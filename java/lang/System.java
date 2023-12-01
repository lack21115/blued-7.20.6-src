package java.lang;

import android.system.ErrnoException;
import android.system.StructUtsname;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import dalvik.system.VMRuntime;
import dalvik.system.VMStack;
import java.io.BufferedInputStream;
import java.io.Console;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import libcore.icu.ICU;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/lang/System.class */
public final class System {
    private static final int ARRAYCOPY_SHORT_BOOLEAN_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_BYTE_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_CHAR_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_DOUBLE_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_FLOAT_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_INT_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_LONG_ARRAY_THRESHOLD = 32;
    private static final int ARRAYCOPY_SHORT_SHORT_ARRAY_THRESHOLD = 32;
    private static boolean justRanFinalization;
    private static boolean runGC;
    private static final Object lock = new Object();
    public static final PrintStream err = new PrintStream(new FileOutputStream(FileDescriptor.err));
    public static final PrintStream out = new PrintStream(new FileOutputStream(FileDescriptor.out));
    public static final InputStream in = new BufferedInputStream(new FileInputStream(FileDescriptor.in));
    private static final Properties unchangeableSystemProperties = initUnchangeableSystemProperties();
    private static Properties systemProperties = createSystemProperties();
    private static final String lineSeparator = getProperty("line.separator");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/System$PropertiesWithNonOverrideableDefaults.class */
    public static final class PropertiesWithNonOverrideableDefaults extends Properties {
        PropertiesWithNonOverrideableDefaults(Properties properties) {
            super(properties);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object put(Object obj, Object obj2) {
            if (this.defaults.containsKey(obj)) {
                System.logE("Ignoring attempt to set property \"" + obj + "\" to value \"" + obj2 + "\".");
                return this.defaults.get(obj);
            }
            return super.put(obj, obj2);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object remove(Object obj) {
            if (this.defaults.containsKey(obj)) {
                System.logE("Ignoring attempt to remove property \"" + obj + "\".");
                return null;
            }
            return super.remove(obj);
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/System$SystemEnvironment.class */
    static class SystemEnvironment extends AbstractMap<String, String> {
        private final Map<String, String> map;

        public SystemEnvironment(Map<String, String> map) {
            this.map = Collections.unmodifiableMap(map);
        }

        private String toNonNullString(Object obj) {
            if (obj == null) {
                throw new NullPointerException("o == null");
            }
            return (String) obj;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(toNonNullString(obj));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(toNonNullString(obj));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<String, String>> entrySet() {
            return this.map.entrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public String get(Object obj) {
            return this.map.get(toNonNullString(obj));
        }
    }

    private System() {
    }

    public static native void arraycopy(Object obj, int i, Object obj2, int i2, int i3);

    public static void arraycopy(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("src == null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > bArr.length - i3 || i2 > bArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + bArr.length + " srcPos=" + i + " dst.length=" + bArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyByteUnchecked(bArr, i, bArr2, i2, i3);
        } else if (bArr != bArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                bArr2[i2 + i5] = bArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                bArr2[i2 + i3] = bArr[i + i3];
            }
        }
    }

    public static void arraycopy(char[] cArr, int i, char[] cArr2, int i2, int i3) {
        if (cArr == null) {
            throw new NullPointerException("src == null");
        }
        if (cArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > cArr.length - i3 || i2 > cArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + cArr.length + " srcPos=" + i + " dst.length=" + cArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyCharUnchecked(cArr, i, cArr2, i2, i3);
        } else if (cArr != cArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                cArr2[i2 + i5] = cArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                cArr2[i2 + i3] = cArr[i + i3];
            }
        }
    }

    public static void arraycopy(double[] dArr, int i, double[] dArr2, int i2, int i3) {
        if (dArr == null) {
            throw new NullPointerException("src == null");
        }
        if (dArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > dArr.length - i3 || i2 > dArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + dArr.length + " srcPos=" + i + " dst.length=" + dArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyDoubleUnchecked(dArr, i, dArr2, i2, i3);
        } else if (dArr != dArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                dArr2[i2 + i5] = dArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                dArr2[i2 + i3] = dArr[i + i3];
            }
        }
    }

    public static void arraycopy(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        if (fArr == null) {
            throw new NullPointerException("src == null");
        }
        if (fArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > fArr.length - i3 || i2 > fArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + fArr.length + " srcPos=" + i + " dst.length=" + fArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyFloatUnchecked(fArr, i, fArr2, i2, i3);
        } else if (fArr != fArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                fArr2[i2 + i5] = fArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                fArr2[i2 + i3] = fArr[i + i3];
            }
        }
    }

    public static void arraycopy(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        if (iArr == null) {
            throw new NullPointerException("src == null");
        }
        if (iArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > iArr.length - i3 || i2 > iArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + iArr.length + " srcPos=" + i + " dst.length=" + iArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyIntUnchecked(iArr, i, iArr2, i2, i3);
        } else if (iArr != iArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                iArr2[i2 + i5] = iArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                iArr2[i2 + i3] = iArr[i + i3];
            }
        }
    }

    public static void arraycopy(long[] jArr, int i, long[] jArr2, int i2, int i3) {
        if (jArr == null) {
            throw new NullPointerException("src == null");
        }
        if (jArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > jArr.length - i3 || i2 > jArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + jArr.length + " srcPos=" + i + " dst.length=" + jArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyLongUnchecked(jArr, i, jArr2, i2, i3);
        } else if (jArr != jArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                jArr2[i2 + i5] = jArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                jArr2[i2 + i3] = jArr[i + i3];
            }
        }
    }

    public static void arraycopy(short[] sArr, int i, short[] sArr2, int i2, int i3) {
        if (sArr == null) {
            throw new NullPointerException("src == null");
        }
        if (sArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > sArr.length - i3 || i2 > sArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + sArr.length + " srcPos=" + i + " dst.length=" + sArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyShortUnchecked(sArr, i, sArr2, i2, i3);
        } else if (sArr != sArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                sArr2[i2 + i5] = sArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                sArr2[i2 + i3] = sArr[i + i3];
            }
        }
    }

    public static void arraycopy(boolean[] zArr, int i, boolean[] zArr2, int i2, int i3) {
        if (zArr == null) {
            throw new NullPointerException("src == null");
        }
        if (zArr2 == null) {
            throw new NullPointerException("dst == null");
        }
        if (i < 0 || i2 < 0 || i3 < 0 || i > zArr.length - i3 || i2 > zArr2.length - i3) {
            throw new ArrayIndexOutOfBoundsException("src.length=" + zArr.length + " srcPos=" + i + " dst.length=" + zArr2.length + " dstPos=" + i2 + " length=" + i3);
        }
        if (i3 > 32) {
            arraycopyBooleanUnchecked(zArr, i, zArr2, i2, i3);
        } else if (zArr != zArr2 || i >= i2 || i2 >= i + i3) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i3) {
                    return;
                }
                zArr2[i2 + i5] = zArr[i + i5];
                i4 = i5 + 1;
            }
        } else {
            while (true) {
                i3--;
                if (i3 < 0) {
                    return;
                }
                zArr2[i2 + i3] = zArr[i + i3];
            }
        }
    }

    private static native void arraycopyBooleanUnchecked(boolean[] zArr, int i, boolean[] zArr2, int i2, int i3);

    private static native void arraycopyByteUnchecked(byte[] bArr, int i, byte[] bArr2, int i2, int i3);

    private static native void arraycopyCharUnchecked(char[] cArr, int i, char[] cArr2, int i2, int i3);

    private static native void arraycopyDoubleUnchecked(double[] dArr, int i, double[] dArr2, int i2, int i3);

    private static native void arraycopyFloatUnchecked(float[] fArr, int i, float[] fArr2, int i2, int i3);

    private static native void arraycopyIntUnchecked(int[] iArr, int i, int[] iArr2, int i2, int i3);

    private static native void arraycopyLongUnchecked(long[] jArr, int i, long[] jArr2, int i2, int i3);

    private static native void arraycopyShortUnchecked(short[] sArr, int i, short[] sArr2, int i2, int i3);

    private static void checkPropertyName(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
    }

    public static String clearProperty(String str) {
        checkPropertyName(str);
        return (String) systemProperties.remove(str);
    }

    public static Console console() {
        return Console.getConsole();
    }

    private static Properties createSystemProperties() {
        PropertiesWithNonOverrideableDefaults propertiesWithNonOverrideableDefaults = new PropertiesWithNonOverrideableDefaults(unchangeableSystemProperties);
        setDefaultChangeableProperties(propertiesWithNonOverrideableDefaults);
        return propertiesWithNonOverrideableDefaults;
    }

    public static native long currentTimeMillis();

    public static void exit(int i) {
        Runtime.getRuntime().exit(i);
    }

    public static void gc() {
        boolean z;
        synchronized (lock) {
            z = justRanFinalization;
            if (z) {
                justRanFinalization = false;
            } else {
                runGC = true;
            }
        }
        if (z) {
            Runtime.getRuntime().gc();
        }
    }

    public static Properties getProperties() {
        return systemProperties;
    }

    public static String getProperty(String str) {
        return getProperty(str, null);
    }

    public static String getProperty(String str, String str2) {
        checkPropertyName(str);
        return systemProperties.getProperty(str, str2);
    }

    public static SecurityManager getSecurityManager() {
        return null;
    }

    public static String getenv(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        return Libcore.os.getenv(str);
    }

    public static Map<String, String> getenv() {
        HashMap hashMap = new HashMap();
        String[] environ = Libcore.os.environ();
        int length = environ.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new SystemEnvironment(hashMap);
            }
            String str = environ[i2];
            int indexOf = str.indexOf(61);
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            i = i2 + 1;
        }
    }

    public static native int identityHashCode(Object obj);

    public static Channel inheritedChannel() throws IOException {
        return SelectorProvider.provider().inheritedChannel();
    }

    private static Properties initUnchangeableSystemProperties() {
        VMRuntime runtime = VMRuntime.getRuntime();
        Properties properties = new Properties();
        properties.put("java.boot.class.path", runtime.bootClassPath());
        properties.put("java.class.path", runtime.classPath());
        properties.put("java.class.version", "50.0");
        properties.put("java.compiler", "");
        properties.put("java.ext.dirs", "");
        properties.put("java.version", "0");
        String str = getenv("JAVA_HOME");
        String str2 = str;
        if (str == null) {
            str2 = "/system";
        }
        properties.put("java.home", str2);
        properties.put("java.specification.name", "Dalvik Core Library");
        properties.put("java.specification.vendor", "The Android Project");
        properties.put("java.specification.version", "0.9");
        properties.put("java.vendor", "The Android Project");
        properties.put("java.vendor.url", "http://www.android.com/");
        properties.put("java.vm.name", "Dalvik");
        properties.put("java.vm.specification.name", "Dalvik Virtual Machine Specification");
        properties.put("java.vm.specification.vendor", "The Android Project");
        properties.put("java.vm.specification.version", "0.9");
        properties.put("java.vm.vendor", "The Android Project");
        properties.put("java.vm.version", runtime.vmVersion());
        properties.put("file.separator", BridgeUtil.SPLIT_MARK);
        properties.put("line.separator", "\n");
        properties.put("path.separator", ":");
        properties.put("java.runtime.name", "Android Runtime");
        properties.put("java.runtime.version", "0.9");
        properties.put("java.vm.vendor.url", "http://www.android.com/");
        properties.put("file.encoding", "UTF-8");
        properties.put("user.language", "en");
        properties.put("user.region", "US");
        try {
            properties.put("user.name", Libcore.os.getpwuid(Libcore.os.getuid()).pw_name);
            StructUtsname uname = Libcore.os.uname();
            properties.put("os.arch", uname.machine);
            properties.put("os.name", uname.sysname);
            properties.put("os.version", uname.release);
            properties.put("android.icu.library.version", ICU.getIcuVersion());
            properties.put("android.icu.unicode.version", ICU.getUnicodeVersion());
            properties.put("android.icu.cldr.version", ICU.getCldrVersion());
            parsePropertyAssignments(properties, specialProperties());
            parsePropertyAssignments(properties, runtime.properties());
            return properties;
        } catch (ErrnoException e) {
            throw new AssertionError(e);
        }
    }

    private static void initUnchangeableSystemProperty(String str, String str2) {
        checkPropertyName(str);
        unchangeableSystemProperties.put(str, str2);
    }

    public static String lineSeparator() {
        return lineSeparator;
    }

    public static void load(String str) {
        Runtime.getRuntime().load(str, VMStack.getCallingClassLoader());
    }

    public static void loadLibrary(String str) {
        Runtime.getRuntime().loadLibrary(str, VMStack.getCallingClassLoader());
    }

    private static native void log(char c, String str, Throwable th);

    public static void logE(String str) {
        log('E', str, null);
    }

    public static void logE(String str, Throwable th) {
        log('E', str, th);
    }

    public static void logI(String str) {
        log('I', str, null);
    }

    public static void logI(String str, Throwable th) {
        log('I', str, th);
    }

    public static void logW(String str) {
        log('W', str, null);
    }

    public static void logW(String str, Throwable th) {
        log('W', str, th);
    }

    public static native String mapLibraryName(String str);

    public static native long nanoTime();

    private static void parsePropertyAssignments(Properties properties, String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            int indexOf = str.indexOf(61);
            properties.put(str.substring(0, indexOf), str.substring(indexOf + 1));
            i = i2 + 1;
        }
    }

    public static void runFinalization() {
        boolean z;
        synchronized (lock) {
            z = runGC;
            runGC = false;
        }
        if (z) {
            Runtime.getRuntime().gc();
        }
        Runtime.getRuntime().runFinalization();
        synchronized (lock) {
            justRanFinalization = true;
        }
    }

    @Deprecated
    public static void runFinalizersOnExit(boolean z) {
        Runtime.runFinalizersOnExit(z);
    }

    private static void setDefaultChangeableProperties(Properties properties) {
        properties.put("java.io.tmpdir", "/tmp");
        properties.put("user.home", "");
    }

    public static void setErr(PrintStream printStream) {
        setFieldImpl("err", "Ljava/io/PrintStream;", printStream);
    }

    private static native void setFieldImpl(String str, String str2, Object obj);

    public static void setIn(InputStream inputStream) {
        setFieldImpl("in", "Ljava/io/InputStream;", inputStream);
    }

    public static void setOut(PrintStream printStream) {
        setFieldImpl("out", "Ljava/io/PrintStream;", printStream);
    }

    public static void setProperties(Properties properties) {
        PropertiesWithNonOverrideableDefaults propertiesWithNonOverrideableDefaults = new PropertiesWithNonOverrideableDefaults(unchangeableSystemProperties);
        if (properties != null) {
            propertiesWithNonOverrideableDefaults.putAll(properties);
        } else {
            setDefaultChangeableProperties(propertiesWithNonOverrideableDefaults);
        }
        systemProperties = propertiesWithNonOverrideableDefaults;
    }

    public static String setProperty(String str, String str2) {
        checkPropertyName(str);
        return (String) systemProperties.setProperty(str, str2);
    }

    public static void setSecurityManager(SecurityManager securityManager) {
        if (securityManager != null) {
            throw new SecurityException();
        }
    }

    private static native String[] specialProperties();
}
