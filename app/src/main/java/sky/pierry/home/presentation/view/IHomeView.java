package sky.pierry.home.presentation.view;

import java.util.List;
import sky.pierry.core.domain.Movie;
import sky.pierry.core.presentation.IBaseView;

public interface IHomeView extends IBaseView{

  void load(List<Movie> body);

  void goToDetails(Movie movie);
}
