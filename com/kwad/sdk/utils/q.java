package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/q.class */
public final class q {
    public static final BigInteger azA;
    public static final BigInteger azB;
    public static final BigInteger azC;
    public static final char azD;
    public static final BigInteger azE;
    public static final BigInteger azF;
    public static final File[] azG;
    public static final String azH;
    private static final char azI;
    public static final BigInteger azx;
    public static final BigInteger azy;
    public static final BigInteger azz;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        azx = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        azy = multiply;
        BigInteger multiply2 = azx.multiply(multiply);
        azz = multiply2;
        BigInteger multiply3 = azx.multiply(multiply2);
        azA = multiply3;
        BigInteger multiply4 = azx.multiply(multiply3);
        azB = multiply4;
        azC = azx.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(STMobileHumanActionNative.ST_MOBILE_SEG_SKY));
        azE = multiply5;
        azF = azx.multiply(multiply5);
        azG = new File[0];
        azH = Character.toString('.');
        azI = File.separatorChar;
        azD = Dc() ? '/' : '\\';
    }

    private static boolean Dc() {
        return azI == '\\';
    }

    public static String G(Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }

    public static boolean G(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean H(File file) {
        return file.exists();
    }

    private static FileInputStream I(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    private static FileOutputStream J(File file) {
        return a(file, false);
    }

    public static void K(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IOException("Could not find parent directory");
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            file.createNewFile();
            return;
        }
        throw new IOException("Directory '" + parentFile + "' could not be created");
    }

    private static void L(File file) {
        if (file.exists()) {
            if (!U(file)) {
                O(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean M(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                O(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean N(File file) {
        return M(file);
    }

    public static void O(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            IOException e = null;
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                try {
                    R(listFiles[i2]);
                } catch (IOException e2) {
                    e = e2;
                }
                i = i2 + 1;
            }
            if (e != null) {
                throw e;
            }
        }
    }

    public static byte[] P(File file) {
        return Q(file).getBytes();
    }

    public static String Q(File file) {
        return a(file, Charset.defaultCharset());
    }

    private static void R(File file) {
        if (file.isDirectory()) {
            L(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (exists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static void S(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isDirectory()) {
            return;
        } else {
            if (!M(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static void T(File file) {
        M(file);
        n(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    private static boolean U(File file) {
        ao.checkNotNull(file);
        if (Dc()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean V(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        c(file, file2);
        return M(file2);
    }

    public static FileOutputStream a(File file, boolean z) {
        K(file);
        return new FileOutputStream(file, z);
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = I(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String a2 = com.kwad.sdk.crash.utils.h.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void a(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Asset path is empty.");
        }
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            inputStream = open;
            b(open, file);
            com.kwad.sdk.crash.utils.b.closeQuietly(open);
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z) {
        ArrayList arrayList;
        File[] listFiles;
        ao.f(file, "Source");
        ao.f(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath()) && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                ArrayList arrayList2 = new ArrayList(listFiles.length);
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    arrayList = arrayList2;
                    if (i2 >= length) {
                        break;
                    }
                    arrayList2.add(new File(file2, listFiles[i2].getName()).getCanonicalPath());
                    i = i2 + 1;
                }
            } else {
                arrayList = null;
            }
            a(file, file2, null, z, arrayList);
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            File file3 = listFiles[i2];
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    a(file3, file4, fileFilter, z, list);
                } else {
                    c(file3, file4, z);
                }
            }
            i = i2 + 1;
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.a(str, fileOutputStream, charset);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private static void b(File file, File file2, boolean z) {
        ao.f(file, "Source");
        ao.f(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                c(file, file2, true);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    private static void b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = J(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.g(inputStream, fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
    }

    private static void c(File file, File file2, boolean z) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel = fileInputStream2.getChannel();
                    try {
                        FileChannel channel2 = fileOutputStream.getChannel();
                        long size = channel.size();
                        long j = 0;
                        while (true) {
                            long j2 = j;
                            if (j2 >= size) {
                                break;
                            }
                            long j3 = size - j2;
                            if (j3 > 31457280) {
                                j3 = 31457280;
                            }
                            fileChannel2 = channel2;
                            j = j2 + channel2.transferFrom(channel, j2, j3);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(channel2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(channel);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        if (file.length() == file2.length()) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                    fileChannel2 = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                fileOutputStream = null;
                fileChannel = null;
                fileInputStream2 = fileInputStream;
                fileChannel2 = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    private static boolean c(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            d(file, file2);
            try {
                file.delete();
                return true;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                return true;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return false;
        }
    }

    public static void d(File file, File file2) {
        b(file, file2, true);
    }

    private static void d(File file, File file2, boolean z) {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean delete(String str) {
        return M(new File(str));
    }

    public static void deleteContents(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            file2.delete();
            i = i2 + 1;
        }
    }

    public static void e(File file, File file2) {
        d(file, file2, true);
    }

    public static BufferedInputStream eu(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return null;
            }
            return new BufferedInputStream(fileInputStream);
        }
        return null;
    }

    public static boolean ev(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean ew(String str) {
        return !TextUtils.isEmpty(str) && G(new File(str));
    }

    private static int ex(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int ey(String str) {
        int lastIndexOf;
        if (str != null && ex(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int ey = ey(str);
        return ey == -1 ? "" : str.substring(ey + 1);
    }

    private static void n(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(J(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }
}
