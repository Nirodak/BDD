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

public class TestForm {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test

    public void testLogin(){
        AuthPage.login(DataHelper.getAuthInfo());
        VerifyPage.verify(DataHelper.getVerifyCode());
        CardsPage.card1ClickDeposit();
        DepositPage.cardDeposit(100, DataHelper.getSecondCard());
        Configuration.holdBrowserOpen=true;
    }
}
