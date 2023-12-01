package c.t.m.g;

import android.location.Location;
import android.os.Bundle;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e4.class */
public class e4 {

    /* renamed from: c  reason: collision with root package name */
    public static e4 f3754c = new e4();
    public static boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    public int f3755a = 0;
    public boolean b = false;

    public static void a(boolean z) {
        d = z;
    }

    public static boolean a() {
        return d;
    }

    public static e4 b() {
        if (f3754c == null) {
            synchronized (e4.class) {
                try {
                    if (f3754c == null) {
                        f3754c = new e4();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3754c;
    }

    public int a(Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras.getInt("fakeCode");
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int a(b5 b5Var) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public int a(q5 q5Var) {
        int i = 0;
        if (d) {
            return 0;
        }
        if (q5Var.isMockGps() >= 1) {
            this.b = true;
            i = 1;
        } else {
            this.b = false;
        }
        return i + this.f3755a;
    }

    public void a(int i) {
        this.f3755a = (int) Math.pow(2.0d, i + 3);
    }

    public void c() {
        this.f3755a = 0;
        this.b = false;
    }
}
