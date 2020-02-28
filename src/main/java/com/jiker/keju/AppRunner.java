package com.jiker.keju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        String receipt = "";
        Read read = new Read();
        read.add("src/main/resources/" + testDataFile);
        receipt = read.count();
        System.out.println(receipt);
    }

}
