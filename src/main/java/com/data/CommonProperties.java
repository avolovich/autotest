package com.data;

import com.data.utils.PropertiesHelper;

import java.io.IOException;

public class CommonProperties {

    private static CommonProperties commonProperties;
    private static final String FOLDER_PATH = "/src/main/resources/";
    private static final String FILE_NAME = "common.properties";
    private static String JRS_URL;

    private CommonProperties() throws IOException {
        PropertiesHelper p = new PropertiesHelper();
        JRS_URL = p.getProperty(FOLDER_PATH+FILE_NAME,"jrs.url");
    }

    public static CommonProperties getCommonProperties() throws IOException {
        if (commonProperties==null) {
            commonProperties = new CommonProperties();
        }
        return commonProperties;
    }

    public String getJrsUrl() {
        return JRS_URL;
    }



}
