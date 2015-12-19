package com.islandtechies.view.impl;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.islandtechies.R;
import com.islandtechies.presenter.LoginPresenter;
import com.islandtechies.view.LoginFragment;
import com.islandtechies.view.SignupFragment;
import com.islandtechies.view.iface.ILoginView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ILoginView, LoginFragment.FragmentCommunicator, SignupFragment.FragmentCommunicator {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    LoginPresenter loginPresenter;

    FragmentManager manager;
    LoginFragment loginFragment;
    SignupFragment signupFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        toolbar.setTitle(R.string.app_name);
        loginPresenter = new LoginPresenter(this, getBaseContext());

        loginFragment = new LoginFragment();
        signupFragment = new SignupFragment();

        manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.login_fragment_container, loginFragment, "loginFragment").commit();
        loginFragment.setFragmentCommunicator(this);
        signupFragment.setFragmentCommunicator(this);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Invalid username and/or password.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void login(String username, String password) {
        loginPresenter.login(username, password);
    }

    @Override
    public void showSignupFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.login_fragment_container, signupFragment).commit();
    }

    @Override
    public void showLoginFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.login_fragment_container, loginFragment).commit();
    }
}
