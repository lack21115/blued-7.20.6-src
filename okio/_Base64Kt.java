package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/_Base64Kt.class */
public final class _Base64Kt {
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    /* JADX WARN: Removed duplicated region for block: B:180:0x01a4 A[LOOP:1: B:124:0x0069->B:180:0x01a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01ba A[EDGE_INSN: B:206:0x01ba->B:182:0x01ba ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte[] decodeBase64ToArray(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio._Base64Kt.decodeBase64ToArray(java.lang.String):byte[]");
    }

    public static final String encodeBase64(byte[] bArr, byte[] map) {
        Intrinsics.e(bArr, "<this>");
        Intrinsics.e(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b = bArr[i];
            int i4 = i3 + 1;
            byte b2 = bArr[i3];
            byte b3 = bArr[i4];
            int i5 = i2 + 1;
            bArr2[i2] = map[(b & 255) >> 2];
            int i6 = i5 + 1;
            bArr2[i5] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i7 = i6 + 1;
            bArr2[i6] = map[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            i2 = i7 + 1;
            bArr2[i7] = map[b3 & 63];
            i = i4 + 1;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            int i8 = i2 + 1;
            bArr2[i2] = map[(b4 & 255) >> 2];
            int i9 = i8 + 1;
            bArr2[i8] = map[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr2[i9] = b5;
            bArr2[i9 + 1] = b5;
        } else if (length2 == 2) {
            byte b6 = bArr[i];
            byte b7 = bArr[i + 1];
            int i10 = i2 + 1;
            bArr2[i2] = map[(b6 & 255) >> 2];
            int i11 = i10 + 1;
            bArr2[i10] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr2[i11] = map[(b7 & 15) << 2];
            bArr2[i11 + 1] = (byte) 61;
        }
        return _JvmPlatformKt.toUtf8String(bArr2);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
