package com.islandtechies.view;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.islandtechies.R;

public class ContentActivity extends AppCompatActivity {

    private ContentFragment contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        FragmentManager manager = getFragmentManager();
        contentFragment = (ContentFragment) manager.findFragmentById(R.id.fragmentContent);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String content = bundle.getString("content");
        String imageUrl = bundle.getString("imageUrl");
        ImageView image = new ImageView(this);

        contentFragment.setViews(title, content, imageUrl);
    }
}
