package com.oplus.quickgame.sdk.engine.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.heytap.baselib.utils.ClientIdUtils;
import com.oplus.quickgame.sdk.engine.ui.MD5Util;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f24410a = "";
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f24411c = false;
    private static String e = "";
    private static boolean f;
    private static Handler g;
    private static HandlerThread h;
    private static Object d = new Object();
    private static final Object i = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/utils/e$a.class */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f24412a;

        a(Context context) {
            this.f24412a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(e.e)) {
                    e.e(this.f24412a);
                    String unused = e.e = com.oplus.stdid.sdk.a.e(this.f24412a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(Context context, h hVar) {
        String str = f24410a;
        String clientId = ClientIdUtils.INSTANCE.getClientId(context);
        if (!b(clientId) || TextUtils.equals(clientId, str)) {
            return;
        }
        a(context, clientId);
        f24410a = clientId;
        hVar.a(str, clientId);
    }

    private static void a(Context context, String str) {
        String b2 = b.b(MD5Util.md5Hex(context.getPackageName()), str);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.nearme.common.util.DeviceUtil", 0).edit();
        edit.putString("imei", b2);
        edit.commit();
    }

    protected static Handler b() {
        Handler handler;
        synchronized (i) {
            if (h == null || !h.isAlive()) {
                HandlerThread handlerThread = new HandlerThread("xgame_getDeviceId");
                h = handlerThread;
                handlerThread.start();
                Looper looper = h.getLooper();
                g = looper != null ? new Handler(looper) : new Handler();
            }
            handler = g;
        }
        return handler;
    }

    public static String b(Context context) {
        return b(context, null);
    }

    public static String b(Context context, h hVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        synchronized (e.class) {
            try {
                if (!b(f24410a)) {
                    String c2 = c(context);
                    f24410a = c2;
                    if (!b(c2)) {
                        String clientId = ClientIdUtils.INSTANCE.getClientId(context);
                        f24410a = clientId;
                        if (b(clientId)) {
                            a(context, f24410a);
                        }
                    }
                }
                if (hVar != null && (!b || f)) {
                    f = false;
                    a(context, hVar);
                    b = true;
                }
            } catch (Throwable th) {
            }
            try {
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f24410a;
    }

    private static boolean b(String str) {
        return (TextUtils.isEmpty(str) || "000000000000000".equals(str)) ? false : true;
    }

    public static int c() {
        return Build.VERSION.SDK_INT;
    }

    private static String c(Context context) {
        String string = context.getSharedPreferences("com.nearme.common.util.DeviceUtil", 0).getString("imei", f24410a);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return com.oplus.quickgame.sdk.engine.utils.a.a(MD5Util.md5Hex(context.getPackageName()), string);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (Build.VERSION.SDK_INT < 29) {
            return "";
        }
        b().post(new a(context));
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context) {
        if (f24411c) {
            return;
        }
        synchronized (d) {
            if (!f24411c) {
                com.oplus.stdid.sdk.a.b(context);
                f24411c = true;
            }
        }
    }
}
