package com.islandtechies.view;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.islandtechies.R;
import com.islandtechies.model.ContentModel;
import com.islandtechies.view.adapter.ContentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private ListView listView;
    private String[] titles;
    private String[] descriptions;
    private ContentAdapter contentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Resources res = getResources();
        titles = res.getStringArray(R.array.titles);
        descriptions = res.getStringArray(R.array.descriptions);

    }

    public void pourDataToListView(List<ContentModel> contentModelList) {
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> contents = new ArrayList<>();

        for (ContentModel contentModel : contentModelList) {
            images.add(contentModel.getImageUrl());
            titles.add(contentModel.getTitle());
            contents.add(contentModel.getContent());
        }

        if (!titles.isEmpty()) {
            contentAdapter = new ContentAdapter(getActivity(), images, titles, contents);
            listView.setAdapter(contentAdapter);
        }
    }
}
