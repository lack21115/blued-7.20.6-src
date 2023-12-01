package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Semaphore;

@Metadata
@DebugMetadata(b = "Merge.kt", c = {69}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/ChannelFlowMerge$collectTo$2$1.class */
final class ChannelFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43456a;
    final /* synthetic */ Flow<T> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SendingCollector<T> f43457c;
    final /* synthetic */ Semaphore d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2$1(Flow<? extends T> flow, SendingCollector<T> sendingCollector, Semaphore semaphore, Continuation<? super ChannelFlowMerge$collectTo$2$1> continuation) {
        super(2, continuation);
        this.b = flow;
        this.f43457c = sendingCollector;
        this.d = semaphore;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChannelFlowMerge$collectTo$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChannelFlowMerge$collectTo$2$1(this.b, this.f43457c, this.d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43456a;
        try {
            if (i == 0) {
                ResultKt.a(obj);
                this.f43456a = 1;
                if (this.b.a(this.f43457c, this) == a2) {
                    return a2;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.a(obj);
            }
            this.d.a();
            return Unit.f42314a;
        } catch (Throwable th) {
            this.d.a();
            throw th;
        }
    }
}
