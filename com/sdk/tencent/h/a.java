package com.sdk.tencent.h;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/h/a.class */
public class a extends d {
    public static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f14368c = new byte[256];

    /* renamed from: a  reason: collision with root package name */
    public byte[] f14369a = new byte[4];

    static {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = 0;
            if (i3 >= 255) {
                break;
            }
            f14368c[i3] = -1;
            i2 = i3 + 1;
        }
        while (true) {
            char[] cArr = b;
            if (i >= cArr.length) {
                return;
            }
            f14368c[cArr[i]] = (byte) i;
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.io.PushbackInputStream r7, java.io.OutputStream r8, int r9) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.tencent.h.a.a(java.io.PushbackInputStream, java.io.OutputStream, int):void");
    }
}
