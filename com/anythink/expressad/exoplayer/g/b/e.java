package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/e.class */
public final class e extends h {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.anythink.expressad.exoplayer.g.b.e.1
        private static e a(Parcel parcel) {
            return new e(parcel);
        }

        private static e[] a(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ e[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f4511a = "COMM";
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4512c;
    public final String d;

    e(Parcel parcel) {
        super(f4511a);
        this.b = parcel.readString();
        this.f4512c = parcel.readString();
        this.d = parcel.readString();
    }

    public e(String str, String str2, String str3) {
        super(f4511a);
        this.b = str;
        this.f4512c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return af.a((Object) this.f4512c, (Object) eVar.f4512c) && af.a((Object) this.b, (Object) eVar.b) && af.a((Object) this.d, (Object) eVar.d);
    }

    public final int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f4512c;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + hashCode2) * 31) + i;
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.g + ": language=" + this.b + ", description=" + this.f4512c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }
}
