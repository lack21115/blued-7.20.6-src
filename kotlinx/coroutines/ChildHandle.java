package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildHandle.class */
public interface ChildHandle extends DisposableHandle {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildHandle$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    Job a();

    boolean b(Throwable th);
}
