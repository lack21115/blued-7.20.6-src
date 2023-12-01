package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/SupervisorCoroutine.class */
final class SupervisorCoroutine<T> extends ScopeCoroutine<T> {
    @Override // kotlinx.coroutines.JobSupport
    public boolean c(Throwable th) {
        return false;
    }
}
