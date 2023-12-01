package com.github.mikephil.charting.matrix;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/matrix/Vector3.class */
public final class Vector3 {
    public static final Vector3 d = new Vector3(0.0f, 0.0f, 0.0f);
    public static final Vector3 e = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 f = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 g = new Vector3(0.0f, 0.0f, 1.0f);

    /* renamed from: a  reason: collision with root package name */
    public float f8558a;
    public float b;

    /* renamed from: c  reason: collision with root package name */
    public float f8559c;

    public Vector3() {
    }

    public Vector3(float f2, float f3, float f4) {
        a(f2, f3, f4);
    }

    public final void a(float f2, float f3, float f4) {
        this.f8558a = f2;
        this.b = f3;
        this.f8559c = f4;
    }
}
