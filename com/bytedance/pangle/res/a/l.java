package com.bytedance.pangle.res.a;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/l.class */
public final class l {
    public static void a(g gVar) {
        gVar.b(0);
        int readInt = gVar.readInt();
        int readInt2 = gVar.readInt();
        int readInt3 = gVar.readInt();
        gVar.skipBytes(4);
        int readInt4 = gVar.readInt();
        int readInt5 = gVar.readInt();
        gVar.skipBytes(readInt2 * 4);
        if (readInt3 != 0) {
            gVar.skipBytes(readInt3 * 4);
        }
        gVar.skipBytes((readInt5 == 0 ? readInt : readInt5) - readInt4);
        if (readInt5 != 0) {
            int i = readInt - readInt5;
            gVar.skipBytes(i);
            int i2 = i % 4;
            if (i2 > 0) {
                while (i2 > 0) {
                    gVar.readByte();
                    i2--;
                }
            }
        }
    }
}
