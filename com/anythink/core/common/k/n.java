package com.anythink.core.common.k;

import android.provider.Downloads;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.v;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/n.class */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6818a = "anythink_bidding";

    public static void a(String str, com.anythink.core.common.e.e eVar, String str2, ai aiVar, int i, int i2) {
        a(str, eVar, str2, aiVar, i, i2, null);
    }

    public static void a(String str, com.anythink.core.common.e.e eVar, String str2, ai aiVar, int i, int i2, List<String> list) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reason", str2);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str);
                jSONObject.put("adtype", eVar.Z());
                jSONObject.put("adsourceId", aiVar.t());
                jSONObject.put("networkFirmId", aiVar.c());
                jSONObject.put("content", eVar.G());
                jSONObject.put("hourly_frequency", i);
                jSONObject.put("hourly_limit", aiVar.f());
                jSONObject.put("daily_frequency", i2);
                jSONObject.put("daily_limit", aiVar.e());
                jSONObject.put("pacing_limit", aiVar.s());
                jSONObject.put("request_fail_interval", aiVar.H());
                if (list == null) {
                    list = "";
                }
                jSONObject.put("filter_source_ids", list);
                a("anythink_network", jSONObject.toString(), true);
            } catch (Throwable th) {
            }
        }
    }

    public static void a(String str, String str2) {
        if (ATSDK.isNetworkLogDebug()) {
            a("anythink_".concat(String.valueOf(str)), str2, false);
        }
    }

    public static void a(String str, String str2, String str3, ai aiVar) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", g.i.v);
                jSONObject.put("result", str);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str2);
                jSONObject.put("adtype", str3);
                jSONObject.put("adsourceId", aiVar.t());
                jSONObject.put("networkFirmId", aiVar.c());
                jSONObject.put("content", aiVar.g());
                jSONObject.put("msg", aiVar.z());
                a(f6818a, jSONObject.toString(), TextUtils.equals(g.i.g, str));
            } catch (Throwable th) {
            }
        }
    }

    private static void a(String str, String str2, String str3, String str4) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", g.i.w);
                jSONObject.put("result", str);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str2);
                jSONObject.put("adtype", str3);
                jSONObject.put(Downloads.Impl.COLUMN_ERROR_MSG, str4);
                a("anythink_network", jSONObject.toString(), TextUtils.equals(g.i.g, str));
            } catch (Throwable th) {
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        if (ATSDK.isNetworkLogDebug()) {
            boolean z = true;
            switch (str2.hashCode()) {
                case 48:
                    if (str2.equals("0")) {
                        z = false;
                        break;
                    }
                    break;
                case 49:
                    if (str2.equals("1")) {
                        z = true;
                        break;
                    }
                    break;
                case 50:
                    if (str2.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 51:
                    if (str2.equals("3")) {
                        z = true;
                        break;
                    }
                    break;
                case 52:
                    if (str2.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
            }
            a(str, z ? !z ? !z ? !z ? !z ? "" : g.i.m : g.i.j : g.i.i : g.i.k : g.i.l, str3, str4, str5, false);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        String str6;
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str);
                jSONObject.put("adtype", str2);
                jSONObject.put("api", str3);
                jSONObject.put("result", str4);
                jSONObject.put("reason", str5);
                if (z) {
                    if (!TextUtils.isEmpty(str)) {
                        Map<String, Object> c2 = v.a().c(str);
                        if (c2.size() > 0) {
                            String str7 = "";
                            for (Map.Entry<String, Object> entry : c2.entrySet()) {
                                str7 = str7 + "key=" + entry.getKey() + ",value=" + entry.getValue().toString() + ";";
                            }
                            str6 = "[" + str7 + "]";
                            jSONObject.put("extra", str6);
                        }
                    }
                    str6 = "";
                    jSONObject.put("extra", str6);
                }
                StringBuilder sb = new StringBuilder("anythink_network");
                sb.append(com.anythink.core.common.b.n.a().v() ? "(DebuggerMode)" : "");
                Log.i(sb.toString(), jSONObject.toString());
            } catch (Throwable th) {
            }
        }
    }

    public static void a(String str, String str2, boolean z) {
        String str3;
        String[] split;
        String property = System.getProperty("line.separator");
        try {
            if (str2.startsWith("{")) {
                str3 = new JSONObject(str2).toString(4);
            } else {
                str3 = str2;
                if (str2.startsWith("[")) {
                    str3 = new JSONArray(str2).toString(4);
                }
            }
        } catch (JSONException e) {
            str3 = str2;
        }
        String str4 = "╔═══════════════════════════════════════════════════════════════════════════════════════";
        for (String str5 : str3.split(property)) {
            str4 = (str4 + "\n") + "║ " + str5;
        }
        String str6 = str4 + "\n╚═══════════════════════════════════════════════════════════════════════════════════════";
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(com.anythink.core.common.b.n.a().v() ? "(DebuggerMode)" : "");
            Log.e(sb.toString(), " \n".concat(String.valueOf(str6)));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(com.anythink.core.common.b.n.a().v() ? "(DebuggerMode)" : "");
        Log.i(sb2.toString(), " \n".concat(String.valueOf(str6)));
    }

    private static void b(String str, String str2) {
        a(str, str2, false);
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        a(str, str2, str3, str4, str5, false);
    }
}
