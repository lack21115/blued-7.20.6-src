package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/f.class */
public final class f extends com.anythink.expressad.exoplayer.g.c.b {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.anythink.expressad.exoplayer.g.c.f.1
        private static f a(Parcel parcel) {
            return new f(parcel, (byte) 0);
        }

        private static f[] a(int i) {
            return new f[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ f createFromParcel(Parcel parcel) {
            return new f(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ f[] newArray(int i) {
            return new f[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f7372a;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f7373a;
        public final long b;

        private a(int i, long j) {
            this.f7373a = i;
            this.b = j;
        }

        /* synthetic */ a(int i, long j, byte b) {
            this(i, j);
        }

        static /* synthetic */ a a(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        static /* synthetic */ void a(a aVar, Parcel parcel) {
            parcel.writeInt(aVar.f7373a);
            parcel.writeLong(aVar.b);
        }

        private static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        private void c(Parcel parcel) {
            parcel.writeInt(this.f7373a);
            parcel.writeLong(this.b);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/f$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f7374a;
        public final boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f7375c;
        public final boolean d;
        public final long e;
        public final List<a> f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        private b(long j, boolean z, boolean z2, boolean z3, List<a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.f7374a = j;
            this.b = z;
            this.f7375c = z2;
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
            this.f7374a = parcel.readLong();
            this.b = parcel.readByte() == 1;
            this.f7375c = parcel.readByte() == 1;
            this.d = parcel.readByte() == 1;
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
            this.f = Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        static /* synthetic */ b a(Parcel parcel) {
            return new b(parcel);
        }

        static /* synthetic */ b a(s sVar) {
            long j;
            boolean z;
            int i;
            int i2;
            int i3;
            long j2;
            long h = sVar.h();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = (sVar.d() & 128) != 0;
            ArrayList arrayList = new ArrayList();
            if (z4) {
                j = -9223372036854775807L;
                z3 = false;
                z = false;
                i = 0;
                i2 = 0;
                i3 = 0;
                j2 = -9223372036854775807L;
            } else {
                int d = sVar.d();
                z2 = (d & 128) != 0;
                z = (d & 64) != 0;
                boolean z5 = (d & 32) != 0;
                j = z ? sVar.h() : -9223372036854775807L;
                if (!z) {
                    int d2 = sVar.d();
                    arrayList = new ArrayList(d2);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= d2) {
                            break;
                        }
                        arrayList.add(new a(sVar.d(), sVar.h(), (byte) 0));
                        i4 = i5 + 1;
                    }
                }
                if (z5) {
                    long d3 = sVar.d();
                    z3 = (128 & d3) != 0;
                    j2 = ((((d3 & 1) << 32) | sVar.h()) * 1000) / 90;
                } else {
                    j2 = -9223372036854775807L;
                }
                i = sVar.e();
                i2 = sVar.d();
                i3 = sVar.d();
            }
            return new b(h, z4, z2, z, arrayList, j, z3, j2, i, i2, i3);
        }

        private static /* synthetic */ void a(b bVar, Parcel parcel) {
            parcel.writeLong(bVar.f7374a);
            parcel.writeByte(bVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.f7375c ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.d ? (byte) 1 : (byte) 0);
            int size = bVar.f.size();
            parcel.writeInt(size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    parcel.writeLong(bVar.e);
                    parcel.writeByte(bVar.g ? (byte) 1 : (byte) 0);
                    parcel.writeLong(bVar.h);
                    parcel.writeInt(bVar.i);
                    parcel.writeInt(bVar.j);
                    parcel.writeInt(bVar.k);
                    return;
                }
                a.a(bVar.f.get(i2), parcel);
                i = i2 + 1;
            }
        }

        private static b b(s sVar) {
            long j;
            boolean z;
            int i;
            int i2;
            int i3;
            long j2;
            long h = sVar.h();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = (sVar.d() & 128) != 0;
            ArrayList arrayList = new ArrayList();
            if (z4) {
                j = -9223372036854775807L;
                z3 = false;
                z = false;
                i = 0;
                i2 = 0;
                i3 = 0;
                j2 = -9223372036854775807L;
            } else {
                int d = sVar.d();
                z2 = (d & 128) != 0;
                z = (d & 64) != 0;
                boolean z5 = (d & 32) != 0;
                j = z ? sVar.h() : -9223372036854775807L;
                if (!z) {
                    int d2 = sVar.d();
                    arrayList = new ArrayList(d2);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= d2) {
                            break;
                        }
                        arrayList.add(new a(sVar.d(), sVar.h(), (byte) 0));
                        i4 = i5 + 1;
                    }
                }
                if (z5) {
                    long d3 = sVar.d();
                    z3 = (128 & d3) != 0;
                    j2 = ((((d3 & 1) << 32) | sVar.h()) * 1000) / 90;
                } else {
                    j2 = -9223372036854775807L;
                }
                i = sVar.e();
                i2 = sVar.d();
                i3 = sVar.d();
            }
            return new b(h, z4, z2, z, arrayList, j, z3, j2, i, i2, i3);
        }

        private void b(Parcel parcel) {
            parcel.writeLong(this.f7374a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f7375c ? (byte) 1 : (byte) 0);
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
                a.a(this.f.get(i2), parcel);
                i = i2 + 1;
            }
        }

        private static b c(Parcel parcel) {
            return new b(parcel);
        }
    }

    private f(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                this.f7372a = Collections.unmodifiableList(arrayList);
                return;
            } else {
                arrayList.add(b.a(parcel));
                i = i2 + 1;
            }
        }
    }

    /* synthetic */ f(Parcel parcel, byte b2) {
        this(parcel);
    }

    private f(List<b> list) {
        this.f7372a = Collections.unmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a(s sVar) {
        int d = sVar.d();
        ArrayList arrayList = new ArrayList(d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= d) {
                return new f(arrayList);
            }
            arrayList.add(b.a(sVar));
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int size = this.f7372a.size();
        parcel.writeInt(size);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            b bVar = this.f7372a.get(i3);
            parcel.writeLong(bVar.f7374a);
            parcel.writeByte(bVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.f7375c ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.d ? (byte) 1 : (byte) 0);
            int size2 = bVar.f.size();
            parcel.writeInt(size2);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < size2) {
                    a.a(bVar.f.get(i5), parcel);
                    i4 = i5 + 1;
                }
            }
            parcel.writeLong(bVar.e);
            parcel.writeByte(bVar.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(bVar.h);
            parcel.writeInt(bVar.i);
            parcel.writeInt(bVar.j);
            parcel.writeInt(bVar.k);
            i2 = i3 + 1;
        }
    }
}
