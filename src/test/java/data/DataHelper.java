package data;

import lombok.Value;

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
        private String code;
    }

    @Value
    public static class Cards{
        private String card;
    }
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty");
    }

    public static VerifyCode getVerifyCode(){
        return new VerifyCode("12345");
    }

    public static Cards getFirstCard(){
        return new Cards("5559 0000 0000 0001");
    }
    public static Cards getSecondCard(){
        return new Cards("5559 0000 0000 0002");
    }



}

