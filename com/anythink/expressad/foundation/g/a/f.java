package com.anythink.expressad.foundation.g.a;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7832a = "native";
    public static final String b = "reward";

    /* renamed from: c  reason: collision with root package name */
    public static final String f7833c = "interactive";
    public static final String d = "interstitial";
    public static final String e = "banner";
    public static final String f = "splash";
    public static final String g = "h5_native";
    private static final String q = f.class.getSimpleName();
    public static Map<String, Long> h = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> i = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> j = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> k = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> l = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> m = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> n = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> o = new HashMap();
    public static Map<String, List<com.anythink.expressad.foundation.g.e.a>> p = new HashMap();

    private static String a(String str, String str2) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> b2;
        List<com.anythink.expressad.foundation.g.e.a> list;
        JSONArray jSONArray = new JSONArray();
        if (TextUtils.isEmpty(str2)) {
            b2 = null;
            if (j.containsKey(str)) {
                b2 = j;
            } else if (k.containsKey(str)) {
                b2 = k;
            } else if (l.containsKey(str)) {
                b2 = l;
            } else if (m.containsKey(str)) {
                b2 = m;
            } else if (n.containsKey(str)) {
                b2 = n;
            } else if (o.containsKey(str)) {
                b2 = o;
            } else if (p.containsKey(str)) {
                b2 = p;
            }
        } else {
            b2 = b(str2);
        }
        if (b2 != null) {
            try {
                if (w.b(str) && b2.containsKey(str) && (list = b2.get(str)) != null && list.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= list.size()) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("cid", list.get(i3).a());
                        jSONObject.put("rid", list.get(i3).b());
                        jSONArray.put(jSONObject);
                        i2 = i3 + 1;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    private static Map<String, List<com.anythink.expressad.foundation.g.e.a>> a(String str) {
        if (j.containsKey(str)) {
            return j;
        }
        if (k.containsKey(str)) {
            return k;
        }
        if (l.containsKey(str)) {
            return l;
        }
        if (m.containsKey(str)) {
            return m;
        }
        if (n.containsKey(str)) {
            return n;
        }
        if (o.containsKey(str)) {
            return o;
        }
        if (p.containsKey(str)) {
            return p;
        }
        return null;
    }

    public static void a(String str, com.anythink.expressad.foundation.d.c cVar, String str2) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> b2 = b(str2);
        if (cVar == null || b2 == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(cVar.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.Z());
            if (!b2.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar);
                b2.put(str, arrayList);
                return;
            }
            List<com.anythink.expressad.foundation.g.e.a> list = b2.get(str);
            if (list != null && list.size() == 20) {
                list.remove(0);
            }
            if (list != null) {
                list.add(aVar);
            }
        } catch (Throwable th) {
            o.b(q, th.getMessage(), th);
        }
    }

    private static void a(Map... mapArr) {
        try {
            int length = mapArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                Map map = mapArr[i3];
                if (map != null) {
                    map.clear();
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            o.b(q, th.getMessage(), th);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Map<String, List<com.anythink.expressad.foundation.g.e.a>> b(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1052618729:
                if (str.equals(f7832a)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -934326481:
                if (str.equals("reward")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -895866265:
                if (str.equals(f)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 538816457:
                if (str.equals(g)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 604727084:
                if (str.equals(d)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1844104930:
                if (str.equals(f7833c)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                return j;
            case true:
                return k;
            case true:
                return l;
            case true:
                return m;
            case true:
                return n;
            case true:
                return o;
            case true:
                return p;
            default:
                return null;
        }
    }

    private static void b(String str, com.anythink.expressad.foundation.d.c cVar, String str2) {
        Map<String, List<com.anythink.expressad.foundation.g.e.a>> b2 = b(str2);
        if (cVar == null || b2 == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(cVar.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.e.a aVar = new com.anythink.expressad.foundation.g.e.a(cVar.aZ(), cVar.Z());
            if (!b2.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar);
                b2.put(str, arrayList);
                return;
            }
            List<com.anythink.expressad.foundation.g.e.a> list = b2.get(str);
            if (list != null) {
                list.add(aVar);
            }
        } catch (Throwable th) {
            o.b(q, th.getMessage(), th);
        }
    }
}
