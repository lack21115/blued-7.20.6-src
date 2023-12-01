package com.opos.mobad.service.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipInputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c/e.class */
public class e {
    public static void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(str + "_dirty");
                if (file2.exists()) {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "rn but exists");
                    c(file2);
                }
                if (file.renameTo(file2)) {
                    b(file2);
                } else {
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "rn fail");
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "clear temp fail", th);
        }
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "prepare failed!zipPath or destPath is empty!";
        } else if (new File(str).exists()) {
            File a2 = f.a(context, str);
            if (a2 == null) {
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "prepare but null dirFile!");
                return false;
            }
            String absolutePath = a2.getAbsolutePath();
            if (!a2.exists()) {
                a2.mkdirs();
            } else if (a2.listFiles().length > 0) {
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "file has exist");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean a3 = a(str, absolutePath);
            if (!a3) {
                a(absolutePath);
            }
            com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "prepare result:", Boolean.valueOf(a3), "zipPath =", str, ",destPath:", absolutePath, ",costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return a3;
        } else {
            str2 = "prepare failed!zipPath not exist";
        }
        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", str2);
        return false;
    }

    private static boolean a(String str, String str2) {
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "zip file not exist!" + file.getAbsolutePath());
            return false;
        }
        ZipInputStream zipInputStream = null;
        ZipInputStream zipInputStream2 = null;
        ZipInputStream zipInputStream3 = null;
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
                    ZipInputStream zipInputStream4 = Build.VERSION.SDK_INT >= 24 ? new ZipInputStream(checkedInputStream, Charset.forName("gbk")) : new ZipInputStream(checkedInputStream);
                    ZipInputStream zipInputStream5 = zipInputStream4;
                    boolean a2 = a(zipInputStream4, new File(str2));
                    zipInputStream = zipInputStream4;
                    checkedInputStream.close();
                    ZipInputStream zipInputStream6 = zipInputStream4;
                    fileInputStream.close();
                    try {
                        zipInputStream4.close();
                        return a2;
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e);
                        return a2;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        ZipInputStream zipInputStream7 = zipInputStream;
                        throw th2;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e2);
                if (0 != 0) {
                    try {
                        zipInputStream2.close();
                        return false;
                    } catch (Exception e3) {
                        com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e3);
                        return false;
                    }
                }
                return false;
            }
        } catch (Throwable th4) {
            if (0 != 0) {
                try {
                    zipInputStream3.close();
                } catch (Exception e4) {
                    com.opos.cmn.an.f.a.d("Dynamic-ZipTool", "unzipFile", e4);
                }
            }
            throw th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ba, code lost:
        throw new java.lang.Exception("Entry is outside of the target dir: " + r0.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.util.zip.ZipInputStream r4, java.io.File r5) {
        /*
            r0 = r4
            if (r0 == 0) goto Lc6
            r0 = r5
            if (r0 == 0) goto Lc6
        L8:
            r0 = r4
            java.util.zip.ZipEntry r0 = r0.getNextEntry()     // Catch: java.lang.Exception -> Lbd
            r6 = r0
            r0 = r6
            if (r0 == 0) goto Lbb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbd
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> Lbd
            r7 = r0
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lbd
            r0 = r7
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lbd
            r0 = r7
            r1 = r6
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lbd
            r0 = r7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lbd
            r7 = r0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> Lbd
            r1 = r0
            r2 = r7
            r1.<init>(r2)     // Catch: java.lang.Exception -> Lbd
            r8 = r0
            r0 = r5
            java.lang.String r0 = r0.getCanonicalPath()     // Catch: java.lang.Exception -> Lbd
            r9 = r0
            r0 = r8
            java.lang.String r0 = r0.getCanonicalPath()     // Catch: java.lang.Exception -> Lbd
            r1 = r9
            boolean r0 = r0.startsWith(r1)     // Catch: java.lang.Exception -> Lbd
            if (r0 == 0) goto L97
            r0 = r6
            boolean r0 = r0.isDirectory()     // Catch: java.lang.Exception -> Lbd
            if (r0 == 0) goto L8a
            r0 = r8
            boolean r0 = r0.exists()     // Catch: java.lang.Exception -> Lbd
            if (r0 != 0) goto L90
            r0 = r8
            boolean r0 = r0.mkdirs()     // Catch: java.lang.Exception -> Lbd
            if (r0 != 0) goto L90
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbd
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> Lbd
            r6 = r0
            r0 = r6
            java.lang.String r1 = "file.mkdirs() failed filepath="
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lbd
            r0 = r6
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lbd
            java.lang.String r0 = "Dynamic-ZipTool"
            r1 = r6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lbd
            com.opos.cmn.an.f.a.b(r0, r1)     // Catch: java.lang.Exception -> Lbd
            goto L90
        L8a:
            r0 = r4
            r1 = r8
            b(r0, r1)     // Catch: java.lang.Exception -> Lbd
        L90:
            r0 = r4
            r0.closeEntry()     // Catch: java.lang.Exception -> Lbd
            goto L8
        L97:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbd
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> Lbd
            r4 = r0
            r0 = r4
            java.lang.String r1 = "Entry is outside of the target dir: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lbd
            r0 = r4
            r1 = r6
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> Lbd
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lbd
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Exception -> Lbd
            r1 = r0
            r2 = r4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lbd
            r1.<init>(r2)     // Catch: java.lang.Exception -> Lbd
            throw r0     // Catch: java.lang.Exception -> Lbd
        Lbb:
            r0 = 1
            return r0
        Lbd:
            r4 = move-exception
            java.lang.String r0 = "Dynamic-ZipTool"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.d(r0, r1, r2)
        Lc6:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.c.e.a(java.util.zip.ZipInputStream, java.io.File):boolean");
    }

    private static void b(final File file) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.c.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.c(file);
                    com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "clear succ");
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "clear temp fail", e);
                }
            }
        });
    }

    private static void b(ZipInputStream zipInputStream, File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (zipInputStream == null || file == null) {
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "parentFile.mkdirs() failed filepath=" + file.getAbsolutePath());
            }
            if (!file.createNewFile()) {
                com.opos.cmn.an.f.a.b("Dynamic-ZipTool", "destFile.createNewFile() failed filepath=" + file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (-1 == read) {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                th = th;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    c(listFiles[i2]);
                    i = i2 + 1;
                }
            }
        }
        file.delete();
    }
}
