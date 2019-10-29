package com;

import com.ui.pages.login.Locale;
import org.testng.Assert;

public class Exceptions extends Exception {
    public Exceptions() {
        super();
    }

    public static void noSuchLocaleException(Locale locale, Throwable cause) {
        System.out.println("No such locale value under Locale combo on Login Page: "+locale.toString()+"; "+cause.getMessage());
    }

}
