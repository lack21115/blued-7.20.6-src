package java.util;

import java.io.Serializable;
import java.lang.Enum;

/* loaded from: source-2895416-dex2jar.jar:java/util/EnumSet.class */
public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable {
    private static final long serialVersionUID = 1009687484059888093L;
    final Class<E> elementClass;

    /* loaded from: source-2895416-dex2jar.jar:java/util/EnumSet$SerializationProxy.class */
    private static class SerializationProxy<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 362491234563181265L;
        private Class<E> elementType;
        private E[] elements;

        private SerializationProxy() {
        }

        private Object readResolve() {
            EnumSet noneOf = EnumSet.noneOf(this.elementType);
            E[] eArr = this.elements;
            int length = eArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return noneOf;
                }
                noneOf.add(eArr[i2]);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnumSet(Class<E> cls) {
        this.elementClass = cls;
    }

    public static <E extends Enum<E>> EnumSet<E> allOf(Class<E> cls) {
        EnumSet<E> noneOf = noneOf(cls);
        noneOf.complement();
        return noneOf;
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> enumSet) {
        EnumSet<E> noneOf = noneOf(enumSet.elementClass);
        noneOf.addAll(enumSet);
        noneOf.complement();
        return noneOf;
    }

    public static <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> collection) {
        EnumSet<E> enumSet;
        if (!(collection instanceof EnumSet)) {
            if (!collection.isEmpty()) {
                Iterator<E> it = collection.iterator();
                E next = it.next();
                EnumSet<E> noneOf = noneOf(next.getDeclaringClass());
                noneOf.add(next);
                while (true) {
                    enumSet = noneOf;
                    if (!it.hasNext()) {
                        break;
                    }
                    noneOf.add(it.next());
                }
            } else {
                throw new IllegalArgumentException("empty collection");
            }
        } else {
            enumSet = copyOf((EnumSet) collection);
        }
        return enumSet;
    }

    public static <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> enumSet) {
        EnumSet<E> noneOf = noneOf(enumSet.elementClass);
        noneOf.addAll(enumSet);
        return noneOf;
    }

    public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> cls) {
        if (cls.isEnum()) {
            Enum[] sharedConstants = Enum.getSharedConstants(cls);
            return sharedConstants.length <= 64 ? new MiniEnumSet(cls, sharedConstants) : new HugeEnumSet(cls, sharedConstants);
        }
        throw new ClassCastException(cls.getClass().getName() + " is not an Enum");
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e) {
        EnumSet<E> noneOf = noneOf(e.getDeclaringClass());
        noneOf.add(e);
        return noneOf;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e, E e2) {
        EnumSet<E> of = of(e);
        of.add(e2);
        return of;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e, E e2, E e3) {
        EnumSet<E> of = of(e, e2);
        of.add(e3);
        return of;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e, E e2, E e3, E e4) {
        EnumSet<E> of = of(e, e2, e3);
        of.add(e4);
        return of;
    }

    public static <E extends Enum<E>> EnumSet<E> of(E e, E e2, E e3, E e4, E e5) {
        EnumSet<E> of = of(e, e2, e3, e4);
        of.add(e5);
        return of;
    }

    @SafeVarargs
    public static <E extends Enum<E>> EnumSet<E> of(E e, E... eArr) {
        EnumSet<E> of = of(e);
        int length = eArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return of;
            }
            of.add(eArr[i2]);
            i = i2 + 1;
        }
    }

    public static <E extends Enum<E>> EnumSet<E> range(E e, E e2) {
        if (e.compareTo(e2) > 0) {
            throw new IllegalArgumentException("start is behind end");
        }
        EnumSet<E> noneOf = noneOf(e.getDeclaringClass());
        noneOf.setRange(e, e2);
        return noneOf;
    }

    @Override // 
    public EnumSet<E> clone() {
        try {
            return (EnumSet) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    abstract void complement();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidType(Class<?> cls) {
        return cls == this.elementClass || cls.getSuperclass() == this.elementClass;
    }

    abstract void setRange(E e, E e2);

    Object writeReplace() {
        SerializationProxy serializationProxy = new SerializationProxy();
        serializationProxy.elements = (Enum[]) toArray(new Enum[0]);
        serializationProxy.elementType = this.elementClass;
        return serializationProxy;
    }
}
