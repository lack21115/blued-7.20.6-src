package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/MetricValueSet.class */
public class MetricValueSet implements b {
    private Map<Metric, d> l = Collections.synchronizedMap(new HashMap());

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        for (d dVar : this.l.values()) {
            a.a().a((a) dVar);
        }
        this.l.clear();
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        if (this.l == null) {
            this.l = Collections.synchronizedMap(new HashMap());
        }
    }

    public d getEvent(Integer num, String str, String str2, String str3, Class<? extends d> cls) {
        Metric metric;
        boolean z;
        d dVar;
        if (num.intValue() == f.STAT.m8582a()) {
            metric = MetricRepo.getRepo().getMetric(str, str2);
            z = false;
        } else {
            metric = (Metric) a.a().a(Metric.class, str, str2, str3);
            z = true;
        }
        d dVar2 = null;
        if (metric != null) {
            if (this.l.containsKey(metric)) {
                dVar = this.l.get(metric);
            } else {
                synchronized (MetricValueSet.class) {
                    try {
                        dVar = (d) a.a().a(cls, num, str, str2, str3);
                        this.l.put(metric, dVar);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                z = false;
            }
            dVar2 = dVar;
            if (z) {
                a.a().a((a) metric);
                return dVar;
            }
        }
        return dVar2;
    }

    public List<d> getEvents() {
        return new ArrayList(this.l.values());
    }
}
