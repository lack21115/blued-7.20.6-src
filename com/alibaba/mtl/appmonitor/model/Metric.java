package com.alibaba.mtl.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.List;
import java.util.UUID;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/Metric.class */
public class Metric implements b {
    private DimensionSet b;

    /* renamed from: b  reason: collision with other field name */
    private MeasureSet f25b;
    private boolean g;
    private String o;
    private String p;
    private String r;
    private String s;
    private String z;

    @Deprecated
    public Metric() {
        this.z = null;
    }

    public Metric(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.z = null;
        this.o = str;
        this.p = str2;
        this.b = dimensionSet;
        this.f25b = measureSet;
        this.s = null;
        this.g = z;
    }

    private Measure a(String str, List<Measure> list) {
        if (list != null) {
            for (Measure measure : list) {
                if (TextUtils.equals(str, measure.name)) {
                    return measure;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        this.o = null;
        this.p = null;
        this.s = null;
        this.g = false;
        this.b = null;
        this.f25b = null;
        this.r = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Metric metric = (Metric) obj;
            String str = this.s;
            if (str == null) {
                if (metric.s != null) {
                    return false;
                }
            } else if (!str.equals(metric.s)) {
                return false;
            }
            String str2 = this.o;
            if (str2 == null) {
                if (metric.o != null) {
                    return false;
                }
            } else if (!str2.equals(metric.o)) {
                return false;
            }
            String str3 = this.p;
            return str3 == null ? metric.p == null : str3.equals(metric.p);
        }
        return false;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        this.o = (String) objArr[0];
        this.p = (String) objArr[1];
        if (objArr.length > 2) {
            this.s = (String) objArr[2];
        }
    }

    public DimensionSet getDimensionSet() {
        return this.b;
    }

    public MeasureSet getMeasureSet() {
        return this.f25b;
    }

    public String getModule() {
        return this.o;
    }

    public String getMonitorPoint() {
        return this.p;
    }

    public String getTransactionId() {
        String str;
        synchronized (this) {
            if (this.r == null) {
                this.r = UUID.randomUUID().toString() + "$" + this.o + "$" + this.p;
            }
            str = this.r;
        }
        return str;
    }

    public int hashCode() {
        String str = this.s;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.o;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.p;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((hashCode + 31) * 31) + hashCode2) * 31) + i;
    }

    public boolean isCommitDetail() {
        synchronized (this) {
            if ("1".equalsIgnoreCase(this.z)) {
                return true;
            }
            if ("0".equalsIgnoreCase(this.z)) {
                return false;
            }
            return this.g;
        }
    }

    public void resetTransactionId() {
        this.r = null;
    }

    public void setCommitDetailFromConfig(String str) {
        synchronized (this) {
            this.z = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean valid(com.alibaba.mtl.appmonitor.model.DimensionValueSet r5, com.alibaba.mtl.appmonitor.model.MeasureValueSet r6) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.model.Metric.valid(com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet):boolean");
    }
}
