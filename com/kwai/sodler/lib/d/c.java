package com.kwai.sodler.lib.d;

import android.text.TextUtils;
import com.kwad.sdk.utils.q;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/d/c.class */
public final class c {
    public static File a(File file, String str, File file2) {
        File file3;
        String tz = a.tz();
        if (TextUtils.isEmpty(tz)) {
            com.kwai.sodler.lib.a.w("plugin.so", "Cpu abis is null.");
            file3 = null;
        } else {
            new StringBuilder("Try install soLib, supported abi = ").append(tz);
            File file4 = new File(file, "lib" + File.separator + tz + File.separator + str);
            file3 = null;
            if (file4.exists()) {
                file3 = new File(file2, str);
                if (!file4.renameTo(file3)) {
                    throw new IOException("Rename soLib fail.");
                }
                StringBuilder sb = new StringBuilder("Rename soLib, from = ");
                sb.append(file4.getAbsolutePath());
                sb.append(", to = ");
                sb.append(file3.getAbsolutePath());
            }
        }
        if (file3 == null) {
            StringBuilder sb2 = new StringBuilder("Can not install ");
            sb2.append(str);
            sb2.append(", NO_MATCHING_ABIS");
        }
        return file3;
    }

    public static Set<String> h(File file, File file2) {
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile2;
        BufferedInputStream bufferedInputStream2;
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        q.S(file2);
        StringBuilder sb = new StringBuilder("copy so file to ");
        sb.append(file2.getAbsolutePath());
        sb.append(", apk = ");
        sb.append(file.getName());
        BufferedInputStream bufferedInputStream3 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                BufferedOutputStream bufferedOutputStream = null;
                BufferedInputStream bufferedInputStream4 = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        String name = nextElement.getName();
                        if (name != null && !name.contains("../")) {
                            if (!name.startsWith("lib" + File.separator)) {
                                new StringBuilder("not lib dir entry, skip ").append(name);
                            } else if (nextElement.isDirectory()) {
                                File file3 = new File(file2, name);
                                new StringBuilder("create dir ").append(file3.getAbsolutePath());
                                q.S(file3);
                            } else {
                                File file4 = new File(file2, name);
                                new StringBuilder("unzip soLib file ").append(file4.getAbsolutePath());
                                q.T(file4);
                                byte[] bArr = new byte[4096];
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
                                try {
                                    FileDescriptor fd = fileOutputStream2.getFD();
                                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                                    try {
                                        BufferedInputStream bufferedInputStream5 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                        while (true) {
                                            try {
                                                int read = bufferedInputStream5.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            } catch (IOException e) {
                                                bufferedInputStream2 = bufferedInputStream5;
                                                e = e;
                                                zipFile2 = zipFile;
                                                fileOutputStream = bufferedOutputStream;
                                                bufferedInputStream = bufferedInputStream2;
                                                try {
                                                    com.kwai.sodler.lib.a.e("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                } catch (Throwable th) {
                                                    zipFile = zipFile2;
                                                    th = th;
                                                    bufferedInputStream3 = bufferedInputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream3);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                bufferedInputStream4 = bufferedInputStream5;
                                                bufferedInputStream3 = bufferedInputStream4;
                                                fileOutputStream = bufferedOutputStream;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream3);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        fd.sync();
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream5);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                                        hashSet.add(file4.getName());
                                        bufferedInputStream4 = bufferedInputStream5;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedInputStream2 = bufferedInputStream4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e3) {
                                    bufferedOutputStream = fileOutputStream2;
                                    e = e3;
                                    BufferedInputStream bufferedInputStream6 = bufferedInputStream4;
                                    fileOutputStream = bufferedOutputStream;
                                    bufferedInputStream = bufferedInputStream6;
                                    zipFile2 = zipFile;
                                    com.kwai.sodler.lib.a.e("plugin.so", e);
                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                } catch (Throwable th4) {
                                    bufferedInputStream3 = bufferedInputStream4;
                                    fileOutputStream = fileOutputStream2;
                                    th = th4;
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream3 = bufferedInputStream4;
                        fileOutputStream = bufferedOutputStream;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream4);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                return hashSet;
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
            bufferedInputStream = null;
            zipFile2 = null;
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            fileOutputStream = null;
        }
    }
}
