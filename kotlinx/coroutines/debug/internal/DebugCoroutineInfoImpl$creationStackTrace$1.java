package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata
@DebugMetadata(b = "DebugCoroutineInfoImpl.kt", c = {75}, d = "invokeSuspend", e = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl$creationStackTrace$1.class */
final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43030a;
    final /* synthetic */ DebugCoroutineInfoImpl b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ StackTraceFrame f43031c;
    private /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DebugCoroutineInfoImpl$creationStackTrace$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, StackTraceFrame stackTraceFrame, Continuation<? super DebugCoroutineInfoImpl$creationStackTrace$1> continuation) {
        super(2, continuation);
        this.b = debugCoroutineInfoImpl;
        this.f43031c = stackTraceFrame;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(SequenceScope<? super StackTraceElement> sequenceScope, Continuation<? super Unit> continuation) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1(this.b, this.f43031c, continuation);
        debugCoroutineInfoImpl$creationStackTrace$1.d = obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f43030a;
        if (i == 0) {
            ResultKt.a(obj);
            SequenceScope sequenceScope = (SequenceScope) this.d;
            this.f43030a = 1;
            a2 = this.b.a(sequenceScope, this.f43031c.getCallerFrame(), this);
            if (a2 == a3) {
                return a3;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.f42314a;
    }
}
