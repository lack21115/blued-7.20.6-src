package com.anythink.expressad.mbbanner.a.e;

import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.h.o;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/e/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8041a = a.class.getSimpleName();
    private final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private boolean f8042c;

    private void a(final com.anythink.expressad.mbbanner.a.c.b bVar, final d dVar, final String str) {
        o.d(f8041a, "postCampaignSuccess unitId=".concat(String.valueOf(str)));
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    d dVar2 = dVar;
                    boolean unused = a.this.f8042c;
                    bVar2.a(dVar2);
                }
            }
        });
    }

    private void a(boolean z) {
        this.f8042c = z;
    }

    public final void a(final com.anythink.expressad.mbbanner.a.c.b bVar, final String str) {
        o.d(f8041a, "postResourceSuccess unitId=".concat(String.valueOf(str)));
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.3
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    boolean unused = a.this.f8042c;
                    bVar2.a();
                }
            }
        });
    }

    public final void a(final com.anythink.expressad.mbbanner.a.c.b bVar, final String str, final String str2) {
        String str3 = f8041a;
        o.b(str3, "postCampaignFail errorMsg=" + str + " unitId=" + str2);
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    String str4 = str;
                    boolean unused = a.this.f8042c;
                    bVar2.a(str4);
                }
            }
        });
    }

    public final void b(final com.anythink.expressad.mbbanner.a.c.b bVar, final String str) {
        o.d(f8041a, "postResourceFail unitId=".concat(String.valueOf(str)));
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.4
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    boolean unused = a.this.f8042c;
                    bVar2.b();
                }
            }
        });
    }
}
