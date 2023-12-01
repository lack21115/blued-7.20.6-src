package com.youzan.jsbridge.entrance;

import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.youzan.jsbridge.dispatcher.MethodDispatcher;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.jsbridge.method.Method;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/entrance/CommonInterface.class */
public class CommonInterface {
    public static final String NAME = "YZAndroidJS";
    private MethodDispatcher<JsMethod> mMethodDispatcher;

    public CommonInterface(MethodDispatcher<JsMethod> methodDispatcher) {
        this.mMethodDispatcher = methodDispatcher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JavascriptInterface
    public void doCall(String str) {
        this.mMethodDispatcher.dispatch((Method) new Gson().fromJson(str, (Class<Object>) JsMethod.class));
    }
}
