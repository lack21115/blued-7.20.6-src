package mtopsdk.common.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Method;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/AsyncServiceBinder.class */
public abstract class AsyncServiceBinder {
    private Class b;
    private Class c;
    protected volatile IInterface a = null;
    private Object d = new Object();
    private ServiceConnection e = new ServiceConnection() { // from class: mtopsdk.common.util.AsyncServiceBinder.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (AsyncServiceBinder.this.d) {
                if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.a("mtopsdk.AsyncServiceBinder", "[onServiceConnected] Service connected called. interfaceName =" + AsyncServiceBinder.this.c());
                }
                try {
                    Class<?>[] declaredClasses = AsyncServiceBinder.this.b.getDeclaredClasses();
                    int length = declaredClasses.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        Class<?> cls = declaredClasses[i2];
                        if (cls.getSimpleName().equals("Stub")) {
                            AsyncServiceBinder.this.a = (IInterface) cls.getDeclaredMethod("asInterface", IBinder.class).invoke(cls, iBinder);
                        }
                        i = i2 + 1;
                    }
                } catch (Exception e) {
                    if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                        TBSdkLog.c("mtopsdk.AsyncServiceBinder", "[onServiceConnected] Service bind failed. interfaceName=" + AsyncServiceBinder.this.c());
                    }
                }
                if (AsyncServiceBinder.this.a != null) {
                    AsyncServiceBinder.this.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (AsyncServiceBinder.this.d) {
                AsyncServiceBinder.this.a = null;
            }
        }
    };

    public AsyncServiceBinder(Class cls, Class cls2) {
        this.b = cls;
        this.c = cls2;
    }

    private static Object a(String str, String str2, Class[] clsArr, Object... objArr) {
        Object obj = null;
        if (str != null) {
            if (str2 == null) {
                return null;
            }
            Class<?> cls = Class.forName(str);
            Method declaredMethod = clsArr != null ? cls.getDeclaredMethod(str2, clsArr) : cls.getDeclaredMethod(str2, new Class[0]);
            obj = null;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                if (objArr != null) {
                    return declaredMethod.invoke(cls, objArr);
                }
                obj = declaredMethod.invoke(cls, new Object[0]);
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        try {
            return this.b.getSimpleName();
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.AsyncServiceBinder", "[getInterfaceName]getInterfaceName error.interfaceName =" + this.b, th);
            return null;
        }
    }

    protected abstract void a();

    public void a(Context context) {
        if (this.a == null) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.a("mtopsdk.AsyncServiceBinder", "[asyncBind]try to bind service for " + c());
            }
            try {
                a("com.taobao.android.service.Services", "bind", new Class[]{Context.class, Class.class, ServiceConnection.class}, context.getApplicationContext(), this.b, this.e);
                if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.a("mtopsdk.AsyncServiceBinder", "[asyncBind]bind service by service framework");
                }
            } catch (ClassNotFoundException e) {
                if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.c("mtopsdk.AsyncServiceBinder", "[asyncBind]service framework not exist. use intent to bind service.");
                }
                Intent intent = new Intent(context.getApplicationContext(), this.c);
                intent.setAction(this.b.getName());
                intent.setPackage(context.getPackageName());
                intent.addCategory("android.intent.category.DEFAULT");
                boolean bindService = context.bindService(intent, this.e, 1);
                if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.a("mtopsdk.AsyncServiceBinder", "[asyncBind]bindService ret=" + bindService);
                }
            } catch (NoSuchMethodException e2) {
                if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.a("mtopsdk.AsyncServiceBinder", "[asyncBind]service framework not exist. use intent to bind service.");
                }
                Intent intent2 = new Intent(context.getApplicationContext(), this.c);
                intent2.setAction(this.b.getName());
                intent2.setPackage(context.getPackageName());
                intent2.addCategory("android.intent.category.DEFAULT");
                boolean bindService2 = context.bindService(intent2, this.e, 1);
                if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.a("mtopsdk.AsyncServiceBinder", "[asyncBind]bindService ret=" + bindService2);
                }
            } catch (Throwable th) {
                if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.c("mtopsdk.AsyncServiceBinder", "[asyncBind]Service bind failed. interfaceName =" + c());
                }
            }
        }
    }

    public IInterface b() {
        return this.a;
    }
}
