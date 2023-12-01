package com.sobot.network.http.cookie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/cookie/SimpleCookieJar.class */
public final class SimpleCookieJar implements CookieJar {
    private final Set<Cookie> allCookies = new HashSet();

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (Cookie cookie : this.allCookies) {
                if (cookie.matches(httpUrl)) {
                    arrayList.add(cookie);
                }
            }
        }
        return arrayList;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        synchronized (this) {
            ArrayList<Cookie> arrayList = new ArrayList(this.allCookies);
            this.allCookies.addAll(list);
            ArrayList arrayList2 = new ArrayList();
            for (Cookie cookie : list) {
                for (Cookie cookie2 : arrayList) {
                    if (cookie2.name().equals(cookie.name())) {
                        arrayList2.add(cookie2);
                    }
                }
            }
            this.allCookies.removeAll(arrayList2);
        }
    }
}
