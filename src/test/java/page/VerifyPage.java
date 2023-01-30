package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerifyPage {

    private SelenideElement codeVerifySelector = $("[data-test-id='code'] input");
    private SelenideElement buttonVerifySelector = $("[data-test-id='action-verify']");


    public void verify(DataHelper.VerifyCode code) {
        codeVerifySelector.setValue(code.getVerifyCode());
        buttonVerifySelector.click();

    }
}
