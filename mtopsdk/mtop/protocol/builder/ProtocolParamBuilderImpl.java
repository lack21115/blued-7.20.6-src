package mtopsdk.mtop.protocol.builder;

import com.alipay.sdk.cons.b;
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
    private c a = null;
    private SDKConfig b = SDKConfig.a();

    private Map a() {
        HashMap hashMap = new HashMap();
        hashMap.put("pv", "1.0");
        String a = a.a(com.anythink.core.common.g.c.B);
        if (StringUtils.a(a)) {
            String a2 = a.a("lng");
            if (StringUtils.a(a2)) {
                hashMap.put(com.anythink.core.common.g.c.B, a);
                hashMap.put("lng", a2);
            }
        }
        hashMap.put("t", String.valueOf(SDKUtils.a()));
        hashMap.put("sid", a.a("sid"));
        hashMap.put("accessToken", a.a("accessToken"));
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
        String a = a.a("ua");
        if (a != null) {
            map.put("user-agent", a);
        }
    }

    private Map b(MtopProxy mtopProxy) {
        MtopRequest d = mtopProxy.d();
        MtopNetworkProp e = mtopProxy.e();
        Map a = a();
        a.put("api", d.a().toLowerCase());
        a.put("v", d.b().toLowerCase());
        a.put("data", d.c());
        a.put("ttid", StringUtils.a(e.g) ? e.g : a.a("ttid"));
        String f = this.b.f();
        a.put("appKey", f);
        a.put("sid", a.a("sid"));
        if (e.j >= 0) {
            a.get("t");
            c cVar = this.a;
            int i = e.j;
            a.put("wua", cVar.a());
        }
        String a2 = this.a.a((HashMap) a, f);
        if (!StringUtils.b(a2)) {
            a.put(com.anythink.core.common.g.c.Y, a2);
            a(mtopProxy, a);
            return a;
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
        c c = this.b.c();
        this.a = c;
        if (c == null) {
            TBSdkLog.d("mtopsdk.ProtocolParamBuilderImpl", mtopProxy.h.g(), "ISign for SDKConfig.getInstance().getGlobalSign is null");
            return null;
        }
        return b(mtopProxy);
    }
}
