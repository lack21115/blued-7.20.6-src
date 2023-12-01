package a.a.a.a.a.e;

import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public EnumC0009c f1306a;
    public EnumC0009c b;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/c$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f1307a = new c();
    }

    /* renamed from: a.a.a.a.a.e.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/e/c$c.class */
    public enum EnumC0009c {
        UNKNOWN,
        YES,
        NO
    }

    public c() {
        EnumC0009c enumC0009c = EnumC0009c.UNKNOWN;
        this.f1306a = enumC0009c;
        this.b = enumC0009c;
        e eVar = e.f1313c;
        eVar.c("CompatibleManager", "Build.MODEL:" + Build.MODEL);
    }

    public static c a() {
        return b.f1307a;
    }

    public boolean b() {
        if (this.f1306a == EnumC0009c.UNKNOWN) {
            this.f1306a = d();
        }
        return this.f1306a == EnumC0009c.YES;
    }

    public boolean c() {
        if (this.b == EnumC0009c.UNKNOWN) {
            this.b = e();
        }
        return this.b == EnumC0009c.YES;
    }

    public final EnumC0009c d() {
        String[] strArr = d.e;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return EnumC0009c.NO;
            }
            if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                return EnumC0009c.YES;
            }
            i = i2 + 1;
        }
    }

    public final EnumC0009c e() {
        String[] strArr = d.f;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return EnumC0009c.YES;
            }
            if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                return EnumC0009c.NO;
            }
            i = i2 + 1;
        }
    }
}
