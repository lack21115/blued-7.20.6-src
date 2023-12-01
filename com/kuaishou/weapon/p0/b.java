package com.kuaishou.weapon.p0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10131a = "AES/CBC/NoPadding";
    public static final int b = 16;

    /* renamed from: c  reason: collision with root package name */
    public static final String f10132c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    private static final String d = "AES/CBC/PKCS5Padding";
    private static final String e = "AES";
    private static final String f = "AES/CBC/PKCS7Padding";

    public static byte[] a(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr3 = new byte[16];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 16) {
                    break;
                }
                bArr3[i2] = 0;
                i = i2 + 1;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] bArr4 = bArr2;
            if (z) {
                bArr4 = new byte[bArr2.length - 16];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
            }
            return cipher.doFinal(bArr4);
        } catch (Throwable th) {
            System.out.println(th.getMessage());
            return null;
        }
    }

    public static byte[] b(String str, String str2, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static int c(String str, String str2, byte[] bArr) {
        String str3;
        CipherInputStream cipherInputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        try {
            String str4 = new String(bArr);
            if (str4.length() < 16) {
                int length = str4.length();
                StringBuilder sb = new StringBuilder(str4);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 16 - length) {
                        break;
                    }
                    sb.append("0");
                    i = i2 + 1;
                }
                str3 = sb.toString();
            } else {
                str3 = str4;
                if (str4.length() > 16) {
                    str3 = str4.substring(0, 16);
                }
            }
            try {
                fileInputStream2 = new FileInputStream(str);
                try {
                    fileOutputStream2 = new FileOutputStream(str2);
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        byte[] bArr2 = new byte[16];
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= 16) {
                                break;
                            }
                            bArr2[i4] = 0;
                            i3 = i4 + 1;
                        }
                        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2));
                        cipherInputStream = new CipherInputStream(fileInputStream2, cipher);
                    } catch (Throwable th) {
                        cipherInputStream = null;
                    }
                } catch (Throwable th2) {
                    cipherInputStream = null;
                    fileInputStream = fileInputStream2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                cipherInputStream = null;
                fileInputStream = null;
                fileOutputStream = null;
            }
            try {
                try {
                    byte[] bArr3 = new byte[1024];
                    while (true) {
                        int read = cipherInputStream.read(bArr3);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr3, 0, read);
                    }
                    cipherInputStream.close();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                    }
                } catch (Throwable th4) {
                    fileOutputStream = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (cipherInputStream == null) {
                        return 0;
                    }
                    cipherInputStream.close();
                    return 0;
                }
                cipherInputStream.close();
                return 0;
            } catch (IOException e6) {
                return 0;
            }
        } catch (Throwable th5) {
            return -1;
        }
    }
}
