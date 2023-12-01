package com.anythink.expressad.video.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.f.h.b;
import com.anythink.expressad.foundation.h.j;
import com.anythink.expressad.foundation.h.o;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, ArrayList<String>> f8512a = new HashMap<>();
    private static final String b = "VideoViewReport";

    private static String a(String str, b bVar) {
        String trim = bVar.a().trim();
        if (TextUtils.isEmpty(trim)) {
            return "";
        }
        String str2 = str;
        if (!str.endsWith("?")) {
            str2 = str;
            if (!str.endsWith("&")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str.contains("?") ? "&" : "?");
                str2 = sb.toString();
            }
        }
        return str2 + trim;
    }

    public static void a() {
    }

    public static void a(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().o(), false);
    }

    public static void a(Context context, c cVar, int i, int i2) {
        String str;
        try {
            String[] p = cVar.L().p();
            if (cVar == null || cVar.L() == null || p == null) {
                return;
            }
            String[] strArr = new String[p.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= p.length) {
                    com.anythink.expressad.a.a.a(context, cVar, cVar.K(), strArr, true);
                    return;
                }
                String str2 = p[i4];
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("endscreen_type", i);
                String jSONObject2 = jSONObject.toString();
                String str3 = jSONObject2;
                if (!TextUtils.isEmpty(jSONObject2)) {
                    str3 = j.a(jSONObject2);
                }
                String str4 = str2;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str2 + "&value=" + URLEncoder.encode(str3);
                }
                if (cVar.n() == 1) {
                    str = str4 + "&to=1&cbt=" + cVar.az() + "&tmorl=" + i2;
                } else {
                    str = str4 + "&to=0&cbt=" + cVar.az() + "&tmorl=" + i2;
                }
                strArr[i4] = str;
                i3 = i4 + 1;
            }
        } catch (Throwable th) {
            o.d("", "reportEndcardshowData error");
        }
    }

    public static void a(Context context, c cVar, int i, int i2, int i3) {
        String str;
        if (i2 == 0 || context == null || cVar == null) {
            return;
        }
        try {
            List<Map<Integer, String>> i4 = cVar.L().i();
            int i5 = ((i + 1) * 100) / i2;
            if (i4 == null) {
                return;
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= i4.size()) {
                    return;
                }
                Map<Integer, String> map = i4.get(i7);
                int i8 = i7;
                if (map != null) {
                    i8 = i7;
                    if (map.size() > 0) {
                        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                        while (true) {
                            i8 = i7;
                            if (it.hasNext()) {
                                Map.Entry<Integer, String> next = it.next();
                                int intValue = next.getKey().intValue();
                                String value = next.getValue();
                                if (cVar.n() == 1) {
                                    str = value + "&to=1&cbt=" + cVar.az() + "&tmorl=" + i3;
                                } else {
                                    str = value + "&to=0&cbt=" + cVar.az() + "&tmorl=" + i3;
                                }
                                if (intValue <= i5 && !TextUtils.isEmpty(str)) {
                                    com.anythink.expressad.a.a.a(context, cVar, cVar.K(), new String[]{str}, true);
                                    it.remove();
                                    i4.remove(i7);
                                    i7--;
                                }
                            }
                        }
                    }
                }
                i6 = i8 + 1;
            }
        } catch (Throwable th) {
            o.d("", "reportPlayPercentageData error");
        }
    }

    public static void a(c cVar, com.anythink.expressad.videocommon.c.c cVar2, String str, String str2, String str3) {
        if (cVar == null || cVar2 == null) {
            return;
        }
        try {
            com.anythink.expressad.video.module.c.a aVar = new com.anythink.expressad.video.module.c.a(n.a().g());
            b bVar = new b();
            bVar.a("user_id", j.a(str2));
            bVar.a(com.anythink.expressad.d.a.b.aM, "1");
            bVar.a("reward_name", cVar2.a());
            StringBuilder sb = new StringBuilder();
            sb.append(cVar2.b());
            bVar.a("reward_amount", sb.toString());
            bVar.a("unit_id", str);
            bVar.a("click_id", cVar.aa());
            if (!TextUtils.isEmpty(str3)) {
                bVar.a("extra", str3);
            }
            aVar.a("", bVar);
            String str4 = cVar.ak() + "/addReward?";
            String trim = bVar.a().trim();
            String str5 = "";
            if (!TextUtils.isEmpty(trim)) {
                String str6 = str4;
                if (!str4.endsWith("?")) {
                    str6 = str4;
                    if (!str4.endsWith("&")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str4);
                        sb2.append(str4.contains("?") ? "&" : "?");
                        str6 = sb2.toString();
                    }
                }
                str5 = str6 + trim;
            }
            o.d(b, "rewardUrl:".concat(String.valueOf(str5)));
            com.anythink.expressad.a.a.a(n.a().g(), cVar, cVar.K(), str5, false);
        } catch (Throwable th) {
            o.b(b, th.getMessage(), th);
        }
    }

    public static void a(c cVar, String str) {
        if (cVar != null) {
            try {
                if (cVar.al() == null || cVar.al().size() <= 0) {
                    return;
                }
                for (String str2 : cVar.al()) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.anythink.expressad.a.a.a(n.a().g(), cVar, str, str2, false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(c cVar, Map<Integer, String> map, String str, int i) {
        if (cVar == null || map == null) {
            return;
        }
        try {
            if (map.size() > 0) {
                Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> next = it.next();
                    Integer key = next.getKey();
                    String value = next.getValue();
                    if (i == key.intValue() && !TextUtils.isEmpty(value)) {
                        com.anythink.expressad.a.a.a(n.a().g(), cVar, str, value, false);
                        it.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str) {
        f8512a.remove(str);
    }

    public static void b(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().j() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().j(), false);
    }

    public static void c(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().k() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().k(), false);
    }

    public static void d(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().q() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().q(), false);
    }

    public static void e(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().m() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().m(), false);
    }

    private static void f(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().d() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().d(), true);
    }

    private static void g(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().e() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().e(), false);
    }

    private static void h(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().f() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().f(), false);
    }

    private static void i(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().g() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().g(), false);
    }

    private static void j(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().h() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().h(), false);
    }

    private static void k(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().l() == null) {
            return;
        }
        String K = cVar.K();
        ArrayList<String> arrayList = f8512a.get(K);
        ArrayList<String> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList<>();
            f8512a.put(K, arrayList2);
        }
        if (arrayList2.contains(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().l(), false);
        arrayList2.add(cVar.aZ());
    }
}
