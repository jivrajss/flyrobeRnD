package module.custom.jugnig.flyrobernd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomListAdapter extends ArrayAdapter<String> {
    Context context;
    private ArrayList<String> list;
    Holder holder;
    public View view;
    public int currPosition = 0;

    public CustomListAdapter(Context context,ArrayList<String> list) {
        super(context, android.R.layout.simple_list_item_2, list);
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout layout;

        if (convertView == null) {
            layout = (RelativeLayout) View.inflate(context, R.layout.horizontal_scrollview_row, null);
            holder = new Holder();
            holder.title = (TextView) layout.findViewById(R.id.Ameneties_title);
            layout.setTag(holder);

        } else {
            layout = (RelativeLayout) convertView;
            view = layout;
            holder = (Holder) layout.getTag();
        }
        String newsSource = getItem(position);
        holder.title.setText(newsSource);
        return layout;
    }

    private class Holder {
        public TextView title;

    }

    public int getCurrentPosition() {
        return currPosition;
    }
}
