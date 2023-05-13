package id.com.cw.paymentservice.util;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Objects;

@Log4j2
public class SandBox {
    public static void main(String[] args) throws Exception {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss:sssTZD");
//        System.out.println(simpleDateFormat.format(Timestamp.valueOf(LocalDateTime.now())));

        String merdeka = null;
        System.out.println(Objects.requireNonNullElse(merdeka, "aaa"));
    }

    public static class Handuk {
        private String kain;
    }

    public static void hitungHarga(Handuk handuk){
        System.out.println(handuk + "?");
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        return kilometersPerHour > 0 ? Math.round(kilometersPerHour) : -1;
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(toMilesPerHour(kilometersPerHour) + " km/h = " + kilometersPerHour / 1609 + " mi/h");
        }
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes >= 0) {
            System.out.println(kiloBytes + " KB = " + Math.round(kiloBytes / 1024) + " MB and " + kiloBytes % 1024 + " KB");
        } else {
            System.out.println("Invalid Value");
        }
    }

    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }
        if (isBarking && (hourOfDay < 8 || hourOfDay > 22)) {
            return true;
        }
        return false;
    }

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        return true;
                    }
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean areEqualByThreeDecimalPlaces(double x, double y){
        double xThousand = x*1000;
        double yThousand = y*1000;

        int xint = (int)xThousand;
        int yint = (int)yThousand;

        if (xint == yint){
            return true;
        }
        return false;
    }

    public static boolean hasEqualSum(int x, int y, int z){
        return x + y == z;
    }

    public static boolean hasTeen(int x, int y, int z){
        if ((x >= 13 && x<=19) || (y >= 13 && y<=19) || (z >= 13 && z<=19)){
            return true;
        }
        return false;
    }

    public static boolean isTeen(int x){
        if (x >= 13 && x<=19){
            return true;
        }
        return false;
    }


}
