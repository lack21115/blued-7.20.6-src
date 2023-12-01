package com.tencent.tmsbeacon.pack;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/pack/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f39601a = "GBK";
    private ByteBuffer b;

    /* renamed from: com.tencent.tmsbeacon.pack.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/pack/a$a.class */
    public static class C1035a {

        /* renamed from: a  reason: collision with root package name */
        public byte f39602a;
        public int b;
    }

    public a() {
    }

    public a(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    public a(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b = wrap;
        wrap.position(i);
    }

    public static int a(C1035a c1035a, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c1035a.f39602a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        c1035a.b = i;
        if (i == 15) {
            c1035a.b = byteBuffer.get() & 255;
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
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a != 8) {
                throw new RuntimeException("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new RuntimeException("size invalid: " + a2);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= a2) {
                    break;
                }
                map.put(a((a) key, 0, true), a((a) value, 1, true));
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return map;
    }

    private void a(byte b) {
        switch (b) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
                b(4);
                return;
            case 3:
                b(8);
                return;
            case 4:
                b(4);
                return;
            case 5:
                b(8);
                return;
            case 6:
                byte b2 = this.b.get();
                byte b3 = b2;
                if (b2 < 0) {
                    b3 = b2 + 256;
                }
                b(b3);
                return;
            case 7:
                b(this.b.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a2 * 2) {
                        return;
                    }
                    b();
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
                    b();
                    i3 = i4 + 1;
                }
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                C1035a c1035a = new C1035a();
                a(c1035a);
                if (c1035a.f39602a == 0) {
                    b(a(0, 0, true));
                    return;
                }
                throw new RuntimeException("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) c1035a.f39602a));
            default:
                throw new RuntimeException("invalid type.");
        }
    }

    private int b(C1035a c1035a) {
        return a(c1035a, this.b.duplicate());
    }

    private void b() {
        C1035a c1035a = new C1035a();
        a(c1035a);
        a(c1035a.f39602a);
    }

    private void b(int i) {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        if (c1035a.f39602a != 9) {
            throw new RuntimeException("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new RuntimeException("size invalid: " + a2);
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2) {
                return tArr;
            }
            tArr[i3] = a((a) t, 0, true);
            i2 = i3 + 1;
        }
    }

    public byte a(byte b, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return b;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b2 = c1035a.f39602a;
        if (b2 != 0) {
            if (b2 == 12) {
                return (byte) 0;
            }
            throw new RuntimeException("type mismatch.");
        }
        return this.b.get();
    }

    public double a(double d, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return d;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b = c1035a.f39602a;
        if (b != 4) {
            if (b != 5) {
                if (b == 12) {
                    return 0.0d;
                }
                throw new RuntimeException("type mismatch.");
            }
            return this.b.getDouble();
        }
        return this.b.getFloat();
    }

    public float a(float f, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return f;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b = c1035a.f39602a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new RuntimeException("type mismatch.");
        }
        return this.b.getFloat();
    }

    public int a(int i, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return i;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b = c1035a.f39602a;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 12) {
                        return 0;
                    }
                    throw new RuntimeException("type mismatch.");
                }
                return this.b.getInt();
            }
            return this.b.getShort();
        }
        return this.b.get();
    }

    public int a(String str) {
        this.f39601a = str;
        return 0;
    }

    public long a(long j, int i, boolean z) {
        byte b;
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return j;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b2 = c1035a.f39602a;
        if (b2 != 12) {
            if (b2 == 0) {
                b = this.b.get();
            } else if (b2 == 1) {
                b = this.b.getShort();
            } else if (b2 != 2) {
                if (b2 == 3) {
                    return this.b.getLong();
                }
                throw new RuntimeException("type mismatch.");
            } else {
                b = this.b.getInt();
            }
            return b;
        }
        return 0L;
    }

    public AbstractJceStruct a(AbstractJceStruct abstractJceStruct, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        try {
            AbstractJceStruct abstractJceStruct2 = (AbstractJceStruct) abstractJceStruct.getClass().newInstance();
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a == 10) {
                abstractJceStruct2.readFrom(this);
                a();
                return abstractJceStruct2;
            }
            throw new RuntimeException("type mismatch.");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t, int i, boolean z) {
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
            return a(i, z);
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof AbstractJceStruct) {
            return a((AbstractJceStruct) t, i, z);
        }
        if (t.getClass().isArray()) {
            return ((t instanceof byte[]) || (t instanceof Byte[])) ? a((byte[]) null, i, z) : t instanceof boolean[] ? a((boolean[]) null, i, z) : t instanceof short[] ? a((short[]) null, i, z) : t instanceof int[] ? a((int[]) null, i, z) : t instanceof long[] ? a((long[]) null, i, z) : t instanceof float[] ? a((float[]) null, i, z) : t instanceof double[] ? a((double[]) null, i, z) : a((Object[]) t, i, z);
        }
        throw new RuntimeException("read object error: unsupport type.");
    }

    public String a(int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b = c1035a.f39602a;
        if (b == 6) {
            byte b2 = this.b.get();
            byte b3 = b2;
            if (b2 < 0) {
                b3 = b2 + 256;
            }
            byte[] bArr = new byte[b3];
            this.b.get(bArr);
            try {
                return new String(bArr, this.f39601a);
            } catch (UnsupportedEncodingException e) {
                return new String(bArr, Charset.forName("UTF-8"));
            }
        } else if (b == 7) {
            int i2 = this.b.getInt();
            if (i2 > 104857600 || i2 < 0 || i2 > this.b.capacity()) {
                throw new RuntimeException("String too long: " + i2);
            }
            byte[] bArr2 = new byte[i2];
            this.b.get(bArr2);
            try {
                return new String(bArr2, this.f39601a);
            } catch (UnsupportedEncodingException e2) {
                return new String(bArr2, Charset.forName("UTF-8"));
            }
        } else {
            throw new RuntimeException("type mismatch.");
        }
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    public <T> List<T> a(List<T> list, int i, boolean z) {
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

    public short a(short s, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return s;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b = c1035a.f39602a;
        if (b != 0) {
            if (b != 1) {
                if (b == 12) {
                    return (short) 0;
                }
                throw new RuntimeException("type mismatch.");
            }
            return this.b.getShort();
        }
        return this.b.get();
    }

    public void a() {
        C1035a c1035a = new C1035a();
        do {
            a(c1035a);
            a(c1035a.f39602a);
        } while (c1035a.f39602a != 11);
    }

    public void a(C1035a c1035a) {
        a(c1035a, this.b);
    }

    public void a(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    public boolean a(int i) {
        try {
            C1035a c1035a = new C1035a();
            while (true) {
                int b = b(c1035a);
                if (c1035a.f39602a == 11) {
                    return false;
                }
                int i2 = c1035a.b;
                if (i <= i2) {
                    return i == i2;
                }
                b(b);
                a(c1035a.f39602a);
            }
        } catch (BufferUnderflowException e) {
            com.tencent.tmsbeacon.base.util.c.a(e);
            return false;
        } catch (RuntimeException e2) {
            com.tencent.tmsbeacon.base.util.c.a(e2);
            return false;
        }
    }

    public boolean a(boolean z, int i, boolean z2) {
        boolean z3 = false;
        if (a((byte) 0, i, z2) != 0) {
            z3 = true;
        }
        return z3;
    }

    public byte[] a(byte[] bArr, int i, boolean z) {
        if (!a(i)) {
            if (z) {
                throw new RuntimeException("require field not exist.");
            }
            return null;
        }
        C1035a c1035a = new C1035a();
        a(c1035a);
        byte b = c1035a.f39602a;
        if (b != 9) {
            if (b == 13) {
                C1035a c1035a2 = new C1035a();
                a(c1035a2);
                if (c1035a2.f39602a != 0) {
                    throw new RuntimeException("type mismatch, tag: " + i + ", type: " + ((int) c1035a.f39602a) + ", " + ((int) c1035a2.f39602a));
                }
                int a2 = a(0, 0, true);
                if (a2 >= 0 && a2 <= this.b.capacity()) {
                    byte[] bArr2 = new byte[a2];
                    this.b.get(bArr2);
                    return bArr2;
                }
                throw new RuntimeException("invalid size, tag: " + i + ", type: " + ((int) c1035a.f39602a) + ", " + ((int) c1035a2.f39602a) + ", size: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        }
        int a3 = a(0, 0, true);
        if (a3 < 0 || a3 > this.b.capacity()) {
            throw new RuntimeException("size invalid: " + a3);
        }
        byte[] bArr3 = new byte[a3];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a3) {
                return bArr3;
            }
            bArr3[i3] = a(bArr3[0], 0, true);
            i2 = i3 + 1;
        }
    }

    public double[] a(double[] dArr, int i, boolean z) {
        double[] dArr2;
        if (a(i)) {
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a != 9) {
                throw new RuntimeException("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new RuntimeException("size invalid: " + a2);
            }
            double[] dArr3 = new double[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                dArr2 = dArr3;
                if (i3 >= a2) {
                    break;
                }
                dArr3[i3] = a(dArr3[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        } else {
            dArr2 = null;
        }
        return dArr2;
    }

    public float[] a(float[] fArr, int i, boolean z) {
        float[] fArr2;
        if (a(i)) {
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a != 9) {
                throw new RuntimeException("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new RuntimeException("size invalid: " + a2);
            }
            float[] fArr3 = new float[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                fArr2 = fArr3;
                if (i3 >= a2) {
                    break;
                }
                fArr3[i3] = a(fArr3[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        } else {
            fArr2 = null;
        }
        return fArr2;
    }

    public int[] a(int[] iArr, int i, boolean z) {
        int[] iArr2;
        if (a(i)) {
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a != 9) {
                throw new RuntimeException("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new RuntimeException("size invalid: " + a2);
            }
            int[] iArr3 = new int[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                iArr2 = iArr3;
                if (i3 >= a2) {
                    break;
                }
                iArr3[i3] = a(iArr3[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        } else {
            iArr2 = null;
        }
        return iArr2;
    }

    public long[] a(long[] jArr, int i, boolean z) {
        long[] jArr2;
        if (a(i)) {
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a != 9) {
                throw new RuntimeException("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new RuntimeException("size invalid: " + a2);
            }
            long[] jArr3 = new long[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                jArr2 = jArr3;
                if (i3 >= a2) {
                    break;
                }
                jArr3[i3] = a(jArr3[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        } else {
            jArr2 = null;
        }
        return jArr2;
    }

    public <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new RuntimeException("unable to get type of key and value.");
        }
        return (T[]) b(tArr[0], i, z);
    }

    public short[] a(short[] sArr, int i, boolean z) {
        short[] sArr2;
        if (a(i)) {
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a != 9) {
                throw new RuntimeException("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new RuntimeException("size invalid: " + a2);
            }
            short[] sArr3 = new short[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                sArr2 = sArr3;
                if (i3 >= a2) {
                    break;
                }
                sArr3[i3] = a(sArr3[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        } else {
            sArr2 = null;
        }
        return sArr2;
    }

    public boolean[] a(boolean[] zArr, int i, boolean z) {
        boolean[] zArr2;
        if (a(i)) {
            C1035a c1035a = new C1035a();
            a(c1035a);
            if (c1035a.f39602a != 9) {
                throw new RuntimeException("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new RuntimeException("size invalid: " + a2);
            }
            boolean[] zArr3 = new boolean[a2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                zArr2 = zArr3;
                if (i3 >= a2) {
                    break;
                }
                zArr3[i3] = a(zArr3[0], 0, true);
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        } else {
            zArr2 = null;
        }
        return zArr2;
    }
}
