package com.blued.android.framework.activity.keyboardpage;

import android.view.View;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/keyboardpage/SwitchPanelLayoutHandler.class */
public class SwitchPanelLayoutHandler {
    private final View b;
    private boolean a = false;
    private boolean c = false;

    public SwitchPanelLayoutHandler(View view) {
        this.b = view;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    public boolean a(int i) {
        if (i == 0) {
            this.a = false;
        }
        if (i == this.b.getVisibility()) {
            return true;
        }
        return a() && i == 0;
    }

    public int[] a(int i, int i2) {
        if (this.a) {
            this.b.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public void b() {
        this.a = true;
    }
}
