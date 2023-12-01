package com.anythink.expressad.exoplayer.h;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/af.class */
public final class af implements Parcelable {
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    private final ae[] f7420c;
    private int d;

    /* renamed from: a  reason: collision with root package name */
    public static final af f7419a = new af(new ae[0]);
    public static final Parcelable.Creator<af> CREATOR = new Parcelable.Creator<af>() { // from class: com.anythink.expressad.exoplayer.h.af.1
        private static af a(Parcel parcel) {
            return new af(parcel);
        }

        private static af[] a(int i) {
            return new af[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ af createFromParcel(Parcel parcel) {
            return new af(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ af[] newArray(int i) {
            return new af[i];
        }
    };

    af(Parcel parcel) {
        int readInt = parcel.readInt();
        this.b = readInt;
        this.f7420c = new ae[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                return;
            }
            this.f7420c[i2] = (ae) parcel.readParcelable(ae.class.getClassLoader());
            i = i2 + 1;
        }
    }

    public af(ae... aeVarArr) {
        this.f7420c = aeVarArr;
        this.b = aeVarArr.length;
    }

    private boolean a() {
        return this.b == 0;
    }

    public final int a(ae aeVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b) {
                return -1;
            }
            if (this.f7420c[i2] == aeVar) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public final ae a(int i) {
        return this.f7420c[i];
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
        af afVar = (af) obj;
        return this.b == afVar.b && Arrays.equals(this.f7420c, afVar.f7420c);
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = Arrays.hashCode(this.f7420c);
        }
        return this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b) {
                return;
            }
            parcel.writeParcelable(this.f7420c[i3], 0);
            i2 = i3 + 1;
        }
    }
}
