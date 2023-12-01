package com.opos.mobad.service.d;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.opos.mobad.b.a.ae;
import com.opos.mobad.b.a.af;
import com.opos.mobad.service.h.b;
import java.io.IOException;
import okio.BufferedSource;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27325a;
    private ae.a b;

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, C0732a> f27326c = new LruCache<>(100);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.service.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/d/a$a.class */
    public static class C0732a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f27329a;
        private final long b;

        public C0732a(boolean z, long j) {
            this.f27329a = z;
            this.b = j;
        }
    }

    private void a(String str, C0732a c0732a) {
        if (c0732a == null || a(c0732a)) {
            b(str);
        }
    }

    private boolean a(C0732a c0732a) {
        return c0732a == null || SystemClock.elapsedRealtime() >= c0732a.b;
    }

    private void b(final String str) {
        if (this.b == null || TextUtils.isEmpty("https://adx.ads.heytapmobi.com/show/frequency/req/check")) {
            return;
        }
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.service.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                String str2;
                boolean z;
                b.C0737b a2 = com.opos.mobad.service.h.b.a(a.this.f27325a, "https://adx.ads.heytapmobi.com/show/frequency/req/check", a.this.b.a(com.opos.mobad.service.h.a.a(a.this.f27325a)).a(com.opos.mobad.service.h.a.a()).a(com.opos.mobad.service.h.a.b()).a(com.opos.mobad.service.h.a.b(a.this.f27325a)).c(str).b().b(), new b.a<af>() { // from class: com.opos.mobad.service.d.a.1.1
                    @Override // com.opos.mobad.service.h.b.a
                    /* renamed from: a */
                    public af b(BufferedSource bufferedSource) throws IOException {
                        return af.f25700c.a(bufferedSource);
                    }
                });
                com.opos.cmn.an.f.a.b("StateManager", "refresh:" + a2.f27378a + "," + a2.f27379c);
                if (a2.f27378a != 200 || a2.f27379c == 0) {
                    return;
                }
                if (((af) a2.f27379c).f.intValue() == 0) {
                    aVar = a.this;
                    str2 = str;
                    z = true;
                } else if (((af) a2.f27379c).f.intValue() != 1035) {
                    return;
                } else {
                    aVar = a.this;
                    str2 = str;
                    z = false;
                }
                aVar.b(str2, z, ((af) a2.f27379c).g.intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, int i) {
        com.opos.cmn.an.f.a.b("StateManager", "update, " + str + ", " + z + "," + i);
        this.f27326c.put(str, new C0732a(z, SystemClock.elapsedRealtime() + ((long) i)));
    }

    public void a(Context context, String str, String str2, int i, int i2) {
        synchronized (this) {
            if (context != null) {
                if (!TextUtils.isEmpty(str) && this.f27325a == null) {
                    this.f27325a = context;
                    this.b = new ae.a().a(str).b(str2).a(Integer.valueOf(i)).b(Integer.valueOf(i2)).d(context.getPackageName());
                }
            }
        }
    }

    public void a(String str, boolean z, int i) {
        b(str, z, i);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0732a c0732a = this.f27326c.get(str);
        if (c0732a != null) {
            if (c0732a.f27329a) {
                a(str, c0732a);
                return true;
            } else if (!a(c0732a)) {
                return false;
            }
        }
        b(str);
        return true;
    }
}
