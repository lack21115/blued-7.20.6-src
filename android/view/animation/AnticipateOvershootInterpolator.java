package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.android.internal.R;
import com.android.internal.view.animation.HasNativeInterpolator;
import com.android.internal.view.animation.NativeInterpolatorFactory;
import com.android.internal.view.animation.NativeInterpolatorFactoryHelper;

@HasNativeInterpolator
/* loaded from: source-4181928-dex2jar.jar:android/view/animation/AnticipateOvershootInterpolator.class */
public class AnticipateOvershootInterpolator extends BaseInterpolator implements NativeInterpolatorFactory {
    private final float mTension;

    public AnticipateOvershootInterpolator() {
        this.mTension = 3.0f;
    }

    public AnticipateOvershootInterpolator(float f) {
        this.mTension = 1.5f * f;
    }

    public AnticipateOvershootInterpolator(float f, float f2) {
        this.mTension = f * f2;
    }

    public AnticipateOvershootInterpolator(Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public AnticipateOvershootInterpolator(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.AnticipateOvershootInterpolator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.AnticipateOvershootInterpolator);
        this.mTension = obtainStyledAttributes.getFloat(0, 2.0f) * obtainStyledAttributes.getFloat(1, 1.5f);
        setChangingConfiguration(obtainStyledAttributes.getChangingConfigurations());
        obtainStyledAttributes.recycle();
    }

    private static float a(float f, float f2) {
        return f * f * (((1.0f + f2) * f) - f2);
    }

    private static float o(float f, float f2) {
        return f * f * (((1.0f + f2) * f) + f2);
    }

    @Override // com.android.internal.view.animation.NativeInterpolatorFactory
    public long createNativeInterpolator() {
        return NativeInterpolatorFactoryHelper.createAnticipateOvershootInterpolator(this.mTension);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return f < 0.5f ? a(f * 2.0f, this.mTension) * 0.5f : (o((f * 2.0f) - 2.0f, this.mTension) + 2.0f) * 0.5f;
    }
}
