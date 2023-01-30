package page;


import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selenide.$;

public class DepositPage {

    private SelenideElement amountSelector = $("[data-test-id='amount'] input");

    private SelenideElement cardFromSelector = $("[data-test-id='from'] input");

    private SelenideElement buttonDepositSelector = $("[data-test-id='action-transfer']");

    public void cardDeposit(int amount, DataHelper.Cards cardFrom) {
        amountSelector.setValue(String.valueOf(amount));
        cardFromSelector.setValue(String.valueOf(cardFrom));
        buttonDepositSelector.click();

    }
}
