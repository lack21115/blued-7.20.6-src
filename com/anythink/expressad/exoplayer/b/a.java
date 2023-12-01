package com.anythink.expressad.exoplayer.b;

import com.blued.das.live.LiveProtos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4329a = 16;
    public static final int b = 10;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4330c = 256;
    private static final int d = 1536;
    private static final int[] e = {1, 2, 3, 6};
    private static final int[] f = {48000, 44100, 32000};
    private static final int[] g = {24000, 22050, 16000};
    private static final int[] h = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] i = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] j = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, LiveProtos.Event.LIVE_GIFT_WALL_PAGE_HISTORY_ONE_CLICK_VALUE, LiveProtos.Event.LIVE_KEYBOARD_BARRAGE_CLICK_VALUE, LiveProtos.Event.LIVE_BLIND_BOX_TAB_SEND_CLICK_VALUE, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.anythink.expressad.exoplayer.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/a$a.class */
    public static final class C0048a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4331a = -1;
        public static final int b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4332c = 1;
        public static final int d = 2;
        public final String e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.anythink.expressad.exoplayer.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/a$a$a.class */
        public @interface InterfaceC0049a {
        }

        private C0048a(String str, int i, int i2, int i3, int i4, int i5) {
            this.e = str;
            this.f = i;
            this.h = i2;
            this.g = i3;
            this.i = i4;
            this.j = i5;
        }

        /* synthetic */ C0048a(String str, int i, int i2, int i3, int i4, int i5, byte b2) {
            this(str, i, i2, i3, i4, i5);
        }
    }

    private a() {
    }

    public static int a() {
        return 1536;
    }

    private static int a(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 >= 0) {
            int[] iArr = f;
            if (i2 >= iArr.length || i3 < 0) {
                return -1;
            }
            int[] iArr2 = j;
            if (i4 >= iArr2.length) {
                return -1;
            }
            int i5 = iArr[i2];
            if (i5 == 44100) {
                return (iArr2[i4] + (i3 % 2)) * 2;
            }
            int i6 = i[i4];
            return i5 == 32000 ? i6 * 6 : i6 * 4;
        }
        return -1;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2 = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i2 = e[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i2 * 256;
    }

    public static int a(ByteBuffer byteBuffer, int i2) {
        boolean z = (byteBuffer.get((byteBuffer.position() + i2) + 7) & 255) == 187;
        return 40 << ((byteBuffer.get((byteBuffer.position() + i2) + (z ? 9 : 8)) >> 4) & 7);
    }

    private static int a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return a((bArr[4] & 192) >> 6, bArr[4] & 63);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static C0048a a(com.anythink.expressad.exoplayer.k.r rVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static com.anythink.expressad.exoplayer.m a(com.anythink.expressad.exoplayer.k.s sVar, String str, String str2, com.anythink.expressad.exoplayer.d.e eVar) {
        int i2 = f[(sVar.d() & 192) >> 6];
        int d2 = sVar.d();
        int i3 = h[(d2 & 56) >> 3];
        int i4 = i3;
        if ((d2 & 4) != 0) {
            i4 = i3 + 1;
        }
        return com.anythink.expressad.exoplayer.m.a(str, "audio/ac3", null, -1, i4, i2, null, eVar, str2);
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = position;
        while (true) {
            int i3 = i2;
            if (i3 > limit - 10) {
                return -1;
            }
            if ((byteBuffer.getInt(i3 + 4) & (-16777217)) == -1167101192) {
                return i3 - position;
            }
            i2 = i3 + 1;
        }
    }

    private static int b(byte[] bArr) {
        byte b2 = 0;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            if ((bArr[7] & 255) == 187) {
                b2 = 1;
            }
            return 40 << ((bArr[(b2 != 0 ? (byte) 9 : (byte) 8) == 1 ? 1 : 0] >> 4) & 7);
        }
        return 0;
    }

    public static com.anythink.expressad.exoplayer.m b(com.anythink.expressad.exoplayer.k.s sVar, String str, String str2, com.anythink.expressad.exoplayer.d.e eVar) {
        sVar.d(2);
        int i2 = f[(sVar.d() & 192) >> 6];
        int d2 = sVar.d();
        int i3 = h[(d2 & 14) >> 1];
        int i4 = i3;
        if ((d2 & 1) != 0) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (((sVar.d() & 30) >> 1) > 0) {
            i5 = i4;
            if ((2 & sVar.d()) != 0) {
                i5 = i4 + 2;
            }
        }
        return com.anythink.expressad.exoplayer.m.a(str, (sVar.a() <= 0 || (sVar.d() & 1) == 0) ? "audio/eac3" : com.anythink.expressad.exoplayer.k.o.B, null, -1, i5, i2, null, eVar, str2);
    }
}
