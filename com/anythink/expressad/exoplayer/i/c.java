package com.anythink.expressad.exoplayer.i;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.anythink.expressad.exoplayer.aa;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.i.a;
import com.anythink.expressad.exoplayer.i.e;
import com.anythink.expressad.exoplayer.i.f;
import com.anythink.expressad.exoplayer.m;
import dalvik.bytecode.Opcodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/c.class */
public final class c extends com.anythink.expressad.exoplayer.i.e {

    /* renamed from: a  reason: collision with root package name */
    private static final float f7527a = 0.98f;
    private static final int[] b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    private static final int f7528c = 1000;
    private final f.a d;
    private final AtomicReference<C0136c> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f7529a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final String f7530c;

        public a(int i, int i2, String str) {
            this.f7529a = i;
            this.b = i2;
            this.f7530c = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7529a == aVar.f7529a && this.b == aVar.b && TextUtils.equals(this.f7530c, aVar.f7530c);
        }

        public final int hashCode() {
            int i = this.f7529a;
            int i2 = this.b;
            String str = this.f7530c;
            return (((i * 31) + i2) * 31) + (str != null ? str.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/c$b.class */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        private final C0136c f7531a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7532c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public b(m mVar, C0136c c0136c, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public final int compareTo(b bVar) {
            int a2;
            int i = this.b;
            int i2 = bVar.b;
            if (i != i2) {
                return c.a(i, i2);
            }
            int i3 = this.f7532c;
            int i4 = bVar.f7532c;
            if (i3 != i4) {
                return c.a(i3, i4);
            }
            int i5 = this.d;
            int i6 = bVar.d;
            if (i5 != i6) {
                return c.a(i5, i6);
            }
            if (this.f7531a.m) {
                return c.a(bVar.g, this.g);
            }
            int i7 = 1;
            if (this.b != 1) {
                i7 = -1;
            }
            int i8 = this.e;
            int i9 = bVar.e;
            if (i8 != i9) {
                a2 = c.a(i8, i9);
            } else {
                int i10 = this.f;
                int i11 = bVar.f;
                a2 = i10 != i11 ? c.a(i10, i11) : c.a(this.g, bVar.g);
            }
            return i7 * a2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.f7532c == bVar.f7532c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g;
        }

        public final int hashCode() {
            return (((((((((this.b * 31) + this.f7532c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.i.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/c$c.class */
    public static final class C0136c implements Parcelable {
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final String f7534c;
        public final boolean d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final int q;
        private final SparseArray<Map<af, e>> r;
        private final SparseBooleanArray s;

        /* renamed from: a  reason: collision with root package name */
        public static final C0136c f7533a = new C0136c();
        public static final Parcelable.Creator<C0136c> CREATOR = new Parcelable.Creator<C0136c>() { // from class: com.anythink.expressad.exoplayer.i.c.c.1
            private static C0136c a(Parcel parcel) {
                return new C0136c(parcel);
            }

            private static C0136c[] a(int i) {
                return new C0136c[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ C0136c createFromParcel(Parcel parcel) {
                return new C0136c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ C0136c[] newArray(int i) {
                return new C0136c[i];
            }
        };

        private C0136c() {
            this(new SparseArray(), new SparseBooleanArray(), null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
        }

        C0136c(Parcel parcel) {
            this.r = a(parcel);
            this.s = parcel.readSparseBooleanArray();
            this.b = parcel.readString();
            this.f7534c = parcel.readString();
            this.d = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.e = parcel.readInt();
            this.m = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.n = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.o = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.p = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.q = parcel.readInt();
        }

        C0136c(SparseArray<Map<af, e>> sparseArray, SparseBooleanArray sparseBooleanArray, String str, String str2, boolean z, int i, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, boolean z5, boolean z6, int i5, int i6, boolean z7, int i7) {
            this.r = sparseArray;
            this.s = sparseBooleanArray;
            this.b = com.anythink.expressad.exoplayer.k.af.b(str);
            this.f7534c = com.anythink.expressad.exoplayer.k.af.b(str2);
            this.d = z;
            this.e = i;
            this.m = z2;
            this.n = z3;
            this.o = z4;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.i = z5;
            this.p = z6;
            this.j = i5;
            this.k = i6;
            this.l = z7;
            this.q = i7;
        }

        private static SparseArray<Map<af, e>> a(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<af, e>> sparseArray = new SparseArray<>(readInt);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return sparseArray;
                }
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < readInt3) {
                        hashMap.put((af) parcel.readParcelable(af.class.getClassLoader()), (e) parcel.readParcelable(e.class.getClassLoader()));
                        i3 = i4 + 1;
                    }
                }
                sparseArray.put(readInt2, hashMap);
                i = i2 + 1;
            }
        }

        private d a() {
            return new d(this, (byte) 0);
        }

        private static void a(Parcel parcel, SparseArray<Map<af, e>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                int keyAt = sparseArray.keyAt(i2);
                Map<af, e> valueAt = sparseArray.valueAt(i2);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry<af, e> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
                i = i2 + 1;
            }
        }

        private static boolean a(SparseArray<Map<af, e>> sparseArray, SparseArray<Map<af, e>> sparseArray2) {
            boolean z;
            Map.Entry<af, e> next;
            af key;
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return true;
                }
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                if (indexOfKey < 0) {
                    return false;
                }
                Map<af, e> valueAt = sparseArray.valueAt(i2);
                Map<af, e> valueAt2 = sparseArray2.valueAt(indexOfKey);
                if (valueAt2.size() == valueAt.size()) {
                    Iterator<Map.Entry<af, e>> it = valueAt.entrySet().iterator();
                    do {
                        z = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        next = it.next();
                        key = next.getKey();
                        if (!valueAt2.containsKey(key)) {
                            break;
                        }
                    } while (com.anythink.expressad.exoplayer.k.af.a(next.getValue(), valueAt2.get(key)));
                }
                z = false;
                if (!z) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return true;
                }
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean a(java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> r4, java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> r5) {
            /*
                r0 = r4
                int r0 = r0.size()
                r6 = r0
                r0 = r5
                int r0 = r0.size()
                r1 = r6
                if (r0 == r1) goto L13
                r0 = 0
                return r0
            L13:
                r0 = r4
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
                r4 = r0
            L1f:
                r0 = r4
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L5e
                r0 = r4
                java.lang.Object r0 = r0.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                r7 = r0
                r0 = r7
                java.lang.Object r0 = r0.getKey()
                com.anythink.expressad.exoplayer.h.af r0 = (com.anythink.expressad.exoplayer.h.af) r0
                r8 = r0
                r0 = r5
                r1 = r8
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L5c
                r0 = r7
                java.lang.Object r0 = r0.getValue()
                r1 = r5
                r2 = r8
                java.lang.Object r1 = r1.get(r2)
                boolean r0 = com.anythink.expressad.exoplayer.k.af.a(r0, r1)
                if (r0 != 0) goto L1f
            L5c:
                r0 = 0
                return r0
            L5e:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.C0136c.a(java.util.Map, java.util.Map):boolean");
        }

        public final boolean a(int i) {
            return this.s.get(i);
        }

        public final boolean a(int i, af afVar) {
            Map<af, e> map = this.r.get(i);
            return map != null && map.containsKey(afVar);
        }

        public final e b(int i, af afVar) {
            Map<af, e> map = this.r.get(i);
            if (map != null) {
                return map.get(afVar);
            }
            return null;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01ea A[LOOP:0: B:61:0x014a->B:80:0x01ea, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0143 A[EDGE_INSN: B:88:0x0143->B:59:0x0143 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean equals(java.lang.Object r5) {
            /*
                Method dump skipped, instructions count: 507
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.C0136c.equals(java.lang.Object):boolean");
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public final int hashCode() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            SparseArray<Map<af, e>> sparseArray = this.r;
            int size = sparseArray.size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    parcel.writeSparseBooleanArray(this.s);
                    parcel.writeString(this.b);
                    parcel.writeString(this.f7534c);
                    com.anythink.expressad.exoplayer.k.af.a(parcel, this.d);
                    parcel.writeInt(this.e);
                    com.anythink.expressad.exoplayer.k.af.a(parcel, this.m);
                    com.anythink.expressad.exoplayer.k.af.a(parcel, this.n);
                    com.anythink.expressad.exoplayer.k.af.a(parcel, this.o);
                    parcel.writeInt(this.f);
                    parcel.writeInt(this.g);
                    parcel.writeInt(this.h);
                    com.anythink.expressad.exoplayer.k.af.a(parcel, this.i);
                    com.anythink.expressad.exoplayer.k.af.a(parcel, this.p);
                    parcel.writeInt(this.j);
                    parcel.writeInt(this.k);
                    com.anythink.expressad.exoplayer.k.af.a(parcel, this.l);
                    parcel.writeInt(this.q);
                    return;
                }
                int keyAt = sparseArray.keyAt(i3);
                Map<af, e> valueAt = sparseArray.valueAt(i3);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry<af, e> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/c$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Map<af, e>> f7535a;
        private final SparseBooleanArray b;

        /* renamed from: c  reason: collision with root package name */
        private String f7536c;
        private String d;
        private boolean e;
        private int f;
        private boolean g;
        private boolean h;
        private boolean i;
        private int j;
        private int k;
        private int l;
        private boolean m;
        private boolean n;
        private int o;
        private int p;
        private boolean q;
        private int r;

        public d() {
            this(C0136c.f7533a);
        }

        private d(C0136c c0136c) {
            this.f7535a = a(c0136c.r);
            this.b = c0136c.s.m1030clone();
            this.f7536c = c0136c.b;
            this.d = c0136c.f7534c;
            this.e = c0136c.d;
            this.f = c0136c.e;
            this.g = c0136c.m;
            this.h = c0136c.n;
            this.i = c0136c.o;
            this.j = c0136c.f;
            this.k = c0136c.g;
            this.l = c0136c.h;
            this.m = c0136c.i;
            this.n = c0136c.p;
            this.o = c0136c.j;
            this.p = c0136c.k;
            this.q = c0136c.l;
            this.r = c0136c.q;
        }

        /* synthetic */ d(C0136c c0136c, byte b) {
            this(c0136c);
        }

        private static SparseArray<Map<af, e>> a(SparseArray<Map<af, e>> sparseArray) {
            SparseArray<Map<af, e>> sparseArray2 = new SparseArray<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sparseArray.size()) {
                    return sparseArray2;
                }
                sparseArray2.put(sparseArray.keyAt(i2), new HashMap(sparseArray.valueAt(i2)));
                i = i2 + 1;
            }
        }

        private d a(int i, int i2) {
            this.j = i;
            this.k = i2;
            return this;
        }

        private d a(int i, int i2, boolean z) {
            this.o = i;
            this.p = i2;
            this.q = z;
            return this;
        }

        private d a(Context context, boolean z) {
            Point a2 = com.anythink.expressad.exoplayer.k.af.a(context);
            return a(a2.x, a2.y, z);
        }

        private d a(String str) {
            this.f7536c = str;
            return this;
        }

        private d a(boolean z) {
            this.e = z;
            return this;
        }

        private d b(String str) {
            this.d = str;
            return this;
        }

        private d b(boolean z) {
            this.g = z;
            return this;
        }

        private d c() {
            return a(Opcodes.OP_NEW_ARRAY_JUMBO, 719);
        }

        private d c(int i) {
            this.f = i;
            return this;
        }

        private d c(boolean z) {
            this.h = z;
            return this;
        }

        private d d() {
            return a(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        private d d(int i) {
            this.l = i;
            return this;
        }

        private d d(boolean z) {
            this.i = z;
            return this;
        }

        private d e() {
            return a(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        private d e(boolean z) {
            this.m = z;
            return this;
        }

        private d f(boolean z) {
            this.n = z;
            return this;
        }

        public final d a() {
            if (this.f7535a.size() == 0) {
                return this;
            }
            this.f7535a.clear();
            return this;
        }

        public final d a(int i) {
            Map<af, e> map = this.f7535a.get(i);
            if (map != null) {
                if (map.isEmpty()) {
                    return this;
                }
                this.f7535a.remove(i);
            }
            return this;
        }

        public final d a(int i, af afVar) {
            Map<af, e> map = this.f7535a.get(i);
            if (map != null) {
                if (!map.containsKey(afVar)) {
                    return this;
                }
                map.remove(afVar);
                if (map.isEmpty()) {
                    this.f7535a.remove(i);
                }
            }
            return this;
        }

        public final d a(int i, af afVar, e eVar) {
            Map<af, e> map = this.f7535a.get(i);
            HashMap hashMap = map;
            if (map == null) {
                hashMap = new HashMap();
                this.f7535a.put(i, hashMap);
            }
            if (hashMap.containsKey(afVar) && com.anythink.expressad.exoplayer.k.af.a(hashMap.get(afVar), eVar)) {
                return this;
            }
            hashMap.put(afVar, eVar);
            return this;
        }

        public final d a(int i, boolean z) {
            if (this.b.get(i) == z) {
                return this;
            }
            if (z) {
                this.b.put(i, true);
                return this;
            }
            this.b.delete(i);
            return this;
        }

        public final C0136c b() {
            return new C0136c(this.f7535a, this.b, this.f7536c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
        }

        public final d b(int i) {
            if (this.r != i) {
                this.r = i;
            }
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/c$e.class */
    public static final class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.anythink.expressad.exoplayer.i.c.e.1
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
        public final int f7537a;
        public final int[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7538c;

        private e(int i, int... iArr) {
            this.f7537a = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.b = copyOf;
            this.f7538c = iArr.length;
            Arrays.sort(copyOf);
        }

        e(Parcel parcel) {
            this.f7537a = parcel.readInt();
            int readByte = parcel.readByte();
            this.f7538c = readByte;
            int[] iArr = new int[readByte];
            this.b = iArr;
            parcel.readIntArray(iArr);
        }

        private boolean a(int i) {
            int[] iArr = this.b;
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                if (iArr[i3] == i) {
                    return true;
                }
                i2 = i3 + 1;
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f7537a == eVar.f7537a && Arrays.equals(this.b, eVar.b);
        }

        public final int hashCode() {
            return (this.f7537a * 31) + Arrays.hashCode(this.b);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f7537a);
            parcel.writeInt(this.b.length);
            parcel.writeIntArray(this.b);
        }
    }

    public c() {
        this((f.a) null);
    }

    private c(f.a aVar) {
        this.d = aVar;
        this.e = new AtomicReference<>(C0136c.f7533a);
    }

    private c(com.anythink.expressad.exoplayer.j.d dVar) {
        this(new a.C0135a(dVar));
    }

    static /* synthetic */ int a(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    private static int a(ae aeVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i5 >= list.size()) {
                return i7;
            }
            int intValue = list.get(i5).intValue();
            int i8 = i7;
            if (a(aeVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i8 = i7 + 1;
            }
            i5++;
            i6 = i8;
        }
    }

    private static int a(ae aeVar, int[] iArr, a aVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= aeVar.f7417a) {
                return i3;
            }
            int i4 = i3;
            if (a(aeVar.a(i), iArr[i], aVar)) {
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r11 != r12) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Point a(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r0 = r6
            if (r0 == 0) goto L2b
            r0 = 1
            r12 = r0
            r0 = r9
            r1 = r10
            if (r0 <= r1) goto L13
            r0 = 1
            r11 = r0
            goto L16
        L13:
            r0 = 0
            r11 = r0
        L16:
            r0 = r7
            r1 = r8
            if (r0 <= r1) goto L1e
            goto L21
        L1e:
            r0 = 0
            r12 = r0
        L21:
            r0 = r11
            r1 = r12
            if (r0 == r1) goto L2b
            goto L33
        L2b:
            r0 = r8
            r11 = r0
            r0 = r7
            r8 = r0
            r0 = r11
            r7 = r0
        L33:
            r0 = r9
            r1 = r7
            int r0 = r0 * r1
            r11 = r0
            r0 = r10
            r1 = r8
            int r0 = r0 * r1
            r12 = r0
            r0 = r11
            r1 = r12
            if (r0 < r1) goto L54
            android.graphics.Point r0 = new android.graphics.Point
            r1 = r0
            r2 = r8
            r3 = r12
            r4 = r9
            int r3 = com.anythink.expressad.exoplayer.k.af.a(r3, r4)
            r1.<init>(r2, r3)
            return r0
        L54:
            android.graphics.Point r0 = new android.graphics.Point
            r1 = r0
            r2 = r11
            r3 = r10
            int r2 = com.anythink.expressad.exoplayer.k.af.a(r2, r3)
            r3 = r7
            r1.<init>(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(boolean, int, int, int, int):android.graphics.Point");
    }

    private static f a(af afVar, int[][] iArr, int i, C0136c c0136c, f.a aVar) {
        f fVar;
        String str;
        int[] a2;
        int a3;
        if (!c0136c.m && aVar != null) {
            int i2 = c0136c.o ? 24 : 16;
            boolean z = c0136c.n && (i & i2) != 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= afVar.b) {
                    break;
                }
                ae a4 = afVar.a(i4);
                int[] iArr2 = iArr[i4];
                int i5 = c0136c.f;
                int i6 = c0136c.g;
                int i7 = c0136c.h;
                int i8 = c0136c.j;
                int i9 = c0136c.k;
                boolean z2 = c0136c.l;
                if (a4.f7417a < 2) {
                    a2 = b;
                } else {
                    List<Integer> a5 = a(a4, i8, i9, z2);
                    if (a5.size() < 2) {
                        a2 = b;
                    } else {
                        if (z) {
                            str = null;
                        } else {
                            HashSet hashSet = new HashSet();
                            int i10 = 0;
                            str = null;
                            for (int i11 = 0; i11 < a5.size(); i11++) {
                                String str2 = a4.a(a5.get(i11).intValue()).h;
                                if (hashSet.add(str2) && (a3 = a(a4, iArr2, i2, str2, i5, i6, i7, a5)) > i10) {
                                    str = str2;
                                    i10 = a3;
                                }
                            }
                        }
                        b(a4, iArr2, i2, str, i5, i6, i7, a5);
                        a2 = a5.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(a5);
                    }
                }
                if (a2.length > 0) {
                    fVar = ((f.a) com.anythink.expressad.exoplayer.k.a.a(aVar)).a(a4, a2);
                    break;
                }
                i3 = i4 + 1;
            }
        }
        fVar = null;
        f fVar2 = fVar;
        if (fVar == null) {
            fVar2 = a(afVar, iArr, c0136c);
        }
        return fVar2;
    }

    private static f a(af afVar, int[][] iArr, C0136c c0136c) {
        boolean z;
        ae aeVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < afVar.b; i5++) {
            ae a2 = afVar.a(i5);
            List<Integer> a3 = a(a2, c0136c.j, c0136c.k, c0136c.l);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < a2.f7417a) {
                ae aeVar2 = aeVar;
                int i7 = i;
                int i8 = i2;
                int i9 = i3;
                int i10 = i4;
                if (a(iArr2[i6], c0136c.p)) {
                    m a4 = a2.a(i6);
                    boolean z2 = a3.contains(Integer.valueOf(i6)) && (a4.m == -1 || a4.m <= c0136c.f) && ((a4.n == -1 || a4.n <= c0136c.g) && (a4.d == -1 || a4.d <= c0136c.h));
                    if (!z2) {
                        aeVar2 = aeVar;
                        i7 = i;
                        i8 = i2;
                        i9 = i3;
                        i10 = i4;
                        if (!c0136c.i) {
                        }
                    }
                    int i11 = z2 ? 2 : 1;
                    boolean a5 = a(iArr2[i6], false);
                    int i12 = i11;
                    if (a5) {
                        i12 = i11 + 1000;
                    }
                    boolean z3 = i12 > i2;
                    if (i12 == i2) {
                        if (c0136c.m) {
                            if (b(a4.d, i4) < 0) {
                                z = true;
                                z3 = z;
                            }
                            z = false;
                            z3 = z;
                        } else {
                            int a6 = a4.a();
                            int b2 = a6 != i3 ? b(a6, i3) : b(a4.d, i4);
                            if (a5 && z2) {
                                if (b2 > 0) {
                                    z = true;
                                    z3 = z;
                                }
                                z = false;
                                z3 = z;
                            } else {
                                if (b2 < 0) {
                                    z = true;
                                    z3 = z;
                                }
                                z = false;
                                z3 = z;
                            }
                        }
                    }
                    aeVar2 = aeVar;
                    i7 = i;
                    i8 = i2;
                    i9 = i3;
                    i10 = i4;
                    if (z3) {
                        i10 = a4.d;
                        i9 = a4.a();
                        aeVar2 = a2;
                        i7 = i6;
                        i8 = i12;
                    }
                }
                i6++;
                aeVar = aeVar2;
                i = i7;
                i2 = i8;
                i3 = i9;
                i4 = i10;
            }
        }
        if (aeVar == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.i.d(aeVar, i);
    }

    private static f a(af afVar, int[][] iArr, C0136c c0136c, f.a aVar) {
        int[] iArr2;
        b bVar = null;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < afVar.b; i3++) {
            ae a2 = afVar.a(i3);
            int[] iArr3 = iArr[i3];
            int i4 = 0;
            while (i4 < a2.f7417a) {
                int i5 = i;
                b bVar2 = bVar;
                int i6 = i2;
                if (a(iArr3[i4], c0136c.p)) {
                    b bVar3 = new b(a2.a(i4), c0136c, iArr3[i4]);
                    if (bVar != null) {
                        i5 = i;
                        bVar2 = bVar;
                        i6 = i2;
                        if (bVar3.compareTo(bVar) <= 0) {
                        }
                    }
                    i5 = i3;
                    i6 = i4;
                    bVar2 = bVar3;
                }
                i4++;
                i = i5;
                bVar = bVar2;
                i2 = i6;
            }
        }
        if (i == -1) {
            return null;
        }
        ae a3 = afVar.a(i);
        if (!c0136c.m && aVar != null) {
            int[] iArr4 = iArr[i];
            boolean z = c0136c.n;
            HashSet hashSet = new HashSet();
            a aVar2 = null;
            int i7 = 0;
            int i8 = 0;
            while (i7 < a3.f7417a) {
                m a4 = a3.a(i7);
                a aVar3 = new a(a4.u, a4.v, z ? null : a4.h);
                int i9 = i8;
                a aVar4 = aVar2;
                if (hashSet.add(aVar3)) {
                    int a5 = a(a3, iArr4, aVar3);
                    i9 = i8;
                    aVar4 = aVar2;
                    if (a5 > i8) {
                        i9 = a5;
                        aVar4 = aVar3;
                    }
                }
                i7++;
                i8 = i9;
                aVar2 = aVar4;
            }
            if (i8 > 1) {
                int[] iArr5 = new int[i8];
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    iArr2 = iArr5;
                    if (i11 >= a3.f7417a) {
                        break;
                    }
                    int i12 = i10;
                    if (a(a3.a(i11), iArr4[i11], (a) com.anythink.expressad.exoplayer.k.a.a(aVar2))) {
                        iArr5[i10] = i11;
                        i12 = i10 + 1;
                    }
                    i11++;
                    i10 = i12;
                }
            } else {
                iArr2 = b;
            }
            if (iArr2.length > 0) {
                return aVar.a(a3, iArr2);
            }
        }
        return new com.anythink.expressad.exoplayer.i.d(a3, i2);
    }

    private static List<Integer> a(ae aeVar, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(aeVar.f7417a);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= aeVar.f7417a) {
                break;
            }
            arrayList.add(Integer.valueOf(i6));
            i5 = i6 + 1;
        }
        if (i != Integer.MAX_VALUE) {
            if (i2 == Integer.MAX_VALUE) {
                return arrayList;
            }
            int i7 = Integer.MAX_VALUE;
            while (true) {
                i3 = i7;
                if (i4 >= aeVar.f7417a) {
                    break;
                }
                m a2 = aeVar.a(i4);
                int i8 = i3;
                if (a2.m > 0) {
                    i8 = i3;
                    if (a2.n > 0) {
                        Point a3 = a(z, i, i2, a2.m, a2.n);
                        int i9 = a2.m * a2.n;
                        i8 = i3;
                        if (a2.m >= ((int) (a3.x * f7527a))) {
                            i8 = i3;
                            if (a2.n >= ((int) (a3.y * f7527a))) {
                                i8 = i3;
                                if (i9 < i3) {
                                    i8 = i9;
                                }
                            }
                        }
                    }
                }
                i4++;
                i7 = i8;
            }
            if (i3 != Integer.MAX_VALUE) {
                int size = arrayList.size();
                while (true) {
                    int i10 = size - 1;
                    if (i10 < 0) {
                        break;
                    }
                    int a4 = aeVar.a(((Integer) arrayList.get(i10)).intValue()).a();
                    if (a4 == -1 || a4 > i3) {
                        arrayList.remove(i10);
                    }
                    size = i10;
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    private void a(int i, af afVar, e eVar) {
        a(d().a(i, afVar, eVar));
    }

    private void a(C0136c c0136c) {
        com.anythink.expressad.exoplayer.k.a.a(c0136c);
        if (this.e.getAndSet(c0136c).equals(c0136c)) {
            return;
        }
        b();
    }

    private void a(d dVar) {
        C0136c b2 = dVar.b();
        com.anythink.expressad.exoplayer.k.a.a(b2);
        if (this.e.getAndSet(b2).equals(b2)) {
            return;
        }
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.anythink.expressad.exoplayer.i.e.a r4, int[][][] r5, com.anythink.expressad.exoplayer.aa[] r6, com.anythink.expressad.exoplayer.i.f[] r7, int r8) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(com.anythink.expressad.exoplayer.i.e$a, int[][][], com.anythink.expressad.exoplayer.aa[], com.anythink.expressad.exoplayer.i.f[], int):void");
    }

    @Deprecated
    private boolean a(int i) {
        return c().a(i);
    }

    @Deprecated
    private boolean a(int i, af afVar) {
        return c().a(i, afVar);
    }

    protected static boolean a(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    private static boolean a(m mVar) {
        return TextUtils.isEmpty(mVar.A) || a(mVar, com.anythink.expressad.exoplayer.b.f7166ar);
    }

    private static boolean a(m mVar, int i, a aVar) {
        if (a(i, false) && mVar.u == aVar.f7529a && mVar.v == aVar.b) {
            return aVar.f7530c == null || TextUtils.equals(aVar.f7530c, mVar.h);
        }
        return false;
    }

    protected static boolean a(m mVar, String str) {
        return str != null && TextUtils.equals(str, com.anythink.expressad.exoplayer.k.af.b(mVar.A));
    }

    private static boolean a(m mVar, String str, int i, int i2, int i3, int i4, int i5) {
        if (!a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str == null || com.anythink.expressad.exoplayer.k.af.a((Object) mVar.h, (Object) str)) {
            if (mVar.m == -1 || mVar.m <= i3) {
                if (mVar.n == -1 || mVar.n <= i4) {
                    return mVar.d == -1 || mVar.d <= i5;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean a(int[][] iArr, af afVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int a2 = afVar.a(fVar.f());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fVar.g()) {
                return true;
            }
            if ((iArr[a2][fVar.b(i2)] & 32) != 32) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static int[] a(ae aeVar, int[] iArr, boolean z) {
        HashSet hashSet = new HashSet();
        a aVar = null;
        int i = 0;
        int i2 = 0;
        while (i < aeVar.f7417a) {
            m a2 = aeVar.a(i);
            a aVar2 = new a(a2.u, a2.v, z ? null : a2.h);
            int i3 = i2;
            a aVar3 = aVar;
            if (hashSet.add(aVar2)) {
                int a3 = a(aeVar, iArr, aVar2);
                i3 = i2;
                aVar3 = aVar;
                if (a3 > i2) {
                    i3 = a3;
                    aVar3 = aVar2;
                }
            }
            i++;
            i2 = i3;
            aVar = aVar3;
        }
        if (i2 > 1) {
            int[] iArr2 = new int[i2];
            int i4 = 0;
            int i5 = 0;
            while (i5 < aeVar.f7417a) {
                int i6 = i4;
                if (a(aeVar.a(i5), iArr[i5], (a) com.anythink.expressad.exoplayer.k.a.a(aVar))) {
                    iArr2[i4] = i5;
                    i6 = i4 + 1;
                }
                i5++;
                i4 = i6;
            }
            return iArr2;
        }
        return b;
    }

    private static int[] a(ae aeVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        if (aeVar.f7417a < 2) {
            return b;
        }
        List<Integer> a2 = a(aeVar, i5, i6, z2);
        if (a2.size() < 2) {
            return b;
        }
        if (!z) {
            HashSet hashSet = new HashSet();
            str = null;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i7 >= a2.size()) {
                    break;
                }
                String str2 = aeVar.a(a2.get(i7).intValue()).h;
                String str3 = str;
                int i10 = i9;
                if (hashSet.add(str2)) {
                    int a3 = a(aeVar, iArr, i, str2, i2, i3, i4, a2);
                    str3 = str;
                    i10 = i9;
                    if (a3 > i9) {
                        i10 = a3;
                        str3 = str2;
                    }
                }
                i7++;
                str = str3;
                i8 = i10;
            }
        } else {
            str = null;
        }
        b(aeVar, iArr, i, str, i2, i3, i4, a2);
        return a2.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.anythink.expressad.exoplayer.i.f[] a(com.anythink.expressad.exoplayer.i.e.a r10, int[][][] r11, int[] r12, com.anythink.expressad.exoplayer.i.c.C0136c r13) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(com.anythink.expressad.exoplayer.i.e$a, int[][][], int[], com.anythink.expressad.exoplayer.i.c$c):com.anythink.expressad.exoplayer.i.f[]");
    }

    private static int b(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        } else if (i2 == -1) {
            return 1;
        } else {
            return i - i2;
        }
    }

    @Deprecated
    private e b(int i, af afVar) {
        return c().b(i, afVar);
    }

    private static f b(af afVar, int[][] iArr, int i, C0136c c0136c, f.a aVar) {
        String str;
        int[] a2;
        int a3;
        int i2 = c0136c.o ? 24 : 16;
        boolean z = c0136c.n && (i & i2) != 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= afVar.b) {
                return null;
            }
            ae a4 = afVar.a(i4);
            int[] iArr2 = iArr[i4];
            int i5 = c0136c.f;
            int i6 = c0136c.g;
            int i7 = c0136c.h;
            int i8 = c0136c.j;
            int i9 = c0136c.k;
            boolean z2 = c0136c.l;
            if (a4.f7417a < 2) {
                a2 = b;
            } else {
                List<Integer> a5 = a(a4, i8, i9, z2);
                if (a5.size() < 2) {
                    a2 = b;
                } else {
                    if (!z) {
                        HashSet hashSet = new HashSet();
                        str = null;
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            int i12 = i11;
                            if (i12 >= a5.size()) {
                                break;
                            }
                            String str2 = a4.a(a5.get(i12).intValue()).h;
                            if (hashSet.add(str2) && (a3 = a(a4, iArr2, i2, str2, i5, i6, i7, a5)) > i10) {
                                str = str2;
                                i10 = a3;
                            }
                            i11 = i12 + 1;
                        }
                    } else {
                        str = null;
                    }
                    b(a4, iArr2, i2, str, i5, i6, i7, a5);
                    a2 = a5.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(a5);
                }
            }
            if (a2.length > 0) {
                return ((f.a) com.anythink.expressad.exoplayer.k.a.a(aVar)).a(a4, a2);
            }
            i3 = i4 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static f b(af afVar, int[][] iArr, C0136c c0136c) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Deprecated
    private void b(int i) {
        a(d().a(i));
    }

    @Deprecated
    private void b(int i, boolean z) {
        a(d().a(i, z));
    }

    private static void b(ae aeVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int size = list.size();
        while (true) {
            int i5 = size - 1;
            if (i5 < 0) {
                return;
            }
            int intValue = list.get(i5).intValue();
            if (!a(aeVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(i5);
            }
            size = i5;
        }
    }

    private static int c(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    private C0136c c() {
        return this.e.get();
    }

    private static f c(af afVar, int[][] iArr, C0136c c0136c) {
        ae aeVar = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < afVar.b; i3++) {
            ae a2 = afVar.a(i3);
            int[] iArr2 = iArr[i3];
            int i4 = 0;
            while (i4 < a2.f7417a) {
                ae aeVar2 = aeVar;
                int i5 = i;
                int i6 = i2;
                if (a(iArr2[i4], c0136c.p)) {
                    int i7 = (a2.a(i4).z & 1) != 0 ? 2 : 1;
                    int i8 = i7;
                    if (a(iArr2[i4], false)) {
                        i8 = i7 + 1000;
                    }
                    aeVar2 = aeVar;
                    i5 = i;
                    i6 = i2;
                    if (i8 > i2) {
                        aeVar2 = a2;
                        i5 = i4;
                        i6 = i8;
                    }
                }
                i4++;
                aeVar = aeVar2;
                i = i5;
                i2 = i6;
            }
        }
        if (aeVar == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.i.d(aeVar, i);
    }

    @Deprecated
    private void c(int i) {
        a(d().b(i));
    }

    @Deprecated
    private void c(int i, af afVar) {
        a(d().a(i, afVar));
    }

    private d d() {
        return new d(c(), (byte) 0);
    }

    @Deprecated
    private void e() {
        a(d().a());
    }

    @Override // com.anythink.expressad.exoplayer.i.e
    protected final Pair<aa[], f[]> a(e.a aVar, int[][][] iArr, int[] iArr2) {
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        f fVar;
        int i4;
        String str;
        int[] a2;
        int i5;
        e.a aVar2 = aVar;
        C0136c c0136c = this.e.get();
        int a3 = aVar.a();
        int a4 = aVar.a();
        f[] fVarArr = new f[a4];
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i6 < a4) {
            if (2 == aVar2.a(i6)) {
                if (z3) {
                    int i7 = a3;
                    i = a4;
                    int i8 = i6;
                    i2 = i7;
                    z2 = z3;
                    i3 = i8;
                } else {
                    af b2 = aVar2.b(i6);
                    int[][] iArr3 = iArr[i6];
                    int i9 = iArr2[i6];
                    f.a aVar3 = this.d;
                    int i10 = a3;
                    int i11 = a4;
                    f[] fVarArr2 = fVarArr;
                    int i12 = i6;
                    boolean z5 = z4;
                    if (!c0136c.m) {
                        i10 = a3;
                        i11 = a4;
                        fVarArr2 = fVarArr;
                        i12 = i6;
                        z5 = z4;
                        if (aVar3 != null) {
                            int i13 = c0136c.o ? 24 : 16;
                            boolean z6 = c0136c.n && (i9 & i13) != 0;
                            int i14 = 0;
                            while (true) {
                                i10 = a3;
                                i11 = a4;
                                fVarArr2 = fVarArr;
                                i12 = i6;
                                z5 = z4;
                                if (i14 >= b2.b) {
                                    break;
                                }
                                ae a5 = b2.a(i14);
                                int[] iArr4 = iArr3[i14];
                                int i15 = c0136c.f;
                                int i16 = c0136c.g;
                                int i17 = c0136c.h;
                                int i18 = c0136c.j;
                                int i19 = c0136c.k;
                                boolean z7 = c0136c.l;
                                fVarArr2 = fVarArr;
                                if (a5.f7417a < 2) {
                                    a2 = b;
                                } else {
                                    List<Integer> a6 = a(a5, i18, i19, z7);
                                    if (a6.size() < 2) {
                                        a2 = b;
                                    } else {
                                        if (z6) {
                                            str = null;
                                        } else {
                                            HashSet hashSet = new HashSet();
                                            int i20 = 0;
                                            int i21 = 0;
                                            str = null;
                                            while (i20 < a6.size()) {
                                                String str2 = a5.a(a6.get(i20).intValue()).h;
                                                if (hashSet.add(str2)) {
                                                    int a7 = a(a5, iArr4, i13, str2, i15, i16, i17, a6);
                                                    i5 = i21;
                                                    if (a7 > i21) {
                                                        i5 = a7;
                                                        str = str2;
                                                    }
                                                } else {
                                                    i5 = i21;
                                                }
                                                i20++;
                                                i21 = i5;
                                            }
                                        }
                                        b(a5, iArr4, i13, str, i15, i16, i17, a6);
                                        a2 = a6.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(a6);
                                    }
                                }
                                if (a2.length > 0) {
                                    fVar = ((f.a) com.anythink.expressad.exoplayer.k.a.a(aVar3)).a(a5, a2);
                                    i4 = a3;
                                    i = a4;
                                    break;
                                }
                                i14++;
                                fVarArr = fVarArr2;
                            }
                        }
                    }
                    i = i11;
                    i6 = i12;
                    z4 = z5;
                    fVar = null;
                    i4 = i10;
                    f fVar2 = fVar;
                    if (fVar == null) {
                        fVar2 = a(b2, iArr3, c0136c);
                    }
                    fVarArr2[i6] = fVar2;
                    i3 = i6;
                    z2 = fVarArr2[i6] != null;
                    i2 = i4;
                    fVarArr = fVarArr2;
                }
                aVar2 = aVar;
                z4 |= aVar2.b(i3).b > 0;
                z3 = z2;
            } else {
                int i22 = a3;
                i = a4;
                i2 = i22;
                i3 = i6;
            }
            int i23 = i;
            a3 = i2;
            a4 = i23;
            i6 = i3 + 1;
        }
        int i24 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (true) {
            boolean z10 = z9;
            if (i24 >= a4) {
                break;
            }
            int a8 = aVar2.a(i24);
            if (a8 == 1) {
                z = z10;
                if (!z8) {
                    fVarArr[i24] = a(aVar2.b(i24), iArr[i24], c0136c, z4 ? null : this.d);
                    if (fVarArr[i24] != null) {
                        z8 = true;
                        z = z10;
                    } else {
                        z8 = false;
                        z = z10;
                    }
                }
            } else if (a8 == 2) {
                z = z10;
            } else if (a8 != 3) {
                fVarArr[i24] = c(aVar2.b(i24), iArr[i24], c0136c);
                z = z10;
            } else {
                z = z10;
                if (!z10) {
                    fVarArr[i24] = b(aVar2.b(i24), iArr[i24], c0136c);
                    z = fVarArr[i24] != null;
                }
            }
            i24++;
            z9 = z;
        }
        int i25 = 0;
        while (true) {
            int i26 = i25;
            if (i26 >= a3) {
                break;
            }
            if (c0136c.a(i26)) {
                fVarArr[i26] = null;
            } else {
                af b3 = aVar2.b(i26);
                if (c0136c.a(i26, b3)) {
                    e b4 = c0136c.b(i26, b3);
                    if (b4 == null) {
                        fVarArr[i26] = null;
                    } else if (b4.f7538c == 1) {
                        fVarArr[i26] = new com.anythink.expressad.exoplayer.i.d(b3.a(b4.f7537a), b4.b[0]);
                    } else {
                        fVarArr[i26] = ((f.a) com.anythink.expressad.exoplayer.k.a.a(this.d)).a(b3.a(b4.f7537a), b4.b);
                    }
                }
            }
            i25 = i26 + 1;
        }
        aa[] aaVarArr = new aa[a3];
        int i27 = 0;
        while (true) {
            int i28 = i27;
            if (i28 >= a3) {
                a(aVar2, iArr, aaVarArr, fVarArr, c0136c.q);
                return Pair.create(aaVarArr, fVarArr);
            }
            aaVarArr[i28] = !c0136c.a(i28) && (aVar2.a(i28) == 5 || fVarArr[i28] != null) ? aa.f7156a : null;
            i27 = i28 + 1;
        }
    }
}
