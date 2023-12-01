package com.amap.api.col.p0003sl;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.jv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jv.class */
public abstract class jv extends hv {

    /* renamed from: a  reason: collision with root package name */
    protected Context f5232a;
    protected ia b;
    protected byte[] g;

    public jv(Context context, ia iaVar) {
        if (context != null) {
            this.f5232a = context.getApplicationContext();
        }
        this.b = iaVar;
        setBinary(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] a(byte[] bArr) {
        return ib.a(bArr.length);
    }

    private static byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(ib.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                it.a(th, "bre", "gbh");
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                it.a(th2, "bre", "gbh");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    it.a(th3, "bre", "gbh");
                    return null;
                }
            } catch (Throwable th4) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    it.a(th5, "bre", "gbh");
                }
                throw th4;
            }
        }
    }

    private byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (f()) {
                byte[] a2 = hr.a(this.f5232a, h(), this.b != null && "navi".equals(this.b.a()));
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a3 = ib.a(e());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = ib.a(g());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a4));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                it.a(th, "bre", "gred");
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                it.a(th2, "bre", "gpd");
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    it.a(th3, "bre", "gred");
                }
            }
        }
    }

    private byte[] k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c2 = c();
            if (c2 != null && c2.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(a(c2));
                byteArrayOutputStream.write(c2);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    it.a(th, "bre", "grrd");
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th2) {
                it.a(th2, "bre", "grrd");
                return byteArray2;
            }
        } catch (Throwable th3) {
            try {
                it.a(th3, "bre", "grrd");
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    it.a(th4, "bre", "grrd");
                }
            }
        }
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d = d();
            if (d != null && d.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] a2 = hr.a(d);
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    it.a(th, "bre", "gred");
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th2) {
                it.a(th2, "bre", "gred");
                return byteArray2;
            }
        } catch (Throwable th3) {
            try {
                it.a(th3, "bre", "gred");
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    it.a(th4, "bre", "gred");
                }
            }
        }
    }

    public abstract byte[] c();

    public abstract byte[] d();

    protected String e() {
        return "2.1";
    }

    public boolean f() {
        return true;
    }

    public String g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.c(), this.b.a());
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final byte[] getEntityBytes() {
        byte[] bArr = this.g;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.g = byteArray;
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                it.a(th, "bre", "geb");
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                it.a(th2, "bre", "geb");
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th3) {
                    it.a(th3, "bre", "geb");
                    return null;
                }
            } catch (Throwable th4) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    it.a(th5, "bre", "geb");
                }
                throw th4;
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.kb
    public Map<String, String> getParams() {
        String f = ho.f(this.f5232a);
        String a2 = hr.a();
        String a3 = hr.a(this.f5232a, a2, "key=".concat(String.valueOf(f)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    protected boolean h() {
        return false;
    }
}
