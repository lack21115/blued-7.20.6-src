package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Mutex.kt", c = {114}, d = "withLock", e = "kotlinx.coroutines.sync.MutexKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/MutexKt$withLock$1.class */
public final class MutexKt$withLock$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43632a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    Object f43633c;
    /* synthetic */ Object d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        return MutexKt.a(null, null, null, this);
    }
}
