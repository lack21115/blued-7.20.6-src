package com.uc.crashsdk.a;

import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f40561a = !c.class.desiredAssertionStatus();
    private static String b = "";

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (!f40561a && bArr2.length != 4) {
            throw new AssertionError();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return;
            }
            bArr[i3 + i] = bArr2[i3];
            i2 = i3 + 1;
        }
    }

    public static boolean a(File file, String str, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return false;
            }
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
            i = i2 + 1;
        }
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        Throwable th;
        byte[] byteArray;
        a.a("Uploading to " + str2);
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                int length = sb.length();
                int length2 = bArr.length;
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length + 40 + length2));
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(sb.toString().getBytes());
                    outputStream.write(bArr);
                    outputStream.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        g.a(outputStream);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                                return false;
                            } catch (Throwable th2) {
                                return false;
                            }
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    g.b(th);
                                    g.a(outputStream);
                                    g.a(inputStream);
                                    g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                            return false;
                                        } catch (Throwable th4) {
                                            return false;
                                        }
                                    }
                                    return false;
                                } catch (Throwable th5) {
                                    g.a(outputStream);
                                    g.a(inputStream);
                                    g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th6) {
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        }
                        if (byteArrayOutputStream.toByteArray() == null) {
                            g.a(outputStream);
                            g.a(inputStream);
                            g.a(byteArrayOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                    return false;
                                } catch (Throwable th7) {
                                    return false;
                                }
                            }
                            return false;
                        }
                        a.a("crashsdk", "Log upload response: " + new String(byteArray));
                        g.a(outputStream);
                        g.a(inputStream);
                        g.a(byteArrayOutputStream);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                                return true;
                            } catch (Throwable th8) {
                                return true;
                            }
                        }
                        return true;
                    } catch (Throwable th9) {
                        th = th9;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th11) {
                th = th11;
                inputStream = null;
                byteArrayOutputStream = null;
                outputStream = null;
            }
        } catch (Throwable th12) {
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
            outputStream = null;
            th = th12;
        }
    }

    public static byte[] a() {
        return new byte[]{48, 25, 6, 55};
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x00b4: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:36:0x00b4 */
    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        byte[] bArr;
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                int length = (int) file.length();
                fileInputStream2 = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream2);
                    byte[] bArr2 = null;
                    try {
                        byte[] bArr3 = new byte[length];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            bArr2 = bArr3;
                            int read = bufferedInputStream.read(bArr3, i2, length - i2);
                            if (-1 == read) {
                                break;
                            }
                            i = i2 + read;
                        }
                        g.a(bufferedInputStream);
                        g.a(fileInputStream2);
                        return bArr3;
                    } catch (Exception e) {
                        inputStream = bufferedInputStream;
                        e = e;
                        bArr = bArr2;
                        g.b(e);
                        g.a(inputStream);
                        g.a(fileInputStream2);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        g.a(bufferedInputStream);
                        g.a(fileInputStream2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Exception e3) {
                e = e3;
                bArr = null;
                fileInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = null;
            }
        } catch (Throwable th4) {
            fileInputStream2 = fileInputStream;
            bufferedInputStream = null;
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r5, byte[] r6) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.c.a(java.lang.String, byte[]):byte[]");
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        int i = 4;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                System.arraycopy((Object) bArr, 0, (Object) bArr2, 16, bArr.length);
                return bArr2;
            }
            bArr2[i2] = 0;
            i = i2 + 1;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (z) {
            if (!z2) {
                bArr = a(bArr);
            }
            return cipher.doFinal(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a2 = a(file);
            if (a2 == null || a2.length == 0) {
                return false;
            }
            return a(a2, str, str2);
        } catch (Exception e) {
            g.a(e);
            return false;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }
}
