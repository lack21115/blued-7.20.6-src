package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/Segment.class */
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");

    /* renamed from: a  reason: collision with root package name */
    private final long f43560a;
    private volatile /* synthetic */ int cleanedAndPointers;

    public Segment(long j, S s, int i) {
        super(s);
        this.f43560a = j;
        this.cleanedAndPointers = i << 16;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean e() {
        return this.cleanedAndPointers == h() && !b();
    }

    public final long g() {
        return this.f43560a;
    }

    public abstract int h();

    public final boolean i() {
        int i;
        do {
            i = this.cleanedAndPointers;
            if (!(i != h() || b())) {
                return false;
            }
        } while (!b.compareAndSet(this, i, 65536 + i));
        return true;
    }

    public final boolean j() {
        return b.addAndGet(this, -65536) == h() && !b();
    }

    public final void k() {
        if (b.incrementAndGet(this) != h() || b()) {
            return;
        }
        f();
    }
}
