package com.anythink.basead.d;

import com.anythink.core.api.BaseAd;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5979a = i.class.getSimpleName();
    private Map<String, BaseAd> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/i$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final i f5980a = new i((byte) 0);

        private a() {
        }
    }

    private i() {
        this.b = new HashMap(2);
    }

    /* synthetic */ i(byte b) {
        this();
    }

    public static i a() {
        return a.f5980a;
    }

    public final BaseAd a(String str) {
        return this.b.remove(str);
    }

    public final void a(String str, BaseAd baseAd) {
        this.b.put(str, baseAd);
    }
}
