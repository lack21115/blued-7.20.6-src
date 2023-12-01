package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.class */
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1<R> implements Flow<R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow[] f43377a;
    final /* synthetic */ Function2 b;

    @Metadata
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43378a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1 f43379c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43378a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.f43379c.a(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Function0 b;
        Flow[] flowArr = this.f43377a;
        b = FlowKt__ZipKt.b();
        Object a2 = CombineKt.a(flowCollector, flowArr, b, new FlowKt__ZipKt$combineUnsafe$1$1(this.b, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
