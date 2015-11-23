package com.islandtechies.view.impl;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.islandtechies.R;
import com.islandtechies.model.ContentModel;
import com.islandtechies.model.ListContentModels;
import com.islandtechies.presenter.ContentPresenter;
import com.islandtechies.view.MainFragment;
import com.islandtechies.view.adapter.NavDrawerAdapter;
import com.islandtechies.view.iface.IMainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener, IMainView {

    @Bind(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.lv_nav_drawer)
    ListView navDrawer;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle toggle;
    private int[] navIcons = new int[]{R.drawable.cottage, R.drawable.message, R.drawable.user, R.drawable.calendar};
    private String[] navLabels;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        setSupportActionBar(toolbar);
        navLabels = getResources().getStringArray(R.array.drawer_icon_labels);

        navDrawer.setAdapter(new NavDrawerAdapter(this, navIcons, navLabels));
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(toggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.fragment_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.action_settings:
                break;
            case R.id.action_refresh:
                ContentPresenter contentPresenter = new ContentPresenter(this);
                contentPresenter.loadContent(getBaseContext());
                break;
        }

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.toolbar)
    void onClickToolbar() {
        Toast.makeText(getBaseContext(), "Toolbar logo clicked!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (view.getId()) {
            case R.id.lv_nav_drawer:
                break;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void loadContentsOnUi(ListContentModels listContentModels) {
        List<ContentModel> contentModelList = new ArrayList<>();
        if (listContentModels != null) {
            contentModelList = listContentModels.getContentModelList();
        }
        mainFragment.pourDataToListView(contentModelList);
    }
}
