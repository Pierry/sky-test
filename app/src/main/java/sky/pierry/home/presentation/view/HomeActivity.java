package sky.pierry.home.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import sky.pierry.R;

public class HomeActivity extends AppCompatActivity implements IHomeView {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home_activity);
  }
}
