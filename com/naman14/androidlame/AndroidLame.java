package com.naman14.androidlame;

import com.naman14.androidlame.LameBuilder;

/* loaded from: source-8303388-dex2jar.jar:com/naman14/androidlame/AndroidLame.class */
public class AndroidLame {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.naman14.androidlame.AndroidLame$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/naman14/androidlame/AndroidLame$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10586a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:46:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007a -> B:42:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007e -> B:56:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:50:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0086 -> B:12:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008a -> B:40:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008e -> B:54:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0092 -> B:48:0x006a). Please submit an issue!!! */
        static {
            int[] iArr = new int[LameBuilder.VbrMode.values().length];
            b = iArr;
            try {
                iArr[LameBuilder.VbrMode.VBR_OFF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[LameBuilder.VbrMode.VBR_RH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[LameBuilder.VbrMode.VBR_ABR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[LameBuilder.VbrMode.VBR_MTRH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[LameBuilder.VbrMode.VBR_DEFAUT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[LameBuilder.Mode.values().length];
            f10586a = iArr2;
            try {
                iArr2[LameBuilder.Mode.STEREO.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f10586a[LameBuilder.Mode.JSTEREO.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f10586a[LameBuilder.Mode.MONO.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f10586a[LameBuilder.Mode.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    static {
        System.loadLibrary("mp3lame");
    }

    public AndroidLame() {
        initializeDefault();
    }

    public AndroidLame(LameBuilder lameBuilder) {
        a(lameBuilder);
    }

    private static int a(LameBuilder.Mode mode) {
        int i = AnonymousClass1.f10586a[mode.ordinal()];
        int i2 = 1;
        if (i != 1) {
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return -1;
                    }
                }
            }
            return i2;
        }
        return 0;
    }

    private static int a(LameBuilder.VbrMode vbrMode) {
        int i = AnonymousClass1.b[vbrMode.ordinal()];
        if (i != 1) {
            int i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return i != 5 ? -1 : 6;
                    }
                }
            }
            return i2;
        }
        return 0;
    }

    private void a(LameBuilder lameBuilder) {
        initialize(lameBuilder.f10587a, lameBuilder.d, lameBuilder.b, lameBuilder.f10588c, lameBuilder.j, a(lameBuilder.k), a(lameBuilder.l), lameBuilder.e, lameBuilder.f, lameBuilder.g, lameBuilder.h, lameBuilder.i, lameBuilder.m, lameBuilder.n, lameBuilder.o, lameBuilder.q, lameBuilder.p);
    }

    private static native int encodeBufferInterleaved(short[] sArr, int i, byte[] bArr);

    private static native void initialize(int i, int i2, int i3, int i4, float f, int i5, int i6, int i7, int i8, int i9, int i10, int i11, String str, String str2, String str3, String str4, String str5);

    private static native void initializeDefault();

    private static native void lameClose();

    private static native int lameEncode(short[] sArr, short[] sArr2, int i, byte[] bArr);

    private static native int lameFlush(byte[] bArr);

    public int a(byte[] bArr) {
        return lameFlush(bArr);
    }

    public int a(short[] sArr, short[] sArr2, int i, byte[] bArr) {
        return lameEncode(sArr, sArr2, i, bArr);
    }

    public void a() {
        lameClose();
    }
}
