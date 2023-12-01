package com.bytedance.pangle.f.a;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f/a/d.class */
public final class d {
    /* JADX WARN: Finally extract failed */
    public static e a(File file) {
        ZipFile zipFile;
        a aVar;
        int b;
        int i;
        String str;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                g.a((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(ShareConstants.RES_MANIFEST);
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    g.a(zipFile2);
                    return null;
                }
                a aVar2 = new a();
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    aVar2.a();
                    if (inputStream != null) {
                        aVar2.b = new b(inputStream);
                    }
                    do {
                        b = aVar2.b();
                        if (b == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar2.a();
                            } catch (Throwable th) {
                            }
                            g.a(zipFile2);
                            return null;
                        }
                    } while (b != 2);
                    int length = aVar2.f21396a != 2 ? -1 : aVar2.f21397c.length / 5;
                    String str2 = null;
                    String str3 = null;
                    int i2 = 0;
                    while (i2 != length) {
                        if ("versionCode".equals(aVar2.a(i2))) {
                            str = a(aVar2, i2);
                        } else {
                            str = str2;
                            if ("package".equals(aVar2.a(i2))) {
                                str3 = a(aVar2, i2);
                                str = str2;
                            }
                        }
                        i2++;
                        str2 = str;
                    }
                    try {
                        i = Integer.parseInt(str2);
                    } catch (Throwable th2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str2)));
                        try {
                            aVar2.a();
                        } catch (Throwable th3) {
                        }
                        g.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(str3, i);
                    try {
                        aVar2.a();
                    } catch (Throwable th4) {
                    }
                    g.a(zipFile2);
                    return eVar;
                } catch (Throwable th5) {
                    th = th5;
                    aVar = aVar2;
                    th = th;
                    zipFile = zipFile2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            if (aVar != null) {
                                try {
                                    aVar.a();
                                } catch (Throwable th6) {
                                }
                            }
                            g.a(zipFile);
                            return null;
                        }
                        e eVar2 = new e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable th7) {
                            }
                        }
                        g.a(zipFile);
                        return eVar2;
                    } catch (Throwable th8) {
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable th9) {
                            }
                        }
                        g.a(zipFile);
                        throw th8;
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                aVar = null;
            }
        } catch (Throwable th11) {
            th = th11;
            zipFile = null;
            aVar = null;
        }
    }

    private static String a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    private static String a(a aVar, int i) {
        int b = aVar.b(i);
        int c2 = aVar.c(i);
        return b == 3 ? aVar.d(i) : b == 2 ? String.format("?%s%08X", a(c2), Integer.valueOf(c2)) : (b < 16 || b > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c2), Integer.valueOf(b)) : String.valueOf(c2);
    }
}
