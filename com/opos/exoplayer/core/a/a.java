package com.opos.exoplayer.core.a;

import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f25004a = {1, 2, 3, 6};
    private static final int[] b = {48000, 44100, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f25005c = {24000, 22050, 16000};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_ONE_CLICK_VALUE, LiveProtos.Event.LIVE_KEYBOARD_BARRAGE_CLICK_VALUE, LiveProtos.Event.LIVE_BLIND_BOX_TAB_SEND_CLICK_VALUE, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.opos.exoplayer.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/a$a.class */
    public static final class C0648a {

        /* renamed from: a  reason: collision with root package name */
        public final String f25006a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25007c;
        public final int d;
        public final int e;
        public final int f;

        private C0648a(String str, int i, int i2, int i3, int i4, int i5) {
            this.f25006a = str;
            this.b = i;
            this.d = i2;
            this.f25007c = i3;
            this.e = i4;
            this.f = i5;
        }
    }

    public static int a() {
        return 1536;
    }

    private static int a(int i, int i2) {
        int i3 = i2 / 2;
        if (i >= 0) {
            int[] iArr = b;
            if (i >= iArr.length || i2 < 0) {
                return -1;
            }
            int[] iArr2 = f;
            if (i3 >= iArr2.length) {
                return -1;
            }
            int i4 = iArr[i];
            if (i4 == 44100) {
                return (iArr2[i3] + (i2 % 2)) * 2;
            }
            int i5 = e[i3];
            return i4 == 32000 ? i5 * 6 : i5 * 4;
        }
        return -1;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = f25004a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return a((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    public static Format a(com.opos.exoplayer.core.i.m mVar, String str, String str2, DrmInitData drmInitData) {
        int i = b[(mVar.g() & 192) >> 6];
        int g = mVar.g();
        int i2 = d[(g & 56) >> 3];
        int i3 = i2;
        if ((g & 4) != 0) {
            i3 = i2 + 1;
        }
        return Format.a(str, "audio/ac3", null, -1, -1, i3, i, null, drmInitData, 0, str2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static C0648a a(com.opos.exoplayer.core.i.l lVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static int b(ByteBuffer byteBuffer) {
        if (byteBuffer.getInt(byteBuffer.position() + 4) != -1167101192) {
            return 0;
        }
        return 40 << (byteBuffer.get(byteBuffer.position() + 8) & 7);
    }

    public static int b(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && bArr[7] == -70) {
            return 40 << (bArr[8] & 7);
        }
        return 0;
    }

    public static Format b(com.opos.exoplayer.core.i.m mVar, String str, String str2, DrmInitData drmInitData) {
        mVar.d(2);
        int i = b[(mVar.g() & 192) >> 6];
        int g = mVar.g();
        int i2 = d[(g & 14) >> 1];
        int i3 = i2;
        if ((g & 1) != 0) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (((mVar.g() & 30) >> 1) > 0) {
            i4 = i3;
            if ((2 & mVar.g()) != 0) {
                i4 = i3 + 2;
            }
        }
        return Format.a(str, (mVar.b() <= 0 || (mVar.g() & 1) == 0) ? "audio/eac3" : com.anythink.expressad.exoplayer.k.o.B, null, -1, -1, i4, i, null, drmInitData, 0, str2);
    }
}
