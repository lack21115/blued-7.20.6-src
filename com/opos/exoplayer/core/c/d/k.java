package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/k.class */
final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f11459a = {u.f("isom"), u.f("iso2"), u.f("iso3"), u.f("iso4"), u.f("iso5"), u.f("iso6"), u.f("avc1"), u.f("hvc1"), u.f("hev1"), u.f("mp41"), u.f("mp42"), u.f("3g2a"), u.f("3g2b"), u.f("3gr6"), u.f("3gs6"), u.f("3ge6"), u.f("3gg6"), u.f("M4V "), u.f("M4A "), u.f("f4v "), u.f("kddi"), u.f("M4VP"), u.f("qt  "), u.f("MSNV")};

    private static boolean a(int i) {
        boolean z;
        if ((i >>> 8) != u.f("3gp")) {
            int[] iArr = f11459a;
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                z = false;
                if (i3 < length) {
                    if (iArr[i3] == i) {
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    break;
                }
            }
        }
        z = true;
        return z;
    }

    public static boolean a(com.opos.exoplayer.core.c.f fVar) {
        return a(fVar, true);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static boolean a(com.opos.exoplayer.core.c.f fVar, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static boolean b(com.opos.exoplayer.core.c.f fVar) {
        return a(fVar, false);
    }
}
