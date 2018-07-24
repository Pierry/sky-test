package sky.pierry.core.di;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.lang.reflect.Modifier;

@Module public class Modules {

  private Context context;
  private Gson gson;

  public Modules(Context context) {
    this.context = context;
  }

  @Provides @Reusable public Gson providesGson() {
    return new GsonBuilder().excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC).create();
  }

  @Provides public Context context() {
    return context;
  }
}
