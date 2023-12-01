package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.ExpandableListView;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    static final HashMap<String, SparseArray<m>> f21413a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/f$a.class */
    public static final class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private final MessageDigest[] f21414a;

        a(MessageDigest[] messageDigestArr) {
            this.f21414a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) {
            ByteBuffer slice = byteBuffer.slice();
            MessageDigest[] messageDigestArr = this.f21414a;
            int length = messageDigestArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                MessageDigest messageDigest = messageDigestArr[i2];
                slice.position(0);
                messageDigest.update(slice);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i == 1057 || i == 1059 || i == 1061) {
                        return 3;
                    }
                    switch (i) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2) {
        int a2 = a(i);
        int a3 = a(i2);
        if (a2 == 1) {
            if (a3 != 1) {
                if (a3 == 2 || a3 == 3) {
                    return -1;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
            }
            return 0;
        } else if (a2 == 2) {
            if (a3 != 1) {
                if (a3 != 2) {
                    if (a3 == 3) {
                        return 1;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
                }
                return 0;
            }
            return 1;
        } else if (a2 == 3) {
            if (a3 != 1) {
                if (a3 != 2) {
                    if (a3 == 3) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
                }
                return -1;
            }
            return 1;
        } else {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(a2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                return b(byteBuffer, i);
            }
            throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        throw new IllegalArgumentException("Negative length");
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i) {
        if (i < 8) {
            throw new IllegalArgumentException("end < start: " + i + " < 8");
        }
        int capacity = byteBuffer.capacity();
        if (i > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    private static void a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) ((i >>> 24) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0316  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r13, java.io.RandomAccessFile r14, int... r15) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.f.a(java.lang.String, java.io.RandomAccessFile, int[]):void");
    }

    private static void a(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, m mVar) {
        int i;
        l lVar = new l(fileDescriptor, 0L, mVar.b);
        l lVar2 = new l(fileDescriptor, mVar.f21423c, mVar.d - mVar.f21423c);
        ByteBuffer duplicate = mVar.e.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        long j = mVar.b;
        s.a(duplicate);
        int position = duplicate.position();
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
        }
        duplicate.putInt(duplicate.position() + position + 16, (int) j);
        h hVar = new h(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                try {
                    break;
                } catch (DigestException e) {
                    throw new SecurityException("Failed to compute digest(s) of contents", e);
                }
            }
            iArr[i3] = it.next().intValue();
            i2 = i3 + 1;
        }
        byte[][] a2 = a(iArr, new k[]{lVar, lVar2, hVar});
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                return;
            }
            if (!MessageDigest.isEqual(map.get(Integer.valueOf(iArr[i5])), a2[i5])) {
                throw new SecurityException(b(i) + " digest of contents did not verify");
            }
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, m mVar) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        if (!arrayMap.isEmpty()) {
            try {
                a(arrayMap, randomAccessFile.getFD(), mVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            try {
                if (!Arrays.equals(a(map.get(3), randomAccessFile.length(), mVar), g.a(randomAccessFile, mVar, new i() { // from class: com.bytedance.pangle.g.f.1
                    @Override // com.bytedance.pangle.g.i
                    public final ByteBuffer a(int i) {
                        return ByteBuffer.allocate(i);
                    }
                }).b)) {
                    throw new SecurityException("APK verity digest of contents did not verify");
                }
                z = false;
            } catch (IOException | DigestException | NoSuchAlgorithmException e2) {
                throw new SecurityException("Error during verification", e2);
            }
        }
        if (z) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr, long j, m mVar) {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        order.position(32);
        if (order.getLong() == j - (mVar.f21423c - mVar.b)) {
            return Arrays.copyOfRange(bArr, 0, 32);
        }
        throw new SecurityException("APK content size did not verify");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [byte[], byte[][]] */
    private static byte[][] a(int[] iArr, k[] kVarArr) {
        MessageDigest messageDigest;
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                break;
            }
            j += ((kVarArr[i2].a() + 1048576) - 1) / 1048576;
            i = i2 + 1;
        }
        if (j >= 2097151) {
            throw new DigestException("Too many chunks: ".concat(String.valueOf(j)));
        }
        int i3 = (int) j;
        byte[] bArr = new byte[iArr.length];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= iArr.length) {
                break;
            }
            byte[] bArr2 = new byte[(e(iArr[i5]) * i3) + 5];
            bArr2[0] = 90;
            a(i3, bArr2);
            bArr[i5] = bArr2;
            i4 = i5 + 1;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int length = iArr.length;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= iArr.length) {
                break;
            }
            String b = b(iArr[i7]);
            try {
                messageDigestArr[i7] = MessageDigest.getInstance(b);
                i6 = i7 + 1;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(b + " digest not supported", e);
            }
        }
        a aVar = new a(messageDigestArr);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < 3) {
            k kVar = kVarArr[i8];
            long a2 = kVar.a();
            long j2 = 0;
            a aVar2 = aVar;
            byte[] bArr4 = bArr3;
            while (a2 > 0) {
                int min = (int) Math.min(a2, 1048576L);
                a(min, bArr4);
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 >= length) {
                        try {
                            break;
                        } catch (IOException e2) {
                            throw new DigestException("Failed to digest chunk #" + i10 + " of section #" + i9, e2);
                        }
                    }
                    messageDigestArr[i12].update(bArr4);
                    i11 = i12 + 1;
                }
                kVar.a(aVar2, j2, min);
                a aVar3 = aVar2;
                MessageDigest[] messageDigestArr2 = messageDigestArr;
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    int i14 = iArr[i13];
                    byte[] bArr5 = bArr[i13];
                    int e3 = e(i14);
                    int digest = messageDigestArr2[i13].digest(bArr5, (i10 * e3) + 5, e3);
                    if (digest != e3) {
                        throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                    }
                }
                long j3 = min;
                a2 -= j3;
                i10++;
                j2 += j3;
                messageDigestArr = messageDigestArr2;
                aVar2 = aVar3;
            }
            i9++;
            i8++;
            bArr3 = bArr4;
            aVar = aVar2;
        }
        ?? r0 = new byte[iArr.length];
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= iArr.length) {
                return r0;
            }
            int i17 = iArr[i16];
            byte[] bArr6 = bArr[i16];
            String b2 = b(i17);
            try {
                r0[i16] = MessageDigest.getInstance(b2).digest(bArr6);
                i15 = i16 + 1;
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(b2 + " digest not supported", e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "SHA-256";
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
            }
            return "SHA-512";
        }
        return "SHA-256";
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i != 769) {
            if (i != 1057) {
                if (i != 1059) {
                    if (i != 1061) {
                        switch (i) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                return "RSA";
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                        }
                    }
                    return "DSA";
                }
                return "EC";
            }
            return "RSA";
        }
        return "DSA";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<String, ? extends AlgorithmParameterSpec> d(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i != 1057) {
                        if (i != 1059) {
                            if (i != 1061) {
                                switch (i) {
                                    case 257:
                                        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                    case 258:
                                        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                    case 259:
                                        break;
                                    case 260:
                                        return Pair.create("SHA512withRSA", null);
                                    default:
                                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                                }
                            }
                        }
                    }
                    return Pair.create("SHA256withRSA", null);
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    private static int e(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return 32;
                }
                throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
            }
            return 64;
        }
        return 32;
    }
}
