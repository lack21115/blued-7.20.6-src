package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/FlakeConfig.class */
public class FlakeConfig {
    static SparseArray<Bitmap> i = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    int f11494a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    float f11495c;
    float d;
    float e;
    float f;
    float g;
    Bitmap h;
    private float j = 1300.0f;
    private float k = 1800.0f;
    private float l = -90.0f;
    private float m = 90.0f;
    private float n = -45.0f;
    private float o = 90.0f;
    private float p;
    private float q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlakeConfig(Context context, float f, float f2, Bitmap bitmap) {
        this.p = f;
        this.q = f2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int random = width - ((int) ((Math.random() * width) / 2.0d));
        this.f11494a = random;
        this.b = (height * random) / width;
        b();
        Bitmap bitmap2 = i.get(this.f11494a);
        this.h = bitmap2;
        if (bitmap2 == null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, this.f11494a, this.b, true);
            this.h = createScaledBitmap;
            i.put(this.f11494a, createScaledBitmap);
        }
    }

    private void b() {
        this.f11495c = ((float) Math.random()) * (this.p - this.f11494a);
        this.d = 0.0f - (this.b + (((float) Math.random()) * this.q));
        this.f = this.j + (((float) Math.random()) * (this.k - this.j));
        float random = (float) Math.random();
        float f = this.m;
        float f2 = this.l;
        this.e = (random * (f - f2)) + f2;
        float random2 = (float) Math.random();
        float f3 = this.o;
        float f4 = this.n;
        this.g = (random2 * (f3 - f4)) + f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2) {
        if (f2 < f) {
            throw new IllegalArgumentException("speedMax must be >= speedMini");
        }
        this.k = f2;
        this.j = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        if (f2 < f) {
            throw new IllegalArgumentException("degreeMax must be >= degreeMini");
        }
        this.m = f2;
        this.l = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f, float f2) {
        if (f2 < f) {
            throw new IllegalArgumentException("rotationSpeedMax must be >= rotationSpeedMini");
        }
        this.o = f2;
        this.n = f;
    }
}
