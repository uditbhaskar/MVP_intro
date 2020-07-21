package com.example.mvp_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp_intro.Presenter.LoginPresenter;
import com.example.mvp_intro.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText et_email, et_pwd;
    Button btn_login;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        et_email = findViewById(R.id.et_email);
        et_pwd = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        //Event
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(et_email.getText().toString().trim(), et_pwd.getText().toString().trim());
            }
        });

    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}