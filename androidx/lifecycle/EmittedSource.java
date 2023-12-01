package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/EmittedSource.class */
public final class EmittedSource implements DisposableHandle {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(LiveData<?> source, MediatorLiveData<?> mediator) {
        Intrinsics.e(source, "source");
        Intrinsics.e(mediator, "mediator");
        this.source = source;
        this.mediator = mediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        BuildersKt.a(CoroutineScopeKt.a(Dispatchers.b().a()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    public final Object disposeNow(Continuation<? super Unit> continuation) {
        Object a2 = BuildersKt.a(Dispatchers.b().a(), new EmittedSource$disposeNow$2(this, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
