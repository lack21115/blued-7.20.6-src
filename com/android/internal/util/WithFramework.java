package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/WithFramework.class */
class WithFramework {
    WithFramework() {
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            printUsage();
            return;
        }
        Class<?> cls = Class.forName(strArr[0]);
        System.loadLibrary("android_runtime");
        if (registerNatives() < 0) {
            throw new RuntimeException("Error registering natives.");
        }
        String[] strArr2 = new String[strArr.length - 1];
        System.arraycopy(strArr, 1, strArr2, 0, strArr2.length);
        cls.getMethod("main", String[].class).invoke(null, strArr2);
    }

    private static void printUsage() {
        System.err.println("Usage: dalvikvm " + WithFramework.class.getName() + " [main class] [args]");
    }

    static native int registerNatives();
}
