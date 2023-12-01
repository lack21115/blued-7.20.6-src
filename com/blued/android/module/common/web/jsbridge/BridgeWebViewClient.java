package com.blued.android.module.common.web.jsbridge;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/jsbridge/BridgeWebViewClient.class */
public class BridgeWebViewClient extends WebViewClient {
    private BridgeWebView webView;

    public BridgeWebViewClient(BridgeWebView bridgeWebView) {
        this.webView = bridgeWebView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        BridgeUtil.webViewLoadLocalJs(webView, "WebViewJavascriptBridge.js");
        if (this.webView.getStartupMessage() != null) {
            for (Message message : this.webView.getStartupMessage()) {
                this.webView.dispatchMessage(message);
            }
            this.webView.setStartupMessage(null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (str.startsWith(BridgeUtil.YY_RETURN_DATA)) {
            this.webView.handlerReturnData(str);
            return true;
        } else if (str.startsWith(BridgeUtil.YY_OVERRIDE_SCHEMA)) {
            this.webView.flushMessageQueue();
            return true;
        } else {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }
}
