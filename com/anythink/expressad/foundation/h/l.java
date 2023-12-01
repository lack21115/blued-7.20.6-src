package com.anythink.expressad.foundation.h;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    protected static char[] f5119a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest b;

    /* renamed from: c  reason: collision with root package name */
    private static String f5120c = "SameFileMD5";

    static {
        b = null;
        try {
            b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(l.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e.printStackTrace();
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    b.update(fileInputStream3.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    byte[] digest = b.digest();
                    String a2 = a(digest, digest.length);
                    fileInputStream3.close();
                    return a2;
                } catch (Exception e) {
                    fileInputStream = fileInputStream3;
                    e = e;
                    fileInputStream2 = fileInputStream;
                    o.b(f5120c, "FILE EXCEPTION", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return "";
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        }
    }

    private static String a(String str) {
        return a(new File(str));
    }

    private static String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static String a(byte[] bArr, int i) {
        StringBuffer stringBuffer = new StringBuffer(i * 2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i + 0) {
                return stringBuffer.toString();
            }
            a(bArr[i3], stringBuffer);
            i2 = i3 + 1;
        }
    }

    private static void a(byte b2, StringBuffer stringBuffer) {
        char[] cArr = f5119a;
        char c2 = cArr[(b2 & 240) >> 4];
        char c3 = cArr[b2 & 15];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
    }
}
