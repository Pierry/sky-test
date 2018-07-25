package sky.pierry.home.presentation.view.custom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.MaskTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import sky.pierry.R;
import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.presenter.IHomePresenter;

public class HomeHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.movieTitle) TextView movieTitle;
  @BindView(R.id.cover) ImageView cover;

  private Movie movie;

  public HomeHolder(View itemView, IHomePresenter homePresenter) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    cover.setOnClickListener(view -> homePresenter.details(movie));
  }

  public void bind(Movie movie) {
    if (!movie.isValid()){
      return;
    }
    this.movie = movie;
    movieTitle.setText(movie.getTitle());
    Picasso.get().load(movie.getCoverUrl()).transform(new RoundedCornersTransformation(30, 0)).error(R.mipmap.icon_no_item).into(cover);
  }
}
