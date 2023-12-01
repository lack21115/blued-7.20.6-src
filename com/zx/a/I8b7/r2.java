package com.zx.a.I8b7;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/r2.class */
public class r2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f28501a = new Handler(Looper.getMainLooper());

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/r2$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final r2 f28502a = new r2();
    }

    public boolean a() {
        boolean z = false;
        boolean z2 = t2.p == 1 && t2.q == 1 && t2.o == 1;
        boolean z3 = t2.p == 0 && t2.o == 1;
        if (z2 || z3) {
            z = true;
        }
        return z;
    }

    public boolean b() {
        return t2.p == 1 && t2.q == -1 && t2.o == 1;
    }
}
