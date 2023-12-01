package libcore.util;

import java.lang.reflect.Field;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:libcore/util/Objects.class */
public final class Objects {
    private Objects() {
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static String toString(Object obj) {
        Field[] declaredFields;
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getSimpleName()).append('[');
        int i = 0;
        for (Field field : cls.getDeclaredFields()) {
            if ((field.getModifiers() & 136) == 0) {
                field.setAccessible(true);
                try {
                    Object obj2 = field.get(obj);
                    int i2 = i + 1;
                    if (i > 0) {
                        try {
                            sb.append(',');
                        } catch (IllegalAccessException e) {
                            e = e;
                            throw new AssertionError(e);
                        }
                    }
                    sb.append(field.getName());
                    sb.append('=');
                    if (obj2.getClass().isArray()) {
                        if (obj2.getClass() == boolean[].class) {
                            sb.append(Arrays.toString((boolean[]) obj2));
                            i = i2;
                        } else if (obj2.getClass() == byte[].class) {
                            sb.append(Arrays.toString((byte[]) obj2));
                            i = i2;
                        } else if (obj2.getClass() == char[].class) {
                            sb.append(Arrays.toString((char[]) obj2));
                            i = i2;
                        } else if (obj2.getClass() == double[].class) {
                            sb.append(Arrays.toString((double[]) obj2));
                            i = i2;
                        } else if (obj2.getClass() == float[].class) {
                            sb.append(Arrays.toString((float[]) obj2));
                            i = i2;
                        } else if (obj2.getClass() == int[].class) {
                            sb.append(Arrays.toString((int[]) obj2));
                            i = i2;
                        } else if (obj2.getClass() == long[].class) {
                            sb.append(Arrays.toString((long[]) obj2));
                            i = i2;
                        } else if (obj2.getClass() == short[].class) {
                            sb.append(Arrays.toString((short[]) obj2));
                            i = i2;
                        } else {
                            sb.append(Arrays.toString((Object[]) obj2));
                            i = i2;
                        }
                    } else if (obj2.getClass() == Character.class) {
                        sb.append('\'').append(obj2).append('\'');
                        i = i2;
                    } else if (obj2.getClass() == String.class) {
                        sb.append('\"').append(obj2).append('\"');
                        i = i2;
                    } else {
                        sb.append(obj2);
                        i = i2;
                    }
                } catch (IllegalAccessException e2) {
                    e = e2;
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
