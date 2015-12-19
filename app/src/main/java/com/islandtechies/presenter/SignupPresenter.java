package com.islandtechies.presenter;

import android.content.Context;
import android.util.Log;

import com.islandtechies.model.IRestClient;
import com.islandtechies.model.RestClient;
import com.islandtechies.model.UserModel;
import com.islandtechies.view.iface.ISignupFragment;

import java.util.List;

public class SignupPresenter {
    ISignupFragment iSignupFragment;
    Context context;

    public SignupPresenter(ISignupFragment iSignupFragment, Context context) {
        this.iSignupFragment = iSignupFragment;
        this.context = context;
    }

    public void signup(String username, String password, List<String> userRoles, String accountType) {
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setRoles(userRoles);
        userModel.setType(accountType);
        IRestClient restClient = new RestClient(this, context);
        restClient.signup(userModel);
        Log.d("SignupPresenter", "signup()");
    }

    public void invokeSignupSuccess() {
        iSignupFragment.invokeSignupSuccess();
    }

    public void invokeSignupFailure(String reason) {
        iSignupFragment.invokeSignupFailure(reason);
    }
}
