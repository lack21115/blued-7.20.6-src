package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.model.ConfigMetric;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/h.class */
class h extends a<JSONObject> {
    private String o;
    protected Map<String, i> p;

    public h(String str, int i) {
        super(i);
        this.o = str;
        this.p = new HashMap();
    }

    public boolean a(int i, String str, Map<String, String> map) {
        i iVar;
        Map<String, i> map2 = this.p;
        return (map2 == null || (iVar = map2.get(str)) == null) ? a(i) : iVar.a(i, map);
    }

    public void b(JSONObject jSONObject) {
        a((h) jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("monitorPoints");
            if (optJSONArray == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return;
                }
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                String optString = jSONObject2.optString("monitorPoint");
                String optString2 = jSONObject2.optString("metric_comment_detail");
                if (com.alibaba.mtl.appmonitor.f.b.c(optString)) {
                    i iVar = this.p.get(optString);
                    i iVar2 = iVar;
                    if (iVar == null) {
                        iVar2 = new i(optString, this.n);
                        this.p.put(optString, iVar2);
                    }
                    iVar2.b(jSONObject2);
                    Metric metric = MetricRepo.getRepo().getMetric(this.o, optString);
                    if (metric != null) {
                        metric.setCommitDetailFromConfig(optString2);
                    }
                    Object opt = jSONObject2.opt("measures");
                    if (opt instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) opt;
                        MeasureSet create = MeasureSet.create();
                        int length = jSONArray.length();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= length) {
                                break;
                            }
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                            if (jSONObject3 != null) {
                                String optString3 = jSONObject3.optString("name");
                                Double valueOf = Double.valueOf(jSONObject3.optDouble("min"));
                                Double valueOf2 = Double.valueOf(jSONObject3.optDouble("max"));
                                if (optString3 != null && valueOf != null && valueOf2 != null) {
                                    create.addMeasure(new Measure(optString3, Double.valueOf(0.0d), valueOf, valueOf2));
                                }
                            }
                            i3 = i4 + 1;
                        }
                        Metric metric2 = MetricRepo.getRepo().getMetric("config_prefix" + this.o, "config_prefix" + optString);
                        if (metric2 != null) {
                            MetricRepo.getRepo().remove(metric2);
                        }
                        MetricRepo.getRepo().add(new ConfigMetric("config_prefix" + this.o, "config_prefix" + optString, create));
                    }
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
    }
}
