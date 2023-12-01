package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/MeasureValue.class */
public class MeasureValue implements Parcelable, b {
    public static final Parcelable.Creator<MeasureValue> CREATOR = new Parcelable.Creator<MeasureValue>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureValue.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MeasureValue[] newArray(int i) {
            return new MeasureValue[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MeasureValue createFromParcel(Parcel parcel) {
            return MeasureValue.a(parcel);
        }
    };
    private Double d;
    private double e;
    private boolean n;

    @Deprecated
    public MeasureValue() {
    }

    @Deprecated
    public MeasureValue(double d) {
        this.e = d;
    }

    @Deprecated
    public MeasureValue(double d, double d2) {
        this.d = Double.valueOf(d2);
        this.e = d;
        this.n = false;
    }

    static MeasureValue a(Parcel parcel) {
        MeasureValue measureValue = null;
        try {
            boolean z = parcel.readInt() != 0;
            double readDouble = parcel.readDouble();
            double readDouble2 = parcel.readDouble();
            MeasureValue create = create();
            create.n = z;
            create.d = Double.valueOf(readDouble);
            measureValue = create;
            create.e = readDouble2;
            return create;
        } catch (Throwable th) {
            th.printStackTrace();
            return measureValue;
        }
    }

    public static MeasureValue create() {
        return (MeasureValue) a.a().a(MeasureValue.class, new Object[0]);
    }

    public static MeasureValue create(double d) {
        return (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf(d));
    }

    public static MeasureValue create(double d, double d2) {
        return (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf(d), Double.valueOf(d2));
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        synchronized (this) {
            this.e = 0.0d;
            this.d = null;
            this.n = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        synchronized (this) {
            if (objArr == null) {
                return;
            }
            if (objArr.length > 0) {
                this.e = ((Double) objArr[0]).doubleValue();
            }
            if (objArr.length > 1) {
                this.d = (Double) objArr[1];
                this.n = false;
            }
        }
    }

    public Double getOffset() {
        return this.d;
    }

    public double getValue() {
        return this.e;
    }

    public boolean isFinish() {
        return this.n;
    }

    public void merge(MeasureValue measureValue) {
        synchronized (this) {
            if (measureValue == null) {
                return;
            }
            try {
                this.e += measureValue.getValue();
                if (measureValue.getOffset() != null) {
                    if (this.d == null) {
                        this.d = Double.valueOf(0.0d);
                    }
                    this.d = Double.valueOf(this.d.doubleValue() + measureValue.getOffset().doubleValue());
                }
            } catch (Throwable th) {
            }
        }
    }

    public void setFinish(boolean z) {
        this.n = z;
    }

    public void setOffset(double d) {
        this.d = Double.valueOf(d);
    }

    public void setValue(double d) {
        this.e = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.n ? 1 : 0);
            parcel.writeDouble(this.d == null ? 0.0d : this.d.doubleValue());
            parcel.writeDouble(this.e);
        } catch (Throwable th) {
        }
    }
}
