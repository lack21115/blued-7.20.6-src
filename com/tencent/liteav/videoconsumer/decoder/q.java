package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private boolean f36799a = false;

    private static void a(p pVar) throws IOException {
        int c2 = pVar.c();
        pVar.a(4);
        pVar.a(4);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > c2) {
                pVar.a(5);
                pVar.a(5);
                pVar.a(5);
                pVar.a(5);
                return;
            }
            pVar.d();
            pVar.d();
            pVar.a(1);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length * 3) / 2];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            if (i < bArr.length - 2 && bArr[i] == 0) {
                int i3 = i + 1;
                if (bArr[i3] == 0) {
                    int i4 = i + 2;
                    if (bArr[i4] <= 3) {
                        int i5 = i2 + 1;
                        bArr2[i2] = bArr[i];
                        int i6 = i5 + 1;
                        bArr2[i5] = bArr[i3];
                        i2 = i6 + 1;
                        bArr2[i6] = 3;
                        i = i4;
                    }
                }
            }
            bArr2[i2] = bArr[i];
            i++;
            i2++;
        }
        byte[] bArr3 = bArr;
        if (i2 != bArr.length) {
            bArr3 = new byte[i2];
            System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i2);
        }
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] a(InputStream inputStream) throws IOException {
        boolean z;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        p pVar = new p(inputStream, byteArrayOutputStream);
        pVar.b(8);
        int a2 = (int) pVar.a();
        pVar.b(8);
        pVar.a();
        pVar.d();
        if (a2 == 100 || a2 == 110 || a2 == 122 || a2 == 144) {
            if (pVar.c() == 3) {
                pVar.b(1);
            }
            pVar.d();
            pVar.d();
            pVar.b(1);
            if (pVar.a(true)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 8) {
                        break;
                    }
                    if (pVar.a(true)) {
                        if (i2 < 6) {
                            pVar.c(16);
                        } else {
                            pVar.c(64);
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        pVar.d();
        int c2 = pVar.c();
        if (c2 == 0) {
            pVar.d();
        } else if (c2 == 1) {
            pVar.b(1);
            pVar.d();
            pVar.d();
            int c3 = pVar.c();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= c3) {
                    break;
                }
                StringBuilder sb = new StringBuilder("SPS: offsetForRefFrame [");
                sb.append(i4);
                sb.append("]");
                pVar.d();
                i3 = i4 + 1;
            }
        }
        pVar.c();
        pVar.b(1);
        pVar.d();
        pVar.d();
        if (!pVar.a(true)) {
            pVar.b(1);
        }
        pVar.b(1);
        if (pVar.a(true)) {
            pVar.d();
            pVar.d();
            pVar.d();
            pVar.d();
        }
        if (pVar.a(false)) {
            pVar.b(true);
            if (pVar.a(true) && ((int) pVar.a()) == 255) {
                pVar.b(16);
                pVar.b(16);
            }
            if (pVar.a(true)) {
                pVar.b(1);
            }
            if (pVar.a(true)) {
                pVar.b(3);
                pVar.b(1);
                if (pVar.a(true)) {
                    pVar.b(8);
                    pVar.b(8);
                    pVar.b(8);
                }
            }
            if (pVar.a(true)) {
                pVar.d();
                pVar.d();
            }
            if (pVar.a(true)) {
                pVar.b(32);
                pVar.b(32);
                pVar.b(1);
            }
            boolean a3 = pVar.a(true);
            if (a3) {
                a(pVar);
            }
            boolean a4 = pVar.a(true);
            if (a4) {
                a(pVar);
            }
            if (a3 || a4) {
                pVar.b(1);
            }
            pVar.b(1);
            if (pVar.a(false)) {
                pVar.b(true);
                pVar.a(true);
                pVar.d();
                pVar.d();
                pVar.d();
                pVar.d();
                pVar.d();
                z = false;
                if (!this.f36799a) {
                    LiteavLog.w("H264SPSModifier", "decode: do not add max_dec_frame_buffering when it is ".concat(String.valueOf(pVar.b())));
                    this.f36799a = true;
                    z = false;
                }
            } else {
                pVar.b(true);
                pVar.b(true);
                pVar.d(0);
                pVar.d(0);
                pVar.d(10);
                pVar.d(10);
                pVar.d(0);
                pVar.d(1);
                if (!this.f36799a) {
                    LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when it is no exist");
                    this.f36799a = true;
                }
                z = true;
            }
            if (!z) {
                return null;
            }
        } else {
            pVar.b(true);
            pVar.b(false);
            pVar.b(false);
            pVar.b(false);
            pVar.b(false);
            pVar.b(false);
            pVar.b(false);
            pVar.b(false);
            pVar.b(false);
            pVar.b(true);
            pVar.b(true);
            pVar.d(0);
            pVar.d(0);
            pVar.d(10);
            pVar.d(10);
            pVar.d(0);
            pVar.d(1);
            if (!this.f36799a) {
                LiteavLog.w("H264SPSModifier", "decode: add max_dec_frame_buffering 1 when vui is no exist");
                this.f36799a = true;
            }
        }
        pVar.e();
        return byteArrayOutputStream.toByteArray();
    }
}
