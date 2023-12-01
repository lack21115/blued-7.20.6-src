package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/la.class */
public class la {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23926a = "LibaryLoaderHelper";

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f23927c = !la.class.desiredAssertionStatus();
    private static boolean b = false;

    public static File a(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    private static File a(Context context, String str) {
        return new File(a(context), System.mapLibraryName(str));
    }

    private static ZipEntry a(ZipFile zipFile, String str) {
        ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
        if (entry != null) {
            return entry;
        }
        return zipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(str));
    }

    private static void a(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    File file2 = listFiles[i2];
                    file2.getName();
                    if (!file2.delete() && Log.isLoggable(f23926a, 6)) {
                        Log.e(f23926a, "Failed to remove " + file2.getAbsolutePath());
                    }
                    i = i2 + 1;
                }
            }
            if (file.delete() || !Log.isLoggable(f23926a, 6)) {
                return;
            }
            Log.e(f23926a, "Failed to remove " + file.getAbsolutePath());
        } catch (Exception e) {
            if (Log.isLoggable(f23926a, 6)) {
                Log.e(f23926a, "Failed to remove old libs, ", e);
            }
        }
    }

    private static boolean b(Context context) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        if (b) {
            return false;
        }
        b = true;
        File a2 = a(context);
        a(a2);
        try {
            ZipFile zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            String[] strArr = ka.b;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    zipFile.close();
                    return true;
                }
                String str = strArr[i2];
                ZipEntry a3 = a(zipFile, str);
                if (a3 == null) {
                    zipFile.close();
                    a(a2);
                    return false;
                }
                String name = a3.getName();
                if (name == null || (!name.contains("../") && !name.contains(".."))) {
                    File a4 = a(context, str);
                    if (Log.isLoggable(f23926a, 4)) {
                        Log.i(f23926a, "Extracting native libraries into " + a4.getAbsolutePath());
                    }
                    if (!f23927c && a4.exists()) {
                        throw new AssertionError();
                    }
                    try {
                        if (!a4.createNewFile()) {
                            throw new IOException();
                        }
                        FileOutputStream fileOutputStream2 = null;
                        try {
                            inputStream = zipFile.getInputStream(a3);
                            try {
                                fileOutputStream = new FileOutputStream(a4);
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                byte[] bArr = new byte[16384];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                inputStream.close();
                                fileOutputStream.close();
                                if (Build.VERSION.SDK_INT >= 9) {
                                    a4.setReadable(true, false);
                                    a4.setExecutable(true, false);
                                    a4.setWritable(true);
                                }
                                i = i2 + 1;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                    } catch (IOException e) {
                        if (a4.exists() && !a4.delete() && Log.isLoggable(f23926a, 6)) {
                            Log.e(f23926a, "Failed to delete " + a4.getAbsolutePath());
                        }
                        zipFile.close();
                        throw e;
                    }
                }
            }
            zipFile.close();
            a(a2);
            return false;
        } catch (IOException e2) {
            if (Log.isLoggable(f23926a, 6)) {
                Log.e(f23926a, "Failed to unpack native libraries", e2);
            }
            a(a2);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        if (f23927c || context != null) {
            File a2 = a(context, str);
            boolean exists = a2.exists();
            if (Log.isLoggable(f23926a, 4)) {
                Log.i(f23926a, "libary:" + a2.getAbsolutePath() + " is exist:" + exists);
            }
            if (exists || b(context)) {
                try {
                    System.load(a2.getAbsolutePath());
                    return true;
                } catch (UnsatisfiedLinkError e) {
                    return false;
                }
            }
            return false;
        }
        throw new AssertionError();
    }
}
