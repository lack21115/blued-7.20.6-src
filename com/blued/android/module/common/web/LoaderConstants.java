package com.blued.android.module.common.web;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/LoaderConstants.class */
public class LoaderConstants {
    public static final String CLOSE = "close";
    public static final String DEVICE = "device";
    public static final String FEED_CUSTOM_RECOMMEND = "feedCustomRecommend";
    public static final String GET_CURRENT_LOCATION = "getCurrentLocation";
    public static final String GET_NETWORK_TYPE = "getNetworkType";
    public static final String GO_BACK = "goBack";
    public static final String INTERCEPT_GO_BACK = "interceptGoBack";
    public static final String LIVE_ACTIVITY_ACTION = "live_activity_action";
    public static final String NATIVE_TO_JS = "nativeToJs";
    public static final String ON_INIT = "onInit";
    public static final String OPEN_SHARE = "openShare";
    public static final String PAGE_INFO = "pageInfo";
    public static final String SAVE_IMAGE = "saveImage";
    public static final String SET_HEAD_MENU = "setHeadMenu";
    public static final String SHAKE = "shake";
    public static final String VIBRATE = "vibrate";
    public static final String YY_BUY_BEANS = "yy_js_native_bean";
    public static final String YY_BUY_GIFT = "yy_js_native_pay";
    public static final String YY_NATIVE_CHARGE = "yy_js_native_charge";
    public static final String YY_OPEN_MAGIC_LIST = "yy_magic_ranking_page";

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/LoaderConstants$LifeCycle.class */
    public interface LifeCycle {
        public static final int HARDWARE_BACK = 4;
        public static final int PAGE_DESTROY = 3;
        public static final int PAGE_HIDE = 2;
        public static final int PAGE_SHOW = 1;
        public static final int READY = 0;
        public static final int RESIZE = 5;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/LoaderConstants$ResponseCode.class */
    public interface ResponseCode {
        public static final int FAILED = 0;
        public static final int SUCCESS = 1;
    }
}
