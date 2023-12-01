package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/COSPushHelper.class */
public class COSPushHelper {

    /* renamed from: a  reason: collision with root package name */
    private static long f27494a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f60a = false;

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f27494a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                f27494a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f60a;
    }

    public static boolean hasNetwork(Context context) {
        return i.m8432a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a2 = f.a(context).a(e.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            try {
                f60a = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void uploadToken(Context context, String str) {
        i.m8431a(context, e.ASSEMBLE_PUSH_COS, str);
    }
}
