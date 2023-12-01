package com.github.mikephil.charting.buffer;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/buffer/AbstractBuffer.class */
public abstract class AbstractBuffer<T> {

    /* renamed from: a  reason: collision with root package name */
    protected int f22060a;
    public final float[] b;

    /* renamed from: c  reason: collision with root package name */
    protected float f22061c = 1.0f;
    protected float d = 1.0f;
    protected int e = 0;
    protected int f = 0;

    public AbstractBuffer(int i) {
        this.f22060a = 0;
        this.f22060a = 0;
        this.b = new float[i];
    }

    public void a() {
        this.f22060a = 0;
    }

    public void a(float f, float f2) {
        this.f22061c = f;
        this.d = f2;
    }

    public int b() {
        return this.b.length;
    }
}
