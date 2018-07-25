package sky.pierry.details.view;

import java.util.List;
import sky.pierry.core.presentation.IBaseView;

public interface IDetailsView extends IBaseView {
  void loadTitle(String text);

  void loadOverview(String text);

  void loadDuration(String text);

  void loadYear(String text);

  void loadCover(List<String> backdropsUrl);
}
