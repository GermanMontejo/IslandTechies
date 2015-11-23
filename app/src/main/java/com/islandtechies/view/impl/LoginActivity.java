package com.islandtechies.view.impl;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.islandtechies.R;
import com.islandtechies.presenter.LoginPresenter;
import com.islandtechies.view.iface.ILoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.et_username)
    EditText etUsername;

    @Bind(R.id.et_password)
    EditText etPassword;

    @Bind(R.id.btn_submit)
    Button btnSubmit;

    LoginPresenter presenter;

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
        presenter = new LoginPresenter(this);
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

    @OnClick(R.id.btn_submit)
    void login() {
        Toast.makeText(this, "Login", Toast.LENGTH_LONG).show();
        presenter.login(etUsername.getText().toString(), etPassword.getText().toString());
    }
}
