package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/o.class */
public class o {
    public static s a(JSONObject jSONObject) {
        p b = b(jSONObject);
        if (b == null) {
            return null;
        }
        int a2 = b.a();
        String l = b.l();
        String j = b.j();
        boolean z = b.d() == 1;
        boolean z2 = b.h() == 1;
        int e = b.e();
        String c2 = b.c();
        String f = b.f();
        String b2 = b.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f;
            packageInfo.versionName = l;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(b2) && b2.startsWith(".")) {
                applicationInfo.name = f + b2;
                applicationInfo.className = f + b2;
            }
            applicationInfo.theme = b.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m = b.m();
            if (m != null && m.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= m.size()) {
                        break;
                    }
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m.get(i2).c();
                    activityInfo.theme = m.get(i2).b();
                    activityInfo.labelRes = m.get(i2).a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                    i = i2 + 1;
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable th) {
        }
        s sVar = new s(packageInfo, a2, f, l, j, c2);
        sVar.v = z;
        sVar.x = e;
        int a3 = b.k() == null ? 0 : b.k().a();
        int b3 = b.k() == null ? -1 : b.k().b();
        sVar.t = a3;
        sVar.u = b3;
        sVar.s = System.currentTimeMillis();
        boolean z3 = z2;
        if (Build.VERSION.SDK_INT > 29) {
            z3 = z2;
            if (z2) {
                z3 = b.g() == 1;
            }
        }
        sVar.y = z3;
        return sVar;
    }

    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString("wm"));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString(bh.q));
            pVar.e(jSONObject.optInt("ws", 1));
            int i = 0;
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt(com.anythink.expressad.d.a.b.R));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            while (true) {
                ArrayList arrayList2 = arrayList;
                if (i >= jSONArray.length()) {
                    pVar.a(arrayList2);
                    p.b bVar = new p.b();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("we");
                    bVar.a(jSONObject2.optInt("duration"));
                    bVar.b(jSONObject2.optInt("network"));
                    pVar.a(bVar);
                    return pVar;
                }
                p.a aVar = new p.a();
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                aVar.a(jSONObject3.optInt("r"));
                aVar.b(jSONObject3.optInt("t"));
                aVar.a(jSONObject3.getString("n"));
                ArrayList arrayList3 = arrayList2;
                if (arrayList2 == null) {
                    arrayList3 = new ArrayList();
                }
                arrayList3.add(aVar);
                i++;
                arrayList = arrayList3;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
