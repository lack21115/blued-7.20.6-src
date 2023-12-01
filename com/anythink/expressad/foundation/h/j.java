package com.anythink.expressad.foundation.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/j.class */
public class j {
    private static Map<Character, Character> b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f5114c;

    /* renamed from: a  reason: collision with root package name */
    private static final String f5113a = j.class.getSimpleName();
    private static char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        b = null;
        f5114c = null;
        HashMap hashMap = new HashMap();
        f5114c = hashMap;
        hashMap.put('v', 'A');
        f5114c.put('S', 'B');
        f5114c.put('o', 'C');
        f5114c.put('a', 'D');
        f5114c.put('j', 'E');
        f5114c.put('c', 'F');
        f5114c.put('7', 'G');
        f5114c.put('d', 'H');
        f5114c.put('R', 'I');
        f5114c.put('z', 'J');
        f5114c.put('p', 'K');
        f5114c.put('W', 'L');
        f5114c.put('i', 'M');
        f5114c.put('f', 'N');
        f5114c.put('G', 'O');
        f5114c.put('y', 'P');
        f5114c.put('N', 'Q');
        f5114c.put('x', 'R');
        f5114c.put('Z', 'S');
        f5114c.put('n', 'T');
        f5114c.put('V', 'U');
        f5114c.put('5', 'V');
        f5114c.put('k', 'W');
        f5114c.put('+', 'X');
        f5114c.put('D', 'Y');
        f5114c.put('H', 'Z');
        f5114c.put('L', 'a');
        f5114c.put('Y', 'b');
        f5114c.put('h', 'c');
        f5114c.put('J', 'd');
        f5114c.put('4', 'e');
        f5114c.put('6', 'f');
        f5114c.put('l', 'g');
        f5114c.put('t', 'h');
        f5114c.put('0', 'i');
        f5114c.put('U', 'j');
        f5114c.put('3', 'k');
        f5114c.put('Q', 'l');
        f5114c.put('r', 'm');
        f5114c.put('g', 'n');
        f5114c.put('E', 'o');
        f5114c.put('u', 'p');
        f5114c.put('q', 'q');
        f5114c.put('8', 'r');
        f5114c.put('s', 's');
        f5114c.put('w', 't');
        f5114c.put('/', 'u');
        f5114c.put('X', 'v');
        f5114c.put('M', 'w');
        f5114c.put('e', 'x');
        f5114c.put('B', 'y');
        f5114c.put('A', 'z');
        f5114c.put('T', '0');
        f5114c.put('2', '1');
        f5114c.put('F', '2');
        f5114c.put('b', '3');
        f5114c.put('9', '4');
        f5114c.put('P', '5');
        f5114c.put('1', '6');
        f5114c.put('O', '7');
        f5114c.put('I', '8');
        f5114c.put('K', '9');
        f5114c.put('m', '+');
        f5114c.put('C', '/');
        HashMap hashMap2 = new HashMap();
        b = hashMap2;
        hashMap2.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', 'd');
        b.put('I', 'R');
        b.put('J', 'z');
        b.put('K', 'p');
        b.put('L', 'W');
        b.put('M', 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put('Y', 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put('b', 'Y');
        b.put('c', 'h');
        b.put('d', 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', 'l');
        b.put('h', 't');
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put('l', 'Q');
        b.put('m', 'r');
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', 'u');
        b.put('q', 'q');
        b.put('r', '8');
        b.put('s', 's');
        b.put('t', 'w');
        b.put('u', '/');
        b.put('v', 'X');
        b.put('w', 'M');
        b.put('x', 'e');
        b.put('y', 'B');
        b.put('z', 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', 'b');
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', 'm');
        b.put('/', 'C');
    }

    private j() {
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : q.b(str);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(d[i4 >>> 2]);
                stringBuffer.append(d[(i4 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                stringBuffer.append(d[i4 >>> 2]);
                stringBuffer.append(d[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                stringBuffer.append(d[(i6 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i7 = bArr[i5] & 255;
            stringBuffer.append(d[i4 >>> 2]);
            stringBuffer.append(d[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            stringBuffer.append(d[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(d[i7 & 63]);
            i = i5 + 1;
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        return q.a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
        if (r0 == (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r0.write(((r0 & 15) << 4) | ((r0 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ce, code lost:
        r0 = r6;
        r6 = r0 + 1;
        r0 = r0[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d9, code lost:
        if (r0 != 61) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
        return r0.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
        r0 = com.anythink.expressad.foundation.h.j.e[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
        if (r6 >= r0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
        if (r0 == (-1)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fc, code lost:
        if (r0 == (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
        r0.write(r0 | ((r0 & 3) << 6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] c(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.j.c(java.lang.String):byte[]");
    }
}
