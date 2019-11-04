package com.utils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class CsvReader {

    private static final String relativePath = "resources";
    private static final String delimiter = ",";
    private String filename;
    private FileReader fileReader;

    public CsvReader(String filename) throws IOException {
        String filePath = relativePath+"/"+filename;
        try {
            this.fileReader = new FileReader(filePath);
            this.filename = filename;
        } catch (FileNotFoundException e){
            System.out.println();
            e.printStackTrace();
        }
    }

    public String[][] GetData(String ...params) throws IOException {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(delimiter);
                if (credentials.length==params.length) {

                }
                else throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }
}
