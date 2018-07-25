package sky.pierry.core.domain;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {

  @SerializedName("id") private String id;
  @SerializedName("backdrops_url") private List<String> backdropsUrl;
  @SerializedName("cover_url") private String coverUrl;
  @SerializedName("release_year") private String releaseYear;
  @SerializedName("duration") private String duration;
  @SerializedName("overview") private String overview;
  @SerializedName("title") private String title;

  public Movie() {
  }

  public Movie(Parcel parcel) {
    id = parcel.readString();
    backdropsUrl = new ArrayList<>();
    parcel.readList(backdropsUrl, String.class.getClassLoader());
    coverUrl = parcel.readString();
    releaseYear = parcel.readString();
    duration = parcel.readString();
    overview = parcel.readString();
    title = parcel.readString();
  }

  public static final Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
    @Override public Movie createFromParcel(Parcel parcel) {
      return new Movie(parcel);
    }

    @Override public Movie[] newArray(int i) {
      return new Movie[i];
    }
  };

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

  public boolean isValid() {
    return title != null && !title.isEmpty();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(id);
    parcel.writeList(backdropsUrl);
    parcel.writeString(coverUrl);
    parcel.writeString(releaseYear);
    parcel.writeString(duration);
    parcel.writeString(overview);
    parcel.writeString(title);
  }
}
