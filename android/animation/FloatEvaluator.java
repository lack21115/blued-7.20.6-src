package android.animation;

/* loaded from: source-9557208-dex2jar.jar:android/animation/FloatEvaluator.class */
public class FloatEvaluator implements TypeEvaluator<Number> {
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(((number2.floatValue() - floatValue) * f) + floatValue);
    }
}
