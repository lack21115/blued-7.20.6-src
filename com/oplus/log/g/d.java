package com.oplus.log.g;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.oplus.log.d.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/d.class */
public final class d {

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/log/g/d$a.class */
    public interface a {
        void a(int i, File file);

        void a(int i, String str);
    }

    private static List<File> a(long j, long j2, String str, final String str2) {
        long j3;
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
        try {
            j3 = simpleDateFormat.parse(simpleDateFormat.format(new Date(j))).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            j3 = j;
        }
        File a2 = h.a(str);
        if (a2 != null && (listFiles = a2.listFiles(new FilenameFilter() { // from class: com.oplus.log.g.d.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str3) {
                if (TextUtils.isEmpty(str3)) {
                    return false;
                }
                return (str3.endsWith(".dog3") || str3.endsWith(".dog1") || str3.endsWith(".dog2")) && (TextUtils.isEmpty(String.this) || str3.startsWith(String.this));
            }
        })) != null && listFiles.length > 0) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                File file = listFiles[i2];
                try {
                    String[] split = file.getName().split("\\.")[0].split(BridgeUtil.UNDERLINE_STR);
                    long time = simpleDateFormat.parse(split[split.length - 4] + "-" + split[split.length - 3] + "-" + split[split.length - 2] + "-" + split[split.length - 1]).getTime();
                    if (j <= 0 || j2 <= 0 || (time >= j3 && time <= j2)) {
                        arrayList.add(file);
                    }
                } catch (Exception e2) {
                    if (com.oplus.log.b.a()) {
                        e2.printStackTrace();
                    }
                }
                i = i2 + 1;
            }
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.oplus.log.g.d.2
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file2, File file3) {
                    return file2.lastModified() <= file3.lastModified() ? 1 : -1;
                }
            });
        }
        return arrayList;
    }

    public static void a(long j, long j2, com.oplus.log.c cVar, String str, String str2, a aVar) {
        List<File> a2 = a(j, j2, cVar.e(), cVar.g());
        if (a2.size() == 0) {
            aVar.a(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "no match file");
            return;
        }
        a("opluslog_" + str2 + BridgeUtil.UNDERLINE_STR + UUID.randomUUID() + ".zip", str, a2, aVar);
    }

    private static void a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                a(file2);
            } else {
                file2.delete();
            }
            i = i2 + 1;
        }
    }

    public static void a(String str) {
        File a2 = h.a(str);
        if (a2 == null) {
            return;
        }
        a(a2);
    }

    private static void a(String str, String str2, List<File> list, a aVar) {
        int i;
        int i2;
        FileInputStream fileInputStream;
        File a2 = h.a(str2);
        if (a2 != null && a2.isDirectory() && list != null && list.size() != 0) {
            File b = h.b(str2 + File.separator + str);
            if (b != null) {
                byte[] bArr = new byte[1024];
                int i3 = 100;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(b);
                    ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                    try {
                        Iterator<File> it = list.iterator();
                        long j = 0;
                        while (true) {
                            i2 = i3;
                            if (!it.hasNext()) {
                                break;
                            }
                            File next = it.next();
                            j += next.length();
                            if (j < 3145728) {
                                try {
                                    fileInputStream = new FileInputStream(next);
                                } catch (Exception e) {
                                    i3 = 102;
                                }
                                try {
                                    zipOutputStream.putNextEntry(new ZipEntry(next.getName()));
                                    while (true) {
                                        int read = fileInputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                    zipOutputStream.closeEntry();
                                    fileInputStream.close();
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                        break;
                                    } catch (Throwable th2) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                        throw th2;
                                        break;
                                    }
                                }
                            } else {
                                i2 = 101;
                                break;
                            }
                        }
                        zipOutputStream.close();
                        fileOutputStream.close();
                        if (aVar != null) {
                            if (b.length() > 0) {
                                aVar.a(i2, b);
                                return;
                            } else {
                                aVar.a(PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING, "zip file is empty");
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            try {
                                zipOutputStream.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                            throw th5;
                        }
                    }
                } catch (Exception e2) {
                    if (aVar != null) {
                        aVar.a(PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES, e2.toString());
                        return;
                    }
                    return;
                }
            } else if (aVar == null) {
                return;
            } else {
                i = -103;
            }
        } else if (aVar == null) {
            return;
        } else {
            i = -102;
        }
        aVar.a(i, "");
    }
}
