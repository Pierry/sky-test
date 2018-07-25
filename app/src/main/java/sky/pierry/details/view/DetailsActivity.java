package sky.pierry.details.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rd.PageIndicatorView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import sky.pierry.R;
import sky.pierry.core.App;
import sky.pierry.core.domain.Movie;
import sky.pierry.details.presenter.IDetailsPresenter;
import sky.pierry.details.view.custom.CoverHolder;
import sky.pierry.details.view.custom.DetailsAdapter;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DetailsActivity extends AppCompatActivity implements IDetailsView {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.title) TextView title;
  @BindView(R.id.overview) TextView overview;
  @BindView(R.id.duration) TextView duration;
  @BindView(R.id.year) TextView year;
  @BindView(R.id.viewPager) ViewPager viewPager;
  @BindView(R.id.pager) PageIndicatorView pager;

  @Inject IDetailsPresenter detailsPresenter;
  @Inject DetailsAdapter detailsAdapter;

  private Unbinder bind;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    App.getControllerComponent(this).inject(this);
    setContentView(R.layout.details_activity);
    bind = ButterKnife.bind(this);
    actionBar();
  }

  private void actionBar() {
    toolbar.setTitle(getString(R.string.details));
    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
  }

  @Override protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  @Override protected void onStart() {
    super.onStart();
    detailsPresenter.inject(this);
    Movie movie = getIntent().getExtras().getParcelable("movie");
    detailsPresenter.load(movie);
  }

  private void loadViewPager(List<CoverHolder> covers) {
    detailsAdapter.setData(createPageList(covers));
    viewPager.setAdapter(detailsAdapter);
    pager.setViewPager(viewPager);
  }

  private List<View> createPageList(List<CoverHolder> covers) {
    List<View> pageList = new ArrayList<>();
    for (CoverHolder holder : covers) {
      pageList.add(holder.getView());
    }
    return pageList;
  }

  @Override public void showLoader() {
    runOnUiThread(() -> progressBar.setVisibility(View.VISIBLE));
  }

  @Override public void hideLoader() {
    runOnUiThread(() -> progressBar.setVisibility(View.GONE));
  }

  @Override public void noContent() {
    runOnUiThread(() -> Toast.makeText(this, getString(R.string.no_content), Toast.LENGTH_SHORT).show());
  }

  @Override public void noInternet() {
    runOnUiThread(() -> Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show());
  }

  @Override public void loadTitle(String text) {
    runOnUiThread(() -> title.setText(text));
  }

  @Override public void loadOverview(String text) {
    runOnUiThread(() -> overview.setText(text));
  }

  @Override public void loadDuration(String text) {
    runOnUiThread(() -> duration.setText(text));
  }

  @Override public void loadYear(String text) {
    runOnUiThread(() -> year.setText(text));
  }

  @Override public void loadCover(List<String> backdropsUrl) {
    List<CoverHolder> covers = new ArrayList<>();
    for (String url : backdropsUrl) {
      CoverHolder holder = new CoverHolder(this);
      holder.bind(url);
      covers.add(holder);
    }
    loadViewPager(covers);
  }

  @Override protected void onDestroy() {
    bind.unbind();
    super.onDestroy();
  }
}
