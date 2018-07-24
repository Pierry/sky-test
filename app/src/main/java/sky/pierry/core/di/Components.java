package sky.pierry.core.di;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = Modules.class) public interface Components {

  Context context();

}
