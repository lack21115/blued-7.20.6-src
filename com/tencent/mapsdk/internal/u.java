package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.internal.mi;
import com.tencent.mapsdk.shell.events.ReportEvent;
import java.io.File;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u.class */
public final class u implements ji, ki, li {
    private static final u e = new u();
    private s b;

    /* renamed from: a  reason: collision with root package name */
    private ki f24342a = new a();

    /* renamed from: c  reason: collision with root package name */
    private ji f24343c = new b();
    private li d = new c();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u$a.class */
    public class a implements ki {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.ki
        public int a() {
            return 0;
        }

        @Override // com.tencent.mapsdk.internal.ki
        public Class a(String str) {
            return Util.findClass(str, b());
        }

        @Override // com.tencent.mapsdk.internal.ki
        public <T> Class<? extends T> a(String str, Class<T> cls) {
            return Util.findClass(str, cls, b());
        }

        @Override // com.tencent.mapsdk.internal.ki
        public Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
            return Util.invokeStaticMethod(cls, str, clsArr, objArr);
        }

        @Override // com.tencent.mapsdk.internal.ki
        public <T> T a(Class<T> cls, Object... objArr) {
            return (T) Util.newInstance(cls, objArr);
        }

        @Override // com.tencent.mapsdk.internal.ki
        public Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
            return Util.invokeMethod(obj, str, clsArr, objArr);
        }

        @Override // com.tencent.mapsdk.internal.ki
        public Object a(Object obj, String str, Object... objArr) {
            return Util.invokeMethod(obj, str, objArr);
        }

        @Override // com.tencent.mapsdk.internal.ki
        public ClassLoader b() {
            return getClass().getClassLoader();
        }

        @Override // com.tencent.mapsdk.internal.ki
        public Object b(String str) {
            return Util.newInstance(a(str), new Object[0]);
        }

        @Override // com.tencent.mapsdk.internal.ki
        public File c() {
            return null;
        }

        @Override // com.tencent.mapsdk.internal.mi.a
        public void close() {
        }

        @Override // com.tencent.mapsdk.internal.mi.a
        public void init(Context context, String str) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u$b.class */
    public class b implements ji {
        public b() {
        }

        @Override // com.tencent.mapsdk.internal.ji
        public void a(int i, Map<String, String> map) {
        }

        @Override // com.tencent.mapsdk.internal.mi.a
        public void close() {
        }

        @Override // com.tencent.mapsdk.internal.mi.a
        public void init(Context context, String str) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u$c.class */
    public class c implements li {
        public c() {
        }

        @Override // com.tencent.mapsdk.internal.mi.a
        public void close() {
        }

        @Override // com.tencent.mapsdk.internal.mi.a
        public void init(Context context, String str) {
        }

        @Override // com.tencent.mapsdk.internal.li
        public void onPauseReport() {
        }

        @Override // com.tencent.mapsdk.internal.li
        public void onReport(ReportEvent reportEvent) {
        }

        @Override // com.tencent.mapsdk.internal.li
        public void onResumeReport() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u$d.class */
    public class d implements Runnable {
        public final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f24347c;
        public final /* synthetic */ Handler d;
        public final /* synthetic */ Callback e;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/u$d$a.class */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Callback callback = d.this.e;
                if (callback != null) {
                    callback.callback(null);
                }
            }
        }

        public d(Context context, String str, Handler handler, Callback callback) {
            this.b = context;
            this.f24347c = str;
            this.d = handler;
            this.e = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.init(this.b, this.f24347c);
            this.d.post(new a());
        }
    }

    private u() {
    }

    public static u d() {
        return e;
    }

    @Override // com.tencent.mapsdk.internal.ki
    public int a() {
        return this.f24342a.a();
    }

    @Override // com.tencent.mapsdk.internal.ki
    public Class a(String str) {
        return this.f24342a.a(str);
    }

    @Override // com.tencent.mapsdk.internal.ki
    public <T> Class<? extends T> a(String str, Class<T> cls) {
        return this.f24342a.a(str, cls);
    }

    @Override // com.tencent.mapsdk.internal.ki
    public Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        return this.f24342a.a(cls, str, clsArr, objArr);
    }

    @Override // com.tencent.mapsdk.internal.ki
    public <T> T a(Class<T> cls, Object... objArr) {
        return (T) this.f24342a.a(cls, objArr);
    }

    @Override // com.tencent.mapsdk.internal.ki
    public Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        return this.f24342a.a(obj, str, clsArr, objArr);
    }

    @Override // com.tencent.mapsdk.internal.ki
    public Object a(Object obj, String str, Object... objArr) {
        return this.f24342a.a(obj, str, objArr);
    }

    @Override // com.tencent.mapsdk.internal.ji
    public void a(int i, Map<String, String> map) {
        this.f24343c.a(i, map);
    }

    public void a(Context context, String str, Callback<Void> callback) {
        new Thread(new d(context, str, new Handler(Looper.getMainLooper()), callback), "tms-plugin").start();
    }

    @Override // com.tencent.mapsdk.internal.ki
    public ClassLoader b() {
        return this.f24342a.b();
    }

    @Override // com.tencent.mapsdk.internal.ki
    public Object b(String str) {
        return this.f24342a.b(str);
    }

    @Override // com.tencent.mapsdk.internal.ki
    public File c() {
        return this.f24342a.c();
    }

    @Override // com.tencent.mapsdk.internal.mi.a
    public void close() {
        this.f24342a.close();
        this.f24343c.close();
        this.d.close();
    }

    public File e() {
        return this.f24342a.c();
    }

    public s f() {
        return this.b;
    }

    @Override // com.tencent.mapsdk.internal.mi.a
    public void init(Context context, String str) {
        mi.a(context);
        if (!mi.p.isEmpty()) {
            for (mi.b bVar : mi.p) {
                String str2 = "com.tencent.mapsdk." + bVar.b;
                ki b2 = Util.findClass(str2, u.class.getClassLoader()) != null ? this.f24342a.b(str2) : null;
                if (b2 instanceof mi.a) {
                    b2.init(context, str);
                }
                if (b2 instanceof ki) {
                    this.f24342a = b2;
                } else if (b2 instanceof li) {
                    this.d = b2;
                } else if (b2 instanceof ji) {
                    this.f24343c = b2;
                }
            }
        }
        this.f24342a.a();
        this.b = (s) this.f24342a.b("com.tencent.mapsdk.core.MapDelegateFactoryImpl");
    }

    @Override // com.tencent.mapsdk.internal.li
    public void onPauseReport() {
        this.d.onPauseReport();
    }

    @Override // com.tencent.mapsdk.internal.li
    public void onReport(ReportEvent reportEvent) {
        this.d.onReport(reportEvent);
    }

    @Override // com.tencent.mapsdk.internal.li
    public void onResumeReport() {
        this.d.onResumeReport();
    }
}
