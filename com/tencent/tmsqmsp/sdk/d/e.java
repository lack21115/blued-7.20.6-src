package com.tencent.tmsqmsp.sdk.d;

import android.util.Base64;
import com.tencent.tmsqmsp.sdk.f.h;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/d/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f26058a = {8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 83, -48, 63, 32, -108, 73, 5, 42, 66, -52, 43, 96, -67, 83, 13, 51, 34, -18, 52, 73, -65, 118, 10, 54, 92, -12, 116, 105, -71, 105, 13, 21, 124, -10, 3, 114, -87, 97, 43, 15, 118, -54, 35, 63, -93, 101, 0, 48, 66, -55, 17, 33, -22, 108, 11, 99, 81, -54, 43, 36, -21, 99, 120, 104, 66, -46, 6, 88, -126, 85, 27, 61, 33, -86, 52, 105, -76, 99, 8, 14, 86, -19, 18, 37, -8, 18, 126, 12, 83, -88, 22, 113, -80, 98, 40, 63, 109, -16, 48, 118, -68, 72, 45, 24, 86, -25, 35, 88, -28, 106, 123, 33, 114, -45, 117, 81, -94, 111, 3, 60, 120, -86, 110, 123, -28, 105, 101, 52, 94, -19, 31, 97, -67, 104, 3, 41, 117, -84, 51, 82, -65, 86, 6, 57, 60, -86, 124, 115, -89, 23, 30, 11, 60, -39, 52, 67, -125, 66, 36, 41, 60, -7, 20, 69, -80, 111, 120, 41, 89, -10, 47, 103, -102, 100, 15, 10, 86, -33};
    private static final byte[] b = {8, 84, -26, 87, 39, 47, Byte.MAX_VALUE, -49, 22, 81};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f26059c = {23, 67, -110};

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/d/e$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f26060a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f26061c;
        public byte[] d;

        private b() {
        }
    }

    public static b a(DataInputStream dataInputStream) {
        b bVar = new b();
        try {
            bVar.f26060a = dataInputStream.readInt();
            bVar.b = dataInputStream.readInt();
            int readInt = dataInputStream.readInt();
            bVar.f26061c = readInt;
            if (readInt <= 0 || readInt > 256) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            bVar.d = bArr;
            dataInputStream.read(bArr);
            return bVar;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static PublicKey a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = h.a(f26058a);
        }
        try {
            return KeyFactory.getInstance(h.a(f26059c)).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a(DataInputStream dataInputStream, int i, byte[] bArr, PublicKey publicKey) {
        try {
            Signature signature = Signature.getInstance(h.a(b));
            signature.initVerify(publicKey);
            byte[] bArr2 = new byte[8192];
            while (true) {
                int read = i < 8192 ? dataInputStream.read(bArr2, 0, i) : dataInputStream.read(bArr2);
                if (read == 0 || read == -1) {
                    break;
                }
                signature.update(bArr2, 0, read);
                i -= read;
            }
            return signature.verify(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2, PublicKey publicKey) {
        try {
            Signature signature = Signature.getInstance(h.a(b));
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] a(File file, String str) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        int available;
        int i;
        DataInputStream dataInputStream3 = null;
        try {
            if (file.exists()) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                } catch (IOException e) {
                    e = e;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (dataInputStream3 != null) {
                        try {
                            dataInputStream3.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    available = dataInputStream.available();
                } catch (IOException e3) {
                    e = e3;
                    dataInputStream3 = dataInputStream;
                    e.printStackTrace();
                    if (dataInputStream != null) {
                        dataInputStream2 = dataInputStream;
                        try {
                            dataInputStream2.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
                if (available < 8 || available > 5242880) {
                    try {
                        dataInputStream.close();
                        return null;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return null;
                    }
                } else if (dataInputStream.readInt() != 1364419939) {
                    try {
                        dataInputStream.close();
                        return null;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return null;
                    }
                } else {
                    int readInt = dataInputStream.readInt();
                    if (readInt <= 0 || readInt > 256 || readInt >= (i = available - 8)) {
                        try {
                            dataInputStream.close();
                            return null;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            return null;
                        }
                    }
                    PublicKey a2 = a(str);
                    if (a2 == null) {
                        try {
                            dataInputStream.close();
                            return null;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            return null;
                        }
                    }
                    byte[] bArr = new byte[readInt];
                    byte[] bArr2 = new byte[i - readInt];
                    dataInputStream.read(bArr);
                    dataInputStream.read(bArr2);
                    dataInputStream3 = dataInputStream;
                    dataInputStream2 = dataInputStream;
                    if (a(bArr2, bArr, a2)) {
                        try {
                            dataInputStream.close();
                            return bArr2;
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            return bArr2;
                        }
                    }
                    dataInputStream2.close();
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.io.File r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.sdk.d.e.b(java.io.File, java.lang.String):boolean");
    }
}
