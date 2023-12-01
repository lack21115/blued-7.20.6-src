package com.ishumei.l111l11111Il;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l1111l1Il.class */
public final class l111l1111l1Il {
    private static final int l1111l111111Il = -1;
    private static final FileFilter l111l11111lIl = new FileFilter() { // from class: com.ishumei.l111l11111Il.l111l1111l1Il.1
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            try {
                if (!name.startsWith(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c8f8a"))) {
                    return false;
                }
                int i = 3;
                while (true) {
                    int i2 = i;
                    if (i2 >= name.length()) {
                        return true;
                    }
                    if (!Character.isDigit(name.charAt(i2))) {
                        return false;
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                return false;
            }
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l1111l1Il$l1111l111111Il.class */
    public static final class l1111l111111Il {
        public String l1111l111111Il = "";
    }

    private static int l1111l111111Il(String str) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        int i;
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    String readLine = bufferedReader.readLine();
                    i = -1;
                    if (readLine != null) {
                        i = !readLine.matches("0-[\\d]+$") ? -1 : Integer.parseInt(readLine.substring(2)) + 1;
                    }
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) bufferedReader);
                } catch (IOException e) {
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) bufferedReader);
                    i = -1;
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                    return i;
                } catch (Throwable th) {
                    bufferedReader2 = bufferedReader;
                    th = th;
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) bufferedReader2);
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r11 >= 1024) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r0[r11] == 10) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (java.lang.Character.isDigit(r0[r11]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        r0 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
        if (r0 >= 1024) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
        if (java.lang.Character.isDigit(r0[r0]) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
        return java.lang.Integer.parseInt(new java.lang.String(r0, 0, r11, r0 - r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0097, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int l1111l111111Il(java.lang.String r8, java.io.FileInputStream r9) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l111l1111l1Il.l1111l111111Il(java.lang.String, java.io.FileInputStream):int");
    }

    private static int l1111l111111Il(byte[] bArr, int i) {
        int i2;
        while (i < 1024 && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i3 = i;
                while (true) {
                    i2 = i3 + 1;
                    if (i2 >= 1024 || !Character.isDigit(bArr[i2])) {
                        break;
                    }
                    i3 = i2;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public static l1111l111111Il l1111l111111Il() {
        l1111l111111Il l1111l111111il = new l1111l111111Il();
        try {
            for (String str : com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111I1l(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08f8d909cd09c8f8a96919990"))) {
                String[] split = str.split(":");
                if (2 == split.length) {
                    String trim = split[0].trim();
                    String trim2 = split[1].trim();
                    if (TextUtils.equals(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("af8d909c9a8c8c908d"), trim) || TextUtils.equals(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("92909b9a93df919e929a"), trim)) {
                        l1111l111111il.l1111l111111Il = trim2;
                    }
                }
            }
            return l1111l111111il;
        } catch (Exception e) {
            return l1111l111111il;
        }
    }

    public static int l111l11111I1l() {
        int i;
        FileInputStream fileInputStream;
        int i2;
        try {
            int l111l11111lIl2 = l111l11111lIl();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i = i4;
                if (i3 >= l111l11111lIl2) {
                    break;
                }
                File file = new File(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad09c8f8a") + i3 + com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d09c8f8a998d9a8ed09c8f8a96919990a0929e87a0998d9a8e"));
                int i5 = i;
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileInputStream2.read(bArr);
                        int i6 = 0;
                        while (true) {
                            i2 = i6;
                            if (i2 >= 128 || !Character.isDigit(bArr[i2])) {
                                break;
                            }
                            i6 = i2 + 1;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i2)));
                        i5 = i;
                        if (valueOf.intValue() > i) {
                            i5 = valueOf.intValue();
                        }
                    } catch (NumberFormatException e) {
                        i5 = i;
                    }
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream2);
                }
                i3++;
                i4 = i5;
            }
            int i7 = i;
            if (i == -1) {
                try {
                    fileInputStream = new FileInputStream(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08f8d909cd09c8f8a96919990"));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                }
                try {
                    int l1111l111111Il2 = l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c8f8adfb2b785"), fileInputStream) * 1000;
                    i7 = i;
                    if (l1111l111111Il2 > i) {
                        i7 = l1111l111111Il2;
                    }
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                    throw th;
                }
            }
            return i7;
        } catch (Exception e2) {
            return -1;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0073: MOVE  (r0 I:??[long, double]) = (r5 I:??[long, double]), block:B:25:0x0073 */
    public static long l111l11111Il() {
        long j;
        FileInputStream fileInputStream;
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                try {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    return memoryInfo.totalMem;
                } catch (Exception e) {
                    return 0L;
                }
            }
            try {
                try {
                    fileInputStream = new FileInputStream(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08f8d909cd0929a9296919990"));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                }
                try {
                    long l1111l111111Il2 = l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("b29a92ab908b9e93"), fileInputStream) << 10;
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                    return l1111l111111Il2;
                } catch (Throwable th2) {
                    th = th2;
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                return j;
            }
        }
        return 0L;
    }

    public static int l111l11111lIl() {
        try {
            int l1111l111111Il2 = l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f908c8c969d939a"));
            int i = l1111l111111Il2;
            if (l1111l111111Il2 == -1) {
                i = l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f8d9a8c9a918b"));
            }
            return i == -1 ? l111l1111l1Il() : i;
        } catch (SecurityException | Exception e) {
            return -1;
        }
    }

    private static int l111l11111lIl(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.parseInt(str.substring(2)) + 1;
    }

    private static int l111l1111l1Il() {
        try {
            return new File(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f908c8c969d939a")).listFiles(l111l11111lIl).length;
        } catch (Exception e) {
            return 0;
        }
    }
}
