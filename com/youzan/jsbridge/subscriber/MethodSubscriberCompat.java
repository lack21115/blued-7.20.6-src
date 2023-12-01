package com.youzan.jsbridge.subscriber;

import com.youzan.jsbridge.method.JsMethodCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/subscriber/MethodSubscriberCompat.class */
public interface MethodSubscriberCompat extends Subscriber<JsMethodCompat> {
    public static final String CONFIG_NATIVE = "configNative";
    public static final String DO_ACTION = "doAction";
    public static final String GET_DATA = "getData";
    public static final String GET_USER_INFO = "getUserInfo";
    public static final String GOTO_NATIVE = "gotoNative";
    public static final String GOTO_WEBVIEW = "gotoWebview";
    public static final String PUT_DATA = "putData";
    public static final String RETURN_SHARE_DATA = "returnShareData";
    public static final String SET_RIGHT_MENU = "setRightMenu";
    public static final String TURN_OFF_PULL_DOWN_REFRESH = "turnOffPullDownRefresh";
    public static final String WEB_READY = "webReady";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/subscriber/MethodSubscriberCompat$Method.class */
    public @interface Method {
    }

    @Override // com.youzan.jsbridge.subscriber.Subscriber
    String subscribe();
}
