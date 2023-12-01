package com.tencent.bugly.idasc.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    protected String f35323a = "GBK";
    private ByteBuffer b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f35324a;
        public int b;
    }

    public k() {
    }

    public k(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    public k(byte[] bArr, byte b) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b = wrap;
        wrap.position(4);
    }

    private double a(double d, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return d;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f35324a;
        if (b != 4) {
            if (b != 5) {
                if (b == 12) {
                    return 0.0d;
                }
                throw new h("type mismatch.");
            }
            return this.b.getDouble();
        }
        return this.b.getFloat();
    }

    private float a(float f, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return f;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f35324a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new h("type mismatch.");
        }
        return this.b.getFloat();
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f35324a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b == 15) {
            aVar.b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    private <T> List<T> a(List<T> list, int i, boolean z) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a != 8) {
                throw new h("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= a2) {
                    break;
                }
                map.put(a((k) key, 0, true), a((k) value, 1, true));
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new h("require field not exist.");
        }
        return map;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f35324a);
        } while (aVar.f35324a != 11);
    }

    private void a(byte b) {
        int i;
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
                byte b2 = this.b.get();
                byte b3 = b2;
                if (b2 < 0) {
                    b3 = b2 + 256;
                }
                a(b3);
                return;
            case 7:
                i = this.b.getInt();
                break;
            case 8:
                int a2 = a(0, 0, true);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= a2 * 2) {
                        return;
                    }
                    b();
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
                    b();
                    i4 = i5 + 1;
                }
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f35324a != 0) {
                    throw new h("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar.f35324a));
                }
                i = a(0, 0, true);
                break;
            default:
                throw new h("invalid type.");
        }
        a(i);
    }

    private void a(int i) {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(byteBuffer.position() + i);
    }

    private void a(a aVar) {
        a(aVar, this.b);
    }

    private <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new h("unable to get type of key and value.");
        }
        return (T[]) b(tArr[0], i, z);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f35324a);
    }

    private boolean b(int i) {
        try {
            a aVar = new a();
            while (true) {
                int a2 = a(aVar, this.b.duplicate());
                if (i <= aVar.b || aVar.f35324a == 11) {
                    break;
                }
                a(a2);
                a(aVar.f35324a);
            }
            return i == aVar.b;
        } catch (h | BufferUnderflowException e) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f35324a != 9) {
            throw new h("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a2)));
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2) {
                return tArr;
            }
            tArr[i3] = a((k) t, 0, true);
            i2 = i3 + 1;
        }
    }

    private boolean[] d(int i, boolean z) {
        boolean[] zArr;
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a != 9) {
                throw new h("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            boolean[] zArr2 = new boolean[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                zArr = zArr2;
                if (i3 >= a2) {
                    break;
                }
                zArr2[i3] = a(0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new h("require field not exist.");
        } else {
            zArr = null;
        }
        return zArr;
    }

    private short[] e(int i, boolean z) {
        short[] sArr;
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a != 9) {
                throw new h("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a2)));
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
            throw new h("require field not exist.");
        } else {
            sArr = null;
        }
        return sArr;
    }

    private int[] f(int i, boolean z) {
        int[] iArr;
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a != 9) {
                throw new h("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a2)));
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
            throw new h("require field not exist.");
        } else {
            iArr = null;
        }
        return iArr;
    }

    private long[] g(int i, boolean z) {
        long[] jArr;
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a != 9) {
                throw new h("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a2)));
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
            throw new h("require field not exist.");
        } else {
            jArr = null;
        }
        return jArr;
    }

    private float[] h(int i, boolean z) {
        float[] fArr;
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a != 9) {
                throw new h("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a2)));
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
            throw new h("require field not exist.");
        } else {
            fArr = null;
        }
        return fArr;
    }

    private double[] i(int i, boolean z) {
        double[] dArr;
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a != 9) {
                throw new h("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a2)));
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
            throw new h("require field not exist.");
        } else {
            dArr = null;
        }
        return dArr;
    }

    public final byte a(byte b, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f35324a;
        if (b2 != 0) {
            if (b2 == 12) {
                return (byte) 0;
            }
            throw new h("type mismatch.");
        }
        return this.b.get();
    }

    public final int a(int i, int i2, boolean z) {
        if (!b(i2)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return i;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f35324a;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 12) {
                        return 0;
                    }
                    throw new h("type mismatch.");
                }
                return this.b.getInt();
            }
            return this.b.getShort();
        }
        return this.b.get();
    }

    public final int a(String str) {
        this.f35323a = str;
        return 0;
    }

    public final long a(long j, int i, boolean z) {
        byte b;
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return j;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f35324a;
        if (b2 == 0) {
            b = this.b.get();
        } else if (b2 == 1) {
            b = this.b.getShort();
        } else if (b2 != 2) {
            if (b2 != 3) {
                if (b2 == 12) {
                    return 0L;
                }
                throw new h("type mismatch.");
            }
            return this.b.getLong();
        } else {
            b = this.b.getInt();
        }
        return b;
    }

    public final m a(m mVar, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f35324a == 10) {
                mVar2.a(this);
                a();
                return mVar2;
            }
            throw new h("type mismatch.");
        } catch (Exception e) {
            throw new h(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(i, z));
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
            return String.valueOf(b(i, z));
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof m) {
            return a((m) t, i, z);
        }
        if (t.getClass().isArray()) {
            return ((t instanceof byte[]) || (t instanceof Byte[])) ? c(i, z) : t instanceof boolean[] ? d(i, z) : t instanceof short[] ? e(i, z) : t instanceof int[] ? f(i, z) : t instanceof long[] ? g(i, z) : t instanceof float[] ? h(i, z) : t instanceof double[] ? i(i, z) : a((Object[]) t, i, z);
        }
        throw new h("read object error: unsupport type.");
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    public final short a(short s, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f35324a;
        if (b != 0) {
            if (b != 1) {
                if (b == 12) {
                    return (short) 0;
                }
                throw new h("type mismatch.");
            }
            return this.b.getShort();
        }
        return this.b.get();
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.b = ByteBuffer.wrap(bArr);
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final String b(int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f35324a;
        if (b == 6) {
            byte b2 = this.b.get();
            byte b3 = b2;
            if (b2 < 0) {
                b3 = b2 + 256;
            }
            byte[] bArr = new byte[b3];
            this.b.get(bArr);
            try {
                return new String(bArr, this.f35323a);
            } catch (UnsupportedEncodingException e) {
                return new String(bArr);
            }
        } else if (b == 7) {
            int i2 = this.b.getInt();
            if (i2 > 104857600 || i2 < 0) {
                throw new h("String too long: ".concat(String.valueOf(i2)));
            }
            byte[] bArr2 = new byte[i2];
            this.b.get(bArr2);
            try {
                return new String(bArr2, this.f35323a);
            } catch (UnsupportedEncodingException e2) {
                return new String(bArr2);
            }
        } else {
            throw new h("type mismatch.");
        }
    }

    public final byte[] c(int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b = aVar.f35324a;
        if (b != 9) {
            if (b == 13) {
                a aVar2 = new a();
                a(aVar2);
                if (aVar2.f35324a != 0) {
                    throw new h("type mismatch, tag: " + i + ", type: " + ((int) aVar.f35324a) + ", " + ((int) aVar2.f35324a));
                }
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    byte[] bArr = new byte[a2];
                    this.b.get(bArr);
                    return bArr;
                }
                throw new h("invalid size, tag: " + i + ", type: " + ((int) aVar.f35324a) + ", " + ((int) aVar2.f35324a) + ", size: " + a2);
            }
            throw new h("type mismatch.");
        }
        int a3 = a(0, 0, true);
        if (a3 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a3)));
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
