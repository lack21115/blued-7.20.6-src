package cn.com.chinatelecom.account.api;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/CtAccountJsBridge.class */
public class CtAccountJsBridge implements cn.com.chinatelecom.account.api.b.a {
    private static final String TAG = CtAccountJsBridge.class.getSimpleName();
    public static Handler mHandler = new Handler(Looper.getMainLooper());
    private a callback;
    private WebView mWebView;

    /* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/CtAccountJsBridge$a.class */
    public interface a {
        void a(String str);
    }

    public CtAccountJsBridge(WebView webView) {
        this.mWebView = webView;
    }

    public CtAccountJsBridge(a aVar) {
        this.callback = aVar;
    }

    @Override // cn.com.chinatelecom.account.api.b.a
    public void callbackPreCode(final String str) {
        String str2 = TAG;
        CtAuth.info(str2, "callbackPreCode:" + str);
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.CtAccountJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                if (CtAccountJsBridge.this.mWebView != null) {
                    WebView webView = CtAccountJsBridge.this.mWebView;
                    Tracker.loadUrl(webView, "javascript:ejsBridge.callbackPreCode('" + str + "')");
                } else if (CtAccountJsBridge.this.callback != null) {
                    a aVar = CtAccountJsBridge.this.callback;
                    aVar.a("javascript:ejsBridge.callbackPreCode('" + str + "')");
                }
            }
        });
    }

    @Override // cn.com.chinatelecom.account.api.b.a
    public void callbackPreCodeParams(final String str) {
        String str2 = TAG;
        CtAuth.info(str2, "callbackPreCodeParams:" + str);
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.CtAccountJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                if (CtAccountJsBridge.this.mWebView != null) {
                    WebView webView = CtAccountJsBridge.this.mWebView;
                    Tracker.loadUrl(webView, "javascript:ejsBridge.callbackPreCodeParams('" + str + "')");
                } else if (CtAccountJsBridge.this.callback != null) {
                    a aVar = CtAccountJsBridge.this.callback;
                    aVar.a("javascript:ejsBridge.callbackPreCodeParams('" + str + "')");
                }
            }
        });
    }

    @JavascriptInterface
    public void getPreCodeParams(String str) {
        String str2 = TAG;
        CtAuth.info(str2, "getPreCodeParams:" + str);
        CtAuth.getInstance().getPreCodeParamsByJs(str, this);
    }

    @JavascriptInterface
    public void requestPreCode(String str) {
        String str2 = TAG;
        CtAuth.info(str2, "requestPreCode:" + str);
        CtAuth.getInstance().requestPreCodeByJs(str, this);
    }
}
