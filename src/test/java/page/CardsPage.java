package page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CardsPage {


    public void clickCardDepositButton(String lastNum) {
        SelenideElement cardSelector = $x(".//div[text() = '**** **** **** " + lastNum + "']");
        cardSelector.$("button").click();
    }


    private int cardBalancePars(String text) {
        String cardBalanceTextStart = "баланс: ";
        String cardBalanceTextFinish = " р.";
        val start = text.indexOf(cardBalanceTextStart);
        val finish = text.indexOf(cardBalanceTextFinish);
        val balance = text.substring(start + cardBalanceTextStart.length(), finish);
        return Integer.parseInt(balance);
    }

    public int getCardBalance(String lastNum) {
        String cardBalance = $x(".//div[text() = '**** **** **** " + lastNum + "']").text();
        return cardBalancePars(cardBalance);
    }

}
