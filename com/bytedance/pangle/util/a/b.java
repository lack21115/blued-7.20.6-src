package com.bytedance.pangle.util.a;

import com.bytedance.pangle.util.f;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f7893a = "";

    private static ByteBuffer a(ByteBuffer byteBuffer, int i) {
        if (i < 8) {
            throw new IllegalArgumentException("end < start: " + i + " < 8");
        }
        int capacity = byteBuffer.capacity();
        if (i > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    public static String[] a(File file) {
        String str;
        ByteBuffer b;
        boolean z;
        String str2 = "";
        try {
            b = b(file);
        } catch (Exception e) {
            str = "";
        }
        if (b.order() == ByteOrder.LITTLE_ENDIAN) {
            ByteBuffer a2 = a(b, b.capacity() - 24);
            int i = 0;
            while (a2.hasRemaining()) {
                i++;
                if (a2.remaining() >= 8) {
                    long j = a2.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
                    }
                    int i2 = (int) j;
                    int position = a2.position();
                    if (i2 > a2.remaining()) {
                        throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a2.remaining());
                    }
                    int i3 = a2.getInt();
                    if (i3 == -262969152) {
                        f7893a = "V3";
                    } else if (i3 == 1896449818) {
                        f7893a = "V2";
                    } else {
                        a2.position(position + i2);
                    }
                    z = true;
                    break;
                }
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            z = false;
            if (z) {
                str2 = f.a(b.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
            return new String[]{str2, f7893a, str};
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007a A[Catch: all -> 0x0226, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0226, blocks: (B:5:0x0014, B:15:0x003e, B:18:0x0060, B:24:0x007a, B:27:0x0095, B:32:0x00b8, B:34:0x00f1, B:36:0x00fe, B:43:0x012b, B:46:0x015e, B:49:0x0175, B:50:0x019e, B:51:0x019f, B:51:0x019f, B:52:0x01a2, B:53:0x01b0, B:54:0x01b1, B:54:0x01b1, B:55:0x01b4, B:56:0x01c1, B:57:0x01c2, B:57:0x01c2, B:58:0x01c5, B:59:0x01cb, B:60:0x01cc, B:60:0x01cc, B:61:0x01cf, B:62:0x01dd, B:63:0x01de, B:63:0x01de, B:64:0x01e1, B:65:0x01e7, B:66:0x01e8, B:66:0x01e8, B:67:0x01eb, B:68:0x0211, B:69:0x0212, B:69:0x0212, B:70:0x0215, B:71:0x021b, B:72:0x021c, B:72:0x021c, B:73:0x021f, B:74:0x0225, B:9:0x0024, B:12:0x0032), top: B:87:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0212 A[Catch: all -> 0x0226, all -> 0x0226, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0226, blocks: (B:5:0x0014, B:15:0x003e, B:18:0x0060, B:24:0x007a, B:27:0x0095, B:32:0x00b8, B:34:0x00f1, B:36:0x00fe, B:43:0x012b, B:46:0x015e, B:49:0x0175, B:50:0x019e, B:51:0x019f, B:51:0x019f, B:52:0x01a2, B:53:0x01b0, B:54:0x01b1, B:54:0x01b1, B:55:0x01b4, B:56:0x01c1, B:57:0x01c2, B:57:0x01c2, B:58:0x01c5, B:59:0x01cb, B:60:0x01cc, B:60:0x01cc, B:61:0x01cf, B:62:0x01dd, B:63:0x01de, B:63:0x01de, B:64:0x01e1, B:65:0x01e7, B:66:0x01e8, B:66:0x01e8, B:67:0x01eb, B:68:0x0211, B:69:0x0212, B:69:0x0212, B:70:0x0215, B:71:0x021b, B:72:0x021c, B:72:0x021c, B:73:0x021f, B:74:0x0225, B:9:0x0024, B:12:0x0032), top: B:87:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer b(java.io.File r6) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.a.b.b(java.io.File):java.nio.ByteBuffer");
    }
}
