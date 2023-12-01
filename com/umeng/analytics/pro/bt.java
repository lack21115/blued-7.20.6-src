package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bt.class */
public class bt {

    /* renamed from: a  reason: collision with root package name */
    private final cp f26980a;
    private final dc b;

    public bt() {
        this(new cj.a());
    }

    public bt(cr crVar) {
        dc dcVar = new dc();
        this.b = dcVar;
        this.f26980a = crVar.a(dcVar);
    }

    /* JADX WARN: Finally extract failed */
    private Object a(byte b, byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        String str;
        try {
            try {
                ck j = j(bArr, bxVar, bxVarArr);
                if (j != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && j.b == 11) {
                                                    str = this.f26980a.z();
                                                }
                                            } else if (j.b == 10) {
                                                str = Long.valueOf(this.f26980a.x());
                                            }
                                        } else if (j.b == 11) {
                                            str = this.f26980a.A();
                                        }
                                    } else if (j.b == 8) {
                                        str = Integer.valueOf(this.f26980a.w());
                                    }
                                } else if (j.b == 6) {
                                    str = Short.valueOf(this.f26980a.v());
                                }
                            } else if (j.b == 4) {
                                str = Double.valueOf(this.f26980a.y());
                            }
                        } else if (j.b == 3) {
                            str = Byte.valueOf(this.f26980a.u());
                        }
                    } else if (j.b == 2) {
                        str = Boolean.valueOf(this.f26980a.t());
                    }
                    this.b.e();
                    this.f26980a.B();
                    return str;
                }
                str = null;
                this.b.e();
                this.f26980a.B();
                return str;
            } catch (Exception e) {
                throw new bw(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.f26980a.B();
            throw th;
        }
    }

    private ck j(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        this.b.a(bArr);
        int length = bxVarArr.length + 1;
        bx[] bxVarArr2 = new bx[length];
        bxVarArr2[0] = bxVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bxVarArr.length) {
                break;
            }
            int i3 = i2 + 1;
            bxVarArr2[i3] = bxVarArr[i2];
            i = i3;
        }
        this.f26980a.j();
        ck ckVar = null;
        int i4 = 0;
        while (i4 < length) {
            ck l = this.f26980a.l();
            if (l.b == 0 || l.f27009c > bxVarArr2[i4].a()) {
                return null;
            }
            if (l.f27009c != bxVarArr2[i4].a()) {
                cs.a(this.f26980a, l.b);
                this.f26980a.m();
                ckVar = l;
            } else {
                int i5 = i4 + 1;
                i4 = i5;
                ckVar = l;
                if (i5 < length) {
                    this.f26980a.j();
                    i4 = i5;
                    ckVar = l;
                }
            }
        }
        return ckVar;
    }

    public Boolean a(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Boolean) a((byte) 2, bArr, bxVar, bxVarArr);
    }

    public void a(bq bqVar, String str) throws bw {
        a(bqVar, str.getBytes());
    }

    public void a(bq bqVar, String str, String str2) throws bw {
        try {
            try {
                a(bqVar, str.getBytes(str2));
                this.f26980a.B();
            } catch (UnsupportedEncodingException e) {
                throw new bw("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } catch (Throwable th) {
            this.f26980a.B();
            throw th;
        }
    }

    public void a(bq bqVar, byte[] bArr) throws bw {
        try {
            this.b.a(bArr);
            bqVar.read(this.f26980a);
        } finally {
            this.b.e();
            this.f26980a.B();
        }
    }

    public void a(bq bqVar, byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    bqVar.read(this.f26980a);
                }
            } catch (Exception e) {
                throw new bw(e);
            }
        } finally {
            this.b.e();
            this.f26980a.B();
        }
    }

    public Byte b(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Byte) a((byte) 3, bArr, bxVar, bxVarArr);
    }

    public Double c(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Double) a((byte) 4, bArr, bxVar, bxVarArr);
    }

    public Short d(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Short) a((byte) 6, bArr, bxVar, bxVarArr);
    }

    public Integer e(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Integer) a((byte) 8, bArr, bxVar, bxVarArr);
    }

    public Long f(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Long) a((byte) 10, bArr, bxVar, bxVarArr);
    }

    public String g(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (String) a((byte) 11, bArr, bxVar, bxVarArr);
    }

    public ByteBuffer h(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (ByteBuffer) a((byte) 100, bArr, bxVar, bxVarArr);
    }

    /* JADX WARN: Finally extract failed */
    public Short i(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        Short sh;
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    this.f26980a.j();
                    sh = Short.valueOf(this.f26980a.l().f27009c);
                } else {
                    sh = null;
                }
                this.b.e();
                this.f26980a.B();
                return sh;
            } catch (Exception e) {
                throw new bw(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.f26980a.B();
            throw th;
        }
    }
}
