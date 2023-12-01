package mtopsdk.mtop.transform;

import android.os.Handler;
import java.util.Map;
import mtopsdk.a.a;
import mtopsdk.a.b.b;
import mtopsdk.a.b.g;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.antiattack.ApiLockHelper;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopNetworkResultParser;
import mtopsdk.mtop.common.NetworkListenerAdapter;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.transform.converter.Api4NetworkConverter;
import mtopsdk.mtop.util.MtopProxyUtils;
import mtopsdk.mtop.util.MtopStatistics;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/transform/MtopTransformImpl.class */
public class MtopTransformImpl implements MtopTransform {
    private a a(b bVar) {
        return SDKConfig.a().m().a(bVar);
    }

    @Override // mtopsdk.mtop.transform.MtopTransform
    public ApiID a(MtopProxy mtopProxy, Map map, Handler handler) {
        if (mtopProxy.h == null) {
            mtopProxy.h = new MtopStatistics();
        }
        String g = mtopProxy.h.g();
        MtopRequest d = mtopProxy.d();
        String f = d.f();
        if (!MtopProxyUtils.a().contains(f) && ApiLockHelper.a(f, SDKUtils.a())) {
            mtopProxy.a(new MtopResponse(d.a(), d.b(), "ANDROID_SYS_API_FLOW_LIMIT_LOCKED", "哎哟喂,被挤爆啦,请稍后重试"));
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.c("mtopsdk.MtopTransformImpl", "[asyncTransform] ANDROID_SYS_API_FLOW_LIMIT_LOCKED apiKey=" + f);
            }
            return new ApiID(null, mtopProxy);
        }
        b b = b(mtopProxy, map);
        NetworkListenerAdapter a2 = MtopProxyUtils.a(mtopProxy);
        if (a2 != null) {
            a2.f43716c = mtopProxy.h;
        }
        a aVar = null;
        try {
            mtopProxy.h.e();
            a a3 = a(b);
            aVar = a3;
            a3.a(a2);
            aVar = a3;
        } catch (Exception e) {
            TBSdkLog.b("mtopsdk.MtopTransformImpl", g, "[asyncTransform] invoke call.enqueue error :apiKey=" + d.f(), e);
        }
        return new ApiID(aVar, mtopProxy);
    }

    @Override // mtopsdk.mtop.transform.MtopTransform
    public MtopResponse a(MtopProxy mtopProxy, Map map) {
        g gVar;
        g gVar2;
        if (mtopProxy.h == null) {
            mtopProxy.h = new MtopStatistics();
        }
        String g = mtopProxy.h.g();
        MtopRequest d = mtopProxy.d();
        String f = d.f();
        if (!MtopProxyUtils.a().contains(f) && ApiLockHelper.a(f, SDKUtils.a())) {
            MtopResponse mtopResponse = new MtopResponse(d.a(), d.b(), "ANDROID_SYS_API_FLOW_LIMIT_LOCKED", "哎哟喂,被挤爆啦,请稍后重试");
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.c("mtopsdk.MtopTransformImpl", g, "[syncTransform] ANDROID_SYS_API_FLOW_LIMIT_LOCKED apiKey=" + f);
            }
            return mtopResponse;
        }
        b b = b(mtopProxy, map);
        try {
            mtopProxy.h.e();
            gVar = a(b).b();
            try {
                mtopProxy.h.f();
                gVar2 = gVar;
                if (gVar != null) {
                    mtopProxy.h.a(gVar.d());
                    gVar2 = gVar;
                }
            } catch (Throwable th) {
                th = th;
                TBSdkLog.b("mtopsdk.MtopTransformImpl", g, "[syncTransform] invoke call.execute error :apiKey=" + d.f(), th);
                gVar2 = gVar;
                mtopProxy.h.c();
                MtopResponse a2 = MtopNetworkResultParser.a(gVar2, null, mtopProxy);
                mtopProxy.h.d();
                return a2;
            }
        } catch (Throwable th2) {
            th = th2;
            gVar = null;
        }
        mtopProxy.h.c();
        MtopResponse a22 = MtopNetworkResultParser.a(gVar2, null, mtopProxy);
        mtopProxy.h.d();
        return a22;
    }

    public b b(MtopProxy mtopProxy, Map map) {
        if (mtopProxy == null || map == null) {
            return null;
        }
        return new Api4NetworkConverter().a(mtopProxy, map);
    }
}
