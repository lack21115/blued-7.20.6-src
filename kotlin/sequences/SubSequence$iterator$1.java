package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/sequences/SubSequence$iterator$1.class */
public final class SubSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SubSequence<T> f42697a;
    private final Iterator<T> b;

    /* renamed from: c  reason: collision with root package name */
    private int f42698c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubSequence$iterator$1(SubSequence<T> subSequence) {
        Sequence sequence;
        this.f42697a = subSequence;
        sequence = ((SubSequence) subSequence).f42695a;
        this.b = sequence.iterator();
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a() {
        /*
            r4 = this;
        L0:
            r0 = r4
            int r0 = r0.f42698c
            r1 = r4
            kotlin.sequences.SubSequence<T> r1 = r1.f42697a
            int r1 = kotlin.sequences.SubSequence.b(r1)
            if (r0 >= r1) goto L31
            r0 = r4
            java.util.Iterator<T> r0 = r0.b
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L31
            r0 = r4
            java.util.Iterator<T> r0 = r0.b
            java.lang.Object r0 = r0.next()
            r0 = r4
            r1 = r4
            int r1 = r1.f42698c
            r2 = 1
            int r1 = r1 + r2
            r0.f42698c = r1
            goto L0
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SubSequence$iterator$1.a():void");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        a();
        int i2 = this.f42698c;
        i = ((SubSequence) this.f42697a).f42696c;
        return i2 < i && this.b.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        int i;
        a();
        int i2 = this.f42698c;
        i = ((SubSequence) this.f42697a).f42696c;
        if (i2 < i) {
            this.f42698c++;
            return this.b.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
