package com.youzan.x5web;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import com.android.internal.telephony.PhoneConstants;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.youzan.jsbridge.util.AsyncExecutor;
import com.youzan.spiderman.cache.CacheHandler;
import com.youzan.spiderman.cache.CacheStatistic;
import com.youzan.spiderman.cache.ResourceResponse;
import com.youzan.spiderman.html.HtmlResponse;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/WebViewClientWrapper.class */
public class WebViewClientWrapper extends WebViewClient {
    private CacheHandler mCacheHandler;
    private WebViewClient mDelegate;
    private JsInjecter mJsInjecter;

    public WebViewClientWrapper(JsInjecter jsInjecter) {
        this.mJsInjecter = jsInjecter;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageFinished(final WebView webView, String str) {
        this.mJsInjecter.injectJsReady(webView);
        this.mCacheHandler.tryInjectJs(str, new CacheStatistic.InjectJsCallback() { // from class: com.youzan.x5web.WebViewClientWrapper.1
            @Override // com.youzan.spiderman.cache.CacheStatistic.InjectJsCallback
            public void onInject(String str2) {
                webView.loadUrl(str2);
            }
        });
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        } else {
            super.onPageFinished(webView, str);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mCacheHandler.resetStatistic();
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f, f2);
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        } else {
            super.onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.mDelegate;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public void setCacheHandler(CacheHandler cacheHandler) {
        this.mCacheHandler = cacheHandler;
    }

    public void setDelegate(WebViewClient webViewClient) {
        this.mDelegate = webViewClient;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.mDelegate;
        WebResourceResponse shouldInterceptRequest = webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : null;
        WebResourceResponse webResourceResponse = shouldInterceptRequest;
        if (shouldInterceptRequest == null) {
            final Uri url = webResourceRequest.getUrl();
            ResourceResponse shouldInterceptRequest2 = this.mCacheHandler.shouldInterceptRequest(url);
            if (shouldInterceptRequest2 != null) {
                WebResourceResponse webResourceResponse2 = new WebResourceResponse(shouldInterceptRequest2.getMimeType(), shouldInterceptRequest2.getEncoding(), shouldInterceptRequest2.getInputStream());
                HashMap hashMap = new HashMap();
                hashMap.put("access-control-allow-origin", PhoneConstants.APN_TYPE_ALL);
                webResourceResponse2.setResponseHeaders(hashMap);
                return webResourceResponse2;
            }
            HtmlResponse shouldInterceptHtml = this.mCacheHandler.shouldInterceptHtml(url);
            webResourceResponse = shouldInterceptRequest;
            if (shouldInterceptHtml != null) {
                WebResourceResponse webResourceResponse3 = new WebResourceResponse(shouldInterceptHtml.getMimeType(), shouldInterceptHtml.getEncoding(), shouldInterceptHtml.getContentStream());
                webResourceResponse3.setResponseHeaders(shouldInterceptHtml.getTransferHeader());
                final List<String> responseHeader = shouldInterceptHtml.getResponseHeader("Set-Cookie".toLowerCase());
                webResourceResponse = webResourceResponse3;
                if (responseHeader != null) {
                    webResourceResponse = webResourceResponse3;
                    if (!responseHeader.isEmpty()) {
                        final Context context = webView.getContext();
                        AsyncExecutor.getInstance().post(new Runnable() { // from class: com.youzan.x5web.WebViewClientWrapper.2
                            @Override // java.lang.Runnable
                            public void run() {
                                StorageManager.setCookie(context, url.toString(), responseHeader);
                            }
                        });
                        webResourceResponse = webResourceResponse3;
                    }
                }
            }
        }
        return webResourceResponse;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, final String str) {
        WebViewClient webViewClient = this.mDelegate;
        WebResourceResponse shouldInterceptRequest = webViewClient != null ? webViewClient.shouldInterceptRequest(webView, str) : null;
        WebResourceResponse webResourceResponse = shouldInterceptRequest;
        if (shouldInterceptRequest == null) {
            ResourceResponse shouldInterceptRequest2 = this.mCacheHandler.shouldInterceptRequest(Uri.parse(str));
            if (shouldInterceptRequest2 != null) {
                return new WebResourceResponse(shouldInterceptRequest2.getMimeType(), shouldInterceptRequest2.getEncoding(), shouldInterceptRequest2.getInputStream());
            }
            HtmlResponse shouldInterceptHtml = this.mCacheHandler.shouldInterceptHtml(str);
            webResourceResponse = shouldInterceptRequest;
            if (shouldInterceptHtml != null) {
                WebResourceResponse webResourceResponse2 = new WebResourceResponse(shouldInterceptHtml.getMimeType(), shouldInterceptHtml.getEncoding(), shouldInterceptHtml.getContentStream());
                final List<String> responseHeader = shouldInterceptHtml.getResponseHeader("Set-Cookie".toLowerCase());
                webResourceResponse = webResourceResponse2;
                if (responseHeader != null) {
                    webResourceResponse = webResourceResponse2;
                    if (!responseHeader.isEmpty()) {
                        final Context context = webView.getContext();
                        AsyncExecutor.getInstance().post(new Runnable() { // from class: com.youzan.x5web.WebViewClientWrapper.3
                            @Override // java.lang.Runnable
                            public void run() {
                                StorageManager.setCookie(context, str, responseHeader);
                            }
                        });
                        webResourceResponse = webResourceResponse2;
                    }
                }
            }
        }
        return webResourceResponse;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.mDelegate;
        return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewClient webViewClient = this.mDelegate;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
    }
}
