package com.igexin.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.igexin.push.a.b;
import com.igexin.push.f.c;
import com.igexin.push.f.d;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/d/a.class */
public class a implements InvocationHandler {
    private static String b = "ZxExecutor";

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f9671c;

    /* renamed from: a  reason: collision with root package name */
    public Context f9672a;

    /* renamed from: com.igexin.d.a$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/d/a$1.class */
    public final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.c(a.this.f9672a)) {
                    a.a(a.this, a.this.f9672a);
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.d.a$2  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/d/a$2.class */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f9674a;
        final /* synthetic */ String b;

        AnonymousClass2(Context context, String str) {
            this.f9674a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Class cls = d.a(this.f9674a, PushService.class).second;
                if (cls != null) {
                    Intent intent = new Intent(this.f9674a, cls);
                    intent.putExtra("action", PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253);
                    intent.putExtra("id", this.b);
                    c.a(this.f9674a, intent);
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (f9671c == null) {
            synchronized (a.class) {
                try {
                    if (f9671c == null) {
                        a aVar = new a();
                        f9671c = aVar;
                        return aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9671c;
    }

    static /* synthetic */ void a(a aVar, Context context) {
        try {
            Class<?> cls = Class.forName("com.zx.sdk.api.ZXManager");
            Object invoke = cls.getDeclaredMethod("newSDK", String.class).invoke(cls, com.igexin.push.a.r);
            Method declaredMethod = invoke.getClass().getDeclaredMethod("init", Context.class);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("allowPermissionDialog", Boolean.TYPE);
            declaredMethod.invoke(invoke, context);
            declaredMethod2.invoke(invoke, Boolean.FALSE);
            Class<?> cls2 = Class.forName("com.zx.sdk.api.ZXIDListener");
            invoke.getClass().getDeclaredMethod("getZXID", cls2).invoke(invoke, Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{cls2}, aVar));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(String str, Context context) {
        com.igexin.b.a.a().f9586a.execute(new AnonymousClass2(context, str));
    }

    private void b(Context context) {
        this.f9672a = context.getApplicationContext();
        com.igexin.b.a.a().b().schedule(new AnonymousClass1(), 2000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context) {
        b bVar;
        Cursor cursor = null;
        try {
            bVar = new b(context);
            Cursor cursor2 = null;
            try {
                Cursor a2 = bVar.a(com.igexin.push.core.b.U, new String[]{"value"}, "id = 79");
                if (a2 == null || !a2.moveToFirst()) {
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                            return false;
                        }
                    }
                    bVar.close();
                    return false;
                }
                cursor2 = a2;
                boolean parseBoolean = Boolean.parseBoolean(a2.getString(0));
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Throwable th2) {
                        com.igexin.c.a.c.a.a(th2);
                        return parseBoolean;
                    }
                }
                bVar.close();
                return parseBoolean;
            } catch (Throwable th3) {
                cursor = cursor2;
                th = th3;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th4) {
                        com.igexin.c.a.c.a.a(th4);
                        throw th;
                    }
                }
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bVar = null;
        }
    }

    private void d(Context context) {
        try {
            Class<?> cls = Class.forName("com.zx.sdk.api.ZXManager");
            Object invoke = cls.getDeclaredMethod("newSDK", String.class).invoke(cls, com.igexin.push.a.r);
            Method declaredMethod = invoke.getClass().getDeclaredMethod("init", Context.class);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("allowPermissionDialog", Boolean.TYPE);
            declaredMethod.invoke(invoke, context);
            declaredMethod2.invoke(invoke, Boolean.FALSE);
            Class<?> cls2 = Class.forName("com.zx.sdk.api.ZXIDListener");
            invoke.getClass().getDeclaredMethod("getZXID", cls2).invoke(invoke, Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{cls2}, this));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            String name = method.getName();
            boolean z = true;
            int hashCode = name.hashCode();
            if (hashCode != -530890460) {
                if (hashCode == 1116433148 && name.equals("onFailed")) {
                    z = true;
                }
            } else if (name.equals("onSuccess")) {
                z = false;
            }
            if (!z) {
                Object obj2 = objArr[0];
                com.igexin.c.a.c.a.b(b, " get zxid success ".concat(String.valueOf(obj2)));
                com.igexin.b.a.a().f9586a.execute(new AnonymousClass2(this.f9672a, obj2.toString()));
                return null;
            } else if (!z) {
                return null;
            } else {
                StringBuilder sb = new StringBuilder();
                int length = objArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        com.igexin.c.a.c.a.a("ZxExecutor | ", " get zxid failed code  msg = ".concat(String.valueOf(sb)));
                        return null;
                    }
                    sb.append(objArr[i2]);
                    sb.append(",");
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
            return null;
        }
    }
}
