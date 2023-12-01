package com.opos.mobad.service.c;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c/c.class */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.io.File r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L23
            r0 = r4
            boolean r0 = r0.isDirectory()     // Catch: java.lang.Exception -> L1a
            if (r0 == 0) goto L23
            r0 = r4
            java.io.File[] r0 = r0.listFiles()     // Catch: java.lang.Exception -> L1a
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L23
            r0 = r6
            int r0 = r0.length     // Catch: java.lang.Exception -> L1a
            r5 = r0
            goto L25
        L1a:
            r6 = move-exception
            java.lang.String r0 = "MobFileTool"
            java.lang.String r1 = ""
            r2 = r6
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L23:
            r0 = 0
            r5 = r0
        L25:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getFolderFilesCount folderFile="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L40
            r0 = r4
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
            goto L43
        L40:
            java.lang.String r0 = "null"
            r4 = r0
        L43:
            r0 = r6
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = ",count="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "MobFileTool"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.c.c.a(java.io.File):int");
    }

    private static int a(String str) {
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return 0;
            }
            return a(new File(str));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("MobFileTool", "", (Throwable) e);
            return 0;
        }
    }

    public static void a(File file, long j, int i) {
        a(file, j, i, true);
    }

    private static void a(File file, long j, int i, boolean z) {
        String str;
        File[] listFiles;
        if (file.exists() && file.isDirectory()) {
            long e = com.opos.cmn.an.d.b.a.e(file.getAbsolutePath());
            int a2 = a(file.getAbsolutePath());
            if (e >= j || a2 >= i) {
                com.opos.cmn.an.f.a.b("MobFileTool", "video cache size over max size or over max count,start clear video cache.");
                if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.opos.mobad.service.c.c.1
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        int i2 = ((file2.lastModified() - file3.lastModified()) > 0L ? 1 : ((file2.lastModified() - file3.lastModified()) == 0L ? 0 : -1));
                        if (i2 > 0) {
                            return 1;
                        }
                        return i2 == 0 ? 0 : -1;
                    }

                    @Override // java.util.Comparator
                    public boolean equals(Object obj) {
                        return true;
                    }
                });
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= listFiles.length / 2) {
                        return;
                    }
                    a(listFiles[i3], z);
                    i2 = i3 + 1;
                }
            } else {
                str = "video cache size not over max size or over max count,don't need clear video cache.";
            }
        } else {
            str = "folder not exist";
        }
        com.opos.cmn.an.f.a.b("MobFileTool", str);
    }

    private static final void a(File file, boolean z) {
        String str;
        if (file != null && file.exists()) {
            if (z && file.isDirectory()) {
                com.opos.cmn.an.f.a.b("MobFileTool", "skip for directFile", file.getAbsolutePath());
                return;
            }
            File file2 = new File(file.getAbsolutePath() + "_dirty");
            if (file2.exists()) {
                com.opos.cmn.an.f.a.b("MobFileTool", "dirtyFile exist");
            } else {
                str = file.renameTo(file2) ? "dirtyFile not exists" : "rn fail";
            }
            b(file2);
            return;
        }
        com.opos.cmn.an.f.a.b("MobFileTool", str);
    }

    private static void b(File file) {
        StringBuilder sb;
        String str;
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
                    b(listFiles[i2]);
                    i = i2 + 1;
                }
            }
            sb = new StringBuilder();
            str = "removeDirectory = ";
        } else {
            sb = new StringBuilder();
            str = "removeFile = ";
        }
        sb.append(str);
        sb.append(file.getAbsolutePath());
        com.opos.cmn.an.f.a.b("MobFileTool", sb.toString());
        file.delete();
    }

    public static void b(File file, long j, int i) {
        a(file, j, i, false);
    }
}
