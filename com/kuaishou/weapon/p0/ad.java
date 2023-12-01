package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import com.bun.miitmdid.core.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ad.class */
public class ad {
    private String a(String str) {
        try {
            File file = new File(str);
            String str2 = null;
            if (file.exists()) {
                str2 = null;
                if (file.canRead()) {
                    byte[] bArr = new byte[1024];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    str2 = null;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        String str3 = new String(bArr, 0, read);
                        str2 = str3;
                        if (read > 0) {
                            str2 = str3;
                            break;
                        }
                    }
                    fileInputStream.close();
                }
            }
            return str2;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean b() {
        if ("nokia".equalsIgnoreCase(Build.MANUFACTURER) && ("Nokia_N1".equalsIgnoreCase(Build.DEVICE) || "N1".equalsIgnoreCase(Build.MODEL))) {
            return false;
        }
        try {
            Process start = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            bufferedReader.close();
            String lowerCase = stringBuffer.toString().toLowerCase();
            if (lowerCase.contains("intel") || lowerCase.contains(Utils.CPU_ABI_X86)) {
                return true;
            }
            return lowerCase.contains("amd");
        } catch (IOException e) {
            return false;
        }
    }

    public boolean a() {
        try {
            String a2 = a("/proc/tty/drivers");
            boolean z = !TextUtils.isEmpty(a2) && a2.contains("goldfish");
            if (!z) {
                String a3 = a("/proc/cpuinfo");
                if (!TextUtils.isEmpty(a3)) {
                    if (a3.contains("goldfish")) {
                        return true;
                    }
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
