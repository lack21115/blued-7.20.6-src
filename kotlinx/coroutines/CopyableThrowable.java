package kotlinx.coroutines;

import java.lang.Throwable;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CopyableThrowable.class */
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    T a();
}
