package de.robv.android.xposed.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/services/DirectAccessService.class */
public final class DirectAccessService extends BaseService {
    @Override // de.robv.android.xposed.services.BaseService
    public boolean checkFileAccess(String str, int i) {
        File file = new File(str);
        if (i != 0 || file.exists()) {
            if ((i & 4) == 0 || file.canRead()) {
                if ((i & 2) == 0 || file.canWrite()) {
                    return (i & 1) == 0 || file.canExecute();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public boolean checkFileExists(String str) {
        return new File(str).exists();
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult getFileInputStream(String str, long j, long j2) throws IOException {
        File file = new File(str);
        long length = file.length();
        long lastModified = file.lastModified();
        return (j == length && j2 == lastModified) ? new FileResult(length, lastModified) : new FileResult(new BufferedInputStream(new FileInputStream(str), 16384), length, lastModified);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public InputStream getFileInputStream(String str) throws IOException {
        return new BufferedInputStream(new FileInputStream(str), 16384);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public boolean hasDirectFileAccess() {
        return true;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String str, int i, int i2, long j, long j2) throws IOException {
        File file = new File(str);
        long length = file.length();
        long lastModified = file.lastModified();
        if (j == length && j2 == lastModified) {
            return new FileResult(length, lastModified);
        }
        if (i > 0 || i2 > 0) {
            if (i <= 0 || i < length) {
                int i3 = i;
                if (i < 0) {
                    i3 = 0;
                }
                if (i2 <= 0 || i3 + i2 <= length) {
                    int i4 = i2;
                    if (i2 <= 0) {
                        i4 = (int) (length - i3);
                    }
                    byte[] bArr = new byte[i4];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.skip(i3);
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    return new FileResult(bArr, length, lastModified);
                }
                throw new IllegalArgumentException("Length " + i2 + " is out of range for " + str);
            }
            throw new IllegalArgumentException("Offset " + i + " is out of range for " + str);
        }
        return new FileResult(readFile(str), length, lastModified);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String str, long j, long j2) throws IOException {
        File file = new File(str);
        long length = file.length();
        long lastModified = file.lastModified();
        return (j == length && j2 == lastModified) ? new FileResult(length, lastModified) : new FileResult(readFile(str), length, lastModified);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public byte[] readFile(String str) throws IOException {
        File file = new File(str);
        byte[] bArr = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bArr);
        fileInputStream.close();
        return bArr;
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult statFile(String str) throws IOException {
        File file = new File(str);
        return new FileResult(file.length(), file.lastModified());
    }
}
