package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/MeasureValueSet.class */
public class MeasureValueSet implements Parcelable, b {
    public static final Parcelable.Creator<MeasureValueSet> CREATOR = new Parcelable.Creator<MeasureValueSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureValueSet.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MeasureValueSet[] newArray(int i) {
            return new MeasureValueSet[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MeasureValueSet createFromParcel(Parcel parcel) {
            return MeasureValueSet.a(parcel);
        }
    };
    private Map<String, MeasureValue> map = new LinkedHashMap();

    static MeasureValueSet a(Parcel parcel) {
        try {
            MeasureValueSet create = create();
            try {
                create.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
                return create;
            } catch (Throwable th) {
                return create;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private static Double a(String str) {
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MeasureValueSet create() {
        return (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }

    @Deprecated
    public static MeasureValueSet create(int i) {
        return (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MeasureValueSet create(Map<String, Double> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            for (String str : map.keySet()) {
                Double d = map.get(str);
                if (d != null) {
                    measureValueSet.map.put(str, a.a().a(MeasureValue.class, d));
                }
            }
        }
        return measureValueSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MeasureValueSet fromStringMap(Map<String, String> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Double a2 = a(entry.getValue());
                if (a2 != null) {
                    measureValueSet.map.put(entry.getKey(), a.a().a(MeasureValue.class, a2));
                }
            }
        }
        return measureValueSet;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        for (MeasureValue measureValue : this.map.values()) {
            a.a().a((a) measureValue);
        }
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, MeasureValue> getMap() {
        return this.map;
    }

    public MeasureValue getValue(String str) {
        return this.map.get(str);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void merge(MeasureValueSet measureValueSet) {
        for (String str : this.map.keySet()) {
            this.map.get(str).merge(measureValueSet.getValue(str));
        }
    }

    public void setMap(Map<String, MeasureValue> map) {
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MeasureValueSet setValue(String str, double d) {
        this.map.put(str, a.a().a(MeasureValue.class, Double.valueOf(d)));
        return this;
    }

    public void setValue(String str, MeasureValue measureValue) {
        this.map.put(str, measureValue);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }
}
