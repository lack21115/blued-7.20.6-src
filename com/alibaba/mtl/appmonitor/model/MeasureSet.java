package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/MeasureSet.class */
public class MeasureSet implements Parcelable {
    public static final Parcelable.Creator<MeasureSet> CREATOR = new Parcelable.Creator<MeasureSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureSet.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MeasureSet[] newArray(int i) {
            return new MeasureSet[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MeasureSet createFromParcel(Parcel parcel) {
            return MeasureSet.a(parcel);
        }
    };
    private List<Measure> d = new ArrayList(3);

    private MeasureSet() {
    }

    static MeasureSet a(Parcel parcel) {
        MeasureSet create = create();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(MeasureSet.class.getClassLoader());
            if (readParcelableArray != null) {
                ArrayList arrayList = new ArrayList(readParcelableArray.length);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readParcelableArray.length) {
                        create.d = arrayList;
                        return create;
                    }
                    arrayList.add((Measure) readParcelableArray[i2]);
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }

    public static MeasureSet create() {
        return new MeasureSet();
    }

    public static MeasureSet create(Collection<String> collection) {
        MeasureSet measureSet = new MeasureSet();
        if (collection != null) {
            for (String str : collection) {
                measureSet.addMeasure(str);
            }
        }
        return measureSet;
    }

    public static MeasureSet create(String[] strArr) {
        MeasureSet measureSet = new MeasureSet();
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                measureSet.addMeasure(strArr[i2]);
                i = i2 + 1;
            }
        }
        return measureSet;
    }

    public MeasureSet addMeasure(Measure measure) {
        if (!this.d.contains(measure)) {
            this.d.add(measure);
        }
        return this;
    }

    public MeasureSet addMeasure(String str) {
        return addMeasure(new Measure(str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Measure getMeasure(String str) {
        for (Measure measure : this.d) {
            if (measure.getName().equals(str)) {
                return measure;
            }
        }
        return null;
    }

    public List<Measure> getMeasures() {
        return this.d;
    }

    public void setConstantValue(MeasureValueSet measureValueSet) {
        List<Measure> list = this.d;
        if (list == null || measureValueSet == null) {
            return;
        }
        for (Measure measure : list) {
            if (measure.getConstantValue() != null && measureValueSet.getValue(measure.getName()) == null) {
                measureValueSet.setValue(measure.getName(), measure.getConstantValue().doubleValue());
            }
        }
    }

    public void upateMeasure(Measure measure) {
        int size = this.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (TextUtils.equals(this.d.get(i2).name, measure.name)) {
                this.d.get(i2).setMax(measure.getMax());
                this.d.get(i2).setMin(measure.getMin());
                this.d.get(i2).setConstantValue(measure.getConstantValue());
            }
            i = i2 + 1;
        }
    }

    public void upateMeasures(List<Measure> list) {
        int size = this.d.size();
        int size2 = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < size2) {
                    if (TextUtils.equals(this.d.get(i2).name, list.get(i4).name)) {
                        this.d.get(i2).setMax(list.get(i4).getMax());
                        this.d.get(i2).setMin(list.get(i4).getMin());
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public boolean valid(MeasureValueSet measureValueSet) {
        if (this.d == null) {
            return true;
        }
        if (measureValueSet == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return true;
            }
            Measure measure = this.d.get(i2);
            if (measure != null) {
                String name = measure.getName();
                if (!measureValueSet.containValue(name) || !measure.valid(measureValueSet.getValue(name))) {
                    return false;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<Measure> list = this.d;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Measure[] measureArr = null;
                if (array != null) {
                    Measure[] measureArr2 = new Measure[array.length];
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        measureArr = measureArr2;
                        if (i3 >= array.length) {
                            break;
                        }
                        measureArr2[i3] = (Measure) array[i3];
                        i2 = i3 + 1;
                    }
                }
                parcel.writeParcelableArray(measureArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
