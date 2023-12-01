package com.wrapper.proxyapplication;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/WrapperProxyApplication.class */
public abstract class WrapperProxyApplication extends Application {
    static Context baseContext;
    static String className = "com.soft.blued.app.BluedApplication";
    static ClassLoader mLoader;
    static Application shellApp;
    static String tinkerApp = "tinker support";

    private boolean Fixappname() {
        synchronized (this) {
            if (className.startsWith(".")) {
                className = super.getPackageName() + className;
            } else if (className.indexOf(".") < 0) {
                className = super.getPackageName() + "." + className;
            }
        }
        return true;
    }

    public static void fixAndroid(Context context, Application application) {
        if (Build.VERSION.SDK_INT == 28) {
            try {
                mLoader = AndroidNClassLoader.inject(context.getClassLoader(), application);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static String getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "0";
        }
    }

    static Context getWrapperProxyAppBaseContext() {
        return baseContext;
    }

    native void Ooo0ooO0oO();

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        baseContext = getBaseContext();
        if (shellApp == null) {
            shellApp = this;
        }
        Fixappname();
        initProxyApplication(context);
    }

    protected abstract void initProxyApplication(Context context);

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Ooo0ooO0oO();
    }
}
