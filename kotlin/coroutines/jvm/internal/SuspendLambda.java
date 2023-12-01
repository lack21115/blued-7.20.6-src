package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/SuspendLambda.class */
public abstract class SuspendLambda extends ContinuationImpl implements SuspendFunction, FunctionBase<Object> {
    private final int arity;

    public SuspendLambda(int i) {
        this(i, null);
    }

    public SuspendLambda(int i, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            String a = Reflection.a(this);
            Intrinsics.c(a, "renderLambdaToString(this)");
            return a;
        }
        return super.toString();
    }
}
