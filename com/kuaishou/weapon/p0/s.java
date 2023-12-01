package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public int f23861a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f23862c;
    public String d;
    public String e;
    public Context f;
    public ClassLoader g;
    public String h;
    public String i;
    public String j;
    public String k;
    public ActivityInfo[] l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public PackageInfo r;
    public long s;
    public int t;
    public int u;
    public boolean v;
    public int w;
    public int x = -1;
    public boolean y;

    public s() {
    }

    public s(PackageInfo packageInfo, int i, String str, String str2, String str3, String str4) {
        this.r = packageInfo;
        this.f23861a = i;
        this.f23862c = str;
        this.d = str2;
        this.i = str3;
        this.j = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f23862c;
            String str2 = ((s) obj).f23862c;
            return str == null ? str2 == null : str.equals(str2);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f23862c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
