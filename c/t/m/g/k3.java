package c.t.m.g;

import android.app.backup.FullBackup;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k3.class */
public class k3 {
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static int a(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static final String a(double d, int i) {
        Locale locale = Locale.ENGLISH;
        return String.format(locale, "%." + i + FullBackup.DATA_TREE_TOKEN, Double.valueOf(d));
    }

    public static final boolean a(double d, double d2) {
        return a(d, d2, 1.0E-8d);
    }

    public static final boolean a(double d, double d2, double d3) {
        boolean z = false;
        if (!Double.isNaN(d)) {
            if (Double.isNaN(d2)) {
                return false;
            }
            z = false;
            if (Math.abs(d - d2) < d3) {
                z = true;
            }
        }
        return z;
    }

    public static final boolean a(float f, float f2) {
        return a(f, f2, 1.0E-8f);
    }

    public static final boolean a(float f, float f2, float f3) {
        boolean z = false;
        if (!Float.isNaN(f)) {
            if (Float.isNaN(f2)) {
                return false;
            }
            z = false;
            if (Math.abs(f - f2) < f3) {
                z = true;
            }
        }
        return z;
    }
}
