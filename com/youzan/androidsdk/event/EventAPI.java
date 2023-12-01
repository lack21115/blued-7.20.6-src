package com.youzan.androidsdk.event;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/event/EventAPI.class */
public interface EventAPI {
    public static final String EVENT_ADD_TO_CART = "addToCart";
    public static final String EVENT_ADD_UP = "addUp";
    public static final String EVENT_AUTHENTICATION = "getUserInfo";
    public static final String EVENT_AUTHORIZATION_ERROR = "authorizationError";
    public static final String EVENT_AUTHORIZATION_SUCCESS = "authorizationSuccess";
    public static final String EVENT_BUY_NOW = "buyNow";
    public static final String EVENT_CHECK_AUTH_MOBILE = "checkAuthSucceed";
    public static final String EVENT_DO_ACTION = "doAction";
    public static final String EVENT_FILE_CHOOSER = "showFileChooser";
    public static final String EVENT_INVOKE_DISAGREE_PROTOCOL = "invokeDisagreeProtocol";
    public static final String EVENT_INVOKE_GO_CASHIER = "GoCashier";
    public static final String EVENT_PAGE_READY = "webReady";
    public static final String EVENT_PAYMENT_FINISHED = "paymentFinished";
    public static final String EVENT_SHARE = "returnShareData";
    public static final String SIGN_NEED_LOGIN = "{\"need_login\":true}";
    public static final String SIGN_NOT_NEED_LOGIN = "{\"need_login\":false}";
}
