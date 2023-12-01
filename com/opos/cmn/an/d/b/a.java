package com.opos.cmn.an.d.b;

import android.os.Environment;
import android.os.StatFs;
import com.igexin.push.core.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/d/b/a.class */
public final class a {
    public static void a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public static boolean a() {
        boolean z;
        try {
            z = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "isSdCardAvailable", e);
            z = false;
        }
        com.opos.cmn.an.f.a.b("FileTool", "isSdCardAvailable=" + z);
        return z;
    }

    public static boolean a(File file) {
        boolean exists = file != null ? file.exists() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("isFileExists ");
        sb.append(file != null ? file.getAbsolutePath() : b.l);
        sb.append(" =");
        sb.append(exists);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return exists;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.File r4, java.io.File r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L1a
            r0 = r5
            if (r0 == 0) goto L1a
            r0 = r4
            r1 = r5
            boolean r0 = r0.renameTo(r1)     // Catch: java.lang.Exception -> L11
            r6 = r0
            goto L1c
        L11:
            r7 = move-exception
            java.lang.String r0 = "FileTool"
            java.lang.String r1 = "rename"
            r2 = r7
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L1a:
            r0 = 0
            r6 = r0
        L1c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "renameTo "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "null"
            r7 = r0
            r0 = r4
            if (r0 == 0) goto L3c
            r0 = r4
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
            goto L3f
        L3c:
            java.lang.String r0 = "null"
            r4 = r0
        L3f:
            r0 = r8
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r4 = r0
            r0 = r5
            if (r0 == 0) goto L51
            r0 = r5
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
        L51:
            r0 = r8
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = " result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "FileTool"
            r1 = r8
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.a(java.io.File, java.io.File):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.InputStream r5, java.io.File r6) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.a(java.io.InputStream, java.io.File):boolean");
    }

    public static boolean a(String str) {
        boolean exists = !com.opos.cmn.an.c.a.a(str) ? new File(str).exists() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("isFileExists ");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(" =");
        sb.append(exists);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return exists;
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "inputStream2Bytes", e);
            return null;
        }
    }

    public static String b() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        com.opos.cmn.an.f.a.b("FileTool", "getSdCardRootPath=" + absolutePath);
        return absolutePath;
    }

    public static boolean b(File file) {
        boolean z = file != null && file.exists() && file.isDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append("isFolderExist ");
        sb.append(file != null ? file.getAbsolutePath() : b.l);
        sb.append(" =");
        sb.append(z);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.String r4) {
        /*
            r0 = r4
            boolean r0 = com.opos.cmn.an.c.a.a(r0)
            if (r0 != 0) goto L23
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r4
            r1.<init>(r2)
            r6 = r0
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 == 0) goto L23
            r0 = r6
            boolean r0 = r0.isDirectory()
            if (r0 == 0) goto L23
            r0 = 1
            r5 = r0
            goto L25
        L23:
            r0 = 0
            r5 = r0
        L25:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "isFileExists "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L3b
            goto L3e
        L3b:
            java.lang.String r0 = "null"
            r4 = r0
        L3e:
            r0 = r6
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = " ="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "FileTool"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.b(java.lang.String):boolean");
    }

    public static long c() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "", e);
            j = 0;
        }
        com.opos.cmn.an.f.a.b("FileTool", "getSDCardAvailableSize=" + j);
        return j;
    }

    public static String c(String str) {
        String str2 = "";
        if (!com.opos.cmn.an.c.a.a(str)) {
            int lastIndexOf = str.lastIndexOf(File.separator);
            str2 = lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getFolderPath ");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(" folder path=");
        sb.append(str2);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return str2;
    }

    public static boolean c(File file) {
        File parentFile;
        boolean mkdirs = (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) ? false : parentFile.mkdirs();
        StringBuilder sb = new StringBuilder();
        sb.append("makeDirs ");
        sb.append(file != null ? file.getAbsolutePath() : b.l);
        sb.append(" =");
        sb.append(mkdirs);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return mkdirs;
    }

    public static String d(File file) {
        return file != null ? c(file.getAbsolutePath()) : "";
    }

    public static boolean d(String str) {
        boolean delete = a(str) ? new File(str).delete() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("deleteFile ");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(" result=");
        sb.append(delete);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return delete;
    }

    public static long e(String str) {
        long h = !com.opos.cmn.an.c.a.a(str) ? h(new File(str)) : 0L;
        StringBuilder sb = new StringBuilder();
        sb.append("getFolderOrFileSize filePath=");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(",size=");
        sb.append(h);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return h;
    }

    public static boolean e(File file) {
        boolean delete = a(file) ? file.delete() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("deleteFile ");
        sb.append(file != null ? file.getAbsolutePath() : b.l);
        sb.append(" result=");
        sb.append(delete);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return delete;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(java.io.File r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L15
            r0 = r4
            boolean r0 = r0.createNewFile()     // Catch: java.io.IOException -> Lc
            r5 = r0
            goto L17
        Lc:
            r6 = move-exception
            java.lang.String r0 = "FileTool"
            java.lang.String r1 = "createNewFile"
            r2 = r6
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L15:
            r0 = 0
            r5 = r0
        L17:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "createNewFile "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L32
            r0 = r4
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
            goto L35
        L32:
            java.lang.String r0 = "null"
            r4 = r0
        L35:
            r0 = r6
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = " result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "FileTool"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.f(java.io.File):boolean");
    }

    public static boolean f(String str) {
        boolean mkdirs = !com.opos.cmn.an.c.a.a(str) ? new File(str).mkdirs() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("makeFolder ");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(" =");
        sb.append(mkdirs);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return mkdirs;
    }

    public static long g(File file) {
        long length = a(file) ? file.length() : 0L;
        StringBuilder sb = new StringBuilder();
        sb.append("getFileLength ");
        sb.append(file != null ? file.getAbsolutePath() : b.l);
        sb.append(" length=");
        sb.append(length);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return length;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long h(java.io.File r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L24
            r0 = r4
            boolean r0 = r0.isDirectory()     // Catch: java.lang.Exception -> L1b
            if (r0 == 0) goto L13
            r0 = r4
            long r0 = j(r0)     // Catch: java.lang.Exception -> L1b
            r5 = r0
            goto L26
        L13:
            r0 = r4
            long r0 = i(r0)     // Catch: java.lang.Exception -> L1b
            r5 = r0
            goto L26
        L1b:
            r7 = move-exception
            java.lang.String r0 = "FileTool"
            java.lang.String r1 = ""
            r2 = r7
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L24:
            r0 = 0
            r5 = r0
        L26:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "getFolderOrFileSize filePath="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L41
            r0 = r4
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
            goto L44
        L41:
            java.lang.String r0 = "null"
            r4 = r0
        L44:
            r0 = r7
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",size="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "FileTool"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.h(java.io.File):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long i(java.io.File r4) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.d.b.a.i(java.io.File):long");
    }

    private static long j(File file) {
        long i;
        long j = 0;
        long j2 = 0;
        if (file != null) {
            long j3 = 0;
            j2 = 0;
            try {
                if (b(file)) {
                    File[] listFiles = file.listFiles();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        j3 = j;
                        j2 = j;
                        if (i3 >= listFiles.length) {
                            break;
                        }
                        long j4 = j;
                        if (listFiles[i3].isDirectory()) {
                            long j5 = j;
                            i = j(listFiles[i3]);
                        } else {
                            i = i(listFiles[i3]);
                        }
                        j += i;
                        i2 = i3 + 1;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("FileTool", "", e);
                j2 = j3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getFolderSize file=");
        sb.append(file != null ? file.getAbsolutePath() : b.l);
        sb.append(",size=");
        sb.append(j2);
        com.opos.cmn.an.f.a.b("FileTool", sb.toString());
        return j2;
    }
}
