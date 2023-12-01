package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/j.class */
public final class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>() { // from class: com.anythink.expressad.exoplayer.g.b.j.1
        private static j a(Parcel parcel) {
            return new j(parcel);
        }

        private static j[] a(int i) {
            return new j[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ j[] newArray(int i) {
            return new j[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f7360a = "PRIV";
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f7361c;

    j(Parcel parcel) {
        super(f7360a);
        this.b = parcel.readString();
        this.f7361c = parcel.createByteArray();
    }

    public j(String str, byte[] bArr) {
        super(f7360a);
        this.b = str;
        this.f7361c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return af.a((Object) this.b, (Object) jVar.b) && Arrays.equals(this.f7361c, jVar.f7361c);
    }

    public final int hashCode() {
        String str = this.b;
        return (((str != null ? str.hashCode() : 0) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + Arrays.hashCode(this.f7361c);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.g + ": owner=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.f7361c);
    }
}
