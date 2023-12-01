package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fn.class */
public class fn {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f27721a = {80, 85, 83, 72};

    /* renamed from: a  reason: collision with other field name */
    private byte f420a;

    /* renamed from: a  reason: collision with other field name */
    private int f421a;

    /* renamed from: a  reason: collision with other field name */
    private short f422a;
    private byte[] b;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fn$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f27722a = new c();

        /* renamed from: a  reason: collision with other field name */
        public static final d f423a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f423a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            byte[] bArr2 = bArr;
            if (fn.m8721a(bArr)) {
                fn a2 = fn.a(bArr);
                if (a2.f420a != 0 && a2.f420a == bVar.a()) {
                    return bVar.a(a2.b, a2.f421a);
                }
                bArr2 = a2.b;
            }
            return bArr2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fn$b.class */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fn$c.class */
    public static final class c {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fn$d.class */
    public static final class d implements b {
        @Override // com.xiaomi.push.fn.b
        public final byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.fn.b
        public final byte[] a(byte[] bArr, int i) {
            GZIPInputStream gZIPInputStream;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream.read(bArr2);
                    try {
                        gZIPInputStream.close();
                        return bArr2;
                    } catch (IOException e) {
                        return bArr2;
                    }
                } catch (IOException e2) {
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e3) {
                            return bArr;
                        }
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                gZIPInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
            }
        }
    }

    protected fn(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
    }

    protected fn(short s, byte b2, int i, byte[] bArr) {
        this.f422a = (short) 1;
        this.f422a = s;
        this.f420a = b2;
        this.f421a = i;
        this.b = bArr;
    }

    public static fn a(byte b2, int i, byte[] bArr) {
        return new fn(b2, i, bArr);
    }

    public static fn a(short s, byte b2, int i, byte[] bArr) {
        return new fn(s, b2, i, bArr);
    }

    public static fn a(byte[] bArr) {
        if (m8721a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return a(s, b2, i, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8721a(byte[] bArr) {
        byte[] bArr2 = f27721a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i2 = i3 + 1;
        }
    }
}
