package sky.pierry;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import sky.pierry.core.domain.Movie;
import sky.pierry.home.presentation.view.custom.HomeAdapter;

@RunWith(MockitoJUnitRunner.class) public class MovieTest {

  @Test public void testValid() {
    Movie movie = new Movie();
    movie.setTitle("Title");
    boolean isValid = movie.isValid();
    Assert.assertTrue(isValid);
  }

  @Test public void testInvalid() {
    Movie movie = new Movie();
    movie.setId(UUID.randomUUID().toString());
    boolean isValid = movie.isValid();
    Assert.assertFalse(isValid);
  }
}
