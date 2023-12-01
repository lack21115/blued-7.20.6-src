package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/cache/c.class */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    protected static final Object f41067a = new Object();
    protected List<T> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected Context f41068c;
    private byte[] d;
    private byte[] e;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        this.f41068c = ContextDelegate.getContext(context);
        w b = w.b();
        b.a(this.f41068c);
        this.d = b.c();
        this.e = b.d();
        c();
    }

    private String b() {
        return y.b(this.f41068c).a(a(), null);
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
        } else if (str.length() > 10000) {
            p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
        } else {
            try {
                p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
                List<T> a2 = a(b(str));
                if (a2 != null) {
                    this.b.addAll(a2);
                }
            } catch (Exception e) {
                d();
                p.d("CacheSettings", p.a(e));
            }
        }
    }

    private void d(String str) {
        y.b(this.f41068c).b(a(), str);
    }

    protected abstract String a();

    protected abstract List<T> a(String str);

    abstract String b(String str);

    public final void c() {
        synchronized (f41067a) {
            g.a(a());
            this.b.clear();
            c(b());
        }
    }

    public final void d() {
        synchronized (f41067a) {
            this.b.clear();
            d("");
            p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] e() {
        byte[] bArr = this.d;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] f() {
        byte[] bArr = this.e;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }
}
