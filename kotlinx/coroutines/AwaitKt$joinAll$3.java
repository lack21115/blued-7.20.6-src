package kotlinx.coroutines;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Await.kt", c = {66}, d = "joinAll", e = "kotlinx.coroutines.AwaitKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/AwaitKt$joinAll$3.class */
public final class AwaitKt$joinAll$3 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f42781a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f42782c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AwaitKt$joinAll$3(Continuation<? super AwaitKt$joinAll$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.f42782c |= Integer.MIN_VALUE;
        return AwaitKt.a((Collection<? extends Job>) null, this);
    }
}
