package c.t.m.g;

import android.os.Bundle;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v3.class */
public abstract class v3 {

    /* renamed from: a  reason: collision with root package name */
    public String f4022a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4023c = true;

    public v3(String str, String str2) {
        this.f4022a = str;
        this.b = str2;
    }

    public void a() {
    }

    public boolean a(Bundle bundle) {
        if (this.f4023c) {
            return b(bundle);
        }
        return false;
    }

    public abstract boolean b(Bundle bundle);

    public String toString() {
        return "[name=" + this.f4022a + ",desc=" + this.b + ",enabled=" + this.f4023c + "]";
    }
}
