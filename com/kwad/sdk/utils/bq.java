package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bq.class */
public final class bq {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bq$a.class */
    public static final class a extends ZipOutputStream {
        private Map<String, Integer> aBK;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.aBK = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) {
            Integer num;
            String name = zipEntry.getName();
            Integer num2 = this.aBK.get(name);
            if (num2 == null || num2.intValue() <= 0) {
                num = 1;
            } else {
                zipEntry = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + num2 + ")."));
                num = Integer.valueOf(num2.intValue() + 1);
            }
            this.aBK.put(name, num);
            super.putNextEntry(zipEntry);
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        File[] listFiles;
        if (zipOutputStream == null || file == null) {
            com.kwad.sdk.core.d.b.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
        } else if (!file.exists()) {
            com.kwad.sdk.core.d.b.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
        } else {
            String eW = TextUtils.isEmpty(str) ? eW(file.getName()) : str + File.separator + eW(file.getName());
            if (!file.isFile()) {
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    a(zipOutputStream, file2, eW, bArr);
                }
                return;
            }
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(eW));
                    while (true) {
                        int read = bufferedInputStream2.read(bArr, 0, bArr.length);
                        if (-1 == read) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                            return;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    bufferedInputStream = bufferedInputStream2;
                    e = e;
                    com.kwad.sdk.core.d.b.e("ZipUtils", "error doZip", e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    throw e;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream = null;
            }
        }
    }

    private static boolean a(File[] fileArr, File file) {
        a aVar;
        byte[] bArr;
        a aVar2;
        int i;
        if (file != null) {
            try {
                bArr = new byte[4096];
                aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
                i = 0;
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            while (true) {
                int i2 = i;
                if (i2 > 0) {
                    aVar2.flush();
                    aVar2.closeEntry();
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
                    return true;
                }
                try {
                    a(aVar2, fileArr[0], null, bArr);
                    i = i2 + 1;
                } catch (Throwable th2) {
                    aVar = aVar2;
                    th = th2;
                }
                aVar = aVar2;
                th = th2;
                try {
                    com.kwad.sdk.core.d.b.e("ZipUtils", "error zip", th);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    return false;
                } catch (Throwable th3) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    throw th3;
                }
            }
        }
        return false;
    }

    private static String eW(String str) {
        if (!TextUtils.isEmpty(str) || str.length() <= 1) {
            String str2 = str;
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
                if (str.charAt(0) == '.') {
                    str2 = str.substring(1);
                }
            }
            return str2;
        }
        return str;
    }

    public static boolean unZip(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        ZipInputStream zipInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    ZipInputStream zipInputStream3 = new ZipInputStream(bufferedInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream3.getNextEntry();
                            if (nextEntry == null) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream3);
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                return true;
                            }
                            String name = nextEntry.getName();
                            if (!name.contains("../")) {
                                if (nextEntry.isDirectory()) {
                                    new File(str + BridgeUtil.SPLIT_MARK + name).mkdirs();
                                } else {
                                    File file2 = new File(str + BridgeUtil.SPLIT_MARK + name);
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    try {
                                        fileOutputStream2 = new FileOutputStream(file2);
                                        while (true) {
                                            try {
                                                try {
                                                    int read = zipInputStream3.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream2.write(bArr, 0, read);
                                                } catch (IOException e) {
                                                    e = e;
                                                    com.kwad.sdk.core.d.b.e("ZipUtils", "error unZip when write", e);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                                    zipInputStream3.closeEntry();
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                fileOutputStream = fileOutputStream2;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                                throw th;
                                            }
                                        }
                                        fileOutputStream2.flush();
                                        fileOutputStream2.getFD().sync();
                                    } catch (IOException e2) {
                                        e = e2;
                                        fileOutputStream2 = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream = null;
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                    zipInputStream3.closeEntry();
                                }
                            }
                        }
                    } catch (IOException e3) {
                        zipInputStream = zipInputStream3;
                        e = e3;
                        com.kwad.sdk.core.d.b.e("ZipUtils", "error unZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream2 = zipInputStream3;
                        inputStream = bufferedInputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    zipInputStream = null;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedInputStream = null;
                zipInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip")) {
            return;
        }
        if (zip(file, new File(absolutePath + ".zip"))) {
            file.delete();
        }
    }
}
