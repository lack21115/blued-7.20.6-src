package com.soft.blued.sdk;

import android.content.Context;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/SDKActionManager.class */
public class SDKActionManager {

    /* renamed from: a  reason: collision with root package name */
    private static SDKBaseAction f16056a;

    public static void a() {
        synchronized (SDKActionManager.class) {
            try {
                SDKBaseAction b = b();
                Logger.a("SDKAction", "sdkManager finishAction, sdkAction:", b);
                if (b != null) {
                    b.b();
                }
                b((SDKBaseAction) null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context) {
        SDKBaseAction b = b();
        Logger.a("SDKAction", "sdkManager startAction, sdkAction:", b);
        if (b != null) {
            b.a(context);
        }
    }

    public static void a(Context context, long j) {
        synchronized (SDKActionManager.class) {
            try {
                Logger.a("SDKAction", "sdkManager cancelAction, actionId:", Long.valueOf(j));
                SDKBaseAction b = b();
                if (a(j, b)) {
                    Logger.a("SDKAction", "action id checked and cancel it, sdkAction:", b);
                    b.d(context);
                    b((SDKBaseAction) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(SDKBaseAction sDKBaseAction) {
        Logger.a("SDKAction", "sdkManager setAction, newAction:", sDKBaseAction);
        SDKBaseAction b = b();
        if (b != null) {
            Logger.a("SDKAction", "has oldAction, so finish it, oldAction:", b);
            b.b();
        }
        b(sDKBaseAction);
    }

    public static boolean a(long j) {
        if (j == 0) {
            return true;
        }
        return a(j, b());
    }

    public static boolean a(long j, SDKBaseAction sDKBaseAction) {
        return (sDKBaseAction == null || sDKBaseAction.c() || sDKBaseAction.a() != j) ? false : true;
    }

    private static SDKBaseAction b() {
        synchronized (SDKActionManager.class) {
            try {
                if (f16056a == null || f16056a.c()) {
                    return null;
                }
                return f16056a;
            } finally {
            }
        }
    }

    public static SDKBaseAction b(long j) {
        SDKBaseAction b = b();
        if (a(j, b)) {
            return b;
        }
        return null;
    }

    private static void b(SDKBaseAction sDKBaseAction) {
        synchronized (SDKActionManager.class) {
            try {
                f16056a = sDKBaseAction;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(long j) {
        synchronized (SDKActionManager.class) {
            try {
                Logger.a("SDKAction", "sdkManager finishAction, actionId:", Long.valueOf(j));
                SDKBaseAction b = b();
                if (a(j, b)) {
                    Logger.a("SDKAction", "action id checked and finish it, sdkAction:", b);
                    b.b();
                    b((SDKBaseAction) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
