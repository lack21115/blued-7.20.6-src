package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeWebViewCookie.class */
public class WeWebViewCookie implements WeCookie {
    private Context b;

    public WeWebViewCookie(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("ctx 不能为null");
        }
        this.b = context;
        CookieSyncManager.createInstance(context.getApplicationContext());
        CookieManager.getInstance();
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeCookie
    public void clearCookie() {
        CookieManager.getInstance().removeAllCookie();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        Cookie parse;
        synchronized (this) {
            String cookie = CookieManager.getInstance().getCookie(httpUrl.toString());
            if (cookie == null) {
                return Collections.emptyList();
            }
            String[] split = cookie.split(";");
            ArrayList arrayList = new ArrayList();
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return arrayList;
                }
                String str = split[i2];
                if (str != null && (parse = Cookie.parse(httpUrl, str)) != null) {
                    arrayList.add(parse);
                }
                i = i2 + 1;
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() != 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            CookieSyncManager.getInstance().sync();
                            return;
                        } else {
                            CookieManager.getInstance().setCookie(httpUrl.toString(), list.get(i2).toString());
                            i = i2 + 1;
                        }
                    }
                }
            }
        }
    }
}
