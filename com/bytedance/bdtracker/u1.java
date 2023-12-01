package com.bytedance.bdtracker;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.applog.util.SensitiveUtils;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1.class */
public abstract class u1 {

    /* renamed from: a  reason: collision with root package name */
    public u1 f21314a;
    public Handler b;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$a.class */
    public class a implements h<String> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a() {
            return u1.this.b("openudid");
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a(String str, String str2, u1 u1Var) {
            String str3 = str;
            return u1Var == null ? str3 : u1Var.d(str3, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public void a(String str) {
            u1.this.a("openudid", str);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean a(String str, String str2) {
            return j1.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean b(String str) {
            return j1.c(str);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$b.class */
    public class b implements h<String> {
        public b() {
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a() {
            return u1.this.b("clientudid");
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a(String str, String str2, u1 u1Var) {
            String str3 = str;
            return u1Var == null ? str3 : u1Var.b(str3, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public void a(String str) {
            u1.this.a("clientudid", str);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean a(String str, String str2) {
            return j1.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean b(String str) {
            return j1.c(str);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$c.class */
    public class c implements h<String> {
        public c() {
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a() {
            return u1.this.b("serial_number");
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a(String str, String str2, u1 u1Var) {
            String str3 = str;
            return u1Var == null ? str3 : u1Var.e(str3, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public void a(String str) {
            u1.this.a("serial_number", str);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean a(String str, String str2) {
            return j1.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean b(String str) {
            String str2 = str;
            return (TextUtils.isEmpty(str2) || TextUtils.equals(str2, "unknown")) ? false : true;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$d.class */
    public class d implements h<String[]> {
        public d() {
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String[] a() {
            return u1.this.c("sim_serial_number");
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String[] a(String[] strArr, String[] strArr2, u1 u1Var) {
            String[] strArr3 = strArr;
            return u1Var == null ? strArr3 : u1Var.a(strArr3, strArr2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public void a(String[] strArr) {
            u1.this.a("sim_serial_number", strArr);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean a(String[] strArr, String[] strArr2) {
            boolean z;
            String[] strArr3 = strArr;
            String[] strArr4 = strArr2;
            if (strArr3 == strArr4) {
                return true;
            }
            if (strArr3 != null && strArr4 != null && strArr3.length == strArr4.length) {
                int length = strArr3.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = true;
                    if (i2 >= length) {
                        break;
                    }
                    String str = strArr3[i2];
                    boolean z2 = false;
                    for (String str2 : strArr4) {
                        z2 = j1.a(str2, str) || z2;
                    }
                    if (!z2) {
                        break;
                    }
                    i = i2 + 1;
                }
                return z;
            }
            z = false;
            return z;
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean b(String[] strArr) {
            String[] strArr2 = strArr;
            return strArr2 != null && strArr2.length > 0;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$e.class */
    public class e implements h<String> {
        public e() {
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a() {
            return u1.this.b("udid");
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a(String str, String str2, u1 u1Var) {
            String str3 = str;
            return u1Var == null ? str3 : u1Var.f(str3, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public void a(String str) {
            u1.this.a("udid", str);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean a(String str, String str2) {
            return j1.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean b(String str) {
            return j1.c(str);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$f.class */
    public class f implements h<String> {
        public f() {
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a() {
            return u1.this.b("udid_list");
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a(String str, String str2, u1 u1Var) {
            String str3 = str;
            return u1Var == null ? str3 : u1Var.g(str3, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public void a(String str) {
            u1.this.a("udid_list", str);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean a(String str, String str2) {
            return j1.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean b(String str) {
            return SensitiveUtils.validMultiImei(str);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$g.class */
    public class g implements h<String> {
        public g() {
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a() {
            return u1.this.b("device_id");
        }

        @Override // com.bytedance.bdtracker.u1.h
        public String a(String str, String str2, u1 u1Var) {
            String str3 = str;
            return u1Var == null ? str3 : u1Var.c(str3, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public void a(String str) {
            u1.this.a("device_id", str);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean a(String str, String str2) {
            return j1.a(str, str2);
        }

        @Override // com.bytedance.bdtracker.u1.h
        public boolean b(String str) {
            return !TextUtils.isEmpty(str);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u1$h.class */
    public interface h<L> {
        L a();

        L a(L l, L l2, u1 u1Var);

        void a(L l);

        boolean a(L l, L l2);

        boolean b(L l);
    }

    public final <T> T a(T t, T t2, h<T> hVar) {
        if (hVar != null) {
            u1 u1Var = this.f21314a;
            T a2 = hVar.a();
            boolean b2 = hVar.b(t);
            boolean b3 = hVar.b(a2);
            T t3 = t;
            if (!b2) {
                t3 = t;
                if (b3) {
                    t3 = a2;
                }
            }
            if (u1Var != null) {
                T a3 = hVar.a(t3, t2, u1Var);
                if (!hVar.a(a3, a2)) {
                    hVar.a(a3);
                }
                return a3;
            }
            boolean z = false;
            if (b2 || b3) {
                t2 = t3;
            } else {
                z = true;
            }
            if ((z && hVar.b(t2)) || (b2 && !hVar.a(t2, a2))) {
                hVar.a(t2);
            }
            return t2;
        }
        throw new IllegalArgumentException("agent == null");
    }

    public void a(Handler handler) {
        u1 u1Var = this.f21314a;
        if (u1Var != null) {
            u1Var.a(handler);
        }
        this.b = handler;
    }

    public void a(String str) {
        u1 u1Var = this.f21314a;
        if (u1Var != null) {
            u1Var.a(str);
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(String str, String[] strArr);

    public String[] a(String[] strArr, String[] strArr2) {
        return (String[]) a(strArr, strArr2, new d());
    }

    public abstract String b(String str);

    public String b(String str, String str2) {
        return (String) a(str, str2, new b());
    }

    public String c(String str, String str2) {
        return (String) a(str, str2, new g());
    }

    public abstract String[] c(String str);

    public String d(String str, String str2) {
        return (String) a(str, str2, new a());
    }

    public String e(String str, String str2) {
        return (String) a(str, str2, new c());
    }

    public String f(String str, String str2) {
        return (String) a(str, str2, new e());
    }

    public String g(String str, String str2) {
        return (String) a(str, str2, new f());
    }
}
