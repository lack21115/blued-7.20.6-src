package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractIterator.class */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    private State f42322a = State.NotReady;
    private T b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractIterator$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42323a;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.Done.ordinal()] = 1;
            iArr[State.Ready.ordinal()] = 2;
            f42323a = iArr;
        }
    }

    private final boolean c() {
        this.f42322a = State.Failed;
        a();
        return this.f42322a == State.Ready;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(T t) {
        this.b = t;
        this.f42322a = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.f42322a = State.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z = false;
        if (this.f42322a != State.Failed) {
            int i = WhenMappings.f42323a[this.f42322a.ordinal()];
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
            this.f42322a = State.NotReady;
            return this.b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
