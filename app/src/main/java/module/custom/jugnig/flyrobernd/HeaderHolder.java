package module.custom.jugnig.flyrobernd;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by JugniG on 05-05-2016.
 */

public class HeaderHolder extends RecyclerView.ViewHolder {
    public CenterLockHorizontalScrollview horizontalScrollview;

    public HeaderHolder(View itemView) {
        super(itemView);
        horizontalScrollview = (CenterLockHorizontalScrollview) itemView.findViewById(R.id.horizontalScrollView);
    }
}