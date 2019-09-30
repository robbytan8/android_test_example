package com.robby.android_test_example;

import com.robby.android_test_example.presenter.MainPresenter;
import com.robby.android_test_example.presenter.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainPresenterTest {

    private MainPresenter mainPresenter;
    @Mock
    MainView mainView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mainView);
    }

    @Test
    public void login1() {
        String email = "";
        String password = "";
        String message = "Invalid username or password";
        mainPresenter.checkEmailAndPassword(email, password);
        Mockito.verify(mainView).updateUI(message);
    }

    @Test
    public void login2() {
        String email = "someone@domain.com";
        String password = "";
        String message = "Invalid username or password";
        mainPresenter.checkEmailAndPassword(email, password);
        Mockito.verify(mainView).updateUI(message);
    }

    @Test
    public void login3() {
        String email = "";
        String password = "123456789";
        String message = "Invalid username or password";
        mainPresenter.checkEmailAndPassword(email, password);
        Mockito.verify(mainView).updateUI(message);
    }

    @Test
    public void login4() {
        String email = "someone@domain.com";
        String password = "123456789";
        String message = "Login success";
        mainPresenter.checkEmailAndPassword(email, password);
        Mockito.verify(mainView).updateUI(message);
    }
}