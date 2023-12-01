package external.org.apache.commons.lang3.builder;

import external.org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/builder/CompareToBuilder.class */
public class CompareToBuilder implements Builder<Integer> {
    private int comparison = 0;

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= declaredFields.length || compareToBuilder.comparison != 0) {
                return;
            }
            Field field = declaredFields[i2];
            if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
            i = i2 + 1;
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, null, new String[0]);
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z) {
        return reflectionCompare(obj, obj2, z, null, new String[0]);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null || obj2 == null) {
            throw new NullPointerException();
        }
        Class<?> cls2 = obj.getClass();
        if (cls2.isInstance(obj2)) {
            CompareToBuilder compareToBuilder = new CompareToBuilder();
            reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
            }
            return compareToBuilder.toComparison();
        }
        throw new ClassCastException();
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        return reflectionCompare(obj, obj2, false, null, strArr);
    }

    public CompareToBuilder append(byte b, byte b2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = b < b2 ? -1 : b > b2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(char c, char c2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = c < c2 ? -1 : c > c2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(double d, double d2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Double.compare(d, d2);
        return this;
    }

    public CompareToBuilder append(float f, float f2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Float.compare(f, f2);
        return this;
    }

    public CompareToBuilder append(int i, int i2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i < i2 ? -1 : i > i2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(long j, long j2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = j < j2 ? -1 : j > j2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.comparison == 0 && obj != obj2) {
            if (obj == null) {
                this.comparison = -1;
                return this;
            } else if (obj2 == null) {
                this.comparison = 1;
                return this;
            } else if (!obj.getClass().isArray()) {
                if (comparator == null) {
                    this.comparison = ((Comparable) obj).compareTo(obj2);
                    return this;
                }
                this.comparison = comparator.compare(obj, obj2);
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
                append((Object[]) obj, (Object[]) obj2, comparator);
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(short s, short s2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = s < s2 ? -1 : s > s2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(boolean z, boolean z2) {
        if (this.comparison == 0 && z != z2) {
            if (z) {
                this.comparison = 1;
                return this;
            }
            this.comparison = -1;
            return this;
        }
        return this;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        int i = -1;
        if (this.comparison == 0 && bArr != bArr2) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (bArr.length == bArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= bArr.length || this.comparison != 0) {
                                break;
                            }
                            append(bArr[i3], bArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (bArr.length >= bArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        int i = -1;
        if (this.comparison == 0 && cArr != cArr2) {
            if (cArr != null) {
                if (cArr2 != null) {
                    if (cArr.length == cArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= cArr.length || this.comparison != 0) {
                                break;
                            }
                            append(cArr[i3], cArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (cArr.length >= cArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        int i = -1;
        if (this.comparison == 0 && dArr != dArr2) {
            if (dArr != null) {
                if (dArr2 != null) {
                    if (dArr.length == dArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dArr.length || this.comparison != 0) {
                                break;
                            }
                            append(dArr[i3], dArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (dArr.length >= dArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        int i = -1;
        if (this.comparison == 0 && fArr != fArr2) {
            if (fArr != null) {
                if (fArr2 != null) {
                    if (fArr.length == fArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= fArr.length || this.comparison != 0) {
                                break;
                            }
                            append(fArr[i3], fArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (fArr.length >= fArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        int i = -1;
        if (this.comparison == 0 && iArr != iArr2) {
            if (iArr != null) {
                if (iArr2 != null) {
                    if (iArr.length == iArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= iArr.length || this.comparison != 0) {
                                break;
                            }
                            append(iArr[i3], iArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (iArr.length >= iArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        int i = -1;
        if (this.comparison == 0 && jArr != jArr2) {
            if (jArr != null) {
                if (jArr2 != null) {
                    if (jArr.length == jArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= jArr.length || this.comparison != 0) {
                                break;
                            }
                            append(jArr[i3], jArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (jArr.length >= jArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        int i = -1;
        if (this.comparison == 0 && objArr != objArr2) {
            if (objArr != null) {
                if (objArr2 != null) {
                    if (objArr.length == objArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= objArr.length || this.comparison != 0) {
                                break;
                            }
                            append(objArr[i3], objArr2[i3], comparator);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (objArr.length >= objArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        int i = -1;
        if (this.comparison == 0 && sArr != sArr2) {
            if (sArr != null) {
                if (sArr2 != null) {
                    if (sArr.length == sArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= sArr.length || this.comparison != 0) {
                                break;
                            }
                            append(sArr[i3], sArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (sArr.length >= sArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        int i = -1;
        if (this.comparison == 0 && zArr != zArr2) {
            if (zArr != null) {
                if (zArr2 != null) {
                    if (zArr.length == zArr2.length) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= zArr.length || this.comparison != 0) {
                                break;
                            }
                            append(zArr[i3], zArr2[i3]);
                            i2 = i3 + 1;
                        }
                    } else {
                        if (zArr.length >= zArr2.length) {
                            i = 1;
                        }
                        this.comparison = i;
                        return this;
                    }
                } else {
                    this.comparison = 1;
                    return this;
                }
            } else {
                this.comparison = -1;
                return this;
            }
        }
        return this;
    }

    public CompareToBuilder appendSuper(int i) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.org.apache.commons.lang3.builder.Builder
    public Integer build() {
        return Integer.valueOf(toComparison());
    }

    public int toComparison() {
        return this.comparison;
    }
}
