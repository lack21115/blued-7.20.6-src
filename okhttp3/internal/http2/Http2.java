package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2.class */
public final class Http2 {

    /* renamed from: a  reason: collision with root package name */
    static final ByteString f43913a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] b = new String[64];

    /* renamed from: c  reason: collision with root package name */
    static final String[] f43914c = new String[256];

    static {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            String[] strArr = f43914c;
            if (i5 >= strArr.length) {
                break;
            }
            strArr[i5] = Util.a("%8s", Integer.toBinaryString(i5)).replace(' ', '0');
            i4 = i5 + 1;
        }
        String[] strArr2 = b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= 1) {
                break;
            }
            b[iArr[i7] | 8] = b[i3] + "|PADDED";
            i6 = i7 + 1;
        }
        String[] strArr3 = b;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int i8 = 0;
        while (true) {
            int i9 = i8;
            i = 0;
            if (i9 >= 3) {
                break;
            }
            int i10 = new int[]{4, 32, 36}[i9];
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 < 1) {
                    int i13 = iArr[i12] | i10;
                    b[i13] = b[i2] + '|' + b[i10];
                    b[i13 | 8] = b[i2] + '|' + b[i10] + "|PADDED";
                    i11 = i12 + 1;
                }
            }
            i8 = i9 + 1;
        }
        while (true) {
            String[] strArr4 = b;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f43914c[i];
            }
            i++;
        }
    }

    private Http2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.a(str, objArr));
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f43914c[b3];
            } else if (b2 != 7 && b2 != 8) {
                String[] strArr = b;
                String str = b3 < strArr.length ? strArr[b3] : f43914c[b3];
                return (b2 != 5 || (b3 & 4) == 0) ? (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f43914c[b3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = d;
        return Util.a("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), b2 < strArr.length ? strArr[b2] : Util.a("0x%02x", Byte.valueOf(b2)), a(b2, b3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(Util.a(str, objArr));
    }
}
