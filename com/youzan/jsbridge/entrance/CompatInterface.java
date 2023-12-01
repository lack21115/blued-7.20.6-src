package com.youzan.jsbridge.entrance;

import android.webkit.JavascriptInterface;
import com.youzan.jsbridge.dispatcher.MethodDispatcher;
import com.youzan.jsbridge.method.JsMethodCompat;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/entrance/CompatInterface.class */
public class CompatInterface {
    public static final String NAME = "androidJS";
    private MethodDispatcher<JsMethodCompat> mDispatcher;

    public CompatInterface(MethodDispatcher<JsMethodCompat> methodDispatcher) {
        this.mDispatcher = methodDispatcher;
    }

    private void dispatch(String str, String str2) {
        this.mDispatcher.dispatch(new JsMethodCompat(str, str2));
    }

    @JavascriptInterface
    public void configNative(String str) {
        dispatch("configNative", str);
    }

    @JavascriptInterface
    public void configRightBarItems(String str) {
        dispatch(CompatEntrance.API_CONFIG_RIGHT_BAR_MENU, str);
    }

    @JavascriptInterface
    public void doAction(String str) {
        dispatch("doAction", str);
    }

    @JavascriptInterface
    public void getData(String str) {
        dispatch("getData", str);
    }

    @JavascriptInterface
    public void getUserInfo(String str) {
        dispatch("getUserInfo", str);
    }

    @JavascriptInterface
    public void gotoNative(String str) {
        dispatch("gotoNative", str);
    }

    @JavascriptInterface
    public void gotoWebview(String str) {
        dispatch("gotoWebview", str);
    }

    @JavascriptInterface
    public void putData(String str) {
        dispatch("putData", str);
    }

    @JavascriptInterface
    public void returnShareData(String str) {
        dispatch("returnShareData", str);
    }

    @JavascriptInterface
    public void setRightMenu(String str) {
        dispatch("setRightMenu", str);
    }

    @JavascriptInterface
    public void turnOffPullDownRefresh(String str) {
        dispatch("turnOffPullDownRefresh", str);
    }

    @JavascriptInterface
    public void webReady(String str) {
        dispatch("webReady", str);
    }
}
