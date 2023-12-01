package external.org.apache.commons.lang3.builder;

import external.org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/builder/HashCodeBuilder.class */
public class HashCodeBuilder implements Builder<Integer> {
    private static final ThreadLocal<Set<IDKey>> REGISTRY = new ThreadLocal<>();
    private final int iConstant;
    private int iTotal;

    public HashCodeBuilder() {
        this.iTotal = 0;
        this.iConstant = 37;
        this.iTotal = 17;
    }

    public HashCodeBuilder(int i, int i2) {
        this.iTotal = 0;
        if (i == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
        }
        if (i % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
        }
        if (i2 % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        }
        this.iConstant = i2;
        this.iTotal = i;
    }

    static Set<IDKey> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object obj) {
        Set<IDKey> registry = getRegistry();
        return registry != null && registry.contains(new IDKey(obj));
    }

    private static void reflectionAppend(Object obj, Class<?> cls, HashCodeBuilder hashCodeBuilder, boolean z, String[] strArr) {
        if (isRegistered(obj)) {
            return;
        }
        try {
            register(obj);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Field field = declaredFields[i2];
                if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                    try {
                        hashCodeBuilder.append(field.get(obj));
                    } catch (IllegalAccessException e) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
                i = i2 + 1;
            }
        } finally {
            unregister(obj);
        }
    }

    public static int reflectionHashCode(int i, int i2, Object obj) {
        return reflectionHashCode(i, i2, obj, false, null, new String[0]);
    }

    public static int reflectionHashCode(int i, int i2, Object obj, boolean z) {
        return reflectionHashCode(i, i2, obj, z, null, new String[0]);
    }

    public static <T> int reflectionHashCode(int i, int i2, T t, boolean z, Class<? super T> cls, String... strArr) {
        if (t == null) {
            throw new IllegalArgumentException("The object to build a hash code for must not be null");
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i, i2);
        Class<? super Object> cls2 = t.getClass();
        reflectionAppend(t, cls2, hashCodeBuilder, z, strArr);
        while (cls2.getSuperclass() != null && cls2 != cls) {
            cls2 = cls2.getSuperclass();
            reflectionAppend(t, cls2, hashCodeBuilder, z, strArr);
        }
        return hashCodeBuilder.toHashCode();
    }

    public static int reflectionHashCode(Object obj, Collection<String> collection) {
        return reflectionHashCode(obj, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionHashCode(Object obj, boolean z) {
        return reflectionHashCode(17, 37, obj, z, null, new String[0]);
    }

    public static int reflectionHashCode(Object obj, String... strArr) {
        return reflectionHashCode(17, 37, obj, false, null, strArr);
    }

    static void register(Object obj) {
        synchronized (HashCodeBuilder.class) {
            try {
                if (getRegistry() == null) {
                    REGISTRY.set(new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        getRegistry().add(new IDKey(obj));
    }

    static void unregister(Object obj) {
        Set<IDKey> registry = getRegistry();
        if (registry != null) {
            registry.remove(new IDKey(obj));
            synchronized (HashCodeBuilder.class) {
                try {
                    Set<IDKey> registry2 = getRegistry();
                    if (registry2 != null && registry2.isEmpty()) {
                        REGISTRY.remove();
                    }
                } finally {
                }
            }
        }
    }

    public HashCodeBuilder append(byte b) {
        this.iTotal = (this.iTotal * this.iConstant) + b;
        return this;
    }

    public HashCodeBuilder append(char c2) {
        this.iTotal = (this.iTotal * this.iConstant) + c2;
        return this;
    }

    public HashCodeBuilder append(double d) {
        return append(Double.doubleToLongBits(d));
    }

    public HashCodeBuilder append(float f) {
        this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f);
        return this;
    }

    public HashCodeBuilder append(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    public HashCodeBuilder append(long j) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) ((j >> 32) ^ j));
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
            return this;
        } else if (!obj.getClass().isArray()) {
            this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
            return this;
        } else if (obj instanceof long[]) {
            append((long[]) obj);
            return this;
        } else if (obj instanceof int[]) {
            append((int[]) obj);
            return this;
        } else if (obj instanceof short[]) {
            append((short[]) obj);
            return this;
        } else if (obj instanceof char[]) {
            append((char[]) obj);
            return this;
        } else if (obj instanceof byte[]) {
            append((byte[]) obj);
            return this;
        } else if (obj instanceof double[]) {
            append((double[]) obj);
            return this;
        } else if (obj instanceof float[]) {
            append((float[]) obj);
            return this;
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj);
            return this;
        } else {
            append((Object[]) obj);
            return this;
        }
    }

    public HashCodeBuilder append(short s) {
        this.iTotal = (this.iTotal * this.iConstant) + s;
        return this;
    }

    public HashCodeBuilder append(boolean z) {
        int i = this.iTotal;
        this.iTotal = (z ? 0 : 1) + (this.iConstant * i);
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(bArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr != null) {
            int length = cArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(cArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr != null) {
            int length = dArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(dArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(fArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr != null) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(iArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr != null) {
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(jArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(objArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr != null) {
            int length = sArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(sArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr != null) {
            int length = zArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                append(zArr[i2]);
                i = i2 + 1;
            }
        } else {
            this.iTotal *= this.iConstant;
        }
        return this;
    }

    public HashCodeBuilder appendSuper(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.org.apache.commons.lang3.builder.Builder
    public Integer build() {
        return Integer.valueOf(toHashCode());
    }

    public int hashCode() {
        return toHashCode();
    }

    public int toHashCode() {
        return this.iTotal;
    }
}
