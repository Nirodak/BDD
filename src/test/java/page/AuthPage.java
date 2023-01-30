package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;


import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    private SelenideElement loginSelector = $("[data-test-id='login'] input");
    private SelenideElement passwordSelector = $("[data-test-id='password'] input");
    private SelenideElement buttonAuthSelector = $("[data-test-id='action-login']");

    public void login(DataHelper.AuthInfo authInfo) {
        loginSelector.setValue(authInfo.getLogin());
        passwordSelector.setValue(authInfo.getPassword());
        buttonAuthSelector.click();

    }

}
