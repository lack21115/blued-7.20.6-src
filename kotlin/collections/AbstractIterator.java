package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractIterator.class */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    private State a = State.NotReady;
    private T b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractIterator$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.Done.ordinal()] = 1;
            iArr[State.Ready.ordinal()] = 2;
            a = iArr;
        }
    }

    private final boolean c() {
        this.a = State.Failed;
        a();
        return this.a == State.Ready;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(T t) {
        this.b = t;
        this.a = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.a = State.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z = false;
        if (this.a != State.Failed) {
            int i = WhenMappings.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return c();
                }
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.a = State.NotReady;
            return this.b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
