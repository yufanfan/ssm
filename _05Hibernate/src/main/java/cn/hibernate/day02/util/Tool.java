package cn.hibernate.day02.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Happy on 2017-12-26.
 */
public class Tool {
    public static Date strToDate(String date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        return sdf.parse(date);
    }
}
