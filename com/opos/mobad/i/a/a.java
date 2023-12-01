package com.opos.mobad.i.a;

import android.content.Context;
import android.util.Log;
import com.opos.mobad.i.b;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a/a.class */
public class a implements com.opos.mobad.i.d {
    private int a(long j) {
        long j2 = (j % 1048576 == 0 ? 0 : 1) + (j / 1048576);
        long j3 = j2;
        if (j2 > 5) {
            j3 = 5;
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockNum=" + j3);
        return (int) j3;
    }

    private int a(long j, int i) {
        long j2 = 5 == i ? j / 5 : 1048576L;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockSize=" + j2);
        return (int) j2;
    }

    private String a(com.opos.mobad.i.a aVar) {
        if (aVar != null) {
            int i = aVar.f12520c;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return "";
                    }
                    return aVar.f + File.separator + aVar.g;
                }
                return aVar.g;
            }
            return aVar.d;
        }
        return "";
    }

    private void a(File file) {
        if (file == null || com.opos.cmn.an.d.b.a.a(file)) {
            return;
        }
        if (!com.opos.cmn.an.d.b.a.b(com.opos.cmn.an.d.b.a.d(file))) {
            com.opos.cmn.an.d.b.a.c(file);
        }
        com.opos.cmn.an.d.b.a.f(file);
    }

    private void a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        a(new File(str));
    }

    private boolean a(int i) {
        boolean z = i == 0;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needLockFile result=" + z);
        return z;
    }

    private boolean a(Context context, com.opos.mobad.i.a aVar, long j) {
        boolean z;
        if (context != null && aVar != null) {
            try {
                z = a(d.a(context, aVar), aVar.b, j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "verifyFileIntegrity", (Throwable) e);
            }
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "verifyFileIntegrity downloadRequest=", aVar, "contentLength=", Long.valueOf(j), "result=", Boolean.valueOf(z));
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "verifyFileIntegrity downloadRequest=", aVar, "contentLength=", Long.valueOf(j), "result=", Boolean.valueOf(z));
        return z;
    }

    private boolean a(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.b.b.e eVar) {
        if (context == null || aVar == null || eVar == null) {
            return false;
        }
        try {
            if (eVar.d >= 1048576) {
                com.opos.cmn.func.b.b.a aVar2 = eVar.f;
                String a2 = aVar2 != null ? aVar2.a("Accept-Ranges") : "";
                StringBuilder sb = new StringBuilder();
                sb.append("download acceptRange=");
                sb.append(a2 != null ? a2 : "");
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
                if (!com.opos.cmn.an.c.a.a(a2)) {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server support multi thread download ");
                    return d(context, aVar, eVar);
                }
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server don't support multi thread download,download as normal file.");
            } else {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download normal file=" + aVar.d);
            }
            return b(context, aVar, eVar);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadEngineImpl", "download", (Throwable) e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (com.opos.cmn.an.d.b.a.a(r10, r9) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        r14 = a(r8, r9, r13, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c7, code lost:
        if (com.opos.cmn.an.d.b.a.a(r10, r9) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r8, java.io.File r9, java.io.InputStream r10, long r11, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.i.a.a.a(java.io.File, java.io.File, java.io.InputStream, long, java.lang.String):boolean");
    }

    private boolean a(File file, File file2, String str, long j) {
        boolean z = file != null && file2 != null && a(file2, str, j) && com.opos.cmn.an.d.b.a.a(file2, file);
        StringBuilder sb = new StringBuilder();
        sb.append("verifyTmpFileAndRename destFile=");
        sb.append(file != null ? file.getAbsolutePath() : com.igexin.push.core.b.l);
        sb.append(",tmpFile=");
        sb.append(file2 != null ? file2.getAbsolutePath() : com.igexin.push.core.b.l);
        sb.append(",md5=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append("contentLength=");
        sb.append(j);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean a(File file, String str) {
        boolean z = com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.a.c.a(file).equals(str);
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        sb.append(file != null ? file.getAbsolutePath() : com.igexin.push.core.b.l);
        sb.append(",md5=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean a(File file, String str, long j) {
        boolean z = j <= 0 ? com.opos.cmn.an.d.b.a.a(file) && a(file, str) : j == com.opos.cmn.an.d.b.a.g(file) && a(file, str);
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        sb.append(file != null ? file.getAbsolutePath() : com.igexin.push.core.b.l);
        sb.append(",md5=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",contentLength=");
        sb.append(j);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean b(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.b.b.e eVar) {
        boolean z;
        if (context != null && aVar != null) {
            try {
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e);
            } finally {
                eVar.a();
            }
            if (eVar != null) {
                if (200 != eVar.f11174a) {
                    Log.d("DownloadEngineImpl", "downloadNormalFile httpResponseEntity.getResponseCode()=" + eVar.f11174a);
                } else if (c(context, aVar, eVar)) {
                    z = true;
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
                    return z;
                }
                z = false;
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
        return z;
    }

    private boolean c(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.b.b.e eVar) {
        boolean a2 = (context == null || aVar == null || eVar == null) ? false : a(d.a(context, aVar), d.b(context, aVar), eVar.f11175c, eVar.d, aVar.b);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(a2));
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x065f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02a0 A[Catch: all -> 0x0678, Exception -> 0x06cf, TRY_ENTER, TryCatch #14 {all -> 0x0678, blocks: (B:8:0x0010, B:11:0x003b, B:13:0x0043, B:14:0x0053, B:14:0x0053, B:15:0x0056, B:16:0x005e, B:78:0x0230, B:76:0x0227, B:84:0x0262, B:87:0x0277, B:89:0x02a0, B:91:0x02b0, B:93:0x02b8, B:95:0x02be, B:97:0x02c5, B:100:0x0307, B:105:0x0340, B:108:0x0380, B:110:0x039b, B:116:0x03e7, B:118:0x03fe, B:43:0x0164), top: B:238:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.content.Context r15, com.opos.mobad.i.a r16, com.opos.cmn.func.b.b.e r17) {
        /*
            Method dump skipped, instructions count: 1859
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.i.a.a.d(android.content.Context, com.opos.mobad.i.a, com.opos.cmn.func.b.b.e):boolean");
    }

    @Override // com.opos.mobad.i.d
    public com.opos.mobad.i.b a(Context context, com.opos.mobad.i.a aVar) {
        boolean z;
        b.a aVar2 = new b.a();
        if (context != null && aVar != null) {
            long j = 0;
            com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(context, aVar.f12519a);
            if (a2 != null) {
                j = a2.d;
            }
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download contentLength=" + j);
            aVar2.a(j);
            if (a(context, aVar, j)) {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                z = true;
            } else {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target not exists,start download it now.fileInfo=" + a(aVar));
                if (a(aVar.f12520c)) {
                    String str = aVar.d + ".lk";
                    a(str);
                    e eVar = new e(str);
                    try {
                        if (!eVar.a()) {
                            z = false;
                        } else if (a(context, aVar, j)) {
                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                            z = true;
                        } else {
                            z = a(context, aVar, a2);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e);
                    } finally {
                        eVar.b();
                        com.opos.cmn.an.d.b.a.d(str);
                    }
                } else {
                    z = a(context, aVar, a2);
                }
            }
            aVar2.a(z);
            com.opos.mobad.i.b a3 = aVar2.a();
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download downloadRequest=", aVar, "downloadResponse=", a3);
            return a3;
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "context or downloadRequest  is null.");
        z = false;
        aVar2.a(z);
        com.opos.mobad.i.b a32 = aVar2.a();
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download downloadRequest=", aVar, "downloadResponse=", a32);
        return a32;
    }
}
