package com.islandtechies.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.islandtechies.R;

public class ContentViewHolder {

    public ImageView getIcon() {
        return icon;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDescription() {
        return description;
    }

    private ImageView icon;
    private TextView title;
    private TextView description;

    public ContentViewHolder(View view) {
        icon = (ImageView) view.findViewById(R.id.ivContentIcon);
        title = (TextView) view.findViewById(R.id.tvTitle);
        description = (TextView) view.findViewById(R.id.tvDescription);
    }
}
