package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/CustomLinearLayout.class */
public class CustomLinearLayout extends KeyboardListenLinearLayout {
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 19) {
            rect.left = 0;
            rect.top = 0;
            rect.right = 0;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsets2 = windowInsets;
        if (Build.VERSION.SDK_INT >= 19) {
            windowInsets2 = super.onApplyWindowInsets(windowInsets.replaceSystemWindowInsets(0, 0, 0, windowInsets.getSystemWindowInsetBottom()));
        }
        return windowInsets2;
    }
}
