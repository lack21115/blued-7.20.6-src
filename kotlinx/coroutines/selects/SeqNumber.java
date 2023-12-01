package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/SeqNumber.class */
public final class SeqNumber {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f43600a = AtomicLongFieldUpdater.newUpdater(SeqNumber.class, "number");
    private volatile /* synthetic */ long number = 1;

    public final long a() {
        return f43600a.incrementAndGet(this);
    }
}
