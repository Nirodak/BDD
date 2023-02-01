package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AuthPage;
import page.CardsPage;
import page.DepositPage;
import page.VerifyPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForm {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    public String firstCardNum = "0001";
    public String secondCardNum = "0002";

    public int checkBalanceAmount(String lastNum, int amountDeposit, String type) {
        CardsPage cardsPage = new CardsPage();
        var startBalance = cardsPage.getCardBalance(lastNum);
        if (startBalance >= amountDeposit) {
            if (type == "from")
                return startBalance - amountDeposit;
            else if (type == "to") {
                return startBalance + amountDeposit;
            }
        }
        return startBalance;
    }

    public void login() {
        AuthPage authPage = new AuthPage();
        VerifyPage verifyPage = new VerifyPage();
        authPage.login(DataHelper.getAuthInfo());
        verifyPage.verify(DataHelper.getVerifyCode());
    }


    public void depositFirstCard(int amountDeposit) {
        login();
        CardsPage cardsPage = new CardsPage();
        int checkAmountBalanceTo = checkBalanceAmount(firstCardNum, amountDeposit, "to");
        int checkAmountBalanceFrom = checkBalanceAmount(secondCardNum, amountDeposit, "from");
        cardsPage.clickCardDepositButton(firstCardNum);
        DepositPage depositPage = new DepositPage();
        depositPage.cardDeposit(amountDeposit, DataHelper.getSecondCard());
        int finishBalanceFirstCard = cardsPage.getCardBalance(firstCardNum);
        int finishBalanceSecondCard = cardsPage.getCardBalance(secondCardNum);
        assertEquals(checkAmountBalanceTo, finishBalanceFirstCard);
        assertEquals(checkAmountBalanceFrom, finishBalanceSecondCard);
    }


    @Test
    public void depositFirstCardBalance() {
        depositFirstCard(1000);
    }
    @Test
    public void depositSecondCardBalance(){
        login();
        int amountDeposit = 1000;
        CardsPage cardsPage = new CardsPage();
        int checkAmountBalanceTo = checkBalanceAmount(secondCardNum, amountDeposit, "to");
        int checkAmountBalanceFrom = checkBalanceAmount(firstCardNum, amountDeposit, "from");
        cardsPage.clickCardDepositButton(secondCardNum);
        DepositPage depositPage = new DepositPage();
        depositPage.cardDeposit(amountDeposit, DataHelper.getFirstCard());
        int finishBalanceFirstCard = cardsPage.getCardBalance(firstCardNum);
        int finishBalanceSecondCard = cardsPage.getCardBalance(secondCardNum);
        assertEquals(checkAmountBalanceTo, finishBalanceSecondCard);
        assertEquals(checkAmountBalanceFrom, finishBalanceFirstCard);
    }

    @Test
    public void depositFirstCardOverBalance() {
        depositFirstCard(50000);
    }
    @Test
    public void depositSecondCardOverBalance(){
        login();
        int amountDeposit = 50000;
        CardsPage cardsPage = new CardsPage();
        int checkAmountBalanceTo = checkBalanceAmount(secondCardNum, amountDeposit, "to");
        int checkAmountBalanceFrom = checkBalanceAmount(firstCardNum, amountDeposit, "from");
        cardsPage.clickCardDepositButton(secondCardNum);
        DepositPage depositPage = new DepositPage();
        depositPage.cardDeposit(amountDeposit, DataHelper.getFirstCard());
        int finishBalanceFirstCard = cardsPage.getCardBalance(firstCardNum);
        int finishBalanceSecondCard = cardsPage.getCardBalance(secondCardNum);
        assertEquals(checkAmountBalanceTo, finishBalanceSecondCard);
        assertEquals(checkAmountBalanceFrom, finishBalanceFirstCard);
    }

}
