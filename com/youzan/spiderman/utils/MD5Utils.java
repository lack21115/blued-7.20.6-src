package com.youzan.spiderman.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/MD5Utils.class */
public class MD5Utils {
    private static final String STRING_ENCODE = "UTF-8";
    private static final String TAG = "MD5UTILS";

    private MD5Utils() {
    }

    public static String calScriptFileMd5(File file) throws IOException {
        return getStringMd5(FileUtil.getFileContent(file.getPath()));
    }

    public static String calculateMD5(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                String replace = String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
                                IOUtils.closeSilently(fileInputStream);
                                return replace;
                            }
                            messageDigest.update(bArr, 0, read);
                        } catch (IOException e) {
                            throw new RuntimeException("Unable to process file for MD5", e);
                        }
                    } catch (Throwable th) {
                        IOUtils.closeSilently(fileInputStream);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e2) {
                Logger.e(TAG, "Exception while getting FileInputStream", e2);
                return null;
            }
        } catch (NoSuchAlgorithmException e3) {
            Logger.e(TAG, "Exception while getting digest", e3);
            return null;
        }
    }

    public static boolean checkZipFileMD5(File file, String str) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            Logger.e(TAG, "MD5 string empty or updateFile null", new Object[0]);
            return false;
        }
        String calculateMD5 = calculateMD5(file);
        if (calculateMD5 == null) {
            Logger.e(TAG, "calculatedDigest null", new Object[0]);
            return false;
        }
        Logger.v(TAG, "Calculated digest: " + calculateMD5, new Object[0]);
        Logger.v(TAG, "Provided digest: " + str, new Object[0]);
        return StringUtils.equals(calculateMD5, str);
    }

    public static String getStringMd5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return stringBuffer.toString();
                }
                stringBuffer.append(Integer.toHexString((digest[i2] & 255) | 256).substring(1, 3));
                i = i2 + 1;
            }
        } catch (Exception e) {
            Logger.e("error", e);
            return "";
        }
    }
}
