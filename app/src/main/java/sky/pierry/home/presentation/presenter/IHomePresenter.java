package sky.pierry.home.presentation.presenter;

import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.view.IHomeView;

public interface IHomePresenter {

  void inject(IHomeView homeView);

  void findAll();

  void details(Movie movie);
}
