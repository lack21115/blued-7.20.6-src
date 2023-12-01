package com.anythink.expressad.exoplayer.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/ae.class */
public final class ae implements Parcelable {
    public static final Parcelable.Creator<ae> CREATOR = new Parcelable.Creator<ae>() { // from class: com.anythink.expressad.exoplayer.h.ae.1
        private static ae a(Parcel parcel) {
            return new ae(parcel);
        }

        private static ae[] a(int i) {
            return new ae[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ae createFromParcel(Parcel parcel) {
            return new ae(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ae[] newArray(int i) {
            return new ae[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f4578a;
    private final com.anythink.expressad.exoplayer.m[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f4579c;

    ae(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f4578a = readInt;
        this.b = new com.anythink.expressad.exoplayer.m[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f4578a) {
                return;
            }
            this.b[i2] = (com.anythink.expressad.exoplayer.m) parcel.readParcelable(com.anythink.expressad.exoplayer.m.class.getClassLoader());
            i = i2 + 1;
        }
    }

    public ae(com.anythink.expressad.exoplayer.m... mVarArr) {
        com.anythink.expressad.exoplayer.k.a.b(true);
        this.b = mVarArr;
        this.f4578a = 1;
    }

    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            com.anythink.expressad.exoplayer.m[] mVarArr = this.b;
            if (i2 >= mVarArr.length) {
                return -1;
            }
            if (mVar == mVarArr[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public final com.anythink.expressad.exoplayer.m a(int i) {
        return this.b[i];
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
        ae aeVar = (ae) obj;
        return this.f4578a == aeVar.f4578a && Arrays.equals(this.b, aeVar.b);
    }

    public final int hashCode() {
        if (this.f4579c == 0) {
            this.f4579c = Arrays.hashCode(this.b) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
        }
        return this.f4579c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4578a);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f4578a) {
                return;
            }
            parcel.writeParcelable(this.b[i3], 0);
            i2 = i3 + 1;
        }
    }
}
