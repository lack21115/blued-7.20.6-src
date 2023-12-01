package a.a.a.a.a.b.i;

import com.qiniu.pili.droid.streaming.PreviewAppearance;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/f.class */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public int f1275a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f1276c;
    public float[] d;

    public final void a(int i, int i2, int i3, int i4) {
        this.f1276c = k.f1279a;
        float f = (i3 * 1.0f) / i4;
        float f2 = i;
        float f3 = i2;
        if ((f2 * 1.0f) / f3 < f) {
            float f4 = ((f3 - (f2 / f)) / 2.0f) / f3;
            float f5 = 1.0f - f4;
            this.d = new float[]{0.0f, f4, 0.0f, f5, 1.0f, f4, 1.0f, f5};
            return;
        }
        float f6 = ((f2 - (f3 * f)) / 2.0f) / f2;
        float f7 = 1.0f - f6;
        this.d = new float[]{f6, 0.0f, f6, 1.0f, f7, 0.0f, f7, 1.0f};
    }

    public boolean a(int i, int i2, int i3, int i4, int i5, int i6, PreviewAppearance.ScaleType scaleType) {
        this.f1275a = i3;
        this.b = i4;
        if (scaleType == PreviewAppearance.ScaleType.FULL) {
            a(i, i2, i5, i6);
        } else {
            b(i, i2, i5, i6);
        }
        return super.a(i5, i6);
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.d = k.d;
        float f = i3;
        float f2 = i4;
        float f3 = (f * 1.0f) / f2;
        float f4 = (i * 1.0f) / i2;
        if (f4 < f3) {
            float f5 = ((f2 * f4) / f) / 2.0f;
            float f6 = ((0.5f - f5) * 2.0f) - 1.0f;
            float f7 = ((f5 + 0.5f) * 2.0f) - 1.0f;
            this.f1276c = new float[]{f6, -1.0f, f6, 1.0f, f7, -1.0f, f7, 1.0f};
            return;
        }
        float f8 = ((f / f4) / f2) / 2.0f;
        float f9 = ((0.5f - f8) * 2.0f) - 1.0f;
        float f10 = ((f8 + 0.5f) * 2.0f) - 1.0f;
        this.f1276c = new float[]{-1.0f, f9, -1.0f, f10, 1.0f, f9, 1.0f, f10};
    }

    @Override // a.a.a.a.a.b.i.g
    public int c() {
        return this.f1275a;
    }

    @Override // a.a.a.a.a.b.i.g
    public int d() {
        return this.b;
    }

    @Override // a.a.a.a.a.b.i.g
    public float[] e() {
        return this.f1276c;
    }

    @Override // a.a.a.a.a.b.i.g
    public float[] f() {
        return this.d;
    }
}
