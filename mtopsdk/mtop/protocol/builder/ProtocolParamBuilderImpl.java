package mtopsdk.mtop.protocol.builder;

import com.alipay.sdk.cons.b;
import com.huawei.openalliance.ad.constant.t;
import com.taobao.tao.remotebusiness.listener.c;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.xstate.a;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/protocol/builder/ProtocolParamBuilderImpl.class */
public class ProtocolParamBuilderImpl implements ProtocolParamBuilder {

    /* renamed from: a  reason: collision with root package name */
    private c f43772a = null;
    private SDKConfig b = SDKConfig.a();

    private Map a() {
        HashMap hashMap = new HashMap();
        hashMap.put("pv", "1.0");
        String a2 = a.a("lat");
        if (StringUtils.a(a2)) {
            String a3 = a.a("lng");
            if (StringUtils.a(a3)) {
                hashMap.put("lat", a2);
                hashMap.put("lng", a3);
            }
        }
        hashMap.put("t", String.valueOf(SDKUtils.a()));
        hashMap.put("sid", a.a("sid"));
        hashMap.put(t.cN, a.a(t.cN));
        hashMap.put(b.g, a.a(b.g));
        hashMap.put("x-features", String.valueOf(MtopFeatureManager.a()));
        return hashMap;
    }

    private void a(MtopProxy mtopProxy, Map map) {
        MtopNetworkProp e = mtopProxy.e();
        if (e.k != null && !e.k.isEmpty()) {
            for (Map.Entry entry : e.k.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        String k = this.b.k();
        if (StringUtils.a(k)) {
            map.put("x-app-ver", k);
        }
        String a2 = a.a("ua");
        if (a2 != null) {
            map.put("user-agent", a2);
        }
    }

    private Map b(MtopProxy mtopProxy) {
        MtopRequest d = mtopProxy.d();
        MtopNetworkProp e = mtopProxy.e();
        Map a2 = a();
        a2.put("api", d.a().toLowerCase());
        a2.put("v", d.b().toLowerCase());
        a2.put("data", d.c());
        a2.put("ttid", StringUtils.a(e.g) ? e.g : a.a("ttid"));
        String f = this.b.f();
        a2.put("appKey", f);
        a2.put("sid", a.a("sid"));
        if (e.j >= 0) {
            a2.get("t");
            c cVar = this.f43772a;
            int i = e.j;
            a2.put("wua", cVar.a());
        }
        String a3 = this.f43772a.a((HashMap) a2, f);
        if (!StringUtils.b(a3)) {
            a2.put("sign", a3);
            a(mtopProxy, a2);
            return a2;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("api=");
        sb.append(d.a());
        sb.append(";v=");
        sb.append(d.b());
        sb.append(" getMtopApiWBSign  failed. [appKey=");
        sb.append(f);
        sb.append("]");
        TBSdkLog.d("mtopsdk.ProtocolParamBuilderImpl", mtopProxy.h.g(), sb.toString());
        return null;
    }

    @Override // mtopsdk.mtop.protocol.builder.ProtocolParamBuilder
    public Map a(MtopProxy mtopProxy) {
        if (mtopProxy == null || mtopProxy.c() == null) {
            TBSdkLog.d("mtopsdk.ProtocolParamBuilderImpl", "[buildParams]mtopProxy or entrance is invalid.---" + mtopProxy);
            return null;
        }
        c c2 = this.b.c();
        this.f43772a = c2;
        if (c2 == null) {
            TBSdkLog.d("mtopsdk.ProtocolParamBuilderImpl", mtopProxy.h.g(), "ISign for SDKConfig.getInstance().getGlobalSign is null");
            return null;
        }
        return b(mtopProxy);
    }
}
