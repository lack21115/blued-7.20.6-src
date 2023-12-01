package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/CollectionsKt___CollectionsKt.class */
public class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static final <T> int a(List<? extends T> list, T t) {
        Intrinsics.e(list, "<this>");
        return list.indexOf(t);
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        int i2;
        Intrinsics.e(iterable, "<this>");
        Intrinsics.e(buffer, "buffer");
        Intrinsics.e(separator, "separator");
        Intrinsics.e(prefix, "prefix");
        Intrinsics.e(postfix, "postfix");
        Intrinsics.e(truncated, "truncated");
        buffer.append(prefix);
        Iterator<? extends T> it = iterable.iterator();
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i >= 0) {
                i2 = i3;
                if (i3 > i) {
                    break;
                }
            }
            StringsKt.a(buffer, next, function1);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable a(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
            i = -1;
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
            function1 = null;
        }
        return CollectionsKt.a(iterable, appendable, charSequence, charSequence2, charSequence3, i, charSequence4, function1);
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.e(iterable, "<this>");
        Intrinsics.e(separator, "separator");
        Intrinsics.e(prefix, "prefix");
        Intrinsics.e(postfix, "postfix");
        Intrinsics.e(truncated, "truncated");
        String sb = ((StringBuilder) CollectionsKt.a(iterable, new StringBuilder(), separator, prefix, postfix, i, truncated, function1)).toString();
        Intrinsics.c(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return CollectionsKt.a(iterable, charSequence, charSequence2, charSequence3, i, charSequence4, function1);
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C destination) {
        Intrinsics.e(iterable, "<this>");
        Intrinsics.e(destination, "destination");
        for (T t : iterable) {
            destination.add(t);
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.e(iterable, "<this>");
        Intrinsics.e(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> g = CollectionsKt.g(iterable);
            CollectionsKt.a((List) g, (Comparator) comparator);
            return g;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return CollectionsKt.f(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            ArraysKt.a(array, (Comparator) comparator);
            return ArraysKt.a(array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final <T> List<T> a(Collection<? extends T> collection, T t) {
        Intrinsics.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> boolean a(Iterable<? extends T> iterable, T t) {
        Intrinsics.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t) : CollectionsKt.b(iterable, t) >= 0;
    }

    public static final <T> int b(Iterable<? extends T> iterable, T t) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                CollectionsKt.c();
            }
            if (Intrinsics.a(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int b(List<? extends T> list, T t) {
        Intrinsics.e(list, "<this>");
        return list.lastIndexOf(t);
    }

    public static final <T> T b(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.h((List<? extends Object>) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable, int i) {
        Intrinsics.e(iterable, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt.b();
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return CollectionsKt.f(iterable);
                }
                if (i == 1) {
                    return CollectionsKt.a(CollectionsKt.b(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (T t : iterable) {
                arrayList.add(t);
                int i3 = i2 + 1;
                i2 = i3;
                if (i3 == i) {
                    break;
                }
            }
            return CollectionsKt.c((List) arrayList);
        }
    }

    public static final <T> List<T> b(Collection<? extends T> collection, Iterable<? extends T> elements) {
        Intrinsics.e(collection, "<this>");
        Intrinsics.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            CollectionsKt.a((Collection) arrayList, (Iterable) elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static final int[] b(Collection<Integer> collection) {
        Intrinsics.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            iArr[i2] = it.next().intValue();
            i = i2 + 1;
        }
    }

    public static final <T> T c(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) CollectionsKt.k((List<? extends Object>) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T c(List<? extends T> list, int i) {
        Intrinsics.e(list, "<this>");
        if (i < 0 || i > CollectionsKt.b((List) list)) {
            return null;
        }
        return list.get(i);
    }

    public static final <T> List<T> c(Collection<? extends T> collection) {
        Intrinsics.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        if (!(iterable instanceof Collection) || ((Collection) iterable).size() > 1) {
            List<T> g = CollectionsKt.g(iterable);
            CollectionsKt.g((List) g);
            return g;
        }
        return CollectionsKt.f(iterable);
    }

    public static final <T> HashSet<T> e(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        return (HashSet) CollectionsKt.a((Iterable) iterable, new HashSet(MapsKt.b(CollectionsKt.a(iterable, 12))));
    }

    public static final <T> List<T> f(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return CollectionsKt.c(collection);
                }
                return CollectionsKt.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            }
            return CollectionsKt.b();
        }
        return CollectionsKt.c(CollectionsKt.g(iterable));
    }

    public static final <T> List<T> g(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        return iterable instanceof Collection ? CollectionsKt.c((Collection) iterable) : (List) CollectionsKt.a((Iterable) iterable, new ArrayList());
    }

    public static final <T> T h(List<? extends T> list) {
        Intrinsics.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> Set<T> h(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return (Set) CollectionsKt.a((Iterable) iterable, new LinkedHashSet(MapsKt.b(collection.size())));
                }
                return SetsKt.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            }
            return SetsKt.a();
        }
        return SetsKt.b((Set) CollectionsKt.a((Iterable) iterable, new LinkedHashSet()));
    }

    public static final <T> Iterable<IndexedValue<T>> i(final Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        return new IndexingIterable(new Function0<Iterator<? extends T>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final Iterator<T> invoke() {
                return iterable.iterator();
            }
        });
    }

    public static final <T> T i(List<? extends T> list) {
        Intrinsics.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> T j(List<? extends T> list) {
        Intrinsics.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(CollectionsKt.b((List) list));
    }

    public static final <T> List<T> j(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        return CollectionsKt.f(CollectionsKt.k(iterable));
    }

    public static final <T> T k(List<? extends T> list) {
        Intrinsics.e(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> Set<T> k(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) CollectionsKt.a((Iterable) iterable, new LinkedHashSet());
    }

    public static final <T extends Comparable<? super T>> T l(Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    public static final <T> T l(List<? extends T> list) {
        Intrinsics.e(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static final <T> Sequence<T> m(final Iterable<? extends T> iterable) {
        Intrinsics.e(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return Iterable.this.iterator();
            }
        };
    }
}
