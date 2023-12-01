package mtopsdk.mtop;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.antiattack.AntiAttackHandler;
import mtopsdk.mtop.antiattack.AntiAttackHandlerImpl;
import mtopsdk.mtop.antiattack.CheckCodeValidateListener;
import mtopsdk.mtop.antiattack.DefaultCheckCodeValidateListener;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.MtopSDK;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.util.MtopProxyConstant;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.mtop.util.Result;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/MtopProxyBase.class */
public class MtopProxyBase implements IMTOPDataObject {
    public static EnvModeEnum a = EnvModeEnum.ONLINE;
    public static AntiAttackHandler b = new AntiAttackHandlerImpl();
    public static CheckCodeValidateListener c = new DefaultCheckCodeValidateListener();
    private static volatile boolean l = false;
    public MtopRequest d;
    public MtopNetworkProp e;
    public Object f;
    public MtopListener g;
    public MtopStatistics h;
    private EntranceEnum i = EntranceEnum.GW_OPEN;
    private String j;
    private String k;

    public MtopProxyBase(MtopRequest mtopRequest, MtopNetworkProp mtopNetworkProp, Object obj, MtopListener mtopListener) {
        this.e = new MtopNetworkProp();
        this.d = mtopRequest;
        if (mtopNetworkProp != null) {
            this.e = mtopNetworkProp;
        }
        this.f = obj;
        this.g = mtopListener;
    }

    private static void a() {
        EnvModeEnum j = SDKConfig.a().j();
        if (j != null) {
            a = j;
        }
        MtopSDK.a();
        l = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b() {
        if (l) {
            return;
        }
        synchronized (MtopProxyBase.class) {
            try {
                if (!l) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(MtopResponse mtopResponse) {
        if (mtopResponse == null || !(this.g instanceof MtopCallback.MtopFinishListener)) {
            return;
        }
        ((MtopCallback.MtopFinishListener) this.g).onFinished(new MtopFinishEvent(mtopResponse), this.f);
    }

    public void b(String str) {
        this.k = str;
    }

    public String c(String str) {
        EnvModeEnum envModeEnum;
        try {
            envModeEnum = a;
            this.e.o = envModeEnum;
        } catch (Exception e) {
            TBSdkLog.d("mtopsdk.MtopProxyBase", "[getFullBaseUrl] create MtopProxyBase fullbaseurl error ---" + e.toString());
        }
        if (StringUtils.a(this.k)) {
            StringBuilder sb = new StringBuilder(40);
            sb.append(this.e.a.a());
            if (StringUtils.a(str)) {
                sb.append(str);
            }
            sb.append(this.k);
            sb.append(BridgeUtil.SPLIT_MARK);
            sb.append(this.i.a());
            return sb.toString();
        }
        if (StringUtils.b(this.j)) {
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append(this.e.a.a());
            if (StringUtils.a(str)) {
                sb2.append(str);
            }
            sb2.append(MtopProxyConstant.a[envModeEnum.a()]);
            sb2.append(this.i.a());
            return sb2.toString();
        }
        return this.j;
    }

    public EntranceEnum c() {
        return this.i;
    }

    public MtopRequest d() {
        return this.d;
    }

    public MtopNetworkProp e() {
        return this.e;
    }

    public MtopListener f() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Result g() {
        String g = this.h.g();
        MtopRequest mtopRequest = this.d;
        if (mtopRequest == null || !mtopRequest.e()) {
            StringBuilder sb = new StringBuilder("mtopRequest is invalid.");
            MtopRequest mtopRequest2 = this.d;
            sb.append(mtopRequest2 != null ? mtopRequest2.toString() : "mtopRequest=null");
            String sb2 = sb.toString();
            TBSdkLog.d("mtopsdk.MtopProxyBase", g, "[validateBusinessInit]" + sb2);
            return new Result(false, "ANDROID_SYS_MTOPPROXYBASE_INIT_ERROR", sb2);
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.a("mtopsdk.MtopProxyBase", g, "[validateBusinessInit]" + this.d.toString());
        }
        if (this.e == null) {
            TBSdkLog.d("mtopsdk.MtopProxyBase", g, "[validateBusinessInit]MtopNetworkProp is invalid.");
            return new Result(false, "ANDROID_SYS_MTOPPROXYBASE_INIT_ERROR", "MtopNetworkProp is invalid.");
        }
        return new Result(true);
    }

    public Object getContext() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopProxyBase [entrance=");
        sb.append(this.i);
        sb.append(", fullBaseUrl=");
        sb.append(this.j);
        sb.append(", customDomain=");
        sb.append(this.k);
        sb.append(", mtopRequest=");
        sb.append(this.d);
        sb.append(", property=");
        sb.append(this.e);
        sb.append(", context=");
        sb.append(this.f);
        sb.append(", callback=");
        sb.append(this.g);
        sb.append("]");
        return sb.toString();
    }
}
