package com.blued.android.framework.view.wheel.widget.adapters;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/adapters/NumericWheelAdapter.class */
public class NumericWheelAdapter extends AbstractWheelTextAdapter {
    private int f;
    private int g;
    private String h;

    @Override // com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public int a() {
        return (this.g - this.f) + 1;
    }

    @Override // com.blued.android.framework.view.wheel.widget.adapters.AbstractWheelTextAdapter
    public CharSequence a(int i) {
        if (i < 0 || i >= a()) {
            return null;
        }
        int i2 = this.f + i;
        String str = this.h;
        return str != null ? String.format(str, Integer.valueOf(i2)) : Integer.toString(i2);
    }
}
