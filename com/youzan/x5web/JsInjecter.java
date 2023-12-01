package com.youzan.x5web;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebView;
import com.youzan.jsbridge.dispatcher.MethodDispatcher;
import com.youzan.jsbridge.entrance.CommonEntrance;
import com.youzan.jsbridge.entrance.CommonInterface;
import com.youzan.jsbridge.entrance.CompatEntrance;
import com.youzan.jsbridge.entrance.CompatInterface;
import com.youzan.jsbridge.entrance.JsBridgeEntrance;
import com.youzan.jsbridge.internal.JsMethodModel;
import com.youzan.jsbridge.internal.JsMethodParser;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.jsbridge.method.JsMethodCompat;
import com.youzan.jsbridge.util.BridgeUtil;
import com.youzan.jsbridge.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/JsInjecter.class */
public class JsInjecter {
    public static final String JS_IS_READY = "javascript:window.isReadyForYouZanJSBridge=true;";
    private MethodDispatcher<JsMethod> mDispatcher;
    private MethodDispatcher<JsMethodCompat> mDispatcherCompat;
    private List<JsBridgeEntrance> mEntrances;
    private boolean mIsJsInjected = false;
    private JsMethodParser mJsMethodParser;
    private String mLastUrl;
    private WebView mWebView;

    public JsInjecter(WebView webView) {
        this.mWebView = webView;
        init();
    }

    private void blockJsInterface(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    private void init() {
        this.mDispatcher = new JsMethodDispatcher(this.mWebView);
        this.mDispatcherCompat = new JsMethodDispatcher(this.mWebView);
        if (Build.VERSION.SDK_INT >= 17) {
            initJavascriptInterfaces(this.mDispatcher, this.mDispatcherCompat);
        } else if (!BridgeUtil.shouldInjectJs()) {
            Logger.i("api 17以下未打开js桥接");
        } else {
            this.mEntrances = new ArrayList();
            this.mJsMethodParser = new JsMethodParser();
            addEntrance(new CompatEntrance());
            addEntrance(new CommonEntrance());
        }
    }

    private void initJavascriptInterfaces(MethodDispatcher<JsMethod> methodDispatcher, MethodDispatcher<JsMethodCompat> methodDispatcher2) {
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(new CommonInterface(methodDispatcher), "YZAndroidJS");
        this.mWebView.addJavascriptInterface(new CompatInterface(methodDispatcher2), "androidJS");
    }

    private void injectJs(WebView webView) {
        for (JsBridgeEntrance jsBridgeEntrance : this.mEntrances) {
            webView.loadUrl(jsBridgeEntrance.toJavaScript());
        }
    }

    private boolean parsePromptMessage(String str) {
        JsMethodModel deserialize = this.mJsMethodParser.deserialize(str);
        if (deserialize == null) {
            return false;
        }
        JsMethod parse = this.mJsMethodParser.parse(deserialize);
        if (parse != null) {
            Logger.d("Dispatching method " + parse.getName());
            return this.mDispatcher.dispatch(parse);
        }
        JsMethodCompat parseCompat = this.mJsMethodParser.parseCompat(deserialize);
        Logger.d("Dispatching compat method " + parseCompat.getName());
        return this.mDispatcherCompat.dispatch(parseCompat);
    }

    void addEntrance(JsBridgeEntrance jsBridgeEntrance) {
        this.mEntrances.add(jsBridgeEntrance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodDispatcher<JsMethod> getDispatcher() {
        return this.mDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public MethodDispatcher<JsMethodCompat> getDispatcherCompat() {
        return this.mDispatcherCompat;
    }

    public void injectJsReady(WebView webView) {
        webView.loadUrl(JS_IS_READY);
    }

    public boolean jsPrompt(String str, JsPromptResult jsPromptResult) {
        if (BridgeUtil.shouldInjectJs() && parsePromptMessage(str)) {
            jsPromptResult.confirm("{\"code\": 200, \"result\":\"\"}");
            return true;
        }
        return false;
    }

    public void shouldInjectJs(WebView webView, int i) {
        if (BridgeUtil.shouldInjectJs()) {
            if (i <= 25) {
                this.mIsJsInjected = false;
            } else if (!this.mIsJsInjected && !TextUtils.equals(this.mLastUrl, webView.getUrl())) {
                injectJs(webView);
                this.mLastUrl = webView.getUrl();
                this.mIsJsInjected = true;
            }
            if (i <= 75 || this.mIsJsInjected) {
                return;
            }
            injectJs(webView);
            this.mLastUrl = webView.getUrl();
            this.mIsJsInjected = true;
        }
    }
}
