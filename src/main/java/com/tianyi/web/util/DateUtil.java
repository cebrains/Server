/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tianyi.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

enum DateStyle {

    MM_DD("MM-dd"),
    YYYY_MM("yyyy-MM"),
    YYYY_MM_DD("yyyy-MM-dd"),
    MM_DD_HH_MM("MM-dd HH:mm"),
    MM_DD_HH_MM_SS("MM-dd HH:mm:ss"),
    YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),
    MM_DD_EN("MM/dd"),
    YYYY_MM_EN("yyyy/MM"),
    YYYY_MM_DD_EN("yyyy/MM/dd"),
    MM_DD_HH_MM_EN("MM/dd HH:mm"),
    MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss"),
    YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm"),
    YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss"),
    MM_DD_CN("MM月dd日"),
    YYYY_MM_CN("yyyy年MM月"),
    YYYY_MM_DD_CN("yyyy年MM月dd日"),
    MM_DD_HH_MM_CN("MM月dd日 HH:mm"),
    MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss"),
    YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm"),
    YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss"),
    HH_MM("HH:mm"),
    HH_MM_SS("HH:mm:ss");

    private String value;

    DateStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

enum Week {

    MONDAY("星期一", "Monday", "Mon.", 1),
    TUESDAY("星期二", "Tuesday", "Tues.", 2),
    WEDNESDAY("星期三", "Wednesday", "Wed.", 3),
    THURSDAY("星期四", "Thursday", "Thur.", 4),
    FRIDAY("星期五", "Friday", "Fri.", 5),
    SATURDAY("星期六", "Saturday", "Sat.", 6),
    SUNDAY("星期日", "Sunday", "Sun.", 7);

    String name_cn;
    String name_en;
    String name_enShort;
    int number;

    Week(String name_cn, String name_en, String name_enShort, int number) {
        this.name_cn = name_cn;
        this.name_en = name_en;
        this.name_enShort = name_enShort;
        this.number = number;
    }

    public String getChineseName() {
        return name_cn;
    }

    public String getName() {
        return name_en;
    }

    public String getShortName() {
        return name_enShort;
    }

    public int getNumber() {
        return number;
    }
}

/**
 * 时间工具类。
 *
 * @author lxf
 */
public class DateUtil {

    public static final String C_DATE_DIVISION = "-";
    public static final String C_TIME_PATTON_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String C_DATE_PATTON_DEFAULT = "yyyy-MM-dd";
    public static final String C_DATA_PATTON_YYYYMMDD = "yyyyMMdd";
    public static final String C_TIME_PATTON_HHMMSS = "HH:mm:ss";
    public static final int C_ONE_SECOND = 1000;
    public static final int C_ONE_MINUTE = 60 * C_ONE_SECOND;
    public static final int C_ONE_HOUR = 60 * C_ONE_MINUTE;
    public static final long C_ONE_DAY = 24 * C_ONE_HOUR;

    /**
     * Return the current date
     *
     * @return － DATE<br>
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();

        return currDate;
    }

    /**
     * Return the current date string
     *
     * @return －vurrenDate to String
     */
    public static String getCurrentDateStr() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();

        return format(currDate);
    }

    /**
     * Return the current date in the specified format
     *
     * @param strFormat
     * @return
     */
    public static String getCurrentDateStr(String strFormat) {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();

        return format(currDate, strFormat);
    }

    /**
     * Parse a string and return a date value
     *
     * @param dateValue
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateValue) {
        return parseDate(C_DATE_PATTON_DEFAULT, dateValue);
    }

    /**
     * Parse a strign and return a datetime value
     *
     * @param dateValue
     * @return
     */
    public static Date parseDateTime(String dateValue) {
        return parseDate(C_TIME_PATTON_DEFAULT, dateValue);
    }

    /**
     * Parse a string and return the date value in the specified format
     *
     * @param strFormat
     * @param dateValue
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static Date parseDate(String strFormat, String dateValue) {
        if (dateValue == null) {
            return null;
        }

        if (strFormat == null) {
            strFormat = C_TIME_PATTON_DEFAULT;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        Date newDate = null;

        try {
            newDate = dateFormat.parse(dateValue.toString());
        } catch (ParseException pe) {
            pe.printStackTrace();
            newDate = null;
        }

        return newDate;
    }

    /**
     * 将Timestamp类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime 需要转换的日期。
     * @return 转换后符合给定格式的日期字符串
     */
    public static String format(Date aTs_Datetime) {
        return format(aTs_Datetime, C_DATE_PATTON_DEFAULT);
    }

    /**
     * 将Timestamp类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime 需要转换的日期。
     * @return 转换后符合给定格式的日期字符串
     */
    public static String formatTime(Date aTs_Datetime) {
        return format(aTs_Datetime, C_TIME_PATTON_DEFAULT);
    }

    /**
     * 将Date类型的日期转换为系统参数定义的格式的字符串。
     *
     * @param aTs_Datetime
     * @param as_Pattern
     * @return
     */
    public static String format(Date aTs_Datetime, String as_Pattern) {
        if (aTs_Datetime == null || as_Pattern == null) {
            return null;
        }

        SimpleDateFormat dateFromat = new SimpleDateFormat();
        dateFromat.applyPattern(as_Pattern);

        return dateFromat.format(aTs_Datetime);
    }

    /**
     * @param aTs_Datetime
     * @param as_Format
     * @return
     */
    public static String formatTime(Date aTs_Datetime, String as_Format) {
        if (aTs_Datetime == null || as_Format == null) {
            return null;
        }

        SimpleDateFormat dateFromat = new SimpleDateFormat();
        dateFromat.applyPattern(as_Format);

        return dateFromat.format(aTs_Datetime);
    }

    public static String getFormatTime(Date dateTime) {
        return formatTime(dateTime, C_TIME_PATTON_HHMMSS);
    }

    /**
     * 获取SimpleDateFormat
     *
     * @param parttern 日期格式
     * @return SimpleDateFormat对象
     * @throws RuntimeException 异常：非法日期格式
     */
    private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {
        return new SimpleDateFormat(parttern);
    }

    /**
     * 获取日期中的某数值。如获取月份
     *
     * @param date 日期
     * @param dateType 日期格式
     * @return 数值
     */
    private static int getInteger(Date date, int dateType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(dateType);
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date 日期字符串
     * @param dateType 类型
     * @param amount 数值
     * @return 计算后日期字符串
     */
    private static String addInteger(String date, int dateType, int amount) {
        String dateString = null;
        DateStyle dateStyle = getDateStyle(date);
        if (dateStyle != null) {
            Date myDate = StringToDate(date, dateStyle);
            myDate = addInteger(myDate, dateType, amount);
            dateString = DateToString(myDate, dateStyle);
        }
        return dateString;
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date 日期
     * @param dateType 类型
     * @param amount 数值
     * @return 计算后日期
     */
    private static Date addInteger(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * 获取精确的日期
     *
     * @param timestamps 时间long集合
     * @return 日期
     */
    private static Date getAccurateDate(List<Long> timestamps) {
        Date date = null;
        long timestamp = 0;
        Map<Long, long[]> map = new HashMap<Long, long[]>();
        List<Long> absoluteValues = new ArrayList<Long>();

        if (timestamps != null && timestamps.size() > 0) {
            if (timestamps.size() > 1) {
                for (int i = 0; i < timestamps.size(); i++) {
                    for (int j = i + 1; j < timestamps.size(); j++) {
                        long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
                        absoluteValues.add(absoluteValue);
                        long[] timestampTmp = {timestamps.get(i), timestamps.get(j)};
                        map.put(absoluteValue, timestampTmp);
                    }
                }

                // 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的
                long minAbsoluteValue = -1;
                if (!absoluteValues.isEmpty()) {
                    // 如果timestamps的size为2，这是差值只有一个，因此要给默认值
                    minAbsoluteValue = absoluteValues.get(0);
                }
                for (int i = 0; i < absoluteValues.size(); i++) {
                    for (int j = i + 1; j < absoluteValues.size(); j++) {
                        if (absoluteValues.get(i) > absoluteValues.get(j)) {
                            minAbsoluteValue = absoluteValues.get(j);
                        } else {
                            minAbsoluteValue = absoluteValues.get(i);
                        }
                    }
                }

                if (minAbsoluteValue != -1) {
                    long[] timestampsLastTmp = map.get(minAbsoluteValue);
                    if (absoluteValues.size() > 1) {
                        timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
                    } else if (absoluteValues.size() == 1) {
                        // 当timestamps的size为2，需要与当前时间作为参照
                        long dateOne = timestampsLastTmp[0];
                        long dateTwo = timestampsLastTmp[1];
                        if ((Math.abs(dateOne - dateTwo)) < 100000000000L) {
                            timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
                        } else {
                            long now = System.currentTimeMillis();
                            if (Math.abs(dateOne - now) <= Math.abs(dateTwo - now)) {
                                timestamp = dateOne;
                            } else {
                                timestamp = dateTwo;
                            }
                        }
                    }
                }
            } else {
                timestamp = timestamps.get(0);
            }
        }

        if (timestamp != 0) {
            date = new Date(timestamp);
        }
        return date;
    }

    /**
     * 判断字符串是否为日期字符串
     *
     * @param date 日期字符串
     * @return true or false
     */
    public static boolean isDate(String date) {
        boolean isDate = false;
        if (date != null) {
            if (StringToDate(date) != null) {
                isDate = true;
            }
        }
        return isDate;
    }

    /**
     * 获取日期字符串的日期风格。失敗返回null。
     *
     * @param date 日期字符串
     * @return 日期风格
     */
    public static DateStyle getDateStyle(String date) {
        DateStyle dateStyle = null;
        Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
        List<Long> timestamps = new ArrayList<Long>();
        for (DateStyle style : DateStyle.values()) {
            Date dateTmp = StringToDate(date, style.getValue());
            if (dateTmp != null) {
                timestamps.add(dateTmp.getTime());
                map.put(dateTmp.getTime(), style);
            }
        }
        dateStyle = map.get(getAccurateDate(timestamps).getTime());
        return dateStyle;
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date 日期字符串
     * @return 日期
     */
    public static Date StringToDate(String date) {
        DateStyle dateStyle = null;
        return StringToDate(date, dateStyle);
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date 日期字符串
     * @param parttern 日期格式
     * @return 日期
     */
    public static Date StringToDate(String date, String parttern) {
        Date myDate = null;
        if (date != null) {
            try {
                myDate = getDateFormat(parttern).parse(date);
            } catch (Exception e) {
            }
        }
        return myDate;
    }

    /**
     * 将日期字符串转化为日期。失败返回null。
     *
     * @param date 日期字符串
     * @param dateStyle 日期风格
     * @return 日期
     */
    public static Date StringToDate(String date, DateStyle dateStyle) {
        Date myDate = null;
        if (dateStyle == null) {
            List<Long> timestamps = new ArrayList<Long>();
            for (DateStyle style : DateStyle.values()) {
                Date dateTmp = StringToDate(date, style.getValue());
                if (dateTmp != null) {
                    timestamps.add(dateTmp.getTime());
                }
            }
            myDate = getAccurateDate(timestamps);
        } else {
            myDate = StringToDate(date, dateStyle.getValue());
        }
        return myDate;
    }

    /**
     * 将日期转化为日期字符串。失败返回null。
     *
     * @param date 日期
     * @param parttern 日期格式
     * @return 日期字符串
     */
    public static String DateToString(Date date, String parttern) {
        String dateString = null;
        if (date != null) {
            try {
                dateString = getDateFormat(parttern).format(date);
            } catch (Exception e) {
            }
        }
        return dateString;
    }

    /**
     * 将日期转化为日期字符串。失败返回null。
     *
     * @param date 日期
     * @param dateStyle 日期风格
     * @return 日期字符串
     */
    public static String DateToString(Date date, DateStyle dateStyle) {
        String dateString = null;
        if (dateStyle != null) {
            dateString = DateToString(date, dateStyle.getValue());
        }
        return dateString;
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date 旧日期字符串
     * @param parttern 新日期格式
     * @return 新日期字符串
     */
    public static String StringToString(String date, String parttern) {
        return StringToString(date, null, parttern);
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date 旧日期字符串
     * @param dateStyle 新日期风格
     * @return 新日期字符串
     */
    public static String StringToString(String date, DateStyle dateStyle) {
        return StringToString(date, null, dateStyle);
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date 旧日期字符串
     * @param olddParttern 旧日期格式
     * @param newParttern 新日期格式
     * @return 新日期字符串
     */
    public static String StringToString(String date, String olddParttern, String newParttern) {
        String dateString = null;
        if (olddParttern == null) {
            DateStyle style = getDateStyle(date);
            if (style != null) {
                Date myDate = StringToDate(date, style.getValue());
                dateString = DateToString(myDate, newParttern);
            }
        } else {
            Date myDate = StringToDate(date, olddParttern);
            dateString = DateToString(myDate, newParttern);
        }
        return dateString;
    }

    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     *
     * @param date 旧日期字符串
     * @param olddDteStyle 旧日期风格
     * @param newDateStyle 新日期风格
     * @return 新日期字符串
     */
    public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {
        String dateString = null;
        if (olddDteStyle == null) {
            DateStyle style = getDateStyle(date);
            dateString = StringToString(date, style.getValue(), newDateStyle.getValue());
        } else {
            dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());
        }
        return dateString;
    }

    /**
     * 增加日期的年份。失败返回null。
     *
     * @param date 日期
     * @param yearAmount 增加数量。可为负数
     * @return 增加年份后的日期字符串
     */
    public static String addYear(String date, int yearAmount) {
        return addInteger(date, Calendar.YEAR, yearAmount);
    }

    /**
     * 增加日期的年份。失败返回null。
     *
     * @param date 日期
     * @param yearAmount 增加数量。可为负数
     * @return 增加年份后的日期
     */
    public static Date addYear(Date date, int yearAmount) {
        return addInteger(date, Calendar.YEAR, yearAmount);
    }

    /**
     * 增加日期的月份。失败返回null。
     *
     * @param date 日期
     * @param yearAmount 增加数量。可为负数
     * @return 增加月份后的日期字符串
     */
    public static String addMonth(String date, int yearAmount) {
        return addInteger(date, Calendar.MONTH, yearAmount);
    }

    /**
     * 增加日期的月份。失败返回null。
     *
     * @param date 日期
     * @param yearAmount 增加数量。可为负数
     * @return 增加月份后的日期
     */
    public static Date addMonth(Date date, int yearAmount) {
        return addInteger(date, Calendar.MONTH, yearAmount);
    }

    /**
     * 增加日期的天数。失败返回null。
     *
     * @param date 日期字符串
     * @param dayAmount 增加数量。可为负数
     * @return 增加天数后的日期字符串
     */
    public static String addDay(String date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * 增加日期的天数。失败返回null。
     *
     * @param date 日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加天数后的日期
     */
    public static Date addDay(Date date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * 增加日期的小时。失败返回null。
     *
     * @param date 日期字符串
     * @param dayAmount 增加数量。可为负数
     * @return 增加小时后的日期字符串
     */
    public static String addHour(String date, int hourAmount) {
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * 增加日期的小时。失败返回null。
     *
     * @param date 日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加小时后的日期
     */
    public static Date addHour(Date date, int hourAmount) {
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * 增加日期的分钟。失败返回null。
     *
     * @param date 日期字符串
     * @param dayAmount 增加数量。可为负数
     * @return 增加分钟后的日期字符串
     */
    public static String addMinute(String date, int hourAmount) {
        return addInteger(date, Calendar.MINUTE, hourAmount);
    }

    /**
     * 增加日期的分钟。失败返回null。
     *
     * @param date 日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加分钟后的日期
     */
    public static Date addMinute(Date date, int hourAmount) {
        return addInteger(date, Calendar.MINUTE, hourAmount);
    }

    /**
     * 增加日期的秒钟。失败返回null。
     *
     * @param date 日期字符串
     * @param dayAmount 增加数量。可为负数
     * @return 增加秒钟后的日期字符串
     */
    public static String addSecond(String date, int hourAmount) {
        return addInteger(date, Calendar.SECOND, hourAmount);
    }

    /**
     * 增加日期的秒钟。失败返回null。
     *
     * @param date 日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加秒钟后的日期
     */
    public static Date addSecond(Date date, int hourAmount) {
        return addInteger(date, Calendar.SECOND, hourAmount);
    }

    /**
     * 获取日期的年份。失败返回0。
     *
     * @param date 日期字符串
     * @return 年份
     */
    public static int getYear(String date) {
        return getYear(StringToDate(date));
    }

    /**
     * 获取日期的年份。失败返回0。
     *
     * @param date 日期
     * @return 年份
     */
    public static int getYear(Date date) {
        return getInteger(date, Calendar.YEAR);
    }

    /**
     * 获取日期的月份。失败返回0。
     *
     * @param date 日期字符串
     * @return 月份
     */
    public static int getMonth(String date) {
        return getMonth(StringToDate(date));
    }

    /**
     * 获取日期的月份。失败返回0。
     *
     * @param date 日期
     * @return 月份
     */
    public static int getMonth(Date date) {
        return getInteger(date, Calendar.MONTH);
    }

    /**
     * 获取日期的天数。失败返回0。
     *
     * @param date 日期字符串
     * @return 天
     */
    public static int getDay(String date) {
        return getDay(StringToDate(date));
    }

    /**
     * 获取日期的天数。失败返回0。
     *
     * @param date 日期
     * @return 天
     */
    public static int getDay(Date date) {
        return getInteger(date, Calendar.DATE);
    }

    /**
     * 获取日期的小时。失败返回0。
     *
     * @param date 日期字符串
     * @return 小时
     */
    public static int getHour(String date) {
        return getHour(StringToDate(date));
    }

    /**
     * 获取日期的小时。失败返回0。
     *
     * @param date 日期
     * @return 小时
     */
    public static int getHour(Date date) {
        return getInteger(date, Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取日期的分钟。失败返回0。
     *
     * @param date 日期字符串
     * @return 分钟
     */
    public static int getMinute(String date) {
        return getMinute(StringToDate(date));
    }

    /**
     * 获取日期的分钟。失败返回0。
     *
     * @param date 日期
     * @return 分钟
     */
    public static int getMinute(Date date) {
        return getInteger(date, Calendar.MINUTE);
    }

    /**
     * 获取日期的秒钟。失败返回0。
     *
     * @param date 日期字符串
     * @return 秒钟
     */
    public static int getSecond(String date) {
        return getSecond(StringToDate(date));
    }

    /**
     * 获取日期的秒钟。失败返回0。
     *
     * @param date 日期
     * @return 秒钟
     */
    public static int getSecond(Date date) {
        return getInteger(date, Calendar.SECOND);
    }

    /**
     * 获取日期 。默认yyyy-MM-dd格式。失败返回null。
     *
     * @param date 日期字符串
     * @return 日期
     */
    public static String getDate(String date) {
        return StringToString(date, DateStyle.YYYY_MM_DD);
    }

    /**
     * 获取日期。默认yyyy-MM-dd格式。失败返回null。
     *
     * @param date 日期
     * @return 日期
     */
    public static String getDate(Date date) {
        return DateToString(date, DateStyle.YYYY_MM_DD);
    }

    /**
     * 获取日期的时间。默认HH:mm:ss格式。失败返回null。
     *
     * @param date 日期字符串
     * @return 时间
     */
    public static String getTime(String date) {
        return StringToString(date, DateStyle.HH_MM_SS);
    }

    /**
     * 获取日期的时间。默认HH:mm:ss格式。失败返回null。
     *
     * @param date 日期
     * @return 时间
     */
    public static String getTime(Date date) {
        return DateToString(date, DateStyle.HH_MM_SS);
    }

    /**
     * 获取日期的时间。默认yyyy-MM-dd HH:mm:ss格式。失败返回null。
     *
     * @param date 日期字符串
     * @return 时间
     */
    public static Date getDateTime(String date) {
        return DateUtil.StringToDate(date);
    }

    /**
     * 获取日期的时间。默认yyyy-MM-dd HH:mm:ss格式。失败返回null。
     *
     * @param date 日期
     * @return 时间
     */
    public static String getDateTime(Date date) {
        return DateToString(date, DateStyle.YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获得日期
     *
     * @param time
     * @return
     */
    public static Date getDate(long time) {
        return new Date(time);
    }

    /**
     * 获取日期的星期。失败返回null。
     *
     * @param date 日期字符串
     * @return 星期
     */
    public static Week getWeek(String date) {
        Week week = null;
        DateStyle dateStyle = getDateStyle(date);
        if (dateStyle != null) {
            Date myDate = StringToDate(date, dateStyle);
            week = getWeek(myDate);
        }
        return week;
    }

    /**
     * 获取日期的星期。失败返回null。
     *
     * @param date 日期
     * @return 星期
     */
    public static Week getWeek(Date date) {
        Week week = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        switch (weekNumber) {
            case 0:
                week = Week.SUNDAY;
                break;
            case 1:
                week = Week.MONDAY;
                break;
            case 2:
                week = Week.TUESDAY;
                break;
            case 3:
                week = Week.WEDNESDAY;
                break;
            case 4:
                week = Week.THURSDAY;
                break;
            case 5:
                week = Week.FRIDAY;
                break;
            case 6:
                week = Week.SATURDAY;
                break;
        }
        return week;
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date 日期字符串
     * @param otherDate 另一个日期字符串
     * @return 相差天数
     */
    public static int getIntervalDays(String date, String otherDate) {
        return getIntervalDays(StringToDate(date), StringToDate(otherDate));
    }

    /**
     * @param date 日期
     * @param otherDate 另一个日期
     * @return 相差天数
     */
    public static int getIntervalDays(Date date, Date otherDate) {
        date = DateUtil.StringToDate(DateUtil.getDate(date));
        long time = Math.abs(date.getTime() - otherDate.getTime());
        return (int) time / (24 * 60 * 60 * 1000);
    }

    /**
     * 判断原日期是否在目标日期之前
     *
     * @param src
     * @param dst
     * @return
     */
    public static boolean isBefore(Date src, Date dst) {
        return src.before(dst);
    }

    /**
     * 判断原日期是否在目标日期之后
     *
     * @param src
     * @param dst
     * @return
     */
    public static boolean isAfter(Date src, Date dst) {
        return src.after(dst);
    }

    /**
     * 判断和当前日期是否是同一天
     *
     * @param date
     * @return
     */
    public static boolean isSameDay(Date date) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        c2.setTime(new Date());
        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSameDay(Date date, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        c2.setTime(date2);
        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断某个日期是否在某个日期范围
     *
     * @param beginDate 日期范围开始
     * @param endDate 日期范围结束
     * @param src 需要判断的日期
     * @return
     */
    public static boolean between(Date beginDate, Date endDate, Date src) {
        return beginDate.before(src) && endDate.after(src);
    }
}
