package com.kwad.sdk.core.c;

import android.content.Context;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/c/a.class */
public class a {
    public static SimpleDateFormat JQ = new SimpleDateFormat("yyyy-MM-dd");
    private static volatile a afU;

    private static boolean a(f fVar) {
        long j = fVar.alK;
        if (j <= 0) {
            return false;
        }
        return JQ.format(new Date(j)).equals(JQ.format(new Date()));
    }

    public static void am(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            b.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            an(adTemplate);
        }
    }

    private static void an(AdTemplate adTemplate) {
        f fVar;
        List<f> list;
        boolean z;
        int cj = d.cj(adTemplate);
        int bV = d.bV(adTemplate);
        ArrayList vW = vW();
        if (vW != null && vW.size() != 0) {
            Iterator<f> it = vW.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                if (next.adStyle == bV && next.taskType == cj) {
                    next.count++;
                    if (!a(next)) {
                        next.count = 1;
                        next.T(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            list = vW;
            if (!z) {
                fVar = new f(bV, cj, 1, System.currentTimeMillis());
            }
            t("ksadsdk_local_ad_task_info_adstyle_data", t.C(list).toString());
            adTemplate.watched = true;
        }
        vW = new ArrayList();
        fVar = new f(bV, cj, 1, System.currentTimeMillis());
        vW.add(fVar);
        list = vW;
        t("ksadsdk_local_ad_task_info_adstyle_data", t.C(list).toString());
        adTemplate.watched = true;
    }

    private static List<f> bb(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> vW = vW();
        if (vW != null) {
            if (vW.size() == 0) {
                return arrayList;
            }
            for (f fVar : vW) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void c(int i, long j) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static String getString(String str) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }

    private static void t(String str, String str2) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    public static a vU() {
        if (afU == null) {
            synchronized (a.class) {
                try {
                    if (afU == null) {
                        afU = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return afU;
    }

    public static boolean vV() {
        List<f> bb = bb(15);
        if (bb.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (f fVar : bb) {
            int i2 = i + fVar.count;
            i = i2;
            if (fVar.alK > j) {
                j = fVar.alK;
                i = i2;
            }
        }
        b.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > vX()) {
            return false;
        }
        return j + (vY() * 1000) <= System.currentTimeMillis();
    }

    public static List<f> vW() {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int vX() {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long vY() {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }
}
