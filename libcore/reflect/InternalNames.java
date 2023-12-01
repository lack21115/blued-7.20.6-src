package libcore.reflect;

import java.lang.reflect.Array;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/InternalNames.class */
public final class InternalNames {
    private InternalNames() {
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) {
        if (str.startsWith("[")) {
            return Array.newInstance(getClass(classLoader, str.substring(1)), 0).getClass();
        }
        if (str.equals("Z")) {
            return Boolean.TYPE;
        }
        if (str.equals("B")) {
            return Byte.TYPE;
        }
        if (str.equals("S")) {
            return Short.TYPE;
        }
        if (str.equals("I")) {
            return Integer.TYPE;
        }
        if (str.equals("J")) {
            return Long.TYPE;
        }
        if (str.equals("F")) {
            return Float.TYPE;
        }
        if (str.equals("D")) {
            return Double.TYPE;
        }
        if (str.equals("C")) {
            return Character.TYPE;
        }
        if (str.equals("V")) {
            return Void.TYPE;
        }
        String replace = str.substring(1, str.length() - 1).replace('/', '.');
        try {
            return classLoader.loadClass(replace);
        } catch (ClassNotFoundException e) {
            NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(replace);
            noClassDefFoundError.initCause(e);
            throw noClassDefFoundError;
        }
    }

    public static String getInternalName(Class<?> cls) {
        return cls.isArray() ? '[' + getInternalName(cls.getComponentType()) : cls == Boolean.TYPE ? "Z" : cls == Byte.TYPE ? "B" : cls == Short.TYPE ? "S" : cls == Integer.TYPE ? "I" : cls == Long.TYPE ? "J" : cls == Float.TYPE ? "F" : cls == Double.TYPE ? "D" : cls == Character.TYPE ? "C" : cls == Void.TYPE ? "V" : 'L' + cls.getName().replace('.', '/') + ';';
    }
}
