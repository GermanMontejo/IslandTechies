package com.islandtechies.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.islandtechies.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    Button btnSubmit;
    TextView tvSignup;
    CheckBox cbRememberPassword;
    FragmentCommunicator fragmentCommunicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = (EditText) view.findViewById(R.id.et_username);
        etPassword = (EditText) view.findViewById(R.id.et_password);
        btnSubmit = (Button) view.findViewById(R.id.btn_submit);
        tvSignup = (TextView) view.findViewById(R.id.tv_signup);
        cbRememberPassword = (CheckBox) view.findViewById(R.id.cbox_remember);

        btnSubmit.setOnClickListener(this);
        tvSignup.setOnClickListener(this);
        cbRememberPassword.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void setFragmentCommunicator(FragmentCommunicator fragmentCommunicator) {
        this.fragmentCommunicator = fragmentCommunicator;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_submit:
                fragmentCommunicator.login(etUsername.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.tv_signup:
                fragmentCommunicator.showSignupFragment();
                break;
            case R.id.cbox_remember:
                break;
        }
    }

    public interface FragmentCommunicator {
        void login(String username, String password);
        void showSignupFragment();
    }
}
