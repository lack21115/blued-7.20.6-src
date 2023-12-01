package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ho.class */
public class ho implements ir<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f526a;

    /* renamed from: a  reason: collision with other field name */
    public hi f527a;

    /* renamed from: a  reason: collision with other field name */
    public String f528a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f529a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jh f525a = new jh("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f27792a = new iz("", (byte) 10, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f27793c = new iz("", (byte) 11, 3);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ho hoVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hoVar.getClass())) {
            int compareTo = Boolean.valueOf(m8819a()).compareTo(Boolean.valueOf(hoVar.m8819a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m8819a() || (a4 = is.a(this.f526a, hoVar.f526a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = is.a(this.f527a, hoVar.f527a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = is.a(this.f528a, hoVar.f528a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return getClass().getName().compareTo(hoVar.getClass().getName());
    }

    public ho a(long j) {
        this.f526a = j;
        a(true);
        return this;
    }

    public ho a(hi hiVar) {
        this.f527a = hiVar;
        return this;
    }

    public ho a(String str) {
        this.f528a = str;
        return this;
    }

    public String a() {
        return this.f528a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8818a() {
        if (this.f527a == null) {
            throw new jd("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f528a != null) {
        } else {
            throw new jd("Required field 'content' was not present! Struct: " + toString());
        }
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
            if (s == 1) {
                if (mo8982a.f27852a == 10) {
                    this.f526a = jcVar.mo8981a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else if (s != 2) {
                if (s == 3 && mo8982a.f27852a == 11) {
                    this.f528a = jcVar.mo8987a();
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            } else {
                if (mo8982a.f27852a == 8) {
                    this.f527a = hi.a(jcVar.mo8980a());
                    jcVar.g();
                }
                jf.a(jcVar, mo8982a.f27852a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (m8819a()) {
            m8818a();
            return;
        }
        throw new jd("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f529a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8819a() {
        return this.f529a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8820a(ho hoVar) {
        if (hoVar != null && this.f526a == hoVar.f526a) {
            boolean b2 = b();
            boolean b3 = hoVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f527a.equals(hoVar.f527a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hoVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f528a.equals(hoVar.f528a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m8818a();
        jcVar.a(f525a);
        jcVar.a(f27792a);
        jcVar.a(this.f526a);
        jcVar.b();
        if (this.f527a != null) {
            jcVar.a(b);
            jcVar.mo8991a(this.f527a.a());
            jcVar.b();
        }
        if (this.f528a != null) {
            jcVar.a(f27793c);
            jcVar.a(this.f528a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo8990a();
    }

    public boolean b() {
        return this.f527a != null;
    }

    public boolean c() {
        return this.f528a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m8820a((ho) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f526a);
        sb.append(", ");
        sb.append("collectionType:");
        hi hiVar = this.f527a;
        if (hiVar == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(hiVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f528a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
