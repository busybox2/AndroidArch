package com.bigoat.bbc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;


import com.bigoat.bbc.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 2020-07-01
 *     desc   : 当前时间
 * </pre>
 */
public class CurrentTimeView extends AppCompatTextView {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 aa E HH:mm:ss", Locale.CHINESE);
    private long updateInterval = 1;
    private final Runnable runnable = new Runnable() {
        final Date d = new Date();
        @Override
        public void run() {
            d.setTime(System.currentTimeMillis());
            String str = sdf.format(d);
            setText(str);
            updateDateTime();
        }
    };

    public CurrentTimeView(Context context) {
        super(context);
        init(context, null);
    }

    public CurrentTimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CurrentTimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) return;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CurrentTimeView);
        String format = ta.getString(R.styleable.CurrentTimeView_ctvFormat);
        if (format!=null && !"".equals(format)) {
            sdf = new SimpleDateFormat(format, Locale.CHINESE);
        }

        long updateInterval = ta.getInteger(R.styleable.CurrentTimeView_ctvUpdateInterval, -1);
        if (updateInterval != -1) {
            this.updateInterval = updateInterval;
        }

        ta.recycle();

        setText(sdf.format(new Date()));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isEnabled()) {
            updateDateTime();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(runnable);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            updateDateTime();
        } else {
            removeCallbacks(runnable);
        }
    }

    private void updateDateTime() {
        postDelayed(runnable, updateInterval*1000);
    }
}
