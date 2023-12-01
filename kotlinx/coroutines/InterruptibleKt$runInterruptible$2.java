package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Interruptible.kt", c = {}, d = "invokeSuspend", e = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/InterruptibleKt$runInterruptible$2.class */
final class InterruptibleKt$runInterruptible$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f42830a;
    final /* synthetic */ Function0<T> b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Object f42831c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    InterruptibleKt$runInterruptible$2(Function0<? extends T> function0, Continuation<? super InterruptibleKt$runInterruptible$2> continuation) {
        super(2, continuation);
        this.b = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((InterruptibleKt$runInterruptible$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.b, continuation);
        interruptibleKt$runInterruptible$2.f42831c = obj;
        return interruptibleKt$runInterruptible$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b;
        IntrinsicsKt.a();
        if (this.f42830a == 0) {
            ResultKt.a(obj);
            b = InterruptibleKt.b(((CoroutineScope) this.f42831c).getCoroutineContext(), this.b);
            return b;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
