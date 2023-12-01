package com.anythink.expressad.splash.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5344a = a.class.getSimpleName();

    public static c a(String str, c cVar) {
        String valueOf;
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        if (TextUtils.isEmpty(str) && cVar == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                JSONObject a2 = c.a(cVar);
                JSONObject jSONObject = new JSONObject(str);
                try {
                    if (!jSONObject.has(c.O)) {
                        a2.put(c.O, "");
                    }
                } catch (Exception e) {
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a2.put(next, jSONObject.getString(next));
                }
                c b = c.b(a2);
                String optString = a2.optString("unitId");
                if (!TextUtils.isEmpty(optString)) {
                    b.l(optString);
                }
                return b;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return cVar;
            }
        }
        JSONObject a3 = c.a(cVar);
        c b2 = c.b(a3);
        c cVar2 = b2;
        if (b2 == null) {
            cVar2 = cVar;
        }
        if (!TextUtils.isEmpty(str)) {
            String optString2 = a3.optString("unitId");
            if (!TextUtils.isEmpty(optString2)) {
                cVar2.l(optString2);
            }
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(com.anythink.expressad.foundation.g.a.ce);
            if (optJSONObject != null) {
                t.b(n.a().g(), Integer.valueOf(optJSONObject.getString(com.anythink.expressad.foundation.g.a.cc)).intValue());
                t.b(n.a().g(), Integer.valueOf(optJSONObject.getString(com.anythink.expressad.foundation.g.a.cd)).intValue());
            }
            cVar2.p(cVar2.ad());
            String ah = cVar2.ah();
            if (optJSONObject != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                StringBuilder sb = new StringBuilder();
                while (keys2.hasNext()) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    String next2 = keys2.next();
                    String optString3 = optJSONObject.optString(next2);
                    if (!com.anythink.expressad.foundation.g.a.cc.equals(next2)) {
                        valueOf = optString3;
                        if (!com.anythink.expressad.foundation.g.a.cd.equals(next2)) {
                            sb.append(next2);
                            sb.append("=");
                            sb.append(valueOf);
                        }
                    }
                    valueOf = String.valueOf(t.b(n.a().g(), Integer.valueOf(optString3).intValue()));
                    sb.append(next2);
                    sb.append("=");
                    sb.append(valueOf);
                }
                try {
                    cVar2.q(ah + ((Object) sb));
                } catch (Throwable th) {
                    return cVar;
                }
            }
        }
        return cVar2;
    }

    private static String a() {
        return "";
    }

    private static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable th) {
            o.d(f5344a, "code to string is error");
            return "";
        }
    }

    public static String a(int i, float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (i == 4) {
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, com.anythink.expressad.video.bt.a.c.f5450a);
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, com.anythink.expressad.video.bt.a.c.f5450a);
            } else {
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, t.a(n.a().g(), f));
                jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, t.a(n.a().g(), f2));
            }
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cf, i);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cg, n.a().g().getResources().getConfiguration().orientation);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.ch, t.c(n.a().g()));
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static String a(String str) {
        List<com.anythink.expressad.foundation.g.e.a> list;
        try {
            if (f.i == null) {
                return "";
            }
            Map<String, List<com.anythink.expressad.foundation.g.e.a>> map = f.i;
            if (!w.b(str) || !map.containsKey(str) || (list = map.get(str)) == null || list.size() <= 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return jSONArray.toString();
                }
                JSONObject jSONObject = new JSONObject();
                com.anythink.expressad.foundation.g.e.a aVar = list.get(i2);
                jSONObject.put("cid", aVar.a());
                jSONObject.put("crid", aVar.c());
                jSONArray.put(jSONObject);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static List<com.anythink.expressad.foundation.g.e.a> a(List<com.anythink.expressad.foundation.g.e.a> list, List<c> list2) {
        List<com.anythink.expressad.foundation.g.e.a> list3;
        synchronized (a.class) {
            list3 = list;
            if (list2 != null) {
                list3 = list;
                try {
                    if (list2.size() > 0) {
                        ArrayList arrayList = list;
                        if (list == null) {
                            arrayList = new ArrayList();
                        }
                        Iterator<c> it = list2.iterator();
                        while (true) {
                            list3 = arrayList;
                            if (!it.hasNext()) {
                                break;
                            }
                            c next = it.next();
                            if (next != null) {
                                com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(next.aZ(), next.r());
                                if (arrayList.size() >= 20) {
                                    arrayList.remove(0);
                                }
                                arrayList.add(aVar);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return list3;
    }

    private static void a(Context context, List<c> list) {
        o.b(f5344a, "updateInstallList 开始 更新本机已安装广告列表");
        if (context == null || list == null || list.size() == 0) {
            o.b(f5344a, "updateInstallList 列表为空 不做更新本机已安装广告列表");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            c cVar = list.get(i2);
            if (cVar != null) {
                t.a(context, cVar.ba());
            }
            i = i2 + 1;
        }
    }

    private static void a(String str, List<c> list) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> map = f.i;
        if (map == null || list == null || list.size() <= 0) {
            return;
        }
        if (w.b(str)) {
            if (map.containsKey(str)) {
                map.put(str, a(map.get(str), list));
            } else {
                map.put(str, a(new ArrayList(), list));
            }
        }
        f.i = map;
    }

    private static String b() {
        return "";
    }
}
