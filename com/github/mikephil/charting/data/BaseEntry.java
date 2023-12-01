package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/BaseEntry.class */
public abstract class BaseEntry {

    /* renamed from: a  reason: collision with root package name */
    private float f8516a;
    private Object b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f8517c;

    public BaseEntry() {
        this.f8516a = 0.0f;
        this.b = null;
        this.f8517c = null;
    }

    public BaseEntry(float f) {
        this.f8516a = 0.0f;
        this.b = null;
        this.f8517c = null;
        this.f8516a = f;
    }

    public BaseEntry(float f, Object obj) {
        this(f);
        this.b = obj;
    }

    public void a(float f) {
        this.f8516a = f;
    }

    public void a(Object obj) {
        this.b = obj;
    }

    public float b() {
        return this.f8516a;
    }

    public Drawable g() {
        return this.f8517c;
    }

    public Object h() {
        return this.b;
    }
}
