package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CardsPage {

    private static SelenideElement card1ButtonSelector = $x(".//div[text() = '**** **** **** 0001']/button");
    private static SelenideElement card2ButtonSelector = $x(".//div[text() = '**** **** **** 0002']/button");

    public static void card1ClickDeposit (){
        card1ButtonSelector.click();

    }
    public static void card2ClickDeposit (){
        card2ButtonSelector.click();

    }
}
