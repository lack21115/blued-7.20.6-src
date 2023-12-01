package mtopsdk.mtop.util;

import android.drm.DrmManagerClient;
import com.igexin.c.a.b.c;
import com.tencent.ugc.common.UGCConstants;
import java.util.HashMap;
import mtopsdk.common.util.StringUtils;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/ErrorConstant.class */
public class ErrorConstant {

    /* renamed from: a  reason: collision with root package name */
    static HashMap f43781a = new HashMap();
    static HashMap b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    static HashMap f43782c;

    static {
        HashMap hashMap = new HashMap();
        f43782c = hashMap;
        hashMap.put("SYSTEM_ERROR", Integer.valueOf((int) DrmManagerClient.ERROR_UNKNOWN));
        f43782c.put("FAIL_SYS_HSF_ASYNC_POOL_FOOL", Integer.valueOf((int) UGCConstants.ERR_BGM_UNSUPPORT_SYSTEM));
        f43782c.put("FAIL_SYS_PARAM_MISSING", -2008);
        f43782c.put("FAIL_SYS_PARAM_FORMAT_ERROR", -2009);
        f43782c.put("FAIL_SYS_SYSTEM_BUSY_ERROR", Integer.valueOf((int) UGCConstants.ERR_BGM_NO_AUDIO_TRACK));
        f43782c.put("FAIL_SYS_API_STOP_SERVICE", Integer.valueOf((int) UGCConstants.ERR_BGM_UNSUPPORT_AUDIO_CHANNEL));
        f43782c.put("FAIL_BIZ_MTOP_RT_IS_NULL", -2004);
        f43782c.put("FAIL_SYS_API_NOT_FOUNDED", -2018);
        f43782c.put("FAIL_SYS_SERVICE_NOT_EXIST", -2019);
        f43782c.put("FAIL_SYS_SERVICE_TIMEOUT", -2020);
        f43782c.put("FAIL_SYS_SERVICE_FAULT", -2021);
        f43782c.put("FAIL_SYS_SERVICE_INNER_FAULT", -2022);
        f43782c.put("FAIL_SYS_PROTOVER_MISSED", -2026);
        f43782c.put("FAIL_SYS_PROTOPARAM_MISSED", -2025);
        f43782c.put("FAIL_SYS_INTERNAL_FAULT", -2012);
        f43782c.put("FAIL_SYS_INVALID_HTTP_METHOD", -2013);
        f43782c.put("FAIL_SYS_UNKNOWN_APP", -2014);
        f43782c.put("FAIL_SYS_RETMISSED_ERROR", -2015);
        f43782c.put("FAIL_SYS_API_UNAUTHORIZED", -2007);
        f43782c.put("FAIL_SYS_BIZPARAM_MISSED", -2008);
        f43782c.put("FAIL_SYS_BIZPARAM_TYPE_ERROR", -2009);
        f43782c.put("FAIL_SYS_ASYNC4J_RESPONSE_FETCH_FAIL", -2024);
        f43782c.put("FAIL_SYS_ASYNC4J_RESPONSE_QUERY_FAIL", -2023);
        f43782c.put("FAIL_SYS_BADARGUMENT_T", -2010);
        f43782c.put("FAIL_SYS_APPKEY_NOT_EXIST", -2011);
        f43782c.put("FAIL_SYS_TOPAUTHPARAM_MISSED", -2032);
        f43782c.put("FAIL_SYS_TOPAUTH_FAILED", -2027);
        f43782c.put("FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR", -2028);
        f43782c.put("FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR", -2029);
        f43782c.put("FAIL_SYS_TOPUNAUTHAPI_ERROR", -2030);
        f43782c.put("FAIL_SYS_TOPAUTH_FAULT", -2031);
        f43782c.put("FAIL_SYS_ILLEGAL_ARGUMENT_TTID", Integer.valueOf((int) c.f));
        f43782c.put("FAIL_SYS_ACCESS_TOKEN_EXPIRED", -2034);
        f43782c.put("FAIL_SYS_ILLEGAL_ACCESS_TOKEN", -2035);
        f43782c.put("FAIL_SYS_LOGIN_CANCEL", -2036);
        f43782c.put("FAIL_SYS_LOGIN_FAIL", -2037);
        b.put("ANDROID_SYS_NETWORK_ERROR", -2501);
        b.put("ANDROID_SYS_NO_NETWORK", -2500);
        b.put("ANDROID_SYS_JSONDATA_BLANK", -2502);
        b.put("ANDROID_SYS_JSONDATA_PARSE_ERROR", -2503);
        b.put("ANDROID_SYS_MTOPREQUEST_INVALID_ERROR", -2504);
        b.put("ANDROID_SYS_MTOPPROXYBASE_INIT_ERROR", -2505);
        b.put("ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR", -2506);
        b.put("ANDROID_SYS_API_FLOW_LIMIT_LOCKED", -2507);
        b.put("ANDROID_SYS_API_41X_ANTI_ATTACK", -2508);
        b.put("ANDROID_SYS_TRADE_API_ASYNC_RESULT", -2509);
        b.put("ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", -2510);
        b.put("ANDROID_SYS_ASYNC4J_INTERNAL_ERROR", -2511);
        b.put("ANDROID_SYS_MISS_API_RESPONSE_SIGN", -2512);
        b.put("ANDROID_SYS_VALIDATE_API_RESPONSE_SIGN_ERROR", -2513);
        f43781a.put("FAIL_SYS_REQUEST_EXPIRED", -2016);
        f43781a.put("FAIL_SYS_SESSION_EXPIRED", -2005);
        f43781a.put("FAIL_SYS_ILEGEL_SIGN", -2006);
        f43781a.put("FAIL_SYS_TRAFFIC_LIMIT", -2017);
        f43781a.putAll(f43782c);
        f43781a.putAll(b);
        f43781a.put(com.alipay.security.mobile.module.http.model.c.g, -1001);
    }

    public static Integer a(String str) {
        Integer num = (Integer) f43781a.get(str);
        Integer num2 = num;
        if (num == null) {
            num2 = -1000;
        }
        return num2;
    }

    public static Integer b(String str) {
        Integer num = (Integer) b.get(str);
        Integer num2 = num;
        if (num == null) {
            num2 = -1000;
        }
        return num2;
    }

    public static boolean c(String str) {
        return f43782c.containsKey(str);
    }

    public static boolean d(String str) {
        return StringUtils.b(str) || b.containsKey(str);
    }

    public static boolean e(String str) {
        int intValue = b(str).intValue();
        return -2501 == intValue || -2500 == intValue;
    }

    public static boolean f(String str) {
        return -2005 == a(str).intValue();
    }

    public static boolean g(String str) {
        return -1001 == a(str).intValue();
    }

    public static boolean h(String str) {
        return -2508 == b(str).intValue();
    }

    public static boolean i(String str) {
        return -2507 == b(str).intValue();
    }

    public static boolean j(String str) {
        return -2016 == a(str).intValue();
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("FAIL_SYS_");
    }
}
