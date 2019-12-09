package com.data.settings;

import com.utils.FileProperties;

import java.util.HashMap;

public class CommonProperties {

    private static CommonProperties commonProperties;
    private static final String FOLDER_PATH = "/src/main/resources/";
    private static final String FILE_NAME = "common.properties";
    private static HashMap<String,String> allProperties = new HashMap<>();

    private static final String JRS_URL_KEY = "jrs.url";
    private static final String DEFAULT_BROWSER_KEY = "default.browser";

    private static String absolutePath;
    private static String JRS_URL;
    private static String defaultBrowser;


    private CommonProperties() {
       setDataFromFile();
    }

    public static CommonProperties getInstance()  {
        if (commonProperties==null) {
            commonProperties = new CommonProperties();
        }
        return commonProperties;
    }

    private void setDataFromFile() {
        FileProperties commonProperties = new FileProperties();
        absolutePath = System.getProperty("user.dir")+FOLDER_PATH+FILE_NAME;
        allProperties = commonProperties.getProperties(absolutePath);
        JRS_URL = allProperties.get(JRS_URL_KEY);
        defaultBrowser = allProperties.get(DEFAULT_BROWSER_KEY);
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public String getJrsUrl() {
        return JRS_URL;
    }

    public String getDefaultWebDriver() {
        return defaultBrowser;
    }

}
