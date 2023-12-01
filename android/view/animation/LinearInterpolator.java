package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;
import com.android.internal.view.animation.HasNativeInterpolator;
import com.android.internal.view.animation.NativeInterpolatorFactory;
import com.android.internal.view.animation.NativeInterpolatorFactoryHelper;

@HasNativeInterpolator
/* loaded from: source-4181928-dex2jar.jar:android/view/animation/LinearInterpolator.class */
public class LinearInterpolator extends BaseInterpolator implements NativeInterpolatorFactory {
    public LinearInterpolator() {
    }

    public LinearInterpolator(Context context, AttributeSet attributeSet) {
    }

    @Override // com.android.internal.view.animation.NativeInterpolatorFactory
    public long createNativeInterpolator() {
        return NativeInterpolatorFactoryHelper.createLinearInterpolator();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return f;
    }
}
