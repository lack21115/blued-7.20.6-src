package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.s8;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t8.class */
public class t8 {

    /* renamed from: a  reason: collision with root package name */
    public int f38021a;
    public s8 b;

    /* renamed from: c  reason: collision with root package name */
    public s8 f38022c;
    public Interpolator d;
    public ArrayList<s8> e;
    public y8 f;

    public t8(s8... s8VarArr) {
        this.f38021a = s8VarArr.length;
        ArrayList<s8> arrayList = new ArrayList<>();
        this.e = arrayList;
        arrayList.addAll(Arrays.asList(s8VarArr));
        this.b = this.e.get(0);
        s8 s8Var = this.e.get(this.f38021a - 1);
        this.f38022c = s8Var;
        this.d = s8Var.c();
    }

    public static t8 a(double... dArr) {
        int length = dArr.length;
        s8.a[] aVarArr = new s8.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (s8.a) s8.a(0.0f);
            aVarArr[1] = (s8.a) s8.a(1.0f, dArr[0]);
        } else {
            aVarArr[0] = (s8.a) s8.a(0.0f, dArr[0]);
            for (int i = 1; i < length; i++) {
                aVarArr[i] = (s8.a) s8.a(i / (length - 1), dArr[i]);
            }
        }
        return new p8(aVarArr);
    }

    public static t8 a(int... iArr) {
        int length = iArr.length;
        s8.b[] bVarArr = new s8.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (s8.b) s8.b(0.0f);
            bVarArr[1] = (s8.b) s8.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (s8.b) s8.a(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                bVarArr[i] = (s8.b) s8.a(i / (length - 1), iArr[i]);
            }
        }
        return new r8(bVarArr);
    }

    public static t8 a(s8... s8VarArr) {
        int length = s8VarArr.length;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < length; i++) {
            if (s8VarArr[i] instanceof s8.a) {
                z = true;
            } else if (s8VarArr[i] instanceof s8.b) {
                z2 = true;
            } else {
                z3 = true;
            }
        }
        if (z && !z2 && !z3) {
            s8.a[] aVarArr = new s8.a[length];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return new p8(aVarArr);
                }
                aVarArr[i3] = (s8.a) s8VarArr[i3];
                i2 = i3 + 1;
            }
        } else if (!z2 || z || z3) {
            return new t8(s8VarArr);
        } else {
            s8.b[] bVarArr = new s8.b[length];
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    return new r8(bVarArr);
                }
                bVarArr[i5] = (s8.b) s8VarArr[i5];
                i4 = i5 + 1;
            }
        }
    }

    public static t8 a(Object... objArr) {
        int length = objArr.length;
        s8.c[] cVarArr = new s8.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (s8.c) s8.c(0.0f);
            cVarArr[1] = (s8.c) s8.a(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (s8.c) s8.a(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                cVarArr[i] = (s8.c) s8.a(i / (length - 1), objArr[i]);
            }
        }
        return new t8(cVarArr);
    }

    @Override // 
    /* renamed from: a */
    public t8 clone() {
        ArrayList<s8> arrayList = this.e;
        int size = arrayList.size();
        s8[] s8VarArr = new s8[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new t8(s8VarArr);
            }
            s8VarArr[i2] = arrayList.get(i2).clone();
            i = i2 + 1;
        }
    }

    public Object a(float f) {
        int i = this.f38021a;
        if (i == 2) {
            Interpolator interpolator = this.d;
            float f2 = f;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f);
            }
            return this.f.a(f2, this.b.e(), this.f38022c.e());
        }
        int i2 = 1;
        if (f <= 0.0f) {
            s8 s8Var = this.e.get(1);
            Interpolator c2 = s8Var.c();
            float f3 = f;
            if (c2 != null) {
                f3 = c2.getInterpolation(f);
            }
            float b = this.b.b();
            return this.f.a((f3 - b) / (s8Var.b() - b), this.b.e(), s8Var.e());
        } else if (f >= 1.0f) {
            s8 s8Var2 = this.e.get(i - 2);
            Interpolator c3 = this.f38022c.c();
            float f4 = f;
            if (c3 != null) {
                f4 = c3.getInterpolation(f);
            }
            float b2 = s8Var2.b();
            return this.f.a((f4 - b2) / (this.f38022c.b() - b2), s8Var2.e(), this.f38022c.e());
        } else {
            s8 s8Var3 = this.b;
            while (true) {
                s8 s8Var4 = s8Var3;
                if (i2 >= this.f38021a) {
                    return this.f38022c.e();
                }
                s8 s8Var5 = this.e.get(i2);
                if (f < s8Var5.b()) {
                    Interpolator c4 = s8Var5.c();
                    float f5 = f;
                    if (c4 != null) {
                        f5 = c4.getInterpolation(f);
                    }
                    float b3 = s8Var4.b();
                    return this.f.a((f5 - b3) / (s8Var5.b() - b3), s8Var4.e(), s8Var5.e());
                }
                i2++;
                s8Var3 = s8Var5;
            }
        }
    }

    public void a(y8 y8Var) {
        this.f = y8Var;
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f38021a) {
                return str;
            }
            str = str + this.e.get(i2).e() + "  ";
            i = i2 + 1;
        }
    }
}
