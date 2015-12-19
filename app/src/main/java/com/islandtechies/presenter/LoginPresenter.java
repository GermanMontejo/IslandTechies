package com.islandtechies.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.islandtechies.model.IRestClient;
import com.islandtechies.model.RestClient;
import com.islandtechies.view.iface.ILoginView;

public class LoginPresenter {

    ILoginView iLoginView;
    Context context;
    String USER_PREF="users_preferences";
    SharedPreferences pref = null;

    public LoginPresenter(ILoginView iLoginView, Context context) {
        this.iLoginView = iLoginView;
        this.context = context;
        pref = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
    }

    public void login(String username, String password) {

        IRestClient restClient = new RestClient(this, context);

        if (username.equals("admin") && password.equals("password")) {
            pref.edit().putBoolean("isLoginSuccess", true).apply();
            iLoginView.showSuccess();

        } else {
            pref.edit().putBoolean("isLoginSuccess", false).apply();
            iLoginView.showError();
        }
    }
}
