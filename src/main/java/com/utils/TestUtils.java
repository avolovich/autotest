package com.utils;

public class TestUtils {

    public static void explicitWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
