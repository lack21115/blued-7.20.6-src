package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/am.class */
public class am {
    private static am B;
    private static final String Code = "hiad_sp_properties_cache_sdk";
    private static final String I = "PropertiesCache";
    private static final String V = "cache_data";
    private static final byte[] Z = new byte[0];
    private SharedPreferences C;
    private a F;
    private final byte[] S = new byte[0];

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/am$a.class */
    public static final class a implements Cloneable {
        String B;
        Integer C;
        String Code;
        String D;
        String F;
        String I;
        String L;
        Boolean S;
        Boolean V;
        Boolean Z;

        /* renamed from: a  reason: collision with root package name */
        Integer f9385a;
        Integer b;

        /* renamed from: Code */
        public a clone() {
            a aVar = new a();
            aVar.Code = this.Code;
            aVar.V = this.V;
            aVar.I = this.I;
            aVar.Z = this.Z;
            aVar.B = this.B;
            aVar.C = this.C;
            aVar.S = this.S;
            aVar.F = this.F;
            aVar.D = this.D;
            aVar.L = this.L;
            aVar.f9385a = this.f9385a;
            aVar.b = this.b;
            return aVar;
        }
    }

    private am(Context context) {
        this.C = context.getSharedPreferences(Code, 0);
    }

    public static am Code(Context context) {
        am amVar;
        synchronized (Z) {
            if (B == null) {
                B = new am(context);
            }
            amVar = B;
        }
        return amVar;
    }

    private void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        final a clone = aVar.clone();
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.am.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = am.this.C.edit();
                edit.putString(am.V, z.V(clone));
                edit.apply();
            }
        });
    }

    private void d() {
        if (this.F == null) {
            String string = this.C.getString(V, null);
            a aVar = null;
            if (string != null) {
                aVar = null;
                if (string.length() > 0) {
                    aVar = (a) z.V(string, a.class, new Class[0]);
                }
            }
            a aVar2 = aVar;
            if (aVar == null) {
                aVar2 = new a();
            }
            this.F = aVar2;
        }
    }

    public Boolean B() {
        synchronized (this.S) {
            d();
            if (this.F.Z != null) {
                return this.F.Z;
            }
            return null;
        }
    }

    public void B(boolean z) {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return;
            }
            this.F.L = String.valueOf(z);
            Code(this.F);
        }
    }

    public String C() {
        String str;
        synchronized (this.S) {
            d();
            str = this.F.B;
        }
        return str;
    }

    public void Code() {
        synchronized (this.S) {
            d();
        }
    }

    public void Code(int i) {
        synchronized (this.S) {
            d();
            this.F.C = Integer.valueOf(i);
            Code(this.F);
        }
    }

    public void Code(Boolean bool) {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return;
            }
            this.F.S = bool;
            Code(this.F);
        }
    }

    public void Code(Integer num) {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return;
            }
            this.F.f9385a = num;
            Code(this.F);
        }
    }

    public void Code(String str) {
        synchronized (this.S) {
            d();
            this.F.I = str;
            Code(this.F);
        }
    }

    public void Code(boolean z) {
        synchronized (this.S) {
            d();
            this.F.V = Boolean.valueOf(z);
            Code(this.F);
        }
    }

    public String D() {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return "";
            }
            return this.F.F;
        }
    }

    public Boolean F() {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return null;
            }
            return this.F.S;
        }
    }

    public String I() {
        synchronized (this.S) {
            d();
            if (this.F.I != null) {
                return this.F.I;
            }
            return null;
        }
    }

    public void I(String str) {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return;
            }
            this.F.F = str;
            Code(this.F);
        }
    }

    public void I(boolean z) {
        synchronized (this.S) {
            d();
            this.F.Z = Boolean.valueOf(z);
            Code(this.F);
        }
    }

    public String L() {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return null;
            }
            if (this.F.D != null) {
                return this.F.D;
            }
            return null;
        }
    }

    public Integer S() {
        synchronized (this.S) {
            d();
            if (this.F.C != null) {
                return this.F.C;
            }
            return null;
        }
    }

    public void V(Integer num) {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return;
            }
            this.F.b = num;
            Code(this.F);
        }
    }

    public void V(String str) {
        synchronized (this.S) {
            d();
            this.F.B = str;
            Code(this.F);
        }
    }

    public void V(boolean z) {
        synchronized (this.S) {
            d();
            this.F.Code = String.valueOf(z);
            Code(this.F);
        }
    }

    public boolean V() {
        synchronized (this.S) {
            d();
            if (this.F.V != null) {
                return this.F.V.booleanValue();
            }
            return false;
        }
    }

    public String Z() {
        String str;
        synchronized (this.S) {
            d();
            str = this.F.Code;
        }
        return str;
    }

    public void Z(boolean z) {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return;
            }
            this.F.D = String.valueOf(z);
            Code(this.F);
        }
    }

    public String a() {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return null;
            }
            if (this.F.L != null) {
                return this.F.L;
            }
            return null;
        }
    }

    public Integer b() {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return null;
            }
            return this.F.f9385a;
        }
    }

    public Integer c() {
        synchronized (this.S) {
            d();
            if (this.F == null) {
                return null;
            }
            if (this.F.b != null) {
                return this.F.b;
            }
            return null;
        }
    }
}
