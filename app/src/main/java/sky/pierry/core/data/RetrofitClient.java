package sky.pierry.core.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import sky.pierry.core.domain.Movie;

public interface RetrofitClient {

  GsonBuilder builder = new GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
  Gson gson = builder.create();

  Retrofit retrofit = new Retrofit.Builder().baseUrl(Config.URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

  @GET(Config.MOVIES) Call<List<Movie>> movies();
}
