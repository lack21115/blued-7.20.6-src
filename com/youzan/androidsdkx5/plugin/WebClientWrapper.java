package com.youzan.androidsdkx5.plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.youzan.androidsdk.YouzanLog;
import com.youzan.androidsdk.event.PrivacyDisagreeProtocolEvent;
import com.youzan.androidsdk.tool.SchemeIntent;
import com.youzan.androidsdk.tool.SessionManager;
import com.youzan.androidsdk.tool.WebParameter;
import com.youzan.androidsdkx5.YouzanBrowser;
import com.youzan.androidsdkx5.view.LoadingView;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/plugin/WebClientWrapper.class */
public class WebClientWrapper extends WebViewClient {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f1143 = -9;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final long f1144 = 3000;

    /* renamed from: ʻ  reason: contains not printable characters */
    private WeakReference<Activity> f1145;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f1147;

    /* renamed from: ʾ  reason: contains not printable characters */
    private View f1148;

    /* renamed from: ˈ  reason: contains not printable characters */
    private int f1150;

    /* renamed from: ˉ  reason: contains not printable characters */
    private String f1151;

    /* renamed from: ι  reason: contains not printable characters */
    private FrameLayout f1156;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private WebViewClient f1157;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f1152 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Stack<String> f1154 = new Stack<>();

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f1146 = false;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f1155 = false;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f1149 = false;

    /* renamed from: ˌ  reason: contains not printable characters */
    private final Handler f1153 = new Handler(Looper.getMainLooper());

    public WebClientWrapper(Context context) {
        if (context instanceof Activity) {
            this.f1145 = new WeakReference<>((Activity) context);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Pair<Integer, Integer> m9221(ViewGroup viewGroup) {
        Pair<Integer, Integer> m9221;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof YouzanBrowser) {
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                return new Pair<>(Integer.valueOf(iArr[1]), Integer.valueOf(childAt.getHeight()));
            } else if ((childAt instanceof ViewGroup) && (m9221 = m9221((ViewGroup) childAt)) != null) {
                return m9221;
            } else {
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public View m9222(Activity activity) {
        try {
            return activity.getWindow().getDecorView().getRootView();
        } catch (Exception e) {
            Log.e("YouzanBrowser", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9225(View view) {
        Pair<Integer, Integer> m9221;
        if (this.f1156 == null) {
            this.f1156 = new FrameLayout(view.getContext());
        }
        if (this.f1148 == null) {
            this.f1148 = new LoadingView(view.getContext());
            if (TextUtils.isEmpty(this.f1151)) {
                int i = this.f1150;
                if (i > 0) {
                    ((LoadingView) this.f1148).setLoadImage(i);
                } else {
                    ((LoadingView) this.f1148).setImage();
                }
            } else {
                ((LoadingView) this.f1148).setLoadImage(this.f1151);
            }
        }
        if (this.f1148.getParent() == null || this.f1148.getParent() != this.f1156) {
            if (this.f1148.getParent() != null) {
                ((ViewGroup) this.f1148.getParent()).removeView(this.f1148);
            }
            ViewGroup.LayoutParams layoutParams = this.f1148.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams;
            if (layoutParams == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams3.gravity = 17;
            this.f1156.addView(this.f1148, layoutParams3);
        }
        if (this.f1156.getParent() == null || this.f1156.getParent() != view) {
            ViewGroup viewGroup = (ViewGroup) view;
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1, 17);
            if (this.f1149 && (m9221 = m9221(viewGroup)) != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                layoutParams4.topMargin = m9221.first.intValue() - iArr[1];
                layoutParams4.height = m9221.second.intValue();
                layoutParams4.gravity = 48;
            }
            this.f1156.setClickable(false);
            viewGroup.addView(this.f1156, layoutParams4);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9226(WebView webView) {
        if (System.currentTimeMillis() - this.f1152 > 3000) {
            this.f1152 = System.currentTimeMillis();
            SessionManager.unregister(webView.getContext());
            webView.reload();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9228(String str) {
        if (TextUtils.isEmpty(str) || str.equals(getUrl())) {
            return;
        }
        if (WebParameter.isYouzanPage(str)) {
            this.f1154.push(str);
        } else if (TextUtils.isEmpty(this.f1147)) {
        } else {
            this.f1154.push(this.f1147);
            this.f1147 = null;
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    protected final Activity getActivity() {
        WeakReference<Activity> weakReference = this.f1145;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getUrl() {
        if (this.f1154.size() > 0) {
            return this.f1154.peek();
        }
        return null;
    }

    public void hideProgressBar() {
        this.f1153.post(new Runnable() { // from class: com.youzan.androidsdkx5.plugin.WebClientWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                if (WebClientWrapper.this.f1156 != null && WebClientWrapper.this.f1156.isShown()) {
                    WebClientWrapper.this.f1156.setVisibility(8);
                }
            }
        });
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f1146) {
            this.f1146 = false;
        }
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
        if (this.f1155) {
            YouzanLog.d("finish loading by onPageFinished");
            hideProgressBar();
        }
        webView.loadUrl(PrivacyDisagreeProtocolEvent.injectSupportPrivacyDisagreeProtocol());
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f1146 && this.f1154.size() > 0) {
            this.f1147 = this.f1154.pop();
        }
        m9228(str);
        this.f1146 = true;
        if ((webView.getContext() instanceof Activity) && this.f1155) {
            showProgressBar((Activity) webView.getContext());
        }
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (Build.VERSION.SDK_INT < 23 && i == f1143) {
            m9226(webView);
            return;
        }
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT >= 23 && webResourceError != null && webResourceError.getErrorCode() == f1143) {
            m9226(webView);
            return;
        }
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f, f2);
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        } else {
            super.onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public boolean pageCanGoBack() {
        return this.f1154.size() >= 2;
    }

    public final boolean pageGoBack(WebView webView) {
        if (pageCanGoBack()) {
            String popBackUrl = popBackUrl();
            if (TextUtils.isEmpty(popBackUrl)) {
                return false;
            }
            webView.loadUrl(popBackUrl);
            return true;
        }
        return false;
    }

    public final String popBackUrl() {
        if (this.f1154.size() >= 2) {
            this.f1154.pop();
            return this.f1154.pop();
        }
        return null;
    }

    public void setDelegate(WebViewClient webViewClient) {
        if (webViewClient instanceof WebClientWrapper) {
            return;
        }
        this.f1157 = webViewClient;
    }

    public void setLoadingImage(int i) {
        this.f1150 = i;
    }

    public void setLoadingImage(String str) {
        this.f1151 = str;
    }

    public void setLoadingView(View view) {
        this.f1148 = view;
    }

    public void setNeedLoading(boolean z) {
        this.f1155 = z;
    }

    public void setOnlyWebRegionLoadingShow(boolean z) {
        this.f1149 = z;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
        }
        return null;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewClient webViewClient = this.f1157;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, str);
        }
        return null;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f1157;
        return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        Uri parse = Uri.parse(str);
        WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
        boolean z = false;
        if (copyBackForwardList == null || copyBackForwardList.getSize() <= 0 || copyBackForwardList.getCurrentItem() == null || !(str.equals(copyBackForwardList.getCurrentItem().getOriginalUrl()) || str.equals(WebParameter.getKdtUnionUrl(parse)))) {
            Context context = webView.getContext();
            if (SchemeIntent.isSilentType(parse.getScheme())) {
                return SchemeIntent.handleSilently(context, parse);
            }
            if (WebParameter.isBlockHost(parse.getHost())) {
                return false;
            }
            WebViewClient webViewClient = this.f1157;
            if ((webViewClient != null && webViewClient.shouldOverrideUrlLoading(webView, str)) || SchemeIntent.handleAlive(context, parse)) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public void showProgressBar(final Activity activity) {
        this.f1153.post(new Runnable() { // from class: com.youzan.androidsdkx5.plugin.WebClientWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                View m9222 = WebClientWrapper.this.m9222(activity);
                if (m9222 == null) {
                    return;
                }
                WebClientWrapper.this.m9225(m9222);
                if (WebClientWrapper.this.f1156.getVisibility() == 8) {
                    WebClientWrapper.this.f1156.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    String m9229() {
        if (this.f1154.size() > 0) {
            return this.f1154.pop();
        }
        return null;
    }
}
