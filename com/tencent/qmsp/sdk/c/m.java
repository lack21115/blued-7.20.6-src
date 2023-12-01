package com.tencent.qmsp.sdk.c;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f38577a = {96, 110, -109, 82, 109, 2, 36, -77, 108, 59, -80, 10, 112, 122, 56, -67};

    public String a(byte[] bArr) {
        return com.tencent.qmsp.sdk.f.h.a(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, byte[] r8, java.lang.String r9, int r10) {
        /*
            r6 = this;
            r0 = 0
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r9
            r11 = r0
            r0 = r9
            if (r0 != 0) goto L19
            r0 = r13
            r9 = r0
            r0 = r6
            byte[] r1 = com.tencent.qmsp.sdk.c.m.f38577a     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            java.lang.String r0 = r0.a(r1)     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r11 = r0
        L19:
            r0 = r13
            r9 = r0
            com.tencent.qmsp.sdk.f.b r0 = new com.tencent.qmsp.sdk.f.b     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r1 = r8
            r2 = r11
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            byte[] r0 = r0.a(r1, r2)     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L33
            r0 = 0
            return r0
        L33:
            r0 = r13
            r9 = r0
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r1 = r0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r3 = r2
            r4 = r7
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L79
            r7 = r0
            r0 = r7
            r1 = 305419896(0x12345678, float:5.6904566E-28)
            r0.writeInt(r1)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L71
            r0 = r7
            r1 = r10
            r0.writeInt(r1)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L71
            r0 = r7
            r1 = 1
            r0.writeInt(r1)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L71
            r0 = r7
            r1 = r8
            r0.write(r1)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L71
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L62
            r0 = 1
            return r0
        L62:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
            r0 = 1
            return r0
        L69:
            r8 = move-exception
            r0 = r7
            r9 = r0
            r0 = r8
            r7 = r0
            goto L94
        L71:
            r8 = move-exception
            goto L7d
        L75:
            r7 = move-exception
            goto L94
        L79:
            r8 = move-exception
            r0 = r12
            r7 = r0
        L7d:
            r0 = r7
            r9 = r0
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L75
            r0 = r7
            if (r0 == 0) goto L92
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L8d
            r0 = 0
            return r0
        L8d:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L92:
            r0 = 0
            return r0
        L94:
            r0 = r9
            if (r0 == 0) goto La4
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L9f
            goto La4
        L9f:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        La4:
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.c.m.a(java.lang.String, byte[], java.lang.String, int):boolean");
    }

    public byte[] a(String str, String str2, int i) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        File file = new File(str);
        boolean exists = file.exists();
        AutoCloseable autoCloseable = null;
        try {
            if (exists) {
                try {
                    dataInputStream2 = new DataInputStream(new FileInputStream(file));
                } catch (IOException e) {
                    e = e;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            autoCloseable.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    int available = dataInputStream2.available();
                    if (available <= 12 || available > 102400) {
                        try {
                            dataInputStream2.close();
                            return null;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    } else if (dataInputStream2.readInt() != 305419896) {
                        try {
                            dataInputStream2.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    } else {
                        int readInt = dataInputStream2.readInt();
                        if (readInt <= 0 || readInt > i) {
                            try {
                                dataInputStream2.close();
                                return null;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return null;
                            }
                        } else if (dataInputStream2.readInt() != 1) {
                            try {
                                dataInputStream2.close();
                                return null;
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                return null;
                            }
                        } else {
                            int i2 = available - 12;
                            byte[] bArr = new byte[i2];
                            if (i2 != dataInputStream2.read(bArr)) {
                                try {
                                    dataInputStream2.close();
                                    return null;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    return null;
                                }
                            }
                            String str3 = str2;
                            if (str2 == null) {
                                str3 = a(f38577a);
                            }
                            byte[] a2 = new com.tencent.qmsp.sdk.f.b().a(bArr, 0, i2, str3.getBytes());
                            if (a2 == null) {
                                try {
                                    dataInputStream2.close();
                                    return null;
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                    return null;
                                }
                            }
                            try {
                                dataInputStream2.close();
                                return a2;
                            } catch (IOException e9) {
                                e9.printStackTrace();
                                return a2;
                            }
                        }
                    }
                } catch (IOException e10) {
                    dataInputStream = dataInputStream2;
                    e = e10;
                    e.printStackTrace();
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                            return null;
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
