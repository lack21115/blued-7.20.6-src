package com.anythink.expressad.foundation.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.g.f.m;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.r;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/b/b.class */
public class b {
    private static final String g = "SDKController";
    private static volatile b h;
    private Context i;
    private String m;
    private int n;
    private String j = "";
    private String k = "";
    private boolean l = false;

    /* renamed from: a  reason: collision with root package name */
    public final int f7753a = 1;
    public final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public final int f7754c = 3;
    public final int d = 4;
    public final int e = 5;
    public final int f = 6;

    private b() {
    }

    public static b a() {
        if (h == null) {
            synchronized (b.class) {
                try {
                    if (h == null) {
                        h = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    private static void a(Context context) {
        String str;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(g.w, 0);
            String str2 = "";
            if (sharedPreferences != null) {
                str2 = sharedPreferences.getString(g.o.l, "");
                str = sharedPreferences.getString(g.o.m, "");
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(com.anythink.expressad.foundation.g.a.co) && TextUtils.isEmpty(com.anythink.expressad.foundation.g.a.cp)) {
                com.anythink.expressad.foundation.g.a.co = str2;
                com.anythink.expressad.foundation.g.a.cp = str;
            }
        } catch (Throwable th) {
            o.b(g, th.getMessage(), th);
        }
    }

    private static String b() {
        return com.anythink.expressad.out.b.f8067a;
    }

    private void c() {
        a.b().a(this.j);
        a.b().b(this.k);
        a.b().c();
        a(this.i.getApplicationContext());
        r.a(this.i);
        this.l = true;
    }

    private static void d() {
    }

    private void e() {
        a.b().a(this.j);
        a.b().b(this.k);
        a.b().c();
    }

    public final void a(Map map, final Context context) {
        if (context != null) {
            this.i = context.getApplicationContext();
            a.b().a(this.i);
            try {
                m.a(this.i);
            } catch (Exception e) {
            }
            n.a().a(new Runnable() { // from class: com.anythink.expressad.foundation.b.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    k.i(context);
                }
            }, 300L);
            if (map != null) {
                if (map.containsKey(com.anythink.expressad.a.d)) {
                    this.j = (String) map.get(com.anythink.expressad.a.d);
                }
                if (map.containsKey(com.anythink.expressad.a.e)) {
                    this.k = (String) map.get(com.anythink.expressad.a.e);
                }
                a.b().a(this.j);
                a.b().b(this.k);
                a.b().c();
                a(this.i.getApplicationContext());
                r.a(this.i);
                this.l = true;
            }
        }
    }
}
