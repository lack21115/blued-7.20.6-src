package mtopsdk.mtop.util;

import com.taobao.tao.remotebusiness.listener.c;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.antiattack.ApiLockHelper;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.xstate.a;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/ResponseHandlerUtil.class */
public class ResponseHandlerUtil {
    public static MtopResponse a(MtopResponse mtopResponse, MtopProxy mtopProxy) {
        a(mtopResponse);
        mtopProxy.e.f = true;
        return mtopProxy.a();
    }

    public static Result a(MtopResponse mtopResponse, MtopResponse mtopResponse2) {
        Result result = new Result(mtopResponse);
        if (mtopResponse.f() != 304 || mtopResponse2 == null) {
            result.a(false);
            return result;
        }
        result.a(mtopResponse2);
        return result;
    }

    private static void a(MtopResponse mtopResponse) {
        if (mtopResponse == null || mtopResponse.e() == null) {
            return;
        }
        try {
            String a2 = c.a(mtopResponse.e(), "x-systime");
            if (StringUtils.a(a2)) {
                a.a("t_offset", String.valueOf(Long.parseLong(a2) - (System.currentTimeMillis() / 1000)));
            }
        } catch (Exception e) {
            TBSdkLog.b("mtopsdk.ResponseHandlerUtil", "[computeTimeOffset]parse systime from mtop response data error", e);
        }
    }

    public static Result b(MtopResponse mtopResponse, MtopProxy mtopProxy) {
        Result result = new Result(mtopResponse);
        int f = mtopResponse.f();
        if (f == 420 || f == 499 || f == 599) {
            if (mtopProxy != null) {
                ApiLockHelper.b(mtopProxy.d().f(), SDKUtils.a());
            }
            mtopResponse.a("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
            mtopResponse.b("哎哟喂,被挤爆啦,请稍后重试");
            return result;
        } else if (f != 419) {
            result.a(false);
            return result;
        } else {
            mtopResponse.a("ANDROID_SYS_API_41X_ANTI_ATTACK");
            mtopResponse.b("哎哟喂,被挤爆啦,请稍后重试!");
            return result;
        }
    }
}
