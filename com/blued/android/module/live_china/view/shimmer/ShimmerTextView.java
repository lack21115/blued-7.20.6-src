package com.blued.android.module.live_china.view.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.live_china.view.shimmer.ShimmerViewHelper;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/shimmer/ShimmerTextView.class */
public class ShimmerTextView extends AppCompatTextView implements ShimmerViewBase {

    /* renamed from: a  reason: collision with root package name */
    private ShimmerViewHelper f15458a;

    public ShimmerTextView(Context context) {
        super(context);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), null);
        this.f15458a = shimmerViewHelper;
        shimmerViewHelper.a(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f15458a = shimmerViewHelper;
        shimmerViewHelper.a(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ShimmerViewHelper shimmerViewHelper = new ShimmerViewHelper(this, getPaint(), attributeSet);
        this.f15458a = shimmerViewHelper;
        shimmerViewHelper.a(getCurrentTextColor());
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public boolean a() {
        return this.f15458a.b();
    }

    public float getGradientX() {
        return this.f15458a.a();
    }

    public int getPrimaryColor() {
        return this.f15458a.c();
    }

    public int getReflectionColor() {
        return this.f15458a.d();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        ShimmerViewHelper shimmerViewHelper = this.f15458a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.f();
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ShimmerViewHelper shimmerViewHelper = this.f15458a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.e();
        }
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback animationSetupCallback) {
        this.f15458a.a(animationSetupCallback);
    }

    public void setGradientX(float f) {
        this.f15458a.a(f);
    }

    public void setPrimaryColor(int i) {
        this.f15458a.a(i);
    }

    public void setReflectionColor(int i) {
        this.f15458a.b(i);
    }

    @Override // com.blued.android.module.live_china.view.shimmer.ShimmerViewBase
    public void setShimmering(boolean z) {
        this.f15458a.a(z);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        ShimmerViewHelper shimmerViewHelper = this.f15458a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.a(getCurrentTextColor());
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        ShimmerViewHelper shimmerViewHelper = this.f15458a;
        if (shimmerViewHelper != null) {
            shimmerViewHelper.a(getCurrentTextColor());
        }
    }
}
