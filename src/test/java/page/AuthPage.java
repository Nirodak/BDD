package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;


import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    private static SelenideElement loginSelector = $("[data-test-id='login'] input");
    private static SelenideElement passwordSelector = $("[data-test-id='password'] input");
    private static SelenideElement buttonAuthSelector = $("[data-test-id='action-login']");

    public static void login(DataHelper.AuthInfo authInfo){
        loginSelector.setValue(authInfo.getLogin());
        passwordSelector.setValue(authInfo.getPassword());
        buttonAuthSelector.click();

    }

}
