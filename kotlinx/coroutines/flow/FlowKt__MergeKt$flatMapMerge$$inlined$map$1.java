package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapMerge$$inlined$map$1.class */
public final class FlowKt__MergeKt$flatMapMerge$$inlined$map$1<R> implements Flow<Flow<? extends R>> {
    final /* synthetic */ Flow a;
    final /* synthetic */ Function2 b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2.class */
    public static final class AnonymousClass2<T> implements FlowCollector<T> {
        final /* synthetic */ FlowCollector a;
        final /* synthetic */ Function2 b;

        @Metadata
        @DebugMetadata(b = "Merge.kt", c = {136, 136}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2")
        /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1  reason: invalid class name */
        /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1.class */
        public static final class AnonymousClass1 extends ContinuationImpl {
            /* synthetic */ Object a;
            int b;
            Object c;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
            this.a = flowCollector;
            this.b = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
            /*
                r5 = this;
                r0 = r7
                boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L2b
                r0 = r7
                kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
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
                kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1
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
                r11 = r0
                r0 = r7
                int r0 = r0.b
                r8 = r0
                r0 = r8
                if (r0 == 0) goto L79
                r0 = r8
                r1 = 1
                if (r0 == r1) goto L65
                r0 = r8
                r1 = 2
                if (r0 != r1) goto L5b
                r0 = r10
                kotlin.ResultKt.a(r0)
                goto Lc3
            L5b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r0
            L65:
                r0 = r7
                java.lang.Object r0 = r0.c
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                r9 = r0
                r0 = r10
                kotlin.ResultKt.a(r0)
                r0 = r10
                r6 = r0
                goto La8
            L79:
                r0 = r10
                kotlin.ResultKt.a(r0)
                r0 = r5
                kotlinx.coroutines.flow.FlowCollector r0 = r0.a
                r9 = r0
                r0 = r5
                kotlin.jvm.functions.Function2 r0 = r0.b
                r10 = r0
                r0 = r7
                r1 = r9
                r0.c = r1
                r0 = r7
                r1 = 1
                r0.b = r1
                r0 = r10
                r1 = r6
                r2 = r7
                java.lang.Object r0 = r0.invoke(r1, r2)
                r6 = r0
                r0 = r6
                r1 = r11
                if (r0 != r1) goto La8
                r0 = r11
                return r0
            La8:
                r0 = r7
                r1 = 0
                r0.c = r1
                r0 = r7
                r1 = 2
                r0.b = r1
                r0 = r9
                r1 = r6
                r2 = r7
                java.lang.Object r0 = r0.emit(r1, r2)
                r1 = r11
                if (r0 != r1) goto Lc3
                r0 = r11
                return r0
            Lc3:
                kotlin.Unit r0 = kotlin.Unit.a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector flowCollector, Continuation continuation) {
        Object a = this.a.a(new AnonymousClass2(flowCollector, this.b), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
