package external.org.apache.commons.lang3.builder;

import external.org.apache.commons.lang3.ArrayUtils;
import external.org.apache.commons.lang3.tuple.Pair;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/builder/EqualsBuilder.class */
public class EqualsBuilder implements Builder<Boolean> {
    private static final ThreadLocal<Set<Pair<IDKey, IDKey>>> REGISTRY = new ThreadLocal<>();
    private boolean isEquals = true;

    static Pair<IDKey, IDKey> getRegisterPair(Object obj, Object obj2) {
        return Pair.of(new IDKey(obj), new IDKey(obj2));
    }

    static Set<Pair<IDKey, IDKey>> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        Pair<IDKey, IDKey> registerPair = getRegisterPair(obj, obj2);
        Pair of = Pair.of(registerPair.getLeft(), registerPair.getRight());
        if (registry != null) {
            return registry.contains(registerPair) || registry.contains(of);
        }
        return false;
    }

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, EqualsBuilder equalsBuilder, boolean z, String[] strArr) {
        if (isRegistered(obj, obj2)) {
            return;
        }
        try {
            register(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= declaredFields.length || !equalsBuilder.isEquals) {
                    break;
                }
                Field field = declaredFields[i2];
                if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                    try {
                        equalsBuilder.append(field.get(obj), field.get(obj2));
                    } catch (IllegalAccessException e) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
                i = i2 + 1;
            }
        } finally {
            unregister(obj, obj2);
        }
    }

    public static boolean reflectionEquals(Object obj, Object obj2, Collection<String> collection) {
        return reflectionEquals(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z) {
        return reflectionEquals(obj, obj2, z, null, new String[0]);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        Class<?> cls2;
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        Class<?> cls3 = obj.getClass();
        Class<?> cls4 = obj2.getClass();
        if (cls3.isInstance(obj2)) {
            cls2 = cls3;
            if (!cls4.isInstance(obj)) {
                cls2 = cls4;
            }
        } else if (!cls4.isInstance(obj)) {
            return false;
        } else {
            cls2 = cls4;
            if (!cls3.isInstance(obj2)) {
                cls2 = cls3;
            }
        }
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        try {
            reflectionAppend(obj, obj2, cls2, equalsBuilder, z, strArr);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                reflectionAppend(obj, obj2, cls2, equalsBuilder, z, strArr);
            }
            return equalsBuilder.isEquals();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String... strArr) {
        return reflectionEquals(obj, obj2, false, null, strArr);
    }

    static void register(Object obj, Object obj2) {
        synchronized (EqualsBuilder.class) {
            try {
                if (getRegistry() == null) {
                    REGISTRY.set(new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        getRegistry().add(getRegisterPair(obj, obj2));
    }

    static void unregister(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        if (registry != null) {
            registry.remove(getRegisterPair(obj, obj2));
            synchronized (EqualsBuilder.class) {
                try {
                    Set<Pair<IDKey, IDKey>> registry2 = getRegistry();
                    if (registry2 != null && registry2.isEmpty()) {
                        REGISTRY.remove();
                    }
                } finally {
                }
            }
        }
    }

    public EqualsBuilder append(byte b, byte b2) {
        if (this.isEquals) {
            this.isEquals = b == b2;
            return this;
        }
        return this;
    }

    public EqualsBuilder append(char c, char c2) {
        if (this.isEquals) {
            this.isEquals = c == c2;
            return this;
        }
        return this;
    }

    public EqualsBuilder append(double d, double d2) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public EqualsBuilder append(float f, float f2) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f), Float.floatToIntBits(f2));
    }

    public EqualsBuilder append(int i, int i2) {
        if (this.isEquals) {
            this.isEquals = i == i2;
            return this;
        }
        return this;
    }

    public EqualsBuilder append(long j, long j2) {
        if (this.isEquals) {
            this.isEquals = j == j2;
            return this;
        }
        return this;
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (this.isEquals && obj != obj2) {
            if (obj == null || obj2 == null) {
                setEquals(false);
                return this;
            } else if (!obj.getClass().isArray()) {
                this.isEquals = obj.equals(obj2);
                return this;
            } else if (obj.getClass() != obj2.getClass()) {
                setEquals(false);
                return this;
            } else if (obj instanceof long[]) {
                append((long[]) obj, (long[]) obj2);
                return this;
            } else if (obj instanceof int[]) {
                append((int[]) obj, (int[]) obj2);
                return this;
            } else if (obj instanceof short[]) {
                append((short[]) obj, (short[]) obj2);
                return this;
            } else if (obj instanceof char[]) {
                append((char[]) obj, (char[]) obj2);
                return this;
            } else if (obj instanceof byte[]) {
                append((byte[]) obj, (byte[]) obj2);
                return this;
            } else if (obj instanceof double[]) {
                append((double[]) obj, (double[]) obj2);
                return this;
            } else if (obj instanceof float[]) {
                append((float[]) obj, (float[]) obj2);
                return this;
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj, (boolean[]) obj2);
                return this;
            } else {
                append((Object[]) obj, (Object[]) obj2);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(short s, short s2) {
        if (this.isEquals) {
            this.isEquals = s == s2;
            return this;
        }
        return this;
    }

    public EqualsBuilder append(boolean z, boolean z2) {
        if (this.isEquals) {
            this.isEquals = z == z2;
            return this;
        }
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.isEquals && bArr != bArr2) {
            if (bArr != null && bArr2 != null) {
                if (bArr.length == bArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= bArr.length || !this.isEquals) {
                            break;
                        }
                        append(bArr[i2], bArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (this.isEquals && cArr != cArr2) {
            if (cArr != null && cArr2 != null) {
                if (cArr.length == cArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= cArr.length || !this.isEquals) {
                            break;
                        }
                        append(cArr[i2], cArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (this.isEquals && dArr != dArr2) {
            if (dArr != null && dArr2 != null) {
                if (dArr.length == dArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= dArr.length || !this.isEquals) {
                            break;
                        }
                        append(dArr[i2], dArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (this.isEquals && fArr != fArr2) {
            if (fArr != null && fArr2 != null) {
                if (fArr.length == fArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= fArr.length || !this.isEquals) {
                            break;
                        }
                        append(fArr[i2], fArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (this.isEquals && iArr != iArr2) {
            if (iArr != null && iArr2 != null) {
                if (iArr.length == iArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= iArr.length || !this.isEquals) {
                            break;
                        }
                        append(iArr[i2], iArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (this.isEquals && jArr != jArr2) {
            if (jArr != null && jArr2 != null) {
                if (jArr.length == jArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jArr.length || !this.isEquals) {
                            break;
                        }
                        append(jArr[i2], jArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (this.isEquals && objArr != objArr2) {
            if (objArr != null && objArr2 != null) {
                if (objArr.length == objArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= objArr.length || !this.isEquals) {
                            break;
                        }
                        append(objArr[i2], objArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (this.isEquals && sArr != sArr2) {
            if (sArr != null && sArr2 != null) {
                if (sArr.length == sArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= sArr.length || !this.isEquals) {
                            break;
                        }
                        append(sArr[i2], sArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.isEquals && zArr != zArr2) {
            if (zArr != null && zArr2 != null) {
                if (zArr.length == zArr2.length) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= zArr.length || !this.isEquals) {
                            break;
                        }
                        append(zArr[i2], zArr2[i2]);
                        i = i2 + 1;
                    }
                } else {
                    setEquals(false);
                    return this;
                }
            } else {
                setEquals(false);
                return this;
            }
        }
        return this;
    }

    public EqualsBuilder appendSuper(boolean z) {
        if (this.isEquals) {
            this.isEquals = z;
            return this;
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.org.apache.commons.lang3.builder.Builder
    public Boolean build() {
        return Boolean.valueOf(isEquals());
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    public void reset() {
        this.isEquals = true;
    }

    protected void setEquals(boolean z) {
        this.isEquals = z;
    }
}
