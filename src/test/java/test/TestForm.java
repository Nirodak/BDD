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

    @Test
    public void testLogin() {
        AuthPage.login(DataHelper.getAuthInfo());
        VerifyPage.verify(DataHelper.getVerifyCode());
    }

    @Test
    public void testDepositFirstCard() {
        int amountDeposit = 1000;
        testLogin();
        int startBalanceFirstCard = CardsPage.getCardBalance("0001");
        int startBalanceSecondCard = CardsPage.getCardBalance("0002");
        CardsPage.clickCardDepositButton("0001");
        DepositPage.cardDeposit(amountDeposit, DataHelper.getSecondCard());
        boolean checkBalanceLess = CardsPage.checkLess("0002");
        int finishBalanceFirstCard = CardsPage.getCardBalance("0001");
        int finishBalanceSecondCard = CardsPage.getCardBalance("0002");
        assertEquals(true, checkBalanceLess);
        assertEquals(startBalanceFirstCard + amountDeposit, finishBalanceFirstCard);
        assertEquals(startBalanceSecondCard - amountDeposit, finishBalanceSecondCard);


    }

    @Test
    public void testDepositFirstCardOverLimit() {
        int amountDeposit = 20000;
        testLogin();

        int startBalanceFirstCard = CardsPage.getCardBalance("0001");
        int startBalanceSecondCard = CardsPage.getCardBalance("0002");
        CardsPage.clickCardDepositButton("0001");
        DepositPage.cardDeposit(amountDeposit, DataHelper.getSecondCard());
        boolean checkBalanceLess = CardsPage.checkLess("0002");
        int finishBalanceFirstCard = CardsPage.getCardBalance("0001");
        int finishBalanceSecondCard = CardsPage.getCardBalance("0002");
        assertEquals(true, checkBalanceLess);
        assertEquals(startBalanceFirstCard + amountDeposit, finishBalanceFirstCard);
        assertEquals(startBalanceSecondCard - amountDeposit, finishBalanceSecondCard);


    }
}
