package c.t.m.g;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/z2.class */
public class z2 {

    /* renamed from: a  reason: collision with root package name */
    public static File f4025a;

    public static File a(Context context, String str) {
        if (f4025a != null) {
            return f4025a;
        }
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            File externalFilesDir = context.getExternalFilesDir(str);
            f4025a = externalFilesDir;
            return externalFilesDir;
        }
        File filesDir = context.getApplicationContext().getFilesDir();
        f4025a = filesDir;
        return filesDir;
    }

    @Deprecated
    public static void a(Closeable closeable) {
        e3.a(closeable);
    }

    public static void a(String str, long j) {
        File file;
        if (m3.a(str)) {
            return;
        }
        long j2 = 0;
        File file2 = null;
        try {
            File[] listFiles = new File(str).listFiles();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                file = file2;
                if (i2 >= length) {
                    break;
                }
                File file3 = listFiles[i2];
                if (file != null) {
                    file2 = file;
                    if (file.lastModified() > file3.lastModified()) {
                    }
                    j2 += file3.length();
                    i = i2 + 1;
                }
                file2 = file3;
                j2 += file3.length();
                i = i2 + 1;
            }
            if (j2 < j || file == null) {
                return;
            }
            if (g3.a()) {
                file.getName();
                file.length();
            }
            file.delete();
        } catch (Throwable th) {
        }
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                } else if (!a(listFiles[i2])) {
                    return false;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return file.delete();
    }

    public static boolean a(File file, byte[] bArr, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, z);
        } catch (Throwable th) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
            e3.a(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            e3.a(fileOutputStream);
            return false;
        }
    }

    public static byte[] b(File file) {
        BufferedInputStream bufferedInputStream;
        if (!file.exists() || file.length() == 0) {
            return k2.f3812a;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] a2 = g2.a().a(2048);
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read(a2);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        g2.a().a(a2);
                        e3.a(bufferedInputStream);
                        e3.a(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(a2, 0, read);
                } catch (Throwable th) {
                    try {
                        byte[] bArr = k2.f3812a;
                        g2.a().a(a2);
                        e3.a(bufferedInputStream);
                        e3.a(byteArrayOutputStream);
                        return bArr;
                    } catch (Throwable th2) {
                        g2.a().a(a2);
                        e3.a(bufferedInputStream);
                        e3.a(byteArrayOutputStream);
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            bufferedInputStream = null;
        }
    }
}
