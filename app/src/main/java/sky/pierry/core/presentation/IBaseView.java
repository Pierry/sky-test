package sky.pierry.core.presentation;

import sky.pierry.core.domain.Movie;

public interface IBaseView {

  void showLoader();

  void hideLoader();

  void noContent();

  void noInternet();

}
