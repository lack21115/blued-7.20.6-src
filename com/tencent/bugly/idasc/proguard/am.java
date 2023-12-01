package com.tencent.bugly.idasc.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/am.class */
public final class am {
    public static long a(String str, String str2, String str3) {
        if (str == null) {
            al.d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
            return -1L;
        } catch (Throwable th) {
            al.a(th);
            return -1L;
        }
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        int length = fileArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            File file = fileArr[i2];
            long a2 = a(file.getName(), str, str2);
            if (a2 >= 0 && 0 <= a2 && a2 <= j) {
                arrayList.add(file);
            }
            i = i2 + 1;
        }
    }

    public static void a(String str, String str2, String str3, long j) {
        try {
            int i = 0;
            for (File file : b(str, str2, str3, j)) {
                al.c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i++;
                }
            }
            al.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i)), new Object[0]);
        } catch (Throwable th) {
            al.a(th);
        }
    }

    public static boolean a(File file, String str, long j, boolean z) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z));
            boolean a2 = a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j);
            bufferedWriter.close();
            return a2;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static boolean a(Writer writer, char[] cArr, int i, long j, long j2) {
        if (j >= j2) {
            return false;
        }
        try {
            if ((i * 2) + j <= j2) {
                writer.write(cArr, 0, i);
            } else {
                writer.write(cArr, 0, (int) ((j2 - j) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e) {
            al.a(e);
            return false;
        }
    }

    public static boolean a(String str, String str2, int i) {
        boolean z = true;
        al.c("rqdp{  sv sd start} %s", str);
        if (str2 == null || str2.trim().length() <= 0) {
            return false;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            long j = i;
            if (file.length() >= j) {
                z = false;
            }
            return a(file, str2, j, z);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static List<File> b(String str, final String str2, final String str3, long j) {
        ArrayList arrayList = new ArrayList();
        if (str2 == null || str3 == null) {
            al.d("prefix %s and/or postfix %s is null.", str2, str3);
            return arrayList;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.bugly.idasc.proguard.am.1
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file2, String str4) {
                        if (str4 == null) {
                            return false;
                        }
                        boolean z = false;
                        if (str4.startsWith(String.this)) {
                            z = false;
                            if (str4.endsWith(str3)) {
                                z = true;
                            }
                        }
                        return z;
                    }
                });
                if (listFiles != null && listFiles.length != 0) {
                    return a(listFiles, str2, str3, currentTimeMillis - j);
                }
                return arrayList;
            } catch (Throwable th) {
                al.a(th);
            }
        }
        return arrayList;
    }
}
