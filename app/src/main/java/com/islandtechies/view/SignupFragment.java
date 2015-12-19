package com.islandtechies.view;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.islandtechies.R;
import com.islandtechies.presenter.SignupPresenter;
import com.islandtechies.view.iface.ISignupFragment;

import java.util.ArrayList;
import java.util.List;

public class SignupFragment extends Fragment implements View.OnClickListener, ISignupFragment{

    EditText etUsername;
    EditText etPassword;
    EditText etFullname;
    EditText etEmail;
    Button btnSubmit;
    TextView tvBackToLogin;
    FragmentCommunicator fragmentCommunicator;
    SignupPresenter signupPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        etUsername = (EditText) view.findViewById(R.id.et_username);
        etPassword = (EditText) view.findViewById(R.id.et_password);
        etFullname = (EditText) view.findViewById(R.id.et_full_name);
        etEmail = (EditText) view.findViewById(R.id.et_email);
        btnSubmit = (Button) view.findViewById(R.id.btn_submit);
        tvBackToLogin = (TextView) view.findViewById(R.id.tv_back_to_login);
        tvBackToLogin.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        signupPresenter = new SignupPresenter(this, getActivity());
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tv_back_to_login:
                fragmentCommunicator.showLoginFragment();
                break;
            case R.id.btn_submit:
                List<String> userRoles = new ArrayList<>();
                userRoles.add("api");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String accountType = "user";
                signup(username, password, userRoles, accountType);
                break;
        }
    }

    public void signup(String username, String password, List<String> userRoles, String accountType) {
        Log.d("SignupFragment", "signup()");
        signupPresenter.signup(username, password, userRoles, accountType);
    }

    @Override
    public void invokeSignupSuccess() {
        Toast.makeText(getActivity(), "Signup success!", Toast.LENGTH_LONG).show();
        fragmentCommunicator.showLoginFragment();
    }

    @Override
    public void invokeSignupFailure(String reason) {
        Toast.makeText(getActivity(), "Signup failed: " + reason, Toast.LENGTH_LONG).show();
        clearFields();
    }

    public void clearFields() {
        etFullname.setText("");
        etFullname.setHint("Full name");
        etUsername.setText("");
        etUsername.setHint("Username");
        etEmail.setText("");
        etEmail.setHint("Email");
        etPassword.setText("");
        etPassword.setHint("Password");
        etUsername.requestFocus();
    }

    public interface FragmentCommunicator {
        void showLoginFragment();
    }

    public void setFragmentCommunicator(FragmentCommunicator fragmentCommunicator) {
        this.fragmentCommunicator = fragmentCommunicator;
    }
}
