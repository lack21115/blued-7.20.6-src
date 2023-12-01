package com.alibaba.mtl.appmonitor.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/MetricRepo.class */
public class MetricRepo {
    private static MetricRepo a;
    public List<Metric> metrics;

    private MetricRepo(int i) {
        this.metrics = new ArrayList(i);
    }

    public static MetricRepo getRepo() {
        if (a == null) {
            a = new MetricRepo(3);
        }
        return a;
    }

    public static MetricRepo getRepo(int i) {
        return new MetricRepo(i);
    }

    public void add(Metric metric) {
        if (this.metrics.contains(metric)) {
            return;
        }
        this.metrics.add(metric);
    }

    public Metric getMetric(String str, String str2) {
        List<Metric> list;
        if (str == null || str2 == null || (list = this.metrics) == null) {
            return null;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            Metric metric = this.metrics.get(i2);
            if (metric != null && metric.getModule().equals(str) && metric.getMonitorPoint().equals(str2)) {
                return metric;
            }
            i = i2 + 1;
        }
    }

    public boolean remove(Metric metric) {
        if (this.metrics.contains(metric)) {
            return this.metrics.remove(metric);
        }
        return true;
    }
}
