package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.c;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/tid/TidHelper.class */
public class TidHelper {
    private static Tid a(Context context, b bVar) {
        if (bVar == null || bVar.e()) {
            return null;
        }
        return new Tid(bVar.a(), bVar.b(), bVar.i().longValue());
    }

    private static void a(Context context) {
        if (context == null) {
            return;
        }
        com.alipay.sdk.sys.b.a().a(context);
    }

    private static Tid b(Context context) throws Exception {
        try {
            com.alipay.sdk.packet.b a2 = new c().a(com.alipay.sdk.sys.a.a(), context);
            if (a2 != null) {
                JSONObject jSONObject = new JSONObject(a2.b());
                b a3 = b.a(context);
                String optString = jSONObject.optString("tid");
                String string = jSONObject.getString(b.e);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                    a3.a(optString, string);
                }
                return a(context, a3);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void clearTID(Context context) {
        b.a(context).g();
    }

    public static String getIMEI(Context context) {
        a(context);
        return com.alipay.sdk.util.a.a(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return com.alipay.sdk.util.a.a(context).a();
    }

    public static String getTIDValue(Context context) {
        String tid;
        synchronized (TidHelper.class) {
            try {
                Tid loadOrCreateTID = loadOrCreateTID(context);
                tid = Tid.isEmpty(loadOrCreateTID) ? "" : loadOrCreateTID.getTid();
            } finally {
            }
        }
        return tid;
    }

    public static String getVirtualImei(Context context) {
        a(context);
        com.alipay.sdk.data.c.b();
        return com.alipay.sdk.data.c.c();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        com.alipay.sdk.data.c.b();
        return com.alipay.sdk.data.c.d();
    }

    public static Tid loadLocalTid(Context context) {
        b a2 = b.a(context);
        if (a2.h()) {
            return null;
        }
        return new Tid(a2.a(), a2.b(), a2.i().longValue());
    }

    public static Tid loadOrCreateTID(Context context) {
        synchronized (TidHelper.class) {
            try {
                com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "load_create_tid");
                a(context);
                Tid loadTID = loadTID(context);
                Tid tid = loadTID;
                if (Tid.isEmpty(loadTID)) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        return null;
                    }
                    try {
                        tid = b(context);
                    } catch (Throwable th) {
                        tid = loadTID;
                    }
                }
                return tid;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Tid loadTID(Context context) {
        a(context);
        Tid a2 = a(context, b.a(context));
        if (a2 == null) {
            com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "load_tid null");
        }
        return a2;
    }

    public static boolean resetTID(Context context) throws Exception {
        Tid tid;
        com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "reset_tid");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a(context);
            clearTID(context);
            try {
                tid = b(context);
            } catch (Throwable th) {
                tid = null;
            }
            return !Tid.isEmpty(tid);
        }
        throw new Exception("Must be called on worker thread");
    }
}
