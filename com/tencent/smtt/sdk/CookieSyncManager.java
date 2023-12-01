package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/CookieSyncManager.class */
public class CookieSyncManager {

    /* renamed from: a  reason: collision with root package name */
    private static android.webkit.CookieSyncManager f25007a;
    private static CookieSyncManager b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f25008c = false;

    private CookieSyncManager(Context context) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            return;
        }
        a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        f25008c = true;
    }

    public static CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            try {
                f25007a = android.webkit.CookieSyncManager.createInstance(context);
                if (b == null || !f25008c) {
                    b = new CookieSyncManager(context.getApplicationContext());
                }
                cookieSyncManager = b;
            } finally {
            }
        }
        return cookieSyncManager;
    }

    public static CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            try {
                if (b == null) {
                    throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
                }
                cookieSyncManager = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cookieSyncManager;
    }

    public void startSync() {
        w a2 = w.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
            return;
        }
        f25007a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(f25007a)).setUncaughtExceptionHandler(new g());
        } catch (Exception e) {
        }
    }

    public void stopSync() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            f25007a.stopSync();
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            f25007a.sync();
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
