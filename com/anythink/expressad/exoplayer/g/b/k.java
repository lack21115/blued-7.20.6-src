package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/k.class */
public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() { // from class: com.anythink.expressad.exoplayer.g.b.k.1
        private static k a(Parcel parcel) {
            return new k(parcel);
        }

        private static k[] a(int i) {
            return new k[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ k[] newArray(int i) {
            return new k[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f7362a;
    public final String b;

    k(Parcel parcel) {
        super(parcel.readString());
        this.f7362a = parcel.readString();
        this.b = parcel.readString();
    }

    public k(String str, String str2, String str3) {
        super(str);
        this.f7362a = str2;
        this.b = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.g.equals(kVar.g) && af.a((Object) this.f7362a, (Object) kVar.f7362a) && af.a((Object) this.b, (Object) kVar.b);
    }

    public final int hashCode() {
        int hashCode = this.g.hashCode();
        String str = this.f7362a;
        int i = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + hashCode2) * 31) + i;
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.g + ": value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.f7362a);
        parcel.writeString(this.b);
    }
}
