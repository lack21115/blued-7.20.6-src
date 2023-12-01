package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/LongProgressionIterator.class */
public final class LongProgressionIterator extends LongIterator {

    /* renamed from: a  reason: collision with root package name */
    private final long f42583a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42584c;
    private long d;

    public LongProgressionIterator(long j, long j2, long j3) {
        this.f42583a = j3;
        this.b = j2;
        boolean z = true;
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (j3 <= 0 ? i < 0 : i > 0) {
            z = false;
        }
        this.f42584c = z;
        this.d = z ? j : this.b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f42584c;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long j = this.d;
        if (j != this.b) {
            this.d = this.f42583a + j;
            return j;
        } else if (this.f42584c) {
            this.f42584c = false;
            return j;
        } else {
            throw new NoSuchElementException();
        }
    }
}
