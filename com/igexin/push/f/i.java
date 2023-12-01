package com.igexin.push.f;

import com.huawei.openalliance.ad.constant.ax;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    String f10044a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    File f10045c;
    private byte[] d;

    private i(File file) {
        this.f10045c = file;
    }

    private i(String str) {
        this(new File(str));
    }

    private i(String str, byte[] bArr) {
        this.f10044a = str;
        this.d = bArr;
    }

    private i(String str, byte[] bArr, String str2) {
        this(str, bArr);
        this.b = str2;
    }

    private i(byte[] bArr) {
        this.d = bArr;
    }

    private static String a(byte[] bArr) {
        Object obj = null;
        if (bArr != null) {
            if (bArr.length < 10) {
                obj = null;
            } else if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
                obj = "GIF";
            } else if (bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
                obj = "PNG";
            } else if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                obj = "JPG";
            } else {
                obj = null;
                if (bArr[0] == 66) {
                    obj = null;
                    if (bArr[1] == 77) {
                        obj = "BMP";
                    }
                }
            }
        }
        return "JPG".equals(obj) ? ax.V : "GIF".equals(obj) ? ax.B : "PNG".equals(obj) ? ax.Z : "BMP".equals(obj) ? "image/bmp" : "application/octet-stream";
    }

    private String b() {
        File file;
        if (this.f10044a == null && (file = this.f10045c) != null && file.exists()) {
            this.f10044a = this.f10045c.getName();
        }
        return this.f10044a;
    }

    private static String b(byte[] bArr) {
        if (bArr == null || bArr.length < 10) {
            return null;
        }
        if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            return "GIF";
        }
        if (bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
            return "PNG";
        }
        if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
            return "JPG";
        }
        if (bArr[0] == 66 && bArr[1] == 77) {
            return "BMP";
        }
        return null;
    }

    private String c() throws IOException {
        if (this.b == null) {
            byte[] a2 = a();
            Object obj = null;
            if (a2 != null) {
                if (a2.length < 10) {
                    obj = null;
                } else if (a2[0] == 71 && a2[1] == 73 && a2[2] == 70) {
                    obj = "GIF";
                } else if (a2[1] == 80 && a2[2] == 78 && a2[3] == 71) {
                    obj = "PNG";
                } else if (a2[6] == 74 && a2[7] == 70 && a2[8] == 73 && a2[9] == 70) {
                    obj = "JPG";
                } else {
                    obj = null;
                    if (a2[0] == 66) {
                        obj = null;
                        if (a2[1] == 77) {
                            obj = "BMP";
                        }
                    }
                }
            }
            this.b = "JPG".equals(obj) ? ax.V : "GIF".equals(obj) ? ax.B : "PNG".equals(obj) ? ax.Z : "BMP".equals(obj) ? "image/bmp" : "application/octet-stream";
        }
        return this.b;
    }

    public final byte[] a() throws IOException {
        File file;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        if (this.d == null && (file = this.f10045c) != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(this.f10045c);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = fileInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        } catch (Throwable th) {
                            th = th;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                    this.d = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
        }
        return this.d;
    }
}
