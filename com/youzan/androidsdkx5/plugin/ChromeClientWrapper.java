package com.youzan.androidsdkx5.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;
import com.youzan.androidsdk.event.AbsChooserEvent;
import com.youzan.androidsdk.event.EventAPI;
import com.youzan.androidsdk.event.EventCenter;
import com.youzan.androidsdk.tool.Environment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/plugin/ChromeClientWrapper.class */
public final class ChromeClientWrapper extends WebChromeClient {
    public static final Companion Companion = new Companion(null);
    public static final String LOAD_PHASE_DOM_CREATED = "dom_created";

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final String f1172 = "image/*";

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final String f1173 = "yz_prefs_action";
    public final int autoRequestId;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final EventCenter f1174;

    /* renamed from: ˊ  reason: contains not printable characters */
    private WebChromeClient f1175;

    /* renamed from: ˋ  reason: contains not printable characters */
    private ValueCallback<Uri> f1176;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ValueCallback<Uri[]> f1177;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ICustomEventCallback f1178;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final WebView f1179;

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/plugin/ChromeClientWrapper$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/plugin/ChromeClientWrapper$ICustomEventCallback.class */
    public interface ICustomEventCallback {
        void receiveMsg(@WebCustomEventKey String str);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/plugin/ChromeClientWrapper$WebCustomEventKey.class */
    public @interface WebCustomEventKey {
    }

    public ChromeClientWrapper(WebView webView, EventCenter mEventCenter) {
        Intrinsics.d(mEventCenter, "mEventCenter");
        this.f1179 = webView;
        this.f1174 = mEventCenter;
        this.autoRequestId = Environment.generateRequestId();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m12260() {
        WebView webView = this.f1179;
        if (webView == null) {
            return;
        }
        webView.loadUrl("javascript:window.addEventListener('DOMContentLoaded', function() {prompt('yz_prefs_action:dom_created');});");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean m12261(Context context, String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = f1172;
        }
        AbsChooserEvent.Meta meta = new AbsChooserEvent.Meta();
        meta.acceptType = str2;
        meta.requestId = this.autoRequestId;
        return this.f1174.dispatch(context, EventAPI.EVENT_FILE_CHOOSER, meta.toJSON());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean m12262(ValueCallback<Uri> valueCallback, String str) {
        this.f1176 = valueCallback;
        WebView webView = this.f1179;
        if (webView == null) {
            Intrinsics.a();
        }
        Context context = webView.getContext();
        Intrinsics.b(context, "mWebView!!.context");
        return m12261(context, str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean m12263(String str) {
        if (this.f1178 == null) {
            return false;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        List b = StringsKt.b((CharSequence) str2, new String[]{":"}, false, 0, 6, (Object) null);
        if (b != null) {
            Object[] array = b.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length != 2 || (!Intrinsics.a((Object) f1173, (Object) strArr[0]))) {
                    return false;
                }
                if (Intrinsics.a((Object) LOAD_PHASE_DOM_CREATED, (Object) strArr[1])) {
                    ICustomEventCallback iCustomEventCallback = this.f1178;
                    if (iCustomEventCallback == null) {
                        Intrinsics.a();
                    }
                    iCustomEventCallback.receiveMsg(strArr[1]);
                    return true;
                }
                return true;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean m12264(ValueCallback<Uri[]> valueCallback, String str) {
        this.f1177 = valueCallback;
        WebView webView = this.f1179;
        if (webView == null) {
            Intrinsics.a();
        }
        Context context = webView.getContext();
        Intrinsics.b(context, "mWebView!!.context");
        return m12261(context, str);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.getDefaultVideoPoster();
        }
        return super.getDefaultVideoPoster();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public View getVideoLoadingProgressView() {
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        Intrinsics.d(callback, "callback");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.getVisitedHistory(callback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.getVisitedHistory(callback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onCloseWindow(WebView window) {
        Intrinsics.d(window, "window");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onCloseWindow(window);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onCloseWindow(window);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Intrinsics.d(consoleMessage, "consoleMessage");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onCreateWindow(WebView view, boolean z, boolean z2, Message resultMsg) {
        Intrinsics.d(view, "view");
        Intrinsics.d(resultMsg, "resultMsg");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onCreateWindow(view, z, z2, resultMsg);
        }
        return super.onCreateWindow(view, z, z2, resultMsg);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onExceededDatabaseQuota(String url, String databaseIdentifier, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Intrinsics.d(url, "url");
        Intrinsics.d(databaseIdentifier, "databaseIdentifier");
        Intrinsics.d(quotaUpdater, "quotaUpdater");
        quotaUpdater.updateQuota((long) IntentFilter.MATCH_CATEGORY_PATH);
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            webChromeClient.onExceededDatabaseQuota(url, databaseIdentifier, j, j2, j3, quotaUpdater);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onGeolocationPermissionsHidePrompt();
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissionsCallback callback) {
        Intrinsics.d(origin, "origin");
        Intrinsics.d(callback, "callback");
        callback.invoke(origin, true, false);
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onGeolocationPermissionsShowPrompt(origin, callback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onHideCustomView();
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onHideCustomView();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Intrinsics.d(view, "view");
        Intrinsics.d(url, "url");
        Intrinsics.d(message, "message");
        Intrinsics.d(result, "result");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsAlert(view, url, message, result);
        }
        return super.onJsAlert(view, url, message, result);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        Intrinsics.d(view, "view");
        Intrinsics.d(url, "url");
        Intrinsics.d(message, "message");
        Intrinsics.d(result, "result");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsBeforeUnload(view, url, message, result);
        }
        return super.onJsBeforeUnload(view, url, message, result);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        Intrinsics.d(view, "view");
        Intrinsics.d(url, "url");
        Intrinsics.d(message, "message");
        Intrinsics.d(result, "result");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsConfirm(view, url, message, result);
        }
        return super.onJsConfirm(view, url, message, result);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Intrinsics.d(view, "view");
        Intrinsics.d(url, "url");
        Intrinsics.d(message, "message");
        Intrinsics.d(defaultValue, "defaultValue");
        Intrinsics.d(result, "result");
        if (m12263(message)) {
            result.confirm(null);
            return true;
        }
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsPrompt(view, url, message, defaultValue, result);
        }
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsTimeout();
        }
        return super.onJsTimeout();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView view, int i) {
        Intrinsics.d(view, "view");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onProgressChanged(view, i);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onProgressChanged(view, i);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        Intrinsics.d(quotaUpdater, "quotaUpdater");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedIcon(WebView view, Bitmap icon) {
        Intrinsics.d(view, "view");
        Intrinsics.d(icon, "icon");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onReceivedIcon(view, icon);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onReceivedIcon(view, icon);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedTitle(WebView view, String title) {
        Intrinsics.d(view, "view");
        Intrinsics.d(title, "title");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            webChromeClient.onReceivedTitle(view, title);
        } else {
            super.onReceivedTitle(view, title);
        }
        m12260();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedTouchIconUrl(WebView view, String url, boolean z) {
        Intrinsics.d(view, "view");
        Intrinsics.d(url, "url");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onReceivedTouchIconUrl(view, url, z);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onReceivedTouchIconUrl(view, url, z);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onRequestFocus(WebView view) {
        Intrinsics.d(view, "view");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onRequestFocus(view);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onRequestFocus(view);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onShowCustomView(View view, int i, IX5WebChromeClient.CustomViewCallback callback) {
        Intrinsics.d(view, "view");
        Intrinsics.d(callback, "callback");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onShowCustomView(view, i, callback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onShowCustomView(view, i, callback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback callback) {
        Intrinsics.d(view, "view");
        Intrinsics.d(callback, "callback");
        WebChromeClient webChromeClient = this.f1175;
        if (webChromeClient == null) {
            super.onShowCustomView(view, callback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onShowCustomView(view, callback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        WebChromeClient webChromeClient;
        Intrinsics.d(webView, "webView");
        Intrinsics.d(fileChooserParams, "fileChooserParams");
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        if (m12264(valueCallback, (acceptTypes == null || acceptTypes.length <= 0) ? null : acceptTypes[0]) || (webChromeClient = this.f1175) == null) {
            return true;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback) {
        WebChromeClient webChromeClient;
        if (m12262(valueCallback, (String) null) || (webChromeClient = this.f1175) == null) {
            return;
        }
        if (webChromeClient == null) {
            try {
                Intrinsics.a();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.f1175, valueCallback);
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        WebChromeClient webChromeClient;
        if (m12262(valueCallback, str) || (webChromeClient = this.f1175) == null) {
            return;
        }
        if (webChromeClient == null) {
            try {
                Intrinsics.a();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.f1175, valueCallback, str);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
        WebChromeClient webChromeClient;
        Intrinsics.d(acceptType, "acceptType");
        Intrinsics.d(capture, "capture");
        if (m12262(valueCallback, acceptType) || (webChromeClient = this.f1175) == null) {
            return;
        }
        if (webChromeClient == null) {
            try {
                Intrinsics.a();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.f1175, valueCallback, acceptType, capture);
    }

    public final void receiveImage(Intent intent) {
        try {
            if (this.f1176 != null) {
                Uri data = intent != null ? intent.getData() : null;
                ValueCallback<Uri> valueCallback = this.f1176;
                if (valueCallback == null) {
                    Intrinsics.a();
                }
                valueCallback.onReceiveValue(data);
            } else if (this.f1177 != null) {
                Uri[] uriArr = intent == null ? null : new Uri[]{Uri.parse(intent.getDataString())};
                ValueCallback<Uri[]> valueCallback2 = this.f1177;
                if (valueCallback2 == null) {
                    Intrinsics.a();
                }
                valueCallback2.onReceiveValue(uriArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ValueCallback valueCallback3 = null;
        this.f1177 = valueCallback3;
        this.f1176 = valueCallback3;
    }

    public final void setCustomEventCallback$yzsdkx5_release(ICustomEventCallback iCustomEventCallback) {
        this.f1178 = iCustomEventCallback;
    }

    public final void setDelegate(WebChromeClient webChromeClient) {
        if (webChromeClient instanceof ChromeClientWrapper) {
            return;
        }
        this.f1175 = webChromeClient;
    }
}
