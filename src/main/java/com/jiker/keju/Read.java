package com.jiker.keju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;

public class Read {
    private List<String> info;

    public Read() {

    }

    public void add(String testDataFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(testDataFile)));
            while (null != bufferedReader.readLine()) {
                this.info.add(bufferedReader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String count() {
        Taxi taxi = new Taxi();
        String str1 = null;
        for (String str : info) {
            str1 = str1 + "收费" + taxi.text(str) + "元\\n";
        }
        return str1;
    }
}
