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
    private static int f1190 = -9;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final long f1191 = 3000;

    /* renamed from: ʻ  reason: contains not printable characters */
    private WeakReference<Activity> f1192;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f1194;

    /* renamed from: ʾ  reason: contains not printable characters */
    private View f1195;

    /* renamed from: ˈ  reason: contains not printable characters */
    private int f1197;

    /* renamed from: ˉ  reason: contains not printable characters */
    private String f1198;

    /* renamed from: ι  reason: contains not printable characters */
    private FrameLayout f1203;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private WebViewClient f1204;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f1199 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Stack<String> f1201 = new Stack<>();

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f1193 = false;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f1202 = false;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f1196 = false;

    /* renamed from: ˌ  reason: contains not printable characters */
    private final Handler f1200 = new Handler(Looper.getMainLooper());

    public WebClientWrapper(Context context) {
        if (context instanceof Activity) {
            this.f1192 = new WeakReference<>((Activity) context);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Pair<Integer, Integer> m12271(ViewGroup viewGroup) {
        Pair<Integer, Integer> m12271;
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
            } else if ((childAt instanceof ViewGroup) && (m12271 = m12271((ViewGroup) childAt)) != null) {
                return m12271;
            } else {
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public View m12272(Activity activity) {
        try {
            return activity.getWindow().getDecorView().getRootView();
        } catch (Exception e) {
            Log.e("YouzanBrowser", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12275(View view) {
        Pair<Integer, Integer> m12271;
        if (this.f1203 == null) {
            this.f1203 = new FrameLayout(view.getContext());
        }
        if (this.f1195 == null) {
            this.f1195 = new LoadingView(view.getContext());
            if (TextUtils.isEmpty(this.f1198)) {
                int i = this.f1197;
                if (i > 0) {
                    ((LoadingView) this.f1195).setLoadImage(i);
                } else {
                    ((LoadingView) this.f1195).setImage();
                }
            } else {
                ((LoadingView) this.f1195).setLoadImage(this.f1198);
            }
        }
        if (this.f1195.getParent() == null || this.f1195.getParent() != this.f1203) {
            if (this.f1195.getParent() != null) {
                ((ViewGroup) this.f1195.getParent()).removeView(this.f1195);
            }
            ViewGroup.LayoutParams layoutParams = this.f1195.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams;
            if (layoutParams == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams3.gravity = 17;
            this.f1203.addView(this.f1195, layoutParams3);
        }
        if (this.f1203.getParent() == null || this.f1203.getParent() != view) {
            ViewGroup viewGroup = (ViewGroup) view;
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1, 17);
            if (this.f1196 && (m12271 = m12271(viewGroup)) != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                layoutParams4.topMargin = m12271.first.intValue() - iArr[1];
                layoutParams4.height = m12271.second.intValue();
                layoutParams4.gravity = 48;
            }
            this.f1203.setClickable(false);
            viewGroup.addView(this.f1203, layoutParams4);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12276(WebView webView) {
        if (System.currentTimeMillis() - this.f1199 > 3000) {
            this.f1199 = System.currentTimeMillis();
            SessionManager.unregister(webView.getContext());
            webView.reload();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12278(String str) {
        if (TextUtils.isEmpty(str) || str.equals(getUrl())) {
            return;
        }
        if (WebParameter.isYouzanPage(str)) {
            this.f1201.push(str);
        } else if (TextUtils.isEmpty(this.f1194)) {
        } else {
            this.f1201.push(this.f1194);
            this.f1194 = null;
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    protected final Activity getActivity() {
        WeakReference<Activity> weakReference = this.f1192;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getUrl() {
        if (this.f1201.size() > 0) {
            return this.f1201.peek();
        }
        return null;
    }

    public void hideProgressBar() {
        this.f1200.post(new Runnable() { // from class: com.youzan.androidsdkx5.plugin.WebClientWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                if (WebClientWrapper.this.f1203 != null && WebClientWrapper.this.f1203.isShown()) {
                    WebClientWrapper.this.f1203.setVisibility(8);
                }
            }
        });
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.f1193) {
            this.f1193 = false;
        }
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
        if (this.f1202) {
            YouzanLog.d("finish loading by onPageFinished");
            hideProgressBar();
        }
        webView.loadUrl(PrivacyDisagreeProtocolEvent.injectSupportPrivacyDisagreeProtocol());
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f1193 && this.f1201.size() > 0) {
            this.f1194 = this.f1201.pop();
        }
        m12278(str);
        this.f1193 = true;
        if ((webView.getContext() instanceof Activity) && this.f1202) {
            showProgressBar((Activity) webView.getContext());
        }
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (Build.VERSION.SDK_INT < 23 && i == f1190) {
            m12276(webView);
            return;
        }
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT >= 23 && webResourceError != null && webResourceError.getErrorCode() == f1190) {
            m12276(webView);
            return;
        }
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f, f2);
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        } else {
            super.onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public boolean pageCanGoBack() {
        return this.f1201.size() >= 2;
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
        if (this.f1201.size() >= 2) {
            this.f1201.pop();
            return this.f1201.pop();
        }
        return null;
    }

    public void setDelegate(WebViewClient webViewClient) {
        if (webViewClient instanceof WebClientWrapper) {
            return;
        }
        this.f1204 = webViewClient;
    }

    public void setLoadingImage(int i) {
        this.f1197 = i;
    }

    public void setLoadingImage(String str) {
        this.f1198 = str;
    }

    public void setLoadingView(View view) {
        this.f1195 = view;
    }

    public void setNeedLoading(boolean z) {
        this.f1202 = z;
    }

    public void setOnlyWebRegionLoadingShow(boolean z) {
        this.f1196 = z;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
        }
        return null;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewClient webViewClient = this.f1204;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, str);
        }
        return null;
    }

    @Override // com.tencent.smtt.sdk.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f1204;
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
            WebViewClient webViewClient = this.f1204;
            if ((webViewClient != null && webViewClient.shouldOverrideUrlLoading(webView, str)) || SchemeIntent.handleAlive(context, parse)) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public void showProgressBar(final Activity activity) {
        this.f1200.post(new Runnable() { // from class: com.youzan.androidsdkx5.plugin.WebClientWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                View m12272 = WebClientWrapper.this.m12272(activity);
                if (m12272 == null) {
                    return;
                }
                WebClientWrapper.this.m12275(m12272);
                if (WebClientWrapper.this.f1203.getVisibility() == 8) {
                    WebClientWrapper.this.f1203.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    String m12279() {
        if (this.f1201.size() > 0) {
            return this.f1201.pop();
        }
        return null;
    }
}
