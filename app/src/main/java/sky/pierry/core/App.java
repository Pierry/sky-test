package sky.pierry.core;

import android.app.Application;
import android.content.Context;
import sky.pierry.BuildConfig;
import sky.pierry.core.di.Components;
import sky.pierry.core.di.DaggerComponents;
import sky.pierry.core.di.Modules;
import timber.log.Timber;

public class App extends Application {

  private Components components;

  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
    components();
  }

  void components() {
    if (components == null) {
      components = DaggerComponents.builder().modules(new Modules(this)).build();
    }
  }

  public static Components getControllerComponent(Context context) {
    return ((App) context.getApplicationContext()).getComponents();
  }

  public Components getComponents() {
    return components;
  }
}
