package com.tencent.tmsqmsp.sdk.d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/d/a.class */
public class a {
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.FileInputStream] */
    public static String a(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        MessageDigest messageDigest;
        try {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e) {
                e = e;
                fileInputStream = null;
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                long length = new File(str).length();
                long j = length;
                if (length > 10002432) {
                    j = 10002432;
                }
                byte[] bArr = new byte[4096];
                while (j > 0) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    int i = read;
                    if (read > j) {
                        i = (int) j;
                    }
                    j -= i;
                    messageDigest.update(bArr, 0, i);
                }
                fileInputStream.close();
                String a2 = com.tencent.tmsqmsp.sdk.f.e.a(messageDigest.digest());
                try {
                    fileInputStream.close();
                    return a2;
                } catch (Exception e4) {
                    return a2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                str = fileInputStream;
                e.printStackTrace();
                FileInputStream fileInputStream3 = fileInputStream;
                fileInputStream2 = fileInputStream;
                if (fileInputStream3 == null) {
                    return null;
                }
                try {
                    fileInputStream2.close();
                    return null;
                } catch (Exception e6) {
                    return null;
                }
            } catch (IOException e7) {
                e = e7;
                str = fileInputStream;
                e.printStackTrace();
                FileInputStream fileInputStream4 = fileInputStream;
                fileInputStream2 = fileInputStream;
                if (fileInputStream4 == null) {
                    return null;
                }
                fileInputStream2.close();
                return null;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                str = fileInputStream;
                e.printStackTrace();
                FileInputStream fileInputStream5 = fileInputStream;
                fileInputStream2 = fileInputStream;
                if (fileInputStream5 == null) {
                    return null;
                }
                fileInputStream2.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                str = fileInputStream;
                th.printStackTrace();
                FileInputStream fileInputStream6 = fileInputStream;
                fileInputStream2 = fileInputStream;
                if (fileInputStream6 == null) {
                    return null;
                }
                fileInputStream2.close();
                return null;
            }
        } catch (Throwable th3) {
            if (str != null) {
                try {
                    str.close();
                } catch (Exception e9) {
                }
            }
            throw th3;
        }
    }
}
