package com.tencent.open;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.open.a.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/b.class */
public abstract class b extends Dialog {
    private static final String TAG = "openSDK_LOG.JsDialog";
    protected a jsBridge;
    protected final WebChromeClient mChromeClient;

    public b(Context context) {
        super(context);
        this.mChromeClient = new WebChromeClient() { // from class: com.tencent.open.b.1
            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i, String str2) {
                f.c(b.TAG, "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i + " of " + str2);
                if (Build.VERSION.SDK_INT == 7) {
                    b.this.onConsoleMessage(str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                f.c(b.TAG, "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (Build.VERSION.SDK_INT > 7) {
                    b.this.onConsoleMessage(consoleMessage == null ? "" : consoleMessage.message());
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                Tracker.onProgressChanged(this, webView, i);
                super.onProgressChanged(webView, i);
            }
        };
    }

    public b(Context context, int i) {
        super(context, i);
        this.mChromeClient = new WebChromeClient() { // from class: com.tencent.open.b.1
            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i2, String str2) {
                f.c(b.TAG, "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i2 + " of " + str2);
                if (Build.VERSION.SDK_INT == 7) {
                    b.this.onConsoleMessage(str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                f.c(b.TAG, "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (Build.VERSION.SDK_INT > 7) {
                    b.this.onConsoleMessage(consoleMessage == null ? "" : consoleMessage.message());
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                Tracker.onProgressChanged(this, webView, i2);
                super.onProgressChanged(webView, i2);
            }
        };
    }

    protected abstract void onConsoleMessage(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jsBridge = new a();
    }
}
