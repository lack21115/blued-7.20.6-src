package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hy.class */
public class hy implements ir<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f673a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f674a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f675b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f672a = new jh("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41503a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m11920a()).compareTo(Boolean.valueOf(hyVar.m11920a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11920a() || (a3 = is.a(this.f673a, hyVar.f673a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = is.a(this.f675b, hyVar.f675b)) == 0) {
                    return 0;
                }
                return a2;
            }
            return a3;
        }
        return getClass().getName().compareTo(hyVar.getClass().getName());
    }

    public hy a(int i) {
        this.f673a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo12036a();
        while (true) {
            iz mo12032a = jcVar.mo12032a();
            if (mo12032a.f41543a == 0) {
                break;
            }
            short s = mo12032a.f887a;
            if (s != 1) {
                if (s == 2 && mo12032a.f41543a == 8) {
                    this.f675b = jcVar.mo12030a();
                    b(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else {
                if (mo12032a.f41543a == 8) {
                    this.f673a = jcVar.mo12030a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (!m11920a()) {
            throw new jd("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new jd("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f674a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11920a() {
        return this.f674a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11921a(hy hyVar) {
        return hyVar != null && this.f673a == hyVar.f673a && this.f675b == hyVar.f675b;
    }

    public hy b(int i) {
        this.f675b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f672a);
        jcVar.a(f41503a);
        jcVar.mo12041a(this.f673a);
        jcVar.b();
        jcVar.a(b);
        jcVar.mo12041a(this.f675b);
        jcVar.b();
        jcVar.c();
        jcVar.mo12040a();
    }

    public void b(boolean z) {
        this.f674a.set(1, z);
    }

    public boolean b() {
        return this.f674a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m11921a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f673a + ", pluginConfigVersion:" + this.f675b + ")";
    }
}
