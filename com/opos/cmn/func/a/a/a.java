package com.opos.cmn.func.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.an.g.g;
import com.opos.cmn.an.g.h;
import com.opos.cmn.func.a.b;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a/a.class */
public class a implements com.opos.cmn.func.a.d {
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

    private String a(com.opos.cmn.func.a.a aVar) {
        if (aVar != null) {
            int i = aVar.f24797c;
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

    private static String a(Throwable th) {
        String str = "";
        if (th != null) {
            str = th.getMessage();
            if (TextUtils.isEmpty(str)) {
                return "" + th;
            }
        }
        return str;
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.content.Context r8, com.opos.cmn.func.a.a r9, long r10) {
        /*
            r7 = this;
            r0 = r8
            if (r0 == 0) goto L25
            r0 = r9
            if (r0 == 0) goto L25
            r0 = r7
            r1 = r8
            r2 = r9
            java.io.File r1 = com.opos.cmn.func.a.a.d.a(r1, r2)     // Catch: java.lang.Exception -> L1c
            r2 = r9
            java.lang.String r2 = r2.b     // Catch: java.lang.Exception -> L1c
            r3 = r10
            r4 = 0
            boolean r0 = r0.a(r1, r2, r3, r4)     // Catch: java.lang.Exception -> L1c
            r12 = r0
            goto L28
        L1c:
            r8 = move-exception
            java.lang.String r0 = "DownloadEngineImpl"
            java.lang.String r1 = "verifyFileIntegrity"
            r2 = r8
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L25:
            r0 = 0
            r12 = r0
        L28:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r13 = r0
            r0 = r13
            java.lang.String r1 = "verifyFileIntegrity downloadRequest="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            if (r0 == 0) goto L45
            r0 = r9
            java.lang.String r0 = r0.toString()
            r8 = r0
            goto L48
        L45:
            java.lang.String r0 = "null"
            r8 = r0
        L48:
            r0 = r13
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = ",contentLength="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r13
            r1 = r12
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "DownloadEngineImpl"
            r1 = r13
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.a(android.content.Context, com.opos.cmn.func.a.a, long):boolean");
    }

    private boolean a(Context context, com.opos.cmn.func.a.a aVar, long j, g gVar, b.a aVar2) {
        if (context == null || aVar == null || gVar == null) {
            return false;
        }
        try {
            if (gVar.d >= 1048576) {
                Map<String, String> map = gVar.e;
                String str = (map == null || map.size() <= 0) ? "" : map.get("Accept-Ranges");
                StringBuilder sb = new StringBuilder();
                sb.append("download acceptRange=");
                sb.append(str != null ? str : "");
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
                if (!com.opos.cmn.an.c.a.a(str)) {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server support multi thread download ");
                    return c(context, aVar, j, gVar, aVar2);
                }
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server don't support multi thread download,download as normal file.");
            } else {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download normal file=" + aVar.d);
            }
            return b(context, aVar, j, gVar, aVar2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("DownloadEngineImpl", "download", e);
            aVar2.a(6);
            aVar2.a("unknown exception: download2 " + a(e));
            return false;
        }
    }

    private boolean a(Context context, com.opos.cmn.func.a.a aVar, g gVar, b.a aVar2) {
        long j;
        boolean z;
        if (gVar != null) {
            long j2 = gVar.d;
            j = j2;
            if (gVar.e != null) {
                j = j2;
                if (DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(gVar.e.get("Transfer-Encoding"))) {
                    j = -1000;
                }
            }
        } else {
            j = 0;
        }
        if (context == null || aVar == null || gVar == null || (j <= 0 && j != -1000)) {
            aVar2.a(5);
            aVar2.a("internal error: saveNormalFile context=" + context + " contentLength=" + j + " downloadRequest=" + aVar + " netResponse=" + gVar);
            z = false;
        } else {
            z = a(d.a(context, aVar), d.b(context, aVar), gVar.f24554c, j, aVar.b, aVar2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("saveNormalFile downloadRequest=");
        sb.append(aVar != null ? aVar.toString() : com.igexin.push.core.b.l);
        sb.append(",netResponse=");
        String str = com.igexin.push.core.b.l;
        if (gVar != null) {
            str = gVar.toString();
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean a(File file, File file2, InputStream inputStream, long j, String str, b.a aVar) {
        boolean z;
        if (file == null || file2 == null || inputStream == null) {
            aVar.a(5);
            aVar.a("internal error: saveNormalFile destFile=" + file + " tmpFile=" + file2 + " inputStream=" + inputStream);
            return false;
        }
        long g = com.opos.cmn.an.d.b.a.g(file2);
        try {
            try {
                if (com.opos.cmn.an.d.b.a.a(file)) {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists." + file.getAbsolutePath());
                    if (a(file, str, j, (b.a) null)) {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists and valid, don't need rename!" + file.getAbsolutePath());
                        z = true;
                    } else {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists but not valid, rename tmp file!");
                        com.opos.cmn.an.d.b.a.e(file);
                        boolean a2 = com.opos.cmn.an.d.b.a.a(inputStream, file2);
                        long g2 = com.opos.cmn.an.d.b.a.g(file2) - g;
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile: traffic = " + g2 + ", tmpFileOriginLength = " + g + ", dest = " + file.getAbsolutePath());
                        aVar.b(g2);
                        if (!a2) {
                            aVar.a(2);
                            z = false;
                        }
                        z = a(file, file2, str, j, aVar);
                    }
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file not exists." + file.getAbsolutePath());
                    boolean a3 = com.opos.cmn.an.d.b.a.a(inputStream, file2);
                    long g3 = com.opos.cmn.an.d.b.a.g(file2) - g;
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile: traffic = " + g3 + ", tmpFileOriginLength = " + g + ", dest = " + file.getAbsolutePath());
                    aVar.b(g3);
                    if (!a3) {
                        aVar.a(2);
                        z = false;
                    }
                    z = a(file, file2, str, j, aVar);
                }
                com.opos.cmn.an.d.b.a.e(file2);
                return z;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("DownloadEngineImpl", "saveSdFile", e);
                aVar.a(6);
                aVar.a("unknown exception: saveNormalFile " + a(e));
                com.opos.cmn.an.d.b.a.e(file2);
                return false;
            }
        } catch (Throwable th) {
            com.opos.cmn.an.d.b.a.e(file2);
            throw th;
        }
    }

    private boolean a(File file, File file2, String str, long j, b.a aVar) {
        boolean z = file != null && file2 != null && a(file2, str, j, aVar) && com.opos.cmn.an.d.b.a.a(file2, file);
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r7, java.lang.String r8, long r9, com.opos.cmn.func.a.b.a r11) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.a(java.io.File, java.lang.String, long, com.opos.cmn.func.a.b$a):boolean");
    }

    private boolean a(File file, String str, b.a aVar, String str2) {
        String str3;
        boolean z = true;
        if (com.opos.cmn.an.c.a.a(str)) {
            str3 = "";
        } else {
            str3 = com.opos.cmn.an.a.c.a(file);
            if (!str3.equalsIgnoreCase(str)) {
                z = false;
            }
        }
        if (!z && aVar != null) {
            aVar.a(4);
            aVar.a("md5 check fail: fileMd5=" + str3 + " targetMd5=" + str + " " + str2);
        }
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

    private boolean b(Context context, com.opos.cmn.func.a.a aVar, long j, g gVar, b.a aVar2) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (aVar != null) {
                z = false;
                if (gVar != null) {
                    try {
                        try {
                            if (200 == gVar.f24553a) {
                                z = false;
                                if (a(context, aVar, gVar, aVar2)) {
                                    z = true;
                                }
                            } else {
                                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile httpResponseEntity.getResponseCode()=" + gVar.f24553a);
                                aVar2.a(gVar.f24553a);
                                z = false;
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.c("DownloadEngineImpl", "", e);
                            aVar2.a(6);
                            aVar2.a("unknown exception: downloadNormalFile " + a(e));
                            z = false;
                        }
                    } finally {
                        h.a(j);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("downloadNormalFile downloadRequest=");
        sb.append(aVar != null ? aVar.toString() : com.igexin.push.core.b.l);
        sb.append(",netResponse=");
        String str = com.igexin.push.core.b.l;
        if (gVar != null) {
            str = gVar.toString();
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:7|8|9|10|11|12|13|(3:185|186|(44:188|189|190|191|192|193|194|195|196|197|198|199|200|201|202|203|204|205|206|207|208|209|210|211|212|(34:215|216|217|218|219|220|221|222|223|224|225|226|227|228|229|230|231|232|233|234|235|236|237|238|239|240|241|242|243|244|245|246|247|213)|272|273|274|275|276|277|16|17|(10:19|(1:21)|22|23|(1:25)|26|27|28|(2:30|(2:31|(6:33|34|35|(1:37)(1:40)|38|39)(1:41)))(0)|42)(1:184)|43|44|45|(2:47|(1:49)(17:71|72|(7:75|76|77|78|79|80|73)|87|88|89|(2:90|(2:92|93)(1:94))|95|96|(4:99|(3:101|102|103)(2:105|106)|104|97)|107|108|109|110|111|112|(2:114|(15:116|117|118|119|120|121|(10:127|128|129|130|131|132|51|(5:53|54|55|56|57)|59|60)|123|124|125|126|51|(0)|59|60)(5:136|137|138|139|(9:141|142|143|144|126|51|(0)|59|60)(7:145|146|147|148|149|150|(9:152|123|124|125|126|51|(0)|59|60)(10:153|154|129|130|131|132|51|(0)|59|60))))(11:155|156|157|158|159|160|161|162|163|164|(16:166|167|168|169|170|171|172|173|174|143|144|126|51|(0)|59|60)(10:175|176|129|130|131|132|51|(0)|59|60))))(1:182)|50|51|(0)|59|60))|15|16|17|(0)(0)|43|44|45|(0)(0)|50|51|(0)|59|60) */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x089a, code lost:
        r20 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0300 A[Catch: all -> 0x089f, IOException -> 0x0928, Exception -> 0x0932, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x0932, blocks: (B:15:0x0055, B:17:0x005d, B:18:0x006d, B:105:0x02f3, B:108:0x0300, B:122:0x0350, B:122:0x0350, B:123:0x0353, B:125:0x0379, B:127:0x0389, B:129:0x0391, B:131:0x0397, B:133:0x039e, B:136:0x03de, B:141:0x040c, B:144:0x044c, B:146:0x0468, B:149:0x04ac, B:153:0x04be, B:154:0x04d6, B:109:0x0308, B:78:0x0237, B:82:0x0255, B:115:0x0330, B:118:0x033d, B:121:0x034f, B:119:0x0345), top: B:308:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x033d A[Catch: all -> 0x089f, IOException -> 0x092d, Exception -> 0x0932, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x092d, blocks: (B:115:0x0330, B:118:0x033d), top: B:304:0x0330 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0379 A[Catch: all -> 0x089f, Exception -> 0x0932, TRY_ENTER, TryCatch #9 {Exception -> 0x0932, blocks: (B:15:0x0055, B:17:0x005d, B:18:0x006d, B:105:0x02f3, B:108:0x0300, B:122:0x0350, B:122:0x0350, B:123:0x0353, B:125:0x0379, B:127:0x0389, B:129:0x0391, B:131:0x0397, B:133:0x039e, B:136:0x03de, B:141:0x040c, B:144:0x044c, B:146:0x0468, B:149:0x04ac, B:153:0x04be, B:154:0x04d6, B:109:0x0308, B:78:0x0237, B:82:0x0255, B:115:0x0330, B:118:0x033d, B:121:0x034f, B:119:0x0345), top: B:308:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0879  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x08db  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x08fd  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0962  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x09a4  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0330 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x02f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(android.content.Context r15, com.opos.cmn.func.a.a r16, long r17, com.opos.cmn.an.g.g r19, com.opos.cmn.func.a.b.a r20) {
        /*
            Method dump skipped, instructions count: 2475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.c(android.content.Context, com.opos.cmn.func.a.a, long, com.opos.cmn.an.g.g, com.opos.cmn.func.a.b$a):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x025f  */
    @Override // com.opos.cmn.func.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.cmn.func.a.b a(android.content.Context r9, com.opos.cmn.func.a.a r10) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.a(android.content.Context, com.opos.cmn.func.a.a):com.opos.cmn.func.a.b");
    }
}
