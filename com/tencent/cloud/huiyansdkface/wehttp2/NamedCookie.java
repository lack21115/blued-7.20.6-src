package com.tencent.cloud.huiyansdkface.wehttp2;

import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/NamedCookie.class */
public class NamedCookie {

    /* renamed from: a  reason: collision with root package name */
    private Cookie f36095a;

    NamedCookie(Cookie cookie) {
        this.f36095a = cookie;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<NamedCookie> a(Collection<Cookie> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Cookie cookie : collection) {
            arrayList.add(new NamedCookie(cookie));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cookie a() {
        return this.f36095a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NamedCookie) {
            NamedCookie namedCookie = (NamedCookie) obj;
            boolean z = false;
            if (namedCookie.f36095a.name().equals(this.f36095a.name())) {
                z = false;
                if (namedCookie.f36095a.domain().equals(this.f36095a.domain())) {
                    z = false;
                    if (namedCookie.f36095a.path().equals(this.f36095a.path())) {
                        z = false;
                        if (namedCookie.f36095a.secure() == this.f36095a.secure()) {
                            z = false;
                            if (namedCookie.f36095a.hostOnly() == this.f36095a.hostOnly()) {
                                z = true;
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.f36095a.name().hashCode()) * 31) + this.f36095a.domain().hashCode()) * 31) + this.f36095a.path().hashCode()) * 31) + (!this.f36095a.secure())) * 31) + (!this.f36095a.hostOnly());
    }
}
