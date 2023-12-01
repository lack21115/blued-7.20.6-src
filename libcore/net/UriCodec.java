package libcore.net;

import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/UriCodec.class */
public abstract class UriCodec {
    private void appendEncoded(StringBuilder sb, String str, Charset charset, boolean z) {
        int i;
        int i2;
        if (str == null) {
            throw new NullPointerException("s == null");
        }
        int i3 = -1;
        int i4 = 0;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && !((charAt >= '0' && charAt <= '9') || isRetained(charAt) || (charAt == '%' && z)))) {
                i = i3;
                i2 = i4;
                if (i3 == -1) {
                    i = i4;
                    i2 = i4;
                }
            } else {
                i = i3;
                if (i3 != -1) {
                    appendHex(sb, str.substring(i3, i4), charset);
                    i = -1;
                }
                if (charAt == '%' && z) {
                    sb.append((CharSequence) str, i4, Math.min(i4 + 3, str.length()));
                    i2 = i4 + 2;
                } else if (charAt == ' ') {
                    sb.append('+');
                    i2 = i4;
                } else {
                    sb.append(charAt);
                    i2 = i4;
                }
            }
            i4 = i2 + 1;
            i3 = i;
        }
        if (i3 != -1) {
            appendHex(sb, str.substring(i3, str.length()), charset);
        }
    }

    private static void appendHex(StringBuilder sb, byte b) {
        sb.append('%');
        sb.append(Byte.toHexString(b, true));
    }

    private static void appendHex(StringBuilder sb, String str, Charset charset) {
        byte[] bytes = str.getBytes(charset);
        int length = bytes.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            appendHex(sb, bytes[i2]);
            i = i2 + 1;
        }
    }

    public static String decode(String str) {
        return decode(str, false, StandardCharsets.UTF_8, true);
    }

    public static String decode(String str, boolean z, Charset charset, boolean z2) {
        int i;
        int hexToInt;
        int hexToInt2;
        if (str.indexOf(37) == -1 && (!z || str.indexOf(43) == -1)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= str.length()) {
                return sb.toString();
            }
            char charAt = str.charAt(i3);
            if (charAt == '%') {
                do {
                    if (i3 + 2 < str.length() && (hexToInt = hexToInt(str.charAt(i3 + 1))) != -1 && (hexToInt2 = hexToInt(str.charAt(i3 + 2))) != -1) {
                        byteArrayOutputStream.write((byte) ((hexToInt << 4) + hexToInt2));
                    } else if (z2) {
                        throw new IllegalArgumentException("Invalid % sequence at " + i3 + ": " + str);
                    } else {
                        byte[] bytes = "�".getBytes(charset);
                        byteArrayOutputStream.write(bytes, 0, bytes.length);
                    }
                    i = i3 + 3;
                    if (i >= str.length()) {
                        break;
                    }
                    i3 = i;
                } while (str.charAt(i) == '%');
                sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
                byteArrayOutputStream.reset();
                i2 = i;
            } else {
                char c = charAt;
                if (z) {
                    c = charAt;
                    if (charAt == '+') {
                        c = ' ';
                    }
                }
                sb.append(c);
                i2 = i3 + 1;
            }
        }
    }

    private static int hexToInt(char c) {
        if ('0' > c || c > '9') {
            if ('a' > c || c > 'f') {
                if ('A' > c || c > 'F') {
                    return -1;
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }

    public static void validateSimple(String str, String str2) throws URISyntaxException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            char charAt = str.charAt(i2);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt < '0' || charAt > '9') && str2.indexOf(charAt) <= -1))) {
                throw new URISyntaxException(str, "Illegal character", i2);
            }
            i = i2 + 1;
        }
    }

    public final void appendEncoded(StringBuilder sb, String str) {
        appendEncoded(sb, str, StandardCharsets.UTF_8, false);
    }

    public final void appendPartiallyEncoded(StringBuilder sb, String str) {
        appendEncoded(sb, str, StandardCharsets.UTF_8, true);
    }

    public final String encode(String str, Charset charset) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        appendEncoded(sb, str, charset, false);
        return sb.toString();
    }

    protected abstract boolean isRetained(char c);

    public final String validate(String str, int i, int i2, String str2) throws URISyntaxException {
        int i3;
        int i4 = i;
        while (true) {
            i3 = i4;
            if (i3 >= i2) {
                return str.substring(i, i2);
            }
            char charAt = str.charAt(i3);
            if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || ((charAt >= '0' && charAt <= '9') || isRetained(charAt)))) {
                i4 = i3 + 1;
            } else if (charAt != '%') {
                throw new URISyntaxException(str, "Illegal character in " + str2, i3);
            } else {
                if (i3 + 2 >= i2) {
                    throw new URISyntaxException(str, "Incomplete % sequence in " + str2, i3);
                }
                int hexToInt = hexToInt(str.charAt(i3 + 1));
                int hexToInt2 = hexToInt(str.charAt(i3 + 2));
                if (hexToInt == -1 || hexToInt2 == -1) {
                    break;
                }
                i4 = i3 + 3;
            }
        }
        throw new URISyntaxException(str, "Invalid % sequence: " + str.substring(i3, i3 + 3) + " in " + str2, i3);
    }
}
