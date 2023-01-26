package page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CardsPage {
    public static SelenideElement getCardSelector(String lastNum) {
        return $x(".//div[text() = '**** **** **** " + lastNum + "']");
    }

    public static void clickCardDepositButton(String lastNum) {
        var cardSelector = getCardSelector(lastNum);
        cardSelector.$("button").click();
    }


    private static int cardBalancePars(String text) {
        String cardBalanceTextStart = "баланс: ";
        String cardBalanceTextFinish = " р.";
        val start = text.indexOf(cardBalanceTextStart);
        val finish = text.indexOf(cardBalanceTextFinish);
        val balance = text.substring(start + cardBalanceTextStart.length(), finish);
        return Integer.parseInt(balance);
    }

    public static int getCardBalance(String lastNum) {
        val cardText = getCardSelector(lastNum).text();
        return cardBalancePars(cardText);
    }


}
