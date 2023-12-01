package android.net.http;

import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/CharArrayBuffers.class */
class CharArrayBuffers {
    static final char uppercaseAddon = ' ';

    CharArrayBuffers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean containsIgnoreCaseTrimmed(CharArrayBuffer charArrayBuffer, int i, String str) {
        int length = charArrayBuffer.length();
        char[] buffer = charArrayBuffer.buffer();
        while (i < length && HTTP.isWhitespace(buffer[i])) {
            i++;
        }
        int length2 = str.length();
        boolean z = length >= i + length2;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!z || i3 >= length2) {
                break;
            }
            char c2 = buffer[i + i3];
            char charAt = str.charAt(i3);
            if (c2 != charAt) {
                z = toLower(c2) == toLower(charAt);
            }
            i2 = i3 + 1;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setLowercaseIndexOf(CharArrayBuffer charArrayBuffer, int i) {
        int length = charArrayBuffer.length();
        char[] buffer = charArrayBuffer.buffer();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return -1;
            }
            char c2 = buffer[i3];
            if (c2 == i) {
                return i3;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                buffer[i3] = (char) (c2 + ' ');
            }
            i2 = i3 + 1;
        }
    }

    private static char toLower(char c2) {
        char c3 = c2;
        if (c2 >= 'A') {
            c3 = c2;
            if (c2 <= 'Z') {
                c3 = (char) (c2 + ' ');
            }
        }
        return c3;
    }
}
