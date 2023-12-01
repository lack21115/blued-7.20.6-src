package com.bytedance.pangle.res.a;

import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/g.class */
public final class g extends f {
    public g(i iVar) {
        super(iVar);
    }

    public final void a() {
        short readShort = readShort();
        if (readShort != 8) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (short) 8, Short.valueOf(readShort)));
        }
    }

    public final int[] a(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return iArr;
            }
            iArr[i3] = readInt();
            i2 = i3 + 1;
        }
    }

    public final void b() {
        byte readByte = readByte();
        if (readByte != 0) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (byte) 0, Byte.valueOf(readByte)));
        }
    }

    public final void b(int i) {
        int readInt;
        while (true) {
            readInt = readInt();
            if (readInt != i && readInt >= 1835009) {
                break;
            }
            i = -1;
        }
        if (readInt != 1835009) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", 1835009, Integer.valueOf(readInt)));
        }
    }

    @Override // com.bytedance.pangle.res.a.f, java.io.DataInput
    public final int skipBytes(int i) {
        int i2;
        int skipBytes;
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= i || (skipBytes = super.skipBytes(i - i2)) <= 0) {
                break;
            }
            i3 = i2 + skipBytes;
        }
        return i2;
    }
}
