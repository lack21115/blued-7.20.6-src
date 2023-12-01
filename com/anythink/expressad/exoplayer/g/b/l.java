package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/l.class */
public final class l extends h {
    public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>() { // from class: com.anythink.expressad.exoplayer.g.b.l.1
        private static l a(Parcel parcel) {
            return new l(parcel);
        }

        private static l[] a(int i) {
            return new l[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ l[] newArray(int i) {
            return new l[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f7363a;
    public final String b;

    l(Parcel parcel) {
        super(parcel.readString());
        this.f7363a = parcel.readString();
        this.b = parcel.readString();
    }

    public l(String str, String str2, String str3) {
        super(str);
        this.f7363a = str2;
        this.b = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.g.equals(lVar.g) && af.a((Object) this.f7363a, (Object) lVar.f7363a) && af.a((Object) this.b, (Object) lVar.b);
    }

    public final int hashCode() {
        int hashCode = this.g.hashCode();
        String str = this.f7363a;
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
        return this.g + ": url=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.f7363a);
        parcel.writeString(this.b);
    }
}
