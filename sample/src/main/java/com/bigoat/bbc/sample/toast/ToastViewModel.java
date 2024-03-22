package com.bigoat.bbc.sample.toast;

import android.graphics.Color;

import com.bigoat.bbc.base.BaseLiveData;
import com.bigoat.bbc.sample.my.MyViewModel;
import com.blankj.utilcode.util.ToastUtils;

public class ToastViewModel extends MyViewModel {
    public BaseLiveData<Boolean> customToastData = new BaseLiveData<>(false);

    public void switchCustomToast() {
        customToastData.value(!customToastData.value());
    }

    @Override
    public void toast(TYPE type, String msg) {
        if (!customToastData.value()) {
            super.toast(type, msg);
        } else {
            switch (type) {
                case NORMAL:
                    ToastUtils.getDefaultMaker().setBgColor(Color.parseColor("#353A3E"));
                    ToastUtils.getDefaultMaker().setTextColor(Color.WHITE);
                    break;
                case INFO:
                    ToastUtils.getDefaultMaker().setBgColor(Color.parseColor("#3F51B5"));
                    ToastUtils.getDefaultMaker().setTextColor(Color.WHITE);
                    break;
                case WARN:
                    ToastUtils.getDefaultMaker().setBgColor(Color.parseColor("#FFA900"));
                    ToastUtils.getDefaultMaker().setTextColor(Color.WHITE);
                    break;
                case ERROR:
                    ToastUtils.getDefaultMaker().setBgColor(Color.parseColor("#D50000"));
                    ToastUtils.getDefaultMaker().setTextColor(Color.WHITE);
                    break;
                case SUCCESS:
                    ToastUtils.getDefaultMaker().setBgColor(Color.parseColor("#388E3C"));
                    ToastUtils.getDefaultMaker().setTextColor(Color.WHITE);
                    break;
            }
            ToastUtils.showShort(msg);
        }
    }
}
