package com.blued.android.framework.view.wheel.widget;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/ItemsRange.class */
public class ItemsRange {

    /* renamed from: a  reason: collision with root package name */
    private int f10350a;
    private int b;

    public ItemsRange() {
        this(0, 0);
    }

    public ItemsRange(int i, int i2) {
        this.f10350a = i;
        this.b = i2;
    }

    public int a() {
        return this.f10350a;
    }

    public boolean a(int i) {
        return i >= a() && i <= b();
    }

    public int b() {
        return (a() + c()) - 1;
    }

    public int c() {
        return this.b;
    }
}
