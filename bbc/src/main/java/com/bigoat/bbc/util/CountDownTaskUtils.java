package com.bigoat.bbc.util;

import android.os.CountDownTimer;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 2021-12-21
 *     desc   : 倒计时任务工具类
 * </pre>
 */
public class CountDownTaskUtils {
    // 任务集
    private static final Map<String, CountDownTimer> TIMES = new HashMap<>();

    /**
     * 开始倒计时任务
     *
     * @param tag 标记
     * @param millisInFuture 结束时间
     * @param callback 回调
     */
    public static void start(String tag, long millisInFuture, final TaskCallback callback) {
        start(tag, millisInFuture, 1000, callback);
    }

    /**
     * 开始倒计时任务
     *
     * @param tag 标记
     * @param millisInFuture 结束时间
     * @param interval 执行间隔
     * @param callback 回调
     */
    public static void start(String tag, long millisInFuture, long interval, TaskCallback callback) {
       if (TIMES.get(tag) != null) {
           cancel(tag);
       }

        CountDownTimer countDownTimer = new CountDownTimer(millisInFuture, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                callback.onTick(millisUntilFinished); }

            @Override
            public void onFinish() {
                callback.onFinish();
            }
        };

       countDownTimer.start();
       TIMES.put(tag, countDownTimer);
    }

    /**
     * 取消所有任务
     */
    public static void cancelAll() {
        for (String tag : TIMES.keySet()) {
           cancel(tag);
        }
        TIMES.clear();
    }

    /**
     * 取消任务
     *
     * @param tag tag
     */
    public static void cancel(String tag) {
       CountDownTimer timer = TIMES.get(tag);
       if (timer != null) {
           timer.cancel();
           timer = null;
       }
        TIMES.remove(tag);
    }

    /**
     * 倒计时任务回调
     */
    public abstract static class TaskCallback {
        // 倒计时回调
        public abstract void onTick(long millisUntilFinished);
        // 倒计时结束
        public void onFinish() {}
    }
}
