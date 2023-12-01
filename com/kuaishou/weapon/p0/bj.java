package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bj.class */
public class bj {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10144a = "/proc/cpuinfo";

    public static String a() {
        try {
            String str = Build.CPU_ABI;
            String str2 = Build.CPU_ABI2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(com.huawei.openalliance.ad.constant.t.aE + str2);
            }
            String a2 = bg.a("ro.product.cpu.abilist");
            if (!TextUtils.isEmpty(a2)) {
                sb.append(com.huawei.openalliance.ad.constant.t.aE + a2);
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static bi b() {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        try {
            fileInputStream = new FileInputStream(new File(f10144a));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        bi biVar = new bi();
                        int i = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                biVar.a(i);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return biVar;
                            } else if (!TextUtils.isEmpty(readLine)) {
                                if (readLine.contains("Processor")) {
                                    String[] split = readLine.split(":");
                                    if (split != null) {
                                        String trim = split[1].trim();
                                        if (!TextUtils.isEmpty(trim)) {
                                            biVar.b(trim);
                                        }
                                    }
                                }
                                int i2 = i;
                                if (readLine.contains("processor")) {
                                    String[] split2 = readLine.split(":");
                                    if (split2 != null) {
                                        String trim2 = split2[1].trim();
                                        i2 = i;
                                        if (!TextUtils.isEmpty(trim2)) {
                                            i2 = Integer.parseInt(trim2) + 1;
                                        }
                                    }
                                }
                                i = i2;
                                if (readLine.contains("Hardware")) {
                                    String[] split3 = readLine.split(":");
                                    i = i2;
                                    if (split3 != null) {
                                        String str = split3[1];
                                        i = i2;
                                        if (!TextUtils.isEmpty(str)) {
                                            biVar.a(str);
                                            i = i2;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return null;
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            fileInputStream = null;
            inputStreamReader = null;
        }
    }
}
