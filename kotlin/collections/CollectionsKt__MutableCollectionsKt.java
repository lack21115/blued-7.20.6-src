package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt__MutableCollectionsKt.class */
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    private static final <T> boolean a(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke((T) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean a(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.e(collection, "<this>");
        Intrinsics.e(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        boolean z = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean a(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.e(list, "<this>");
        Intrinsics.e(predicate, "predicate");
        return a((List) list, (Function1) predicate, true);
    }

    private static final <T> boolean a(List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        int i;
        if (!(list instanceof RandomAccess)) {
            return a(TypeIntrinsics.a(list), function1, z);
        }
        int b = CollectionsKt.b((List) list);
        if (b >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                T t = list.get(i2);
                if (function1.invoke(t).booleanValue() != z) {
                    if (i3 != i2) {
                        list.set(i3, t);
                    }
                    i3++;
                }
                i = i3;
                if (i2 == b) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int b2 = CollectionsKt.b((List) list);
        if (i > b2) {
            return true;
        }
        while (true) {
            list.remove(b2);
            if (b2 == i) {
                return true;
            }
            b2--;
        }
    }

    public static final <T> T e(List<T> list) {
        Intrinsics.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(CollectionsKt.b((List) list));
    }

    public static final <T> T f(List<T> list) {
        Intrinsics.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt.b((List) list));
    }
}
