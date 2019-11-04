package com.exceptions;

import com.ui.pages.login.Locale;
import org.testng.Assert;

public class noSuchLocaleException extends Exception {
    public noSuchLocaleException(Locale locale, Throwable cause) {
        super("No such locale value under Locale combo on Login Page: "+locale.toString()+"; "+cause.getMessage());
        System.out.println("No such locale value under Locale combo on Login Page: "+locale.toString()+"; "+cause.getMessage());
    }

}
