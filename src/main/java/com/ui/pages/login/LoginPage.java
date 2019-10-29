package com.ui.pages.login;

public class LoginPage {
    private LoginActController act;
    private LoginVerifyController verify;

    public LoginActController act() {return act;}
    public LoginVerifyController verify() {return verify;}

    private LoginPage(LoginActController act, LoginVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static LoginPage getLoginPage() {
        return new LoginPage(new LoginActController(), new LoginVerifyController());
    }
}
