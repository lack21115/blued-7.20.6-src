package com.kuaishou.weapon.p0;

import android.os.Build;
import com.kuaishou.weapon.p0.jni.Engine;
import java.lang.reflect.Method;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cs.class */
public class cs {

    /* renamed from: a  reason: collision with root package name */
    private static int f23797a;
    private static boolean b;

    public cs() {
        b();
    }

    private int a(Method method) {
        try {
            if (f23797a <= 1 || method == null) {
                return 0;
            }
            return Engine.mmo(method, f23797a, method.getModifiers());
        } catch (Exception e) {
            return 0;
        }
    }

    private void b() {
        if (!Engine.loadSuccess || b) {
            return;
        }
        boolean b2 = cq.b();
        int i = Build.VERSION.SDK_INT;
        if (b2 && i < 29 && i > 22) {
            f23797a = Engine.off();
        }
        b = true;
    }

    private boolean c() {
        return b && f23797a > 1;
    }

    public int a() {
        if (c()) {
            long a2 = cp.b.a();
            long a3 = cp.f23791a.a();
            if (f23797a == a2) {
                return (int) a3;
            }
            return -1;
        }
        return -1;
    }

    public int a(int i, Class cls, String str, Object... objArr) {
        Method a2;
        try {
            if (!c() || (a2 = dg.a(cls, str, objArr)) == null) {
                return 0;
            }
            return Engine.mqc(a2, i);
        } catch (Exception e) {
            return 0;
        }
    }

    public int a(Class cls, String str, Object... objArr) {
        try {
            if (c()) {
                return a(dg.a(cls, str, objArr));
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
