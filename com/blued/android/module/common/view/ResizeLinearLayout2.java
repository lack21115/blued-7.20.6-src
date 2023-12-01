package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/ResizeLinearLayout2.class */
public class ResizeLinearLayout2 extends KeyboardListenLinearLayout implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    private int[] f11033a;
    private SkinCompatBackgroundHelper b;

    public ResizeLinearLayout2(Context context) {
        this(context, null);
    }

    public ResizeLinearLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResizeLinearLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11033a = new int[4];
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
            this.f11033a[0] = rect.left;
            this.f11033a[1] = rect.top;
            this.f11033a[2] = rect.right;
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
            this.f11033a[0] = windowInsets.getSystemWindowInsetLeft();
            this.f11033a[1] = windowInsets.getSystemWindowInsetTop();
            this.f11033a[2] = windowInsets.getSystemWindowInsetRight();
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
