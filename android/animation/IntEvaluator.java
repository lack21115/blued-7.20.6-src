package android.animation;

/* loaded from: source-9557208-dex2jar.jar:android/animation/IntEvaluator.class */
public class IntEvaluator implements TypeEvaluator<Integer> {
    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (intValue + ((num2.intValue() - intValue) * f)));
    }
}
