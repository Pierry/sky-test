package sky.pierry.home.presentation.presenter;

import java.util.List;
import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.view.IHomeView;

public interface IHomePresenter {

  void onStart();

  void inject(IHomeView homeView);

  void details(Movie movie);

  void fill(List<Movie> movies);

  void error();

  void error(String message);
}
