package com.islandtechies.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islandtechies.R;
import com.squareup.picasso.Picasso;

public class ContentFragment extends Fragment {

    private ImageView ivContentImage;
    private TextView tvTitle;
    private TextView tvContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ivContentImage = (ImageView) view.findViewById(R.id.ivContentImage);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvContent = (TextView) view.findViewById(R.id.tvContent);
        return view;
    }

    public void setViews(String title, String content, String imageUrl) {
        Picasso.with(getActivity())
                .load(imageUrl)
                .fit()
                .into(ivContentImage);
        tvTitle.setText(title);
        tvContent.setText(content);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
