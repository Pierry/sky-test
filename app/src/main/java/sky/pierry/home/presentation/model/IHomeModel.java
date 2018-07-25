package sky.pierry.home.presentation.model;

import java.util.List;
import retrofit2.Call;
import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.presenter.HomePresenter;

public interface IHomeModel {

  void all();

  void inject(HomePresenter homePresenter);
}
