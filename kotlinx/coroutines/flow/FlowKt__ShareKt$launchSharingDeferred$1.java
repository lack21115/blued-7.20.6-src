package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

@Metadata
@DebugMetadata(b = "Share.kt", c = {418}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1.class */
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43285a;
    final /* synthetic */ Flow<T> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CompletableDeferred<StateFlow<T>> f43286c;
    private /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ShareKt$launchSharingDeferred$1(Flow<? extends T> flow, CompletableDeferred<StateFlow<T>> completableDeferred, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.b = flow;
        this.f43286c = completableDeferred;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.b, this.f43286c, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.d = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f43285a;
        try {
            if (i == 0) {
                ResultKt.a(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.d;
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Flow<T> flow = this.b;
                final CompletableDeferred<StateFlow<T>> completableDeferred = this.f43286c;
                this.f43285a = 1;
                if (flow.a(new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T t, Continuation<? super Unit> continuation) {
                        Unit unit;
                        MutableStateFlow mutableStateFlow = (MutableStateFlow) Ref.ObjectRef.this.f42545a;
                        if (mutableStateFlow == null) {
                            unit = null;
                        } else {
                            mutableStateFlow.b(t);
                            unit = Unit.f42314a;
                        }
                        if (unit == null) {
                            CoroutineScope coroutineScope2 = coroutineScope;
                            Ref.ObjectRef objectRef2 = Ref.ObjectRef.this;
                            T t2 = (T) StateFlowKt.a(t);
                            completableDeferred.a((CompletableDeferred) new ReadonlyStateFlow((StateFlow) t2, JobKt.b(coroutineScope2.getCoroutineContext())));
                            Unit unit2 = Unit.f42314a;
                            objectRef2.f42545a = t2;
                        }
                        return Unit.f42314a;
                    }
                }, this) == a2) {
                    return a2;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.a(obj);
            }
            return Unit.f42314a;
        } catch (Throwable th) {
            this.f43286c.a(th);
            throw th;
        }
    }
}
