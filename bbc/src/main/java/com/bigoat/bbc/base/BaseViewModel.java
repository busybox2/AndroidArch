package com.bigoat.bbc.base;

import androidx.lifecycle.ViewModel;
import androidx.annotation.NonNull;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-11-19
 *     desc   : 基础ViewModel进行逻辑处理
 * </pre>
 */
public class BaseViewModel extends ViewModel implements IToast, ILog {

    private String tag;

    private boolean isCreate = false;

    protected BaseLiveData<String> progressData = new BaseLiveData<>();

    /**
     * 监听Activity 和 Fragment 生命周期
     */
    public void create() {
        if (!isCreate) {
            tag = getClass().getSimpleName();
            onCreate();
            isCreate = true;
        }
    }

    public void onCreate() {}

    public void onStart() {}

    public void onResume() {}

    public void onPause() {}

    public void onStop() {}

    public void onDestroy() {}

    protected void showProgress(@NonNull String msg) {
        progressData.value(msg);
    }

    protected void showProgress() {
        progressData.value("");
    }

    protected void hideProgress() {
        progressData.value(null);
    }
}
