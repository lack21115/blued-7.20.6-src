package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.e.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/c.class */
public class c extends d {
    private static final Long a = 300000L;

    /* renamed from: a  reason: collision with other field name */
    private Metric f16a;
    private DimensionValueSet b;

    /* renamed from: b  reason: collision with other field name */
    private MeasureValueSet f17b;

    /* renamed from: b  reason: collision with other field name */
    private Long f18b;
    private Map<String, MeasureValue> f;

    public DimensionValueSet a() {
        return this.b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public MeasureValueSet m8577a() {
        return this.f17b;
    }

    public void a(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.b;
        if (dimensionValueSet2 == null) {
            this.b = dimensionValueSet;
        } else {
            dimensionValueSet2.addValues(dimensionValueSet);
        }
    }

    public void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f.isEmpty()) {
            this.f18b = Long.valueOf(currentTimeMillis);
        }
        this.f.put(str, (MeasureValue) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValue.class, Double.valueOf(currentTimeMillis), Double.valueOf(currentTimeMillis - this.f18b.longValue())));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8578a(String str) {
        MeasureValue measureValue = this.f.get(str);
        if (measureValue != null) {
            double currentTimeMillis = System.currentTimeMillis();
            i.a("DurationEvent", "statEvent consumeTime. module:", this.o, " monitorPoint:", this.p, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - measureValue.getValue()));
            measureValue.setValue(currentTimeMillis - measureValue.getValue());
            measureValue.setFinish(true);
            this.f17b.setValue(str, measureValue);
            return this.f16a.getMeasureSet().valid(this.f17b);
        }
        return false;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        super.clean();
        this.f16a = null;
        this.f18b = null;
        for (MeasureValue measureValue : this.f.values()) {
            com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) measureValue);
        }
        this.f.clear();
        if (this.f17b != null) {
            com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) this.f17b);
            this.f17b = null;
        }
        if (this.b != null) {
            com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) this.b);
            this.b = null;
        }
    }

    public boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.f16a.getMeasureSet().getMeasures();
        if (measures == null) {
            return false;
        }
        int size = measures.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            Measure measure = measures.get(i2);
            if (measure != null) {
                double doubleValue = measure.getMax() != null ? measure.getMax().doubleValue() : a.longValue();
                MeasureValue measureValue = this.f.get(measure.getName());
                if (measureValue != null && !measureValue.isFinish() && currentTimeMillis - measureValue.getValue() > doubleValue) {
                    return true;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.f == null) {
            this.f = new HashMap();
        }
        Metric metric = MetricRepo.getRepo().getMetric(this.o, this.p);
        this.f16a = metric;
        if (metric.getDimensionSet() != null) {
            this.b = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            this.f16a.getDimensionSet().setConstantValue(this.b);
        }
        this.f17b = (MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0]);
    }
}
