package com.bigoat.bbc.base;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ToastUtils;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 2020-04-28
 *     desc   : 吐司接口
 * </pre>
 */
public interface IToast {

    class Config {
        static Config config = new Config();

        public Config setGravity(final int gravity) {
            ToastUtils.setGravity(gravity, 0, 0);
            return this;
        }

        public Config setGravity(final int gravity, final int xOffset, final int yOffset) {
            ToastUtils.setGravity(gravity, xOffset, yOffset);
            return this;
        }

        public Config setBgColor(@ColorInt final int backgroundColor) {
            ToastUtils.setBgColor(backgroundColor);
            return this;
        }

        public Config setBgResource(@DrawableRes final int bgResource) {
            ToastUtils.setBgResource(bgResource);
            return this;
        }

        public Config setMsgColor(@ColorInt final int msgColor) {
            ToastUtils.setMsgColor(msgColor);
            return this;
        }

        public Config setMsgTextSize(final int textSize) {
            ToastUtils.setMsgTextSize(textSize);
            return this;
        }

    }

    static Config getConfig() {
        return Config.config;
    }

    default void showToast(@NonNull String msg) {
        ToastUtils.showShort(msg);
    }

    @Deprecated
    default void showToastNormal(@NonNull String msg) {
        ToastUtils.showShort(msg);
    }

    default void showToastInfo(@NonNull String msg) {
        ToastUtils.showShort(msg);
    }

    default void showToastWarning(@NonNull String msg) {
        ToastUtils.showShort(msg);
    }

    default void showToastError(@NonNull String msg) {
        ToastUtils.showShort(msg);
    }

    default void showToastSuccess(@NonNull String msg) {
        ToastUtils.showShort(msg);
    }
}
