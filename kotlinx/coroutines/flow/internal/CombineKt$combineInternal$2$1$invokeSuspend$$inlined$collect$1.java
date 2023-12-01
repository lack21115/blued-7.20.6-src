package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.class */
public final class CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1<T> implements FlowCollector<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Channel f43470a;
    final /* synthetic */ int b;

    @Metadata
    @DebugMetadata(b = "Combine.kt", c = {135, 136}, d = "emit", e = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43471a;
        int b;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43471a = obj;
            this.b |= Integer.MIN_VALUE;
            return CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(Channel channel, int i) {
        this.f43470a = channel;
        this.b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            r0 = r7
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L2b
            r0 = r7
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
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
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1
            r1 = r0
            r2 = r5
            r3 = r7
            r1.<init>(r3)
            r7 = r0
        L35:
            r0 = r7
            java.lang.Object r0 = r0.f43471a
            r10 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r9 = r0
            r0 = r7
            int r0 = r0.b
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L6d
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L65
            r0 = r8
            r1 = 2
            if (r0 != r1) goto L5b
            r0 = r10
            kotlin.ResultKt.a(r0)
            goto Lb2
        L5b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L65:
            r0 = r10
            kotlin.ResultKt.a(r0)
            goto La1
        L6d:
            r0 = r10
            kotlin.ResultKt.a(r0)
            r0 = r7
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r10 = r0
            r0 = r5
            kotlinx.coroutines.channels.Channel r0 = r0.f43470a
            r10 = r0
            kotlin.collections.IndexedValue r0 = new kotlin.collections.IndexedValue
            r1 = r0
            r2 = r5
            int r2 = r2.b
            r3 = r6
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r7
            r1 = 1
            r0.b = r1
            r0 = r10
            r1 = r6
            r2 = r7
            java.lang.Object r0 = r0.a(r1, r2)
            r1 = r9
            if (r0 != r1) goto La1
            r0 = r9
            return r0
        La1:
            r0 = r7
            r1 = 2
            r0.b = r1
            r0 = r7
            java.lang.Object r0 = kotlinx.coroutines.YieldKt.a(r0)
            r1 = r9
            if (r0 != r1) goto Lb2
            r0 = r9
            return r0
        Lb2:
            kotlin.Unit r0 = kotlin.Unit.f42314a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
