package de.robv.android.xposed.services;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/services/BaseService.class */
public abstract class BaseService {
    public static final int F_OK = 0;
    public static final int R_OK = 4;
    public static final int W_OK = 2;
    public static final int X_OK = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ensureAbsolutePath(String str) {
        if (!str.startsWith(BridgeUtil.SPLIT_MARK)) {
            throw new IllegalArgumentException("Only absolute filenames are allowed: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwCommonIOException(int i, String str, String str2, String str3) throws IOException {
        switch (i) {
            case 1:
            case 13:
                if (str == null) {
                    str = "Permission denied: " + str2;
                }
                throw new FileNotFoundException(str);
            case 2:
                if (str == null) {
                    str = "No such file or directory: " + str2;
                }
                throw new FileNotFoundException(str);
            case 12:
                throw new OutOfMemoryError(str);
            case 21:
                if (str == null) {
                    str = "Is a directory: " + str2;
                }
                throw new FileNotFoundException(str);
            default:
                if (str == null) {
                    str = "Error " + i + str3 + str2;
                }
                throw new IOException(str);
        }
    }

    public abstract boolean checkFileAccess(String str, int i);

    public boolean checkFileExists(String str) {
        return checkFileAccess(str, 0);
    }

    public FileResult getFileInputStream(String str, long j, long j2) throws IOException {
        FileResult readFile = readFile(str, j, j2);
        return readFile.content == null ? readFile : new FileResult(new ByteArrayInputStream(readFile.content), readFile.size, readFile.mtime);
    }

    public InputStream getFileInputStream(String str) throws IOException {
        return new ByteArrayInputStream(readFile(str));
    }

    public long getFileModificationTime(String str) throws IOException {
        return statFile(str).mtime;
    }

    public long getFileSize(String str) throws IOException {
        return statFile(str).size;
    }

    public boolean hasDirectFileAccess() {
        return false;
    }

    public abstract FileResult readFile(String str, int i, int i2, long j, long j2) throws IOException;

    public abstract FileResult readFile(String str, long j, long j2) throws IOException;

    public abstract byte[] readFile(String str) throws IOException;

    public abstract FileResult statFile(String str) throws IOException;
}
