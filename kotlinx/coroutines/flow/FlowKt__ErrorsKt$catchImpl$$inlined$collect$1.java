package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.class */
public final class FlowKt__ErrorsKt$catchImpl$$inlined$collect$1<T> implements FlowCollector<T> {
    final /* synthetic */ FlowCollector a;
    final /* synthetic */ Ref.ObjectRef b;

    @Metadata
    @DebugMetadata(b = "Errors.kt", c = {136}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1.class */
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
            return FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__ErrorsKt$catchImpl$$inlined$collect$1(FlowCollector flowCollector, Ref.ObjectRef objectRef) {
        this.a = flowCollector;
        this.b = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            r0 = r7
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L2b
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.AnonymousClass1) r0
            r9 = r0
            r0 = r9
            int r0 = r0.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r9
            r1 = r9
            int r1 = r1.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.b = r1
            r0 = r9
            r7 = r0
            goto L35
        L2b:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1
            r1 = r0
            r2 = r5
            r3 = r7
            r1.<init>(r3)
            r7 = r0
        L35:
            r0 = r7
            java.lang.Object r0 = r0.a
            r10 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r9 = r0
            r0 = r7
            int r0 = r0.b
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L6c
            r0 = r8
            r1 = 1
            if (r0 != r1) goto L62
            r0 = r7
            java.lang.Object r0 = r0.d
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1) r0
            r6 = r0
            r0 = r10
            kotlin.ResultKt.a(r0)     // Catch: java.lang.Throwable -> L5e
            goto L9a
        L5e:
            r7 = move-exception
            goto La1
        L62:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L6c:
            r0 = r10
            kotlin.ResultKt.a(r0)
            r0 = r7
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r10 = r0
            r0 = r5
            kotlinx.coroutines.flow.FlowCollector r0 = r0.a     // Catch: java.lang.Throwable -> L9e
            r10 = r0
            r0 = r7
            r1 = r5
            r0.d = r1     // Catch: java.lang.Throwable -> L9e
            r0 = r7
            r1 = 1
            r0.b = r1     // Catch: java.lang.Throwable -> L9e
            r0 = r10
            r1 = r6
            r2 = r7
            java.lang.Object r0 = r0.emit(r1, r2)     // Catch: java.lang.Throwable -> L9e
            r6 = r0
            r0 = r6
            r1 = r9
            if (r0 != r1) goto L9a
            r0 = r9
            return r0
        L9a:
            kotlin.Unit r0 = kotlin.Unit.a
            return r0
        L9e:
            r7 = move-exception
            r0 = r5
            r6 = r0
        La1:
            r0 = r6
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.b
            r1 = r7
            r0.a = r1
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
