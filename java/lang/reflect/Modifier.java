package java.lang.reflect;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/Modifier.class */
public class Modifier {
    public static final int ABSTRACT = 1024;
    static final int ANNOTATION = 8192;
    static final int BRIDGE = 64;
    public static final int CONSTRUCTOR = 65536;
    static final int ENUM = 16384;
    public static final int FINAL = 16;
    public static final int INTERFACE = 512;
    public static final int MIRANDA = 2097152;
    public static final int NATIVE = 256;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;
    public static final int PUBLIC = 1;
    public static final int STATIC = 8;
    public static final int STRICT = 2048;
    public static final int SYNCHRONIZED = 32;
    public static final int SYNTHETIC = 4096;
    public static final int TRANSIENT = 128;
    static final int VARARGS = 128;
    public static final int VOLATILE = 64;

    public static int classModifiers() {
        return 3103;
    }

    public static int constructorModifiers() {
        return 7;
    }

    public static int fieldModifiers() {
        return 223;
    }

    public static int interfaceModifiers() {
        return 3087;
    }

    public static boolean isAbstract(int i) {
        return (i & 1024) != 0;
    }

    public static boolean isConstructor(int i) {
        return (65536 & i) != 0;
    }

    public static boolean isFinal(int i) {
        return (i & 16) != 0;
    }

    public static boolean isInterface(int i) {
        return (i & 512) != 0;
    }

    public static boolean isNative(int i) {
        return (i & 256) != 0;
    }

    public static boolean isPrivate(int i) {
        return (i & 2) != 0;
    }

    public static boolean isProtected(int i) {
        return (i & 4) != 0;
    }

    public static boolean isPublic(int i) {
        return (i & 1) != 0;
    }

    public static boolean isStatic(int i) {
        return (i & 8) != 0;
    }

    public static boolean isStrict(int i) {
        return (i & 2048) != 0;
    }

    public static boolean isSynchronized(int i) {
        return (i & 32) != 0;
    }

    public static boolean isTransient(int i) {
        return (i & 128) != 0;
    }

    public static boolean isVolatile(int i) {
        return (i & 64) != 0;
    }

    public static int methodModifiers() {
        return 3391;
    }

    public static String toString(int i) {
        StringBuilder sb = new StringBuilder();
        if (isPublic(i)) {
            sb.append("public ");
        }
        if (isProtected(i)) {
            sb.append("protected ");
        }
        if (isPrivate(i)) {
            sb.append("private ");
        }
        if (isAbstract(i)) {
            sb.append("abstract ");
        }
        if (isStatic(i)) {
            sb.append("static ");
        }
        if (isFinal(i)) {
            sb.append("final ");
        }
        if (isTransient(i)) {
            sb.append("transient ");
        }
        if (isVolatile(i)) {
            sb.append("volatile ");
        }
        if (isSynchronized(i)) {
            sb.append("synchronized ");
        }
        if (isNative(i)) {
            sb.append("native ");
        }
        if (isStrict(i)) {
            sb.append("strictfp ");
        }
        if (isInterface(i)) {
            sb.append("interface ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
