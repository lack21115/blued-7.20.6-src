package com.tencent.open.yyb;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.applog.util.WebViewJsUtil;
import com.huawei.hms.ads.fw;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.bc;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.a.f;
import com.tencent.open.utils.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/AppbarJsBridge.class */
public class AppbarJsBridge {
    public static final int AUTHORIZE_FAIL = -5;
    public static final String BUTTON_CLICK_CALLBACK_FUNCTION_NAME = "clickCallback";
    public static final String CALLBACK_LOGIN = "loginCallback";
    public static final String CALLBACK_SHARE = "shareCallback";
    public static final int Code_Java_Exception = -3;
    public static final int Code_None = -2;
    public static final int JSBRIDGE_VERSION = 1;
    public static final String JS_BRIDGE_SCHEME = "jsb://";
    public static final String READY_CALLBACK_FUNCTION_NAME = "readyCallback";
    public static final int Result_Fail = -1;
    public static final int Result_OK = 0;
    public static final int SHARE_QQ = 1;
    public static final int SHARE_QZ = 2;
    public static final int SHARE_TIMELINE = 4;
    public static final int SHARE_WX = 3;

    /* renamed from: a  reason: collision with root package name */
    private WebView f24614a;
    private Activity b;

    public AppbarJsBridge(Activity activity, WebView webView) {
        this.b = activity;
        this.f24614a = webView;
    }

    private void a(Uri uri, String str, int i, String str2) {
        f.a("openSDK_LOG.AppbarJsBridge", "-->callAMethod : uri = " + uri);
        if (!a(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            responseFail(str2, i, str, -5);
            return;
        }
        try {
            AppbarJsBridge.class.getDeclaredMethod(str, Uri.class, Integer.TYPE, String.class, String.class).invoke(this, uri, Integer.valueOf(i), str, str2);
        } catch (Exception e) {
            f.a("openSDK_LOG.AppbarJsBridge", "-->callAMethod : Exception = ", e);
            e.printStackTrace();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            responseFail(str2, i, str, -3);
        }
    }

    private boolean a(String str) {
        return true;
    }

    public void callback(String str, String str2) {
        if (this.f24614a != null) {
            StringBuffer stringBuffer = new StringBuffer(WebViewJsUtil.JS_URL_PREFIX);
            stringBuffer.append("if(!!");
            stringBuffer.append(str);
            stringBuffer.append("){");
            stringBuffer.append(str);
            stringBuffer.append("(");
            stringBuffer.append(str2);
            stringBuffer.append(")}");
            Tracker.loadUrl(this.f24614a, stringBuffer.toString());
        }
    }

    public void clickCallback() {
        response(BUTTON_CLICK_CALLBACK_FUNCTION_NAME, 0, null, "");
    }

    public void closeWebView(Uri uri, int i, String str, String str2) {
        f.a("openSDK_LOG.AppbarJsBridge", "-->closeWebView : url = " + uri);
        this.b.finish();
    }

    public void getAppInfo(Uri uri, int i, String str, String str2) {
        String[] split;
        String queryParameter = uri.getQueryParameter("packagenames");
        f.b("openSDK_LOG.AppbarJsBridge", "-->getAppInfo : packageNames = " + queryParameter);
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(str2) || (split = queryParameter.split(",")) == null || split.length == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                f.a("openSDK_LOG.AppbarJsBridge", "-->getAppInfo : result = " + jSONObject.toString());
                response(str2, i, str, jSONObject.toString());
                return;
            }
            String trim = split[i3].trim();
            PackageInfo packageInfo = null;
            try {
                packageInfo = this.b.getPackageManager().getPackageInfo(trim, 0);
            } catch (PackageManager.NameNotFoundException e) {
                f.b("openSDK_LOG.AppbarJsBridge", "-->getAppInfo : NameNotFoundException e1", e);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (packageInfo != null) {
                    jSONObject2.put("install", 1);
                    jSONObject2.put("appName", packageInfo.applicationInfo.name);
                    jSONObject2.put("verCode", packageInfo.versionCode);
                    jSONObject2.put("verName", packageInfo.versionName);
                } else {
                    jSONObject2.put("install", 0);
                }
                jSONObject.put(trim, jSONObject2);
            } catch (Exception e2) {
                responseFail(str2, i, str, -3);
            }
            i2 = i3 + 1;
        }
    }

    public int getVersion() {
        return 1;
    }

    public void invoke(String str) {
        int i;
        f.a("openSDK_LOG.AppbarJsBridge", "-->invoke : url = " + str);
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        f.a("openSDK_LOG.AppbarJsBridge", "-->invoke : hostAsMethodName = " + host);
        if (TextUtils.isEmpty(host)) {
            return;
        }
        List<String> pathSegments = parse.getPathSegments();
        String str2 = null;
        if (pathSegments == null || pathSegments.size() <= 0) {
            i = 0;
        } else {
            int parseIntValue = Util.parseIntValue(pathSegments.get(0));
            i = parseIntValue;
            if (pathSegments.size() > 1) {
                str2 = pathSegments.get(1);
                i = parseIntValue;
            }
        }
        f.a("openSDK_LOG.AppbarJsBridge", "-->invoke : seqid = " + i + " callbackName = " + str2);
        if (!host.equals("callBatch")) {
            a(parse, host, i, str2);
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(parse.getQueryParameter(RemoteMessageConst.MessageBody.PARAM));
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("method");
                int i3 = jSONObject.getInt("seqid");
                String optString = jSONObject.optString(bc.e.D);
                JSONObject jSONObject2 = jSONObject.getJSONObject(ProcessBridgeProvider.KEY_ARGS);
                StringBuilder sb = new StringBuilder();
                sb.append(JS_BRIDGE_SCHEME);
                sb.append(string);
                sb.append("/");
                sb.append(i3);
                sb.append("/");
                sb.append(!TextUtils.isEmpty(optString) ? optString : "");
                sb.append("?");
                if (jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String decode = Uri.decode(jSONObject2.getString(next));
                        sb.append(next);
                        sb.append("=");
                        sb.append(Uri.encode(decode));
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                }
                a(Uri.parse(sb.toString()), string, i3, optString);
            }
        } catch (Exception e) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            responseFail(str2, i, host, -5);
        }
    }

    public void openLoginActivity(Uri uri, int i, String str, String str2) {
        f.a("openSDK_LOG.AppbarJsBridge", "-->openLoginActivity : url = " + uri);
        ((AppbarActivity) this.b).login();
    }

    public void openNewWindow(Uri uri, int i, String str, String str2) {
        String queryParameter = uri.getQueryParameter("url");
        try {
            Intent intent = new Intent(this.b, AppbarActivity.class);
            intent.putExtra("url", queryParameter);
            this.b.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pageControl(Uri uri, int i, String str, String str2) {
        f.a("openSDK_LOG.AppbarJsBridge", "-->pageControl : url = " + uri);
        int parseIntValue = Util.parseIntValue(uri.getQueryParameter("type"));
        WebView webView = this.f24614a;
        if (webView != null) {
            if (parseIntValue == 1) {
                webView.goBack();
            } else if (parseIntValue == 2) {
                webView.goForward();
            } else {
                webView.reload();
            }
        }
        response(str2, i, str, "");
    }

    public void ready() {
        response(READY_CALLBACK_FUNCTION_NAME, 1, null, fw.Code);
    }

    public void response(String str, int i, String str2, String str3) {
        response(str, i, str2, str3, null);
    }

    public void response(String str, int i, String str2, String str3, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", 0);
            jSONObject.put("data", str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("method", str2);
            }
            jSONObject.put("seqid", i);
            if (map != null) {
                for (String str4 : map.keySet()) {
                    jSONObject.put(str4, map.get(str4));
                }
            }
            callback(str, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void responseFail(String str, int i, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", -1);
            jSONObject.put("code", i2);
            jSONObject.put("method", str2);
            jSONObject.put("seqid", i);
            callback(str, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void responseShare(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", i + "");
        response(CALLBACK_SHARE, 0, null, "0", hashMap);
    }

    public void responseShareFail(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", i + "");
        response(CALLBACK_SHARE, 0, null, "1", hashMap);
    }

    public void setWebView(Uri uri, int i, String str, String str2) {
        try {
            String queryParameter = uri.getQueryParameter("title");
            boolean z = false;
            int parseIntValue = Util.parseIntValue(uri.getQueryParameter("buttonVisible"), 0);
            if (!TextUtils.isEmpty(queryParameter)) {
                ((AppbarActivity) this.b).setAppbarTitle(queryParameter);
            }
            AppbarActivity appbarActivity = (AppbarActivity) this.b;
            if (parseIntValue == 1) {
                z = true;
            }
            appbarActivity.setShareVisibility(z);
            f.a("openSDK_LOG.AppbarJsBridge", "-->setWebView : url = " + uri + " -- buttonVisiable = " + parseIntValue);
            response(str2, i, str, "");
        } catch (Exception e) {
            responseFail(str2, i, str, -3);
        }
    }

    public void share(Uri uri, int i, String str, String str2) {
        f.a("openSDK_LOG.AppbarJsBridge", "-->share : url = " + uri);
        String queryParameter = uri.getQueryParameter("title");
        String queryParameter2 = uri.getQueryParameter("summary");
        String queryParameter3 = uri.getQueryParameter(DBDefinition.ICON_URL);
        String str3 = queryParameter3;
        if (TextUtils.isEmpty(queryParameter3)) {
            str3 = "http://qzs.qq.com/open/mobile/jsbridge/demo.htm";
        }
        String queryParameter4 = uri.getQueryParameter("jumpUrl");
        f.a("openSDK_LOG.AppbarJsBridge", "-->share : title = " + queryParameter);
        f.a("openSDK_LOG.AppbarJsBridge", "-->share : summary = " + queryParameter2);
        f.a("openSDK_LOG.AppbarJsBridge", "-->share : iconUrl = " + str3);
        f.a("openSDK_LOG.AppbarJsBridge", "-->share : jumpUrl = " + queryParameter4);
        ShareModel shareModel = new ShareModel();
        shareModel.f24615a = queryParameter;
        shareModel.b = queryParameter2;
        shareModel.f24616c = str3;
        shareModel.d = queryParameter4;
        ((AppbarActivity) this.b).setShareModel(shareModel);
        int parseIntValue = Util.parseIntValue(uri.getQueryParameter("type"), 0);
        if (parseIntValue == 1) {
            ((AppbarActivity) this.b).shareToQQ();
        } else if (parseIntValue == 2) {
            ((AppbarActivity) this.b).shareToQzone();
        } else if (parseIntValue == 3) {
            ((AppbarActivity) this.b).shareToWX();
        } else if (parseIntValue != 4) {
            ((AppbarActivity) this.b).showFloatingDialog();
        } else {
            ((AppbarActivity) this.b).shareToTimeline();
        }
    }
}
