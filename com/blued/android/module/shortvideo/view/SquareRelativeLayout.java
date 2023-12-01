package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/SquareRelativeLayout.class */
public class SquareRelativeLayout extends RelativeLayout {
    public SquareRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Log.i("SquareRelativeLayout", "specify width mode:" + View.MeasureSpec.toString(i) + " size:" + size);
        Log.i("SquareRelativeLayout", "specify height mode:" + View.MeasureSpec.toString(i2) + " size:" + size2);
        setMeasuredDimension(size, size);
    }
}
