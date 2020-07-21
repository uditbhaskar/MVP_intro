package com.example.mvp_intro.Presenter;

import com.example.mvp_intro.Model.User;
import com.example.mvp_intro.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        boolean isLoginSuccess = user.isDataCorrect();

        if(isLoginSuccess)
            loginView.onLoginResult("Login done my boy.");
        else
            loginView.onLoginResult("Something fishy occurred!!!");
    }
}
