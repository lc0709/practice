package com.doiche.utils;

public class TimeUtil {
    public static final long SECOND = 20L;
    public static final long MINUTE = SECOND * 60L;
    public static final long ZERO = 0L;

    public static long minutes(long min){
        return MINUTE * min;
    }
    public static long seconds(long sec){
        return SECOND * sec;
    }
}
