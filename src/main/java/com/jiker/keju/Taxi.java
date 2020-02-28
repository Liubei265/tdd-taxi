package com.jiker.keju;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Taxi {
    private BigDecimal distance;
    private BigDecimal waitingTime;

    public Taxi() {
    }

    public BigDecimal text(String strLine) {
        String[] str = strLine.split(",");
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str[0]);
        this.distance = new BigDecimal(m.replaceAll("").trim());
        m = p.matcher(str[1]);
        this.waitingTime = new BigDecimal(m.replaceAll("").trim());
        return charge(this.distance, this.waitingTime);
    }

    public BigDecimal charge(BigDecimal distance, BigDecimal waitingTime) {
        if (distance.compareTo(Constants.zero) == 1 && distance.compareTo(Constants.firstLap) <= 0) {
            return Constants.baseFees.add(waitingTime.multiply(Constants.minFees)).setScale(0, BigDecimal.ROUND_HALF_UP);
        }
        return chargeLong(distance, waitingTime);
    }

    public BigDecimal chargeLong(BigDecimal distance, BigDecimal waitingTime) {
        if (distance.compareTo(Constants.firstLap) == 1 && distance.compareTo(Constants.secLap) <= 0) {
            BigDecimal pay = ((distance.subtract(Constants.firstLap)).multiply(Constants.firstPrice)).add(Constants.baseFees);
            return pay.add(waitingTime.multiply(Constants.minFees)).setScale(0, BigDecimal.ROUND_HALF_UP);
        }
        BigDecimal overSecondFees = (distance.subtract(Constants.secLap)).multiply(Constants.secondPrice);
        BigDecimal overFees = overSecondFees.add((Constants.secLap.subtract(Constants.firstLap)).multiply(Constants.firstPrice));
        return (overFees.add(Constants.baseFees)).add(waitingTime.multiply(Constants.minFees)).setScale(0, BigDecimal.ROUND_HALF_UP);
    }
}
