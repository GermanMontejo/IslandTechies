package com.islandtechies.presenter;

import com.islandtechies.view.iface.ILoginView;

public class LoginPresenter {

    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    public void login(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            iLoginView.showSuccess();
        } else {
            iLoginView.showError();
        }
    }
}
