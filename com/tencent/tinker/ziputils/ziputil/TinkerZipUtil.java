package com.tencent.tinker.ziputils.ziputil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/TinkerZipUtil.class */
public class TinkerZipUtil {
    private static final int BUFFER_SIZE = 16384;

    public static void extractLargeModifyFile(TinkerZipEntry tinkerZipEntry, File file, long j, TinkerZipOutputStream tinkerZipOutputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        TinkerZipEntry tinkerZipEntry2 = new TinkerZipEntry(tinkerZipEntry);
        tinkerZipEntry2.setMethod(0);
        tinkerZipEntry2.setSize(file.length());
        tinkerZipEntry2.setCompressedSize(file.length());
        tinkerZipEntry2.setCrc(j);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            tinkerZipOutputStream.putNextEntry(new TinkerZipEntry(tinkerZipEntry2));
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    tinkerZipOutputStream.closeEntry();
                    bufferedInputStream.close();
                    return;
                }
                tinkerZipOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            bufferedInputStream2 = bufferedInputStream;
            th = th2;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    public static void extractTinkerEntry(TinkerZipFile tinkerZipFile, TinkerZipEntry tinkerZipEntry, TinkerZipOutputStream tinkerZipOutputStream) throws IOException {
        InputStream inputStream;
        try {
            inputStream = tinkerZipFile.getInputStream(tinkerZipEntry);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            tinkerZipOutputStream.putNextEntry(new TinkerZipEntry(tinkerZipEntry));
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                tinkerZipOutputStream.write(bArr, 0, read);
            }
            tinkerZipOutputStream.closeEntry();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static boolean validateZipEntryName(File file, String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            String canonicalPath2 = file.toPath().resolve(str).toFile().getCanonicalPath();
            return canonicalPath2.startsWith(canonicalPath + File.separator);
        } catch (Throwable th) {
            return false;
        }
    }
}
