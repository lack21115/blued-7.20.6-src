package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/hash/FileSHA256.class */
public abstract class FileSHA256 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23065a = 8192;

    /* renamed from: c  reason: collision with root package name */
    private static final String f23066c = "FileSHA256";
    private static final String d = "";
    private static final String b = "SHA-256";
    private static final String[] e = {b, "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    private static boolean a(String str) {
        String[] strArr = e;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (strArr[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.InputStream] */
    public static String fileSHAEncrypt(File file, String str) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        boolean z;
        if (TextUtils.isEmpty(str) || !a(str)) {
            b.b(f23066c, "algorithm is empty or not safe");
            return "";
        } else if (!a(file)) {
            b.b(f23066c, "file is not valid");
            return "";
        } else {
            try {
                try {
                    messageDigest = MessageDigest.getInstance(str);
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    file = null;
                    a.a((InputStream) file);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    boolean z2 = false;
                    while (true) {
                        z = z2;
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                        z2 = true;
                    }
                    String str2 = null;
                    if (z) {
                        str2 = HexUtil.byteArray2HexStr(messageDigest.digest());
                    }
                    a.a((InputStream) fileInputStream);
                    return str2;
                } catch (IOException e4) {
                    e = e4;
                    String str3 = f23066c;
                    FileInputStream fileInputStream2 = fileInputStream;
                    StringBuilder sb = new StringBuilder();
                    FileInputStream fileInputStream3 = fileInputStream;
                    sb.append("IOException");
                    FileInputStream fileInputStream4 = fileInputStream;
                    sb.append(e.getMessage());
                    FileInputStream fileInputStream5 = fileInputStream;
                    b.b(str3, sb.toString());
                    a.a((InputStream) fileInputStream);
                    return null;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    String str4 = f23066c;
                    FileInputStream fileInputStream6 = fileInputStream;
                    StringBuilder sb2 = new StringBuilder();
                    FileInputStream fileInputStream7 = fileInputStream;
                    sb2.append("NoSuchAlgorithmException");
                    FileInputStream fileInputStream8 = fileInputStream;
                    sb2.append(e.getMessage());
                    FileInputStream fileInputStream9 = fileInputStream;
                    b.b(str4, sb2.toString());
                    a.a((InputStream) fileInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                a.a((InputStream) file);
                throw th;
            }
        }
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, b);
    }

    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        return HexUtil.byteArray2HexStr(messageDigest.digest());
                    }
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    }
                }
            } catch (IOException | NoSuchAlgorithmException e2) {
                b.b(f23066c, "inputstraem exception");
                a.a(inputStream);
                return "";
            }
        } finally {
            a.a(inputStream);
        }
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (TextUtils.isEmpty(str) || !a(str2)) {
            b.b(f23066c, "hash value is null || algorithm is illegal");
            return false;
        }
        return str.equals(fileSHAEncrypt(file, str2));
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (TextUtils.isEmpty(str) || !a(str2)) {
            b.b(f23066c, "hash value is null || algorithm is illegal");
            return false;
        }
        return str.equals(inputStreamSHAEncrypt(inputStream, str2));
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }
}
