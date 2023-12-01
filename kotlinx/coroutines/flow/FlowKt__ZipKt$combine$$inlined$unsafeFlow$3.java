package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.class */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3<R> implements Flow<R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow[] f43354a;
    final /* synthetic */ Function2 b;

    @Metadata
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43355a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 f43356c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43355a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.f43356c.a(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Flow[] flowArr = this.f43354a;
        Intrinsics.d();
        final Flow[] flowArr2 = this.f43354a;
        Object a2 = CombineKt.a(flowCollector, flowArr, new Function0<T[]>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final T[] invoke() {
                int length = flowArr2.length;
                Intrinsics.a(0, "T?");
                return (T[]) new Object[length];
            }
        }, new FlowKt__ZipKt$combine$6$2(this.b, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
