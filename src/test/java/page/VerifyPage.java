package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerifyPage {

    private static SelenideElement codeVerifySelector = $("[data-test-id='code'] input");
    private static SelenideElement buttonVerifySelector = $("[data-test-id='action-verify']");


    public static void verify(DataHelper.VerifyCode code) {
        codeVerifySelector.setValue(code.getVerifyCode());
        buttonVerifySelector.click();



    }
}
