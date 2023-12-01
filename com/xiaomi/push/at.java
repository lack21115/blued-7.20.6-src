package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/at.class */
public class at implements as, InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final String[][] f27567a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a  reason: collision with other field name */
    private Context f146a;

    /* renamed from: a  reason: collision with other field name */
    private Class f148a = null;
    private Class b = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f150a = null;

    /* renamed from: b  reason: collision with other field name */
    private Method f151b = null;

    /* renamed from: c  reason: collision with root package name */
    private Method f27568c = null;
    private Method d = null;
    private Method e = null;
    private Method f = null;
    private Method g = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f149a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private volatile int f144a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile long f145a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f147a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/at$a.class */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        Boolean f152a;

        /* renamed from: a  reason: collision with other field name */
        String f153a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f27570c;
        String d;

        private a() {
            this.f152a = null;
            this.f153a = null;
            this.b = null;
            this.f27570c = null;
            this.d = null;
        }

        boolean a() {
            if (!TextUtils.isEmpty(this.f153a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.f27570c) || !TextUtils.isEmpty(this.d)) {
                this.f152a = Boolean.TRUE;
            }
            return this.f152a != null;
        }
    }

    public at(Context context) {
        this.f146a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return r.a(context, str);
        } catch (Throwable th) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method != null) {
            try {
                T t = (T) method.invoke(obj, objArr);
                if (t != null) {
                    return t;
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    private void a() {
        synchronized (this.f149a) {
            try {
                this.f149a.notifyAll();
            } catch (Exception e) {
            }
        }
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = f27567a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index ".concat(String.valueOf(i)));
                cls = a3;
                cls2 = a4;
                break;
            }
            i++;
            cls = a3;
            cls2 = a4;
        }
        this.f148a = a2;
        this.f150a = a(a2, "InitSdk", Context.class, cls);
        this.b = cls;
        this.f27568c = a(cls2, "getOAID", new Class[0]);
        this.f = a(cls2, "isSupported", new Class[0]);
        this.g = a(cls2, "shutDown", new Class[0]);
    }

    private void a(String str) {
        if (this.f147a != null) {
            return;
        }
        long j = this.f145a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f144a;
        long j2 = j;
        long j3 = elapsedRealtime;
        if (elapsedRealtime > com.anythink.expressad.video.module.a.a.m.ag) {
            j2 = j;
            j3 = elapsedRealtime;
            if (i < 3) {
                synchronized (this.f149a) {
                    j2 = j;
                    j3 = elapsedRealtime;
                    if (this.f145a == j) {
                        j2 = j;
                        j3 = elapsedRealtime;
                        if (this.f144a == i) {
                            b("retry, current count is ".concat(String.valueOf(i)));
                            this.f144a++;
                            b(this.f146a);
                            j2 = this.f145a;
                            j3 = SystemClock.elapsedRealtime() - Math.abs(j2);
                        }
                    }
                }
            }
        }
        if (this.f147a != null || j2 < 0 || j3 > com.anythink.expressad.video.module.a.a.m.ag || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f149a) {
            if (this.f147a == null) {
                try {
                    b(str + " wait...");
                    this.f149a.wait(com.anythink.expressad.video.module.a.a.m.ag);
                } catch (Exception e) {
                }
            }
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                ClassLoader classLoader2 = classLoader;
                if (classLoader == null) {
                    classLoader2 = context.getClassLoader();
                }
                a(this.f150a, this.f148a.newInstance(), context, Proxy.newProxyInstance(classLoader2, new Class[]{this.b}, this));
            } catch (Throwable th) {
                b("call init sdk error:".concat(String.valueOf(th)));
            }
            this.f145a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f145a = elapsedRealtime;
    }

    private static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m8344a("mdid:".concat(String.valueOf(str)));
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public String mo8458a() {
        a("getOAID");
        if (this.f147a == null) {
            return null;
        }
        return this.f147a.b;
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public boolean mo8459a() {
        a("isSupported");
        return this.f147a != null && Boolean.TRUE.equals(this.f147a.f152a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f145a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            boolean z = false;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Object obj2 = objArr[i2];
                if (obj2 != null && !a(obj2)) {
                    aVar.b = (String) a(this.f27568c, obj2, new Object[0]);
                    aVar.f152a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder("has get succ, check duplicate:");
                        if (this.f147a != null) {
                            z = true;
                        }
                        sb.append(z);
                        b(sb.toString());
                        synchronized (at.class) {
                            try {
                                if (this.f147a == null) {
                                    this.f147a = aVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        a();
        return null;
    }
}
