package com.efs.sdk.base.core.util;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f21792a = new Random();

    public static String a(com.efs.sdk.base.core.d.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.f21764a.f21762a);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(bVar.f21764a.d);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(bVar.f21764a.e);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append((int) bVar.f21764a.b);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(ProcessUtil.myPid());
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(f21792a.nextInt(10000));
        sb.append(BridgeUtil.UNDERLINE_STR);
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        return sb.toString();
    }

    public static String a(File file) {
        return e(file);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static void a(File file, File file2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        File file3 = file2;
        if (file2.isDirectory()) {
            file3 = new File(file2, file.getName());
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file3);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        try {
                            Log.e("efs.util.file", "error when copy", e);
                            a(fileInputStream);
                            a(fileOutputStream);
                            b(file);
                        } catch (Throwable th) {
                            th = th;
                            a(fileInputStream);
                            a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
                a(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
        }
        a(fileOutputStream);
        b(file);
    }

    public static boolean a(File file, String str) {
        return a(file, str.getBytes());
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                a(fileOutputStream2);
                return true;
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                th = th;
                try {
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static byte[] a(String str) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(str);
                byte[] bArr2 = bArr;
                try {
                    byte[] bArr3 = new byte[fileInputStream3.available()];
                    bArr2 = bArr3;
                    fileInputStream3.read(bArr3);
                    a(fileInputStream3);
                    return bArr3;
                } catch (Exception e) {
                    bArr = bArr2;
                    fileInputStream = fileInputStream3;
                    e = e;
                    fileInputStream2 = fileInputStream;
                    Log.e("efs.util.file", "read data error", e);
                    a(fileInputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream3;
                    a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        }
    }

    public static com.efs.sdk.base.core.d.b b(String str) {
        String[] split = str.split(BridgeUtil.UNDERLINE_STR);
        if (split.length != 7) {
            Log.w("efs.util.file", "File name error, name is ".concat(String.valueOf(str)));
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b(str2, Byte.valueOf(split[3]).byteValue());
        bVar.a(str3);
        bVar.a(byteValue);
        return bVar;
    }

    public static void b(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                b(listFiles[i2]);
                i = i2 + 1;
            }
        }
        file.delete();
    }

    public static long c(File file) {
        long length;
        long j = 0;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length2 = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    length = j;
                    if (i2 >= length2) {
                        break;
                    }
                    j += c(listFiles[i2]);
                    i = i2 + 1;
                }
            } else {
                return 0L;
            }
        } else {
            length = 0 + file.length();
        }
        return length;
    }

    public static List<File> d(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            File file2 = listFiles[i2];
            if (file2.isFile()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(d(file2));
            }
            i = i2 + 1;
        }
    }

    private static String e(File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String sb2 = sb.toString();
                    a(fileInputStream);
                    return sb2;
                }
                sb.append(new String(bArr, 0, read));
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                Log.e("efs.util.file", "read file error", th);
                a(fileInputStream);
                return "";
            } catch (Throwable th3) {
                a(fileInputStream);
                throw th3;
            }
        }
    }
}
