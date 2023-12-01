package com.igexin.push.core.a.b;

import android.speech.srec.Recognizer;
import com.igexin.push.b.a;
import com.igexin.push.config.SDKUrlConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b/h.class */
public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23407a = com.igexin.push.config.c.f23373a + "_RedirectServerAction";

    private static void a(String str, JSONArray jSONArray) {
        try {
            com.igexin.c.a.c.a.a(f23407a + "|start fetch idc config, url : " + str, new Object[0]);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.e.a.f(new com.igexin.push.core.h.c(str, jSONArray)), false, true);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(f23407a + e.toString(), new Object[0]);
        }
    }

    private static void a(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("delay");
        if (optLong >= 0) {
            com.igexin.push.core.e.O = optLong;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("address_list");
        com.igexin.c.a.c.a.a("redirect|" + optLong + "|" + optJSONArray.toString(), new Object[0]);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                com.igexin.push.b.c.a().d().a(arrayList);
                return;
            }
            String optString = optJSONArray.optString(i2);
            int indexOf = optString.indexOf(44);
            if (indexOf > 0) {
                String substring = optString.substring(0, indexOf);
                String substring2 = optString.substring(indexOf + 1);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    long parseLong = Long.parseLong(substring2);
                    a.b bVar = new a.b();
                    bVar.f23299a = "socket://".concat(String.valueOf(substring));
                    bVar.b = currentTimeMillis + (parseLong * 1000);
                    arrayList.add(bVar);
                } catch (NumberFormatException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
            i = i2 + 1;
        }
    }

    public static String[] a(JSONArray jSONArray) {
        String[] strArr;
        String[] strArr2 = null;
        try {
            String[] strArr3 = new String[jSONArray.length()];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr2 = strArr3;
                strArr = strArr3;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                StringBuilder sb = new StringBuilder("https://");
                sb.append(jSONArray.getString(i2));
                strArr3[i2] = sb.toString();
                i = i2 + 1;
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(f23407a + "|parseIDCConfigURL exception" + e.toString(), new Object[0]);
            strArr = strArr2;
        }
        return strArr;
    }

    private static void b(JSONObject jSONObject) {
        if (jSONObject.has("loc") && jSONObject.has(Recognizer.KEY_CONFIDENCE)) {
            try {
                SDKUrlConfig.setLocation(jSONObject.getString("loc"));
                String str = com.igexin.push.core.e.f;
                com.igexin.c.a.c.a.a(f23407a + " set group id : " + com.igexin.push.core.e.f, new Object[0]);
                JSONArray jSONArray = jSONObject.getJSONArray(Recognizer.KEY_CONFIDENCE);
                String[] a2 = a(jSONArray);
                if (a2 == null || a2.length <= 1) {
                    return;
                }
                String[] idcConfigUrl = SDKUrlConfig.getIdcConfigUrl();
                if (idcConfigUrl != null && (idcConfigUrl.length <= 1 || a2[1].equals(idcConfigUrl[1]))) {
                    com.igexin.c.a.c.a.a(f23407a + "|current idc config url == new idc config url, return", new Object[0]);
                    return;
                }
                if (com.igexin.push.core.e.ao == 0) {
                    a(a2[1], jSONArray);
                } else if (System.currentTimeMillis() - com.igexin.push.core.e.ao > 7200000) {
                    a(a2[1], jSONArray);
                } else {
                    com.igexin.c.a.c.a.a(f23407a + "|get idc cfg last time less than 2 hours return", new Object[0]);
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(f23407a + e.toString(), new Object[0]);
            }
        }
    }

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        String str;
        com.igexin.c.a.c.a.a(f23407a + "|redirect server resp data : " + jSONObject, new Object[0]);
        try {
            a(jSONObject);
            com.igexin.c.a.b.a.a.d.a().g();
            if (jSONObject.has("loc") && jSONObject.has(Recognizer.KEY_CONFIDENCE)) {
                try {
                    SDKUrlConfig.setLocation(jSONObject.getString("loc"));
                    String str2 = com.igexin.push.core.e.f;
                    com.igexin.c.a.c.a.a(f23407a + " set group id : " + com.igexin.push.core.e.f, new Object[0]);
                    JSONArray jSONArray = jSONObject.getJSONArray(Recognizer.KEY_CONFIDENCE);
                    String[] a2 = a(jSONArray);
                    if (a2 != null && a2.length > 1) {
                        String[] idcConfigUrl = SDKUrlConfig.getIdcConfigUrl();
                        if (idcConfigUrl != null && (idcConfigUrl.length <= 1 || a2[1].equals(idcConfigUrl[1]))) {
                            com.igexin.c.a.c.a.a(f23407a + "|current idc config url == new idc config url, return", new Object[0]);
                        }
                        if (com.igexin.push.core.e.ao == 0) {
                            str = a2[1];
                        } else if (System.currentTimeMillis() - com.igexin.push.core.e.ao > 7200000) {
                            str = a2[1];
                        } else {
                            com.igexin.c.a.c.a.a(f23407a + "|get idc cfg last time less than 2 hours return", new Object[0]);
                        }
                        a(str, jSONArray);
                    }
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(f23407a + e.toString(), new Object[0]);
                }
            }
            if (com.igexin.push.f.g.a()) {
                com.igexin.c.a.c.a.a(f23407a + "|redirect reInit so ~~~~~", new Object[0]);
                com.igexin.push.f.g.d();
                return true;
            }
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(f23407a + e2.toString(), new Object[0]);
            return true;
        }
    }
}
