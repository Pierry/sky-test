package sky.pierry.home.presentation.view.custom;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import sky.pierry.R;
import sky.pierry.core.domain.Movie;

public class HomeHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.movieTitle) TextView movieTitle;
  @BindView(R.id.cover) ImageView cover;

  public HomeHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void bind(Movie movie) {
    movieTitle.setText(movie.getTitle());
    Picasso.get().load(movie.getCoverUrl()).into(cover);
  }
}
