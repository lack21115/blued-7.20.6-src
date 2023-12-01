package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.s;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/g.class */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.anythink.expressad.exoplayer.g.c.g.1
        private static g a(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), (byte) 0);
        }

        private static g[] a(int i) {
            return new g[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ g[] newArray(int i) {
            return new g[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f7376a;
    public final long b;

    private g(long j, long j2) {
        this.f7376a = j;
        this.b = j2;
    }

    /* synthetic */ g(long j, long j2, byte b) {
        this(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(s sVar, long j) {
        long d = sVar.d();
        return (128 & d) != 0 ? 8589934591L & ((((d & 1) << 32) | sVar.h()) + j) : com.anythink.expressad.exoplayer.b.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a(s sVar, long j, ac acVar) {
        long a2 = a(sVar, j);
        return new g(a2, acVar.a(a2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7376a);
        parcel.writeLong(this.b);
    }
}
