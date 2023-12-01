package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Delay.kt", c = {155}, d = "awaitCancellation", e = "kotlinx.coroutines.DelayKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DelayKt$awaitCancellation$1.class */
public final class DelayKt$awaitCancellation$1 extends ContinuationImpl {
    /* synthetic */ Object a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelayKt$awaitCancellation$1(Continuation<? super DelayKt$awaitCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return DelayKt.a(this);
    }
}
