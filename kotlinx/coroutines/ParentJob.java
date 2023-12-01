package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ParentJob.class */
public interface ParentJob extends Job {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ParentJob$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    CancellationException n();
}
