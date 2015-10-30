package com.islandtechies.view;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islandtechies.R;
import com.islandtechies.adapter.SlideFragmentAdapter;

public class ContentFragment extends Fragment {

    private static String MY_PREF = "preferences";

    public static ContentFragment newInstance(int position, Context context) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        SharedPreferences preferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        if (preferences.getBoolean("endedSlide", false)) {
            args.putInt("position", 0);
            preferences.edit().putBoolean("endedSlide", false).commit();
        } else {
            args.putInt("position", position);
        }
        contentFragment.setArguments(args);
        return contentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = getArguments().getInt("position", 0);
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.fragment_slide_image);
        imageView.setImageDrawable(SlideFragmentAdapter.images.get(position));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        TextView textView = (TextView) view.findViewById(R.id.fragment_slide_text);
        try {
            textView.setText(SlideFragmentAdapter.contents[position]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            textView.setText(SlideFragmentAdapter.contents[2]);
        }

        return view;
    }
}
