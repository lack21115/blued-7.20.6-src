package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ranges/IntProgressionIterator.class */
public final class IntProgressionIterator extends IntIterator {

    /* renamed from: a  reason: collision with root package name */
    private final int f42578a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42579c;
    private int d;

    public IntProgressionIterator(int i, int i2, int i3) {
        this.f42578a = i3;
        this.b = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f42579c = z;
        this.d = z ? i : this.b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f42579c;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.f42578a + i;
            return i;
        } else if (this.f42579c) {
            this.f42579c = false;
            return i;
        } else {
            throw new NoSuchElementException();
        }
    }
}
