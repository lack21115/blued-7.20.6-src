package com.anythink.expressad.exoplayer.g;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/a.class */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.a.1
        private static a a(Parcel parcel) {
            return new a(parcel);
        }

        private static a[] a() {
            return new a[0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i) {
            return new a[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0129a[] f7340a;

    /* renamed from: com.anythink.expressad.exoplayer.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/a$a.class */
    public interface InterfaceC0129a extends Parcelable {
    }

    a(Parcel parcel) {
        this.f7340a = new InterfaceC0129a[parcel.readInt()];
        int i = 0;
        while (true) {
            int i2 = i;
            InterfaceC0129a[] interfaceC0129aArr = this.f7340a;
            if (i2 >= interfaceC0129aArr.length) {
                return;
            }
            interfaceC0129aArr[i2] = (InterfaceC0129a) parcel.readParcelable(InterfaceC0129a.class.getClassLoader());
            i = i2 + 1;
        }
    }

    public a(List<? extends InterfaceC0129a> list) {
        InterfaceC0129a[] interfaceC0129aArr = new InterfaceC0129a[list.size()];
        this.f7340a = interfaceC0129aArr;
        list.toArray(interfaceC0129aArr);
    }

    public a(InterfaceC0129a... interfaceC0129aArr) {
        this.f7340a = interfaceC0129aArr;
    }

    public final int a() {
        return this.f7340a.length;
    }

    public final InterfaceC0129a a(int i) {
        return this.f7340a[i];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f7340a, ((a) obj).f7340a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f7340a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7340a.length);
        InterfaceC0129a[] interfaceC0129aArr = this.f7340a;
        int length = interfaceC0129aArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            parcel.writeParcelable(interfaceC0129aArr[i3], 0);
            i2 = i3 + 1;
        }
    }
}
