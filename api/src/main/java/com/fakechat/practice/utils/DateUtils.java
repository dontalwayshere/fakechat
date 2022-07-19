package com.fakechat.practice.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {


    /**
     * 支持jdk1.6的写法<br/>
     * 解析2015-12-27T14:20:34+08:00格式类型的时间<br/>
     * 将2015-12-27T14:20:34+08:00转换成2015-12-27 14:20:34<br/>
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String getTimestampTimeV16(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        sdf.setTimeZone(tz);
        Date date = sdf.parse(str);
        String string = date.toString();
        return string;
    }

    /**
     * 支持jdk1.7的写法<br/>
     * 解析2015-12-27T14:20:34+08:00格式类型的时间<br/>
     * 将2015-12-27T14:20:34+08:00转换成2015-12-27 14:20:34<br/>
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String getTimestampTimeV17(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date date = sdf.parse(str);
        String string = date.toString();
        return string;
    }

    /**
     * 将1464166640(当前时间的秒)转换成：yyyy-MM-dd HH:mm:ss格式
     *
     * @param str
     * @return
     */
    public static String getTimeToDay(String str) {
        Date date = new Date(1464166640L * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }

    public static Timestamp getTimestamp(String time) {
        Timestamp timestamp = Timestamp.valueOf(time);
        return timestamp;
    }


}
