package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String parseDate(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
