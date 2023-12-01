package c.t.m.g;

import android.hardware.SensorManager;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/s.class */
public class s {
    public static double[] l = new double[7];

    /* renamed from: a  reason: collision with root package name */
    public t f3923a;
    public boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public float[] f3924c = new float[9];
    public int d = 0;
    public boolean e = false;
    public volatile long f = 0;
    public double[][] g = null;
    public double[][] h = null;
    public float[] i = {-10.0f, -10.0f, -10.0f};
    public float[] j = {1.0f, 1.0f, 1.0f};
    public float[] k = new float[3];

    public void a() {
        int i = 0;
        this.d = 0;
        this.e = false;
        this.f = 0L;
        while (true) {
            double[][] dArr = this.g;
            if (i >= dArr.length) {
                Arrays.fill(this.i, -10.0f);
                this.f3923a.d();
                return;
            }
            Arrays.fill(dArr[i], 0.0d);
            i++;
        }
    }

    public void a(int i, int i2, float f, double[][] dArr, double[][] dArr2, double[][] dArr3, double[] dArr4) {
        if (this.b) {
            return;
        }
        r.f3905a = i;
        r.b = (i * (i - 1)) / 2;
        r.f3906c = i2;
        r.d = f;
        r.e = dArr;
        r.f = dArr2;
        r.g = dArr3;
        r.h = dArr4;
        this.g = (double[][]) Array.newInstance(Double.TYPE, 10, 128);
        this.h = (double[][]) Array.newInstance(Double.TYPE, 10, 128);
        this.f3923a = new t();
        this.b = true;
    }

    public void a(long j, float f) {
        this.f3923a.a(j, f);
    }

    public void a(long j, float[] fArr, float[] fArr2) {
        a(this.i, fArr);
        Arrays.fill(this.f3924c, 0.0f);
        SensorManager.getRotationMatrix(this.f3924c, null, this.i, this.j);
        double[][] dArr = this.g;
        double[] dArr2 = dArr[0];
        int i = this.d;
        dArr2[i] = fArr[0];
        dArr[1][i] = fArr[1];
        dArr[2][i] = fArr[2];
        dArr[3][i] = Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
        this.g[4][this.d] = Math.sqrt((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1]) + (fArr2[2] * fArr2[2]));
        double d = 0.0d;
        double d2 = Math.abs(this.g[3][this.d] - 0.0d) < 1.0E-5d ? 2.0d : fArr[2] / this.g[3][this.d];
        double[] dArr3 = this.g[5];
        int i2 = this.d;
        if (Math.abs(d2) <= 1.0d) {
            d = Math.acos(d2);
        }
        dArr3[i2] = d;
        a(this.k, this.f3924c, fArr);
        double[] dArr4 = this.g[6];
        int i3 = this.d;
        float[] fArr3 = this.k;
        dArr4[i3] = Math.sqrt((fArr3[0] * fArr3[0]) + (fArr3[1] * fArr3[1]));
        double[] dArr5 = this.g[7];
        int i4 = this.d;
        float[] fArr4 = this.k;
        dArr5[i4] = fArr4[2];
        a(fArr4, this.f3924c, fArr2);
        double[] dArr6 = this.g[8];
        int i5 = this.d;
        float[] fArr5 = this.k;
        dArr6[i5] = Math.sqrt((fArr5[0] * fArr5[0]) + (fArr5[1] * fArr5[1]));
        this.g[9][this.d] = this.k[2];
        this.f = j;
        int i6 = this.d + 1;
        this.d = i6;
        if (i6 == 128) {
            this.d = 0;
            if (this.e) {
                return;
            }
            this.e = true;
        }
    }

    public final void a(float[] fArr, float[] fArr2) {
        float f = r.d;
        if (fArr[0] == -10.0f) {
            System.arraycopy(fArr2, 0, fArr, 0, fArr.length);
            return;
        }
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = (fArr[i] * f) + ((1.0f - f) * fArr2[i]);
        }
    }

    public final void a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[1]) + (fArr2[2] * fArr3[2]);
        fArr[1] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[5] * fArr3[2]);
        fArr[2] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[1]) + (fArr2[8] * fArr3[2]);
    }

    public double[] a(long j) {
        if (!this.e || j - this.f >= com.anythink.expressad.video.module.a.a.m.ag) {
            return null;
        }
        int i = this.d;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            double[][] dArr = this.g;
            if (i3 >= dArr.length) {
                return this.f3923a.a(j, this.h);
            }
            System.arraycopy(dArr[i3], i, this.h[i3], 0, dArr[i3].length - i);
            if (this.d != 0) {
                double[][] dArr2 = this.g;
                System.arraycopy(dArr2[i3], 0, this.h[i3], dArr2[i3].length - i, i);
            }
            i2 = i3 + 1;
        }
    }

    public void b() {
        if (this.b) {
            a();
            this.f3923a.b();
            this.b = false;
        }
    }
}
