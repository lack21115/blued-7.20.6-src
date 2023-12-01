package c.t.m.g;

import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f3767a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3768c;

    public c(String str, String str2, String str3) {
        this.f3767a = str2;
        this.b = str;
        this.f3768c = str3;
    }

    public String a() {
        return a(this.f3768c);
    }

    public final String a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public String b() {
        return a(this.b);
    }

    public String c() {
        return a(this.f3767a);
    }

    public String d() {
        return a(Build.MANUFACTURER);
    }

    public String e() {
        return a(q3.f());
    }

    public String f() {
        return "1.7.6";
    }
}
