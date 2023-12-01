package com.hihonor.push.sdk;

import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f22293a;
    public final int b;

    public g(String str) {
        this.f22293a = str;
        this.b = a(str);
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static g a(String str) {
        return new g(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f22293a, ((g) obj).f22293a);
    }

    public final int hashCode() {
        return this.b;
    }
}
