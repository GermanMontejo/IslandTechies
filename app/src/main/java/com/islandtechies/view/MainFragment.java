package com.islandtechies.view;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.islandtechies.R;
import com.islandtechies.model.ContentModel;
import com.islandtechies.view.adapter.ContentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements ListView.OnItemClickListener{

    private ListView listView;
    private String[] titles;
    private String[] descriptions;
    private ContentAdapter contentAdapter;
    private List<String> listImages;
    private List<String> listTitles;
    private List<String> listContents;


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
        listView.setOnItemClickListener(this);
    }

    public void pourDataToListView(List<ContentModel> contentModelList) {
        listImages = new ArrayList<>();
        listTitles = new ArrayList<>();
        listContents = new ArrayList<>();

        for (ContentModel contentModel : contentModelList) {
            listImages.add(contentModel.getImageUrl());
            listTitles.add(contentModel.getTitle());
            listContents.add(contentModel.getContent());
        }

        if (!listTitles.isEmpty()) {
            contentAdapter = new ContentAdapter(getActivity(), listImages, listTitles, listContents);
            listView.setAdapter(contentAdapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        intent.putExtra("title", listTitles.get(position));
        intent.putExtra("content", listContents.get(position));
        intent.putExtra("imageUrl", listImages.get(position));
        startActivity(intent);
    }
}
