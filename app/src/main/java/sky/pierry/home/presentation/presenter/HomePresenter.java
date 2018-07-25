package sky.pierry.home.presentation.presenter;

import android.content.Context;
import java.util.List;
import javax.inject.Inject;
import sky.pierry.core.App;
import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.model.IHomeModel;
import sky.pierry.home.presentation.view.IHomeView;

public class HomePresenter implements IHomePresenter {

  @Inject IHomeModel homeModel;

  private IHomeView homeView;

  public HomePresenter(Context context) {
    App.getControllerComponent(context).inject(this);
  }

  @Override public void onStart() {
    if (!homeView.isConnected()){
      homeView.noInternet();
      return;
    }
    homeModel.inject(this);
    homeModel.all();
  }

  @Override public void inject(IHomeView homeView) {
    this.homeView = homeView;
  }

  @Override public void details(Movie movie) {
    homeView.goToDetails(movie);
  }

  @Override public void fill(List<Movie> movies){
    homeView.load(movies);
  }

  @Override public void error() {
    homeView.noContent();
  }

  @Override public void error(String message) {
    homeView.error(message);
  }
}
