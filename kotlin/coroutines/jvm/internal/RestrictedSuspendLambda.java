package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/RestrictedSuspendLambda.class */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements SuspendFunction, FunctionBase<Object> {
    private final int arity;

    public RestrictedSuspendLambda(int i) {
        this(i, null);
    }

    public RestrictedSuspendLambda(int i, Continuation<Object> continuation) {
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
            String a2 = Reflection.a(this);
            Intrinsics.c(a2, "renderLambdaToString(this)");
            return a2;
        }
        return super.toString();
    }
}
