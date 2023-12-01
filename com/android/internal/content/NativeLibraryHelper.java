package com.android.internal.content;

import android.content.pm.PackageParser;
import android.os.Build;
import android.os.SELinux;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Slog;
import com.blued.android.module.common.web.LoaderConstants;
import dalvik.system.CloseGuard;
import dalvik.system.VMRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/content/NativeLibraryHelper.class */
public class NativeLibraryHelper {
    private static final int BITCODE_PRESENT = 1;
    public static final String CLEAR_ABI_OVERRIDE = "-";
    private static final boolean DEBUG_NATIVE = false;
    public static final String LIB64_DIR_NAME = "lib64";
    public static final String LIB_DIR_NAME = "lib";
    private static final String TAG = "NativeHelper";

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/content/NativeLibraryHelper$Handle.class */
    public static class Handle implements Closeable {
        final long[] apkHandles;
        private volatile boolean mClosed;
        private final CloseGuard mGuard = CloseGuard.get();
        final boolean multiArch;

        Handle(long[] jArr, boolean z) {
            this.apkHandles = jArr;
            this.multiArch = z;
            this.mGuard.open(LoaderConstants.CLOSE);
        }

        public static Handle create(PackageParser.Package r3) throws IOException {
            return create(r3.getAllCodePaths(), (r3.applicationInfo.flags & Integer.MIN_VALUE) != 0);
        }

        public static Handle create(PackageParser.PackageLite packageLite) throws IOException {
            return create(packageLite.getAllCodePaths(), packageLite.multiArch);
        }

        public static Handle create(File file) throws IOException {
            try {
                return create(PackageParser.parsePackageLite(file, 0));
            } catch (PackageParser.PackageParserException e) {
                throw new IOException("Failed to parse package: " + file, e);
            }
        }

        private static Handle create(List<String> list, boolean z) throws IOException {
            int size = list.size();
            long[] jArr = new long[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return new Handle(jArr, z);
                }
                String str = list.get(i2);
                jArr[i2] = NativeLibraryHelper.nativeOpenApk(str);
                if (jArr[i2] == 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= i2) {
                            break;
                        }
                        NativeLibraryHelper.nativeClose(jArr[i4]);
                        i3 = i4 + 1;
                    }
                    throw new IOException("Unable to open APK: " + str);
                }
                i = i2 + 1;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long[] jArr = this.apkHandles;
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    this.mGuard.close();
                    this.mClosed = true;
                    return;
                }
                NativeLibraryHelper.nativeClose(jArr[i2]);
                i = i2 + 1;
            }
        }

        protected void finalize() throws Throwable {
            if (this.mGuard != null) {
                this.mGuard.warnIfOpen();
            }
            try {
                if (!this.mClosed) {
                    close();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static int copyNativeBinaries(Handle handle, File file, String str) {
        long[] jArr = handle.apkHandles;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 1;
            }
            int nativeCopyNativeBinaries = nativeCopyNativeBinaries(jArr[i2], file.getPath(), str);
            if (nativeCopyNativeBinaries != 1) {
                return nativeCopyNativeBinaries;
            }
            i = i2 + 1;
        }
    }

    public static int copyNativeBinariesForSupportedAbi(Handle handle, File file, String[] strArr, boolean z) throws IOException {
        createNativeLibrarySubdir(file);
        int findSupportedAbi = findSupportedAbi(handle, strArr);
        if (findSupportedAbi >= 0) {
            String instructionSet = VMRuntime.getInstructionSet(strArr[findSupportedAbi]);
            if (z) {
                file = new File(file, instructionSet);
                createNativeLibrarySubdir(file);
            }
            int copyNativeBinaries = copyNativeBinaries(handle, file, strArr[findSupportedAbi]);
            if (copyNativeBinaries != 1) {
                return copyNativeBinaries;
            }
        }
        return findSupportedAbi;
    }

    public static int copyNativeBinariesWithOverride(Handle handle, File file, String str) {
        String[] strArr;
        int copyNativeBinariesForSupportedAbi;
        int copyNativeBinariesForSupportedAbi2;
        try {
            if (handle.multiArch) {
                if (str != null && !CLEAR_ABI_OVERRIDE.equals(str)) {
                    Slog.w(TAG, "Ignoring abiOverride for multi arch application.");
                }
                if (Build.SUPPORTED_32_BIT_ABIS.length > 0 && (copyNativeBinariesForSupportedAbi2 = copyNativeBinariesForSupportedAbi(handle, file, Build.SUPPORTED_32_BIT_ABIS, true)) < 0 && copyNativeBinariesForSupportedAbi2 != -114 && copyNativeBinariesForSupportedAbi2 != -113) {
                    Slog.w(TAG, "Failure copying 32 bit native libraries; copyRet=" + copyNativeBinariesForSupportedAbi2);
                    return copyNativeBinariesForSupportedAbi2;
                } else if (Build.SUPPORTED_64_BIT_ABIS.length <= 0 || (copyNativeBinariesForSupportedAbi = copyNativeBinariesForSupportedAbi(handle, file, Build.SUPPORTED_64_BIT_ABIS, true)) >= 0 || copyNativeBinariesForSupportedAbi == -114 || copyNativeBinariesForSupportedAbi == -113) {
                    return 1;
                } else {
                    Slog.w(TAG, "Failure copying 64 bit native libraries; copyRet=" + copyNativeBinariesForSupportedAbi);
                    return copyNativeBinariesForSupportedAbi;
                }
            }
            String str2 = null;
            if (CLEAR_ABI_OVERRIDE.equals(str)) {
                str2 = null;
            } else if (str != null) {
                str2 = str;
            }
            if (str2 != null) {
                strArr = new String[1];
                strArr[0] = str2;
            } else {
                strArr = Build.SUPPORTED_ABIS;
            }
            String[] strArr2 = strArr;
            if (Build.SUPPORTED_64_BIT_ABIS.length > 0) {
                strArr2 = strArr;
                if (str2 == null) {
                    strArr2 = strArr;
                    if (hasRenderscriptBitcode(handle)) {
                        strArr2 = Build.SUPPORTED_32_BIT_ABIS;
                    }
                }
            }
            int copyNativeBinariesForSupportedAbi3 = copyNativeBinariesForSupportedAbi(handle, file, strArr2, true);
            if (copyNativeBinariesForSupportedAbi3 >= 0 || copyNativeBinariesForSupportedAbi3 == -114) {
                return 1;
            }
            Slog.w(TAG, "Failure copying native libraries [errorCode=" + copyNativeBinariesForSupportedAbi3 + "]");
            return copyNativeBinariesForSupportedAbi3;
        } catch (IOException e) {
            Slog.e(TAG, "Copying native libraries failed", e);
            return -110;
        }
    }

    private static void createNativeLibrarySubdir(File file) throws IOException {
        if (file.isDirectory()) {
            if (!SELinux.restorecon(file)) {
                throw new IOException("Cannot set SELinux context for " + file.getPath());
            }
            return;
        }
        file.delete();
        if (!file.mkdir()) {
            throw new IOException("Cannot create " + file.getPath());
        }
        try {
            Os.chmod(file.getPath(), OsConstants.S_IRWXU | OsConstants.S_IRGRP | OsConstants.S_IXGRP | OsConstants.S_IROTH | OsConstants.S_IXOTH);
        } catch (ErrnoException e) {
            throw new IOException("Cannot chmod native library directory " + file.getPath(), e);
        }
    }

    public static int findSupportedAbi(Handle handle, String[] strArr) {
        int i;
        int i2;
        int i3 = -114;
        long[] jArr = handle.apkHandles;
        int length = jArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i = i3;
                break;
            }
            int nativeFindSupportedAbi = nativeFindSupportedAbi(jArr[i4], strArr);
            if (nativeFindSupportedAbi != -114) {
                if (nativeFindSupportedAbi != -113) {
                    i = nativeFindSupportedAbi;
                    if (nativeFindSupportedAbi < 0) {
                        break;
                    }
                    if (i3 >= 0) {
                        i2 = i3;
                        if (nativeFindSupportedAbi >= i3) {
                        }
                    }
                    i2 = nativeFindSupportedAbi;
                } else {
                    i2 = i3;
                    if (i3 < 0) {
                        i2 = -113;
                    }
                }
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        return i;
    }

    private static native int hasRenderscriptBitcode(long j);

    public static boolean hasRenderscriptBitcode(Handle handle) throws IOException {
        long[] jArr = handle.apkHandles;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            int hasRenderscriptBitcode = hasRenderscriptBitcode(jArr[i2]);
            if (hasRenderscriptBitcode < 0) {
                throw new IOException("Error scanning APK, code: " + hasRenderscriptBitcode);
            }
            if (hasRenderscriptBitcode == 1) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClose(long j);

    private static native int nativeCopyNativeBinaries(long j, String str, String str2);

    private static native int nativeFindSupportedAbi(long j, String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeOpenApk(String str);

    private static native long nativeSumNativeBinaries(long j, String str);

    public static void removeNativeBinariesFromDirLI(File file, boolean z) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listFiles.length) {
                        break;
                    }
                    if (listFiles[i2].isDirectory()) {
                        removeNativeBinariesFromDirLI(listFiles[i2], true);
                    } else if (!listFiles[i2].delete()) {
                        Slog.w(TAG, "Could not delete native binary: " + listFiles[i2].getPath());
                    }
                    i = i2 + 1;
                }
            }
            if (!z || file.delete()) {
                return;
            }
            Slog.w(TAG, "Could not delete native binary directory: " + file.getPath());
        }
    }

    public static void removeNativeBinariesLI(String str) {
        if (str == null) {
            return;
        }
        removeNativeBinariesFromDirLI(new File(str), false);
    }

    private static long sumNativeBinaries(Handle handle, String str) {
        long j = 0;
        long[] jArr = handle.apkHandles;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return j;
            }
            j += nativeSumNativeBinaries(jArr[i2], str);
            i = i2 + 1;
        }
    }

    private static long sumNativeBinariesForSupportedAbi(Handle handle, String[] strArr) {
        int findSupportedAbi = findSupportedAbi(handle, strArr);
        if (findSupportedAbi >= 0) {
            return sumNativeBinaries(handle, strArr[findSupportedAbi]);
        }
        return 0L;
    }

    public static long sumNativeBinariesWithOverride(Handle handle, String str) throws IOException {
        long j = 0;
        if (handle.multiArch) {
            if (str != null && !CLEAR_ABI_OVERRIDE.equals(str)) {
                Slog.w(TAG, "Ignoring abiOverride for multi arch application.");
            }
            if (Build.SUPPORTED_32_BIT_ABIS.length > 0) {
                j = 0 + sumNativeBinariesForSupportedAbi(handle, Build.SUPPORTED_32_BIT_ABIS);
            }
            long j2 = j;
            if (Build.SUPPORTED_64_BIT_ABIS.length > 0) {
                j2 = j + sumNativeBinariesForSupportedAbi(handle, Build.SUPPORTED_64_BIT_ABIS);
            }
            return j2;
        }
        String str2 = null;
        if (CLEAR_ABI_OVERRIDE.equals(str)) {
            str2 = null;
        } else if (str != null) {
            str2 = str;
        }
        String[] strArr = str2 != null ? new String[]{str2} : Build.SUPPORTED_ABIS;
        String[] strArr2 = strArr;
        if (Build.SUPPORTED_64_BIT_ABIS.length > 0) {
            strArr2 = strArr;
            if (str2 == null) {
                strArr2 = strArr;
                if (hasRenderscriptBitcode(handle)) {
                    strArr2 = Build.SUPPORTED_32_BIT_ABIS;
                }
            }
        }
        return 0 + sumNativeBinariesForSupportedAbi(handle, strArr2);
    }
}
