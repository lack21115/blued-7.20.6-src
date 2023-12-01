package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.util.Vector;

/* renamed from: com.amap.api.col.3sl.in  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/in.class */
public final class in {
    private static int b = 100;
    private static int d = 10000;
    private Vector<ik> a;
    private int c;
    private int e;

    public in() {
        this.c = b;
        this.e = 0;
        this.c = 10;
        this.a = new Vector<>();
    }

    public in(byte b2) {
        this.c = b;
        this.e = 0;
        this.a = new Vector<>();
    }

    public final Vector<ik> a() {
        return this.a;
    }

    public final void a(ik ikVar) {
        synchronized (this) {
            if (ikVar != null) {
                if (!TextUtils.isEmpty(ikVar.b())) {
                    this.a.add(ikVar);
                    this.e += ikVar.b().getBytes().length;
                }
            }
        }
    }

    public final boolean a(String str) {
        synchronized (this) {
            if (str == null) {
                return false;
            }
            if (this.a.size() >= this.c) {
                return true;
            }
            return this.e + str.getBytes().length > d;
        }
    }

    public final void b() {
        synchronized (this) {
            this.a.clear();
            this.e = 0;
        }
    }
}
