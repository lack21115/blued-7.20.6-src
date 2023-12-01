package com.oplus.quickgame.sdk.engine.ui;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/ui/MD5Util.class */
public class MD5Util {
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String convertHashToString(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return str.toLowerCase();
            }
            str = str + Integer.toString((bArr[i2] & 255) + 256, 16).substring(1);
            i = i2 + 1;
        }
    }

    public static String generateMD5(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                int i = 0;
                while (i != -1) {
                    int read = fileInputStream.read(bArr);
                    i = read;
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                        i = read;
                    }
                }
                String convertHashToString = convertHashToString(messageDigest.digest());
                try {
                    fileInputStream.close();
                    return convertHashToString;
                } catch (Exception e) {
                    return convertHashToString;
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (Exception e3) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String hex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return new String(cArr);
            }
            byte b = bArr[i];
            int i4 = i3 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i3] = cArr2[(b >> 4) & 15];
            cArr[i4] = cArr2[b & 15];
            i++;
            i2 = i4 + 1;
        }
    }

    public static String md5Hex(String str) {
        try {
            return md5Hex(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String md5Hex(byte[] bArr) {
        try {
            return hex(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
