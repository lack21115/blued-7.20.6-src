package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.s8;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r8.class */
public class r8 extends t8 {
    private int g;
    private int h;
    private int i;
    private boolean j;

    public r8(s8.b... bVarArr) {
        super(bVarArr);
        this.j = true;
    }

    @Override // com.tencent.mapsdk.internal.t8
    public Object a(float f) {
        return Integer.valueOf(b(f));
    }

    public int b(float f) {
        int i = this.f24330a;
        if (i == 2) {
            if (this.j) {
                this.j = false;
                this.g = ((s8.b) this.e.get(0)).h();
                int h = ((s8.b) this.e.get(1)).h();
                this.h = h;
                this.i = h - this.g;
            }
            Interpolator interpolator = this.d;
            float f2 = f;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f);
            }
            y8 y8Var = this.f;
            return y8Var == null ? this.g + ((int) (f2 * this.i)) : ((Number) y8Var.a(f2, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
        } else if (f <= 0.0f) {
            s8.b bVar = (s8.b) this.e.get(0);
            s8.b bVar2 = (s8.b) this.e.get(1);
            int h2 = bVar.h();
            int h3 = bVar2.h();
            float b = bVar.b();
            float b2 = bVar2.b();
            Interpolator c2 = bVar2.c();
            float f3 = f;
            if (c2 != null) {
                f3 = c2.getInterpolation(f);
            }
            float f4 = (f3 - b) / (b2 - b);
            y8 y8Var2 = this.f;
            return y8Var2 == null ? h2 + ((int) (f4 * (h3 - h2))) : ((Number) y8Var2.a(f4, Integer.valueOf(h2), Integer.valueOf(h3))).intValue();
        } else if (f >= 1.0f) {
            s8.b bVar3 = (s8.b) this.e.get(i - 2);
            s8.b bVar4 = (s8.b) this.e.get(this.f24330a - 1);
            int h4 = bVar3.h();
            int h5 = bVar4.h();
            float b3 = bVar3.b();
            float b4 = bVar4.b();
            Interpolator c3 = bVar4.c();
            float f5 = f;
            if (c3 != null) {
                f5 = c3.getInterpolation(f);
            }
            float f6 = (f5 - b3) / (b4 - b3);
            y8 y8Var3 = this.f;
            return y8Var3 == null ? h4 + ((int) (f6 * (h5 - h4))) : ((Number) y8Var3.a(f6, Integer.valueOf(h4), Integer.valueOf(h5))).intValue();
        } else {
            s8.b bVar5 = (s8.b) this.e.get(0);
            int i2 = 1;
            while (true) {
                int i3 = this.f24330a;
                if (i2 >= i3) {
                    return ((Number) this.e.get(i3 - 1).e()).intValue();
                }
                s8.b bVar6 = (s8.b) this.e.get(i2);
                if (f < bVar6.b()) {
                    Interpolator c4 = bVar6.c();
                    float f7 = f;
                    if (c4 != null) {
                        f7 = c4.getInterpolation(f);
                    }
                    float b5 = (f7 - bVar5.b()) / (bVar6.b() - bVar5.b());
                    int h6 = bVar5.h();
                    int h7 = bVar6.h();
                    y8 y8Var4 = this.f;
                    return y8Var4 == null ? h6 + ((int) (b5 * (h7 - h6))) : ((Number) y8Var4.a(b5, Integer.valueOf(h6), Integer.valueOf(h7))).intValue();
                }
                i2++;
                bVar5 = bVar6;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.t8
    /* renamed from: b */
    public r8 clone() {
        ArrayList<s8> arrayList = this.e;
        int size = arrayList.size();
        s8.b[] bVarArr = new s8.b[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new r8(bVarArr);
            }
            bVarArr[i2] = (s8.b) arrayList.get(i2).clone();
            i = i2 + 1;
        }
    }
}
