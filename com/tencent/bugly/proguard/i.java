package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f35386a;
    private String b = "GBK";

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/i$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f35387a;
        public int b;
    }

    public i() {
    }

    public i(byte[] bArr) {
        this.f35386a = ByteBuffer.wrap(bArr);
    }

    public i(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f35386a = wrap;
        wrap.position(4);
    }

    private double a(double d, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return d;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b = aVar.f35387a;
        if (b != 4) {
            if (b != 5) {
                if (b == 12) {
                    return 0.0d;
                }
                throw new g("type mismatch.");
            }
            return this.f35386a.getDouble();
        }
        return this.f35386a.getFloat();
    }

    private float a(float f, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return f;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b = aVar.f35387a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new g("type mismatch.");
        }
        return this.f35386a.getFloat();
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f35387a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b == 15) {
            aVar.b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a != 8) {
                throw new g("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= a2) {
                    break;
                }
                map.put(a((i) key, 0, true), a((i) value, 1, true));
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new g("require field not exist.");
        }
        return map;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar, this.f35386a);
            a(aVar.f35387a);
        } while (aVar.f35387a != 11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [int] */
    private void a(byte b) {
        switch (b) {
            case 0:
                ByteBuffer byteBuffer = this.f35386a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.f35386a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.f35386a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.f35386a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.f35386a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.f35386a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                byte b2 = this.f35386a.get();
                byte b3 = b2;
                if (b2 < 0) {
                    b3 = b2 + 256;
                }
                ByteBuffer byteBuffer7 = this.f35386a;
                byteBuffer7.position(byteBuffer7.position() + b3);
                return;
            case 7:
                int i = this.f35386a.getInt();
                ByteBuffer byteBuffer8 = this.f35386a;
                byteBuffer8.position(byteBuffer8.position() + i);
                return;
            case 8:
                int a2 = a(0, 0, true);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= (a2 << 1)) {
                        return;
                    }
                    a aVar = new a();
                    a(aVar, this.f35386a);
                    a(aVar.f35387a);
                    i2 = i3 + 1;
                }
            case 9:
                int a3 = a(0, 0, true);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= a3) {
                        return;
                    }
                    a aVar2 = new a();
                    a(aVar2, this.f35386a);
                    a(aVar2.f35387a);
                    i4 = i5 + 1;
                }
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar3 = new a();
                a(aVar3, this.f35386a);
                if (aVar3.f35387a == 0) {
                    int a4 = a(0, 0, true);
                    ByteBuffer byteBuffer9 = this.f35386a;
                    byteBuffer9.position(byteBuffer9.position() + a4);
                    return;
                }
                throw new g("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar3.f35387a));
            default:
                throw new g("invalid type.");
        }
    }

    private boolean a(int i) {
        try {
            a aVar = new a();
            while (true) {
                int a2 = a(aVar, this.f35386a.duplicate());
                if (i <= aVar.b || aVar.f35387a == 11) {
                    break;
                }
                this.f35386a.position(this.f35386a.position() + a2);
                a(aVar.f35387a);
            }
            return i == aVar.b;
        } catch (g | BufferUnderflowException e) {
            return false;
        }
    }

    private <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new g("unable to get type of key and value.");
        }
        return (T[]) b(tArr[0], i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        if (aVar.f35387a != 9) {
            throw new g("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new g("size invalid: " + a2);
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2) {
                return tArr;
            }
            tArr[i3] = a((i) t, 0, true);
            i2 = i3 + 1;
        }
    }

    private boolean[] d(int i, boolean z) {
        boolean[] zArr;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a != 9) {
                throw new g("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            boolean[] zArr2 = new boolean[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                zArr = zArr2;
                if (i3 >= a2) {
                    break;
                }
                zArr2[i3] = a((byte) 0, 0, true) != 0;
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new g("require field not exist.");
        } else {
            zArr = null;
        }
        return zArr;
    }

    private short[] e(int i, boolean z) {
        short[] sArr;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a != 9) {
                throw new g("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            short[] sArr2 = new short[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                sArr = sArr2;
                if (i3 >= a2) {
                    break;
                }
                sArr2[i3] = a(sArr2[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new g("require field not exist.");
        } else {
            sArr = null;
        }
        return sArr;
    }

    private int[] f(int i, boolean z) {
        int[] iArr;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a != 9) {
                throw new g("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            int[] iArr2 = new int[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                iArr = iArr2;
                if (i3 >= a2) {
                    break;
                }
                iArr2[i3] = a(iArr2[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new g("require field not exist.");
        } else {
            iArr = null;
        }
        return iArr;
    }

    private long[] g(int i, boolean z) {
        long[] jArr;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a != 9) {
                throw new g("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            long[] jArr2 = new long[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                jArr = jArr2;
                if (i3 >= a2) {
                    break;
                }
                jArr2[i3] = a(jArr2[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new g("require field not exist.");
        } else {
            jArr = null;
        }
        return jArr;
    }

    private float[] h(int i, boolean z) {
        float[] fArr;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a != 9) {
                throw new g("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            float[] fArr2 = new float[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                fArr = fArr2;
                if (i3 >= a2) {
                    break;
                }
                fArr2[i3] = a(fArr2[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new g("require field not exist.");
        } else {
            fArr = null;
        }
        return fArr;
    }

    private double[] i(int i, boolean z) {
        double[] dArr;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a != 9) {
                throw new g("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            double[] dArr2 = new double[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                dArr = dArr2;
                if (i3 >= a2) {
                    break;
                }
                dArr2[i3] = a(dArr2[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new g("require field not exist.");
        } else {
            dArr = null;
        }
        return dArr;
    }

    public final byte a(byte b, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b2 = aVar.f35387a;
        if (b2 != 0) {
            if (b2 == 12) {
                return (byte) 0;
            }
            throw new g("type mismatch.");
        }
        return this.f35386a.get();
    }

    public final int a(int i, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return i;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b = aVar.f35387a;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 12) {
                        return 0;
                    }
                    throw new g("type mismatch.");
                }
                return this.f35386a.getInt();
            }
            return this.f35386a.getShort();
        }
        return this.f35386a.get();
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }

    public final long a(long j, int i, boolean z) {
        byte b;
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return j;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b2 = aVar.f35387a;
        if (b2 == 0) {
            b = this.f35386a.get();
        } else if (b2 == 1) {
            b = this.f35386a.getShort();
        } else if (b2 != 2) {
            if (b2 != 3) {
                if (b2 == 12) {
                    return 0L;
                }
                throw new g("type mismatch.");
            }
            return this.f35386a.getLong();
        } else {
            b = this.f35386a.getInt();
        }
        return b;
    }

    public final k a(k kVar, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        try {
            k kVar2 = (k) kVar.getClass().newInstance();
            a aVar = new a();
            a(aVar, this.f35386a);
            if (aVar.f35387a == 10) {
                kVar2.a(this);
                a();
                return kVar2;
            }
            throw new g("type mismatch.");
        } catch (Exception e) {
            throw new g(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i, boolean z) {
        boolean z2 = false;
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            if (a((byte) 0, i, z) != 0) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } else if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        } else {
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
                return String.valueOf(b(i, z));
            }
            if (t instanceof Map) {
                return (HashMap) a(new HashMap(), (Map) t, i, z);
            } else if (!(t instanceof List)) {
                if (t instanceof k) {
                    return a((k) t, i, z);
                }
                if (t.getClass().isArray()) {
                    return ((t instanceof byte[]) || (t instanceof Byte[])) ? c(i, z) : t instanceof boolean[] ? d(i, z) : t instanceof short[] ? e(i, z) : t instanceof int[] ? f(i, z) : t instanceof long[] ? g(i, z) : t instanceof float[] ? h(i, z) : t instanceof double[] ? i(i, z) : a((Object[]) t, i, z);
                }
                throw new g("read object error: unsupport type.");
            } else {
                List list = (List) t;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] b = b(list.get(0), i, z);
                if (b == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= b.length) {
                        return arrayList;
                    }
                    arrayList.add(b[i3]);
                    i2 = i3 + 1;
                }
            }
        }
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    public final short a(short s, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b = aVar.f35387a;
        if (b != 0) {
            if (b != 1) {
                if (b == 12) {
                    return (short) 0;
                }
                throw new g("type mismatch.");
            }
            return this.f35386a.getShort();
        }
        return this.f35386a.get();
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f35386a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f35386a = ByteBuffer.wrap(bArr);
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final String b(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b = aVar.f35387a;
        if (b == 6) {
            byte b2 = this.f35386a.get();
            byte b3 = b2;
            if (b2 < 0) {
                b3 = b2 + 256;
            }
            byte[] bArr = new byte[b3];
            this.f35386a.get(bArr);
            try {
                return new String(bArr, this.b);
            } catch (UnsupportedEncodingException e) {
                return new String(bArr);
            }
        } else if (b == 7) {
            int i2 = this.f35386a.getInt();
            if (i2 > 104857600 || i2 < 0) {
                throw new g("String too long: " + i2);
            }
            byte[] bArr2 = new byte[i2];
            this.f35386a.get(bArr2);
            try {
                return new String(bArr2, this.b);
            } catch (UnsupportedEncodingException e2) {
                return new String(bArr2);
            }
        } else {
            throw new g("type mismatch.");
        }
    }

    public final byte[] c(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f35386a);
        byte b = aVar.f35387a;
        if (b != 9) {
            if (b == 13) {
                a aVar2 = new a();
                a(aVar2, this.f35386a);
                if (aVar2.f35387a != 0) {
                    throw new g("type mismatch, tag: " + i + ", type: " + ((int) aVar.f35387a) + ", " + ((int) aVar2.f35387a));
                }
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    byte[] bArr = new byte[a2];
                    this.f35386a.get(bArr);
                    return bArr;
                }
                throw new g("invalid size, tag: " + i + ", type: " + ((int) aVar.f35387a) + ", " + ((int) aVar2.f35387a) + ", size: " + a2);
            }
            throw new g("type mismatch.");
        }
        int a3 = a(0, 0, true);
        if (a3 < 0) {
            throw new g("size invalid: " + a3);
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
}
