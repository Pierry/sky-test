package sky.pierry.home.presentation.model;

import android.content.Context;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sky.pierry.core.App;
import sky.pierry.core.data.RetrofitClient;
import sky.pierry.core.domain.Movie;
import sky.pierry.core.support.HttpStatusCode;
import sky.pierry.home.presentation.presenter.HomePresenter;
import sky.pierry.home.presentation.presenter.IHomePresenter;
import timber.log.Timber;

public class HomeModel implements IHomeModel {

  @Inject RetrofitClient api;

  private IHomePresenter homePresenter;

  public HomeModel(Context context) {
    App.getControllerComponent(context).inject(this);
  }

  @Override public void inject(HomePresenter homePresenter) {
    this.homePresenter = homePresenter;
  }

  @Override public void all() {
    api.movies().enqueue(new Callback<List<Movie>>() {
      @Override public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        switch (response.code()) {
          case HttpStatusCode.OK:
            responseOk(response.body());
            break;
          default:
            homePresenter.error();
            break;
        }
      }

      @Override public void onFailure(Call<List<Movie>> call, Throwable t) {
        Timber.e(t);
        homePresenter.error(t.getMessage());
      }
    });
  }

  private void responseOk(List<Movie> movies) {
    if (movies != null) {
      homePresenter.fill(movies);
      return;
    }
    homePresenter.error();
  }
}
