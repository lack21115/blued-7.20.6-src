package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KFunction;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/FunInterfaceConstructorReference.class */
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class a;

    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FunInterfaceConstructorReference) {
            return this.a.equals(((FunInterfaceConstructorReference) obj).a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return "fun interface " + this.a.getName();
    }
}
