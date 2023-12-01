package com.getui.gtc.i.a;

import com.getui.gtc.base.util.io.IOUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/i/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8424a = !a.class.desiredAssertionStatus();

    public static String a(String str) {
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(File file, File file2, String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        FileInputStream fileInputStream;
        BufferedOutputStream bufferedOutputStream2;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byte[] bArr2 = new byte[read];
                            System.arraycopy(bArr, 0, bArr2, 0, read);
                            bufferedOutputStream3.write(b.a(bArr2, str));
                        }
                        bufferedOutputStream3.flush();
                        IOUtils.safeClose(fileInputStream);
                        bufferedOutputStream2 = bufferedOutputStream3;
                    } catch (Exception e) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        fileOutputStream = fileOutputStream2;
                        e = e;
                        try {
                            com.getui.gtc.i.c.a.b(e);
                            com.getui.gtc.i.b.a.a(file2);
                            IOUtils.safeClose(fileInputStream);
                            fileOutputStream2 = fileOutputStream;
                            IOUtils.safeClose(bufferedOutputStream2);
                            IOUtils.safeClose(fileOutputStream2);
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = bufferedOutputStream2;
                            IOUtils.safeClose(fileInputStream);
                            IOUtils.safeClose(bufferedOutputStream);
                            IOUtils.safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        fileOutputStream3 = fileOutputStream2;
                        th = th2;
                        fileOutputStream = fileOutputStream3;
                        IOUtils.safeClose(fileInputStream);
                        IOUtils.safeClose(bufferedOutputStream);
                        IOUtils.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    bufferedOutputStream2 = null;
                    fileOutputStream = fileOutputStream2;
                    e = e2;
                } catch (Throwable th3) {
                    bufferedOutputStream = null;
                    fileOutputStream3 = fileOutputStream2;
                    th = th3;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                bufferedOutputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream3 = null;
                bufferedOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            bufferedOutputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            bufferedOutputStream = null;
            fileInputStream = null;
        }
        IOUtils.safeClose(bufferedOutputStream2);
        IOUtils.safeClose(fileOutputStream2);
    }
}
