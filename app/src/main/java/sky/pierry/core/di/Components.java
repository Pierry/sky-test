package sky.pierry.core.di;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import sky.pierry.home.data.Api;
import sky.pierry.home.presentation.presenter.HomePresenter;
import sky.pierry.home.presentation.view.HomeActivity;

@Singleton @Component(modules = Modules.class) public interface Components {

  Context context();

  void inject(Api api);

  void inject(HomePresenter homePresenter);

  void inject(HomeActivity homeActivity);

}
