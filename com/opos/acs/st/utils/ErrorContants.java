package com.opos.acs.st.utils;

import android.content.Context;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/ErrorContants.class */
public class ErrorContants {
    public static final String CHANNEL_BD = "1";
    public static final String CHANNEL_FEEDS = "4";
    public static final String CHANNEL_ST = "5";
    public static final String CHANNEL_UNION = "2";
    public static final String INIT_LOADAD_ERROR = "202";
    public static final String LOAD_STRATEGY_ERROR = "601";
    public static final String LOCAL_BIZ_DE_ERROR = "609";
    public static final String LOCAL_BIZ_EN_ERROR = "608";
    public static final String LOCAL_DE_ERROR = "607";
    public static final String LOCAL_EN_ERROR = "606";
    public static final String NET_ERROR = "-1";
    public static final String NET_NO_CALLBACK = "-2";
    public static final String NEW_PERIODIC_REPORT_ERROR = "610";
    public static final String NEW_REALTIME_REPORT_ERROR = "611";
    public static final String NO_NEW_OLD_ASSOCIATE = "612";
    public static final String NO_NEW_STRATEGY_ERROR = "613";
    public static final String PERIODIC_REPORT_ERROR = "602";
    public static final String REALTIME_LOADAD_ERROR = "201";
    public static final String REALTIME_REPORT_ERROR = "603";
    public static final String REPORT_ERROR = "604";
    public static final String THIRDPARTY_ST_ERROR = "1";
    public static final String THIRD_PARTY_ST = "605";

    public static Map errorContantseMap(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TKDownloadReason.KSAD_TK_NET, h.a(context));
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        hashMap.put("chn", str2);
        hashMap.put("evtId", "-1");
        hashMap.put(com.anythink.expressad.d.a.b.dx, Long.valueOf(System.currentTimeMillis()));
        hashMap.put("url", "");
        hashMap.put("ret", "-1");
        hashMap.put("rt", 0);
        hashMap.put("mt", 0);
        hashMap.put("ext", "");
        return hashMap;
    }

    public static Map errorContantseMap(Context context, String str, String str2, String str3, String str4, long j, long j2, String str5) {
        Map errorContantseMap = errorContantseMap(context, str);
        errorContantseMap.put("evtId", str2);
        errorContantseMap.put("url", str3);
        errorContantseMap.put("ret", str4);
        errorContantseMap.put("rt", Long.valueOf(j));
        errorContantseMap.put("mt", Long.valueOf(j2));
        errorContantseMap.put("ext", str5);
        return errorContantseMap;
    }
}
