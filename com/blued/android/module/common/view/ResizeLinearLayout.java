package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ResizeLinearLayout.class */
public class ResizeLinearLayout extends KeyboardListenLinearLayout implements BluedSkinSupportable {
    private int[] a;
    private SkinCompatBackgroundHelper b;

    public ResizeLinearLayout(Context context) {
        this(context, null);
    }

    public ResizeLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResizeLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new int[4];
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.b = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, 0);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.a[0] = rect.left;
            this.a[1] = rect.top;
            this.a[2] = rect.right;
            rect.left = 0;
            rect.top = 0;
            rect.right = 0;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsets2 = windowInsets;
        if (Build.VERSION.SDK_INT >= 20) {
            this.a[0] = windowInsets.getSystemWindowInsetLeft();
            this.a[1] = windowInsets.getSystemWindowInsetTop();
            this.a[2] = windowInsets.getSystemWindowInsetRight();
            windowInsets2 = super.onApplyWindowInsets(windowInsets.replaceSystemWindowInsets(0, 0, 0, windowInsets.getSystemWindowInsetBottom()));
        }
        return windowInsets2;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }
}
