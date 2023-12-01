package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/MemoryCookieJar.class */
public class MemoryCookieJar implements WeCookie, Iterable<Cookie> {
    private HashSet<NamedCookie> b = new HashSet<>();

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeCookie
    public void clearCookie() {
        this.b.clear();
    }

    @Override // java.lang.Iterable
    public Iterator<Cookie> iterator() {
        final Iterator<NamedCookie> it = this.b.iterator();
        return new Iterator<Cookie>() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.MemoryCookieJar.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Cookie next() {
                return ((NamedCookie) it.next()).a();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }
        };
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            Iterator<Cookie> it = iterator();
            while (it.hasNext()) {
                Cookie next = it.next();
                if (next.expiresAt() < System.currentTimeMillis()) {
                    it.remove();
                } else if (next.matches(httpUrl)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        synchronized (this) {
            for (NamedCookie namedCookie : NamedCookie.a(list)) {
                this.b.remove(namedCookie);
                this.b.add(namedCookie);
            }
        }
    }
}
