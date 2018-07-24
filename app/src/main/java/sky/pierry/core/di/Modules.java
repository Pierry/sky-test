package sky.pierry.core.di;

import android.content.Context;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import sky.pierry.core.data.RetrofitClient;
import sky.pierry.home.data.Api;
import sky.pierry.home.data.IApi;
import sky.pierry.home.presentation.presenter.HomePresenter;
import sky.pierry.home.presentation.presenter.IHomePresenter;
import sky.pierry.home.presentation.view.custom.HomeAdapter;

@Module public class Modules {

  private Context context;
  private Gson gson;

  public Modules(Context context) {
    this.context = context;
  }

  @Provides @Singleton public RetrofitClient providesRetrofit() {
    return RetrofitClient.retrofit.create(RetrofitClient.class);
  }

  @Provides @Singleton public IApi providesApi(){
    return new Api(context);
  }

  @Provides @Singleton public IHomePresenter providesHomePresenter(){
    return new HomePresenter(context);
  }

  @Provides @Singleton public HomeAdapter providesHomeAdapter(){
    return new HomeAdapter();
  }

  @Provides public Context context() {
    return context;
  }
}
