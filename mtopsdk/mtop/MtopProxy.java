package mtopsdk.mtop;

import android.os.Handler;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilder;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilderImpl;
import mtopsdk.mtop.transform.MtopTransform;
import mtopsdk.mtop.transform.MtopTransformImpl;
import mtopsdk.mtop.unit.UserUnit;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.mtop.util.Result;
import mtopsdk.xstate.a;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/MtopProxy.class */
public class MtopProxy extends MtopProxyBase {
    private ProtocolParamBuilder i;
    private MtopTransform j;

    public MtopProxy(MtopRequest mtopRequest, MtopNetworkProp mtopNetworkProp, Object obj, MtopListener mtopListener) {
        super(mtopRequest, mtopNetworkProp, obj, mtopListener);
        this.i = new ProtocolParamBuilderImpl();
        this.j = new MtopTransformImpl();
    }

    private void h() {
        if (this.h == null) {
            this.h = new MtopStatistics();
            this.h.a();
            if (this.d != null) {
                this.h.p = this.d.f();
            }
        }
    }

    private void i() {
        String str = this.e.q;
        String str2 = str;
        if (StringUtils.b(str)) {
            str2 = a.a("uid");
        }
        SDKConfig.a().g();
        this.e.p = StringUtils.b(null) ? new UserUnit(str2, UserUnit.UnitType.CENTER, "") : new UserUnit(str2, UserUnit.UnitType.UNIT, null);
    }

    private void j() {
        b();
        h();
        i();
        if (SwitchConfig.a().b()) {
            return;
        }
        this.e.a = ProtocolEnum.HTTP;
    }

    public ApiID a(Handler handler) {
        j();
        Result g = g();
        if (!g.d()) {
            a(this.d != null ? new MtopResponse(this.d.a(), this.d.b(), g.b(), g.c()) : new MtopResponse(g.b(), g.c()));
            return new ApiID(null, this);
        }
        Map a = this.i.a(this);
        if (a == null) {
            a(new MtopResponse(this.d.a(), this.d.b(), "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR", "生成Mtop签名sign失败"));
            return new ApiID(null, this);
        }
        return this.j.a(this, a, handler);
    }

    public MtopResponse a() {
        j();
        Result g = g();
        if (!g.d()) {
            MtopResponse mtopResponse = this.d != null ? new MtopResponse(this.d.a(), this.d.b(), g.b(), g.c()) : new MtopResponse(g.b(), g.c());
            a(mtopResponse);
            return mtopResponse;
        }
        Map a = this.i.a(this);
        if (a == null) {
            return new MtopResponse(this.d.a(), this.d.b(), "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR", "生成Mtop签名sign失败");
        }
        MtopResponse a2 = this.j.a(this, a);
        this.h.f = a2.a();
        this.h.h();
        a2.a(this.h);
        return a2;
    }
}
