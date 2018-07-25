package sky.pierry.details.view.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import sky.pierry.R;

public class CoverHolder extends RelativeLayout {

  private ImageView imageView;
  private View view;

  public CoverHolder(Context context) {
    super(context);
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    view = inflater.inflate(R.layout.details_adapter, (ViewGroup) null, false);
    instance();
  }

  private void instance() {
    imageView = view.findViewById(R.id.imageView);
  }

  public void bind(String url) {
    Picasso.get().load(url).transform(new RoundedCornersTransformation(30, 0)).error(R.mipmap.icon_no_item).into(imageView);
  }

  public View getView() {
    return view;
  }
}
