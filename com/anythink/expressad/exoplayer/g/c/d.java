package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/d.class */
public final class d extends b {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.anythink.expressad.exoplayer.g.c.d.1
        private static d a(Parcel parcel) {
            return new d(parcel, (byte) 0);
        }

        private static d[] a(int i) {
            return new d[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ d createFromParcel(Parcel parcel) {
            return new d(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ d[] newArray(int i) {
            return new d[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f7368a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7369c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List<a> h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f7370a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public final long f7371c;

        private a(int i, long j, long j2) {
            this.f7370a = i;
            this.b = j;
            this.f7371c = j2;
        }

        /* synthetic */ a(int i, long j, long j2, byte b) {
            this(i, j, j2);
        }

        public static a a(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        private void b(Parcel parcel) {
            parcel.writeInt(this.f7370a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.f7371c);
        }
    }

    private d(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.f7368a = j;
        this.b = z;
        this.f7369c = z2;
        this.d = z3;
        this.e = z4;
        this.f = j2;
        this.g = j3;
        this.h = Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j4;
        this.k = i;
        this.l = i2;
        this.m = i3;
    }

    private d(Parcel parcel) {
        this.f7368a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.f7369c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.e = parcel.readByte() == 1;
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                break;
            }
            arrayList.add(a.a(parcel));
            i = i2 + 1;
        }
        this.h = Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    /* synthetic */ d(Parcel parcel, byte b) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(s sVar, long j, ac acVar) {
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int i;
        int i2;
        int i3;
        boolean z4;
        long h = sVar.h();
        boolean z5 = (sVar.d() & 128) != 0;
        ArrayList emptyList = Collections.emptyList();
        if (z5) {
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            i = 0;
            i2 = 0;
            i3 = 0;
            z4 = false;
        } else {
            int d = sVar.d();
            z = (d & 128) != 0;
            z4 = (d & 64) != 0;
            boolean z6 = (d & 32) != 0;
            z2 = (d & 16) != 0;
            j2 = (!z4 || z2) ? -9223372036854775807L : g.a(sVar, j);
            if (!z4) {
                int d2 = sVar.d();
                emptyList = new ArrayList(d2);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= d2) {
                        break;
                    }
                    int d3 = sVar.d();
                    long a2 = !z2 ? g.a(sVar, j) : com.anythink.expressad.exoplayer.b.b;
                    emptyList.add(new a(d3, a2, acVar.a(a2), (byte) 0));
                    i4 = i5 + 1;
                }
            }
            if (z6) {
                long d4 = sVar.d();
                z3 = (128 & d4) != 0;
                j3 = ((((d4 & 1) << 32) | sVar.h()) * 1000) / 90;
            } else {
                z3 = false;
                j3 = -9223372036854775807L;
            }
            i = sVar.e();
            i2 = sVar.d();
            i3 = sVar.d();
        }
        return new d(h, z5, z, z4, z2, j2, acVar.a(j2), emptyList, z3, j3, i, i2, i3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7368a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7369c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        int size = this.h.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
                parcel.writeLong(this.j);
                parcel.writeInt(this.k);
                parcel.writeInt(this.l);
                parcel.writeInt(this.m);
                return;
            }
            a aVar = this.h.get(i3);
            parcel.writeInt(aVar.f7370a);
            parcel.writeLong(aVar.b);
            parcel.writeLong(aVar.f7371c);
            i2 = i3 + 1;
        }
    }
}
