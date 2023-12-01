package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r2.class */
public class r2 {
    public static boolean a(File file, File file2, boolean z) {
        byte[] a2 = g2.a().a(2048);
        try {
            long length = file.length();
            File file3 = new File(file.getAbsolutePath() + ".tmp");
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file3));
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(a2);
                if (read == -1) {
                    break;
                }
                gZIPOutputStream.write(a2, 0, read);
            }
            fileInputStream.close();
            gZIPOutputStream.close();
            if (z) {
                file.delete();
            }
            file3.renameTo(file2);
            long length2 = file2.length();
            String.format(Locale.ENGLISH, "compressFileGzip:%s,%d,%s,%d,%.2f", file.getName(), Long.valueOf(length), file2.getName(), Long.valueOf(length2), Double.valueOf(length2 / length));
            g2.a().a(a2);
            return true;
        } catch (Throwable th) {
            try {
                file.getName();
                file.length();
                g2.a().a(a2);
                return false;
            } catch (Throwable th2) {
                g2.a().a(a2);
                throw th2;
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        l3.a(bArr);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            return k2.f3860a;
        }
    }
}
