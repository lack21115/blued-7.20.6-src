package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.util.Vector;

/* renamed from: com.amap.api.col.3sl.in  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/in.class */
public final class in {
    private static int b = 100;
    private static int d = 10000;

    /* renamed from: a  reason: collision with root package name */
    private Vector<ik> f5167a;

    /* renamed from: c  reason: collision with root package name */
    private int f5168c;
    private int e;

    public in() {
        this.f5168c = b;
        this.e = 0;
        this.f5168c = 10;
        this.f5167a = new Vector<>();
    }

    public in(byte b2) {
        this.f5168c = b;
        this.e = 0;
        this.f5167a = new Vector<>();
    }

    public final Vector<ik> a() {
        return this.f5167a;
    }

    public final void a(ik ikVar) {
        synchronized (this) {
            if (ikVar != null) {
                if (!TextUtils.isEmpty(ikVar.b())) {
                    this.f5167a.add(ikVar);
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
            if (this.f5167a.size() >= this.f5168c) {
                return true;
            }
            return this.e + str.getBytes().length > d;
        }
    }

    public final void b() {
        synchronized (this) {
            this.f5167a.clear();
            this.e = 0;
        }
    }
}
