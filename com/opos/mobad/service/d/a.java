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
    private Context f13637a;
    private ae.a b;

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, C0562a> f13638c = new LruCache<>(100);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.service.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/d/a$a.class */
    public static class C0562a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f13641a;
        private final long b;

        public C0562a(boolean z, long j) {
            this.f13641a = z;
            this.b = j;
        }
    }

    private void a(String str, C0562a c0562a) {
        if (c0562a == null || a(c0562a)) {
            b(str);
        }
    }

    private boolean a(C0562a c0562a) {
        return c0562a == null || SystemClock.elapsedRealtime() >= c0562a.b;
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
                b.C0567b a2 = com.opos.mobad.service.h.b.a(a.this.f13637a, "https://adx.ads.heytapmobi.com/show/frequency/req/check", a.this.b.a(com.opos.mobad.service.h.a.a(a.this.f13637a)).a(com.opos.mobad.service.h.a.a()).a(com.opos.mobad.service.h.a.b()).a(com.opos.mobad.service.h.a.b(a.this.f13637a)).c(str).b().b(), new b.a<af>() { // from class: com.opos.mobad.service.d.a.1.1
                    @Override // com.opos.mobad.service.h.b.a
                    /* renamed from: a */
                    public af b(BufferedSource bufferedSource) throws IOException {
                        return af.f12012c.a(bufferedSource);
                    }
                });
                com.opos.cmn.an.f.a.b("StateManager", "refresh:" + a2.f13690a + "," + a2.f13691c);
                if (a2.f13690a != 200 || a2.f13691c == 0) {
                    return;
                }
                if (((af) a2.f13691c).f.intValue() == 0) {
                    aVar = a.this;
                    str2 = str;
                    z = true;
                } else if (((af) a2.f13691c).f.intValue() != 1035) {
                    return;
                } else {
                    aVar = a.this;
                    str2 = str;
                    z = false;
                }
                aVar.b(str2, z, ((af) a2.f13691c).g.intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, int i) {
        com.opos.cmn.an.f.a.b("StateManager", "update, " + str + ", " + z + "," + i);
        this.f13638c.put(str, new C0562a(z, SystemClock.elapsedRealtime() + ((long) i)));
    }

    public void a(Context context, String str, String str2, int i, int i2) {
        synchronized (this) {
            if (context != null) {
                if (!TextUtils.isEmpty(str) && this.f13637a == null) {
                    this.f13637a = context;
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
        C0562a c0562a = this.f13638c.get(str);
        if (c0562a != null) {
            if (c0562a.f13641a) {
                a(str, c0562a);
                return true;
            } else if (!a(c0562a)) {
                return false;
            }
        }
        b(str);
        return true;
    }
}
