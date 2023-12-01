package okhttp3.internal.ws;

import okio.Buffer;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/ws/WebSocketProtocol.class */
public final class WebSocketProtocol {
    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        } else if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        } else {
            return "Code " + i + " is reserved and may not be used.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i2 = unsafeCursor.start;
            int i3 = unsafeCursor.end;
            while (i2 < i3) {
                int i4 = i % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i = i4 + 1;
            }
        } while (unsafeCursor.next() != -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i) {
        String a2 = a(i);
        if (a2 != null) {
            throw new IllegalArgumentException(a2);
        }
    }
}
