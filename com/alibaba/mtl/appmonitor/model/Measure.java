package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/Measure.class */
public class Measure implements Parcelable {
    public static final Parcelable.Creator<Measure> CREATOR = new Parcelable.Creator<Measure>() { // from class: com.alibaba.mtl.appmonitor.model.Measure.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Measure[] newArray(int i) {
            return new Measure[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Measure createFromParcel(Parcel parcel) {
            return Measure.a(parcel);
        }
    };
    protected Double a;
    protected Double b;
    protected Double c;
    protected String name;

    public Measure(String str) {
        this(str, Double.valueOf(0.0d));
    }

    public Measure(String str, Double d) {
        this(str, d, Double.valueOf(0.0d), null);
    }

    public Measure(String str, Double d, Double d2, Double d3) {
        double d4 = 0.0d;
        Double valueOf = Double.valueOf(0.0d);
        this.a = valueOf;
        this.b = valueOf;
        this.c = valueOf;
        this.a = d2;
        this.b = d3;
        this.name = str;
        this.c = Double.valueOf(d != null ? d.doubleValue() : d4);
    }

    static Measure a(Parcel parcel) {
        try {
            Double valueOf = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            return new Measure(parcel.readString(), !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null, !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null, valueOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
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
            Measure measure = (Measure) obj;
            String str = this.name;
            return str == null ? measure.name == null : str.equals(measure.name);
        }
        return false;
    }

    public Double getConstantValue() {
        return this.c;
    }

    public Double getMax() {
        return this.b;
    }

    public Double getMin() {
        return this.a;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setConstantValue(Double d) {
        this.c = d;
    }

    public void setMax(Double d) {
        this.b = d;
    }

    public void setMin(Double d) {
        this.a = d;
    }

    public void setRange(Double d, Double d2) {
        this.a = d;
        this.b = d2;
    }

    public boolean valid(MeasureValue measureValue) {
        Double valueOf = Double.valueOf(measureValue.getValue());
        if (valueOf != null) {
            if (this.a == null || valueOf.doubleValue() >= this.a.doubleValue()) {
                return this.b == null || valueOf.doubleValue() <= this.b.doubleValue();
            }
            return false;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.b == null ? 0 : 1);
            if (this.b != null) {
                parcel.writeDouble(this.b.doubleValue());
            }
            parcel.writeInt(this.a == null ? 0 : 1);
            if (this.a != null) {
                parcel.writeDouble(this.a.doubleValue());
            }
            parcel.writeString(this.name);
            parcel.writeInt(this.c == null ? 0 : 1);
            if (this.c != null) {
                parcel.writeDouble(this.c.doubleValue());
            }
        } catch (Throwable th) {
        }
    }
}
