package com.data.utils;

import com.exceptions.propertiesFileAccessException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class FileProperties implements PropertiesProvider {

    @Override
    public HashMap<String, String> getProperties(String source) {
        // Trying to open file
        HashMap<String,String> resultMap = new HashMap<>();
        Properties properties = new Properties();
        try {
            File file = new File(source);
            properties.load(new FileReader(file));

            // putting all the properties inside a hashmap

            for (String name: properties.stringPropertyNames())
                resultMap.put(name, properties.getProperty(name));

        } catch (IOException e) {
            throw new propertiesFileAccessException(source, e);
        }
        return resultMap;
    }
}
