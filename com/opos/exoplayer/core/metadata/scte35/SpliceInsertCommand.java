package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.b;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/SpliceInsertCommand.class */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.SpliceInsertCommand.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f11855a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11856c;
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

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/SpliceInsertCommand$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11857a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11858c;

        private a(int i, long j, long j2) {
            this.f11857a = i;
            this.b = j;
            this.f11858c = j2;
        }

        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void a(Parcel parcel) {
            parcel.writeInt(this.f11857a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.f11858c);
        }
    }

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.f11855a = j;
        this.b = z;
        this.f11856c = z2;
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

    private SpliceInsertCommand(Parcel parcel) {
        this.f11855a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.f11856c = parcel.readByte() == 1;
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
            arrayList.add(a.b(parcel));
            i = i2 + 1;
        }
        this.h = Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceInsertCommand a(m mVar, long j, s sVar) {
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int i;
        int i2;
        int i3;
        boolean z4;
        long m = mVar.m();
        boolean z5 = (mVar.g() & 128) != 0;
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
            int g = mVar.g();
            z = (g & 128) != 0;
            z4 = (g & 64) != 0;
            boolean z6 = (g & 32) != 0;
            z2 = (g & 16) != 0;
            j2 = (!z4 || z2) ? -9223372036854775807L : TimeSignalCommand.a(mVar, j);
            if (!z4) {
                int g2 = mVar.g();
                emptyList = new ArrayList(g2);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= g2) {
                        break;
                    }
                    int g3 = mVar.g();
                    long a2 = !z2 ? TimeSignalCommand.a(mVar, j) : b.b;
                    emptyList.add(new a(g3, a2, sVar.b(a2)));
                    i4 = i5 + 1;
                }
            }
            if (z6) {
                long g4 = mVar.g();
                z3 = (128 & g4) != 0;
                j3 = ((((g4 & 1) << 32) | mVar.m()) * 1000) / 90;
            } else {
                z3 = false;
                j3 = -9223372036854775807L;
            }
            i = mVar.h();
            i2 = mVar.g();
            i3 = mVar.g();
        }
        return new SpliceInsertCommand(m, z5, z, z4, z2, j2, sVar.b(j2), emptyList, z3, j3, i, i2, i3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11855a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11856c ? (byte) 1 : (byte) 0);
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
            this.h.get(i3).a(parcel);
            i2 = i3 + 1;
        }
    }
}
