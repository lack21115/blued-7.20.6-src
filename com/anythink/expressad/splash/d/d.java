package com.anythink.expressad.splash.d;

import com.anythink.expressad.out.e;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/d/d.class */
public class d implements com.anythink.expressad.splash.b.d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8234a = "SplashShowListenerImpl";
    private e b;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f8235c;
    private boolean d;
    private c e;

    public d(c cVar, e eVar, double d, com.anythink.expressad.foundation.d.c cVar2) {
        this.e = cVar;
        this.b = eVar;
        this.f8235c = cVar2;
        this.d = a(d, cVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007e A[Catch: Exception -> 0x00f3, TRY_ENTER, TryCatch #0 {Exception -> 0x00f3, blocks: (B:2:0x0000, B:5:0x0013, B:7:0x0021, B:9:0x003e, B:11:0x007e, B:13:0x0089, B:15:0x0090, B:18:0x0099, B:25:0x00a8, B:29:0x00da), top: B:40:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(double r6, com.anythink.expressad.foundation.d.c r8) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.d.d.a(double, com.anythink.expressad.foundation.d.c):boolean");
    }

    private static void d() {
    }

    private static void e() {
    }

    private void f() {
        if (this.b != null) {
            this.b = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.anythink.expressad.splash.b.d
    public final void a() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        e eVar = this.b;
        if (eVar == null || this.d) {
            return;
        }
        eVar.a(cVar);
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a(String str) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.f8228a = false;
        }
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void b() {
        e eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
        c cVar = this.e;
        if (cVar != null) {
            cVar.f8228a = false;
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void c() {
    }
}
