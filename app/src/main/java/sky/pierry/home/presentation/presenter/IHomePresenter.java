package sky.pierry.home.presentation.presenter;

import sky.pierry.home.presentation.view.IHomeView;

public interface IHomePresenter {

  void inject(IHomeView homeView);

  void findAll();
}
