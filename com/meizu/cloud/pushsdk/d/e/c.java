package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import android.os.Build;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/e/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24123a = c.class.getSimpleName();
    private final HashMap<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Object> f24124c;
    private final HashMap<String, String> d;

    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/e/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f24125a = null;

        public a a(Context context) {
            this.f24125a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private c(a aVar) {
        this.b = new HashMap<>();
        this.f24124c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.f24125a != null) {
            a(aVar.f24125a);
        }
        com.meizu.cloud.pushsdk.d.f.c.c(f24123a, "Subject created successfully.", new Object[0]);
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.d.put(str, str2);
    }

    private void d() {
        a(com.anythink.expressad.foundation.g.a.J, "android-" + Build.VERSION.RELEASE);
    }

    private void e() {
        a(com.anythink.expressad.foundation.g.a.F, Build.DISPLAY);
    }

    private void f() {
        a("dm", Build.MODEL);
    }

    private void g() {
        a("df", Build.MANUFACTURER);
    }

    public Map<String, Object> a() {
        return this.f24124c;
    }

    public void a(Context context) {
        b(context);
    }

    public Map<String, String> b() {
        return this.d;
    }

    public void b(Context context) {
        String b = e.b(context);
        if (b != null) {
            a(com.igexin.push.core.b.Y, b);
        }
    }

    public Map<String, String> c() {
        return this.b;
    }
}
