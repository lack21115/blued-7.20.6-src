package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Lambda.class */
public abstract class Lambda<R> implements Serializable, FunctionBase<R> {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String a = Reflection.a((Lambda) this);
        Intrinsics.c(a, "renderLambdaToString(this)");
        return a;
    }
}
