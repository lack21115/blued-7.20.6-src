package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/DimensionValueSet.class */
public class DimensionValueSet implements Parcelable, b {
    public static final Parcelable.Creator<DimensionValueSet> CREATOR = new Parcelable.Creator<DimensionValueSet>() { // from class: com.alibaba.mtl.appmonitor.model.DimensionValueSet.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DimensionValueSet[] newArray(int i) {
            return new DimensionValueSet[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DimensionValueSet createFromParcel(Parcel parcel) {
            return DimensionValueSet.a(parcel);
        }
    };
    protected Map<String, String> map;

    @Deprecated
    public DimensionValueSet() {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    static DimensionValueSet a(Parcel parcel) {
        DimensionValueSet dimensionValueSet;
        DimensionValueSet create;
        try {
            create = create();
        } catch (Throwable th) {
            th = th;
            dimensionValueSet = null;
        }
        try {
            create.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
            return create;
        } catch (Throwable th2) {
            dimensionValueSet = create;
            th = th2;
            th.printStackTrace();
            return dimensionValueSet;
        }
    }

    public static DimensionValueSet create() {
        return (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
    }

    @Deprecated
    public static DimensionValueSet create(int i) {
        return (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
    }

    public static DimensionValueSet fromStringMap(Map<String, String> map) {
        DimensionValueSet dimensionValueSet = (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dimensionValueSet.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : com.igexin.push.core.b.l);
        }
        return dimensionValueSet;
    }

    public DimensionValueSet addValues(DimensionValueSet dimensionValueSet) {
        Map<String, String> map;
        if (dimensionValueSet != null && (map = dimensionValueSet.getMap()) != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : com.igexin.push.core.b.l);
            }
        }
        return this;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DimensionValueSet dimensionValueSet = (DimensionValueSet) obj;
            Map<String, String> map = this.map;
            return map == null ? dimensionValueSet.map == null : map.equals(dimensionValueSet.map);
        }
        return false;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, String> getMap() {
        return this.map;
    }

    public String getValue(String str) {
        return this.map.get(str);
    }

    public int hashCode() {
        Map<String, String> map = this.map;
        return 31 + (map == null ? 0 : map.hashCode());
    }

    public void setMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : com.igexin.push.core.b.l);
        }
    }

    public DimensionValueSet setValue(String str, String str2) {
        Map<String, String> map = this.map;
        if (str2 == null) {
            str2 = com.igexin.push.core.b.l;
        }
        map.put(str, str2);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }
}
