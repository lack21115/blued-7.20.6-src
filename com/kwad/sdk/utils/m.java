package com.kwad.sdk.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/m.class */
public final class m {
    public static void a(File[] fileArr, String str) {
        a(fileArr, str, -1);
    }

    private static void a(File[] fileArr, String str, int i) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        ZipOutputStream zipOutputStream2;
        BufferedInputStream bufferedInputStream3 = null;
        BufferedInputStream bufferedInputStream4 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
                try {
                    byte[] bArr = new byte[4096];
                    int i2 = 0;
                    BufferedInputStream bufferedInputStream5 = null;
                    while (true) {
                        zipOutputStream2 = zipOutputStream;
                        bufferedInputStream2 = bufferedInputStream5;
                        bufferedInputStream3 = bufferedInputStream5;
                        if (i2 >= fileArr.length) {
                            break;
                        }
                        BufferedInputStream bufferedInputStream6 = bufferedInputStream5;
                        bufferedInputStream5 = new BufferedInputStream(new FileInputStream(fileArr[i2]), 4096);
                        try {
                            String absolutePath = fileArr[i2].getAbsolutePath();
                            zipOutputStream.putNextEntry(new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream5.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            bufferedInputStream5.close();
                            i2++;
                        } catch (Exception e) {
                            bufferedInputStream = bufferedInputStream5;
                            e = e;
                            com.kwad.sdk.core.d.b.printStackTrace(e);
                            zipOutputStream2 = zipOutputStream;
                            bufferedInputStream2 = bufferedInputStream;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream2);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream4 = bufferedInputStream5;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream4);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream3;
                }
            } catch (Exception e3) {
                e = e3;
                zipOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream2);
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
    }

    public static byte[] k(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            bArr2 = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                bArr2 = byteArray;
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
        return bArr2;
    }
}
