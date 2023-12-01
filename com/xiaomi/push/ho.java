package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ho.class */
public class ho implements ir<ho, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f573a;

    /* renamed from: a  reason: collision with other field name */
    public hi f574a;

    /* renamed from: a  reason: collision with other field name */
    public String f575a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f576a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    private static final jh f572a = new jh("DataCollectionItem");

    /* renamed from: a  reason: collision with root package name */
    private static final iz f41483a = new iz("", (byte) 10, 1);
    private static final iz b = new iz("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    private static final iz f41484c = new iz("", (byte) 11, 3);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ho hoVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hoVar.getClass())) {
            int compareTo = Boolean.valueOf(m11869a()).compareTo(Boolean.valueOf(hoVar.m11869a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m11869a() || (a4 = is.a(this.f573a, hoVar.f573a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = is.a(this.f574a, hoVar.f574a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = is.a(this.f575a, hoVar.f575a)) == 0) {
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
        this.f573a = j;
        a(true);
        return this;
    }

    public ho a(hi hiVar) {
        this.f574a = hiVar;
        return this;
    }

    public ho a(String str) {
        this.f575a = str;
        return this;
    }

    public String a() {
        return this.f575a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11868a() {
        if (this.f574a == null) {
            throw new jd("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f575a != null) {
        } else {
            throw new jd("Required field 'content' was not present! Struct: " + toString());
        }
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
            if (s == 1) {
                if (mo12032a.f41543a == 10) {
                    this.f573a = jcVar.mo12031a();
                    a(true);
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else if (s != 2) {
                if (s == 3 && mo12032a.f41543a == 11) {
                    this.f575a = jcVar.mo12037a();
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            } else {
                if (mo12032a.f41543a == 8) {
                    this.f574a = hi.a(jcVar.mo12030a());
                    jcVar.g();
                }
                jf.a(jcVar, mo12032a.f41543a);
                jcVar.g();
            }
        }
        jcVar.f();
        if (m11869a()) {
            m11868a();
            return;
        }
        throw new jd("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f576a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11869a() {
        return this.f576a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11870a(ho hoVar) {
        if (hoVar != null && this.f573a == hoVar.f573a) {
            boolean b2 = b();
            boolean b3 = hoVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f574a.equals(hoVar.f574a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hoVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f575a.equals(hoVar.f575a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m11868a();
        jcVar.a(f572a);
        jcVar.a(f41483a);
        jcVar.a(this.f573a);
        jcVar.b();
        if (this.f574a != null) {
            jcVar.a(b);
            jcVar.mo12041a(this.f574a.a());
            jcVar.b();
        }
        if (this.f575a != null) {
            jcVar.a(f41484c);
            jcVar.a(this.f575a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.mo12040a();
    }

    public boolean b() {
        return this.f574a != null;
    }

    public boolean c() {
        return this.f575a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m11870a((ho) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f573a);
        sb.append(", ");
        sb.append("collectionType:");
        hi hiVar = this.f574a;
        if (hiVar == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(hiVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f575a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.l);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
