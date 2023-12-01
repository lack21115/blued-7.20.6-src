package java.lang;

import java.io.Serializable;
import java.lang.Enum;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import libcore.util.BasicLruCache;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Enum.class */
public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E> {
    private static final long serialVersionUID = -4300926546619394005L;
    private static final BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache = new BasicLruCache<Class<? extends Enum>, Object[]>(64) { // from class: java.lang.Enum.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // libcore.util.BasicLruCache
        public Object[] create(Class<? extends Enum> cls) {
            if (cls.isEnum()) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("values", EmptyArray.CLASS);
                    declaredMethod.setAccessible(true);
                    return (Object[]) declaredMethod.invoke(null, new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new AssertionError("impossible", e);
                } catch (NoSuchMethodException e2) {
                    throw new AssertionError("impossible", e2);
                } catch (InvocationTargetException e3) {
                    throw new AssertionError("impossible", e3);
                }
            }
            return null;
        }
    };
    private final String name;
    private final int ordinal;

    /* JADX INFO: Access modifiers changed from: protected */
    public Enum(String str, int i) {
        this.name = str;
        this.ordinal = i;
    }

    public static <T extends Enum<T>> T[] getSharedConstants(Class<T> cls) {
        return (T[]) ((Enum[]) sharedConstantsCache.get(cls));
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("enumType == null");
        }
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        Enum[] sharedConstants = getSharedConstants(cls);
        if (sharedConstants == null) {
            throw new IllegalArgumentException(cls + " is not an enum type");
        }
        int length = sharedConstants.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalArgumentException(str + " is not a constant in " + cls.getName());
            }
            T t = (T) sharedConstants[i2];
            if (str.equals(t.name())) {
                return t;
            }
            i = i2 + 1;
        }
    }

    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Enums may not be cloned");
    }

    public final int compareTo(E e) {
        return this.ordinal - e.ordinal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Enum<E>) obj);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    protected final void finalize() {
    }

    public final Class<E> getDeclaringClass() {
        Class<E> cls = (Class<E>) getClass();
        Class superclass = cls.getSuperclass();
        return Enum.class == superclass ? cls : superclass;
    }

    public final int hashCode() {
        return (this.name == null ? 0 : this.name.hashCode()) + this.ordinal;
    }

    public final String name() {
        return this.name;
    }

    public final int ordinal() {
        return this.ordinal;
    }

    public String toString() {
        return this.name;
    }
}
