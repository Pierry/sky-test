package sky.pierry.home.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.List;
import javax.inject.Inject;
import sky.pierry.R;
import sky.pierry.core.App;
import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.presenter.IHomePresenter;
import sky.pierry.home.presentation.view.custom.HomeAdapter;

public class HomeActivity extends AppCompatActivity implements IHomeView {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.recyclerView) RecyclerView recyclerView;
  @BindView(R.id.progressBar) ProgressBar progressBar;

  @Inject IHomePresenter presenter;
  @Inject HomeAdapter homeAdapter;

  private Unbinder bind;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    App.getControllerComponent(this).inject(this);
    setContentView(R.layout.home_activity);
    bind = ButterKnife.bind(this);
    actionBar();
  }

  private void actionBar() {
    toolbar.setTitle(getString(R.string.app_name));
    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
  }

  @Override protected void onStart() {
    super.onStart();
    config();
    adapter();
    presenter.inject(this);
    presenter.findAll();
  }

  private void config() {
    LinearLayoutManager linearManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
  }

  private void adapter() {
    progressBar.setVisibility(View.GONE);
    recyclerView.setAdapter(homeAdapter);
  }

  @Override public void load(List<Movie> body) {
    homeAdapter.addItems(body);
    runOnUiThread(() -> homeAdapter.notifyDataSetChanged());
  }

  @Override public void showLoader() {
    runOnUiThread(() -> progressBar.setVisibility(View.VISIBLE));
  }

  @Override public void hideLoader() {
    runOnUiThread(() -> progressBar.setVisibility(View.GONE));
  }

  @Override public void noContent() {
    hideLoader();
    runOnUiThread(() -> Toast.makeText(this, getString(R.string.no_content), Toast.LENGTH_SHORT).show());
  }

  @Override public void noInternet() {
    hideLoader();
    runOnUiThread(() -> Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show());
  }

  @Override protected void onDestroy() {
    bind.unbind();
    super.onDestroy();
  }
}
