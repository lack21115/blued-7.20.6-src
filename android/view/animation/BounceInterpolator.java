package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;
import com.android.internal.view.animation.HasNativeInterpolator;
import com.android.internal.view.animation.NativeInterpolatorFactory;
import com.android.internal.view.animation.NativeInterpolatorFactoryHelper;

@HasNativeInterpolator
/* loaded from: source-4181928-dex2jar.jar:android/view/animation/BounceInterpolator.class */
public class BounceInterpolator extends BaseInterpolator implements NativeInterpolatorFactory {
    public BounceInterpolator() {
    }

    public BounceInterpolator(Context context, AttributeSet attributeSet) {
    }

    private static float bounce(float f) {
        return f * f * 8.0f;
    }

    @Override // com.android.internal.view.animation.NativeInterpolatorFactory
    public long createNativeInterpolator() {
        return NativeInterpolatorFactoryHelper.createBounceInterpolator();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f * 1.1226f;
        return f2 < 0.3535f ? bounce(f2) : f2 < 0.7408f ? bounce(f2 - 0.54719f) + 0.7f : f2 < 0.9644f ? bounce(f2 - 0.8526f) + 0.9f : bounce(f2 - 1.0435f) + 0.95f;
    }
}
