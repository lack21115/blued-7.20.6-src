package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/interior/Log.class */
public class Log {

    /* renamed from: a  reason: collision with root package name */
    private static long f4631a;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/interior/Log$ISdkLogCallback.class */
    public interface ISdkLogCallback {
        void onLogLine(String str);
    }

    public static boolean forcedLogReport(Context context) {
        try {
            b.a().a(context);
            long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (elapsedRealtime - f4631a < 600) {
                return false;
            }
            f4631a = elapsedRealtime;
            a.a(context);
            return true;
        } catch (Exception e) {
            c.a(e);
            return false;
        }
    }

    public static void setupLogCallback(ISdkLogCallback iSdkLogCallback) {
        c.a(iSdkLogCallback);
    }
}
