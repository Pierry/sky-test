package sky.pierry.core.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Movie {

  @SerializedName("id") private String id;
  @SerializedName("backdrops_url") private List<String> backdropsUrl;
  @SerializedName("cover_url") private String coverUrl;
  @SerializedName("release_year") private String releaseYear;
  @SerializedName("duration") private String duration;
  @SerializedName("overview") private String overview;
  @SerializedName("title") private String title;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<String> getBackdropsUrl() {
    return backdropsUrl;
  }

  public void setBackdropsUrl(List<String> backdropsUrl) {
    this.backdropsUrl = backdropsUrl;
  }

  public String getCoverUrl() {
    return coverUrl;
  }

  public void setCoverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
  }

  public String getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(String releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
