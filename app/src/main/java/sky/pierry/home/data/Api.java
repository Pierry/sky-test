package sky.pierry.home.data;

import android.content.Context;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import sky.pierry.core.App;
import sky.pierry.core.data.RetrofitClient;
import sky.pierry.core.domain.Movie;

public class Api implements IApi {

  @Inject RetrofitClient api;

  public Api(Context context) {
    App.getControllerComponent(context).inject(this);
  }

  @Override public Call<List<Movie>> all() {
    return api.movies();
  }
}
