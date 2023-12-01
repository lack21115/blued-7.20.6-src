package com.anythink.basead.f;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/c.class */
public abstract class c implements a {
    public static final String h = "extra_request_id";
    public static final String i = "extra_scenario";
    public static final String j = "extra_orientation";
    public String b = getClass().getSimpleName();
    protected Context c;
    protected j d;
    protected String e;
    protected boolean f;
    protected s g;

    public c(Context context, j jVar, String str, boolean z) {
        this.c = context.getApplicationContext();
        this.d = jVar;
        this.e = str;
        this.f = z;
    }

    private com.anythink.basead.c.e b() {
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d.b)) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.u);
        }
        s a = com.anythink.basead.f.a.a.a(this.c).a(this.d.b, this.e);
        this.g = a;
        if (a == null) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.x);
        }
        if (this.d.m == null) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.j, com.anythink.basead.c.f.y);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0067 A[Catch: Exception -> 0x0092, TRY_ENTER, TryCatch #0 {Exception -> 0x0092, blocks: (B:2:0x0000, B:4:0x000c, B:7:0x001c, B:9:0x003b, B:16:0x0067, B:18:0x006f, B:10:0x0046, B:12:0x0050, B:13:0x005b), top: B:24:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[Catch: Exception -> 0x0092, TRY_ENTER, TryCatch #0 {Exception -> 0x0092, blocks: (B:2:0x0000, B:4:0x000c, B:7:0x001c, B:9:0x003b, B:16:0x0067, B:18:0x006f, B:10:0x0046, B:12:0x0050, B:13:0x005b), top: B:24:0x0000 }] */
    @Override // com.anythink.basead.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final com.anythink.basead.e.c r10) {
        /*
            r9 = this;
            r0 = r9
            java.lang.String r0 = r0.e     // Catch: java.lang.Exception -> L92
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L92
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L5b
            r0 = r9
            com.anythink.core.common.e.j r0 = r0.d     // Catch: java.lang.Exception -> L92
            java.lang.String r0 = r0.b     // Catch: java.lang.Exception -> L92
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L1c
            goto L5b
        L1c:
            r0 = r9
            android.content.Context r0 = r0.c     // Catch: java.lang.Exception -> L92
            com.anythink.basead.f.a.a r0 = com.anythink.basead.f.a.a.a(r0)     // Catch: java.lang.Exception -> L92
            r1 = r9
            com.anythink.core.common.e.j r1 = r1.d     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = r1.b     // Catch: java.lang.Exception -> L92
            r2 = r9
            java.lang.String r2 = r2.e     // Catch: java.lang.Exception -> L92
            com.anythink.core.common.e.s r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L92
            r12 = r0
            r0 = r9
            r1 = r12
            r0.g = r1     // Catch: java.lang.Exception -> L92
            r0 = r12
            if (r0 != 0) goto L46
            java.lang.String r0 = "30001"
            java.lang.String r1 = "No fill, offer = null!"
            com.anythink.basead.c.e r0 = com.anythink.basead.c.f.a(r0, r1)     // Catch: java.lang.Exception -> L92
            r12 = r0
            goto L63
        L46:
            r0 = r9
            com.anythink.core.common.e.j r0 = r0.d     // Catch: java.lang.Exception -> L92
            com.anythink.core.common.e.k r0 = r0.m     // Catch: java.lang.Exception -> L92
            if (r0 != 0) goto La7
            java.lang.String r0 = "30002"
            java.lang.String r1 = "No fill, setting = null!"
            com.anythink.basead.c.e r0 = com.anythink.basead.c.f.a(r0, r1)     // Catch: java.lang.Exception -> L92
            r12 = r0
            goto L63
        L5b:
            java.lang.String r0 = "30001"
            java.lang.String r1 = "offerid、placementid can not be null!"
            com.anythink.basead.c.e r0 = com.anythink.basead.c.f.a(r0, r1)     // Catch: java.lang.Exception -> L92
            r12 = r0
        L63:
            r0 = r12
            if (r0 == 0) goto L6f
            r0 = r10
            r1 = r12
            r0.onAdLoadFailed(r1)     // Catch: java.lang.Exception -> L92
            return
        L6f:
            r0 = r9
            android.content.Context r0 = r0.c     // Catch: java.lang.Exception -> L92
            com.anythink.basead.f.a.a r0 = com.anythink.basead.f.a.a.a(r0)     // Catch: java.lang.Exception -> L92
            r1 = r9
            com.anythink.core.common.e.j r1 = r1.d     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = r1.b     // Catch: java.lang.Exception -> L92
            r2 = r9
            com.anythink.core.common.e.s r2 = r2.g     // Catch: java.lang.Exception -> L92
            r3 = r9
            com.anythink.core.common.e.j r3 = r3.d     // Catch: java.lang.Exception -> L92
            com.anythink.basead.f.c$1 r4 = new com.anythink.basead.f.c$1     // Catch: java.lang.Exception -> L92
            r5 = r4
            r6 = r9
            r7 = r10
            r5.<init>()     // Catch: java.lang.Exception -> L92
            r0.a(r1, r2, r3, r4)     // Catch: java.lang.Exception -> L92
            return
        L92:
            r12 = move-exception
            r0 = r12
            r0.printStackTrace()
            r0 = r10
            java.lang.String r1 = "-9999"
            r2 = r12
            java.lang.String r2 = r2.getMessage()
            com.anythink.basead.c.e r1 = com.anythink.basead.c.f.a(r1, r2)
            r0.onAdLoadFailed(r1)
            return
        La7:
            r0 = 0
            r12 = r0
            goto L63
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.f.c.a(com.anythink.basead.e.c):void");
    }

    @Override // com.anythink.basead.f.a
    public boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.f.a.a.a(this.c).a(this.g, this.d, this.f);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d() {
        if (this.c == null || TextUtils.isEmpty(this.d.b) || TextUtils.isEmpty(this.e)) {
            return false;
        }
        if (this.g == null) {
            s a = com.anythink.basead.f.a.a.a(this.c).a(this.d.b, this.e);
            this.g = a;
            return a != null;
        }
        return true;
    }

    public final s e() {
        return this.g;
    }
}
