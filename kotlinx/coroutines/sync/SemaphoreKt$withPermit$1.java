package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Semaphore.kt", c = {85}, d = "withPermit", e = "kotlinx.coroutines.sync.SemaphoreKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/SemaphoreKt$withPermit$1.class */
public final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43639a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f43640c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f43640c = obj;
        this.d |= Integer.MIN_VALUE;
        return SemaphoreKt.a(null, null, this);
    }
}
