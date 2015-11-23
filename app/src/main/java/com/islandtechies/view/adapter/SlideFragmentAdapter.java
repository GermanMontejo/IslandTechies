package com.islandtechies.view.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v13.app.FragmentPagerAdapter;

import com.islandtechies.R;
import com.islandtechies.view.SlideFragment;

import java.util.ArrayList;

public class SlideFragmentAdapter extends FragmentPagerAdapter {

    public static ArrayList<Drawable> images = new ArrayList<>();
    public static String[] contents;
    private Context context;

    public SlideFragmentAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
        Resources resources = context.getResources();
        images.add(resources.getDrawable(R.drawable.apple_monitor));
        images.add(resources.getDrawable(R.drawable.gadget));
        images.add(resources.getDrawable(R.drawable.city));
        contents = resources.getStringArray(R.array.contents);
    }

    @Override
    public Fragment getItem(int position) {
        return SlideFragment.newInstance(position, context);
    }

    @Override
    public int getCount() {
        return images.size();
    }
}
