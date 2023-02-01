package data;

import lombok.Value;
import page.CardsPage;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;

    }

    @Value
    public static class VerifyCode {
        private String verifyCode;
    }

    @Value
    public static class Cards {
        private String card;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static VerifyCode getVerifyCode() {
        return new VerifyCode("12345");
    }

    public static Cards getFirstCard() {
        return new Cards("5559 0000 0000 0001");
    }

    public static Cards getSecondCard() {
        return new Cards("5559 0000 0000 0002");
    }



}

