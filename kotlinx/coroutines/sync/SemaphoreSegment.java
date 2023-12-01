package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/SemaphoreSegment.class */
public final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    /* synthetic */ AtomicReferenceArray a;

    public SemaphoreSegment(long j, SemaphoreSegment semaphoreSegment, int i) {
        super(j, semaphoreSegment, i);
        int i2;
        i2 = SemaphoreKt.f;
        this.a = new AtomicReferenceArray(i2);
    }

    public final void a(int i) {
        Symbol symbol;
        symbol = SemaphoreKt.e;
        this.a.set(i, symbol);
        k();
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int h() {
        int i;
        i = SemaphoreKt.f;
        return i;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + g() + ", hashCode=" + hashCode() + ']';
    }
}
