package mtopsdk.mtop.global;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.a.a;
import mtopsdk.common.util.LocalConfig;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/global/SwitchConfig.class */
public class SwitchConfig {
    private static final SwitchConfig a = new SwitchConfig();
    private static final RemoteConfig b = RemoteConfig.a();
    private static final LocalConfig c = LocalConfig.a();
    private static a d = null;
    private static long e = 10;
    private static Map f = new ConcurrentHashMap();

    private SwitchConfig() {
    }

    public static SwitchConfig a() {
        return a;
    }

    public long a(String str) {
        if (StringUtils.b(str)) {
            return 0L;
        }
        String str2 = (String) f.get(str);
        if (StringUtils.b(str2)) {
            return 0L;
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception e2) {
            TBSdkLog.d("mtopsdk.SwitchConfig", "[getIndividualApiLockInterval]parse individual apiLock interval error.apiKey=" + str + " ---" + e2.toString());
            return 0L;
        }
    }

    public void a(Context context) {
        a aVar = d;
    }

    public boolean b() {
        return c.c && b.c;
    }

    public long c() {
        long j = b.d;
        e = j;
        return j;
    }

    public boolean d() {
        return c.b && b.b;
    }
}
