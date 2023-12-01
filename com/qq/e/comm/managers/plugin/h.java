package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f14238a = b.a("e_qq_com_plugin");
    private static String b = b.a("e_qq_com_dex");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(Context context) {
        return context.getDir(b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return "gdt_plugin";
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, File file) throws IOException {
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2;
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        } catch (Throwable th) {
            th = th;
            outputStreamWriter = null;
        }
        try {
            outputStreamWriter2.write(str);
            a(outputStreamWriter2);
        } catch (Throwable th2) {
            outputStreamWriter = outputStreamWriter2;
            th = th2;
            a(outputStreamWriter);
            throw th;
        }
    }

    public static boolean a(File file, File file2) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            return a(new FileInputStream(file), file2);
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        if (inputStream == null || file == null) {
            return false;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.e("parent dir not exists " + parentFile.getAbsolutePath());
                a(inputStream);
                a((Closeable) null);
                return false;
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        a(inputStream);
                        a(fileOutputStream);
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    GDTLogger.e("Exception while copy from InputStream to File", th);
                    throw th;
                } catch (Throwable th2) {
                    a(inputStream);
                    a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File b(Context context) {
        return new File(context.getDir(f14238a, 0), "gdt_plugin.jar");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File c(Context context) {
        return new File(context.getDir(f14238a, 0), "gdt_plugin.next");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File d(Context context) {
        return new File(context.getDir(f14238a, 0), "gdt_plugin.jar.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File e(Context context) {
        return new File(context.getDir(f14238a, 0), "gdt_plugin.next.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File f(Context context) {
        return new File(context.getDir(f14238a, 0), "update_lc");
    }
}
