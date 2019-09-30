package com.robby.android_test_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.robby.android_test_example.presenter.MainPresenter;
import com.robby.android_test_example.presenter.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Robby Tan
 */
public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.et_email)
    EditText txtEmail;
    @BindView(R.id.et_password)
    EditText txtPassword;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
    }

    @OnClick
    public void loginAction() {
        mainPresenter.checkEmailAndPassword(txtEmail.getText().toString(),
                txtPassword.getText().toString());
    }

    @Override
    public void updateUI(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
