package com.blued.android.framework.view.wheel.widget.adapters;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/adapters/ArrayWheelAdapter.class */
public class ArrayWheelAdapter<T> extends AbstractWheelTextAdapter {
    private T[] f;

    @Override // com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter
    public int a() {
        return this.f.length;
    }

    @Override // com.blued.android.framework.view.wheel.widget.adapters.AbstractWheelTextAdapter
    public CharSequence a(int i) {
        if (i >= 0) {
            T[] tArr = this.f;
            if (i < tArr.length) {
                T t = tArr[i];
                return t instanceof CharSequence ? (CharSequence) t : t.toString();
            }
            return null;
        }
        return null;
    }
}
