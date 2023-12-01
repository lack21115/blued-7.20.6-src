package com.alipay.security.mobile.module.d;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f4712a = "";
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f4713c = "";

    public static void a(String str) {
        synchronized (d.class) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                a(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (d.class) {
            try {
                f4712a = str;
                b = str2;
                f4713c = str3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Throwable th) {
        String str;
        synchronized (d.class) {
            try {
                ArrayList arrayList = new ArrayList();
                if (th != null) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str = stringWriter.toString();
                } else {
                    str = "";
                }
                arrayList.add(str);
                a(arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void a(List<String> list) {
        synchronized (d.class) {
            try {
                if (!com.alipay.security.mobile.module.a.a.a(b) && !com.alipay.security.mobile.module.a.a.a(f4713c)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(f4713c);
                    for (String str : list) {
                        stringBuffer.append(", " + str);
                    }
                    stringBuffer.append("\n");
                    try {
                        File file = new File(f4712a);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(f4712a, b);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                        fileWriter.write(stringBuffer.toString());
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
