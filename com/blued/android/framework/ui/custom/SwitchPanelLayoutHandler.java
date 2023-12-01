package com.blued.android.framework.ui.custom;

import android.view.View;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/custom/SwitchPanelLayoutHandler.class */
public class SwitchPanelLayoutHandler {
    private final View b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f9883a = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9884c = false;

    public SwitchPanelLayoutHandler(View view) {
        this.b = view;
    }

    public void a(boolean z) {
        this.f9884c = z;
    }

    public boolean a() {
        return this.f9884c;
    }

    public boolean a(int i) {
        if (i == 0) {
            this.f9883a = false;
        }
        if (i == this.b.getVisibility()) {
            return true;
        }
        return a() && i == 0;
    }

    public int[] a(int i, int i2) {
        if (this.f9883a) {
            this.b.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void b() {
        this.f9883a = true;
    }
}
