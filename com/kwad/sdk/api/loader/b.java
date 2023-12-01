package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/b.class */
final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, ClassLoader classLoader, String str, String str2) {
        String l = h.l(context, str2);
        c(new File(l));
        String n = h.n(context, str2);
        String o = h.o(context, str2);
        String p = h.p(context, str2);
        try {
            o(str, n);
            p(str, p);
            return k.b(context, classLoader, n, o, p).tq() != null;
        } catch (Exception e) {
            c(new File(n));
            c(new File(o));
            c(new File(p));
            c(new File(l));
            throw e;
        }
    }

    private static void c(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            c(listFiles[i2]);
            i = i2 + 1;
        }
    }

    private static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        try {
            c(inputStream, outputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception e2) {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
            try {
                outputStream.close();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    private static void o(String str, String str2) {
        d(new FileInputStream(str), new FileOutputStream(str2));
    }

    private static void p(String str, String str2) {
        ZipFile zipFile;
        ZipFile zipFile2;
        String str3 = w.is64Bit() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
        try {
            zipFile2 = new ZipFile(str);
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile2.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name) && !name.contains("../") && name.endsWith(".so") && name.startsWith(str3)) {
                        d(zipFile2.getInputStream(nextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
                    }
                }
            }
            try {
                zipFile2.close();
            } catch (Exception e) {
            }
        } catch (Throwable th2) {
            zipFile = zipFile2;
            th = th2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }
}
