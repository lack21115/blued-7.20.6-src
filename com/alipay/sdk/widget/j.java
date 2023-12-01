package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import com.alipay.sdk.widget.p;
import com.baidu.mobads.sdk.internal.bw;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/j.class */
public class j extends g implements p.a, p.b, p.c {
    public static final String b = "alipayjsbridge://";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4688c = "onBack";
    public static final String d = "setTitle";
    public static final String e = "onRefresh";
    public static final String f = "showBackButton";
    public static final String g = "onExit";
    public static final String h = "onLoadJs";
    public static final String i = "callNativeFunc";
    public static final String j = "back";
    public static final String k = "title";
    public static final String l = "refresh";
    public static final String m = "backButton";
    public static final String n = "refreshButton";
    public static final String o = "exit";
    public static final String p = "action";
    public static final String q = "pushWindow";
    public static final String r = "h5JsFuncCallback";
    private static final String s = "sdk_result_code:";
    private boolean t;
    private String u;
    private boolean v;
    private final com.alipay.sdk.sys.a w;
    private p x;
    private u y;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/j$a.class */
    abstract class a implements Animation.AnimationListener {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(j jVar, k kVar) {
            this();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public j(Activity activity, com.alipay.sdk.sys.a aVar) {
        super(activity);
        this.t = true;
        this.u = "GET";
        this.v = false;
        this.x = null;
        this.y = new u();
        this.w = aVar;
        c();
    }

    private void a(String str, String str2, String str3) {
        JSONObject c2 = com.alipay.sdk.util.n.c(str3);
        if ("title".equals(str) && c2.has("title")) {
            this.x.getTitle().setText(c2.optString("title", ""));
        } else if ("refresh".equals(str)) {
            this.x.getWebView().reload();
        } else if ("back".equals(str)) {
            e();
        } else {
            int i2 = 0;
            if (o.equals(str)) {
                com.alipay.sdk.app.j.a(c2.optString("result", null));
                a(c2.optBoolean(bw.o, false));
            } else if (m.equals(str)) {
                boolean optBoolean = c2.optBoolean("show", true);
                ImageView backButton = this.x.getBackButton();
                if (!optBoolean) {
                    i2 = 4;
                }
                backButton.setVisibility(i2);
            } else if (n.equals(str)) {
                this.x.getRefreshButton().setVisibility(c2.optBoolean("show", true) ? 0 : 4);
            } else if (!q.equals(str) || c2.optString("url", null) == null) {
            } else {
                b(c2.optString("url"), c2.optString("title", ""));
            }
        }
    }

    private void a(boolean z) {
        com.alipay.sdk.app.j.a(z);
        this.f4685a.finish();
    }

    private void b(String str) {
        Map<String, String> a2 = com.alipay.sdk.util.n.a(this.w, str);
        if (str.startsWith(i)) {
            a(a2.get("func"), a2.get("cbId"), a2.get("data"));
        } else if (str.startsWith(f4688c)) {
            e();
        } else if (str.startsWith(d) && a2.containsKey("title")) {
            this.x.getTitle().setText(a2.get("title"));
        } else if (str.startsWith(e)) {
            this.x.getWebView().reload();
        } else if (str.startsWith(f) && a2.containsKey("bshow")) {
            this.x.getBackButton().setVisibility(TextUtils.equals("true", a2.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(g)) {
            com.alipay.sdk.app.j.a(a2.get("result"));
            a(TextUtils.equals("true", a2.get("bsucc")));
        } else if (str.startsWith(h)) {
            this.x.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    private boolean b(String str, String str2) {
        p pVar = this.x;
        try {
            p pVar2 = new p(this.f4685a, this.w);
            this.x = pVar2;
            pVar2.setChromeProxy(this);
            this.x.setWebClientProxy(this);
            this.x.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.x.getTitle().setText(str2);
            }
            this.v = true;
            this.y.a(pVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new m(this, pVar, str));
            this.x.setAnimation(translateAnimation);
            addView(this.x);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean c() {
        try {
            p pVar = new p(this.f4685a, this.w);
            this.x = pVar;
            pVar.setChromeProxy(this);
            this.x.setWebClientProxy(this);
            this.x.setWebEventProxy(this);
            addView(this.x);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private void d() {
        if (this.t) {
            this.f4685a.finish();
        } else {
            this.x.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
        }
    }

    private void e() {
        WebView webView = this.x.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
            return;
        }
        u uVar = this.y;
        if (uVar == null || uVar.b()) {
            a(false);
        } else {
            f();
        }
    }

    private boolean f() {
        if (this.y.b()) {
            this.f4685a.finish();
            return true;
        }
        this.v = true;
        p pVar = this.x;
        this.x = this.y.a();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setFillAfter(false);
        translateAnimation.setAnimationListener(new l(this, pVar));
        pVar.setAnimation(translateAnimation);
        removeView(pVar);
        addView(this.x);
        return true;
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        this.x.a();
        this.y.c();
    }

    @Override // com.alipay.sdk.widget.p.c
    public void a(p pVar) {
        d();
    }

    @Override // com.alipay.sdk.widget.p.a
    public void a(p pVar, String str) {
        if (str.startsWith("http") || pVar.getUrl().endsWith(str)) {
            return;
        }
        this.x.getTitle().setText(str);
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        if ("POST".equals(this.u)) {
            this.x.a(str, (byte[]) null);
        } else {
            this.x.a(str);
        }
    }

    public void a(String str, String str2, boolean z) {
        this.u = str2;
        this.x.getTitle().setText(str);
        this.t = z;
    }

    @Override // com.alipay.sdk.widget.p.b
    public boolean a(p pVar, int i2, String str, String str2) {
        com.alipay.sdk.sys.a aVar = this.w;
        com.alipay.sdk.app.statistic.a.a(aVar, "net", com.alipay.sdk.app.statistic.c.r, "onReceivedError:" + str2);
        pVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.widget.p.b
    public boolean a(p pVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        com.alipay.sdk.sys.a aVar = this.w;
        com.alipay.sdk.app.statistic.a.a(aVar, "net", com.alipay.sdk.app.statistic.c.r, "2-" + sslError);
        this.f4685a.runOnUiThread(new n(this, sslErrorHandler));
        return true;
    }

    @Override // com.alipay.sdk.widget.p.a
    public boolean a(p pVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(s)) {
            this.f4685a.runOnUiThread(new k(this));
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // com.alipay.sdk.widget.p.c
    public void b(p pVar) {
        pVar.getWebView().reload();
        pVar.getRefreshButton().setVisibility(4);
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        if (this.v) {
            return true;
        }
        d();
        return true;
    }

    @Override // com.alipay.sdk.widget.p.b
    public boolean b(p pVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(b)) {
            b(str.substring(17));
            return true;
        } else if (TextUtils.equals(str, com.alipay.sdk.cons.a.o)) {
            a(false);
            return true;
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            this.x.a(str);
            return true;
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.f4685a.startActivity(intent);
                return true;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.w, com.alipay.sdk.app.statistic.c.b, th);
                return true;
            }
        }
    }

    @Override // com.alipay.sdk.widget.p.b
    public boolean c(p pVar, String str) {
        pVar.a("javascript:window.prompt('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        pVar.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.v) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
