package com.anythink.expressad.video.bt.module.b;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/b/e.class */
public final class e extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8342a = "ProxyShowRewardListener";
    private h b;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.videocommon.e.d f8343c;
    private String d;
    private String e;
    private boolean f;
    private Context g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;

    /* JADX WARN: Removed duplicated region for block: B:15:0x007a A[Catch: Exception -> 0x00ba, TRY_ENTER, TryCatch #0 {Exception -> 0x00ba, blocks: (B:3:0x0034, B:6:0x0045, B:9:0x0056, B:12:0x0062, B:13:0x006f, B:15:0x007a, B:18:0x0085, B:20:0x0091, B:22:0x009f, B:24:0x00a6, B:26:0x00ad), top: B:31:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[Catch: Exception -> 0x00ba, TRY_ENTER, TryCatch #0 {Exception -> 0x00ba, blocks: (B:3:0x0034, B:6:0x0045, B:9:0x0056, B:12:0x0062, B:13:0x006f, B:15:0x007a, B:18:0x0085, B:20:0x0091, B:22:0x009f, B:24:0x00a6, B:26:0x00ad), top: B:31:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e(android.content.Context r7, boolean r8, com.anythink.expressad.videocommon.e.d r9, com.anythink.expressad.foundation.d.c r10, com.anythink.expressad.video.bt.module.b.h r11, java.lang.String r12, java.lang.String r13) {
        /*
            r6 = this;
            r0 = r6
            r0.<init>()
            r0 = r6
            r1 = 0
            r0.h = r1
            r0 = r6
            r1 = 0
            r0.i = r1
            r0 = r6
            r1 = 0
            r0.j = r1
            r0 = r6
            r1 = r11
            r0.b = r1
            r0 = r6
            r1 = r9
            r0.f8343c = r1
            r0 = r6
            r1 = r13
            r0.d = r1
            r0 = r6
            r1 = r12
            r0.e = r1
            r0 = r6
            r1 = r8
            r0.f = r1
            r0 = r6
            r1 = r7
            r0.g = r1
            com.anythink.expressad.foundation.b.a r0 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Exception -> Lba
            java.lang.String r0 = r0.e()     // Catch: java.lang.Exception -> Lba
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> Lba
            r8 = r0
            r0 = 0
            r16 = r0
            r0 = r8
            if (r0 != 0) goto Lbc
            com.anythink.expressad.d.b r0 = com.anythink.expressad.d.b.a()     // Catch: java.lang.Exception -> Lba
            com.anythink.expressad.d.a r0 = com.anythink.expressad.d.b.b()     // Catch: java.lang.Exception -> Lba
            r11 = r0
            r0 = r11
            r7 = r0
            r0 = r11
            if (r0 != 0) goto L5e
            com.anythink.expressad.d.b r0 = com.anythink.expressad.d.b.a()     // Catch: java.lang.Exception -> Lba
            com.anythink.expressad.d.a r0 = com.anythink.expressad.d.b.c()     // Catch: java.lang.Exception -> Lba
            r7 = r0
        L5e:
            r0 = r7
            if (r0 == 0) goto Lbc
            r0 = r7
            long r0 = r0.l()     // Catch: java.lang.Exception -> Lba
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r1
            r14 = r0
            goto L6f
        L6f:
            com.anythink.expressad.videocommon.e.c r0 = com.anythink.expressad.videocommon.e.c.a()     // Catch: java.lang.Exception -> Lba
            com.anythink.expressad.videocommon.e.a r0 = r0.b()     // Catch: java.lang.Exception -> Lba
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L80
            r0 = r7
            long r0 = r0.c()     // Catch: java.lang.Exception -> Lba
            r16 = r0
        L80:
            r0 = r10
            if (r0 == 0) goto Lb9
            r0 = r10
            r1 = r16
            r2 = r14
            boolean r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> Lba
            if (r0 == 0) goto Lad
            r0 = r10
            r1 = 1
            r0.e(r1)     // Catch: java.lang.Exception -> Lba
            r0 = r9
            int r0 = r0.M()     // Catch: java.lang.Exception -> Lba
            r1 = 1
            if (r0 != r1) goto La6
            r0 = r10
            r1 = 1
            r0.m(r1)     // Catch: java.lang.Exception -> Lba
            return
        La6:
            r0 = r10
            r1 = 0
            r0.m(r1)     // Catch: java.lang.Exception -> Lba
            return
        Lad:
            r0 = r10
            r1 = 0
            r0.e(r1)     // Catch: java.lang.Exception -> Lba
            r0 = r10
            r1 = 0
            r0.m(r1)     // Catch: java.lang.Exception -> Lba
        Lb9:
            return
        Lba:
            r7 = move-exception
            return
        Lbc:
            r0 = 0
            r14 = r0
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.module.b.e.<init>(android.content.Context, boolean, com.anythink.expressad.videocommon.e.d, com.anythink.expressad.foundation.d.c, com.anythink.expressad.video.bt.module.b.h, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b A[Catch: Exception -> 0x0084, TRY_ENTER, TryCatch #0 {Exception -> 0x0084, blocks: (B:2:0x0000, B:5:0x0011, B:8:0x0023, B:11:0x0031, B:12:0x003e, B:14:0x004b, B:17:0x0056, B:19:0x0060, B:21:0x006d, B:23:0x0073, B:25:0x0079), top: B:30:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[Catch: Exception -> 0x0084, TRY_ENTER, TryCatch #0 {Exception -> 0x0084, blocks: (B:2:0x0000, B:5:0x0011, B:8:0x0023, B:11:0x0031, B:12:0x003e, B:14:0x004b, B:17:0x0056, B:19:0x0060, B:21:0x006d, B:23:0x0073, B:25:0x0079), top: B:30:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.anythink.expressad.videocommon.e.d r6, com.anythink.expressad.foundation.d.c r7) {
        /*
            com.anythink.expressad.foundation.b.a r0 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Exception -> L84
            java.lang.String r0 = r0.e()     // Catch: java.lang.Exception -> L84
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L84
            r8 = r0
            r0 = 0
            r11 = r0
            r0 = r8
            if (r0 != 0) goto L86
            com.anythink.expressad.d.b r0 = com.anythink.expressad.d.b.a()     // Catch: java.lang.Exception -> L84
            com.anythink.expressad.d.a r0 = com.anythink.expressad.d.b.b()     // Catch: java.lang.Exception -> L84
            r14 = r0
            r0 = r14
            r13 = r0
            r0 = r14
            if (r0 != 0) goto L2c
            com.anythink.expressad.d.b r0 = com.anythink.expressad.d.b.a()     // Catch: java.lang.Exception -> L84
            com.anythink.expressad.d.a r0 = com.anythink.expressad.d.b.c()     // Catch: java.lang.Exception -> L84
            r13 = r0
        L2c:
            r0 = r13
            if (r0 == 0) goto L86
            r0 = r13
            long r0 = r0.l()     // Catch: java.lang.Exception -> L84
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r1
            r9 = r0
            goto L3e
        L3e:
            com.anythink.expressad.videocommon.e.c r0 = com.anythink.expressad.videocommon.e.c.a()     // Catch: java.lang.Exception -> L84
            com.anythink.expressad.videocommon.e.a r0 = r0.b()     // Catch: java.lang.Exception -> L84
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L52
            r0 = r13
            long r0 = r0.c()     // Catch: java.lang.Exception -> L84
            r11 = r0
        L52:
            r0 = r7
            if (r0 == 0) goto L83
            r0 = r7
            r1 = r11
            r2 = r9
            boolean r0 = r0.a(r1, r2)     // Catch: java.lang.Exception -> L84
            if (r0 == 0) goto L79
            r0 = r7
            r1 = 1
            r0.e(r1)     // Catch: java.lang.Exception -> L84
            r0 = r6
            int r0 = r0.M()     // Catch: java.lang.Exception -> L84
            r1 = 1
            if (r0 != r1) goto L73
            r0 = r7
            r1 = 1
            r0.m(r1)     // Catch: java.lang.Exception -> L84
            return
        L73:
            r0 = r7
            r1 = 0
            r0.m(r1)     // Catch: java.lang.Exception -> L84
            return
        L79:
            r0 = r7
            r1 = 0
            r0.e(r1)     // Catch: java.lang.Exception -> L84
            r0 = r7
            r1 = 0
            r0.m(r1)     // Catch: java.lang.Exception -> L84
        L83:
            return
        L84:
            r6 = move-exception
            return
        L86:
            r0 = 0
            r9 = r0
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.module.b.e.a(com.anythink.expressad.videocommon.e.d, com.anythink.expressad.foundation.d.c):void");
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a() {
        super.a();
        h hVar = this.b;
        if (hVar == null || this.h) {
            return;
        }
        this.h = true;
        hVar.a();
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        super.a(cVar);
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(cVar);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(String str) {
        super.a(str);
        h hVar = this.b;
        if (hVar == null || this.i) {
            return;
        }
        this.i = true;
        hVar.a(str);
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(boolean z, int i) {
        super.a(z, i);
        h hVar = this.b;
        if (hVar == null || this.j) {
            return;
        }
        hVar.a(z, i);
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
        super.a(z, cVar);
        h hVar = this.b;
        if (hVar == null || this.j) {
            return;
        }
        this.j = true;
        hVar.a(z, cVar);
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void b() {
        super.b();
        h hVar = this.b;
        if (hVar != null) {
            hVar.b();
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void c() {
        super.c();
        h hVar = this.b;
        if (hVar != null) {
            hVar.c();
        }
    }
}
