package sky.pierry.home.data;

import com.google.gson.Gson;
import java.util.List;
import retrofit2.Call;
import sky.pierry.core.data.RetrofitClient;
import sky.pierry.core.domain.Movie;

public class Api implements IApi {

  private RetrofitClient api;
  private Gson gson;

  @Override public Call<List<Movie>> all() {
    return api.movies();
  }
}
