package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.model.MetricValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.model.LogField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f4454a;

    /* renamed from: a  reason: collision with other field name */
    private AtomicInteger f19a = new AtomicInteger(0);
    private AtomicInteger b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f4455c = new AtomicInteger(0);
    private Map<UTDimensionValueSet, MetricValueSet> h = new ConcurrentHashMap();
    private Map<String, c> g = new ConcurrentHashMap();

    private e() {
    }

    private d a(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends d> cls) {
        Integer eventId;
        MetricValueSet metricValueSet;
        if (com.alibaba.mtl.appmonitor.f.b.c(str) && com.alibaba.mtl.appmonitor.f.b.c(str2) && (eventId = uTDimensionValueSet.getEventId()) != null) {
            synchronized (this.h) {
                MetricValueSet metricValueSet2 = this.h.get(uTDimensionValueSet);
                metricValueSet = metricValueSet2;
                if (metricValueSet2 == null) {
                    metricValueSet = (MetricValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MetricValueSet.class, new Object[0]);
                    this.h.put(uTDimensionValueSet, metricValueSet);
                }
            }
            return metricValueSet.getEvent(eventId, str, str2, str3, cls);
        }
        return null;
    }

    public static e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f4454a == null) {
                    f4454a = new e();
                }
                eVar = f4454a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    private UTDimensionValueSet a(int i) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(UTDimensionValueSet.class, new Object[0]);
        uTDimensionValueSet.setValue(LogField.ACCESS.toString(), com.alibaba.mtl.log.a.b());
        uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), com.alibaba.mtl.log.a.c());
        uTDimensionValueSet.setValue(LogField.USERID.toString(), com.alibaba.mtl.log.a.d());
        uTDimensionValueSet.setValue(LogField.USERNICK.toString(), com.alibaba.mtl.log.a.e());
        uTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(i));
        return uTDimensionValueSet;
    }

    private String a(String str, String str2) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            return metric.getTransactionId();
        }
        return null;
    }

    private void a(f fVar, AtomicInteger atomicInteger) {
        int incrementAndGet = atomicInteger.incrementAndGet();
        i.a("EventRepo", fVar.toString(), " EVENT size:", String.valueOf(incrementAndGet));
        if (incrementAndGet >= fVar.b()) {
            i.a("EventRepo", fVar.toString(), " event size exceed trigger count.");
            atomicInteger.set(0);
            m2137a(fVar.m2139a());
        }
    }

    private void b(String str, String str2) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            metric.resetTransactionId();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<UTDimensionValueSet, List<d>> m2136a(int i) {
        HashMap hashMap = new HashMap();
        synchronized (this.h) {
            ArrayList arrayList = new ArrayList(this.h.keySet());
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < size) {
                    UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) arrayList.get(i3);
                    if (uTDimensionValueSet != null && uTDimensionValueSet.getEventId().intValue() == i) {
                        hashMap.put(uTDimensionValueSet, this.h.get(uTDimensionValueSet).getEvents());
                        this.h.remove(uTDimensionValueSet);
                    }
                    i2 = i3 + 1;
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2137a(int i) {
        final Map<UTDimensionValueSet, List<d>> m2136a = m2136a(i);
        r.a().b(new Runnable() { // from class: com.alibaba.mtl.appmonitor.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.alibaba.mtl.appmonitor.f.c.b(m2136a);
            }
        });
    }

    public void a(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric == null) {
            i.a("EventRepo", "metric is null");
            return;
        }
        if (metric.getDimensionSet() != null) {
            metric.getDimensionSet().setConstantValue(dimensionValueSet);
        }
        if (metric.getMeasureSet() != null) {
            metric.getMeasureSet().setConstantValue(measureValueSet);
        }
        UTDimensionValueSet a2 = a(i);
        ((g) a(a2, str, str2, (String) null, g.class)).a(dimensionValueSet, measureValueSet);
        if (com.alibaba.mtl.log.a.a.g()) {
            g gVar = (g) com.alibaba.mtl.appmonitor.c.a.a().a(g.class, Integer.valueOf(i), str, str2);
            gVar.a(dimensionValueSet, measureValueSet);
            com.alibaba.mtl.appmonitor.f.c.a(a2, gVar);
        }
        a(f.a(i), this.f4455c);
    }

    public void a(int i, String str, String str2, String str3) {
        UTDimensionValueSet a2 = a(i);
        ((a) a(a2, str, str2, str3, a.class)).f();
        if (com.alibaba.mtl.log.a.a.g()) {
            a aVar = (a) com.alibaba.mtl.appmonitor.c.a.a().a(a.class, Integer.valueOf(i), str, str2, str3);
            aVar.f();
            com.alibaba.mtl.appmonitor.f.c.a(a2, aVar);
        }
        a(f.a(i), this.f19a);
    }

    public void a(int i, String str, String str2, String str3, double d) {
        UTDimensionValueSet a2 = a(i);
        ((b) a(a2, str, str2, str3, b.class)).a(d);
        if (com.alibaba.mtl.log.a.a.g()) {
            b bVar = (b) com.alibaba.mtl.appmonitor.c.a.a().a(b.class, Integer.valueOf(i), str, str2, str3);
            bVar.a(d);
            com.alibaba.mtl.appmonitor.f.c.a(a2, bVar);
        }
        a(f.a(i), this.b);
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        UTDimensionValueSet a2 = a(i);
        a aVar = (a) a(a2, str, str2, str3, a.class);
        aVar.g();
        aVar.a(str4, str5);
        if (com.alibaba.mtl.log.a.a.g()) {
            a aVar2 = (a) com.alibaba.mtl.appmonitor.c.a.a().a(a.class, Integer.valueOf(i), str, str2, str3);
            aVar2.g();
            aVar2.a(str4, str5);
            com.alibaba.mtl.appmonitor.f.c.a(a2, aVar2);
        }
        a(f.a(i), this.f19a);
    }

    public void a(Integer num, String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (a2 != null) {
            a(a2, num, str, str2, str3);
        }
    }

    public void a(String str, Integer num, String str2, String str3, DimensionValueSet dimensionValueSet) {
        c cVar;
        synchronized (c.class) {
            try {
                c cVar2 = this.g.get(str);
                cVar = cVar2;
                if (cVar2 == null) {
                    cVar = (c) com.alibaba.mtl.appmonitor.c.a.a().a(c.class, num, str2, str3);
                    this.g.put(str, cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        cVar.a(dimensionValueSet);
    }

    public void a(String str, Integer num, String str2, String str3, String str4) {
        c cVar;
        Metric metric = MetricRepo.getRepo().getMetric(str2, str3);
        if (metric == null || metric.getMeasureSet() == null || metric.getMeasureSet().getMeasure(str4) == null) {
            return;
        }
        synchronized (c.class) {
            try {
                c cVar2 = this.g.get(str);
                cVar = cVar2;
                if (cVar2 == null) {
                    cVar = (c) com.alibaba.mtl.appmonitor.c.a.a().a(c.class, num, str2, str3);
                    this.g.put(str, cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        cVar.a(str4);
    }

    public void a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (a2 != null) {
            a(a2, str3, true);
        }
    }

    public void a(String str, String str2, boolean z) {
        c cVar = this.g.get(str);
        if (cVar == null || !cVar.m2135a(str2)) {
            return;
        }
        this.g.remove(str);
        if (z) {
            b(cVar.o, cVar.p);
        }
        a(cVar.e, cVar.o, cVar.p, cVar.m2134a(), cVar.a());
        com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) cVar);
    }

    public void h() {
        ArrayList arrayList = new ArrayList(this.g.keySet());
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            String str = (String) arrayList.get(i2);
            c cVar = this.g.get(str);
            if (cVar != null && cVar.e()) {
                this.g.remove(str);
            }
            i = i2 + 1;
        }
    }
}
