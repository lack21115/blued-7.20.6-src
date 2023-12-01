package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/MediaView.class */
public class MediaView extends FrameLayout {
    private static final int DEFAULT_HEIGHT = 9;
    private static final int DEFAULT_WIDTH = 16;

    public MediaView(Context context) {
        super(context);
        setBackgroundColor(-16777216);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundColor(-16777216);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundColor(-16777216);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setBackgroundColor(-16777216);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = (size * 9) / 16;
        int i4 = (size2 * 16) / 9;
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (mode == 1073741824) {
                makeMeasureSpec = i;
                if (mode2 == Integer.MIN_VALUE) {
                    i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, size2), 1073741824);
                }
                i = makeMeasureSpec;
                i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                if (mode2 == 1073741824) {
                    makeMeasureSpec2 = i2;
                    if (mode == Integer.MIN_VALUE) {
                        i = View.MeasureSpec.makeMeasureSpec(Math.min(i4, size), 1073741824);
                    }
                } else if (mode != Integer.MIN_VALUE ? mode2 != Integer.MIN_VALUE : mode2 != Integer.MIN_VALUE || size2 / 9 > size / 16) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                    i = makeMeasureSpec;
                    i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                } else {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                }
                i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                i2 = makeMeasureSpec2;
            }
        }
        super.onMeasure(i, i2);
    }
}
