package com.youzan.jsbridge.dispatcher;

import com.bytedance.applog.util.WebViewJsUtil;
import com.youzan.jsbridge.event.NativeEvent;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.jsbridge.method.JsMethodCompat;
import com.youzan.jsbridge.method.Method;
import com.youzan.jsbridge.util.Logger;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/dispatcher/BridgeTrigger.class */
public abstract class BridgeTrigger {
    private static String TAG = BridgeTrigger.class.getSimpleName();

    public void doCallback(Method method, String str, Object... objArr) {
        int length = objArr.length;
        StringBuilder sb = new StringBuilder();
        sb.append(WebViewJsUtil.JS_URL_PREFIX);
        if (method instanceof JsMethod) {
            sb.append("window.YouzanJSBridge && window.YouzanJSBridge.callbacks");
            sb.append(" && (typeof window.YouzanJSBridge.callbacks[\"");
            sb.append(method.getCallback());
            sb.append("\"]");
            sb.append(" === \"function\")");
            sb.append(" && (window.YouzanJSBridge.callbacks[\"");
            sb.append(method.getCallback());
            sb.append("\"])(");
        } else if (!(method instanceof JsMethodCompat)) {
            String str2 = TAG;
            Logger.e(str2, "unknown method type, only JsMethod & JsMethodCompat supported, method:" + method);
            return;
        } else {
            sb.append("(typeof ");
            sb.append(method.getCallback());
            sb.append(" === \"function\") && ");
            sb.append(method.getCallback());
            sb.append("(");
        }
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append(")");
                doLoadJs(sb.toString());
                return;
            }
            Object obj = objArr[i2];
            sb.append(",\"");
            sb.append(obj != null ? obj.toString() : "");
            sb.append("\"");
            i = i2 + 1;
        }
    }

    public void doCallback(String str, Object... objArr) {
        int length = objArr.length;
        StringBuilder sb = new StringBuilder();
        sb.append(WebViewJsUtil.JS_URL_PREFIX);
        sb.append("window.YouzanJSBridge && window.YouzanJSBridge.callbacks");
        sb.append(" && (typeof window.YouzanJSBridge.callbacks[\"");
        sb.append(str);
        sb.append("\"]");
        sb.append(" === \"function\")");
        sb.append(" && window.YouzanJSBridge.callbacks[\"");
        sb.append(str);
        sb.append("\"](");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            sb.append("\"");
            sb.append(obj != null ? obj.toString() : "");
            sb.append("\",");
            i = i2 + 1;
        }
        if (length > 0) {
            sb.setLength(sb.length() - 1);
        }
        sb.append(")");
        doLoadJs(sb.toString());
    }

    public void doEvent(NativeEvent nativeEvent) {
        if (nativeEvent == null || nativeEvent.name == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:window.YouzanJSBridge && window.YouzanJSBridge.trigger && window.YouzanJSBridge.trigger(\"");
        sb.append(nativeEvent.name);
        Object[] objArr = nativeEvent.datas;
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(objArr[i2] != null ? objArr[i2].toString() : "");
                sb.append("\",\"");
                i = i2 + 1;
            }
        }
        sb.append("\")");
        doLoadJs(sb.toString());
    }

    public void doEvent(String str, Object... objArr) {
        doEvent(new NativeEvent(str, objArr));
    }

    public abstract void doLoadJs(String str);
}
