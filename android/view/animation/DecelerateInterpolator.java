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
/* loaded from: source-4181928-dex2jar.jar:android/view/animation/DecelerateInterpolator.class */
public class DecelerateInterpolator extends BaseInterpolator implements NativeInterpolatorFactory {
    private float mFactor;

    public DecelerateInterpolator() {
        this.mFactor = 1.0f;
    }

    public DecelerateInterpolator(float f) {
        this.mFactor = 1.0f;
        this.mFactor = f;
    }

    public DecelerateInterpolator(Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public DecelerateInterpolator(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        this.mFactor = 1.0f;
        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.DecelerateInterpolator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.DecelerateInterpolator);
        this.mFactor = obtainStyledAttributes.getFloat(0, 1.0f);
        setChangingConfiguration(obtainStyledAttributes.getChangingConfigurations());
        obtainStyledAttributes.recycle();
    }

    @Override // com.android.internal.view.animation.NativeInterpolatorFactory
    public long createNativeInterpolator() {
        return NativeInterpolatorFactoryHelper.createDecelerateInterpolator(this.mFactor);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.mFactor == 1.0f ? 1.0f - ((1.0f - f) * (1.0f - f)) : (float) (1.0d - Math.pow(1.0f - f, 2.0f * this.mFactor));
    }
}
