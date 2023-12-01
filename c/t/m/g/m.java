package c.t.m.g;

import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f3878a = "";

    public static String a() {
        return e() ? f3878a : q3.h();
    }

    public static String b() {
        return e() ? "" : q3.j();
    }

    public static String c() {
        return (!e() && Build.VERSION.SDK_INT < 29) ? q3.l() : "";
    }

    public static String d() {
        return e() ? f3878a : q3.m();
    }

    public static boolean e() {
        return false;
    }
}
