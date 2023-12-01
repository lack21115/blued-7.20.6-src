package com.kwad.sdk.utils.kwai;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/h.class */
final class h {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/h$a.class */
    static final class a {
        static final SecureRandom aCI = new SecureRandom();
        static final char[] aCJ = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Fy() {
        byte[] bArr = new byte[16];
        a.aCI.nextBytes(bArr);
        char[] cArr = new char[32];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return new String(cArr);
            }
            byte b = bArr[i2];
            int i3 = i2 << 1;
            cArr[i3] = a.aCJ[(b >> 4) & 15];
            cArr[i3 + 1] = a.aCJ[b & 15];
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Fz() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), new Object[0])).intValue();
        } catch (Throwable th) {
            return 4096;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Y(File file) {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] Z(File file) {
        if (file.isFile()) {
            long length = file.length();
            if ((length >> 32) != 0) {
                throw new IllegalArgumentException("file too large, path:" + file.getPath());
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            a(file, bArr, i);
            return bArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file, byte[] bArr, int i) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            try {
                int read = randomAccessFile.read(bArr, i3, i - i3);
                if (read < 0) {
                    break;
                }
                i2 = i3 + read;
            } finally {
                closeQuietly(randomAccessFile);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(File file, byte[] bArr) {
        try {
            String parent = file.getParent();
            File file2 = new File(parent, file.getName() + ".tmp");
            if (Y(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.setLength(bArr.length);
                randomAccessFile.write(bArr);
                closeQuietly(randomAccessFile);
                if (!file.exists() || file.delete()) {
                    return file2.renameTo(file);
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static void aa(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                aa(listFiles[i2]);
                i = i2 + 1;
            }
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int binarySearch(int[] iArr, int i) {
        int length = (iArr.length >> 1) - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (i2 + length) >>> 1;
            int i4 = iArr[i3 << 1];
            if (i4 < i) {
                i2 = i3 + 1;
            } else if (i4 <= i) {
                return i3;
            } else {
                length = i3 - 1;
            }
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) {
        try {
            if (file.exists()) {
                aa(file);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }
}
