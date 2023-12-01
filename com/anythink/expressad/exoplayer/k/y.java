package com.anythink.expressad.exoplayer.k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/y.class */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<a> f4844a = new Comparator<a>() { // from class: com.anythink.expressad.exoplayer.k.y.1
        private static int a(a aVar, a aVar2) {
            return aVar.f4846a - aVar2.f4846a;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar.f4846a - aVar2.f4846a;
        }
    };
    private static final Comparator<a> b = new Comparator<a>() { // from class: com.anythink.expressad.exoplayer.k.y.2
        private static int a(a aVar, a aVar2) {
            if (aVar.f4847c < aVar2.f4847c) {
                return -1;
            }
            return aVar2.f4847c < aVar.f4847c ? 1 : 0;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            a aVar3 = aVar;
            a aVar4 = aVar2;
            if (aVar3.f4847c < aVar4.f4847c) {
                return -1;
            }
            return aVar4.f4847c < aVar3.f4847c ? 1 : 0;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final int f4845c = -1;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 5;
    private final int g;
    private int k;
    private int l;
    private int m;
    private final a[] i = new a[5];
    private final ArrayList<a> h = new ArrayList<>();
    private int j = -1;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/y$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4846a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public float f4847c;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public y(int i) {
        this.g = i;
    }

    private void b() {
        if (this.j != 1) {
            Collections.sort(this.h, f4844a);
            this.j = 1;
        }
    }

    private void c() {
        if (this.j != 0) {
            Collections.sort(this.h, b);
            this.j = 0;
        }
    }

    public final float a() {
        if (this.j != 0) {
            Collections.sort(this.h, b);
            this.j = 0;
        }
        float f2 = this.l;
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            a aVar = this.h.get(i2);
            i += aVar.b;
            if (i >= f2 * 0.5f) {
                return aVar.f4847c;
            }
        }
        if (this.h.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<a> arrayList = this.h;
        return arrayList.get(arrayList.size() - 1).f4847c;
    }

    public final void a(int i, float f2) {
        a aVar;
        if (this.j != 1) {
            Collections.sort(this.h, f4844a);
            this.j = 1;
        }
        int i2 = this.m;
        if (i2 > 0) {
            a[] aVarArr = this.i;
            int i3 = i2 - 1;
            this.m = i3;
            aVar = aVarArr[i3];
        } else {
            aVar = new a((byte) 0);
        }
        int i4 = this.k;
        this.k = i4 + 1;
        aVar.f4846a = i4;
        aVar.b = i;
        aVar.f4847c = f2;
        this.h.add(aVar);
        this.l += i;
        while (true) {
            int i5 = this.l;
            int i6 = this.g;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            a aVar2 = this.h.get(0);
            if (aVar2.b <= i7) {
                this.l -= aVar2.b;
                this.h.remove(0);
                int i8 = this.m;
                if (i8 < 5) {
                    a[] aVarArr2 = this.i;
                    this.m = i8 + 1;
                    aVarArr2[i8] = aVar2;
                }
            } else {
                aVar2.b -= i7;
                this.l -= i7;
            }
        }
    }
}
