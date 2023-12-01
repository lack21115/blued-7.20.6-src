package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Await.kt", c = {54}, d = "joinAll", e = "kotlinx.coroutines.AwaitKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/AwaitKt$joinAll$1.class */
public final class AwaitKt$joinAll$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f42779a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f42780c;
    /* synthetic */ Object d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AwaitKt$joinAll$1(Continuation<? super AwaitKt$joinAll$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        return AwaitKt.a((Job[]) null, this);
    }
}
