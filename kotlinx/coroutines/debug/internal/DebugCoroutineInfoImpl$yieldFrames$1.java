package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "DebugCoroutineInfoImpl.kt", c = {80}, d = "yieldFrames", e = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl$yieldFrames$1.class */
public final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {
    Object a;
    Object b;
    Object c;
    /* synthetic */ Object d;
    final /* synthetic */ DebugCoroutineInfoImpl e;
    int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$yieldFrames$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, Continuation<? super DebugCoroutineInfoImpl$yieldFrames$1> continuation) {
        super(continuation);
        this.e = debugCoroutineInfoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a;
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        a = this.e.a(null, null, this);
        return a;
    }
}
