package com.ss.android.download.api.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/constant/BaseConstants.class */
public interface BaseConstants {
    @Deprecated
    public static final int ACTION_TYPE_BUTTON = 2;
    @Deprecated
    public static final int ACTION_TYPE_ITEM = 1;
    public static final String CATEGORY_UMENG = "umeng";
    public static final String DOWNLOAD_DIR = "ByteDownload";
    public static final String EVENT_LABEL_AD_EXTRA_DATA = "ad_extra_data";
    public static final String EVENT_LABEL_EXTRA = "extra";
    public static final String EVENT_LABEL_IS_AD_EVENT = "is_ad_event";
    public static final String EVENT_LABEL_LOG_EXTRA = "log_extra";
    public static final int EVENT_SOURCE_SDK_INSIDE = 2;
    public static final int EVENT_SOURCE_USER = 1;
    public static final String MARKET_PREFIX = "market://details?id=";
    public static final String MARKET_SCHEME_SAMSUNG = "samsungapps";
    public static final String SCHEME_MARKET = "market";
    public static final String START_ONLY_FOR_ANDROID = "start_only_for_android";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/constant/BaseConstants$ActionType.class */
    public @interface ActionType {
        public static final int BTN = 2;
        public static final int ITEM = 1;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/constant/BaseConstants$Time.class */
    public interface Time {
        public static final int DAY = 86400000;
        public static final int HOUR = 3600000;
        public static final int MINUTE = 60000;
        public static final int SECOND = 1000;
        public static final int WEEK = 604800000;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/constant/BaseConstants$ToastScene.class */
    public @interface ToastScene {
        public static final int NETWORK_NOT_AVAILABLE = 5;
        public static final int NO_STORAGE_PERMISSION = 1;
        public static final int OPEN_APP_FAILED = 4;
        public static final int PACKAGE_NAME_ERROR = 3;
        public static final int START_DOWNLOAD = 2;
    }
}
