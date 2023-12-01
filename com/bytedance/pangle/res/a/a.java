package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/a.class */
public class a {
    private static final Logger f = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f21469a;
    private final h b;

    /* renamed from: c  reason: collision with root package name */
    private final g f21470c;
    private final e d;
    private C0321a e;

    /* renamed from: com.bytedance.pangle.res.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/a$a.class */
    public static final class C0321a {

        /* renamed from: a  reason: collision with root package name */
        public final short f21471a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21472c;
        public final int d;
        public final int e;

        private C0321a(short s, int i, int i2, int i3) {
            this.f21471a = s;
            this.b = i;
            this.f21472c = i2;
            this.d = i3;
            this.e = i3 + i2;
        }

        public static C0321a a(g gVar, e eVar) {
            int a2 = eVar.a();
            try {
                return new C0321a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a2);
            } catch (EOFException e) {
                return new C0321a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.d = eVar;
        this.f21470c = new g(new i(eVar));
        this.f21469a = bArr;
        this.b = hVar;
    }

    private String a(int i) {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.f21470c.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.f21470c.skipBytes(i2);
        return sb.toString();
    }

    private void b() {
        b(515);
        int readInt = this.f21470c.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                break;
            }
            this.f21470c.readInt();
            this.f21470c.skipBytes(256);
            i = i2 + 1;
        }
        while (j().f21471a == 513) {
            c();
        }
    }

    private void b(int i) {
        if (this.e.f21471a != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.e.f21471a)));
        }
    }

    private void c() {
        short s;
        d();
        short s2 = j().f21471a;
        while (true) {
            short s3 = s2;
            s = s3;
            if (s3 != 514) {
                break;
            }
            d();
            s2 = j().f21471a;
        }
        while (s == 513) {
            e();
            if (this.d.a() < this.e.e) {
                Logger logger = f;
                logger.warning("Unknown data detected. Skipping: " + (this.e.e - this.d.a()) + " byte(s)");
                this.d.skip((long) (this.e.e - this.d.a()));
            }
            s = j().f21471a;
        }
    }

    private void d() {
        b(514);
        this.f21470c.readUnsignedByte();
        this.f21470c.skipBytes(3);
        this.f21470c.skipBytes(this.f21470c.readInt() * 4);
    }

    private void e() {
        b(513);
        this.f21470c.readUnsignedByte();
        this.f21470c.readByte();
        this.f21470c.skipBytes(2);
        int readInt = this.f21470c.readInt();
        int readInt2 = this.f21470c.readInt();
        i();
        int i = (this.e.d + readInt2) - (readInt * 4);
        if (i != this.d.a()) {
            Logger logger = f;
            logger.warning("Invalid data detected. Skipping: " + (i - this.d.a()) + " byte(s)");
            this.f21470c.skipBytes(i - this.d.a());
        }
        int[] a2 = this.f21470c.a(readInt);
        HashSet hashSet = new HashSet();
        int length = a2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            int i4 = a2[i3];
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                f();
                hashSet.add(Integer.valueOf(i4));
            }
            i2 = i3 + 1;
        }
    }

    private void f() {
        if (this.f21470c.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short readShort = this.f21470c.readShort();
        this.f21470c.readInt();
        if ((readShort & 1) == 0) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        int a2 = k.a(this.f21470c);
        k.a(this.f21469a, this.f21470c.readInt(), a2, this.b);
        int readInt = this.f21470c.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            int a3 = k.a(this.f21470c);
            k.a(this.f21469a, this.f21470c.readInt(), a3, this.b);
            h();
            i = i2 + 1;
        }
    }

    private void h() {
        this.f21470c.a();
        this.f21470c.b();
        byte readByte = this.f21470c.readByte();
        int a2 = k.a(this.f21470c);
        int readInt = this.f21470c.readInt();
        if (readByte == 1) {
            k.a(this.f21469a, readInt, a2, this.b);
        }
        if (readByte == 2) {
            k.a(this.f21469a, readInt, a2, this.b);
        }
    }

    private void i() {
        int readInt = this.f21470c.readInt();
        int i = 28;
        if (readInt < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.f21470c.readShort();
        this.f21470c.readShort();
        this.f21470c.readByte();
        this.f21470c.readByte();
        this.f21470c.readByte();
        this.f21470c.readByte();
        this.f21470c.readByte();
        this.f21470c.readByte();
        this.f21470c.readUnsignedShort();
        this.f21470c.readByte();
        this.f21470c.readByte();
        this.f21470c.readByte();
        this.f21470c.skipBytes(1);
        this.f21470c.readShort();
        this.f21470c.readShort();
        this.f21470c.readShort();
        this.f21470c.skipBytes(2);
        if (readInt >= 32) {
            this.f21470c.readByte();
            this.f21470c.readByte();
            this.f21470c.readShort();
            i = 32;
        }
        if (readInt >= 36) {
            this.f21470c.readShort();
            this.f21470c.readShort();
            i = 36;
        }
        if (readInt >= 48) {
            a(4).toCharArray();
            a(8).toCharArray();
            i = 48;
        }
        if (readInt >= 52) {
            this.f21470c.readByte();
            this.f21470c.readByte();
            this.f21470c.skipBytes(2);
            i = 52;
        }
        if (readInt >= 56) {
            this.f21470c.skipBytes(4);
            i = 56;
        }
        int i2 = readInt - 56;
        int i3 = i;
        if (i2 > 0) {
            byte[] bArr = new byte[i2];
            i3 = i + i2;
            this.f21470c.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
            }
        }
        int i4 = readInt - i3;
        if (i4 > 0) {
            this.f21470c.skipBytes(i4);
        }
    }

    private C0321a j() {
        C0321a a2 = C0321a.a(this.f21470c, this.d);
        this.e = a2;
        return a2;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.f21470c.readInt();
        l.a(this.f21470c);
        j();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            b(512);
            this.f21470c.readInt();
            this.f21470c.skipBytes(256);
            this.f21470c.skipBytes(4);
            this.f21470c.skipBytes(4);
            this.f21470c.skipBytes(4);
            this.f21470c.skipBytes(4);
            if (this.e.b == 288 && this.f21470c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f21470c);
            l.a(this.f21470c);
            j();
            boolean z = true;
            while (z) {
                short s = this.e.f21471a;
                if (s == 514) {
                    c();
                } else if (s != 515) {
                    z = false;
                } else {
                    b();
                }
            }
            i = i2 + 1;
        }
    }
}
