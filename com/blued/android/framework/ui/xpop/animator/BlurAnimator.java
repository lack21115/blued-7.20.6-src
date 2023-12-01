package com.blued.android.framework.ui.xpop.animator;

import android.animation.FloatEvaluator;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/BlurAnimator.class */
public class BlurAnimator extends PopupAnimator {
    public Bitmap a;
    public boolean b;
    private FloatEvaluator e;

    public BlurAnimator() {
        this.e = new FloatEvaluator();
        this.b = false;
    }

    public BlurAnimator(View view) {
        super(view);
        this.e = new FloatEvaluator();
        this.b = false;
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.c.getResources(), XPopupUtils.a(this.c.getContext(), this.a, 25.0f, true));
        if (this.b) {
            bitmapDrawable.setColorFilter(XPopup.a(), PorterDuff.Mode.SRC_OVER);
        }
        this.c.setBackground(bitmapDrawable);
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
    }
}
