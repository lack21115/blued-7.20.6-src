package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/MutablePropertyReference0.class */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    @Override // kotlin.reflect.KProperty0
    public KProperty0.Getter b() {
        return ((KMutableProperty0) getReflected()).b();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.a(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return a();
    }
}
