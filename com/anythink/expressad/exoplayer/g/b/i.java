package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/i.class */
public final class i extends h {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() { // from class: com.anythink.expressad.exoplayer.g.b.i.1
        private static i a(Parcel parcel) {
            return new i(parcel);
        }

        private static i[] a(int i) {
            return new i[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ i[] newArray(int i) {
            return new i[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f7358a = "----";
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7359c;
    public final String d;

    i(Parcel parcel) {
        super(f7358a);
        this.b = (String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
        this.f7359c = (String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
        this.d = (String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
    }

    public i(String str, String str2, String str3) {
        super(f7358a);
        this.b = str;
        this.f7359c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return af.a((Object) this.f7359c, (Object) iVar.f7359c) && af.a((Object) this.b, (Object) iVar.b) && af.a((Object) this.d, (Object) iVar.d);
    }

    public final int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f7359c;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + hashCode2) * 31) + i;
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.g + ": domain=" + this.b + ", description=" + this.f7359c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }
}
