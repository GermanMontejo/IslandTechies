package com.islandtechies.presenter;

import android.content.Context;

import com.islandtechies.model.IRestClient;
import com.islandtechies.model.ListContentModels;
import com.islandtechies.model.RestClient;
import com.islandtechies.view.iface.IMainView;

public class ContentPresenter {

    private IMainView mainView;

    public ContentPresenter(IMainView mainView) {
        this.mainView = mainView;
    }

    public void loadContent(Context context) {
        IRestClient iRestClient = new RestClient(this, context);
        iRestClient.loadContents();
    }

    public void invokePresenterToDisplayContents(ListContentModels listContentModels) {
        mainView.loadContentsOnUi(listContentModels);
    }
}
