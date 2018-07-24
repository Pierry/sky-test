package sky.pierry.home.presentation.view.custom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import sky.pierry.R;
import sky.pierry.core.domain.Movie;

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {

  private List<Movie> items;

  public void addItems(List<Movie> movies) {
    this.items = movies;
  }

  @NonNull @Override public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_adapter, parent, false);
    return new HomeHolder(itemView);
  }

  @Override public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
    Movie movie = items.get(position);
    holder.bind(movie);
  }

  @Override public int getItemCount() {
    return items != null ? items.size() : 0;
  }
}
