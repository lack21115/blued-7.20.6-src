package de.robv.android.xposed.services;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/services/ZygoteService.class */
public final class ZygoteService extends BaseService {
    @Override // de.robv.android.xposed.services.BaseService
    public native boolean checkFileAccess(String str, int i);

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String str, int i, int i2, long j, long j2) throws IOException {
        FileResult statFile = statFile(str);
        if (j == statFile.size && j2 == statFile.mtime) {
            return statFile;
        }
        if (i > 0 || i2 > 0) {
            if (i <= 0 || i < statFile.size) {
                int i3 = i;
                if (i < 0) {
                    i3 = 0;
                }
                if (i2 <= 0 || i3 + i2 <= statFile.size) {
                    int i4 = i2;
                    if (i2 <= 0) {
                        i4 = (int) (statFile.size - i3);
                    }
                    return new FileResult(Arrays.copyOfRange(readFile(str), i3, i3 + i4), statFile.size, statFile.mtime);
                }
                throw new IllegalArgumentException("offset " + i3 + " + length " + i2 + " > size " + statFile.size + " for " + str);
            }
            throw new IllegalArgumentException("offset " + i + " >= size " + statFile.size + " for " + str);
        }
        return new FileResult(readFile(str), statFile.size, statFile.mtime);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public FileResult readFile(String str, long j, long j2) throws IOException {
        FileResult statFile = statFile(str);
        return (j == statFile.size && j2 == statFile.mtime) ? statFile : new FileResult(readFile(str), statFile.size, statFile.mtime);
    }

    @Override // de.robv.android.xposed.services.BaseService
    public native byte[] readFile(String str) throws IOException;

    @Override // de.robv.android.xposed.services.BaseService
    public native FileResult statFile(String str) throws IOException;
}
