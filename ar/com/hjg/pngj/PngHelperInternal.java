package ar.com.hjg.pngj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/PngHelperInternal.class */
public final class PngHelperInternal {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3597a = Logger.getLogger("ar.com.pngj");
    public static String b = "ISO-8859-1";

    /* renamed from: c  reason: collision with root package name */
    public static Charset f3598c = Charset.forName("ISO-8859-1");
    public static String d = "UTF-8";
    public static Charset e = Charset.forName("UTF-8");
    private static ThreadLocal<Boolean> f = new ThreadLocal<Boolean>() { // from class: ar.com.hjg.pngj.PngHelperInternal.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public static double a(int i) {
        return i / 100000.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int a(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int i5 = i4 >= i ? i4 - i : i - i4;
        int i6 = i4 >= i2 ? i4 - i2 : i2 - i4;
        int i7 = i4 >= i3 ? i4 - i3 : i3 - i4;
        return (i5 > i6 || i5 > i7) ? i6 <= i7 ? i2 : i3 : i;
    }

    public static int a(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException e2) {
            throw new PngjInputException("error reading byte", e2);
        }
    }

    public static int a(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static InputStream a(File file) {
        try {
            return new FileInputStream(file);
        } catch (Exception e2) {
            throw new PngjInputException("Could not open " + file, e2);
        }
    }

    public static void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
    }

    public static void a(OutputStream outputStream, int i) {
        byte[] bArr = new byte[4];
        a(i, bArr, 0);
        a(outputStream, bArr);
    }

    public static void a(OutputStream outputStream, byte[] bArr) {
        try {
            outputStream.write(bArr);
        } catch (IOException e2) {
            throw new PngjOutputException(e2);
        }
    }

    public static void a(OutputStream outputStream, byte[] bArr, int i, int i2) {
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e2) {
            throw new PngjOutputException(e2);
        }
    }

    public static byte[] a() {
        return new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    public static int b(InputStream inputStream) {
        try {
            int read = inputStream.read();
            int read2 = inputStream.read();
            int read3 = inputStream.read();
            int read4 = inputStream.read();
            if (read == -1 || read2 == -1 || read3 == -1 || read4 == -1) {
                return -1;
            }
            return (read << 24) | (read2 << 16) | ((read3 << 8) + read4);
        } catch (IOException e2) {
            throw new PngjInputException("error reading Int4", e2);
        }
    }

    public static int b(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static final int c(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
