package com.islandtechies.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.islandtechies.R;
import com.islandtechies.model.NewsList;
import com.islandtechies.utils.ContentViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends BaseAdapter {

    private Context context;
    private ContentViewHolder viewHolder;
    private List<NewsList> contentDataList;

    public ContentAdapter(Context context, List<String> images, List<String> titles, List<String> descriptions) {
        this.context = context;
        contentDataList = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            contentDataList.add(new NewsList(images.get(i), titles.get(i), descriptions.get(i).substring(0, 80) + "..."));
        }
    }

    @Override
    public int getCount() {
        return contentDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return contentDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.adapter_row, parent, false);
            viewHolder = new ContentViewHolder(row);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ContentViewHolder) row.getTag();
        }

        NewsList news = contentDataList.get(position);
        Picasso.with(context)
                .load(news.getImageUrl())
                .resize(256, 256)
                .centerCrop()
                .placeholder()
                .into(viewHolder.getIcon());
        viewHolder.getTitle().setText(news.getTitle());
        viewHolder.getDescription().setText(news.getContent());

        return row;
    }
}
