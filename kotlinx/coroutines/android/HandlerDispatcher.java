package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/android/HandlerDispatcher.class */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    private HandlerDispatcher() {
    }

    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public DisposableHandle a(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(this, j, runnable, coroutineContext);
    }
}
