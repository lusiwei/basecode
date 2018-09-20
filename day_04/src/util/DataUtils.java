package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
    public static String parseDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd/hh:mm:ss");
        return sdf.format(date);
    }
}
