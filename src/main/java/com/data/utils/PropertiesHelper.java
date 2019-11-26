package com.data.utils;

import com.exceptions.propertiesFileAccessException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    public String getProperty(String key) {
        return null;
    }

    public String getProperty(String path, String key) throws IOException {
        StringBuilder s = new StringBuilder();
        s.append(System.getProperty("user.dir"));
        s.append(path);
        String fullPath = s.toString();

        // Trying to open file
        try {
            File file = new File(fullPath);
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            String value = properties.getProperty(key);
            return value;
        } catch (IOException e) {
            throw new propertiesFileAccessException(fullPath, e);
        }
    }

    public void setProperty(String key) {

    }

}
