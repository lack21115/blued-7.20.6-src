package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/view/animation/AlphaAnimation.class */
public class AlphaAnimation extends Animation {
    private float mFromAlpha;
    private float mToAlpha;

    public AlphaAnimation(float f, float f2) {
        this.mFromAlpha = f;
        this.mToAlpha = f2;
    }

    public AlphaAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AlphaAnimation);
        this.mFromAlpha = obtainStyledAttributes.getFloat(0, 1.0f);
        this.mToAlpha = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromAlpha;
        transformation.setAlpha(((this.mToAlpha - f2) * f) + f2);
    }

    @Override // android.view.animation.Animation
    public boolean hasAlpha() {
        return true;
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return false;
    }

    @Override // android.view.animation.Animation
    public boolean willChangeTransformationMatrix() {
        return false;
    }
}
