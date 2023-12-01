package com.youzan.androidsdkx5.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.anythink.expressad.a;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.constant.bc;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
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
    private static final String f1125 = "image/*";

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final String f1126 = "yz_prefs_action";
    public final int autoRequestId;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final EventCenter f1127;

    /* renamed from: ˊ  reason: contains not printable characters */
    private WebChromeClient f1128;

    /* renamed from: ˋ  reason: contains not printable characters */
    private ValueCallback<Uri> f1129;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ValueCallback<Uri[]> f1130;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ICustomEventCallback f1131;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final WebView f1132;

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

    public ChromeClientWrapper(WebView webView, EventCenter eventCenter) {
        Intrinsics.d(eventCenter, "mEventCenter");
        this.f1132 = webView;
        this.f1127 = eventCenter;
        this.autoRequestId = Environment.generateRequestId();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m9210() {
        WebView webView = this.f1132;
        if (webView == null) {
            return;
        }
        webView.loadUrl("javascript:window.addEventListener('DOMContentLoaded', function() {prompt('yz_prefs_action:dom_created');});");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean m9211(Context context, String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = f1125;
        }
        AbsChooserEvent.Meta meta = new AbsChooserEvent.Meta();
        meta.acceptType = str2;
        meta.requestId = this.autoRequestId;
        return this.f1127.dispatch(context, EventAPI.EVENT_FILE_CHOOSER, meta.toJSON());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean m9212(ValueCallback<Uri> valueCallback, String str) {
        this.f1129 = valueCallback;
        WebView webView = this.f1132;
        if (webView == null) {
            Intrinsics.a();
        }
        Context context = webView.getContext();
        Intrinsics.b(context, "mWebView!!.context");
        return m9211(context, str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean m9213(String str) {
        if (this.f1131 == null) {
            return false;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        List b = StringsKt.b(str2, new String[]{":"}, false, 0, 6, (Object) null);
        if (b != null) {
            Object[] array = b.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length != 2 || (!Intrinsics.a(f1126, strArr[0]))) {
                    return false;
                }
                if (Intrinsics.a(LOAD_PHASE_DOM_CREATED, strArr[1])) {
                    ICustomEventCallback iCustomEventCallback = this.f1131;
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
    private final boolean m9214(ValueCallback<Uri[]> valueCallback, String str) {
        this.f1130 = valueCallback;
        WebView webView = this.f1132;
        if (webView == null) {
            Intrinsics.a();
        }
        Context context = webView.getContext();
        Intrinsics.b(context, "mWebView!!.context");
        return m9211(context, str);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        WebChromeClient webChromeClient = this.f1128;
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
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        Intrinsics.d(valueCallback, bc.e.D);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.getVisitedHistory(valueCallback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.getVisitedHistory(valueCallback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onCloseWindow(WebView webView) {
        Intrinsics.d(webView, Context.WINDOW_SERVICE);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onCloseWindow(webView);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onCloseWindow(webView);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Intrinsics.d(consoleMessage, "consoleMessage");
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(message, ProcessBridgeProvider.KEY_RESULT_MSG);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onCreateWindow(webView, z, z2, message);
        }
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Intrinsics.d(str, "url");
        Intrinsics.d(str2, "databaseIdentifier");
        Intrinsics.d(quotaUpdater, "quotaUpdater");
        quotaUpdater.updateQuota((long) IntentFilter.MATCH_CATEGORY_PATH);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        WebChromeClient webChromeClient = this.f1128;
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
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        Intrinsics.d(str, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        Intrinsics.d(geolocationPermissionsCallback, bc.e.D);
        geolocationPermissionsCallback.invoke(str, true, false);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient webChromeClient = this.f1128;
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
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(str, "url");
        Intrinsics.d(str2, "message");
        Intrinsics.d(jsResult, "result");
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsAlert(webView, str, str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(str, "url");
        Intrinsics.d(str2, "message");
        Intrinsics.d(jsResult, "result");
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(str, "url");
        Intrinsics.d(str2, "message");
        Intrinsics.d(jsResult, "result");
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsConfirm(webView, str, str2, jsResult);
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(str, "url");
        Intrinsics.d(str2, "message");
        Intrinsics.d(str3, "defaultValue");
        Intrinsics.d(jsPromptResult, "result");
        if (m9213(str2)) {
            jsPromptResult.confirm(null);
            return true;
        }
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            return webChromeClient.onJsTimeout();
        }
        return super.onJsTimeout();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Intrinsics.d(webView, a.B);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onProgressChanged(webView, i);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onProgressChanged(webView, i);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        Intrinsics.d(quotaUpdater, "quotaUpdater");
        WebChromeClient webChromeClient = this.f1128;
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
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(bitmap, "icon");
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onReceivedIcon(webView, bitmap);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onReceivedIcon(webView, bitmap);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(str, "title");
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient != null) {
            if (webChromeClient == null) {
                Intrinsics.a();
            }
            webChromeClient.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
        m9210();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        Intrinsics.d(webView, a.B);
        Intrinsics.d(str, "url");
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onReceivedTouchIconUrl(webView, str, z);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onReceivedTouchIconUrl(webView, str, z);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onRequestFocus(WebView webView) {
        Intrinsics.d(webView, a.B);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onRequestFocus(webView);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onRequestFocus(webView);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onShowCustomView(View view, int i, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        Intrinsics.d(view, a.B);
        Intrinsics.d(customViewCallback, bc.e.D);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onShowCustomView(view, i, customViewCallback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onShowCustomView(view, i, customViewCallback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        Intrinsics.d(view, a.B);
        Intrinsics.d(customViewCallback, bc.e.D);
        WebChromeClient webChromeClient = this.f1128;
        if (webChromeClient == null) {
            super.onShowCustomView(view, customViewCallback);
            return;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        webChromeClient.onShowCustomView(view, customViewCallback);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        WebChromeClient webChromeClient;
        Intrinsics.d(webView, "webView");
        Intrinsics.d(fileChooserParams, "fileChooserParams");
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        if (m9214(valueCallback, (acceptTypes == null || acceptTypes.length <= 0) ? null : acceptTypes[0]) || (webChromeClient = this.f1128) == null) {
            return true;
        }
        if (webChromeClient == null) {
            Intrinsics.a();
        }
        return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback) {
        WebChromeClient webChromeClient;
        if (m9212(valueCallback, (String) null) || (webChromeClient = this.f1128) == null) {
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
        webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.f1128, valueCallback);
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        WebChromeClient webChromeClient;
        if (m9212(valueCallback, str) || (webChromeClient = this.f1128) == null) {
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
        webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.f1128, valueCallback, str);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        WebChromeClient webChromeClient;
        Intrinsics.d(str, "acceptType");
        Intrinsics.d(str2, "capture");
        if (m9212(valueCallback, str) || (webChromeClient = this.f1128) == null) {
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
        webChromeClient.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.f1128, valueCallback, str, str2);
    }

    public final void receiveImage(Intent intent) {
        try {
            if (this.f1129 != null) {
                Uri data = intent != null ? intent.getData() : null;
                ValueCallback<Uri> valueCallback = this.f1129;
                if (valueCallback == null) {
                    Intrinsics.a();
                }
                valueCallback.onReceiveValue(data);
            } else if (this.f1130 != null) {
                Uri[] uriArr = intent == null ? null : new Uri[]{Uri.parse(intent.getDataString())};
                ValueCallback<Uri[]> valueCallback2 = this.f1130;
                if (valueCallback2 == null) {
                    Intrinsics.a();
                }
                valueCallback2.onReceiveValue(uriArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ValueCallback valueCallback3 = null;
        this.f1130 = valueCallback3;
        this.f1129 = valueCallback3;
    }

    public final void setCustomEventCallback$yzsdkx5_release(ICustomEventCallback iCustomEventCallback) {
        this.f1131 = iCustomEventCallback;
    }

    public final void setDelegate(WebChromeClient webChromeClient) {
        if (webChromeClient instanceof ChromeClientWrapper) {
            return;
        }
        this.f1128 = webChromeClient;
    }
}
