package com.tencent.smtt.utils;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/LogFileUtils.class */
public class LogFileUtils {

    /* renamed from: a  reason: collision with root package name */
    private static OutputStream f38925a;

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.e("LOG_FILE", "Couldn't close stream!", e);
            }
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] encryptKey = encryptKey(str, str2);
            String format = String.format("%03d", Integer.valueOf(encryptKey.length));
            byte[] bArr = new byte[encryptKey.length + 3];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy((Object) encryptKey, 0, (Object) bArr, 3, encryptKey.length);
            return bArr;
        } catch (Exception e) {
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static void writeDataToStorage(File file, String str, byte[] bArr, String str2, boolean z) {
        synchronized (LogFileUtils.class) {
            try {
                byte[] encrypt = encrypt(str, str2);
                if (encrypt != null) {
                    str2 = null;
                } else {
                    encrypt = null;
                }
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > 2097152) {
                    file.delete();
                    file.createNewFile();
                }
                if (f38925a == null) {
                    f38925a = new BufferedOutputStream(new FileOutputStream(file, z));
                }
                if (str2 != null) {
                    f38925a.write(str2.getBytes());
                } else {
                    f38925a.write(bArr);
                    f38925a.write(encrypt);
                    f38925a.write(new byte[]{10, 10});
                }
                if (f38925a != null) {
                    try {
                        f38925a.flush();
                    } catch (Throwable th) {
                    }
                }
            } finally {
            }
        }
    }
}
