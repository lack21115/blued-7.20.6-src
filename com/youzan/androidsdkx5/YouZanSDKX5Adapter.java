package com.youzan.androidsdkx5;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebStorage;
import com.youzan.androidsdk.WebViewCompat;
import com.youzan.androidsdk.YouzanLog;
import com.youzan.androidsdk.YouzanSDKAdapter;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.account.Token;
import com.youzan.androidsdk.tool.HttpCookie;
import com.youzan.androidsdk.tool.UserAgent;
import com.youzan.spiderman.cache.SpiderCacheCallback;
import com.youzan.x5web.YZWebSDK;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/YouZanSDKX5Adapter.class */
public class YouZanSDKX5Adapter extends YouzanSDKAdapter {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f1103 = ";";

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f1104 = "Sat, 31 Dec 2016 23:59:59 GMT";

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Set<String> m9203(String str) {
        HashSet hashSet;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(";");
            HashSet hashSet2 = new HashSet(split.length);
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                hashSet = hashSet2;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                if (str2.contains("=")) {
                    hashSet2.add(str2.split("=", 2)[0].trim());
                }
                i = i2 + 1;
            }
        } else {
            hashSet = null;
        }
        return hashSet;
    }

    @Override // com.youzan.androidsdk.YouzanSDKAdapter
    public void clearCookieByHost(Context context, String str) {
        try {
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            String str2 = "https://." + str;
            Set<String> m9203 = m9203(cookieManager.getCookie(str2));
            if (m9203 != null) {
                for (String str3 : m9203) {
                    cookieManager.setCookie(str2, str3 + "=; Expires=" + f1104);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.youzan.androidsdk.YouzanSDKAdapter
    public void clearLocalStorage() {
        try {
            WebStorage.getInstance().deleteAllData();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.youzan.androidsdk.YouzanSDKAdapter
    public void initWeb() {
        YZWebSDK.preInitX5(this.ctx);
        YZWebSDK.init(this.ctx, "appsdk", new SpiderCacheCallback() { // from class: com.youzan.androidsdkx5.YouZanSDKX5Adapter.1
            @Override // com.youzan.spiderman.cache.SpiderCacheCallback
            public void onCustomRequestHeader(String str, Map<String, String> map) {
                try {
                    CookieSyncManager.createInstance(YouZanSDKX5Adapter.this.ctx);
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
            }

            @Override // com.youzan.spiderman.cache.SpiderCacheCallback
            public String onTokenInactive(String str) {
                String accessToken = Token.getAccessToken();
                if (accessToken == null || accessToken.equals(str)) {
                    return null;
                }
                return accessToken;
            }

            @Override // com.youzan.spiderman.cache.SpiderCacheCallback
            public String onTokenNeeded() {
                return Token.getAccessToken();
            }
        });
        YZWebSDK.preloadModifyFromRemote(this.ctx);
    }

    @Override // com.youzan.androidsdk.YouzanSDKAdapter
    public void loadConversation(WebViewCompat webViewCompat, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        webViewCompat.loadUrl("https://h5.youzan.com/v2/im?c=wsc&v=2&kdt_id=" + str + "#talk!id=" + str + "&t=" + currentTimeMillis);
    }

    @Override // com.youzan.androidsdk.YouzanSDKAdapter
    public void saveCookies(Context context, List<HttpCookie> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            for (HttpCookie httpCookie : list) {
                cookieManager.setCookie("https://." + httpCookie.domain(), httpCookie.toString());
            }
            cookieManager.flush();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
                CookieSyncManager.getInstance().sync();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.youzan.androidsdk.YouzanSDKAdapter
    public void sync(Context context, YouzanToken youzanToken) {
        super.sync(context, youzanToken);
        YZWebSDK.syncToken(youzanToken.getAccessToken());
    }

    @Override // com.youzan.androidsdk.YouzanSDKAdapter
    public void userLogout(Context context) {
        super.userLogout(context);
    }
}
