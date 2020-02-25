package com.bigoat.bbc.base;

import androidx.lifecycle.MutableLiveData;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 18-11-19
 *     desc   : 基础数据模型
 * </pre>
 */
public class BaseLiveData<T> extends MutableLiveData<T> {

    public T value() {
        return super.getValue();
    }

    public void value(T value) {
        try {
            super.setValue(value);
        } catch (IllegalStateException e) {
            super.postValue(value);
        }
    }


}
