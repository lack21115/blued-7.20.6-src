package com.huawei.hms.ads.jsb;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.ads.jsb.inner.impl.JsBridgeImpl;
import com.huawei.hms.ads.jsbridge.b;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/PPSJsBridge.class */
public class PPSJsBridge extends com.huawei.hms.ads.jsbridge.a {

    /* renamed from: a  reason: collision with root package name */
    private static JsbConfig f22501a;
    private WeakReference<WebView> b;

    /* renamed from: c  reason: collision with root package name */
    private IWebView f22502c;
    private boolean d;

    public PPSJsBridge(WebView webView) {
        if (webView == null) {
            b.b("webView object is null, cannot register it.");
            return;
        }
        b(webView);
        a();
        webView.addJavascriptInterface(this, "_HwJSBridge");
    }

    public PPSJsBridge(IWebView iWebView) {
        if (iWebView == null) {
            b.b("webView object is null, cannot register it.");
            return;
        }
        b(iWebView);
        a();
        iWebView.addJavascriptInterface(this, "_HwJSBridge");
    }

    private void a() {
        JsBridgeImpl.initConfig(b(), f22501a);
    }

    private void a(final String str) {
        a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                if (PPSJsBridge.this.d) {
                    if (PPSJsBridge.this.f22502c != null) {
                        if (Build.VERSION.SDK_INT >= 19) {
                            PPSJsBridge.this.f22502c.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.1
                                @Override // android.webkit.ValueCallback
                                /* renamed from: a */
                                public void onReceiveValue(String str2) {
                                }
                            });
                            return;
                        }
                        IWebView iWebView = PPSJsBridge.this.f22502c;
                        iWebView.loadUrl("javascript:" + str);
                        return;
                    }
                } else if (PPSJsBridge.this.b != null && PPSJsBridge.this.b.get() != 0) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        ((WebView) PPSJsBridge.this.b.get()).evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.2
                            @Override // android.webkit.ValueCallback
                            /* renamed from: a */
                            public void onReceiveValue(String str2) {
                            }
                        });
                        return;
                    }
                    WebView webView = (WebView) PPSJsBridge.this.b.get();
                    Tracker.loadUrl(webView, "javascript:" + str);
                    return;
                }
                b.b("please register a webView object to jsb.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z, boolean z2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            String format = String.format(Locale.ENGLISH, "if(%s){%s(%s)};", str, str, str2);
            str4 = format;
            if (z) {
                str4 = format + "delete window." + str;
            }
        } else {
            String str5 = str3;
            if (str3 == null) {
                str5 = "";
            }
            str4 = "var iframeEles=document.querySelectorAll('iframe');if(iframeEles && iframeEles.length>0){for (let index = 0; index < iframeEles.length; index++) {var iframe = iframeEles[index];if (iframe &&iframe.contentWindow) {iframe.contentWindow.postMessage({ppsMsgType:1,data:" + str2 + ",cb:'" + str + "',complete:" + z + ",uuid:'" + str5 + "'},'*');}}}";
        }
        a(str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context b() {
        if (this.d) {
            IWebView iWebView = this.f22502c;
            if (iWebView != null) {
                Context context = iWebView.getContext();
                if (context == null) {
                    b.b("custom webView context is null.");
                }
                return context;
            }
        } else {
            WeakReference<WebView> weakReference = this.b;
            if (weakReference != null && weakReference.get() != null) {
                return this.b.get().getContext();
            }
        }
        b.b("the webview context is null.");
        return null;
    }

    private void b(WebView webView) {
        this.b = new WeakReference<>(webView);
    }

    private void b(IWebView iWebView) {
        this.d = true;
        this.f22502c = iWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        if (this.d) {
            IWebView iWebView = this.f22502c;
            if (iWebView != null) {
                return a(iWebView);
            }
            return null;
        }
        WeakReference<WebView> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return a(this.b.get());
    }

    public static void init(JsbConfig jsbConfig) {
        f22501a = jsbConfig;
    }

    public void destroy() {
        WeakReference<WebView> weakReference = this.b;
        if (weakReference != null) {
            weakReference.clear();
        }
        IWebView iWebView = this.f22502c;
        if (iWebView != null) {
            iWebView.removeJavascriptInterface("_HwJSBridge");
            this.f22502c = null;
        }
    }

    @JavascriptInterface
    public String invoke(String str, String str2) {
        WeakReference<WebView> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            b.b("this webView is destroyed");
            return null;
        }
        return JsBridgeImpl.invoke(this.b.get().getContext(), str, str2);
    }

    @JavascriptInterface
    public void invokeAsync(final String str, final String str2, final String str3) {
        final JSONObject jSONObject = new JSONObject();
        a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                String str5;
                String str6 = str2;
                boolean z = true;
                String str7 = null;
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    boolean optBoolean = jSONObject2.optBoolean(Constant.MAP_KEY_TOP, true);
                    str4 = jSONObject2.optString("uuid");
                    jSONObject2.put("url", PPSJsBridge.this.c());
                    z = optBoolean;
                    str7 = str4;
                    str5 = jSONObject2.toString();
                    z = optBoolean;
                } catch (Throwable th) {
                    b.b("jsb response data error.");
                    str4 = str7;
                    str5 = str6;
                }
                Context b = PPSJsBridge.this.b();
                if (b == null) {
                    b.b("invoke method param context is null.");
                }
                final boolean z2 = z;
                final String str8 = str4;
                JsBridgeImpl.invoke(b, str, str5, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str9, CallResult<String> callResult) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(callResult.getData());
                            boolean optBoolean2 = jSONObject3.optBoolean("complete", true);
                            jSONObject.put("code", callResult.getCode());
                            jSONObject.put("data", jSONObject3);
                            jSONObject.put("msg", callResult.getMsg());
                            PPSJsBridge.this.a(str3, jSONObject.toString(), optBoolean2, z2, str8);
                        } catch (Throwable th2) {
                            b.b("jsb response data error.");
                        }
                    }
                }, String.class);
            }
        });
    }
}
