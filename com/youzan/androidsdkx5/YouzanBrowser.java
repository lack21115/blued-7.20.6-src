package com.youzan.androidsdkx5;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.youzan.androidsdk.HtmlStorage;
import com.youzan.androidsdk.WebViewCompat;
import com.youzan.androidsdk.YouzanLog;
import com.youzan.androidsdk.YouzanSDK;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.account.Token;
import com.youzan.androidsdk.event.AbsChooserEvent;
import com.youzan.androidsdk.event.DoActionEvent;
import com.youzan.androidsdk.event.Event;
import com.youzan.androidsdk.event.EventAPI;
import com.youzan.androidsdk.event.EventCenter;
import com.youzan.androidsdk.tool.Javascript;
import com.youzan.androidsdk.tool.Preference;
import com.youzan.androidsdk.tool.UserAgent;
import com.youzan.androidsdk.tool.WebParameter;
import com.youzan.androidsdk.ui.YouzanClient;
import com.youzan.androidsdkx5.YouzanBrowser;
import com.youzan.androidsdkx5.plugin.ChromeClientWrapper;
import com.youzan.androidsdkx5.plugin.ReadyFailureListener;
import com.youzan.androidsdkx5.plugin.SaveImageListener;
import com.youzan.androidsdkx5.plugin.SaveImageProcessor;
import com.youzan.androidsdkx5.plugin.WebClientWrapper;
import com.youzan.jsbridge.JsBridgeManager;
import com.youzan.spiderman.cache.SpiderCacheCallback;
import com.youzan.spiderman.cache.SpiderMan;
import com.youzan.x5web.WebChromeClientWrapper;
import com.youzan.x5web.WebViewClientWrapper;
import com.youzan.x5web.YZBaseWebView;
import com.youzan.x5web.YZWebSDK;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanBrowser.class */
public class YouzanBrowser extends YZBaseWebView implements YouzanClient {
    public static final Companion Companion = new Companion(null);

    /* renamed from: ʾ  reason: contains not printable characters */
    private static final int f1106 = 2000;

    /* renamed from: ʻ  reason: contains not printable characters */
    private ReadyFailureListener f1107;

    /* renamed from: ʼ  reason: contains not printable characters */
    private SaveImageListener f1108;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f1109;

    /* renamed from: ˊ  reason: contains not printable characters */
    private volatile boolean f1110;

    /* renamed from: ˋ  reason: contains not printable characters */
    private ChromeClientWrapper f1111;

    /* renamed from: ˎ  reason: contains not printable characters */
    private WebClientWrapper f1112;

    /* renamed from: ˏ  reason: contains not printable characters */
    private EventCenter f1113;

    /* renamed from: ͺ  reason: contains not printable characters */
    private WebViewCompat f1114;

    /* renamed from: ι  reason: contains not printable characters */
    private YouzanX5WebViewCallbackClient f1115;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private SpiderCacheCallback f1116;

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanBrowser$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Deprecated
    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanBrowser$OnChooseFile.class */
    public interface OnChooseFile {
        @Deprecated
        void onWebViewChooseFile(Intent intent, int i) throws ActivityNotFoundException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanBrowser$a.class */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            YouzanBrowser.this.f1110 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanBrowser$b.class */
    public static final class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            WebView.HitTestResult hitTestResult = YouzanBrowser.this.getHitTestResult();
            if (hitTestResult != null) {
                int type = hitTestResult.getType();
                if (type == 5 || type == 8) {
                    if (YouzanBrowser.this.f1108 != null) {
                        SaveImageListener saveImageListener = YouzanBrowser.this.f1108;
                        if (saveImageListener == null) {
                            Intrinsics.a();
                        }
                        if (saveImageListener.onSaveImage(hitTestResult)) {
                            return true;
                        }
                    }
                    return new SaveImageProcessor().showActionMenu(YouzanBrowser.this);
                }
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouzanBrowser(Context context) {
        super(context);
        Intrinsics.d(context, "context");
        this.f1114 = new YouzanX5Compat(this);
        m9206(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouzanBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.d(context, "context");
        this.f1114 = new YouzanX5Compat(this);
        m9206(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouzanBrowser(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.d(context, "context");
        this.f1114 = new YouzanX5Compat(this);
        m9206(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public YouzanBrowser(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        Intrinsics.d(context, "context");
        this.f1114 = new YouzanX5Compat(this);
        m9206(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m9205() {
        SpiderCacheCallback spiderCacheCallback = new SpiderCacheCallback() { // from class: com.youzan.androidsdkx5.YouzanBrowser$injectCache$1
            @Override // com.youzan.spiderman.cache.SpiderCacheCallback
            public void onCustomRequestHeader(String str, Map<String, String> map) {
                Intrinsics.d(str, "url");
                Intrinsics.d(map, "headerMap");
                try {
                    CookieSyncManager.createInstance(YouzanBrowser.this.getContext());
                    CookieManager cookieManager = CookieManager.getInstance();
                    cookieManager.setAcceptCookie(true);
                    String cookie = cookieManager.getCookie(str);
                    if (cookie != null) {
                        map.put("Cookie", cookie);
                    }
                } catch (Throwable th) {
                    YouzanLog.e("get cookie throw" + th);
                }
                String str2 = UserAgent.httpUA;
                if (str2 != null) {
                    map.put("User-Agent", str2);
                }
            }

            @Override // com.youzan.spiderman.cache.SpiderCacheCallback
            public void onStatistic(String str, String str2, Map<String, String> map) {
                Intrinsics.d(str, "name");
                Intrinsics.d(str2, "desc");
                Intrinsics.d(map, "staticData");
            }

            @Override // com.youzan.spiderman.cache.SpiderCacheCallback
            public String onTokenInactive(String str) {
                EventCenter eventCenter;
                Intrinsics.d(str, "preToken");
                String accessToken = Token.getAccessToken();
                if (accessToken == null || !(!Intrinsics.a(accessToken, str))) {
                    eventCenter = YouzanBrowser.this.f1113;
                    if (eventCenter != null) {
                        eventCenter.dispatch(YouzanBrowser.this.getContext(), "getUserInfo", EventAPI.SIGN_NOT_NEED_LOGIN);
                        return null;
                    }
                    return null;
                }
                return accessToken;
            }

            @Override // com.youzan.spiderman.cache.SpiderCacheCallback
            public String onTokenNeeded() {
                EventCenter eventCenter;
                String accessToken = Token.getAccessToken();
                if (accessToken != null) {
                    return accessToken;
                }
                eventCenter = YouzanBrowser.this.f1113;
                if (eventCenter != null) {
                    eventCenter.dispatch(YouzanBrowser.this.getContext(), "getUserInfo", EventAPI.SIGN_NOT_NEED_LOGIN);
                    return null;
                }
                return null;
            }
        };
        this.f1116 = spiderCacheCallback;
        YZWebSDK.setCacheCallback(spiderCacheCallback);
        SpiderMan.getInstance().initLru();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m9206(Context context) {
        if (isInEditMode()) {
            return;
        }
        if (!YouzanSDK.isReady()) {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
            ReadyFailureListener readyFailureListener = this.f1107;
            if (readyFailureListener != null) {
                if (readyFailureListener == null) {
                    Intrinsics.a();
                }
                readyFailureListener.readyFailure(context);
                return;
            }
            return;
        }
        if (interceptX5WebViewCallback()) {
            YouzanX5WebViewCallbackClient youzanX5WebViewCallbackClient = new YouzanX5WebViewCallbackClient(this);
            this.f1115 = youzanX5WebViewCallbackClient;
            setWebViewCallbackClient(youzanX5WebViewCallbackClient);
            if (getX5WebViewExtension() != null) {
                Log.i("YouzanBrowser", "x5WebViewExtension is not null");
                IX5WebViewExtension x5WebViewExtension = getX5WebViewExtension();
                Intrinsics.b(x5WebViewExtension, "x5WebViewExtension");
                x5WebViewExtension.setWebViewClientExtension(new com.youzan.androidsdkx5.a(this.f1115));
            } else {
                Log.i("YouzanBrowser", "x5WebViewExtension is null");
            }
        }
        this.f1114 = new YouzanX5Compat(this);
        this.f1113 = new EventCenter();
        Preference.renew(context);
        initWrappers(context, null, null);
        m9205();
        m9208(context);
        m9207();
        needLoading(true);
        postDelayed(new a(), 2000);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m9207() {
        setOnLongClickListener(new b());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m9208(Context context) {
        HtmlStorage.Synchronize.aliPay(context);
        HtmlStorage.Synchronize.sdkVersion(context, BuildConfig.VERSION_NAME);
        hideTopbar(true);
        WebParameter.initWebViewParameter(this.f1114);
        WebParameter.webViewUAConfiguration(this.f1114, UserAgent.clintId, "");
        WebParameter.blockDangerJsInterface(this.f1114);
    }

    @Override // com.youzan.x5web.YZBaseWebView, com.tencent.smtt.sdk.WebView
    public void destroy() {
        ViewParent parent = getParent();
        if (parent == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        destroyDrawingCache();
        clearCache(true);
        SpiderMan.getInstance().unInitLru();
        super.destroy();
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public int getPageType() {
        return 1;
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public WebViewCompat getWebViewCompat() {
        return this.f1114;
    }

    public final void hideTopbar(boolean z) {
        HtmlStorage.Synchronize.hideBar(getContext(), z);
    }

    protected final void initWrappers(Context context, ChromeClientWrapper chromeClientWrapper, WebClientWrapper webClientWrapper) {
        if (chromeClientWrapper == null) {
            YouzanBrowser youzanBrowser = this;
            EventCenter eventCenter = this.f1113;
            if (eventCenter == null) {
                Intrinsics.a();
            }
            chromeClientWrapper = new ChromeClientWrapper(youzanBrowser, eventCenter);
        }
        this.f1111 = chromeClientWrapper;
        if (webClientWrapper == null) {
            webClientWrapper = new WebClientWrapper(context);
        }
        this.f1112 = webClientWrapper;
        ChromeClientWrapper chromeClientWrapper2 = this.f1111;
        if (chromeClientWrapper2 == null) {
            Intrinsics.a();
        }
        super.setWebChromeClient(chromeClientWrapper2);
        WebClientWrapper webClientWrapper2 = this.f1112;
        if (webClientWrapper2 == null) {
            Intrinsics.a();
        }
        super.setWebViewClient(webClientWrapper2);
        ChromeClientWrapper chromeClientWrapper3 = this.f1111;
        if (chromeClientWrapper3 != null) {
            chromeClientWrapper3.setCustomEventCallback$yzsdkx5_release(new ChromeClientWrapper.ICustomEventCallback() { // from class: com.youzan.androidsdkx5.YouzanBrowser$initWrappers$1
                @Override // com.youzan.androidsdkx5.plugin.ChromeClientWrapper.ICustomEventCallback
                public void receiveMsg(@ChromeClientWrapper.WebCustomEventKey String str) {
                    WebClientWrapper webClientWrapper3;
                    WebClientWrapper webClientWrapper4;
                    if (Intrinsics.a(ChromeClientWrapper.LOAD_PHASE_DOM_CREATED, str)) {
                        webClientWrapper3 = YouzanBrowser.this.f1112;
                        if (webClientWrapper3 != null) {
                            YouzanLog.d("finish loading by domCreatedEvent");
                            webClientWrapper4 = YouzanBrowser.this.f1112;
                            if (webClientWrapper4 != null) {
                                webClientWrapper4.hideProgressBar();
                            }
                        }
                    }
                }
            });
        }
    }

    public boolean interceptX5WebViewCallback() {
        return false;
    }

    public final boolean isReceiveFileForWebView(int i, Intent intent) {
        return receiveFile(i, intent);
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void loadData(String str, String str2, String str3) {
        Intrinsics.d(str, "data");
        if (YouzanSDK.isReady()) {
            super.loadData(str, str2, str3);
        } else {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.d(str2, "data");
        if (YouzanSDK.isReady()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
        }
    }

    @Override // com.tencent.smtt.sdk.WebView, com.youzan.androidsdk.ui.YouzanClient
    public void loadUrl(String str) {
        Intrinsics.d(str, "s");
        if (YouzanSDK.isReady()) {
            super.loadUrl(str);
        } else {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Intrinsics.d(str, "url");
        Intrinsics.d(map, "additionalHttpHeaders");
        if (YouzanSDK.isReady()) {
            super.loadUrl(str, map);
        } else {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
        }
    }

    public final void needLoading(boolean z) {
        WebClientWrapper webClientWrapper = this.f1112;
        if (webClientWrapper != null) {
            webClientWrapper.setNeedLoading(z);
        }
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public boolean pageCanGoBack() {
        boolean z;
        if (Build.VERSION.SDK_INT <= 19) {
            WebClientWrapper webClientWrapper = this.f1112;
            z = false;
            if (webClientWrapper != null) {
                return webClientWrapper.pageCanGoBack();
            }
        } else {
            z = false;
            if (WebParameter.validPreviousUrl(this.f1114)) {
                z = false;
                if (canGoBack()) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public boolean pageGoBack() {
        boolean z = false;
        if (this.f1110) {
            if (Build.VERSION.SDK_INT <= 19) {
                WebClientWrapper webClientWrapper = this.f1112;
                z = false;
                if (webClientWrapper != null) {
                    return webClientWrapper.pageGoBack(this);
                }
            } else if (!pageCanGoBack()) {
                return false;
            } else {
                if (WebParameter.shouldSkipUrl(WebParameter.getPreviousUrl(this.f1114))) {
                    goBackOrForward(-2);
                } else {
                    goBack();
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public boolean receiveFile(int i, Intent intent) {
        ChromeClientWrapper chromeClientWrapper;
        ChromeClientWrapper chromeClientWrapper2 = this.f1111;
        if (chromeClientWrapper2 == null || i != chromeClientWrapper2.autoRequestId || (chromeClientWrapper = this.f1111) == null) {
            return false;
        }
        chromeClientWrapper.receiveImage(intent);
        return true;
    }

    @Override // com.tencent.smtt.sdk.WebView, com.youzan.androidsdk.ui.YouzanClient
    public void reload() {
        if (YouzanSDK.isReady()) {
            super.reload();
        } else {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
        }
    }

    public final void reloadWebView(Context context) {
        Intrinsics.d(context, "context");
        m9206(context);
    }

    public final void setLoadingImage(int i) {
        WebClientWrapper webClientWrapper = this.f1112;
        if (webClientWrapper != null) {
            webClientWrapper.setLoadingImage(i);
        }
    }

    public final void setLoadingImage(String str) {
        WebClientWrapper webClientWrapper = this.f1112;
        if (webClientWrapper != null) {
            webClientWrapper.setLoadingImage(str);
        }
    }

    public final void setLoadingView(View view) {
        WebClientWrapper webClientWrapper = this.f1112;
        if (webClientWrapper != null) {
            webClientWrapper.setLoadingView(view);
        }
    }

    @Deprecated
    public final void setOnChooseFileCallback(final OnChooseFile onChooseFile) {
        subscribe(new AbsChooserEvent() { // from class: com.youzan.androidsdkx5.YouzanBrowser$setOnChooseFileCallback$event$1
            @Override // com.youzan.androidsdk.event.AbsChooserEvent
            public void call(Context context, Intent intent, int i) throws ActivityNotFoundException {
                Intrinsics.d(context, "context");
                Intrinsics.d(intent, "intent");
                YouzanBrowser.OnChooseFile onChooseFile2 = YouzanBrowser.OnChooseFile.this;
                if (onChooseFile2 != null) {
                    onChooseFile2.onWebViewChooseFile(intent, i);
                }
            }
        });
    }

    public final void setOnlyWebRegionLoadingShow(boolean z) {
        WebClientWrapper webClientWrapper = this.f1112;
        if (webClientWrapper != null) {
            webClientWrapper.setOnlyWebRegionLoadingShow(z);
        }
    }

    public final void setReadyFailureListener(ReadyFailureListener readyFailureListener) {
        this.f1107 = readyFailureListener;
    }

    public final void setSaveImageListener(SaveImageListener saveImageListener) {
        this.f1108 = saveImageListener;
    }

    @Override // com.youzan.x5web.YZBaseWebView, com.tencent.smtt.sdk.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Intrinsics.d(webChromeClient, "client");
        if (!YouzanSDK.isReady()) {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
        } else if ((webChromeClient instanceof WebChromeClientWrapper) || (webChromeClient instanceof ChromeClientWrapper)) {
            super.setWebChromeClient(webChromeClient);
        } else {
            ChromeClientWrapper chromeClientWrapper = this.f1111;
            if (chromeClientWrapper != null) {
                chromeClientWrapper.setDelegate(webChromeClient);
            }
        }
    }

    @Override // com.youzan.x5web.YZBaseWebView, com.tencent.smtt.sdk.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Intrinsics.d(webViewClient, "client");
        if (!YouzanSDK.isReady()) {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
        } else if ((webViewClient instanceof WebViewClientWrapper) || (webViewClient instanceof WebClientWrapper)) {
            super.setWebViewClient(webViewClient);
        } else {
            WebClientWrapper webClientWrapper = this.f1112;
            if (webClientWrapper != null) {
                webClientWrapper.setDelegate(webViewClient);
            }
        }
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public void sharePage() {
        Javascript.sharePage(this.f1114);
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public void subscribe(Event event) {
        Intrinsics.d(event, "event");
        if (!YouzanSDK.isReady()) {
            YouzanLog.e("appkey校验不通过，请检查后重新传入");
            return;
        }
        JsBridgeManager jsBridgeManager = getJsBridgeManager();
        jsBridgeManager.subscribe(new EventSubscriber(event));
        EventCenter eventCenter = this.f1113;
        if (eventCenter == null) {
            Intrinsics.a();
        }
        eventCenter.subscribe(event);
        if (this.f1109) {
            return;
        }
        this.f1109 = true;
        jsBridgeManager.subscribe(new EventSubscriber(new DoActionEvent(this.f1113)));
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public void sync(YouzanToken youzanToken) {
        Intrinsics.d(youzanToken, "token");
        reload();
    }

    @Override // com.youzan.androidsdk.ui.YouzanClient
    public boolean syncNot() {
        if (pageCanGoBack()) {
            return pageGoBack();
        }
        return false;
    }
}
