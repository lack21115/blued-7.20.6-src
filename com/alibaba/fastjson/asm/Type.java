package com.alibaba.fastjson.asm;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/asm/Type.class */
public class Type {
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int i, char[] cArr, int i2, int i3) {
        this.sort = i;
        this.buf = cArr;
        this.off = i2;
        this.len = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r0 == 'J') goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getArgumentsAndReturnSizes(java.lang.String r3) {
        /*
            r0 = 1
            r7 = r0
            r0 = 1
            r5 = r0
            r0 = 1
            r4 = r0
        L7:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r3
            r1 = r5
            char r0 = r0.charAt(r1)
            r5 = r0
            r0 = r5
            r1 = 41
            if (r0 != r1) goto L3f
            r0 = r3
            r1 = r6
            char r0 = r0.charAt(r1)
            r6 = r0
            r0 = r6
            r1 = 86
            if (r0 != r1) goto L28
            r0 = 0
            r5 = r0
            goto L39
        L28:
            r0 = r6
            r1 = 68
            if (r0 == r1) goto L37
            r0 = r7
            r5 = r0
            r0 = r6
            r1 = 74
            if (r0 != r1) goto L39
        L37:
            r0 = 2
            r5 = r0
        L39:
            r0 = r4
            r1 = 2
            int r0 = r0 << r1
            r1 = r5
            r0 = r0 | r1
            return r0
        L3f:
            r0 = r5
            r1 = 76
            if (r0 != r1) goto L5f
        L45:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            r0 = r3
            r1 = r6
            char r0 = r0.charAt(r1)
            r1 = 59
            if (r0 == r1) goto L58
            r0 = r5
            r6 = r0
            goto L45
        L58:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto L7
        L5f:
            r0 = r5
            r1 = 68
            if (r0 == r1) goto L75
            r0 = r5
            r1 = 74
            if (r0 != r1) goto L6e
            goto L75
        L6e:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto L79
        L75:
            r0 = r4
            r1 = 2
            int r0 = r0 + r1
            r4 = r0
        L79:
            r0 = r6
            r5 = r0
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.asm.Type.getArgumentsAndReturnSizes(java.lang.String):int");
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    private static Type getType(char[] cArr, int i) {
        int i2;
        int i3;
        char c2 = cArr[i];
        if (c2 == 'F') {
            return FLOAT_TYPE;
        }
        if (c2 == 'S') {
            return SHORT_TYPE;
        }
        if (c2 == 'V') {
            return VOID_TYPE;
        }
        if (c2 == 'I') {
            return INT_TYPE;
        }
        if (c2 == 'J') {
            return LONG_TYPE;
        }
        if (c2 == 'Z') {
            return BOOLEAN_TYPE;
        }
        if (c2 == '[') {
            int i4 = 1;
            while (true) {
                i2 = i4;
                i3 = i + i2;
                if (cArr[i3] != '[') {
                    break;
                }
                i4 = i2 + 1;
            }
            int i5 = i2;
            if (cArr[i3] == 'L') {
                do {
                    i2++;
                    i5 = i2;
                } while (cArr[i + i2] != ';');
                return new Type(9, cArr, i, i5 + 1);
            }
            return new Type(9, cArr, i, i5 + 1);
        }
        switch (c2) {
            case 'B':
                return BYTE_TYPE;
            case 'C':
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
            default:
                int i6 = 1;
                while (true) {
                    int i7 = i6;
                    if (cArr[i + i7] == ';') {
                        return new Type(10, cArr, i + 1, i7 - 1);
                    }
                    i6 = i7 + 1;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }
}
