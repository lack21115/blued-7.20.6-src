package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hy.class */
public class hy implements ir<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f626a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f627a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f628b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f625a = new jh("XmPushActionCheckClientInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27812a = new iz("", (byte) 8, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m8870a()).compareTo(Boolean.valueOf(hyVar.m8870a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8870a() || (a3 = is.a(this.f626a, hyVar.f626a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = is.a(this.f628b, hyVar.f628b)) == 0) {
                    return 0;
                }
                return a2;
            }
            return a3;
        }
        return getClass().getName().compareTo(hyVar.getClass().getName());
    }

    public hy a(int i) {
        this.f626a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.mo8986a();
        while (true) {
            iz mo8982a = jcVar.mo8982a();
            if (mo8982a.f27852a == 0) {
                break;
            }
            short s = mo8982a.f840a;
            if (s != 1) {
                if (s == 2 && mo8982a.f27852a == 8) {
                    this.f628b = jcVar.mo8980a();
                    b(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else {
                if (mo8982a.f27852a == 8) {
                    this.f626a = jcVar.mo8980a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (!m8870a()) {
            throw new jd("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new jd("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f627a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8870a() {
        return this.f627a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8871a(hy hyVar) {
        return hyVar != null && this.f626a == hyVar.f626a && this.f628b == hyVar.f628b;
    }

    public hy b(int i) {
        this.f628b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f625a);
        jcVar.a(f27812a);
        jcVar.mo8991a(this.f626a);
        jcVar.b();
        jcVar.a(b);
        jcVar.mo8991a(this.f628b);
        jcVar.b();
        jcVar.c();
        jcVar.mo8990a();
    }

    public void b(boolean z) {
        this.f627a.set(1, z);
    }

    public boolean b() {
        return this.f627a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m8871a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f626a + ", pluginConfigVersion:" + this.f628b + ")";
    }
}
