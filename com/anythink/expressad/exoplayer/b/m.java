package com.anythink.expressad.exoplayer.b;

import android.media.AudioSystem;
import android.opengl.GLES30;
import android.text.format.DateUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7209a = 2147385345;
    private static final int b = 536864768;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7210c = -25230976;
    private static final int d = -14745368;
    private static final byte e = Byte.MAX_VALUE;
    private static final byte f = 31;
    private static final byte g = -2;
    private static final byte h = -1;
    private static final int[] i = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] j = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] k = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, AudioSystem.DEVICE_OUT_ALL_A2DP, 1024, 1152, 1280, 1536, WBConstants.SDK_NEW_PAY_VERSION, 2048, 2304, DateUtils.FORMAT_NO_NOON_MIDNIGHT, 2688, 2816, 2823, 2944, 3072, 3840, 4096, GLES30.GL_COLOR, 7680};

    private m() {
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        int position = byteBuffer.position();
        byte b4 = byteBuffer.get(position);
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (byteBuffer.get(position + 4) & 7) << 4;
                b3 = byteBuffer.get(position + 7);
            } else if (b4 != 31) {
                i2 = (byteBuffer.get(position + 4) & 1) << 6;
                b2 = byteBuffer.get(position + 5);
            } else {
                i2 = (byteBuffer.get(position + 5) & 7) << 4;
                b3 = byteBuffer.get(position + 6);
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (byteBuffer.get(position + 5) & 1) << 6;
        b2 = byteBuffer.get(position + 4);
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    private static int a(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i2 = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    private static com.anythink.expressad.exoplayer.m a(byte[] bArr, String str, String str2, com.anythink.expressad.exoplayer.d.e eVar) {
        com.anythink.expressad.exoplayer.k.r rVar;
        int i2 = 0;
        if (bArr[0] == Byte.MAX_VALUE) {
            rVar = new com.anythink.expressad.exoplayer.k.r(bArr);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            if (copyOf[0] == -2 || copyOf[0] == -1) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= copyOf.length - 1) {
                        break;
                    }
                    byte b2 = copyOf[i4];
                    int i5 = i4 + 1;
                    copyOf[i4] = copyOf[i5];
                    copyOf[i5] = b2;
                    i3 = i4 + 2;
                }
            }
            rVar = new com.anythink.expressad.exoplayer.k.r(copyOf);
            if (copyOf[0] == 31) {
                com.anythink.expressad.exoplayer.k.r rVar2 = new com.anythink.expressad.exoplayer.k.r(copyOf);
                while (rVar2.a() >= 16) {
                    rVar2.b(2);
                    rVar.d(rVar2.c(14));
                }
            }
            rVar.a(copyOf, copyOf.length);
        }
        rVar.b(60);
        int i6 = i[rVar.c(6)];
        int i7 = j[rVar.c(4)];
        int c2 = rVar.c(5);
        int[] iArr = k;
        int i8 = c2 >= iArr.length ? -1 : (iArr[c2] * 1000) / 2;
        rVar.b(10);
        if (rVar.c(2) > 0) {
            i2 = 1;
        }
        return com.anythink.expressad.exoplayer.m.a(str, com.anythink.expressad.exoplayer.k.o.D, null, i8, i6 + i2, i7, null, eVar, str2);
    }

    private static boolean a(int i2) {
        return i2 == f7209a || i2 == f7210c || i2 == b || i2 == d;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(byte[] r4) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.m.b(byte[]):int");
    }

    private static com.anythink.expressad.exoplayer.k.r c(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new com.anythink.expressad.exoplayer.k.r(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (copyOf[0] == -2 || copyOf[0] == -1) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= copyOf.length - 1) {
                    break;
                }
                byte b2 = copyOf[i3];
                int i4 = i3 + 1;
                copyOf[i3] = copyOf[i4];
                copyOf[i4] = b2;
                i2 = i3 + 2;
            }
        }
        com.anythink.expressad.exoplayer.k.r rVar = new com.anythink.expressad.exoplayer.k.r(copyOf);
        if (copyOf[0] == 31) {
            com.anythink.expressad.exoplayer.k.r rVar2 = new com.anythink.expressad.exoplayer.k.r(copyOf);
            while (rVar2.a() >= 16) {
                rVar2.b(2);
                rVar.d(rVar2.c(14));
            }
        }
        rVar.a(copyOf, copyOf.length);
        return rVar;
    }

    private static boolean d(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
