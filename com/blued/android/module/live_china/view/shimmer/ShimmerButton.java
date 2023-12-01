package com.blued.android.module.live_china.view.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.blued.android.module.live_china.view.shimmer.ShimmerViewHelper;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/shimmer/ShimmerButton.class */
public class ShimmerButton extends AppCompatButton implements ShimmerViewBase {

    /* renamed from: a  reason: collision with root package name */
    private ShimmerViewHelper f15457a;

    public ShimmerButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f15457a = shimmerViewHelper;
        shimmerViewHelper.a(getCurrentTextColor());
    }

    public ShimmerButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f15457a = shimmerViewHelper;
        shimmerViewHelper.a(getCurrentTextColor());
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public boolean a() {
        return this.f15457a.b();
    }

    public float getGradientX() {
        return this.f15457a.a();
    }

    public int getPrimaryColor() {
        return this.f15457a.c();
    }

    public int getReflectionColor() {
        return this.f15457a.d();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        ShimmerViewHelper shimmerViewHelper = this.f15457a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.f();
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ShimmerViewHelper shimmerViewHelper = this.f15457a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.e();
        }
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback animationSetupCallback) {
        this.f15457a.a(animationSetupCallback);
    }

    public void setGradientX(float f) {
        this.f15457a.a(f);
    }

    public void setPrimaryColor(int i) {
        this.f15457a.a(i);
    }

    public void setReflectionColor(int i) {
        this.f15457a.b(i);
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public void setShimmering(boolean z) {
        this.f15457a.a(z);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        ShimmerViewHelper shimmerViewHelper = this.f15457a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.a(getCurrentTextColor());
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        ShimmerViewHelper shimmerViewHelper = this.f15457a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.a(getCurrentTextColor());
        }
    }
}
