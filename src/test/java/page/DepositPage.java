package page;



import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import javax.xml.crypto.Data;

import static com.codeborne.selenide.Selenide.$;

public class DepositPage {

    private static SelenideElement amountSelector = $("[data-test-id='amount'] input");

    private static SelenideElement cardFromSelector = $("[data-test-id='from'] input");

    private static SelenideElement buttonDepositSelector = $("[data-test-id='action-transfer']");

    public static void cardDeposit(int amount, DataHelper.Cards cardFrom) {
        amountSelector.setValue(String.valueOf(amount));
        cardFromSelector.setValue(String.valueOf(cardFrom));
        buttonDepositSelector.click();

    }
}
