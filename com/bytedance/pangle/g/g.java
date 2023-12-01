package com.bytedance.pangle.g;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.ArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/g.class */
abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7809a = new byte[8];

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/g$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f7810a;
        public final byte[] b;

        a(ByteBuffer byteBuffer, byte[] bArr) {
            this.f7810a = byteBuffer;
            this.b = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/g$b.class */
    public static final class b implements j {

        /* renamed from: a  reason: collision with root package name */
        private int f7811a;
        private final ByteBuffer b;

        /* renamed from: c  reason: collision with root package name */
        private final MessageDigest f7812c;
        private final byte[] d;
        private final byte[] e;

        private b(byte[] bArr, ByteBuffer byteBuffer) {
            this.d = new byte[32];
            this.e = bArr;
            this.b = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.f7812c = messageDigest;
            messageDigest.update(this.e);
            this.f7811a = 0;
        }

        /* synthetic */ b(byte[] bArr, ByteBuffer byteBuffer, byte b) {
            this(bArr, byteBuffer);
        }

        public final void a() {
            if (this.f7811a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.f7811a);
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = Math.min(remaining, 4096 - this.f7811a);
                byteBuffer.limit(byteBuffer.position() + min);
                this.f7812c.update(byteBuffer);
                int i = remaining - min;
                int i2 = this.f7811a + min;
                this.f7811a = i2;
                remaining = i;
                if (i2 == 4096) {
                    MessageDigest messageDigest = this.f7812c;
                    byte[] bArr = this.d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.b.put(this.d);
                    this.f7812c.update(this.e);
                    this.f7811a = 0;
                    remaining = i;
                }
            }
        }

        final void b() {
            int position = this.b.position() % 4096;
            if (position == 0) {
                return;
            }
            this.b.put(ByteBuffer.allocate(4096 - position));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(RandomAccessFile randomAccessFile, m mVar, i iVar) {
        int[] a2 = a(randomAccessFile.length() - (mVar.f7817c - mVar.b));
        int i = a2[a2.length - 1];
        int i2 = i + 4096;
        ByteBuffer a3 = iVar.a(i2);
        a3.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer a4 = a(a3, 0, i);
        int i3 = i + 64;
        ByteBuffer a5 = a(a3, i, i3);
        ByteBuffer a6 = a(a3, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (mVar.b % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.b);
        } else if ((mVar.f7817c - mVar.b) % 4096 != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.f7817c - mVar.b));
        } else {
            long j = mVar.f7817c - mVar.b;
            int[] a7 = a(randomAccessFile.length() - j);
            if (a4 != null) {
                byte[] a8 = a(randomAccessFile, mVar, f7809a, a7, a4);
                if (wrap != null) {
                    wrap.put(a8);
                    wrap.flip();
                }
            }
            if (a5 != null) {
                a5.order(ByteOrder.LITTLE_ENDIAN);
                long length = randomAccessFile.length();
                byte[] bArr2 = f7809a;
                if (bArr2.length != 8) {
                    throw new IllegalArgumentException("salt is not 8 bytes long");
                }
                a5.put("TrueBrew".getBytes());
                a5.put((byte) 1);
                a5.put((byte) 0);
                a5.put((byte) 12);
                a5.put((byte) 7);
                a5.putShort((short) 1);
                a5.putShort((short) 1);
                a5.putInt(0);
                a5.putInt(0);
                a5.putLong(length);
                a5.put((byte) 2);
                a5.put((byte) 0);
                a5.put(bArr2);
                a(a5, 22);
                a5.flip();
            }
            if (a6 != null) {
                a6.order(ByteOrder.LITTLE_ENDIAN);
                long j2 = mVar.b;
                long j3 = mVar.d;
                a6.putInt(24);
                a6.putShort((short) 1);
                a(a6, 2);
                a6.putLong(j2);
                a6.putLong(j);
                a6.putInt(20);
                a6.putShort((short) 2);
                a(a6, 2);
                a6.putLong(j3 + 16);
                a6.putInt(c(j2));
                a(a6, 4);
                a6.flip();
            }
            a3.position(i3 + a6.limit());
            a3.putInt(a6.limit() + 64 + 4);
            a3.flip();
            return new a(a3, bArr);
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i2);
        duplicate.position(i);
        return duplicate.slice();
    }

    private static void a(j jVar, k kVar, int i) {
        long a2 = kVar.a();
        long j = 0;
        while (a2 > 0) {
            int min = (int) Math.min(a2, i);
            kVar.a(jVar, j, min);
            long j2 = min;
            j += j2;
            a2 -= j2;
        }
    }

    private static void a(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static byte[] a(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) {
        b bVar = new b(bArr, a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), (byte) 0);
        a(bVar, new l(randomAccessFile.getFD(), 0L, mVar.b), 1048576);
        long j = mVar.d + 16;
        a(bVar, new l(randomAccessFile.getFD(), mVar.f7817c, j - mVar.f7817c), 1048576);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(c(mVar.b));
        order.flip();
        bVar.a(order);
        long j2 = j + 4;
        a(bVar, new l(randomAccessFile.getFD(), j2, randomAccessFile.length() - j2), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            bVar.a(ByteBuffer.allocate(4096 - length));
        }
        bVar.a();
        bVar.b();
        int length2 = iArr.length;
        int i = 3;
        while (true) {
            int i2 = length2 - i;
            if (i2 < 0) {
                byte[] bArr2 = new byte[32];
                b bVar2 = new b(bArr, ByteBuffer.wrap(bArr2), (byte) 0);
                bVar2.a(a(byteBuffer, 0, 4096));
                bVar2.a();
                return bArr2;
            }
            int i3 = i2 + 1;
            ByteBuffer a2 = a(byteBuffer, iArr[i3], iArr[i2 + 2]);
            ByteBuffer a3 = a(byteBuffer, iArr[i2], iArr[i3]);
            h hVar = new h(a2);
            b bVar3 = new b(bArr, a3, (byte) 0);
            a(bVar3, hVar, 4096);
            bVar3.a();
            bVar3.b();
            length2 = i2;
            i = 1;
        }
    }

    private static int[] a(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = b(j) * 32;
            arrayList.add(Long.valueOf(b(j) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + c(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static long b(long j) {
        return ((j + 4096) - 1) / 4096;
    }

    private static int c(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
