package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.s8;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p8.class */
public class p8 extends t8 {
    private double g;
    private double h;
    private double i;
    private boolean j;

    public p8(s8.a... aVarArr) {
        super(aVarArr);
        this.j = true;
    }

    @Override // com.tencent.mapsdk.internal.t8
    public Object a(float f) {
        return Double.valueOf(b(f));
    }

    public double b(float f) {
        int i;
        y8 y8Var;
        y8 y8Var2;
        y8 y8Var3;
        int i2 = this.f38021a;
        if (i2 == 2) {
            if (this.j) {
                this.j = false;
                this.g = ((s8.a) this.e.get(0)).h();
                double h = ((s8.a) this.e.get(1)).h();
                this.h = h;
                this.i = h - this.g;
            }
            Interpolator interpolator = this.d;
            float f2 = f;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f);
            }
            y8 y8Var4 = this.f;
            return y8Var4 == null ? this.g + (f2 * this.i) : ((Number) y8Var4.a(f2, Double.valueOf(this.g), Double.valueOf(this.h))).doubleValue();
        } else if (f <= 0.0f) {
            s8.a aVar = (s8.a) this.e.get(0);
            s8.a aVar2 = (s8.a) this.e.get(1);
            double h2 = aVar.h();
            double h3 = aVar2.h();
            float b = aVar.b();
            float b2 = aVar2.b();
            Interpolator c2 = aVar2.c();
            float f3 = f;
            if (c2 != null) {
                f3 = c2.getInterpolation(f);
            }
            float f4 = (f3 - b) / (b2 - b);
            return this.f == null ? h2 + (f4 * (h3 - h2)) : ((Number) y8Var3.a(f4, Double.valueOf(h2), Double.valueOf(h3))).floatValue();
        } else if (f >= 1.0f) {
            s8.a aVar3 = (s8.a) this.e.get(i2 - 2);
            s8.a aVar4 = (s8.a) this.e.get(this.f38021a - 1);
            double h4 = aVar3.h();
            double h5 = aVar4.h();
            float b3 = aVar3.b();
            float b4 = aVar4.b();
            Interpolator c3 = aVar4.c();
            float f5 = f;
            if (c3 != null) {
                f5 = c3.getInterpolation(f);
            }
            float f6 = (f5 - b3) / (b4 - b3);
            return this.f == null ? h4 + (f6 * (h5 - h4)) : ((Number) y8Var2.a(f6, Double.valueOf(h4), Double.valueOf(h5))).floatValue();
        } else {
            s8.a aVar5 = (s8.a) this.e.get(0);
            int i3 = 1;
            while (true) {
                if (i3 >= this.f38021a) {
                    return ((Number) this.e.get(i - 1).e()).floatValue();
                }
                s8.a aVar6 = (s8.a) this.e.get(i3);
                if (f < aVar6.b()) {
                    Interpolator c4 = aVar6.c();
                    float f7 = f;
                    if (c4 != null) {
                        f7 = c4.getInterpolation(f);
                    }
                    float b5 = (f7 - aVar5.b()) / (aVar6.b() - aVar5.b());
                    double h6 = aVar5.h();
                    double h7 = aVar6.h();
                    return this.f == null ? h6 + (b5 * (h7 - h6)) : ((Number) y8Var.a(b5, Double.valueOf(h6), Double.valueOf(h7))).floatValue();
                }
                i3++;
                aVar5 = aVar6;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.t8
    /* renamed from: b */
    public p8 clone() {
        ArrayList<s8> arrayList = this.e;
        int size = arrayList.size();
        s8.a[] aVarArr = new s8.a[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new p8(aVarArr);
            }
            aVarArr[i2] = (s8.a) arrayList.get(i2).clone();
            i = i2 + 1;
        }
    }
}
