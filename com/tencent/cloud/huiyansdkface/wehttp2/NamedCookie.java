package com.tencent.cloud.huiyansdkface.wehttp2;

import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/NamedCookie.class */
public class NamedCookie {

    /* renamed from: a  reason: collision with root package name */
    private Cookie f22404a;

    NamedCookie(Cookie cookie) {
        this.f22404a = cookie;
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
        return this.f22404a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NamedCookie) {
            NamedCookie namedCookie = (NamedCookie) obj;
            boolean z = false;
            if (namedCookie.f22404a.name().equals(this.f22404a.name())) {
                z = false;
                if (namedCookie.f22404a.domain().equals(this.f22404a.domain())) {
                    z = false;
                    if (namedCookie.f22404a.path().equals(this.f22404a.path())) {
                        z = false;
                        if (namedCookie.f22404a.secure() == this.f22404a.secure()) {
                            z = false;
                            if (namedCookie.f22404a.hostOnly() == this.f22404a.hostOnly()) {
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
        return ((((((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.f22404a.name().hashCode()) * 31) + this.f22404a.domain().hashCode()) * 31) + this.f22404a.path().hashCode()) * 31) + (!this.f22404a.secure())) * 31) + (!this.f22404a.hostOnly());
    }
}
