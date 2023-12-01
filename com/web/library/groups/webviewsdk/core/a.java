package com.web.library.groups.webviewsdk.core;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import com.bytedance.applog.util.WebViewJsUtil;
import com.web.library.groups.webviewsdk.a.b;
import com.web.library.groups.webviewsdk.photo.ShowPhotoActivity;
import com.weimob.library.groups.wjson.WJSON;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/core/a.class */
public final class a implements Serializable {
    protected Context context = null;
    protected WMWebView webView = null;
    private HashMap<String, Boolean> allowImageMimeTypeMap = new HashMap() { // from class: com.web.library.groups.webviewsdk.core.a.1
        {
            put("png", true);
            put("bmp", true);
            put("jpg", true);
            put("jpeg", true);
        }
    };

    public a(Context context, WMWebView wMWebView) {
        init(context, wMWebView);
    }

    private void a() {
        WMWebView wMWebView = this.webView;
        if (wMWebView != null) {
            wMWebView.a();
        }
    }

    private void a(String str) {
        int i;
        com.web.library.groups.webviewsdk.a.a param = ((b) WJSON.parseObject(str, (Class<Object>) b.class)).getParam();
        if (param == null || param.getUrls() == null || param.getUrls().size() <= 0) {
            return;
        }
        List<String> urls = param.getUrls();
        ArrayList arrayList = new ArrayList();
        int currentPosition = param.getCurrentPosition();
        int i2 = 0;
        while (i2 < urls.size()) {
            String str2 = urls.get(i2);
            if (this.allowImageMimeTypeMap.get(MimeTypeMap.getFileExtensionFromUrl(str2).toLowerCase()).booleanValue()) {
                arrayList.add(str2);
                i = currentPosition;
            } else if (currentPosition == i2) {
                i = 0;
            } else {
                i = currentPosition;
                if (currentPosition > i2) {
                    i = currentPosition - 1;
                }
            }
            i2++;
            currentPosition = i;
        }
        if (currentPosition < 0 || currentPosition > arrayList.size()) {
            param.setCurrentPosition(0);
        }
        if (arrayList.size() > 0) {
            ShowPhotoActivity.a(this.context, arrayList, currentPosition, 1);
        }
    }

    private void b() {
    }

    @JavascriptInterface
    public void action(String str) {
        boolean z;
        String str2 = (String) ((HashMap) WJSON.parseObject(str, (Class<Object>) HashMap.class)).get("action");
        int hashCode = str2.hashCode();
        if (hashCode != -2015087523) {
            if (hashCode == -1291638428 && str2.equals("previewFile")) {
                z = true;
            }
            z = true;
        } else {
            if (str2.equals("authExpired")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            Log.e("onAuthExpired===> ", "onAuthExpired");
            a();
        } else if (!z) {
        } else {
            a(str);
        }
    }

    public void callJavaScript(String str, String str2, String str3) {
        if (this.webView != null) {
            Log.e("callJavaScript===>", WebViewJsUtil.JS_URL_PREFIX + str3 + "." + str + "(" + str2 + ")");
            WMWebView wMWebView = this.webView;
            wMWebView.loadUrl(WebViewJsUtil.JS_URL_PREFIX + str3 + "." + str + "(" + str2 + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void callPhone(String str) {
        try {
            this.context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(Context context, WMWebView wMWebView) {
        this.context = context;
        this.webView = wMWebView;
    }

    public void release() {
        b();
        this.webView = null;
    }
}
