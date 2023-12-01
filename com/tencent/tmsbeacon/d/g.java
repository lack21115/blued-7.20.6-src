package com.tencent.tmsbeacon.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.tmsbeacon.a.d.a;
import java.util.Date;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f25855a;
    private c d;
    private final String b = "sid";
    private String e = "";
    private boolean f = true;
    private int g = 8081;
    private String h = "";
    private String i = "";

    /* renamed from: c  reason: collision with root package name */
    private final Context f25856c = com.tencent.tmsbeacon.a.c.c.d().c();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/g$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f25856c != null) {
                g gVar = g.this;
                gVar.a(gVar.f25856c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/g$b.class */
    public class b implements Runnable {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25857c;

        public b(String str, String str2) {
            this.b = str;
            this.f25857c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Date d = com.tencent.tmsbeacon.base.util.b.d(this.b);
            long time = d != null ? d.getTime() / 1000 : 0L;
            long j = time;
            if (time == 0) {
                j = (new Date().getTime() / 1000) + 86400;
            }
            a.SharedPreferences$EditorC0861a edit = com.tencent.tmsbeacon.a.d.a.a().edit();
            if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("sid_value", this.f25857c).putLong("sid_mt", j);
            }
        }
    }

    private g() {
        com.tencent.tmsbeacon.a.b.a.a().a(new a());
    }

    public static g b() {
        if (f25855a == null) {
            synchronized (g.class) {
                try {
                    if (f25855a == null) {
                        f25855a = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25855a;
    }

    public String a() {
        String str;
        synchronized (this) {
            str = this.i;
        }
        return str;
    }

    public String a(String str) {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.a(str);
        }
        return null;
    }

    public void a(Context context) {
        synchronized (this) {
            com.tencent.tmsbeacon.a.d.a a2 = com.tencent.tmsbeacon.a.d.a.a();
            String string = a2.getString("sid_value", "");
            if (a2.getLong("sid_mt", 0L) > new Date().getTime() / 1000) {
                b(string);
            }
            a(context, com.tencent.tmsbeacon.base.util.b.b());
        }
    }

    public void a(Context context, String str) {
        synchronized (this) {
            this.i = str;
            byte[] a2 = com.tencent.tmsbeacon.base.net.b.c.a(context, str);
            if (a2 != null) {
                this.h = Base64.encodeToString(a2, 2);
            }
        }
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    public void a(String str, String str2) {
        synchronized (this) {
            com.tencent.tmsbeacon.base.util.c.a("[net] -> update local sid|time[%s|%s].", str, str2);
            this.e = str;
            com.tencent.tmsbeacon.a.b.a.a().a(new b(str2, str));
        }
    }

    public void b(String str) {
        synchronized (this) {
            this.e = str;
        }
    }

    public String c() {
        String str;
        synchronized (this) {
            str = this.e;
        }
        return str;
    }

    public String d() {
        String str;
        synchronized (this) {
            str = this.h;
        }
        return str;
    }
}
