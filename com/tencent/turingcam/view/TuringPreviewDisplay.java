package com.tencent.turingcam.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/view/TuringPreviewDisplay.class */
public class TuringPreviewDisplay extends FrameLayout {
    private static final String TAG = "MFACameraDisplay";

    public TuringPreviewDisplay(Context context) {
        this(context, null);
    }

    public TuringPreviewDisplay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TuringPreviewDisplay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
