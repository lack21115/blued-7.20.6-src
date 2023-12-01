package mtopsdk.xstate;

import android.content.Context;
import com.ut.device.UTDevice;
import java.util.HashMap;
import mtopsdk.common.util.AsyncServiceBinder;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.util.PhoneInfo;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/xstate/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap f43796a = new HashMap();
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
            synchronized (f43796a) {
                str2 = (String) f43796a.get(str);
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
            synchronized (f43796a) {
                return (String) f43796a.get(str);
            }
        }
    }

    public static void a(Context context) {
        if (context == null) {
            TBSdkLog.d("mtopsdk.XState", "[init]init() error,context is null");
            return;
        }
        try {
            f43796a.put("ua", PhoneInfo.a(context));
            f43796a.put("pv", "1.0");
            f43796a.put("t_offset", "0");
            f43796a.put(com.alipay.sdk.cons.b.g, UTDevice.getUtdid(context));
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
            synchronized (f43796a) {
                f43796a.put(str, str2);
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
            synchronized (f43796a) {
                f43796a.put(str, str2);
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
            synchronized (f43796a) {
                for (String str : f43796a.keySet()) {
                    a(str, (String) f43796a.get(str));
                }
                f43796a.clear();
            }
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.XState", "[syncToRemote]service.init() error", th);
        }
    }
}
