package com.opos.mobad.provider.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.opos.mobad.provider.record.SdKRecord;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/statistic/StatisticModel.class */
public class StatisticModel implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.statistic.StatisticModel.1
        @Override // com.opos.process.bridge.provider.d.a
        public StatisticModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            StatisticModelIdentify statisticModelIdentify = (StatisticModelIdentify) iBridgeTargetIdentify;
            return StatisticModel.a(context.getApplicationContext(), statisticModelIdentify.f13443a, statisticModelIdentify.b);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static volatile StatisticModel f13442a;
    private Context b;

    private StatisticModel(Context context, boolean z, String str) {
        this.b = context;
        String str2 = TextUtils.isEmpty(str) ? "CN" : str;
        Context context2 = this.b;
        com.opos.cmn.f.a.a(context2, com.opos.cmn.an.b.a.a(context2), str2);
        if (z) {
            com.opos.cmn.f.a.b();
        }
    }

    public static StatisticModel a(Context context, boolean z, String str) {
        StatisticModel statisticModel;
        StatisticModel statisticModel2 = f13442a;
        if (statisticModel2 == null) {
            synchronized (StatisticModel.class) {
                try {
                    StatisticModel statisticModel3 = f13442a;
                    statisticModel = statisticModel3;
                    if (statisticModel3 == null) {
                        statisticModel = new StatisticModel(context, z, str);
                        f13442a = statisticModel;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return statisticModel;
        }
        return statisticModel2;
    }

    private String a() {
        String str = "";
        if (com.opos.cmn.an.f.a.b(this.b)) {
            return "";
        }
        List<PackageInfo> installedPackages = this.b.getPackageManager().getInstalledPackages(128);
        if (installedPackages != null) {
            if (installedPackages.size() <= 0) {
                return "";
            }
            com.opos.cmn.an.f.a.b("report", "size:" + installedPackages.size());
            StringBuilder sb = new StringBuilder();
            for (PackageInfo packageInfo : installedPackages) {
                sb.append(packageInfo.packageName);
                sb.append(":");
            }
            if (sb.length() <= 0) {
                return "";
            }
            str = sb.substring(0, sb.length() - 1);
        }
        return str;
    }

    private void a(String str, Map<String, String> map) {
        com.opos.cmn.an.f.a.a("report", "report transport params =" + str);
        com.opos.cmn.an.f.a.a("report", "report params =", map);
        com.opos.cmn.f.a.a(this.b, str, map);
    }

    @BridgeMethod(a = 2)
    public final void a(String str) {
        if (!TextUtils.isEmpty(str) && SdKRecord.a(this.b).e() + 86400000 <= System.currentTimeMillis()) {
            try {
                Map<String, String> b = b(str);
                b.put("data", a());
                a("", b);
                SdKRecord.a(this.b).f();
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.b("", "transport fail", e);
            }
        }
    }

    @BridgeMethod(a = 1)
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            a(str, b(str2));
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.b("", "transport fail", e);
        }
    }

    public Map<String, String> b(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }
}
