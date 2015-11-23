package com.islandtechies.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.islandtechies.R;
import com.islandtechies.model.NavData;

import java.util.ArrayList;
import java.util.List;

public class NavDrawerAdapter extends BaseAdapter {

    private List<NavData> navDataList;
    private Context context;

    public NavDrawerAdapter(Context context, int[] icons, String[] labels) {
        this.context = context;
        navDataList = new ArrayList<>();
        for (int i = 0; i < labels.length; i++) {
            navDataList.add(new NavData(icons[i], labels[i]));
        }
    }

    @Override
    public int getCount() {
        return navDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return navDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.nav_row, parent, false);
        }

        NavData navData = navDataList.get(position);

        ImageView navIcon = (ImageView) row.findViewById(R.id.ivNavIcon);
        TextView navLabel = (TextView) row.findViewById(R.id.tvNavIconLabel);
        navIcon.setImageResource(navData.getIcon());
        navLabel.setText(navData.getNavIconLabel());
        return row;
    }
}
