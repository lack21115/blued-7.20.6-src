package com.huawei.hms.hatool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/u0.class */
public final class u0 {
    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    q0 q0Var = new q0(1024);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        q0Var.a(bArr, read);
                    }
                    if (q0Var.b() == 0) {
                        a((Closeable) fileInputStream);
                        return "";
                    }
                    String str = new String(q0Var.a(), "UTF-8");
                    a((Closeable) fileInputStream);
                    return str;
                } catch (FileNotFoundException e) {
                    z.f("hmsSdk", "getInfoFromFile(): No files need to be read");
                    a((Closeable) fileInputStream);
                    return "";
                } catch (IOException e2) {
                    z.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                    a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                fileInputStream = null;
            } catch (IOException e4) {
                fileInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            a((Closeable) byteArrayOutputStream);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                z.f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static void a(File file, String str) {
        FileOutputStream fileOutputStream;
        String str2;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    fileOutputStream.flush();
                } catch (FileNotFoundException e) {
                    str2 = "saveInfoToFile(): No files need to be read";
                    fileOutputStream2 = fileOutputStream;
                    z.f("hmsSdk", str2);
                    a((Closeable) fileOutputStream);
                } catch (IOException e2) {
                    str2 = "saveInfoToFile(): io exc from write info to file!";
                    fileOutputStream2 = fileOutputStream;
                    z.f("hmsSdk", str2);
                    a((Closeable) fileOutputStream);
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    a((Closeable) fileOutputStream2);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                fileOutputStream = null;
            } catch (IOException e4) {
                fileOutputStream = null;
            }
            a((Closeable) fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                z.f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception e) {
            z.f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        z.a("hmsSdk", " connHttp disconnect");
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        a((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
