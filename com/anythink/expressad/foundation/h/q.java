package com.anythink.expressad.foundation.h;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7968a = 256;
    private static Map<Character, Character> b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f7969c;
    private static final char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static char[] e;
    private static final char f = '=';
    private static final byte[] g;

    static {
        int i;
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put('A', 'v');
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
        e = new char[d.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            char[] cArr = d;
            if (i3 >= cArr.length) {
                break;
            }
            e[i3] = b.get(Character.valueOf(cArr[i3])).charValue();
            i2 = i3 + 1;
        }
        g = new byte[128];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            byte[] bArr = g;
            i = 0;
            if (i5 >= bArr.length) {
                break;
            }
            bArr[i5] = Byte.MAX_VALUE;
            i4 = i5 + 1;
        }
        while (true) {
            char[] cArr2 = e;
            if (i >= cArr2.length) {
                return;
            }
            g[cArr2[i]] = (byte) i;
            i++;
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i) {
        boolean z = cArr[3] == '=' ? true : true;
        if (cArr[2] == '=') {
            z = true;
        }
        try {
            byte b2 = g[cArr[0]];
            byte b3 = g[cArr[1]];
            byte b4 = g[cArr[2]];
            byte b5 = g[cArr[3]];
            if (z) {
                bArr[i] = (byte) ((3 & (b3 >> 4)) | ((b2 << 2) & 252));
                bArr[i + 1] = (byte) (((b3 << 4) & 240) | ((b4 >> 2) & 15));
                return 2;
            } else if (!z) {
                bArr[i] = (byte) (((b2 << 2) & 252) | (3 & (b3 >> 4)));
                return 1;
            } else {
                int i2 = i + 1;
                bArr[i] = (byte) (((b2 << 2) & 252) | ((b3 >> 4) & 3));
                bArr[i2] = (byte) (((b3 << 4) & 240) | ((b4 >> 2) & 15));
                bArr[i2 + 1] = (byte) ((b5 & 63) | ((b4 << 6) & 192));
                return 3;
            }
        } catch (Exception e2) {
            return 0;
        }
    }

    public static String a(String str) {
        byte[] c2 = c(str);
        if (c2 == null || c2.length <= 0) {
            return null;
        }
        return new String(c2);
    }

    private static String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static String a(byte[] bArr, int i) {
        int i2;
        if (i <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i / 3) << 2) + 4];
            int i3 = 0;
            int i4 = i;
            int i5 = 0;
            while (i4 >= 3) {
                int i6 = ((bArr[i3] & 255) << 16) + ((bArr[i3 + 1] & 255) << 8) + (bArr[i3 + 2] & 255);
                int i7 = i5 + 1;
                cArr[i5] = e[i6 >> 18];
                int i8 = i7 + 1;
                cArr[i7] = e[(i6 >> 12) & 63];
                int i9 = i8 + 1;
                cArr[i8] = e[(i6 >> 6) & 63];
                i5 = i9 + 1;
                cArr[i9] = e[i6 & 63];
                i3 += 3;
                i4 -= 3;
            }
            if (i4 == 1) {
                int i10 = bArr[i3] & 255;
                int i11 = i5 + 1;
                cArr[i5] = e[i10 >> 2];
                int i12 = i11 + 1;
                cArr[i11] = e[(i10 << 4) & 63];
                int i13 = i12 + 1;
                cArr[i12] = '=';
                i2 = i13 + 1;
                cArr[i13] = '=';
            } else {
                i2 = i5;
                if (i4 == 2) {
                    int i14 = ((bArr[i3] & 255) << 8) + (bArr[i3 + 1] & 255);
                    int i15 = i5 + 1;
                    cArr[i5] = e[i14 >> 10];
                    int i16 = i15 + 1;
                    cArr[i15] = e[(i14 >> 4) & 63];
                    int i17 = i16 + 1;
                    cArr[i16] = e[(i14 << 2) & 63];
                    i2 = i17 + 1;
                    cArr[i17] = '=';
                }
            }
            return new String(cArr, 0, i2);
        } catch (Exception e2) {
            return null;
        }
    }

    private static byte[] a(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        try {
            char[] cArr2 = new char[4];
            int i5 = ((i2 >> 2) * 3) + 3;
            byte[] bArr = new byte[i5];
            int i6 = i;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i6 >= i + i2) {
                    break;
                }
                char c2 = cArr[i6];
                if (c2 != '=') {
                    i4 = i7;
                    i3 = i9;
                    if (c2 < g.length) {
                        i4 = i7;
                        i3 = i9;
                        if (g[c2] == Byte.MAX_VALUE) {
                        }
                    }
                    i6++;
                    i7 = i4;
                    i8 = i3;
                }
                i3 = i9 + 1;
                cArr2[i9] = c2;
                if (i3 == 4) {
                    i4 = i7 + a(cArr2, bArr, i7);
                    i3 = 0;
                } else {
                    i4 = i7;
                }
                i6++;
                i7 = i4;
                i8 = i3;
            }
            if (i7 == i5) {
                return bArr;
            }
            byte[] bArr2 = new byte[i7];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i7);
            return bArr2;
        } catch (Exception e2) {
            return null;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, bytes.length);
    }

    private static byte[] c(String str) {
        int i;
        int i2;
        try {
            int length = str.length();
            int i3 = 259;
            if (length < 259) {
                i3 = length;
            }
            char[] cArr = new char[i3];
            int i4 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i4];
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < length) {
                int i8 = i5 + 256;
                if (i8 <= length) {
                    str.getChars(i5, i8, cArr, i7);
                    i = i7 + 256;
                } else {
                    str.getChars(i5, length, cArr, i7);
                    i = (length - i5) + i7;
                }
                int i9 = i7;
                int i10 = i7;
                while (true) {
                    i7 = i9;
                    if (i10 < i) {
                        char c2 = cArr[i10];
                        if (c2 != '=') {
                            i2 = i6;
                            i9 = i7;
                            if (c2 < g.length) {
                                i2 = i6;
                                i9 = i7;
                                if (g[c2] == Byte.MAX_VALUE) {
                                }
                            }
                            i10++;
                            i6 = i2;
                        }
                        i9 = i7 + 1;
                        cArr[i7] = c2;
                        if (i9 == 4) {
                            i2 = i6 + a(cArr, bArr, i6);
                            i9 = 0;
                        } else {
                            i2 = i6;
                        }
                        i10++;
                        i6 = i2;
                    }
                }
                i5 = i8;
            }
            if (i6 == i4) {
                return bArr;
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i6);
            return bArr2;
        } catch (Exception e2) {
            return null;
        }
    }
}
