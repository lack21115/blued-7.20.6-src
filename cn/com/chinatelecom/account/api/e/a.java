package cn.com.chinatelecom.account.api.e;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.d.g;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/e/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4136a = a.class.getSimpleName();
    private static HashMap<String, String> b = new HashMap<>();

    public static long a(Context context) {
        return c.b(context, "key_difference_time", 0L);
    }

    public static cn.com.chinatelecom.account.api.d.d a(Context context, HttpURLConnection httpURLConnection, boolean z) {
        if (z) {
            cn.com.chinatelecom.account.api.d.d dVar = new cn.com.chinatelecom.account.api.d.d();
            try {
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                List<String> list = headerFields.get("p");
                if (list != null && list.size() > 0) {
                    String str = list.get(0);
                    String str2 = f4136a;
                    CtAuth.info(str2, "request protocol : " + str);
                    dVar.b = false;
                }
                List<String> list2 = headerFields.get("Set-Cookie");
                if (list2 != null && list2.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list2.size()) {
                            break;
                        }
                        String str3 = list2.get(0);
                        if (!TextUtils.isEmpty(str3) && str3.contains("gw_auth")) {
                            dVar.f4127a = a(str3, "gw_auth");
                            break;
                        }
                        i = i2 + 1;
                    }
                }
                List<String> list3 = headerFields.get("Log-Level");
                if (list3 != null && !list3.isEmpty()) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= list3.size()) {
                            break;
                        }
                        String str4 = list3.get(0);
                        if (!TextUtils.isEmpty(str4)) {
                            f.a(context, str4);
                        }
                        i3 = i4 + 1;
                    }
                }
                List<String> list4 = headerFields.get("p-reset");
                if (list4 != null && !list4.isEmpty()) {
                    String str5 = list4.get(0);
                    if (!TextUtils.isEmpty(str5)) {
                        a(context, str5);
                    }
                }
                List<String> list5 = headerFields.get("p-ikgx");
                if (list5 != null && !list5.isEmpty()) {
                    String str6 = list5.get(0);
                    if (!TextUtils.isEmpty(str6)) {
                        dVar.f4128c = str6;
                        g.d = str6;
                        return dVar;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return dVar;
        }
        return null;
    }

    public static cn.com.chinatelecom.account.api.d.d a(HttpURLConnection httpURLConnection) {
        cn.com.chinatelecom.account.api.d.d dVar = new cn.com.chinatelecom.account.api.d.d();
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            List<String> list = headerFields.get("rdt_allow");
            if (list != null && list.size() > 0) {
                dVar.d = list.get(0);
                String str = f4136a;
                CtAuth.info(str, "request method : " + dVar.d);
            }
            List<String> list2 = headerFields.get("p-ikgx");
            if (list2 != null && !list2.isEmpty()) {
                String str2 = list2.get(0);
                if (!TextUtils.isEmpty(str2)) {
                    dVar.f4128c = str2;
                    return dVar;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return dVar;
    }

    public static String a(int i) {
        synchronized (a.class) {
            try {
                return i == cn.com.chinatelecom.account.api.a.d ? "presdk" : "preauthIfaa";
            } finally {
            }
        }
    }

    private static String a(String str, String str2) {
        try {
            String[] split = str.split(";");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return "";
                }
                if (split[i2].contains(str2)) {
                    return split[i2].split("=")[1];
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static JSONObject a(Context context, cn.com.chinatelecom.account.api.d.h hVar, String str, Network network, boolean z, String str2) {
        if (hVar == null || hVar.b == null) {
            return j.b();
        }
        JSONObject jSONObject = hVar.b;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hVar.f4134a != -1 && !TextUtils.isEmpty(str)) {
            int optInt = jSONObject.optInt("result");
            String optString = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(h.a(optString, str));
                if (optInt == 0) {
                    jSONObject2.put("gwAuth", hVar.f4135c);
                }
                if (optInt == -10020) {
                    jSONObject.put(DBDefinition.TASK_ID, str);
                }
                jSONObject.put("data", jSONObject2);
            }
            if (optInt != 30002 || !z) {
                if (optInt == -10009 || optInt == -30001) {
                    long optLong = jSONObject.optLong("timeStamp", -1L);
                    if (optLong == -1) {
                        b(context);
                        return jSONObject;
                    }
                    a(context, optLong);
                    return jSONObject;
                }
                return jSONObject;
            }
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("data");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject3.optJSONArray("urls");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    arrayList.add(optJSONArray.getString(i2));
                    i = i2 + 1;
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return a(context, arrayList, str, network, str2);
        }
        return jSONObject;
    }

    private static JSONObject a(Context context, List<String> list, String str, Network network, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return j.a(80001, cn.com.chinatelecom.account.api.a.d.a(j.b) + "- redirect 30002 ");
            }
            try {
                String str3 = list.get(i2);
                if (!TextUtils.isEmpty(str3)) {
                    if (!g.c(context) && Build.VERSION.SDK_INT < 21) {
                        cn.com.chinatelecom.account.api.d.f.a(context, str3);
                    }
                    g.a aVar = new g.a();
                    try {
                        aVar.b(str2);
                        try {
                            aVar.a(network);
                            JSONObject a2 = a(context, new cn.com.chinatelecom.account.api.d.b(context).a(str3, "", 0, aVar.a()), str, network, false, str2);
                            if (a2 != null && a2.optInt("result") == 0) {
                                return a2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            i = i2 + 1;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            i = i2 + 1;
        }
    }

    private static void a(Context context, long j) {
        if (j > 0) {
            c.a(context, "key_difference_time", j - System.currentTimeMillis());
        }
    }

    private static void a(Context context, String str) {
        c.a(context, "key_p_rset_v3.8.10", str);
    }

    private static void b(Context context) {
        String a2 = d.a();
        g.a aVar = new g.a();
        aVar.a("reqTimestamp");
        aVar.b(a2);
        JSONObject jSONObject = new cn.com.chinatelecom.account.api.d.b(context).a(g.b(), "", 1, aVar.a()).b;
        if (jSONObject != null) {
            a(context, jSONObject.optLong("msg", -1L));
        }
    }
}
