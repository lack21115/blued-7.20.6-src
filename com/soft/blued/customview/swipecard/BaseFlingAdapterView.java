package com.soft.blued.customview.swipecard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/swipecard/BaseFlingAdapterView.class */
abstract class BaseFlingAdapterView extends AdapterView {

    /* renamed from: a  reason: collision with root package name */
    private int f14966a;
    private int b;

    public BaseFlingAdapterView(Context context) {
        super(context);
    }

    public BaseFlingAdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseFlingAdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getHeightMeasureSpec() {
        return this.f14966a;
    }

    public int getWidthMeasureSpec() {
        return this.b;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.b = i;
        this.f14966a = i2;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        throw new UnsupportedOperationException("Not supported");
    }
}
