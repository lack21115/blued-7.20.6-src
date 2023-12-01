package external.org.apache.commons.lang3;

import external.org.apache.commons.lang3.exception.CloneFailedException;
import external.org.apache.commons.lang3.mutable.MutableInt;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/ObjectUtils.class */
public class ObjectUtils {
    public static final Null NULL = new Null();

    /* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/ObjectUtils$Null.class */
    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static <T> T clone(T t) {
        Object invoke;
        if (t instanceof Cloneable) {
            if (t.getClass().isArray()) {
                Class<?> componentType = t.getClass().getComponentType();
                if (componentType.isPrimitive()) {
                    int length = Array.getLength(t);
                    Object newInstance = Array.newInstance(componentType, length);
                    while (true) {
                        int i = length - 1;
                        invoke = newInstance;
                        if (length <= 0) {
                            break;
                        }
                        Array.set(newInstance, i, Array.get(t, i));
                        length = i;
                    }
                } else {
                    invoke = ((Object[]) t).clone();
                }
            } else {
                try {
                    invoke = t.getClass().getMethod("clone", new Class[0]).invoke(t, new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new CloneFailedException("Cannot clone Cloneable type " + t.getClass().getName(), e);
                } catch (NoSuchMethodException e2) {
                    throw new CloneFailedException("Cloneable type " + t.getClass().getName() + " has no clone method", e2);
                } catch (InvocationTargetException e3) {
                    throw new CloneFailedException("Exception cloning Cloneable type " + t.getClass().getName(), e3.getCause());
                }
            }
            return (T) invoke;
        }
        return null;
    }

    public static <T> T cloneIfPossible(T t) {
        T t2 = (T) clone(t);
        return t2 == null ? t : t2;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2) {
        return compare(t, t2, false);
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2, boolean z) {
        int i = 1;
        if (t == t2) {
            i = 0;
        } else if (t != null) {
            if (t2 == null) {
                return z ? -1 : 1;
            }
            return t.compareTo(t2);
        } else if (!z) {
            return -1;
        }
        return i;
    }

    public static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static <T> T firstNonNull(T... tArr) {
        if (tArr == null) {
            return null;
        }
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            T t = tArr[i2];
            if (t != null) {
                return t;
            }
            i = i2 + 1;
        }
    }

    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static int hashCodeMulti(Object... objArr) {
        int i = 1;
        int i2 = 1;
        if (objArr != null) {
            int length = objArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + hashCode(objArr[i4]);
                i3 = i4 + 1;
            }
        }
        return i;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        identityToString(stringBuffer, obj);
        return stringBuffer.toString();
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
        stringBuffer.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t = null;
        T t2 = null;
        if (tArr != null) {
            int length = tArr.length;
            int i = 0;
            while (true) {
                t = t2;
                if (i >= length) {
                    break;
                }
                T t3 = tArr[i];
                T t4 = t2;
                if (compare(t3, t2, false) > 0) {
                    t4 = t3;
                }
                i++;
                t2 = t4;
            }
        }
        return t;
    }

    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t = null;
        T t2 = null;
        if (tArr != null) {
            int length = tArr.length;
            int i = 0;
            while (true) {
                t = t2;
                if (i >= length) {
                    break;
                }
                T t3 = tArr[i];
                T t4 = t2;
                if (compare(t3, t2, true) < 0) {
                    t4 = t3;
                }
                i++;
                t2 = t4;
            }
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T mode(T... tArr) {
        T t;
        if (ArrayUtils.isNotEmpty(tArr)) {
            HashMap hashMap = new HashMap(tArr.length);
            int length = tArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                T t2 = tArr[i2];
                MutableInt mutableInt = (MutableInt) hashMap.get(t2);
                if (mutableInt == null) {
                    hashMap.put(t2, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
                i = i2 + 1;
            }
            T t3 = null;
            int i3 = 0;
            Iterator it = hashMap.entrySet().iterator();
            while (true) {
                t = t3;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                int intValue = ((MutableInt) entry.getValue()).intValue();
                if (intValue == i3) {
                    t3 = null;
                } else if (intValue > i3) {
                    i3 = intValue;
                    t3 = entry.getKey();
                }
            }
        } else {
            t = null;
        }
        return t;
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }
}
