package com.tencent.turingface.sdk.mfa;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/nyvKz.class */
public final class nyvKz {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f39970a;
    public String b = "GBK";

    public nyvKz() {
    }

    public nyvKz(byte[] bArr) {
        this.f39970a = ByteBuffer.wrap(bArr);
    }

    public nyvKz(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f39970a = wrap;
        wrap.position(4);
    }

    public final byte a(byte b, int i, boolean z) {
        if (b(i)) {
            ByteBuffer byteBuffer = this.f39970a;
            byte b2 = byteBuffer.get();
            byte b3 = (byte) (b2 & 15);
            if (((b2 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b3 == 0) {
                return this.f39970a.get();
            }
            if (b3 != 11) {
                if (b3 == 12) {
                    return (byte) 0;
                }
                throw new s7Dnc("type mismatch.");
            }
        } else if (z) {
            throw new s7Dnc("require field not exist.");
        }
        return b;
    }

    public final double a(double d, int i, boolean z) {
        if (b(i)) {
            ByteBuffer byteBuffer = this.f39970a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 4) {
                return this.f39970a.getFloat();
            }
            if (b2 == 5) {
                return this.f39970a.getDouble();
            }
            if (b2 != 11) {
                if (b2 == 12) {
                    return 0.0d;
                }
                throw new s7Dnc("type mismatch.");
            }
        } else if (z) {
            throw new s7Dnc("require field not exist.");
        }
        return d;
    }

    public final float a(float f, int i, boolean z) {
        if (b(i)) {
            ByteBuffer byteBuffer = this.f39970a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 4) {
                return this.f39970a.getFloat();
            }
            if (b2 != 11) {
                if (b2 == 12) {
                    return 0.0f;
                }
                throw new s7Dnc("type mismatch.");
            }
        } else if (z) {
            throw new s7Dnc("require field not exist.");
        }
        return f;
    }

    public final int a(int i, int i2, boolean z) {
        if (b(i2)) {
            ByteBuffer byteBuffer = this.f39970a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 0) {
                return this.f39970a.get();
            }
            if (b2 == 1) {
                return this.f39970a.getShort();
            }
            if (b2 == 2) {
                return this.f39970a.getInt();
            }
            if (b2 != 11) {
                if (b2 == 12) {
                    return 0;
                }
                throw new s7Dnc("type mismatch.");
            }
        } else if (z) {
            throw new s7Dnc("require field not exist.");
        }
        return i;
    }

    public final long a(long j, int i, boolean z) {
        byte b;
        if (b(i)) {
            ByteBuffer byteBuffer = this.f39970a;
            byte b2 = byteBuffer.get();
            byte b3 = (byte) (b2 & 15);
            if (((b2 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b3 != 11) {
                if (b3 != 12) {
                    if (b3 == 0) {
                        b = this.f39970a.get();
                    } else if (b3 == 1) {
                        b = this.f39970a.getShort();
                    } else if (b3 != 2) {
                        if (b3 == 3) {
                            return this.f39970a.getLong();
                        }
                        throw new s7Dnc("type mismatch.");
                    } else {
                        b = this.f39970a.getInt();
                    }
                    return b;
                }
                return 0L;
            }
        } else if (z) {
            throw new s7Dnc("require field not exist.");
        }
        return j;
    }

    public final ucT3w a(ucT3w uct3w, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new s7Dnc("require field not exist.");
            }
            return null;
        }
        try {
            ucT3w uct3w2 = (ucT3w) uct3w.getClass().newInstance();
            ByteBuffer byteBuffer = this.f39970a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 10) {
                uct3w2.a(this);
                b();
                return uct3w2;
            }
            throw new s7Dnc("type mismatch.");
        } catch (Exception e) {
            throw new s7Dnc(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i, boolean z) {
        double[] dArr;
        float[] fArr;
        long[] jArr;
        int[] iArr;
        short[] sArr;
        boolean[] zArr;
        ArrayList arrayList;
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i, z));
        }
        if (t instanceof String) {
            return b(i, z);
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            List list = (List) t;
            if (list != null && !list.isEmpty()) {
                Object[] b = b(list.get(0), i, z);
                if (b != null) {
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        arrayList = arrayList2;
                        if (i3 >= b.length) {
                            break;
                        }
                        arrayList2.add(b[i3]);
                        i2 = i3 + 1;
                    }
                } else {
                    return null;
                }
            } else {
                arrayList = new ArrayList();
            }
            return arrayList;
        } else if (t instanceof ucT3w) {
            return a((ucT3w) t, i, z);
        } else {
            if (t.getClass().isArray()) {
                if ((t instanceof byte[]) || (t instanceof Byte[])) {
                    return a(i, z);
                }
                if (t instanceof boolean[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer = this.f39970a;
                        byte b2 = byteBuffer.get();
                        byte b3 = (byte) (b2 & 15);
                        if (((b2 & 240) >> 4) == 15) {
                            byteBuffer.get();
                        }
                        if (b3 != 9) {
                            if (b3 == 11) {
                                return null;
                            }
                            throw new s7Dnc("type mismatch.");
                        }
                        int a2 = a(0, 0, true);
                        if (a2 < 0) {
                            throw new s7Dnc("size invalid: " + a2);
                        }
                        boolean[] zArr2 = new boolean[a2];
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            zArr = zArr2;
                            if (i5 >= a2) {
                                break;
                            }
                            zArr2[i5] = a(zArr2[0], 0, true);
                            i4 = i5 + 1;
                        }
                    } else if (z) {
                        throw new s7Dnc("require field not exist.");
                    } else {
                        zArr = null;
                    }
                    return zArr;
                } else if (t instanceof short[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer2 = this.f39970a;
                        byte b4 = byteBuffer2.get();
                        byte b5 = (byte) (b4 & 15);
                        if (((b4 & 240) >> 4) == 15) {
                            byteBuffer2.get();
                        }
                        if (b5 != 9) {
                            if (b5 == 11) {
                                return null;
                            }
                            throw new s7Dnc("type mismatch.");
                        }
                        int a3 = a(0, 0, true);
                        if (a3 < 0) {
                            throw new s7Dnc("size invalid: " + a3);
                        }
                        short[] sArr2 = new short[a3];
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            sArr = sArr2;
                            if (i7 >= a3) {
                                break;
                            }
                            sArr2[i7] = a(sArr2[0], 0, true);
                            i6 = i7 + 1;
                        }
                    } else if (z) {
                        throw new s7Dnc("require field not exist.");
                    } else {
                        sArr = null;
                    }
                    return sArr;
                } else if (t instanceof int[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer3 = this.f39970a;
                        byte b6 = byteBuffer3.get();
                        byte b7 = (byte) (b6 & 15);
                        if (((b6 & 240) >> 4) == 15) {
                            byteBuffer3.get();
                        }
                        if (b7 != 9) {
                            if (b7 == 11) {
                                return null;
                            }
                            throw new s7Dnc("type mismatch.");
                        }
                        int a4 = a(0, 0, true);
                        if (a4 < 0) {
                            throw new s7Dnc("size invalid: " + a4);
                        }
                        int[] iArr2 = new int[a4];
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            iArr = iArr2;
                            if (i9 >= a4) {
                                break;
                            }
                            iArr2[i9] = a(iArr2[0], 0, true);
                            i8 = i9 + 1;
                        }
                    } else if (z) {
                        throw new s7Dnc("require field not exist.");
                    } else {
                        iArr = null;
                    }
                    return iArr;
                } else if (t instanceof long[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer4 = this.f39970a;
                        byte b8 = byteBuffer4.get();
                        byte b9 = (byte) (b8 & 15);
                        if (((b8 & 240) >> 4) == 15) {
                            byteBuffer4.get();
                        }
                        if (b9 != 9) {
                            if (b9 == 11) {
                                return null;
                            }
                            throw new s7Dnc("type mismatch.");
                        }
                        int a5 = a(0, 0, true);
                        if (a5 < 0) {
                            throw new s7Dnc("size invalid: " + a5);
                        }
                        long[] jArr2 = new long[a5];
                        int i10 = 0;
                        while (true) {
                            int i11 = i10;
                            jArr = jArr2;
                            if (i11 >= a5) {
                                break;
                            }
                            jArr2[i11] = a(jArr2[0], 0, true);
                            i10 = i11 + 1;
                        }
                    } else if (z) {
                        throw new s7Dnc("require field not exist.");
                    } else {
                        jArr = null;
                    }
                    return jArr;
                } else if (t instanceof float[]) {
                    if (b(i)) {
                        ByteBuffer byteBuffer5 = this.f39970a;
                        byte b10 = byteBuffer5.get();
                        byte b11 = (byte) (b10 & 15);
                        if (((b10 & 240) >> 4) == 15) {
                            byteBuffer5.get();
                        }
                        if (b11 != 9) {
                            if (b11 == 11) {
                                return null;
                            }
                            throw new s7Dnc("type mismatch.");
                        }
                        int a6 = a(0, 0, true);
                        if (a6 < 0) {
                            throw new s7Dnc("size invalid: " + a6);
                        }
                        float[] fArr2 = new float[a6];
                        int i12 = 0;
                        while (true) {
                            int i13 = i12;
                            fArr = fArr2;
                            if (i13 >= a6) {
                                break;
                            }
                            fArr2[i13] = a(fArr2[0], 0, true);
                            i12 = i13 + 1;
                        }
                    } else if (z) {
                        throw new s7Dnc("require field not exist.");
                    } else {
                        fArr = null;
                    }
                    return fArr;
                } else if (!(t instanceof double[])) {
                    Object[] objArr = (Object[]) t;
                    if (objArr.length != 0) {
                        return b(objArr[0], i, z);
                    }
                    throw new s7Dnc("unable to get type of key and value.");
                } else {
                    if (b(i)) {
                        ByteBuffer byteBuffer6 = this.f39970a;
                        byte b12 = byteBuffer6.get();
                        byte b13 = (byte) (b12 & 15);
                        if (((b12 & 240) >> 4) == 15) {
                            byteBuffer6.get();
                        }
                        if (b13 != 9) {
                            if (b13 == 11) {
                                return null;
                            }
                            throw new s7Dnc("type mismatch.");
                        }
                        int a7 = a(0, 0, true);
                        if (a7 < 0) {
                            throw new s7Dnc("size invalid: " + a7);
                        }
                        double[] dArr2 = new double[a7];
                        int i14 = 0;
                        while (true) {
                            int i15 = i14;
                            dArr = dArr2;
                            if (i15 >= a7) {
                                break;
                            }
                            dArr2[i15] = a(dArr2[0], 0, true);
                            i14 = i15 + 1;
                        }
                    } else if (z) {
                        throw new s7Dnc("require field not exist.");
                    } else {
                        dArr = null;
                    }
                    return dArr;
                }
            }
            throw new s7Dnc("read object error: unsupport type.");
        }
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        HashMap hashMap;
        HashMap hashMap2 = new HashMap();
        if (map == null || map.isEmpty()) {
            hashMap = new HashMap();
        } else {
            Map.Entry<K, V> next = map.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (!b(i)) {
                if (z) {
                    throw new s7Dnc("require field not exist.");
                }
                return hashMap2;
            }
            ByteBuffer byteBuffer = this.f39970a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 != 8) {
                if (b2 == 11) {
                    return hashMap2;
                }
                throw new s7Dnc("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new s7Dnc("size invalid: " + a2);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                hashMap = hashMap2;
                if (i3 >= a2) {
                    break;
                }
                hashMap2.put(a((nyvKz) key, 0, true), a((nyvKz) value, 1, true));
                i2 = i3 + 1;
            }
        }
        return hashMap;
    }

    public final short a(short s, int i, boolean z) {
        if (b(i)) {
            ByteBuffer byteBuffer = this.f39970a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b2 == 0) {
                return this.f39970a.get();
            }
            if (b2 == 1) {
                return this.f39970a.getShort();
            }
            if (b2 != 11) {
                if (b2 == 12) {
                    return (short) 0;
                }
                throw new s7Dnc("type mismatch.");
            }
        } else if (z) {
            throw new s7Dnc("require field not exist.");
        }
        return s;
    }

    public final void a() {
        ByteBuffer byteBuffer = this.f39970a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        a(b2);
    }

    public final void a(byte b) {
        switch (b) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                byte b2 = this.f39970a.get();
                byte b3 = b2;
                if (b2 < 0) {
                    b3 = b2 + 256;
                }
                a(b3);
                return;
            case 7:
                a(this.f39970a.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a2 * 2) {
                        return;
                    }
                    a();
                    i = i2 + 1;
                }
            case 9:
                int a3 = a(0, 0, true);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= a3) {
                        return;
                    }
                    a();
                    i3 = i4 + 1;
                }
            case 10:
                b();
                return;
            case 11:
            case 12:
                return;
            case 13:
                ByteBuffer byteBuffer = this.f39970a;
                byte b4 = byteBuffer.get();
                byte b5 = (byte) (b4 & 15);
                if (((b4 & 240) >> 4) == 15) {
                    byteBuffer.get();
                }
                if (b5 == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new s7Dnc("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) b5));
            default:
                throw new s7Dnc("invalid type.");
        }
    }

    public final void a(int i) {
        ByteBuffer byteBuffer = this.f39970a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    public final boolean a(boolean z, int i, boolean z2) {
        return a(z ? (byte) 1 : (byte) 0, i, z2) != 0;
    }

    public final byte[] a(int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new s7Dnc("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.f39970a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 != 9) {
            if (b2 != 11) {
                if (b2 == 13) {
                    ByteBuffer byteBuffer2 = this.f39970a;
                    byte b3 = byteBuffer2.get();
                    byte b4 = (byte) (b3 & 15);
                    if (((b3 & 240) >> 4) == 15) {
                        byteBuffer2.get();
                    }
                    if (b4 != 0) {
                        throw new s7Dnc("type mismatch, tag: " + i + ", type: " + ((int) b2) + ", " + ((int) b4));
                    }
                    int a2 = a(0, 0, true);
                    if (a2 >= 0) {
                        byte[] bArr = new byte[a2];
                        this.f39970a.get(bArr);
                        return bArr;
                    }
                    throw new s7Dnc("invalid size, tag: " + i + ", type: " + ((int) b2) + ", " + ((int) b4) + ", size: " + a2);
                }
                throw new s7Dnc("type mismatch.");
            }
            return null;
        }
        int a3 = a(0, 0, true);
        if (a3 < 0) {
            throw new s7Dnc("size invalid: " + a3);
        }
        byte[] bArr2 = new byte[a3];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a3) {
                return bArr2;
            }
            bArr2[i3] = a(bArr2[0], 0, true);
            i2 = i3 + 1;
        }
    }

    public final String b(int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new s7Dnc("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.f39970a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 == 6) {
            byte b3 = this.f39970a.get();
            byte b4 = b3;
            if (b3 < 0) {
                b4 = b3 + 256;
            }
            byte[] bArr = new byte[b4];
            this.f39970a.get(bArr);
            try {
                return new String(bArr, this.b);
            } catch (UnsupportedEncodingException e) {
                return new String(bArr);
            }
        } else if (b2 != 7) {
            if (b2 == 11) {
                return null;
            }
            throw new s7Dnc("type mismatch.");
        } else {
            int i2 = this.f39970a.getInt();
            if (i2 > 104857600 || i2 < 0) {
                throw new s7Dnc("String too long: " + i2);
            }
            byte[] bArr2 = new byte[i2];
            this.f39970a.get(bArr2);
            try {
                return new String(bArr2, this.b);
            } catch (UnsupportedEncodingException e2) {
                return new String(bArr2);
            }
        }
    }

    public final void b() {
        while (this.f39970a.remaining() != 0) {
            ByteBuffer byteBuffer = this.f39970a;
            byte b = byteBuffer.get();
            byte b2 = (byte) (b & 15);
            if (((b & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            a(b2);
            if (b2 == 11) {
                return;
            }
        }
    }

    public final boolean b(int i) {
        boolean z;
        int i2;
        int i3;
        while (true) {
            z = false;
            try {
                ByteBuffer duplicate = this.f39970a.duplicate();
                byte b = duplicate.get();
                byte b2 = (byte) (b & 15);
                i2 = (b & 240) >> 4;
                if (i2 == 15) {
                    i2 = duplicate.get() & 255;
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (i <= i2 || b2 == 11) {
                    break;
                }
                a(i3);
                a(b2);
            } catch (s7Dnc | BufferUnderflowException e) {
                return false;
            }
        }
        if (i == i2) {
            z = true;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] b(T t, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new s7Dnc("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.f39970a;
        byte b = byteBuffer.get();
        byte b2 = (byte) (b & 15);
        if (((b & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b2 != 9) {
            if (b2 == 11) {
                return null;
            }
            throw new s7Dnc("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new s7Dnc("size invalid: " + a2);
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2) {
                return tArr;
            }
            tArr[i3] = a((nyvKz) t, 0, true);
            i2 = i3 + 1;
        }
    }
}
