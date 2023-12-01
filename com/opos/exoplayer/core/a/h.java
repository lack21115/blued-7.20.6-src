package com.opos.exoplayer.core.a;

import android.bluetooth.BluetoothClass;
import android.media.AudioSystem;
import android.opengl.GLES11;
import android.opengl.GLES30;
import android.text.format.DateUtils;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.sina.weibo.sdk.constant.WBConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f11347a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f11348c = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, AudioSystem.DEVICE_OUT_ALL_A2DP, 1024, 1152, 1280, BluetoothClass.Device.Major.IMAGING, WBConstants.SDK_NEW_PAY_VERSION, 2048, 2304, DateUtils.FORMAT_NO_NOON_MIDNIGHT, 2688, GLES11.GL_CURRENT_COLOR, 2823, 2944, 3072, 3840, 4096, GLES30.GL_COLOR, 7680};

    public static int a(ByteBuffer byteBuffer) {
        byte b2;
        int i;
        int i2;
        int i3;
        byte b3;
        int i4;
        int position = byteBuffer.position();
        byte b4 = byteBuffer.get(position);
        if (b4 != -2) {
            if (b4 == -1) {
                b3 = byteBuffer.get(position + 4);
                i4 = position + 7;
            } else if (b4 != 31) {
                b2 = byteBuffer.get(position + 4);
                i = position + 5;
            } else {
                b3 = byteBuffer.get(position + 5);
                i4 = position + 6;
            }
            i2 = (byteBuffer.get(i4) & 60) >> 2;
            i3 = (b3 & 7) << 4;
            return ((i2 | i3) + 1) * 32;
        }
        b2 = byteBuffer.get(position + 5);
        i = position + 4;
        i2 = (byteBuffer.get(i) & 252) >> 2;
        i3 = (b2 & 1) << 6;
        return ((i2 | i3) + 1) * 32;
    }

    public static int a(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i2 = b2 & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static Format a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        com.opos.exoplayer.core.i.l c2 = c(bArr);
        c2.b(60);
        int i = f11347a[c2.c(6)];
        int i2 = b[c2.c(4)];
        int c3 = c2.c(5);
        int[] iArr = f11348c;
        int i3 = c3 >= iArr.length ? -1 : (iArr[c3] * 1000) / 2;
        c2.b(10);
        return Format.a(str, com.anythink.expressad.exoplayer.k.o.D, null, i3, -1, i + (c2.c(2) > 0 ? 1 : 0), i2, null, drmInitData, 0, str2);
    }

    public static boolean a(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(byte[] r4) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.h.b(byte[]):int");
    }

    private static com.opos.exoplayer.core.i.l c(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new com.opos.exoplayer.core.i.l(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (d(copyOf)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= copyOf.length - 1) {
                    break;
                }
                byte b2 = copyOf[i2];
                int i3 = i2 + 1;
                copyOf[i2] = copyOf[i3];
                copyOf[i3] = b2;
                i = i2 + 2;
            }
        }
        com.opos.exoplayer.core.i.l lVar = new com.opos.exoplayer.core.i.l(copyOf);
        if (copyOf[0] == 31) {
            com.opos.exoplayer.core.i.l lVar2 = new com.opos.exoplayer.core.i.l(copyOf);
            while (lVar2.a() >= 16) {
                lVar2.b(2);
                lVar.a(lVar2.c(14), 14);
            }
        }
        lVar.a(copyOf);
        return lVar;
    }

    private static boolean d(byte[] bArr) {
        boolean z = false;
        if (bArr[0] == -2 || bArr[0] == -1) {
            z = true;
        }
        return z;
    }
}
