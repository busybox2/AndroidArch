package com.bigoat.bbc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static com.bigoat.bbc.util.TimerTaskUtils.TimeUnit.MINUTE;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 2021-12-21
 *     desc   : 定时任务工具类
 * </pre>
 */
public class TimerTaskUtils {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
    public static final Timer TIMER = new Timer();
    private static final Map<String, TimerTask> TASKS = new HashMap<>();

    /**
     * 开始定时任务
     *
     * @param tag tag
     * @param delay 延迟
     * @param period 周期
     * @param callback 回调
     */
    public static void start(String tag, long delay, long period, final TaskCallback callback) {
        if (TASKS.get(tag) != null) {
            cancel(tag);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                callback.onTick();
            }
        };

        TIMER.scheduleAtFixedRate(task, delay, period);
        TASKS.put(tag, task);
    }

    public static void start(String tag, long period, final TaskCallback callback) {
        start(tag, 0, period, callback);
    }


    public static void startFixed(String tag, TimeUnit unit, int count, TaskCallback callback) {
        if (TASKS.get(tag) != null) {
            cancel(tag);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                callback.onTick();
            }
        };

        Calendar calendar = Calendar.getInstance();
        switch (unit) {
            case MINUTE:
                calendar.set(Calendar.SECOND, 0);
                calendar.add(Calendar.MINUTE, 1);
                break;
//            case HOUR: return count * 60 * 60 * 1000;
//            case DAY: return count * 24 * 60 * 60 * 1000;
//            case MONTH: return count * 1000;
//            case YEAR: return count * 1000;
        }

        Date date = calendar.getTime();
        System.out.println(SDF.format(date));
        TIMER.scheduleAtFixedRate(task, date, unit.toMillis(count));
        TASKS.put(tag, task);
    }

    public static void cancelAll() {
        for (String tag : TASKS.keySet()) {
           cancel(tag);
        }

        TASKS.clear();
    }

    public static void cancel(String tag) {
        TimerTask timer = TASKS.get(tag);
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        TASKS.remove(tag);
    }

    public static Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.MINUTE, num);
        return startDT.getTime();
    }

    public interface TaskCallback {
        void onTick();
    }

    public enum TimeUnit {
        MINUTE(), HOUR, DAY, MONTH, YEAR;


        public static TimeUnit MINUTE(int count) {
            return MINUTE;
        }

        long toMillis(long count) {
            switch (this) {
                case MINUTE: return count * 60 * 1000;
                case HOUR: return count * 60 * 60 * 1000;
                case DAY: return count * 24 * 60 * 60 * 1000;
                case MONTH: return count * 1000;
                case YEAR: return count * 1000;
            }
            return count;
        }
    }
}
