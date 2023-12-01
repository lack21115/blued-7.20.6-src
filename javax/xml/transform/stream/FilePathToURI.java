package javax.xml.transform.stream;

import java.io.File;
import java.io.UnsupportedEncodingException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/stream/FilePathToURI.class */
public class FilePathToURI {
    private static boolean[] gNeedEscaping = new boolean[128];
    private static char[] gAfterEscaping1 = new char[128];
    private static char[] gAfterEscaping2 = new char[128];
    private static char[] gHexChs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 31) {
                break;
            }
            gNeedEscaping[i2] = true;
            gAfterEscaping1[i2] = gHexChs[i2 >> 4];
            gAfterEscaping2[i2] = gHexChs[i2 & 15];
            i = i2 + 1;
        }
        gNeedEscaping[127] = true;
        gAfterEscaping1[127] = '7';
        gAfterEscaping2[127] = 'F';
        char[] cArr = {' ', '<', '>', '#', '%', '\"', '{', '}', '|', '\\', '^', '~', '[', ']', '`'};
        int length = cArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            char c = cArr[i4];
            gNeedEscaping[c] = true;
            gAfterEscaping1[c] = gHexChs[c >> 4];
            gAfterEscaping2[c] = gHexChs[c & 15];
            i3 = i4 + 1;
        }
    }

    FilePathToURI() {
    }

    public static String filepath2URI(String str) {
        int i;
        char charAt;
        char upperCase;
        if (str == null) {
            return null;
        }
        String replace = str.replace(File.separatorChar, '/');
        int length = replace.length();
        StringBuilder sb = new StringBuilder(length * 3);
        sb.append("file://");
        if (length >= 2 && replace.charAt(1) == ':' && (upperCase = Character.toUpperCase(replace.charAt(0))) >= 'A' && upperCase <= 'Z') {
            sb.append('/');
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= length || (charAt = replace.charAt(i)) >= 128) {
                break;
            }
            if (gNeedEscaping[charAt]) {
                sb.append('%');
                sb.append(gAfterEscaping1[charAt]);
                sb.append(gAfterEscaping2[charAt]);
            } else {
                sb.append(charAt);
            }
            i2 = i + 1;
        }
        if (i < length) {
            try {
                byte[] bytes = replace.substring(i).getBytes("UTF-8");
                int length2 = bytes.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    byte b = bytes[i4];
                    if (b < 0) {
                        int i5 = b + 256;
                        sb.append('%');
                        sb.append(gHexChs[i5 >> 4]);
                        sb.append(gHexChs[i5 & 15]);
                    } else if (gNeedEscaping[b]) {
                        sb.append('%');
                        sb.append(gAfterEscaping1[b]);
                        sb.append(gAfterEscaping2[b]);
                    } else {
                        sb.append((char) b);
                    }
                    i3 = i4 + 1;
                }
            } catch (UnsupportedEncodingException e) {
                return replace;
            }
        }
        return sb.toString();
    }
}
