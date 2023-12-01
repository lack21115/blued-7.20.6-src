package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/SpliceScheduleCommand.class */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.SpliceScheduleCommand.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f11859a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/SpliceScheduleCommand$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11860a;
        public final long b;

        private a(int i, long j) {
            this.f11860a = i;
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeInt(this.f11860a);
            parcel.writeLong(this.b);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/SpliceScheduleCommand$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f11861a;
        public final boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f11862c;
        public final boolean d;
        public final long e;
        public final List<a> f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        private b(long j, boolean z, boolean z2, boolean z3, List<a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.f11861a = j;
            this.b = z;
            this.f11862c = z2;
            this.d = z3;
            this.f = Collections.unmodifiableList(list);
            this.e = j2;
            this.g = z4;
            this.h = j3;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        private b(Parcel parcel) {
            this.f11861a = parcel.readLong();
            this.b = parcel.readByte() == 1;
            this.f11862c = parcel.readByte() == 1;
            this.d = parcel.readByte() == 1;
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
            this.f = Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(m mVar) {
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i;
            int i2;
            int i3;
            boolean z3;
            long m = mVar.m();
            boolean z4 = (mVar.g() & 128) != 0;
            ArrayList arrayList = new ArrayList();
            if (z4) {
                z = false;
                j = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                i3 = 0;
                z3 = false;
            } else {
                int g = mVar.g();
                z = (g & 128) != 0;
                z3 = (g & 64) != 0;
                boolean z5 = (g & 32) != 0;
                j = z3 ? mVar.m() : -9223372036854775807L;
                if (!z3) {
                    int g2 = mVar.g();
                    arrayList = new ArrayList(g2);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= g2) {
                            break;
                        }
                        arrayList.add(new a(mVar.g(), mVar.m()));
                        i4 = i5 + 1;
                    }
                }
                if (z5) {
                    long g3 = mVar.g();
                    z2 = (128 & g3) != 0;
                    j2 = ((((g3 & 1) << 32) | mVar.m()) * 1000) / 90;
                } else {
                    z2 = false;
                    j2 = -9223372036854775807L;
                }
                i = mVar.h();
                i2 = mVar.g();
                i3 = mVar.g();
            }
            return new b(m, z4, z, z3, arrayList, j, z2, j2, i, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Parcel parcel) {
            parcel.writeLong(this.f11861a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f11862c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            int size = this.f.size();
            parcel.writeInt(size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    parcel.writeLong(this.e);
                    parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
                    parcel.writeLong(this.h);
                    parcel.writeInt(this.i);
                    parcel.writeInt(this.j);
                    parcel.writeInt(this.k);
                    return;
                }
                this.f.get(i2).c(parcel);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel);
        }
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                this.f11859a = Collections.unmodifiableList(arrayList);
                return;
            } else {
                arrayList.add(b.c(parcel));
                i = i2 + 1;
            }
        }
    }

    private SpliceScheduleCommand(List<b> list) {
        this.f11859a = Collections.unmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceScheduleCommand a(m mVar) {
        int g = mVar.g();
        ArrayList arrayList = new ArrayList(g);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= g) {
                return new SpliceScheduleCommand(arrayList);
            }
            arrayList.add(b.b(mVar));
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f11859a.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            this.f11859a.get(i3).b(parcel);
            i2 = i3 + 1;
        }
    }
}
