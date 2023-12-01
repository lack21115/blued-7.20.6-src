package com.opos.exoplayer.core.i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<a> f25502a = new Comparator<a>() { // from class: com.opos.exoplayer.core.i.q.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return aVar.f25504a - aVar2.f25504a;
        }
    };
    private static final Comparator<a> b = new Comparator<a>() { // from class: com.opos.exoplayer.core.i.q.2
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.f25505c < aVar2.f25505c) {
                return -1;
            }
            return aVar2.f25505c < aVar.f25505c ? 1 : 0;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final int f25503c;
    private int g;
    private int h;
    private int i;
    private final a[] e = new a[5];
    private final ArrayList<a> d = new ArrayList<>();
    private int f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/q$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f25504a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public float f25505c;

        private a() {
        }
    }

    public q(int i) {
        this.f25503c = i;
    }

    private void a() {
        if (this.f != 1) {
            Collections.sort(this.d, f25502a);
            this.f = 1;
        }
    }

    private void b() {
        if (this.f != 0) {
            Collections.sort(this.d, b);
            this.f = 0;
        }
    }

    public float a(float f) {
        b();
        float f2 = this.h;
        int i = 0;
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            a aVar = this.d.get(i2);
            i += aVar.b;
            if (i >= f * f2) {
                return aVar.f25505c;
            }
        }
        if (this.d.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<a> arrayList = this.d;
        return arrayList.get(arrayList.size() - 1).f25505c;
    }

    public void a(int i, float f) {
        a aVar;
        int i2;
        a aVar2;
        a();
        int i3 = this.i;
        if (i3 > 0) {
            a[] aVarArr = this.e;
            int i4 = i3 - 1;
            this.i = i4;
            aVar = aVarArr[i4];
        } else {
            aVar = new a();
        }
        int i5 = this.g;
        this.g = i5 + 1;
        aVar.f25504a = i5;
        aVar.b = i;
        aVar.f25505c = f;
        this.d.add(aVar);
        int i6 = this.h + i;
        while (true) {
            this.h = i6;
            while (true) {
                int i7 = this.h;
                int i8 = this.f25503c;
                if (i7 <= i8) {
                    return;
                }
                i2 = i7 - i8;
                aVar2 = this.d.get(0);
                if (aVar2.b <= i2) {
                    this.h -= aVar2.b;
                    this.d.remove(0);
                    int i9 = this.i;
                    if (i9 < 5) {
                        a[] aVarArr2 = this.e;
                        this.i = i9 + 1;
                        aVarArr2[i9] = aVar2;
                    }
                }
            }
            aVar2.b -= i2;
            i6 = this.h - i2;
        }
    }
}
