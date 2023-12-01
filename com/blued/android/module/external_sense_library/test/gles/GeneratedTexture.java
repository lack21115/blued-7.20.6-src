package com.blued.android.module.external_sense_library.test.gles;

import android.view.View;
import java.nio.ByteBuffer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/GeneratedTexture.class */
public class GeneratedTexture {
    private static final int[] a = {-16776961, -16711681, -16711936, -65281, -1, 1073742079, 1073807104, -16711681, -65281, 65280, -2147483393, View.MEASURED_STATE_MASK, -256, -65281, -256, -65536};
    private static final ByteBuffer b = a();
    private static final ByteBuffer c = b();

    /* renamed from: com.blued.android.module.external_sense_library.test.gles.GeneratedTexture$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/GeneratedTexture$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Image.values().length];
            a = iArr;
            try {
                iArr[Image.COARSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Image.FINE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/GeneratedTexture$Image.class */
    public enum Image {
        COARSE,
        FINE
    }

    private static ByteBuffer a() {
        byte[] bArr = new byte[16384];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16384) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
                allocateDirect.put(bArr);
                allocateDirect.position(0);
                return allocateDirect;
            }
            int i3 = i2 / 4;
            int i4 = a[(((i3 / 64) / 16) * 4) + ((i3 % 64) / 16)];
            if (i2 == 0 || i2 == 16380) {
                i4 = -1;
            }
            int i5 = (i4 >> 24) & 255;
            float f = i5 / 255.0f;
            bArr[i2] = (byte) ((i4 & 255) * f);
            bArr[i2 + 1] = (byte) (((i4 >> 8) & 255) * f);
            bArr[i2 + 2] = (byte) (((i4 >> 16) & 255) * f);
            bArr[i2 + 3] = (byte) i5;
            i = i2 + 4;
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        while (i2 < i4) {
            int i8 = i;
            while (true) {
                int i9 = i8;
                if (i9 < i3) {
                    int i10 = (i9 * 4) + (i2 * 64 * 4);
                    int i11 = ((i2 & i7) ^ (i9 & i7)) == 0 ? i5 : i6;
                    int i12 = (i11 >> 24) & 255;
                    float f = i12 / 255.0f;
                    bArr[i10] = (byte) ((i11 & 255) * f);
                    bArr[i10 + 1] = (byte) (((i11 >> 8) & 255) * f);
                    bArr[i10 + 2] = (byte) (((i11 >> 16) & 255) * f);
                    bArr[i10 + 3] = (byte) i12;
                    i8 = i9 + 1;
                }
            }
            i2++;
        }
    }

    private static ByteBuffer b() {
        byte[] bArr = new byte[16384];
        a(bArr, 0, 0, 32, 32, -16776961, -65536, 1);
        a(bArr, 32, 32, 64, 64, -16776961, -16711936, 2);
        a(bArr, 0, 32, 32, 64, -65536, -16711936, 4);
        a(bArr, 32, 0, 64, 32, -1, View.MEASURED_STATE_MASK, 8);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        return allocateDirect;
    }
}
