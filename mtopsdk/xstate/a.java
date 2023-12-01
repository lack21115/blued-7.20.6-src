package mtopsdk.xstate;

import android.content.Context;
import com.ut.device.UTDevice;
import java.util.HashMap;
import mtopsdk.common.util.AsyncServiceBinder;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.util.PhoneInfo;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/xstate/a.class */
public final class a {
    private static final HashMap a = new HashMap();
    private static AsyncServiceBinder b;

    public static String a() {
        return a("sid");
    }

    public static String a(String str) {
        String str2;
        AsyncServiceBinder asyncServiceBinder = b;
        if (asyncServiceBinder == null || asyncServiceBinder.b() == null) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.c("mtopsdk.XState", "[getValue]Attention :User XState Local Mode : key=" + str);
            }
            synchronized (a) {
                str2 = (String) a.get(str);
            }
            return str2;
        }
        try {
            return ((mtopsdk.xstate.a.a) b.b()).a(str);
        } catch (Exception e) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.d("mtopsdk.XState", "[getValue] getValue by key=" + str + " error ---" + e.toString());
                StringBuilder sb = new StringBuilder("[getValue]Attention :User XState Local Mode : key=");
                sb.append(str);
                TBSdkLog.c("mtopsdk.XState", sb.toString());
            }
            synchronized (a) {
                return (String) a.get(str);
            }
        }
    }

    public static void a(Context context) {
        if (context == null) {
            TBSdkLog.d("mtopsdk.XState", "[init]init() error,context is null");
            return;
        }
        try {
            a.put("ua", PhoneInfo.a(context));
            a.put("pv", "1.0");
            a.put("t_offset", "0");
            a.put(com.alipay.sdk.cons.b.g, UTDevice.getUtdid(context));
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.XState", "[initPhoneInfo]initPhoneInfo error", th);
        }
        if (b != null) {
            d();
            return;
        }
        b bVar = new b(mtopsdk.xstate.a.a.class, d.class);
        b = bVar;
        bVar.a(context);
    }

    public static void a(String str, String str2) {
        AsyncServiceBinder asyncServiceBinder = b;
        if (asyncServiceBinder == null || asyncServiceBinder.b() == null) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.b("mtopsdk.XState", "[setValue]Attention :User XState Local Mode: key:" + str + " value:" + str2);
            }
            synchronized (a) {
                a.put(str, str2);
            }
            return;
        }
        try {
            ((mtopsdk.xstate.a.a) b.b()).a(str, str2);
        } catch (Exception e) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.d("mtopsdk.XState", "[setValue] setValue failed ,key=" + str + ",value=" + str2 + "; ---" + e.toString());
                StringBuilder sb = new StringBuilder("[setValue]Attention :User XState Local Mode: key:");
                sb.append(str);
                sb.append(" value:");
                sb.append(str2);
                TBSdkLog.c("mtopsdk.XState", sb.toString());
            }
            synchronized (a) {
                a.put(str, str2);
            }
        }
    }

    public static String b() {
        return a("uid");
    }

    public static String c() {
        return a("t_offset");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d() {
        AsyncServiceBinder asyncServiceBinder = b;
        if (asyncServiceBinder == null || asyncServiceBinder.b() == null) {
            return;
        }
        try {
            ((mtopsdk.xstate.a.a) b.b()).a();
            synchronized (a) {
                for (String str : a.keySet()) {
                    a(str, (String) a.get(str));
                }
                a.clear();
            }
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.XState", "[syncToRemote]service.init() error", th);
        }
    }
}
