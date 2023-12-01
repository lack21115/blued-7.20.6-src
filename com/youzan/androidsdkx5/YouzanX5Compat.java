package com.youzan.androidsdkx5;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.youzan.androidsdk.WebViewCompat;
import com.youzan.androidsdk.YouzanLog;
import com.youzan.androidsdk.tool.WebParameter;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouzanX5Compat.class */
public class YouzanX5Compat extends WebViewCompat {

    /* renamed from: ˊ  reason: contains not printable characters */
    private WebView f1122;

    public YouzanX5Compat(WebView webView) {
        this.f1122 = webView;
    }

    @Override // com.youzan.androidsdk.WebViewCompat
    public Context getContext() {
        return this.f1122.getContext();
    }

    @Override // com.youzan.androidsdk.WebViewCompat
    public String getPreviousUrl() {
        WebView webView = this.f1122;
        String str = null;
        if (webView != null) {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            int currentIndex = copyBackForwardList.getCurrentIndex();
            int i = currentIndex > 0 ? currentIndex - 1 : -1;
            str = null;
            if (i >= 0) {
                WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(i);
                str = null;
                if (itemAtIndex != null) {
                    str = itemAtIndex.getUrl();
                }
            }
        }
        return str;
    }

    @Override // com.youzan.androidsdk.WebViewCompat
    public void initWebViewParameter() {
        WebView webView = this.f1122;
        if (webView == null) {
            return;
        }
        webView.setOverScrollMode(2);
        try {
            Context context = this.f1122.getContext();
            WebSettings settings = this.f1122.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(-1);
            settings.setTextZoom(100);
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            if (Build.VERSION.SDK_INT < 19) {
                settings.setDatabasePath(context.getApplicationContext().getDir(WebParameter.PATH_DATABASE, 0).getPath());
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(context.getFilesDir().getPath());
        } catch (Throwable th) {
            YouzanLog.w("WARNING: init WebView Failed");
            th.printStackTrace();
        }
    }

    @Override // com.youzan.androidsdk.WebViewCompat
    public void loadUrl(String str) {
        this.f1122.loadUrl(str);
    }

    @Override // com.youzan.androidsdk.WebViewCompat
    public void removeJavascriptInterface(String str) {
        this.f1122.removeJavascriptInterface(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
        if (r4 != 0) goto L14;
     */
    @Override // com.youzan.androidsdk.WebViewCompat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean validPreviousUrl() {
        /*
            r3 = this;
            r0 = r3
            com.tencent.smtt.sdk.WebView r0 = r0.f1122
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L51
            r0 = r7
            com.tencent.smtt.sdk.WebBackForwardList r0 = r0.copyBackForwardList()
            r7 = r0
            r0 = r7
            int r0 = r0.getCurrentIndex()
            r4 = r0
            r0 = r4
            if (r0 <= 0) goto L27
            r0 = r4
            r1 = 1
            int r0 = r0 - r1
            r4 = r0
            goto L29
        L27:
            r0 = -1
            r4 = r0
        L29:
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 < 0) goto L51
            r0 = r7
            r1 = r4
            com.tencent.smtt.sdk.WebHistoryItem r0 = r0.getItemAtIndex(r1)
            r7 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L51
            r0 = r7
            java.lang.String r0 = r0.getUrl()
            boolean r0 = com.youzan.androidsdk.tool.WebParameter.shouldSkipUrl(r0)
            if (r0 == 0) goto L4f
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L51
        L4f:
            r0 = 1
            r5 = r0
        L51:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youzan.androidsdkx5.YouzanX5Compat.validPreviousUrl():boolean");
    }

    @Override // com.youzan.androidsdk.WebViewCompat
    public void webViewUAConfiguration(WebViewCompat webViewCompat, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            YouzanLog.w("UserAgent Is Null");
            return;
        }
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        WebSettings settings = this.f1122.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " " + str + " " + str3);
    }
}
