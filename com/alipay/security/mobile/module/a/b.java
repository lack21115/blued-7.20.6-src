package com.alipay.security.mobile.module.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/a/b.class */
public final class b {
    public static String a(String str, String str2) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        File file;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                file = new File(str, str2);
            } catch (IOException e) {
                bufferedReader2 = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
        }
        if (file.exists()) {
            bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (IOException e2) {
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return sb.toString();
                } catch (Throwable th3) {
                    bufferedReader = bufferedReader2;
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th4) {
                        }
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
            return sb.toString();
        }
        return null;
    }
}
