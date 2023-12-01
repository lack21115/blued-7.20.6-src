package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import com.youzan.androidsdk.tool.AppSigning;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/SHA256.class */
public abstract class SHA256 {
    public static byte[] digest(File file) {
        BufferedInputStream bufferedInputStream;
        MessageDigest messageDigest;
        int i;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    bufferedInputStream2 = new byte[4096];
                    i = 0;
                    while (true) {
                        int read = bufferedInputStream.read(bufferedInputStream2);
                        if (read == -1) {
                            break;
                        }
                        i += read;
                        messageDigest.update(bufferedInputStream2, 0, read);
                    }
                } catch (IOException | NoSuchAlgorithmException e) {
                    bufferedInputStream2 = bufferedInputStream;
                    HMSLog.e(AppSigning.SHA256, "An exception occurred while computing file 'SHA-256'.");
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    return new byte[0];
                } catch (Throwable th) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th;
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    throw th;
                }
            } catch (IOException | NoSuchAlgorithmException e2) {
                bufferedInputStream = null;
            }
            if (i <= 0) {
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                return new byte[0];
            }
            byte[] digest = messageDigest.digest();
            IOUtils.closeQuietly((InputStream) bufferedInputStream);
            return digest;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            HMSLog.e(AppSigning.SHA256, "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }
}
