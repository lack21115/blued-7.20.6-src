package com.tencent.liteav.audio.earmonitor.a.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/a/b/a/b.class */
public final class b {
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f36226c = new Object();
    private static final Object d = new Object();
    private static final Object e = new Object();
    private static b f = null;

    /* renamed from: a  reason: collision with root package name */
    e f36227a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends a> T a(int i, Context context) {
        if (context != null && i == 1) {
            c cVar = new c(context);
            cVar.a(context);
            return cVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static b a() {
        b bVar;
        synchronized (f36226c) {
            if (f == null) {
                f = new b();
            }
            bVar = f;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, ServiceConnection serviceConnection) {
        synchronized (e) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (d) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.huawei.multimedia.audioengine", str);
            try {
                context.bindService(intent, serviceConnection, 1);
            } catch (SecurityException e2) {
                LiteavLog.e("HwAudioKit.FeatureKitManager", "bindService, SecurityException, %s", e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo("com.huawei.multimedia.audioengine", 0) != null;
            } catch (PackageManager.NameNotFoundException e2) {
                LiteavLog.e("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        synchronized (b) {
            if (this.f36227a != null) {
                this.f36227a.a(i);
            }
        }
    }
}
