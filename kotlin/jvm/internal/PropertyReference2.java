package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/PropertyReference2.class */
public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    @Override // kotlin.reflect.KProperty2
    public KProperty2.Getter a() {
        return ((KProperty2) getReflected()).a();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.a(this);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return a(obj, obj2);
    }
}
