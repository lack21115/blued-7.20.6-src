package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ReduceKt$reduce$$inlined$collect$1.class */
public final class FlowKt__ReduceKt$reduce$$inlined$collect$1<T> implements FlowCollector<T> {
    final /* synthetic */ Ref.ObjectRef a;
    final /* synthetic */ Function3 b;

    @Metadata
    @DebugMetadata(b = "Reduce.kt", c = {137}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ReduceKt$reduce$$inlined$collect$1$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {
        /* synthetic */ Object a;
        int b;
        Object d;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$reduce$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__ReduceKt$reduce$$inlined$collect$1(Ref.ObjectRef objectRef, Function3 function3) {
        this.a = objectRef;
        this.b = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
