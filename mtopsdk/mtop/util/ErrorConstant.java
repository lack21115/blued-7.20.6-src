package mtopsdk.mtop.util;

import com.alipay.security.mobile.module.http.model.c;
import com.anythink.core.common.g.g;
import java.util.HashMap;
import mtopsdk.common.util.StringUtils;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/util/ErrorConstant.class */
public class ErrorConstant {
    static HashMap a = new HashMap();
    static HashMap b = new HashMap();
    static HashMap c;

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put("SYSTEM_ERROR", -2000);
        c.put("FAIL_SYS_HSF_ASYNC_POOL_FOOL", -2001);
        c.put("FAIL_SYS_PARAM_MISSING", -2008);
        c.put("FAIL_SYS_PARAM_FORMAT_ERROR", -2009);
        c.put("FAIL_SYS_SYSTEM_BUSY_ERROR", -2002);
        c.put("FAIL_SYS_API_STOP_SERVICE", -2003);
        c.put("FAIL_BIZ_MTOP_RT_IS_NULL", -2004);
        c.put("FAIL_SYS_API_NOT_FOUNDED", -2018);
        c.put("FAIL_SYS_SERVICE_NOT_EXIST", -2019);
        c.put("FAIL_SYS_SERVICE_TIMEOUT", -2020);
        c.put("FAIL_SYS_SERVICE_FAULT", -2021);
        c.put("FAIL_SYS_SERVICE_INNER_FAULT", -2022);
        c.put("FAIL_SYS_PROTOVER_MISSED", -2026);
        c.put("FAIL_SYS_PROTOPARAM_MISSED", -2025);
        c.put("FAIL_SYS_INTERNAL_FAULT", -2012);
        c.put("FAIL_SYS_INVALID_HTTP_METHOD", -2013);
        c.put("FAIL_SYS_UNKNOWN_APP", -2014);
        c.put("FAIL_SYS_RETMISSED_ERROR", -2015);
        c.put("FAIL_SYS_API_UNAUTHORIZED", -2007);
        c.put("FAIL_SYS_BIZPARAM_MISSED", -2008);
        c.put("FAIL_SYS_BIZPARAM_TYPE_ERROR", -2009);
        c.put("FAIL_SYS_ASYNC4J_RESPONSE_FETCH_FAIL", -2024);
        c.put("FAIL_SYS_ASYNC4J_RESPONSE_QUERY_FAIL", -2023);
        c.put("FAIL_SYS_BADARGUMENT_T", -2010);
        c.put("FAIL_SYS_APPKEY_NOT_EXIST", -2011);
        c.put("FAIL_SYS_TOPAUTHPARAM_MISSED", -2032);
        c.put("FAIL_SYS_TOPAUTH_FAILED", -2027);
        c.put("FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR", -2028);
        c.put("FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR", -2029);
        c.put("FAIL_SYS_TOPUNAUTHAPI_ERROR", -2030);
        c.put("FAIL_SYS_TOPAUTH_FAULT", -2031);
        c.put("FAIL_SYS_ILLEGAL_ARGUMENT_TTID", -2033);
        c.put("FAIL_SYS_ACCESS_TOKEN_EXPIRED", -2034);
        c.put("FAIL_SYS_ILLEGAL_ACCESS_TOKEN", -2035);
        c.put("FAIL_SYS_LOGIN_CANCEL", -2036);
        c.put("FAIL_SYS_LOGIN_FAIL", -2037);
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
        a.put("FAIL_SYS_REQUEST_EXPIRED", -2016);
        a.put("FAIL_SYS_SESSION_EXPIRED", -2005);
        a.put("FAIL_SYS_ILEGEL_SIGN", -2006);
        a.put("FAIL_SYS_TRAFFIC_LIMIT", -2017);
        a.putAll(c);
        a.putAll(b);
        a.put(c.g, Integer.valueOf((int) g.b));
    }

    public static Integer a(String str) {
        Integer num = (Integer) a.get(str);
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
        return c.containsKey(str);
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
