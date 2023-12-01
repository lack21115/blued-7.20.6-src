package com.anythink.expressad.atsignalcommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/o.class */
public class o extends WebChromeClient {
    private static final String b = "H5_ENTRY";

    /* renamed from: a  reason: collision with root package name */
    WindVaneWebView f7114a;

    /* renamed from: c  reason: collision with root package name */
    private e f7115c;

    public o(WindVaneWebView windVaneWebView) {
        this.f7114a = windVaneWebView;
    }

    public final void a(e eVar) {
        this.f7115c = eVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        d signalCommunication = this.f7114a.getSignalCommunication();
        if (signalCommunication != null && consoleMessage != null) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message) || !message.startsWith("mv://")) {
                return false;
            }
            com.anythink.expressad.foundation.h.o.a(b, "onConsoleMessage: message.length() = " + message.length() + " " + message);
            if (message.contains("wv_hybrid:") && signalCommunication.a("wv_hybrid:")) {
                String substring = message.substring(0, message.lastIndexOf(" ") + 1);
                com.anythink.expressad.foundation.h.o.a(b, "message = ".concat(String.valueOf(substring)));
                signalCommunication.c(substring);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        com.anythink.expressad.foundation.h.o.d(b, String.valueOf(str2));
        d signalCommunication = this.f7114a.getSignalCommunication();
        if (signalCommunication == null || str3 == null || !signalCommunication.a(str3)) {
            return false;
        }
        signalCommunication.c(str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Tracker.onProgressChanged(this, webView, i);
        super.onProgressChanged(webView, i);
        e eVar = this.f7115c;
        if (eVar != null) {
            eVar.onProgressChanged(webView, i);
        }
    }
}
