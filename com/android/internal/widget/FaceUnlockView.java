package com.android.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/FaceUnlockView.class */
public class FaceUnlockView extends RelativeLayout {
    private static final String TAG = "FaceUnlockView";

    public FaceUnlockView(Context context) {
        this(context, null);
    }

    public FaceUnlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int resolveMeasured(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int min = Math.min(resolveMeasured(i, getSuggestedMinimumWidth()), resolveMeasured(i2, getSuggestedMinimumHeight()));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(min, Integer.MIN_VALUE));
    }
}
