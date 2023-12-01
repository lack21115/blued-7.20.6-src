package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(b = "Combine.kt", c = {57, 79, 82}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2.class */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f43478a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43479c;
    int d;
    int e;
    final /* synthetic */ Flow<T>[] f;
    final /* synthetic */ Function0<T[]> g;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> h;
    final /* synthetic */ FlowCollector<R> i;
    private /* synthetic */ Object j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "Combine.kt", c = {147}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f43480a;
        final /* synthetic */ Flow<T>[] b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f43481c;
        final /* synthetic */ AtomicInteger d;
        final /* synthetic */ Channel<IndexedValue<Object>> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T>[] flowArr, int i, AtomicInteger atomicInteger, Channel<IndexedValue<Object>> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.b = flowArr;
            this.f43481c = i;
            this.d = atomicInteger;
            this.e = channel;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.b, this.f43481c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicInteger atomicInteger;
            Object a2 = IntrinsicsKt.a();
            int i = this.f43480a;
            try {
                if (i == 0) {
                    ResultKt.a(obj);
                    this.f43480a = 1;
                    if (this.b[this.f43481c].a(new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this.e, this.f43481c), this) == a2) {
                        return a2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.a(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.a(this.e, null, 1, null);
                }
                return Unit.f42314a;
            } finally {
                if (this.d.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.a(this.e, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.f = flowArr;
        this.g = function0;
        this.h = function3;
        this.i = flowCollector;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.f, this.g, this.h, this.i, continuation);
        combineKt$combineInternal$2.j = obj;
        return combineKt$combineInternal$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d8 A[LOOP:0: B:36:0x01d8->B:59:0x030b, LOOP_START, PHI: r15 r16 r21 
      PHI: (r15v3 int) = (r15v2 int), (r15v6 int) binds: [B:33:0x01d1, B:59:0x030b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r16v3 int) = (r16v2 int), (r16v4 int) binds: [B:33:0x01d1, B:59:0x030b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r21v2 kotlin.collections.IndexedValue) = (r21v1 kotlin.collections.IndexedValue), (r21v7 kotlin.collections.IndexedValue) binds: [B:33:0x01d1, B:59:0x030b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Type inference failed for: r0v136, types: [int] */
    /* JADX WARN: Type inference failed for: r0v155, types: [int] */
    /* JADX WARN: Type inference failed for: r0v173, types: [int] */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.flow.Flow[], kotlinx.coroutines.flow.Flow<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0280 -> B:27:0x0161). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x02f5 -> B:57:0x02f0). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
