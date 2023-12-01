package com.anythink.expressad.exoplayer.e.a;

import android.util.Log;
import com.anythink.expressad.exoplayer.k.s;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4461a = "PsshAtomUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/h$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f4462a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f4463c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.f4462a = uuid;
            this.b = i;
            this.f4463c = bArr;
        }
    }

    private h() {
    }

    public static UUID a(byte[] bArr) {
        a c2 = c(bArr);
        if (c2 == null) {
            return null;
        }
        return c2.f4462a;
    }

    private static byte[] a(UUID uuid, byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        int i = length + 32;
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.putInt(i);
        allocate.putInt(com.anythink.expressad.exoplayer.e.a.a.Z);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    private static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        boolean z = uuidArr != null;
        int length = bArr != null ? bArr.length : 0;
        int i = length + 32;
        int i2 = i;
        if (z) {
            i2 = i + (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.putInt(i2);
        allocate.putInt(com.anythink.expressad.exoplayer.e.a.a.Z);
        allocate.putInt(z ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (z) {
            allocate.putInt(uuidArr.length);
            int length2 = uuidArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                UUID uuid2 = uuidArr[i4];
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
                i3 = i4 + 1;
            }
        }
        if (length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static byte[] a(byte[] bArr, UUID uuid) {
        a c2 = c(bArr);
        if (c2 == null) {
            return null;
        }
        if (uuid == null || uuid.equals(c2.f4462a)) {
            return c2.f4463c;
        }
        Log.w(f4461a, "UUID mismatch. Expected: " + uuid + ", got: " + c2.f4462a + ".");
        return null;
    }

    public static int b(byte[] bArr) {
        a c2 = c(bArr);
        if (c2 == null) {
            return -1;
        }
        return c2.b;
    }

    private static a c(byte[] bArr) {
        s sVar = new s(bArr);
        if (sVar.b() < 32) {
            return null;
        }
        sVar.c(0);
        if (sVar.i() == sVar.a() + 4 && sVar.i() == com.anythink.expressad.exoplayer.e.a.a.Z) {
            int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
            if (a2 > 1) {
                Log.w(f4461a, "Unsupported pssh version: ".concat(String.valueOf(a2)));
                return null;
            }
            UUID uuid = new UUID(sVar.j(), sVar.j());
            if (a2 == 1) {
                sVar.d(sVar.m() * 16);
            }
            int m = sVar.m();
            if (m != sVar.a()) {
                return null;
            }
            byte[] bArr2 = new byte[m];
            sVar.a(bArr2, 0, m);
            return new a(uuid, a2, bArr2);
        }
        return null;
    }
}
