package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/f.class */
public final class f extends h {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.anythink.expressad.exoplayer.g.b.f.1
        private static f a(Parcel parcel) {
            return new f(parcel);
        }

        private static f[] a(int i) {
            return new f[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ f[] newArray(int i) {
            return new f[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f7352a = "GEOB";
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7353c;
    public final String d;
    public final byte[] e;

    f(Parcel parcel) {
        super(f7352a);
        this.b = parcel.readString();
        this.f7353c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.createByteArray();
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super(f7352a);
        this.b = str;
        this.f7353c = str2;
        this.d = str3;
        this.e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return af.a((Object) this.b, (Object) fVar.b) && af.a((Object) this.f7353c, (Object) fVar.f7353c) && af.a((Object) this.d, (Object) fVar.d) && Arrays.equals(this.e, fVar.e);
    }

    public final int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f7353c;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + hashCode2) * 31) + i) * 31) + Arrays.hashCode(this.e);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.g + ": mimeType=" + this.b + ", filename=" + this.f7353c + ", description=" + this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.f7353c);
        parcel.writeString(this.d);
        parcel.writeByteArray(this.e);
    }
}
