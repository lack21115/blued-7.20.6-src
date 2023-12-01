package com.zx.a.I8b7;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/d.class */
public class d {
    public static Signature[] a(String str) {
        try {
            return p2.a(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            z1.a(e);
            return null;
        }
    }
}
