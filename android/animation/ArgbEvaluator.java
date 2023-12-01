package android.animation;

/* loaded from: source-9557208-dex2jar.jar:android/animation/ArgbEvaluator.class */
public class ArgbEvaluator implements TypeEvaluator {
    private static final ArgbEvaluator sInstance = new ArgbEvaluator();

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i = (intValue >> 24) & 255;
        int i2 = (intValue >> 16) & 255;
        int i3 = (intValue >> 8) & 255;
        int i4 = intValue & 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((((int) ((((intValue2 >> 24) & 255) - i) * f)) + i) << 24) | ((((int) ((((intValue2 >> 16) & 255) - i2) * f)) + i2) << 16) | ((((int) ((((intValue2 >> 8) & 255) - i3) * f)) + i3) << 8) | (((int) (((intValue2 & 255) - i4) * f)) + i4));
    }
}
