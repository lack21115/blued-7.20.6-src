package com.opos.mobad.e.a.a;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/d.class */
public final class d {
    /* JADX WARN: Removed duplicated region for block: B:57:0x0142 A[Catch: Exception -> 0x017f, TRY_ENTER, TryCatch #0 {Exception -> 0x017f, blocks: (B:54:0x0136, B:57:0x0142, B:60:0x014b), top: B:71:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b A[Catch: Exception -> 0x017f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x017f, blocks: (B:54:0x0136, B:57:0x0142, B:60:0x014b), top: B:71:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.e.a.a.d.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009d, code lost:
        throw new java.lang.Exception("Entry is outside of the target dir: " + r0.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.util.zip.ZipInputStream r4, java.io.File r5) {
        /*
        L0:
            r0 = r4
            java.util.zip.ZipEntry r0 = r0.getNextEntry()     // Catch: java.lang.Exception -> La0
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L9e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La0
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> La0
            r7 = r0
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> La0
            r0 = r7
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Exception -> La0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> La0
            r0 = r7
            r1 = r6
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> La0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> La0
            r0 = r7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> La0
            r7 = r0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> La0
            r1 = r0
            r2 = r7
            r1.<init>(r2)     // Catch: java.lang.Exception -> La0
            r8 = r0
            r0 = r5
            java.lang.String r0 = r0.getCanonicalPath()     // Catch: java.lang.Exception -> La0
            r9 = r0
            r0 = r8
            java.lang.String r0 = r0.getCanonicalPath()     // Catch: java.lang.Exception -> La0
            r1 = r9
            boolean r0 = r0.startsWith(r1)     // Catch: java.lang.Exception -> La0
            if (r0 == 0) goto L7f
            r0 = r6
            boolean r0 = r0.isDirectory()     // Catch: java.lang.Exception -> La0
            if (r0 == 0) goto L72
            r0 = r8
            boolean r0 = r0.exists()     // Catch: java.lang.Exception -> La0
            if (r0 != 0) goto L78
            r0 = r8
            boolean r0 = r0.mkdirs()     // Catch: java.lang.Exception -> La0
            if (r0 != 0) goto L78
            java.lang.String r0 = "ZipTool"
            java.lang.String r1 = "file.mkdirs() failed filepath="
            r2 = r7
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> La0
            java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Exception -> La0
            com.opos.cmn.an.f.a.b(r0, r1)     // Catch: java.lang.Exception -> La0
            goto L78
        L72:
            r0 = r4
            r1 = r8
            b(r0, r1)     // Catch: java.lang.Exception -> La0
        L78:
            r0 = r4
            r0.closeEntry()     // Catch: java.lang.Exception -> La0
            goto L0
        L7f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La0
            r1 = r0
            java.lang.String r2 = "Entry is outside of the target dir: "
            r1.<init>(r2)     // Catch: java.lang.Exception -> La0
            r4 = r0
            r0 = r4
            r1 = r6
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> La0
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> La0
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Exception -> La0
            r1 = r0
            r2 = r4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> La0
            r1.<init>(r2)     // Catch: java.lang.Exception -> La0
            throw r0     // Catch: java.lang.Exception -> La0
        L9e:
            r0 = 1
            return r0
        La0:
            r4 = move-exception
            java.lang.String r0 = "ZipTool"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.d(r0, r1, r2)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.e.a.a.d.a(java.util.zip.ZipInputStream, java.io.File):boolean");
    }

    private static void b(ZipInputStream zipInputStream, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (zipInputStream == null) {
            return;
        }
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    com.opos.cmn.an.f.a.b("ZipTool", "parentFile.mkdirs() failed filepath=" + file.getAbsolutePath());
                }
                if (!file.createNewFile()) {
                    com.opos.cmn.an.f.a.b("ZipTool", "destFile.createNewFile() failed filepath=" + file.getAbsolutePath());
                }
            }
            try {
                fileOutputStream2 = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
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
            } catch (Throwable th2) {
                fileOutputStream = fileOutputStream2;
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ZipTool", "", e);
        }
    }
}
