package com.tencent.tmsqmsp.sdk.f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/j.class */
public class j {
    public static int a(String str, File file) {
        ZipInputStream zipInputStream;
        byte[] bArr = new byte[1024];
        try {
            try {
                zipInputStream = new ZipInputStream(new FileInputStream(str));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        while (nextEntry != null) {
                            String name = nextEntry.getName();
                            if (name != null && !name.contains("../")) {
                                File a2 = a(file, nextEntry);
                                if (!nextEntry.isDirectory()) {
                                    File parentFile = a2.getParentFile();
                                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                                        throw new IOException("Failed to create directory " + parentFile);
                                    }
                                    FileOutputStream fileOutputStream = new FileOutputStream(a2);
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.close();
                                } else if (!a2.isDirectory() && !a2.mkdirs()) {
                                    throw new IOException("Failed to create directory " + a2);
                                }
                            }
                        }
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        zipInputStream.close();
                        return 0;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (zipInputStream != null) {
                                zipInputStream.close();
                                return -1;
                            }
                            return -1;
                        } catch (Throwable th2) {
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zipInputStream = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static File a(File file, ZipEntry zipEntry) {
        File file2;
        File file3;
        try {
            file3 = new File(file, zipEntry.getName());
        } catch (Throwable th) {
            th = th;
            file2 = null;
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            if (file3.getCanonicalPath().startsWith(canonicalPath + File.separator)) {
                return file3;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Entry is outside of the target dir: ");
            sb.append(zipEntry.getName());
            throw new IOException(sb.toString());
        } catch (Throwable th2) {
            th = th2;
            file2 = file3;
            th.printStackTrace();
            return file2;
        }
    }
}
