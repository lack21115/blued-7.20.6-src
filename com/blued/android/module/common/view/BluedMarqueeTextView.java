package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BluedMarqueeTextView.class */
public class BluedMarqueeTextView extends AppCompatTextView {
    public BluedMarqueeTextView(Context context) {
        super(context);
    }

    public BluedMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BluedMarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isFocused() {
        return true;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }
}
