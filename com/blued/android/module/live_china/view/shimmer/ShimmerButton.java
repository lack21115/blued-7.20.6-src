package com.blued.android.module.live_china.view.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.blued.android.module.live_china.view.shimmer.ShimmerViewHelper;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/shimmer/ShimmerButton.class */
public class ShimmerButton extends AppCompatButton implements ShimmerViewBase {
    private ShimmerViewHelper a;

    /* JADX WARN: Multi-variable type inference failed */
    public ShimmerButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.a = shimmerViewHelper;
        shimmerViewHelper.a(getCurrentTextColor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShimmerButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.a = shimmerViewHelper;
        shimmerViewHelper.a(getCurrentTextColor());
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public boolean a() {
        return this.a.b();
    }

    public float getGradientX() {
        return this.a.a();
    }

    public int getPrimaryColor() {
        return this.a.c();
    }

    public int getReflectionColor() {
        return this.a.d();
    }

    public void onDraw(Canvas canvas) {
        ShimmerViewHelper shimmerViewHelper = this.a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.f();
        }
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ShimmerViewHelper shimmerViewHelper = this.a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.e();
        }
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback animationSetupCallback) {
        this.a.a(animationSetupCallback);
    }

    public void setGradientX(float f) {
        this.a.a(f);
    }

    public void setPrimaryColor(int i) {
        this.a.a(i);
    }

    public void setReflectionColor(int i) {
        this.a.b(i);
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public void setShimmering(boolean z) {
        this.a.a(z);
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        ShimmerViewHelper shimmerViewHelper = this.a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.a(getCurrentTextColor());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        ShimmerViewHelper shimmerViewHelper = this.a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.a(getCurrentTextColor());
        }
    }
}
