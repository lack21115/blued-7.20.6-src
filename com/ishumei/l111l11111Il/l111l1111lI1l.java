package com.ishumei.l111l11111Il;

import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l1111lI1l.class */
public final class l111l1111lI1l {
    private static String l1111l111111Il = "sm";
    private static final String[] l111l1111lI1l = null;
    private static final String[] l111l1111llIl = null;
    private static final String[] l111l11111lIl = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    private static final String[] l111l11111I1l = {"goldfish"};
    private static final String[] l111l11111Il = {"/sys/qemu_trace", "/system/bin/qemu-props"};
    private static final String[] l111l1111l1Il = {"000000000000000"};

    public static String l1111l111111Il(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(l1111l111111Il(l1111l111111Il()));
        sb.append(l1111l111111Il(l111l11111lIl()));
        sb.append(l1111l111111Il(l111l11111I1l()));
        boolean z = false;
        sb.append(l1111l111111Il(false));
        sb.append(l1111l111111Il(l1111l111111Il(str)));
        String str3 = Build.BOARD;
        String str4 = Build.BOOTLOADER;
        String str5 = Build.BRAND;
        String str6 = Build.DEVICE;
        String str7 = Build.HARDWARE;
        String str8 = Build.MODEL;
        String str9 = Build.PRODUCT;
        if ("unknown".equals(str3) || "unknown".equals(str4) || "generic".equals(str5) || "generic".equals(str6) || "sdk".equals(str8) || "sdk".equals(str9) || "goldfish".equals(str7)) {
            z = true;
        }
        sb.append(l1111l111111Il(z));
        sb.append(l1111l111111Il(l111l11111lIl(str2)));
        return sb.toString();
    }

    private static String l1111l111111Il(boolean z) {
        return z ? "1" : "0";
    }

    private static boolean l1111l111111Il() {
        try {
            String[] strArr = l111l11111lIl;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 2) {
                    return false;
                }
                if (new File(strArr[i2]).exists()) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean l1111l111111Il(String str) {
        try {
            String[] strArr = l111l1111l1Il;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > 0) {
                    return false;
                }
                if (strArr[0].equalsIgnoreCase(str)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean l111l11111I1l() {
        try {
            String[] strArr = l111l11111Il;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 2) {
                    return false;
                }
                if (new File(strArr[i2]).exists()) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean l111l11111Il() {
        return false;
    }

    private static boolean l111l11111lIl() {
        FileInputStream fileInputStream;
        try {
            File file = new File("/proc/tty/drivers");
            if (!file.exists() || !file.canRead()) {
                return false;
            }
            byte[] bArr = new byte[(int) file.length()];
            InputStream inputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    String str = new String(bArr);
                    String[] strArr = l111l11111I1l;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 > 0) {
                            com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                            return false;
                        } else if (str.contains(strArr[0])) {
                            com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                            return true;
                        } else {
                            i = i2 + 1;
                        }
                    }
                } catch (Exception e) {
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) fileInputStream);
                    return false;
                } catch (Throwable th) {
                    inputStream = fileInputStream;
                    th = th;
                    com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il((Closeable) inputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            return false;
        }
    }

    private static boolean l111l11111lIl(String str) {
        try {
            return str.toLowerCase().equals("android");
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean l111l1111l1Il() {
        return "unknown".equals(Build.BOARD) || "unknown".equals(Build.BOOTLOADER) || "generic".equals(Build.BRAND) || "generic".equals(Build.DEVICE) || "sdk".equals(Build.MODEL) || "sdk".equals(Build.PRODUCT) || "goldfish".equals(Build.HARDWARE);
    }
}
