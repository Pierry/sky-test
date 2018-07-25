package sky.pierry.home.presentation.presenter;

import android.content.Context;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sky.pierry.core.App;
import sky.pierry.core.domain.Movie;
import sky.pierry.core.support.HttpStatusCode;
import sky.pierry.home.data.IApi;
import sky.pierry.home.presentation.view.IHomeView;
import timber.log.Timber;

public class HomePresenter implements IHomePresenter {

  @Inject IApi api;

  private IHomeView homeView;

  public HomePresenter(Context context) {
    App.getControllerComponent(context).inject(this);
  }

  @Override public void inject(IHomeView homeView) {
    this.homeView = homeView;
  }

  @Override public void findAll() {
    api.all().enqueue(new Callback<List<Movie>>() {
      @Override public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        switch (response.code()) {
          case HttpStatusCode.OK:
            homeView.load(response.body());
            break;
        }
      }

      @Override public void onFailure(Call<List<Movie>> call, Throwable t) {
        Timber.e(t);
      }
    });
  }

  @Override public void details(Movie movie) {
    homeView.goToDetails(movie);
  }
}
