package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildJob.class */
public interface ChildJob extends Job {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildJob$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    void a(ParentJob parentJob);
}
