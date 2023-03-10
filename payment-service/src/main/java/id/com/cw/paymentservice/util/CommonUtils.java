package id.com.cw.paymentservice.util;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonUtils {

    private BasicTextEncryptor encryptor;

    public CommonUtils(@Qualifier("jasyptStringEncryptor") BasicTextEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    //Util Date
    public String convertStringDateToFormattedDate(String stringDate, String formatBeforeDate, String formatAfterDate) {
        try {
            var beforeDateFormat = new SimpleDateFormat(formatBeforeDate);
            var afterDateFormat = new SimpleDateFormat(formatAfterDate);
            var convertedDate = beforeDateFormat.parse(stringDate);
            return afterDateFormat.format(convertedDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertTimestampToFormattedStringDate(Timestamp timestamp, String formatTimestamp){
        var simpleDateFormat = new SimpleDateFormat(formatTimestamp);
        return simpleDateFormat.format(timestamp);
    }

    //Util Calculate process time
    public Long calculateServiceTimeInMS(long startTime, long endTime){
        return endTime-startTime;
    }

    //Util File

    //Util Decrypt
    public String encryptData(String data){
        return encryptor.encrypt(data);
    }

    public String decryptData(String data){
        return encryptor.decrypt(data);
    }

    //Util Sorting array
    //Util Search
}
