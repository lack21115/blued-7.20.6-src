package com.ishumei.l111l11111Il.l111l11111lIl;

import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111lIl/l1111l111111Il.class */
public class l1111l111111Il {
    private static final int l111l11111I1l = 1896449818;
    private static final int l111l11111Il = -1091571699;
    public final long l1111l111111Il;
    public final long l111l11111lIl;
    private ByteBuffer l111l1111l1Il;
    private ByteBuffer l111l1111lI1l;
    private long l111l1111llIl;

    /* renamed from: com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il$l1111l111111Il  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111lIl/l1111l111111Il$l1111l111111Il.class */
    public static class C0284l1111l111111Il {
        public final X509Certificate[][] l1111l111111Il;
        private byte[] l111l11111lIl;

        public C0284l1111l111111Il() {
        }

        public C0284l1111l111111Il(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.l1111l111111Il = x509CertificateArr;
            this.l111l11111lIl = bArr;
        }

        public static HashMap<String, String> l1111l111111Il(boolean z) {
            String str;
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                String l111l11111Il = l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1bd8a96939b");
                Field[] l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l111l11111Il);
                if (z) {
                    try {
                        Object l1111l111111Il2 = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l111l11111Il, l111l1111lI1l.l111l11111Il("989a8bac9a8d969e93"));
                        if (l1111l111111Il2 != null) {
                            hashMap.put(l111l1111lI1l.l111l11111Il("8c9a8d969e93a0af"), l1111l111111Il2.toString());
                        }
                    } catch (Throwable th) {
                    }
                    str = "9d909e8d9bd392909b9a93d38c9a8d969e93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
                } else {
                    str = "9d909e8d9bd392909b9a93d39d8d9e919bd3929e918a999e9c8b8a8d9a8dd3999691989a8d8f8d96918bd39c8f8aa09e9d96d39c8f8aa09e9d96cd";
                }
                String l111l11111Il2 = l111l1111lI1l.l111l11111Il(str);
                int length = l1111l111111Il.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return hashMap;
                    }
                    Field field = l1111l111111Il[i2];
                    field.setAccessible(true);
                    String lowerCase = field.getName().toLowerCase();
                    if (l111l11111Il2.contains(lowerCase)) {
                        hashMap.put(lowerCase, field.get(null).toString());
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                return hashMap;
            }
        }
    }

    public l1111l111111Il() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1111l111111Il(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
        this.l111l1111l1Il = byteBuffer;
        this.l1111l111111Il = j;
        this.l111l11111lIl = j2;
        this.l111l1111llIl = j3;
        this.l111l1111lI1l = byteBuffer2;
    }

    public static C0284l1111l111111Il l1111l111111Il(RandomAccessFile randomAccessFile, l1111l111111Il l1111l111111il) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ByteBuffer l1111l111111Il = l111l11111lIl.l1111l111111Il(l1111l111111il.l111l1111l1Il);
        while (l1111l111111Il.hasRemaining()) {
            arrayList.add(l1111l111111Il(l111l11111lIl.l1111l111111Il(l1111l111111Il), hashMap, certificateFactory));
        }
        byte[] bArr = null;
        if (hashMap.containsKey(3)) {
            byte[] bArr2 = (byte[]) hashMap.get(3);
            long length = randomAccessFile.length();
            if (bArr2.length != 40) {
                throw new SecurityException("Verity digest size is wrong: " + bArr2.length);
            }
            ByteBuffer order = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() != length - (l1111l111111il.l111l11111lIl - l1111l111111il.l1111l111111Il)) {
                throw new SecurityException("APK content size did not verify");
            }
            bArr = Arrays.copyOfRange(bArr2, 0, 32);
        }
        return new C0284l1111l111111Il((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]), bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il l1111l111111Il(java.io.RandomAccessFile r11) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il.l1111l111111Il(java.io.RandomAccessFile):com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il");
    }

    private static void l1111l111111Il(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer l1111l111111Il = l111l11111lIl.l1111l111111Il(byteBuffer);
            if (l1111l111111Il.getInt() == l111l11111Il) {
                l1111l111111Il.getInt();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0286 A[LOOP:0: B:68:0x027f->B:70:0x0286, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.X509Certificate[] l1111l111111Il(java.nio.ByteBuffer r8, java.util.Map<java.lang.Integer, byte[]> r9, java.security.cert.CertificateFactory r10) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il.l1111l111111Il(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }
}
