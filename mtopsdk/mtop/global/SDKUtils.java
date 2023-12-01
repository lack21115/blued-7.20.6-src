package mtopsdk.mtop.global;

import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.unit.UnitConfigManager;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.a;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/global/SDKUtils.class */
public class SDKUtils {

    /* renamed from: a  reason: collision with root package name */
    private static SDKConfig f43765a = SDKConfig.a();

    public static long a() {
        return b() + (System.currentTimeMillis() / 1000);
    }

    public static void a(String str) {
        if (str != null) {
            f43765a.b(str);
        }
    }

    public static void a(String str, String str2) {
        a.a("sid", str);
        a.a("uid", str2);
        MtopSDKThreadPoolExecutorFactory.a(new Runnable() { // from class: mtopsdk.mtop.global.SDKUtils.1
            @Override // java.lang.Runnable
            public final void run() {
                UnitConfigManager.a();
            }
        });
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b("mtopsdk.SDKUtils", "[registerSessionInfo]register sessionInfo succeed,sid=" + str + ",uid=" + str2);
        }
    }

    public static long b() {
        String c2 = a.c();
        if (!StringUtils.a(c2)) {
            a.a("t_offset", "0");
            return 0L;
        }
        try {
            return Long.parseLong(c2);
        } catch (NumberFormatException e) {
            TBSdkLog.d("mtopsdk.SDKUtils", "[getTimeOffset]parse t_offset failed");
            return 0L;
        }
    }

    public static void b(String str) {
        if (str != null) {
            f43765a.c(str);
        }
    }
}
