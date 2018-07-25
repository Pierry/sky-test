package sky.pierry.details.presenter;

import sky.pierry.core.domain.Movie;
import sky.pierry.details.view.IDetailsView;

public interface IDetailsPresenter {

  void inject(IDetailsView detailsView);

  void load(Movie movie);

}
