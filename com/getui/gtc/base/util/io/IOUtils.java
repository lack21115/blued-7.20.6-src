package com.getui.gtc.base.util.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/io/IOUtils.class */
public class IOUtils {
    public static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    static final char pad = '=';

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void copy(byte[] bArr, OutputStream outputStream) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            safeClose(byteArrayInputStream);
            throw e;
        }
    }

    public static void encode(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, i);
        copy(inputStream, base64OutputStream);
        base64OutputStream.commit();
    }

    public static byte[] encode(byte[] bArr, int i) throws RuntimeException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                encode(byteArrayInputStream, byteArrayOutputStream, i);
                safeClose(byteArrayInputStream);
                safeClose(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Unexpected I/O error", e);
            }
        } catch (Throwable th) {
            safeClose(byteArrayInputStream);
            safeClose(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] gzip(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    safeClose(gZIPOutputStream2);
                    safeClose(byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safeClose(gZIPOutputStream);
                    safeClose(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] readFile(File file) throws IOException {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (IOException e2) {
                    return byteArray;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void saveToFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        safeClose(fileOutputStream2);
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                th = th;
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void saveToFile(InputStream inputStream, String str) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        safeClose(fileOutputStream2);
                        return;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                th = th;
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void saveToFile(byte[] bArr, File file) throws IOException {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2);
                    if (read == -1) {
                        safeClose(byteArrayInputStream);
                        safeClose(fileOutputStream);
                        return;
                    }
                    fileOutputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                safeClose(byteArrayInputStream);
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            byteArrayInputStream = null;
        }
    }

    public static byte[] unGzip(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Throwable th;
        try {
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream3);
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read();
                            if (read == -1) {
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                safeClose(gZIPInputStream);
                                safeClose(byteArrayOutputStream2);
                                safeClose(byteArrayInputStream3);
                                return byteArray;
                            }
                            byteArrayOutputStream2.write(read);
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayInputStream2 = byteArrayInputStream3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            safeClose(gZIPInputStream);
                            safeClose(byteArrayOutputStream);
                            safeClose(byteArrayInputStream2);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayInputStream2 = byteArrayInputStream3;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th4) {
                byteArrayInputStream = byteArrayInputStream3;
                th = th4;
                Throwable th5 = th;
                gZIPInputStream = null;
                byteArrayOutputStream = null;
                byteArrayInputStream2 = byteArrayInputStream;
                th = th5;
                safeClose(gZIPInputStream);
                safeClose(byteArrayOutputStream);
                safeClose(byteArrayInputStream2);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
        }
    }
}
