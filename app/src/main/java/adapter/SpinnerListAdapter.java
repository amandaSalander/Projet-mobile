package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amanda on 11/04/17.
 */

public class SpinnerListAdapter extends BaseAdapter implements SpinnerAdapter {

    private Context context;
    private List<String> listRegion= new ArrayList<String>();

    public SpinnerListAdapter(Context context, List<String> listRegion) {
        this.context = context;
        this.listRegion = listRegion;
    }

    @Override
    public int getCount() {
        return this.listRegion.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listRegion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView= new TextView(this.context);
        textView.setText(this.listRegion.get(position));

        return textView;
    }
}
