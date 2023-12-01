package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/clean/CleanType.class */
public class CleanType extends ox implements Parcelable {
    public static final Parcelable.Creator<CleanType> CREATOR = new Parcelable.Creator<CleanType>() { // from class: com.ss.android.download.api.clean.CleanType.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public CleanType createFromParcel(Parcel parcel) {
            return new CleanType(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mb */
        public CleanType[] newArray(int i) {
            return new CleanType[i];
        }
    };
    private int h;
    private Map<String, hj> u;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/clean/CleanType$Type.class */
    public @interface Type {
        public static final int APK = -1;
        public static final int CACHE = -3;
        public static final int LOG = -2;
        public static final int OTHERS = -5;
        public static final int REMAIN = -4;
    }

    public CleanType() {
        this.u = new HashMap();
    }

    CleanType(Parcel parcel) {
        super(parcel);
        this.u = new HashMap();
        this.h = parcel.readInt();
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.u.put(parcel.readString(), (hj) parcel.readParcelable(hj.class.getClassLoader()));
            i = i2 + 1;
        }
    }

    public int getType() {
        return this.h;
    }

    @Override // com.ss.android.download.api.clean.ox, com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.h);
        parcel.writeInt(this.u.size());
        for (Map.Entry<String, hj> entry : this.u.entrySet()) {
            try {
                parcel.writeString(entry.getKey());
                parcel.writeParcelable(entry.getValue(), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
