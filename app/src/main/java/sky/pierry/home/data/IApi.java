package sky.pierry.home.data;

import java.util.List;
import retrofit2.Call;
import sky.pierry.core.domain.Movie;

public interface IApi {

  Call<List<Movie>> all();
}
