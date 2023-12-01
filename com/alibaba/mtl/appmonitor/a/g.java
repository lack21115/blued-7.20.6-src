package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/g.class */
public class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private Metric f4458a;
    private Map<DimensionValueSet, a> j;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/g$a.class */
    public class a {
        private int count = 0;
        private int l = 0;
        private List<MeasureValueSet> b = new ArrayList();

        public a() {
        }

        private MeasureValueSet a(MeasureValueSet measureValueSet) {
            List<Measure> measures;
            MeasureValueSet measureValueSet2 = (MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0]);
            if (g.this.f4458a != null && g.this.f4458a.getMeasureSet() != null && (measures = g.this.f4458a.getMeasureSet().getMeasures()) != null) {
                int size = measures.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    Measure measure = measures.get(i2);
                    if (measure != null) {
                        MeasureValue measureValue = (MeasureValue) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValue.class, new Object[0]);
                        MeasureValue value = measureValueSet.getValue(measure.getName());
                        if (value.getOffset() != null) {
                            measureValue.setOffset(value.getOffset().doubleValue());
                        }
                        measureValue.setValue(value.getValue());
                        measureValueSet2.setValue(measure.getName(), measureValue);
                    }
                    i = i2 + 1;
                }
            }
            return measureValueSet2;
        }

        public List<Map<String, Map<String, Double>>> a() {
            Map<String, MeasureValue> map;
            List<MeasureValueSet> list = this.b;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.b.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return arrayList;
                }
                MeasureValueSet measureValueSet = this.b.get(i2);
                if (measureValueSet != null && (map = measureValueSet.getMap()) != null && !map.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, MeasureValue> entry : map.entrySet()) {
                        HashMap hashMap2 = new HashMap();
                        String key = entry.getKey();
                        MeasureValue value = entry.getValue();
                        hashMap2.put("value", Double.valueOf(value.getValue()));
                        if (value.getOffset() != null) {
                            hashMap2.put("offset", value.getOffset());
                        }
                        hashMap.put(key, hashMap2);
                    }
                    arrayList.add(hashMap);
                }
                i = i2 + 1;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2141a(MeasureValueSet measureValueSet) {
            if (measureValueSet != null) {
                if (g.this.f4458a != null && g.this.f4458a.isCommitDetail()) {
                    this.b.add(a(measureValueSet));
                } else if (this.b.isEmpty()) {
                    this.b.add(a(measureValueSet));
                } else {
                    this.b.get(0).merge(measureValueSet);
                }
            }
        }

        public void i() {
            this.count++;
        }

        public void j() {
            this.l++;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    public JSONObject a() {
        JSONObject a2;
        Set<String> keySet;
        synchronized (this) {
            a2 = super.a();
            try {
                if (this.f4458a != null) {
                    a2.put("isCommitDetail", String.valueOf(this.f4458a.isCommitDetail()));
                }
                JSONArray jSONArray = (JSONArray) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
                if (this.j != null) {
                    for (Map.Entry<DimensionValueSet, a> entry : this.j.entrySet()) {
                        JSONObject jSONObject = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.e.class, new Object[0]);
                        DimensionValueSet key = entry.getKey();
                        a value = entry.getValue();
                        int i = value.count;
                        int i2 = value.l;
                        jSONObject.put("count", Integer.valueOf(i));
                        jSONObject.put("noise", Integer.valueOf(i2));
                        jSONObject.put("dimensions", key != null ? new JSONObject(key.getMap()) : "");
                        List<Map<String, Map<String, Double>>> a3 = value.a();
                        JSONArray jSONArray2 = new JSONArray();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < a3.size()) {
                                JSONObject jSONObject2 = new JSONObject();
                                Map<String, Map<String, Double>> map = a3.get(i4);
                                if (map != null && (keySet = map.keySet()) != null) {
                                    for (String str : keySet) {
                                        if (map.get(str) != null) {
                                            jSONObject2.put(str, new JSONObject(map.get(str)));
                                        } else {
                                            jSONObject2.put(str, "");
                                        }
                                    }
                                }
                                jSONArray2.put(jSONObject2);
                                i3 = i4 + 1;
                            }
                        }
                        jSONObject.put("measures", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
                a2.put("values", jSONArray);
            } catch (Exception e) {
            }
        }
        return a2;
    }

    public void a(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        a aVar;
        synchronized (this) {
            DimensionValueSet dimensionValueSet2 = dimensionValueSet;
            if (dimensionValueSet == null) {
                dimensionValueSet2 = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
                dimensionValueSet2.addValues(dimensionValueSet);
            }
            if (this.j.containsKey(dimensionValueSet2)) {
                aVar = this.j.get(dimensionValueSet2);
            } else {
                DimensionValueSet dimensionValueSet3 = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
                dimensionValueSet3.addValues(dimensionValueSet2);
                aVar = new a();
                this.j.put(dimensionValueSet3, aVar);
            }
            if (this.f4458a != null ? this.f4458a.valid(dimensionValueSet2, measureValueSet) : false) {
                aVar.i();
                aVar.m2141a(measureValueSet);
            } else {
                aVar.j();
                if (this.f4458a.isCommitDetail()) {
                    aVar.m2141a(measureValueSet);
                }
            }
            i.a("StatEvent", "entity  count:", Integer.valueOf(aVar.count), " noise:", Integer.valueOf(aVar.l));
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        synchronized (this) {
            super.clean();
            this.f4458a = null;
            for (DimensionValueSet dimensionValueSet : this.j.keySet()) {
                com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) dimensionValueSet);
            }
            this.j.clear();
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.f4458a = MetricRepo.getRepo().getMetric(this.o, this.p);
    }
}
