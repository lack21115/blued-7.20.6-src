package mtopsdk.mtop.global;

import android.content.Context;
import com.taobao.tao.remotebusiness.listener.c;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.a.b;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.unit.ApiUnit;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.a;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/global/SDKConfig.class */
public class SDKConfig {

    /* renamed from: c  reason: collision with root package name */
    private static Context f43764c;
    private static c d;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static volatile ApiUnit m;
    private Lock n = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    private static final SDKConfig f43763a = new SDKConfig();
    private static EnvModeEnum b = EnvModeEnum.ONLINE;
    private static int e = 0;
    private static int f = 0;
    private static b o = new b(MtopSDKThreadPoolExecutorFactory.b());

    private SDKConfig() {
    }

    public static SDKConfig a() {
        return f43763a;
    }

    public SDKConfig a(Context context) {
        if (context != null) {
            f43764c = context.getApplicationContext();
        }
        return this;
    }

    public SDKConfig a(c cVar) {
        d = cVar;
        return this;
    }

    public SDKConfig a(String str) {
        h = str;
        a.a("appKey", str);
        return this;
    }

    public SDKConfig a(EnvModeEnum envModeEnum) {
        if (envModeEnum != null) {
            b = envModeEnum;
        }
        return this;
    }

    public SDKConfig a(ApiUnit apiUnit) {
        if (apiUnit != null) {
            this.n.lock();
            try {
                try {
                    m = apiUnit;
                    if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.a("mtopsdk.SDKConfig", "[setGlobalApiUnit] set apiUnit succeed,apiUnit=" + apiUnit.toString());
                    }
                } catch (Exception e2) {
                    TBSdkLog.d("mtopsdk.SDKConfig", "[setGlobalApiUnit] set apiUnit error ---" + e2.toString());
                }
                return this;
            } finally {
                this.n.unlock();
            }
        }
        return this;
    }

    public Context b() {
        return f43764c;
    }

    public SDKConfig b(String str) {
        k = str;
        a.a("deviceId", str);
        return this;
    }

    public c c() {
        return d;
    }

    public SDKConfig c(String str) {
        l = str;
        a.a(com.alipay.sdk.cons.b.g, str);
        if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.b("mtopsdk.SDKConfig", "[setGlobalUtdid] utdid=" + str);
        }
        return this;
    }

    public int d() {
        return f;
    }

    public SDKConfig d(String str) {
        i = str;
        a.a("ttid", str);
        return this;
    }

    public int e() {
        return e;
    }

    public String f() {
        return h;
    }

    public String g() {
        return l;
    }

    public String h() {
        return i;
    }

    public String i() {
        return g;
    }

    public EnvModeEnum j() {
        return b;
    }

    public String k() {
        return j;
    }

    public ApiUnit l() {
        return m;
    }

    public b m() {
        return o;
    }
}
