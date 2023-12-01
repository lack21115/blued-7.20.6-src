package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/AbstractFlow.class */
public abstract class AbstractFlow<T> implements CancellableFlow<T>, Flow<T> {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            r0 = r7
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.AbstractFlow$collect$1
            if (r0 == 0) goto L2b
            r0 = r7
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = (kotlinx.coroutines.flow.AbstractFlow$collect$1) r0
            r9 = r0
            r0 = r9
            int r0 = r0.d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r9
            r1 = r9
            int r1 = r1.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.d = r1
            r0 = r9
            r7 = r0
            goto L35
        L2b:
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = new kotlinx.coroutines.flow.AbstractFlow$collect$1
            r1 = r0
            r2 = r5
            r3 = r7
            r1.<init>(r2, r3)
            r7 = r0
        L35:
            r0 = r7
            java.lang.Object r0 = r0.b
            r10 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r9 = r0
            r0 = r7
            int r0 = r0.d
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L6c
            r0 = r8
            r1 = 1
            if (r0 != r1) goto L62
            r0 = r7
            java.lang.Object r0 = r0.f43043a
            kotlinx.coroutines.flow.internal.SafeCollector r0 = (kotlinx.coroutines.flow.internal.SafeCollector) r0
            r6 = r0
            r0 = r10
            kotlin.ResultKt.a(r0)     // Catch: java.lang.Throwable -> L5e
            goto La1
        L5e:
            r7 = move-exception
            goto Laa
        L62:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L6c:
            r0 = r10
            kotlin.ResultKt.a(r0)
            kotlinx.coroutines.flow.internal.SafeCollector r0 = new kotlinx.coroutines.flow.internal.SafeCollector
            r1 = r0
            r2 = r6
            r3 = r7
            kotlin.coroutines.CoroutineContext r3 = r3.getContext()
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0     // Catch: java.lang.Throwable -> La9
            r10 = r0
            r0 = r7
            r1 = r6
            r0.f43043a = r1     // Catch: java.lang.Throwable -> La9
            r0 = r7
            r1 = 1
            r0.d = r1     // Catch: java.lang.Throwable -> La9
            r0 = r5
            r1 = r10
            r2 = r7
            java.lang.Object r0 = r0.b(r1, r2)     // Catch: java.lang.Throwable -> La9
            r7 = r0
            r0 = r7
            r1 = r9
            if (r0 != r1) goto La1
            r0 = r9
            return r0
        La1:
            r0 = r6
            r0.releaseIntercepted()
            kotlin.Unit r0 = kotlin.Unit.f42314a
            return r0
        La9:
            r7 = move-exception
        Laa:
            r0 = r6
            r0.releaseIntercepted()
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.AbstractFlow.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object b(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);
}
