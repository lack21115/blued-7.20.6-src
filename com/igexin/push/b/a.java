package com.igexin.push.b;

import android.text.TextUtils;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final String f9685a = com.igexin.push.b.b.f9692a + a.class.getName();
    private static final int q = 10;
    int b;
    protected int g;
    protected volatile long h;
    protected volatile long i;
    boolean j;
    private int l;
    private int m;
    private d n;

    /* renamed from: c  reason: collision with root package name */
    final List<d> f9686c = new ArrayList();
    private final List<b> o = new ArrayList();
    final Object d = new Object();
    private final Object p = new Object();
    public volatile EnumC0278a e = EnumC0278a.NORMAL;
    private int r = 0;
    public AtomicBoolean f = new AtomicBoolean(false);
    final Comparator<d> k = new Comparator<d>() { // from class: com.igexin.push.b.a.1
        private static int a(d dVar, d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(d dVar, d dVar2) {
            return (int) (dVar.c() - dVar2.c());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.igexin.push.b.a$2  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/a$2.class */
    public static final /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9688a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[EnumC0278a.values().length];
            f9688a = iArr;
            try {
                iArr[EnumC0278a.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9688a[EnumC0278a.BACKUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9688a[EnumC0278a.TRY_NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.igexin.push.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/a$a.class */
    public enum EnumC0278a {
        NORMAL(0),
        BACKUP(1),
        TRY_NORMAL(2);
        
        int d;

        EnumC0278a(int i) {
            this.d = -1;
            this.d = i;
        }

        private int a() {
            return this.d;
        }

        public static EnumC0278a a(int i) {
            EnumC0278a[] values = values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return null;
                }
                EnumC0278a enumC0278a = values[i3];
                if (enumC0278a.d == i) {
                    return enumC0278a;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/a$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f9691a;
        public long b;

        public final b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            try {
                this.f9691a = jSONObject.getString("address");
                this.b = jSONObject.getLong("outdateTime");
                return this;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return this;
            }
        }

        public final JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("address", this.f9691a);
                jSONObject.put("outdateTime", this.b);
                return jSONObject;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                return null;
            }
        }

        public final String toString() {
            return "ServerAddress{address='" + this.f9691a + "', outdateTime=" + this.b + '}';
        }
    }

    private String a(boolean z) {
        b next;
        try {
            synchronized (this.p) {
                String str = this.j ? com.igexin.push.core.e.at : com.igexin.push.core.e.au;
                if (this.o.isEmpty() && TextUtils.isEmpty(str)) {
                    com.igexin.c.a.c.a.a(f9685a + "cm list size = 0", new Object[0]);
                    this.m = 0;
                    this.l = 0;
                    return null;
                }
                if (this.o.isEmpty() && !TextUtils.isEmpty(str)) {
                    a(str);
                }
                com.igexin.c.a.c.a.a(f9685a + "cm try = " + this.m + " times", new Object[0]);
                if (this.m >= this.o.size() * 1) {
                    com.igexin.c.a.c.a.a(f9685a + "cm invalid", new Object[0]);
                    this.m = 0;
                    this.l = 0;
                    this.o.clear();
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<b> it = this.o.iterator();
                while (it.hasNext()) {
                    if (it.next().b < currentTimeMillis) {
                        com.igexin.c.a.c.a.a(f9685a + "|add[" + next.f9691a + "] outDate", new Object[0]);
                        it.remove();
                    }
                }
                h();
                if (this.o.isEmpty()) {
                    return null;
                }
                if (z) {
                    this.m++;
                }
                int i = this.l >= this.o.size() ? 0 : this.l;
                this.l = i;
                String str2 = this.o.get(i).f9691a;
                this.l++;
                return str2;
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(f9685a, e.toString());
            com.igexin.c.a.c.a.a(f9685a + "|" + e.toString(), new Object[0]);
            return null;
        }
    }

    private void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    com.igexin.c.a.c.a.a(f9685a + "|get cm from cache, isWf = " + this.j + ", lastCmList = " + str, new Object[0]);
                    return;
                }
                this.o.add(new b().a(jSONArray.getJSONObject(i2)));
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private String b(boolean z) {
        String a2;
        synchronized (this.d) {
            int i = this.b >= this.f9686c.size() ? 0 : this.b;
            this.b = i;
            d dVar = this.f9686c.get(i);
            this.n = dVar;
            a2 = dVar.a(z);
        }
        return a2;
    }

    private void c(boolean z) {
        this.j = z;
    }

    private List<b> g() {
        return this.o;
    }

    private void h() {
        JSONArray jSONArray = new JSONArray();
        for (b bVar : this.o) {
            jSONArray.put(bVar.a());
        }
        com.igexin.push.core.e.f.a().c(jSONArray.length() == 0 ? com.igexin.push.core.b.l : jSONArray.toString(), !this.j);
    }

    private void i() {
        synchronized (this.d) {
            this.b = 0;
            Collections.sort(this.f9686c, this.k);
        }
    }

    private void j() {
        com.igexin.c.a.c.a.a(f9685a + "|detect success, current type = " + this.e, new Object[0]);
        if (this.e == EnumC0278a.BACKUP) {
            a(EnumC0278a.TRY_NORMAL);
            d.a.a();
            com.igexin.push.d.a.a(true);
        }
    }

    private void k() {
        com.igexin.c.a.c.a.a(f9685a + "|before disconnect, type = " + this.e, new Object[0]);
        int i = AnonymousClass2.f9688a[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                a(EnumC0278a.TRY_NORMAL);
            }
        } else if (System.currentTimeMillis() - this.i <= 86400000 || this.g <= com.igexin.push.config.d.t) {
        } else {
            a(EnumC0278a.BACKUP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(EnumC0278a enumC0278a) {
        synchronized (this) {
            com.igexin.c.a.c.a.a(f9685a + "|set domain type = " + enumC0278a, new Object[0]);
            if (com.igexin.push.config.d.g) {
                if (this.e != enumC0278a) {
                    a((List<b>) null);
                }
                int i = AnonymousClass2.f9688a[enumC0278a.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        this.f.set(true);
                        if (this.e != enumC0278a) {
                            this.h = System.currentTimeMillis();
                        }
                        SDKUrlConfig.setConnectAddress(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                        SDKUrlConfig.getConnectAddress();
                        com.igexin.c.a.c.a.a(f9685a + "|set domain type backup cm = " + SDKUrlConfig.getConnectAddress(), new Object[0]);
                    } else if (i == 3) {
                        if (this.e != enumC0278a) {
                            this.r = 0;
                        }
                    }
                    this.e = enumC0278a;
                    c.a().f().n();
                }
                this.b = 0;
                SDKUrlConfig.setConnectAddress(b(true));
                if (enumC0278a == EnumC0278a.NORMAL) {
                    this.f.set(false);
                }
                SDKUrlConfig.getConnectAddress();
                com.igexin.c.a.c.a.a(f9685a + "|set domain type normal cm = " + SDKUrlConfig.getConnectAddress(), new Object[0]);
                this.e = enumC0278a;
                c.a().f().n();
            }
        }
    }

    public final void a(List<b> list) {
        synchronized (this.p) {
            this.l = 0;
            this.m = 0;
            this.o.clear();
            if (list != null) {
                this.o.addAll(list);
                com.igexin.c.a.c.a.a(f9685a + "|set cm list: " + list.toString(), new Object[0]);
            }
            h();
        }
    }

    public final boolean a() {
        boolean z;
        try {
            d.a.a();
            z = true;
            boolean z2 = !com.igexin.push.d.a.d();
            String a2 = a(z2);
            com.igexin.c.a.c.a.a(f9685a + "|get from cm = " + a2, new Object[0]);
            String str = a2;
            if (a2 == null) {
                if (com.igexin.push.config.d.g && this.e == EnumC0278a.BACKUP) {
                    this.b = this.b >= SDKUrlConfig.XFR_ADDRESS_BAK.length ? 0 : this.b;
                    str = SDKUrlConfig.XFR_ADDRESS_BAK[this.b];
                    this.b++;
                } else {
                    if (this.n != null && !this.n.d()) {
                        this.b++;
                    }
                    str = b(z2);
                }
                z = false;
            }
            try {
                if (!SDKUrlConfig.getConnectAddress().equals(str)) {
                    SDKUrlConfig.getConnectAddress();
                    com.igexin.c.a.c.a.a(f9685a + "|address changed : form [" + SDKUrlConfig.getConnectAddress() + "] to [" + str + "]", new Object[0]);
                }
                SDKUrlConfig.setConnectAddress(str);
                return z;
            } catch (Exception e) {
                e = e;
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a(f9685a, e.toString());
                com.igexin.c.a.c.a.a(f9685a + "|switch address|" + e.toString(), new Object[0]);
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public final void b() {
        synchronized (this) {
            this.m = 0;
            if (this.n != null) {
                this.n.e();
            }
        }
    }

    public final void b(List<d> list) {
        synchronized (this.d) {
            this.f9686c.clear();
            this.f9686c.addAll(list);
            Collections.sort(this.f9686c, this.k);
        }
    }

    public final void c() {
        synchronized (this) {
            this.g++;
            com.igexin.c.a.c.a.a(f9685a + "|loginFailedlCnt = " + this.g, new Object[0]);
        }
    }

    public final void d() {
        if (AnonymousClass2.f9688a[this.e.ordinal()] == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
            a(EnumC0278a.TRY_NORMAL);
        }
    }

    public final void e() {
        if (this.e != EnumC0278a.BACKUP) {
            this.g = 0;
        }
        int i = AnonymousClass2.f9688a[this.e.ordinal()];
        if (i == 1) {
            this.i = System.currentTimeMillis();
            c.a().f().n();
            this.f.set(false);
        } else if (i != 3) {
        } else {
            a(EnumC0278a.NORMAL);
            this.f.set(false);
        }
    }

    public final void f() {
        EnumC0278a enumC0278a;
        com.igexin.c.a.c.a.a(f9685a + "|before disconnect, type = " + this.e, new Object[0]);
        int i = AnonymousClass2.f9688a[this.e.ordinal()];
        if (i != 1) {
            if (i == 2 && System.currentTimeMillis() - this.h > com.igexin.push.config.d.r) {
                enumC0278a = EnumC0278a.TRY_NORMAL;
                a(enumC0278a);
            }
        } else if (System.currentTimeMillis() - this.i > 86400000 && this.g > com.igexin.push.config.d.t) {
            enumC0278a = EnumC0278a.BACKUP;
            a(enumC0278a);
        }
        if (com.igexin.push.core.e.u && this.e != EnumC0278a.BACKUP) {
            this.i = System.currentTimeMillis();
            c.a().f().n();
        }
        if (AnonymousClass2.f9688a[this.e.ordinal()] != 3) {
            return;
        }
        int i2 = this.r + 1;
        this.r = i2;
        if (i2 >= 10) {
            this.g = 0;
            this.h = System.currentTimeMillis();
            a(EnumC0278a.BACKUP);
        }
    }
}
