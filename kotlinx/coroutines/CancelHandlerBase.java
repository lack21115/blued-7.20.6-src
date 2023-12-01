package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancelHandlerBase.class */
public abstract class CancelHandlerBase implements Function1<Throwable, Unit> {
    public abstract void a(Throwable th);
}
