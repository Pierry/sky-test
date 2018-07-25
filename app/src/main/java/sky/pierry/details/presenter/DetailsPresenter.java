package sky.pierry.details.presenter;

import sky.pierry.core.domain.Movie;
import sky.pierry.details.view.IDetailsView;

public class DetailsPresenter implements IDetailsPresenter {

  private IDetailsView detailsView;

  @Override public void inject(IDetailsView detailsView) {
    this.detailsView = detailsView;
  }

  @Override public void load(Movie movie) {
    detailsView.loadTitle(movie.getTitle());
    detailsView.loadDuration(movie.getDuration());
    detailsView.loadOverview(movie.getOverview());
    detailsView.loadYear(movie.getReleaseYear());
    detailsView.loadCover(movie.getBackdropsUrl());
  }
}
