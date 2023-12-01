package com.blued.android.framework.view.wheel.widget.adapters;

import com.blued.android.framework.view.wheel.widget.WheelAdapter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/adapters/AdapterWheel.class */
public class AdapterWheel extends AbstractWheelTextAdapter {
    private WheelAdapter f;

    @Override // com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public int a() {
        return this.f.a();
    }

    @Override // com.blued.android.framework.view.wheel.widget.adapters.AbstractWheelTextAdapter
    protected CharSequence a(int i) {
        return this.f.a(i);
    }
}
