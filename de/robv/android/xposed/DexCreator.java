package de.robv.android.xposed;

import android.os.Environment;
import com.alipay.sdk.util.i;
import com.android.dex.DexFormat;
import com.android.org.conscrypt.NativeCrypto;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketOptions;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/DexCreator.class */
public class DexCreator {
    public static File DALVIK_CACHE = new File(Environment.getDataDirectory(), "dalvik-cache");

    private DexCreator() {
    }

    public static byte[] create(String str, String str2) throws IOException {
        boolean z = str.compareTo(str2) < 0;
        byte[] stringToBytes = stringToBytes("L" + str.replace('.', '/') + i.b);
        byte[] stringToBytes2 = stringToBytes("L" + str2.replace('.', '/') + i.b);
        int length = stringToBytes.length + stringToBytes2.length;
        int i = (-length) & 3;
        int i2 = length + i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write("dex\n035��".getBytes());
        byteArrayOutputStream.write(new byte[24]);
        writeInt(byteArrayOutputStream, i2 + 252);
        writeInt(byteArrayOutputStream, 112);
        writeInt(byteArrayOutputStream, DexFormat.ENDIAN_TAG);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, i2 + 164);
        writeInt(byteArrayOutputStream, 2);
        writeInt(byteArrayOutputStream, 112);
        writeInt(byteArrayOutputStream, 2);
        writeInt(byteArrayOutputStream, 120);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 1);
        writeInt(byteArrayOutputStream, 128);
        writeInt(byteArrayOutputStream, i2 + 92);
        writeInt(byteArrayOutputStream, 160);
        writeInt(byteArrayOutputStream, 160);
        writeInt(byteArrayOutputStream, (z ? stringToBytes.length : stringToBytes2.length) + 160);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 1);
        writeInt(byteArrayOutputStream, z ? 0 : 1);
        writeInt(byteArrayOutputStream, 1);
        writeInt(byteArrayOutputStream, z ? 1 : 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, -1);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 0);
        byteArrayOutputStream.write(z ? stringToBytes : stringToBytes2);
        if (!z) {
            stringToBytes2 = stringToBytes;
        }
        byteArrayOutputStream.write(stringToBytes2);
        byteArrayOutputStream.write(new byte[i]);
        writeInt(byteArrayOutputStream, 0);
        writeInt(byteArrayOutputStream, 7);
        writeMapItem(byteArrayOutputStream, 0, 1, 0);
        writeMapItem(byteArrayOutputStream, 1, 2, 112);
        writeMapItem(byteArrayOutputStream, 2, 2, 120);
        writeMapItem(byteArrayOutputStream, 6, 1, 128);
        writeMapItem(byteArrayOutputStream, NativeCrypto.SSL_CB_ACCEPT_EXIT, 2, 160);
        writeMapItem(byteArrayOutputStream, SocketOptions.SO_OOBINLINE, 1, i2 + 160);
        writeMapItem(byteArrayOutputStream, 4096, 1, i2 + 164);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        updateSignature(byteArray);
        updateChecksum(byteArray);
        return byteArray;
    }

    public static File ensure(File file, String str, String str2) throws IOException {
        try {
        } catch (IOException e) {
            file.delete();
        }
        if (matches(XposedHelpers.inputStreamToByteArray(new FileInputStream(file)), str, str2)) {
            return file;
        }
        file.delete();
        byte[] create = create(str, str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(create);
        fileOutputStream.close();
        return file;
    }

    public static File ensure(String str, Class<?> cls) throws IOException {
        return ensure(getDefaultFile(str), str, cls.getName());
    }

    public static File ensure(String str, Class<?> cls, Class<?> cls2) throws IOException {
        if (cls2.isAssignableFrom(cls)) {
            try {
                return ensure("xposed.dummy." + str + "SuperClass", cls);
            } catch (IOException e) {
                throw new IOException("Failed to create a superclass for " + str, e);
            }
        }
        throw new ClassCastException("Cannot initialize " + str + " because " + cls + " does not extend " + cls2);
    }

    public static File getDefaultFile(String str) {
        return new File(DALVIK_CACHE, "xposed_" + str.substring(str.lastIndexOf(46) + 1) + ".dex");
    }

    public static boolean matches(byte[] bArr, String str, String str2) throws IOException {
        boolean z = str.compareTo(str2) < 0;
        byte[] stringToBytes = stringToBytes("L" + str.replace('.', '/') + i.b);
        byte[] stringToBytes2 = stringToBytes("L" + str2.replace('.', '/') + i.b);
        if (stringToBytes.length + 160 + stringToBytes2.length >= bArr.length) {
            return false;
        }
        byte[] bArr2 = z ? stringToBytes : stringToBytes2;
        int length = bArr2.length;
        int i = 0;
        int i2 = 160;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                if (!z) {
                    stringToBytes2 = stringToBytes;
                }
                int length2 = stringToBytes2.length;
                int i4 = 0;
                while (i4 < length2) {
                    if (bArr[i3] != stringToBytes2[i4]) {
                        return false;
                    }
                    i4++;
                    i3++;
                }
                return true;
            }
            if (bArr[i3] != bArr2[i]) {
                return false;
            }
            i++;
            i2 = i3 + 1;
        }
    }

    private static byte[] stringToBytes(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeUleb128(byteArrayOutputStream, str.length());
        byteArrayOutputStream.write(str.getBytes("UTF-8"));
        byteArrayOutputStream.write(0);
        return byteArrayOutputStream.toByteArray();
    }

    private static void updateChecksum(byte[] bArr) {
        Adler32 adler32 = new Adler32();
        adler32.update(bArr, 12, bArr.length - 12);
        int value = (int) adler32.getValue();
        bArr[8] = (byte) (value & 255);
        bArr[9] = (byte) ((value >> 8) & 255);
        bArr[10] = (byte) ((value >> 16) & 255);
        bArr[11] = (byte) ((value >> 24) & 255);
    }

    private static void updateSignature(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr, 32, bArr.length - 32);
            messageDigest.digest(bArr, 12, 20);
        } catch (DigestException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i);
        outputStream.write(i >> 8);
        outputStream.write(i >> 16);
        outputStream.write(i >> 24);
    }

    private static void writeMapItem(OutputStream outputStream, int i, int i2, int i3) throws IOException {
        writeInt(outputStream, i);
        writeInt(outputStream, i2);
        writeInt(outputStream, i3);
    }

    private static void writeUleb128(OutputStream outputStream, int i) throws IOException {
        while (i > 127) {
            outputStream.write((i & 127) | 128);
            i >>>= 7;
        }
        outputStream.write(i);
    }
}
