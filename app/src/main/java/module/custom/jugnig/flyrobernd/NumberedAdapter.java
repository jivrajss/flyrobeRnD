package module.custom.jugnig.flyrobernd;

/**
 * Created by JugniG on 05-05-2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NumberedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = NumberedAdapter.class.getSimpleName();
    private ArrayList<String> labels;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final Context mContext;

    public NumberedAdapter(Context context, int count) {
        this.mContext = context;
        labels = new ArrayList<String>(count);
        for (int i = 0; i < count; ++i) {
            labels.add(Integer.toString(i));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new TextViewHolder(view);
        } else if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header, parent, false);
            return new HeaderHolder(view);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final String label = labels.get(position);
        if (position == 0) {
            HeaderHolder mHeaderHolder = (HeaderHolder) holder;
            mHeaderHolder.horizontalScrollview.setAdapter(mContext, new CustomListAdapter(mContext, labels));
        } else {
            TextViewHolder mViewHolder = (TextViewHolder) holder;
            mViewHolder.textView.setText(label);
        }
//        Log.d(TAG, "into bind ViewHolder---" + position+holder.horizontalScrollview.getText().toString()+"--visibility--"+(holder.horizontalScrollview.getVisibility()==View.VISIBLE));
//        holder.horizontalScrollview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(
//                        holder.horizontalScrollview.getContext(), label, Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.horizontalScrollview.setText("item--" + position);
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private String getItem(int position) {
        return labels.get(position - 1);
    }
}
