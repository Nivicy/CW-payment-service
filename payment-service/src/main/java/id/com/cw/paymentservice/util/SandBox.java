package id.com.cw.paymentservice.util;

import id.com.cw.paymentservice.model.dto.DataList;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Log4j2
public class SandBox {
    public static void main(String[] args) throws Exception {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss:sssTZD");
//        System.out.println(simpleDateFormat.format(Timestamp.valueOf(LocalDateTime.now())));
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            System.out.println("Price : " + price);
            buy = Math.max(buy, sell - price);
            System.out.println("Buy : " + buy);
            sell = Math.max(sell, buy + price - fee);
            System.out.println("Sell : " + sell);
        }

}

    @SneakyThrows
    public static void createExcel(List<DataList> dataLists) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
        for (int i = 0; i < 9; i++) {
            sheet.autoSizeColumn(i);
        }

        //This data needs to be written (Object[])
        Map<String, DataList> data = new TreeMap<String, DataList>();
        for (DataList dataList : dataLists
        ) {
            data.put(UUID.randomUUID().toString(), dataList);
        }

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            DataList objArr = data.get(key);
            int cellnum = 0;

            Cell cell0 = row.createCell(cellnum++);
            cell0.setCellValue((String) objArr.getVar0());
            row.createCell(cellnum);

            Cell cell1 = row.createCell(cellnum++);
            cell1.setCellValue((String) objArr.getVar1());
            row.createCell(cellnum);

            Cell cell2 = row.createCell(cellnum++);
            cell2.setCellValue((String) objArr.getVar2());
            row.createCell(cellnum);

            Cell cell3 = row.createCell(cellnum++);
            cell3.setCellValue((String) objArr.getVar3());
            row.createCell(cellnum);

            Cell cell4 = row.createCell(cellnum++);
            cell4.setCellValue((String) objArr.getVar4());
            row.createCell(cellnum);

            Cell cell5 = row.createCell(cellnum++);
            cell5.setCellValue((String) objArr.getVar5());
            row.createCell(cellnum);

            Cell cell6 = row.createCell(cellnum++);
            cell6.setCellValue((String) objArr.getVar6());
            row.createCell(cellnum);

            Cell cell7 = row.createCell(cellnum++);
            cell7.setCellValue((String) objArr.getVar7());
            row.createCell(cellnum);

            Cell cell8 = row.createCell(cellnum++);
            cell8.setCellValue((String) objArr.getVar8());
            row.createCell(cellnum);

            Cell cell9 = row.createCell(cellnum++);
            cell9.setCellValue((String) objArr.getVar9());
            row.createCell(cellnum);

        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<UUID> generateRandomUUID(int count) {
        // Create a list to store the UUIDs
        List<UUID> uuidList = new ArrayList<>();

        // Generate random UUIDs and add them to the list
        for (int i = 0; i < count; i++) {
            UUID uuid = UUID.randomUUID();
            uuidList.add(uuid);
        }

        return uuidList;
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
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean areEqualByThreeDecimalPlaces(double x, double y) {
        double xThousand = x * 1000;
        double yThousand = y * 1000;

        int xint = (int) xThousand;
        int yint = (int) yThousand;

        if (xint == yint) {
            return true;
        }
        return false;
    }

    public static boolean hasEqualSum(int x, int y, int z) {
        return x + y == z;
    }

    public static boolean hasTeen(int x, int y, int z) {
        if ((x >= 13 && x <= 19) || (y >= 13 && y <= 19) || (z >= 13 && z <= 19)) {
            return true;
        }
        return false;
    }

    public static boolean isTeen(int x) {
        if (x >= 13 && x <= 19) {
            return true;
        }
        return false;
    }

}
