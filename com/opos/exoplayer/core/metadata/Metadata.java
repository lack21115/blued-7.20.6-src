package com.opos.exoplayer.core.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/Metadata.class */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() { // from class: com.opos.exoplayer.core.metadata.Metadata.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Metadata[] newArray(int i) {
            return new Metadata[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Entry[] f11830a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/Metadata$Entry.class */
    public interface Entry extends Parcelable {
    }

    Metadata(Parcel parcel) {
        this.f11830a = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            int i2 = i;
            Entry[] entryArr = this.f11830a;
            if (i2 >= entryArr.length) {
                return;
            }
            entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i = i2 + 1;
        }
    }

    public Metadata(List<? extends Entry> list) {
        if (list == null) {
            this.f11830a = new Entry[0];
            return;
        }
        Entry[] entryArr = new Entry[list.size()];
        this.f11830a = entryArr;
        list.toArray(entryArr);
    }

    public Metadata(Entry... entryArr) {
        this.f11830a = entryArr == null ? new Entry[0] : entryArr;
    }

    public int a() {
        return this.f11830a.length;
    }

    public Entry a(int i) {
        return this.f11830a[i];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f11830a, ((Metadata) obj).f11830a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f11830a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11830a.length);
        Entry[] entryArr = this.f11830a;
        int length = entryArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            parcel.writeParcelable(entryArr[i3], 0);
            i2 = i3 + 1;
        }
    }
}
