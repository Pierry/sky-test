package sky.pierry;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.view.custom.HomeAdapter;

@RunWith(MockitoJUnitRunner.class) public class HomeAdapterTest {

  private HomeAdapter homeAdapter;

  @Before public void setUp() {
    homeAdapter = new HomeAdapter();
  }

  @Test public void testItemsValid() {
    Movie movie = new Movie();
    movie.setTitle("Title");
    List<Movie> items = new ArrayList<>();
    items.add(movie);
    homeAdapter.addItems(items);
    List<Movie> movies = homeAdapter.getItems();
    Assert.assertTrue(movies != null);
  }
}
