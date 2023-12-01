package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/Entry.class */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Entry[] newArray(int i) {
            return new Entry[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f22132a;

    public Entry() {
        this.f22132a = 0.0f;
    }

    public Entry(float f, float f2, Object obj) {
        super(f2, obj);
        this.f22132a = 0.0f;
        this.f22132a = f;
    }

    protected Entry(Parcel parcel) {
        this.f22132a = 0.0f;
        this.f22132a = parcel.readFloat();
        a(parcel.readFloat());
        if (parcel.readInt() == 1) {
            a(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float i() {
        return this.f22132a;
    }

    public String toString() {
        return "Entry, x: " + this.f22132a + " y: " + b();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f22132a);
        parcel.writeFloat(b());
        if (h() == null) {
            parcel.writeInt(0);
        } else if (!(h() instanceof Parcelable)) {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) h(), i);
        }
    }
}
