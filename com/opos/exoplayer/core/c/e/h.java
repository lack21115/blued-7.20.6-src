package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e.i;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/h.class */
final class h extends i {

    /* renamed from: a  reason: collision with root package name */
    private static final int f25172a = u.f("Opus");
    private static final byte[] b = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f25173c;

    private long a(byte[] bArr) {
        int i;
        int i2;
        int i3 = bArr[0] & 255;
        int i4 = i3 & 3;
        if (i4 != 0) {
            i = 2;
            if (i4 != 1) {
                i = 2;
                if (i4 != 2) {
                    i = bArr[1] & 63;
                }
            }
        } else {
            i = 1;
        }
        int i5 = i3 >> 3;
        return (i5 >= 16 ? 2500 << i2 : i5 >= 12 ? 10000 << (i2 & 1) : (i5 & 3) == 3 ? 60000 : 10000 << i2) * i;
    }

    private void a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i * 1000000000) / 48000).array());
    }

    public static boolean a(m mVar) {
        int b2 = mVar.b();
        byte[] bArr = b;
        if (b2 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        mVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.c.e.i
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f25173c = false;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(m mVar, long j, i.a aVar) {
        boolean z = true;
        if (this.f25173c) {
            if (mVar.o() != f25172a) {
                z = false;
            }
            mVar.c(0);
            return z;
        }
        byte[] copyOf = Arrays.copyOf(mVar.f25496a, mVar.c());
        byte b2 = copyOf[9];
        byte b3 = copyOf[11];
        byte b4 = copyOf[10];
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(copyOf);
        a(arrayList, ((b3 & 255) << 8) | (b4 & 255));
        a(arrayList, 3840);
        aVar.f25176a = Format.a(null, "audio/opus", null, -1, -1, b2 & 255, 48000, arrayList, null, 0, null);
        this.f25173c = true;
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(m mVar) {
        return b(a(mVar.f25496a));
    }
}
