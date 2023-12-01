package dalvik.system;

import android.system.ErrnoException;
import com.blued.android.module.common.web.LoaderConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/DexFile.class */
public final class DexFile {
    public static final byte DEXOPT_NEEDED = 2;
    public static final byte PATCHOAT_NEEDED = 1;
    public static final byte UP_TO_DATE = 0;
    private final CloseGuard guard;
    private long mCookie;
    private final String mFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/DexFile$DFEnum.class */
    public class DFEnum implements Enumeration<String> {
        private int mIndex = 0;
        private String[] mNameList;

        DFEnum(DexFile dexFile) {
            this.mNameList = DexFile.getClassNameList(DexFile.this.mCookie);
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.mIndex < this.mNameList.length;
        }

        @Override // java.util.Enumeration
        public String nextElement() {
            String[] strArr = this.mNameList;
            int i = this.mIndex;
            this.mIndex = i + 1;
            return strArr[i];
        }
    }

    public DexFile(File file) throws IOException {
        this(file.getPath());
    }

    public DexFile(String str) throws IOException {
        this.guard = CloseGuard.get();
        this.mCookie = openDexFile(str, null, 0);
        this.mFileName = str;
        this.guard.open(LoaderConstants.CLOSE);
    }

    private DexFile(String str, String str2, int i) throws IOException {
        this.guard = CloseGuard.get();
        if (str2 != null) {
            try {
                String parent = new File(str2).getParent();
                if (Libcore.os.getuid() != Libcore.os.stat(parent).st_uid) {
                    throw new IllegalArgumentException("Optimized data directory " + parent + " is not owned by the current user. Shared storage cannot protect your application from code injection attacks.");
                }
            } catch (ErrnoException e) {
            }
        }
        this.mCookie = openDexFile(str, str2, i);
        this.mFileName = str;
        this.guard.open(LoaderConstants.CLOSE);
    }

    private static native void closeDexFile(long j);

    private static Class defineClass(String str, ClassLoader classLoader, long j, List<Throwable> list) {
        Class cls;
        try {
            cls = defineClassNative(str, classLoader, j);
        } catch (ClassNotFoundException e) {
            cls = null;
            if (list != null) {
                list.add(e);
                return null;
            }
        } catch (NoClassDefFoundError e2) {
            cls = null;
            if (list != null) {
                list.add(e2);
                return null;
            }
        }
        return cls;
    }

    private static native Class defineClassNative(String str, ClassLoader classLoader, long j) throws ClassNotFoundException, NoClassDefFoundError;

    /* JADX INFO: Access modifiers changed from: private */
    public static native String[] getClassNameList(long j);

    public static native boolean isDexOptNeeded(String str) throws FileNotFoundException, IOException;

    public static native byte isDexOptNeededInternal(String str, String str2, String str3, boolean z) throws FileNotFoundException, IOException;

    public static DexFile loadDex(String str, String str2, int i) throws IOException {
        return new DexFile(str, str2, i);
    }

    private static long openDexFile(String str, String str2, int i) throws IOException {
        return openDexFileNative(new File(str).getAbsolutePath(), str2 == null ? null : new File(str2).getAbsolutePath(), i);
    }

    private static native long openDexFileNative(String str, String str2, int i);

    public void close() throws IOException {
        if (this.mCookie != 0) {
            this.guard.close();
            closeDexFile(this.mCookie);
            this.mCookie = 0L;
        }
    }

    public Enumeration<String> entries() {
        return new DFEnum(this);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            close();
        } finally {
            super.finalize();
        }
    }

    public String getName() {
        return this.mFileName;
    }

    public Class loadClass(String str, ClassLoader classLoader) {
        return loadClassBinaryName(str.replace('.', '/'), classLoader, null);
    }

    public Class loadClassBinaryName(String str, ClassLoader classLoader, List<Throwable> list) {
        return defineClass(str, classLoader, this.mCookie, list);
    }

    public String toString() {
        return getName();
    }
}
