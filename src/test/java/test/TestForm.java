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


    public void login() {
        AuthPage authPage = new AuthPage();
        VerifyPage verifyPage = new VerifyPage();
        authPage.login(DataHelper.getAuthInfo());
        verifyPage.verify(DataHelper.getVerifyCode());
    }

    public void depositFirstCard(int amountDeposit) {
        login();
        CardsPage cardsPage = new CardsPage();
        DepositPage depositPage = new DepositPage();
        int startBalanceFirstCard = cardsPage.getCardBalance(firstCardNum);
        int startBalanceSecondCard = cardsPage.getCardBalance(secondCardNum);
        cardsPage.clickCardDepositButton(firstCardNum);
        depositPage.cardDeposit(amountDeposit, DataHelper.getSecondCard());
        int finishBalanceFirstCard = cardsPage.getCardBalance(firstCardNum);
        int finishBalanceSecondCard = cardsPage.getCardBalance(secondCardNum);
        assertEquals(startBalanceFirstCard + amountDeposit, finishBalanceFirstCard);
        assertEquals(startBalanceSecondCard - amountDeposit, finishBalanceSecondCard);

    }

    @Test
    public void depositFirstCardBalance() {
        depositFirstCard(1000);
    }

    @Test
    public void depositFirstCardOverBalance() {
        depositFirstCard(50000);
    }
}
