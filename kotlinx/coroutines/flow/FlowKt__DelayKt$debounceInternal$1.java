package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Delay.kt", c = {224, 358}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1.class */
final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f43122a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43123c;
    /* synthetic */ Object d;
    final /* synthetic */ Function1<T, Long> e;
    final /* synthetic */ Flow<T> f;
    private /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.e = function1;
        this.f = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object a(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return a(coroutineScope, (FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object a(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.e, this.f, continuation);
        flowKt__DelayKt$debounceInternal$1.g = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.d = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.f42314a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:68|30|34|(4:36|(1:45)(1:40)|41|(2:43|44))|46|47|48|(1:50)|51|52|53|(1:55)|56|(2:58|59)(1:60)) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x02a1, code lost:
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02a3, code lost:
        r0.b(r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0266 A[Catch: all -> 0x02a1, TryCatch #0 {all -> 0x02a1, blocks: (B:54:0x0257, B:56:0x0266, B:58:0x0283), top: B:72:0x0257 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02c7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x02c7 -> B:13:0x00c8). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
