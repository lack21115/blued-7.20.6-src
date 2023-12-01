package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/AspectLayout.class */
public class AspectLayout extends RelativeLayout {
    private int a;
    private int b;

    public AspectLayout(Context context) {
        super(context);
    }

    public AspectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AspectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AspectLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int height = getRootView().getHeight();
        if (height - (rect.bottom - rect.top) > height / 4) {
            super.onMeasure(this.a, this.b);
            return;
        }
        this.a = i;
        this.b = i2;
        super.onMeasure(i, i2);
    }
}
