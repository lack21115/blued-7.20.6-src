package mtopsdk.mtop.common;

import com.taobao.tao.remotebusiness.listener.c;
import java.io.IOException;
import java.util.Map;
import mtopsdk.a.b.g;
import mtopsdk.a.b.i;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.unit.UnitConfigManager;
import mtopsdk.mtop.util.ResponseHandlerUtil;
import mtopsdk.mtop.util.Result;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopNetworkResultParser.class */
public class MtopNetworkResultParser {

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopNetworkResultParser$ParseParameter.class */
    public class ParseParameter {

        /* renamed from: a  reason: collision with root package name */
        public int f43711a;
        public Map b;

        /* renamed from: c  reason: collision with root package name */
        public i f43712c;

        public ParseParameter(int i, Map map, i iVar) {
            this.f43711a = i;
            this.b = map;
            this.f43712c = iVar;
        }
    }

    public static MtopResponse a(g gVar, MtopResponse mtopResponse, MtopProxy mtopProxy) {
        if (gVar == null) {
            MtopResponse mtopResponse2 = new MtopResponse("ANDROID_SYS_NETWORK_ERROR", "网络错误");
            if (mtopProxy != null) {
                mtopResponse2.c(mtopProxy.d.a());
                mtopResponse2.d(mtopProxy.d.b());
            }
            return mtopResponse2;
        }
        return a(null, mtopResponse, mtopProxy, new ParseParameter(gVar.a(), gVar.b(), gVar.c()));
    }

    public static MtopResponse a(MtopResponse mtopResponse) {
        if (mtopResponse != null) {
            if (mtopResponse.e() == null) {
                return mtopResponse;
            }
            String a2 = c.a(mtopResponse.e(), "x-retcode");
            if (StringUtils.a(a2)) {
                mtopResponse.a(a2);
                return mtopResponse;
            }
            mtopResponse.h();
        }
        return mtopResponse;
    }

    public static MtopResponse a(MtopResponse mtopResponse, MtopResponse mtopResponse2, MtopProxy mtopProxy, ParseParameter parseParameter) {
        MtopResponse mtopResponse3 = mtopResponse;
        if (mtopResponse == null) {
            mtopResponse3 = new MtopResponse();
        }
        String str = null;
        if (mtopProxy != null) {
            mtopResponse3.c(mtopProxy.d.a());
            mtopResponse3.d(mtopProxy.d.b());
            str = mtopProxy.h.g();
        }
        if (parseParameter == null) {
            TBSdkLog.d("mtopsdk.MtopNetworkResultParser", str, "[parseNetworkRlt]network response is invalid");
            mtopResponse3.a("ANDROID_SYS_NETWORK_ERROR");
            mtopResponse3.b("网络错误");
            return mtopResponse3;
        }
        int i = parseParameter.f43711a;
        Map map = parseParameter.b;
        mtopResponse3.a(i);
        mtopResponse3.a(map);
        i iVar = parseParameter.f43712c;
        if (iVar != null) {
            try {
                mtopResponse3.a(iVar.c());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (i < 0) {
            if (-200 == i) {
                mtopResponse3.a("ANDROID_SYS_NO_NETWORK");
                mtopResponse3.b("无网络");
            } else {
                mtopResponse3.a("ANDROID_SYS_NETWORK_ERROR");
                mtopResponse3.b("网络错误");
            }
            if (TBSdkLog.a(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("[parseNetworkRlt] api=");
                sb.append(mtopResponse3.b());
                sb.append(",v=");
                sb.append(mtopResponse3.c());
                sb.append(",retCode =");
                sb.append(mtopResponse3.a());
                sb.append(",responseCode =");
                sb.append(i);
                sb.append(",responseHeader=");
                sb.append(map);
                TBSdkLog.d("mtopsdk.MtopNetworkResultParser", str, sb.toString());
            }
            return mtopResponse3;
        }
        UnitConfigManager.a(map, str);
        Result b = ResponseHandlerUtil.b(mtopResponse3, mtopProxy);
        if (b == null || !b.d()) {
            Result a2 = ResponseHandlerUtil.a(mtopResponse3, mtopResponse2);
            if (a2 == null || !a2.d()) {
                if (mtopResponse3.d() == null) {
                    mtopResponse3.a("ANDROID_SYS_JSONDATA_BLANK");
                    mtopResponse3.b("返回JSONDATA为空");
                    return mtopResponse3;
                }
                MtopResponse a3 = a(mtopResponse3);
                MtopResponse mtopResponse4 = a3;
                if (a3.j()) {
                    mtopResponse4 = a3;
                    if (mtopProxy != null) {
                        mtopResponse4 = a3;
                        if (!mtopProxy.e().f) {
                            mtopResponse4 = ResponseHandlerUtil.a(a3, mtopProxy);
                        }
                    }
                }
                return mtopResponse4;
            }
            return (MtopResponse) a2.a();
        }
        return (MtopResponse) b.a();
    }
}
