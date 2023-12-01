package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/EmittedSource.class */
public final class EmittedSource implements DisposableHandle {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        Intrinsics.e(liveData, "source");
        Intrinsics.e(mediatorLiveData, "mediator");
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    public void dispose() {
        BuildersKt.a(CoroutineScopeKt.a(Dispatchers.b().a()), (CoroutineContext) null, (CoroutineStart) null, new EmittedSource$dispose$1(this, null), 3, (Object) null);
    }

    public final Object disposeNow(Continuation<? super Unit> continuation) {
        Object a2 = BuildersKt.a(Dispatchers.b().a(), new EmittedSource$disposeNow$2(this, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.a;
    }
}
