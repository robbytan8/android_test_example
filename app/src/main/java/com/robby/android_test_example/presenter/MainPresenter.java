package com.robby.android_test_example.presenter;

/**
 * @author Robby Tan
 */
public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void checkEmailAndPassword(String email, String password) {
        if (email.equals("someone@domain.com") && password.equals("123456789")) {
            mainView.updateUI("Login success");
        } else {
            mainView.updateUI("Invalid username or password");
        }
    }
}
