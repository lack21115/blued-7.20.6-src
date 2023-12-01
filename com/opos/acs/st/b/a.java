package com.opos.acs.st.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.utils.ErrorContants;
import com.opos.acs.st.utils.d;
import com.opos.acs.st.utils.e;
import com.opos.acs.st.utils.h;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f24451a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public long f24452c;
    public long d;

    public static StatisticEvent a(Map map) {
        StatisticEvent statisticEvent = null;
        if (map != null) {
            long j = -1;
            try {
                try {
                    if (map.get("ret") != null) {
                        j = "".equals((String) map.get("ret")) ? -1L : Long.valueOf((String) map.get("ret")).longValue();
                    }
                } catch (Exception e) {
                    d.b("ErrorTag", "", e);
                    j = -1;
                }
                statisticEvent = new StatisticEvent.Builder((String) map.get("evtId"), (String) map.get("url"), j, map.get("rt") == null ? 0L : ((Long) map.get("rt")).longValue(), map.get("mt") == null ? 0L : ((Long) map.get("mt")).longValue(), (String) map.get("chn")).setCurrentTime(map.get(com.anythink.expressad.d.a.b.dx) == null ? System.currentTimeMillis() : ((Long) map.get(com.anythink.expressad.d.a.b.dx)).longValue()).setExt((String) map.get("ext")).setNet((String) map.get("net")).setSdkVersion("330").build();
            } catch (Exception e2) {
                return null;
            }
        }
        return statisticEvent;
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String executeEncryptStringV3 = EncryptUtils.executeEncryptStringV3(str, 0);
        com.opos.cmn.an.f.a.b("LocalEncryptUtils", "encrypt value " + str + " to " + executeEncryptStringV3);
        if (TextUtils.isEmpty(executeEncryptStringV3)) {
            Map errorContantseMap = ErrorContants.errorContantseMap(context, "5", ErrorContants.LOCAL_EN_ERROR, "", "-1", 0L, 0L, str);
            e.a(context);
            e.a(errorContantseMap);
            return str;
        }
        return "@en_v1_".concat(String.valueOf(executeEncryptStringV3));
    }

    public static Map<String, String> a(String str) {
        if (h.a(str)) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            d.b(com.anythink.core.common.k.h.f6811a, "", e);
            return null;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            if (jSONObject.has(next) && !jSONObject.isNull(next)) {
                try {
                    hashMap.put(next, jSONObject.getString(next));
                } catch (JSONException e) {
                    d.b(com.anythink.core.common.k.h.f6811a, "", e);
                }
            }
        }
        return hashMap;
    }

    public static String b(Context context, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("@en_v1_")) {
                return str;
            }
            try {
                String substring = str.substring(7);
                String executeDecryptStringV3 = EncryptUtils.executeDecryptStringV3(substring, 0);
                if (TextUtils.isEmpty(executeDecryptStringV3)) {
                    Map errorContantseMap = ErrorContants.errorContantseMap(context, "5", ErrorContants.LOCAL_DE_ERROR, "", "-1", 0L, 0L, substring);
                    e.a(context);
                    e.a(errorContantseMap);
                    str2 = substring;
                } else {
                    str2 = executeDecryptStringV3;
                }
                com.opos.cmn.an.f.a.b("LocalEncryptUtils", "decrypt value " + str + " to " + str2);
                return str2;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("LocalEncryptUtils", "decryptValue", e);
            }
        }
        return str;
    }

    public static JSONObject b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            return new JSONObject(map);
        } catch (Exception e) {
            d.b(com.anythink.core.common.k.h.f6811a, "", e);
            return null;
        }
    }
}
