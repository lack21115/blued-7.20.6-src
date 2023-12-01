package libcore.util;

import java.lang.ref.Reference;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:libcore/util/CollectionUtils.class */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> Iterable<T> dereferenceIterable(final Iterable<? extends Reference<T>> iterable, final boolean z) {
        return new Iterable<T>() { // from class: libcore.util.CollectionUtils.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new Iterator<T>() { // from class: libcore.util.CollectionUtils.1.1
                    private final Iterator<? extends Reference<T>> delegate;
                    private T next;
                    private boolean removeIsOkay;

                    {
                        this.delegate = Iterable.this.iterator();
                    }

                    private void computeNext() {
                        this.removeIsOkay = false;
                        while (this.next == null && this.delegate.hasNext()) {
                            this.next = this.delegate.next().get();
                            if (z && this.next == null) {
                                this.delegate.remove();
                            }
                        }
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        computeNext();
                        return this.next != null;
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        if (hasNext()) {
                            T t = this.next;
                            this.removeIsOkay = true;
                            this.next = null;
                            return t;
                        }
                        throw new IllegalStateException();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        if (!this.removeIsOkay) {
                            throw new IllegalStateException();
                        }
                        this.delegate.remove();
                    }
                };
            }
        };
    }

    public static <T> void removeDuplicates(List<T> list, Comparator<? super T> comparator) {
        Collections.sort(list, comparator);
        int i = 1;
        int i2 = 1;
        while (i2 < list.size()) {
            int i3 = i;
            if (comparator.compare((Object) list.get(i - 1), (Object) list.get(i2)) != 0) {
                list.set(i, list.get(i2));
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        if (i < list.size()) {
            list.subList(i, list.size()).clear();
        }
    }
}
