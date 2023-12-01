package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/model/DimensionSet.class */
public class DimensionSet implements Parcelable {
    public static final Parcelable.Creator<DimensionSet> CREATOR = new Parcelable.Creator<DimensionSet>() { // from class: com.alibaba.mtl.appmonitor.model.DimensionSet.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DimensionSet[] newArray(int i) {
            return new DimensionSet[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DimensionSet createFromParcel(Parcel parcel) {
            return DimensionSet.a(parcel);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private List<Dimension> f4471c = new ArrayList(3);

    private DimensionSet() {
    }

    static DimensionSet a(Parcel parcel) {
        DimensionSet create = create();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(DimensionSet.class.getClassLoader());
            if (readParcelableArray != null) {
                if (create.f4471c == null) {
                    create.f4471c = new ArrayList();
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readParcelableArray.length) {
                        break;
                    }
                    if (readParcelableArray[i2] == null || !(readParcelableArray[i2] instanceof Dimension)) {
                        i.a("DimensionSet", "parcelables[i]:", readParcelableArray[i2]);
                    } else {
                        create.f4471c.add((Dimension) readParcelableArray[i2]);
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th) {
            i.a("DimensionSet", "[readFromParcel]", th);
        }
        return create;
    }

    public static DimensionSet create() {
        return new DimensionSet();
    }

    public static DimensionSet create(Collection<String> collection) {
        DimensionSet dimensionSet = new DimensionSet();
        if (collection != null) {
            for (String str : collection) {
                dimensionSet.addDimension(new Dimension(str));
            }
        }
        return dimensionSet;
    }

    public static DimensionSet create(String[] strArr) {
        DimensionSet dimensionSet = new DimensionSet();
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                dimensionSet.addDimension(new Dimension(strArr[i2]));
                i = i2 + 1;
            }
        }
        return dimensionSet;
    }

    public DimensionSet addDimension(Dimension dimension) {
        if (this.f4471c.contains(dimension)) {
            return this;
        }
        this.f4471c.add(dimension);
        return this;
    }

    public DimensionSet addDimension(String str) {
        return addDimension(new Dimension(str));
    }

    public DimensionSet addDimension(String str, String str2) {
        return addDimension(new Dimension(str, str2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Dimension getDimension(String str) {
        for (Dimension dimension : this.f4471c) {
            if (dimension.getName().equals(str)) {
                return dimension;
            }
        }
        return null;
    }

    public List<Dimension> getDimensions() {
        return this.f4471c;
    }

    public void setConstantValue(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.f4471c;
        if (list == null || dimensionValueSet == null) {
            return;
        }
        for (Dimension dimension : list) {
            if (dimension.getConstantValue() != null && dimensionValueSet.getValue(dimension.getName()) == null) {
                dimensionValueSet.setValue(dimension.getName(), dimension.getConstantValue());
            }
        }
    }

    public boolean valid(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.f4471c;
        if (list != null) {
            if (dimensionValueSet != null) {
                for (Dimension dimension : list) {
                    if (!dimensionValueSet.containValue(dimension.getName())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<Dimension> list = this.f4471c;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Dimension[] dimensionArr = null;
                if (array != null) {
                    Dimension[] dimensionArr2 = new Dimension[array.length];
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        dimensionArr = dimensionArr2;
                        if (i3 >= array.length) {
                            break;
                        }
                        dimensionArr2[i3] = (Dimension) array[i3];
                        i2 = i3 + 1;
                    }
                }
                parcel.writeParcelableArray(dimensionArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
