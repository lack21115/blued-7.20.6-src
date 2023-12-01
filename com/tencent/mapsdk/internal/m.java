package com.tencent.mapsdk.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f23933a;
    public String b = "GBK";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/m$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f23934a;
        public int b;

        public void a() {
            this.f23934a = (byte) 0;
            this.b = 0;
        }
    }

    public m() {
    }

    public m(ByteBuffer byteBuffer) {
        this.f23933a = byteBuffer;
    }

    public m(byte[] bArr) {
        this.f23933a = ByteBuffer.wrap(bArr);
    }

    public m(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f23933a = wrap;
        wrap.position(i);
    }

    private int a(a aVar) {
        return a(aVar, this.f23933a.duplicate());
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.f23934a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        aVar.b = i;
        if (i == 15) {
            aVar.b = byteBuffer.get() & 255;
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
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 8) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= a2) {
                    break;
                }
                map.put(a((m) key, 0, true), a((m) value, 1, true));
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new j("require field not exist.");
        }
        return map;
    }

    private void a(byte b) {
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
                byte b2 = this.f23933a.get();
                byte b3 = b2;
                if (b2 < 0) {
                    b3 = b2 + 256;
                }
                a(b3);
                return;
            case 7:
                a(this.f23933a.getInt());
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
                c();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                b(aVar);
                if (aVar.f23934a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new j("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar.f23934a));
            default:
                throw new j("invalid type.");
        }
    }

    private void a(int i) {
        ByteBuffer byteBuffer = this.f23933a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    private void b() {
        a aVar = new a();
        b(aVar);
        a(aVar.f23934a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        b(aVar);
        if (aVar.f23934a != 9) {
            throw new j("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new j("size invalid: " + a2);
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2) {
                return tArr;
            }
            tArr[i3] = a((m) t, 0, true);
            i2 = i3 + 1;
        }
    }

    public byte a(byte b, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        b(aVar);
        byte b2 = aVar.f23934a;
        if (b2 != 0) {
            if (b2 == 12) {
                return (byte) 0;
            }
            throw new j("type mismatch.");
        }
        return this.f23933a.get();
    }

    public double a(double d, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return d;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b != 4) {
            if (b != 5) {
                if (b == 12) {
                    return 0.0d;
                }
                throw new j("type mismatch.");
            }
            return this.f23933a.getDouble();
        }
        return this.f23933a.getFloat();
    }

    public float a(float f, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return f;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new j("type mismatch.");
        }
        return this.f23933a.getFloat();
    }

    public int a(int i, int i2, boolean z) {
        if (!b(i2)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return i;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 12) {
                        return 0;
                    }
                    throw new j("type mismatch.");
                }
                return this.f23933a.getInt();
            }
            return this.f23933a.getShort();
        }
        return this.f23933a.get();
    }

    public int a(String str) {
        this.b = str;
        return 0;
    }

    public long a(long j, int i, boolean z) {
        byte b;
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return j;
        }
        a aVar = new a();
        b(aVar);
        byte b2 = aVar.f23934a;
        if (b2 != 12) {
            if (b2 == 0) {
                b = this.f23933a.get();
            } else if (b2 == 1) {
                b = this.f23933a.getShort();
            } else if (b2 != 2) {
                if (b2 == 3) {
                    return this.f23933a.getLong();
                }
                throw new j("type mismatch.");
            } else {
                b = this.f23933a.getInt();
            }
            return b;
        }
        return 0L;
    }

    public p a(p pVar, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return null;
        }
        try {
            p newInit = pVar.newInit();
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a == 10) {
                newInit.readFrom(this);
                c();
                return newInit;
            }
            throw new j("type mismatch.");
        } catch (Exception e) {
            throw new j(e.getMessage());
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
            return b(i, z);
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof p) {
            return b((p) t, i, z);
        }
        if (t.getClass().isArray()) {
            return ((t instanceof byte[]) || (t instanceof Byte[])) ? a((byte[]) null, i, z) : t instanceof boolean[] ? a((boolean[]) null, i, z) : t instanceof short[] ? a((short[]) null, i, z) : t instanceof int[] ? a((int[]) null, i, z) : t instanceof long[] ? a((long[]) null, i, z) : t instanceof float[] ? a((float[]) null, i, z) : t instanceof double[] ? a((double[]) null, i, z) : a((Object[]) t, i, z);
        }
        throw new j("read object error: unsupport type.");
    }

    public String a(String str, int i, boolean z) {
        String str2;
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return str;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b == 6) {
            byte b2 = this.f23933a.get();
            byte b3 = b2;
            if (b2 < 0) {
                b3 = b2 + 256;
            }
            byte[] bArr = new byte[b3];
            this.f23933a.get(bArr);
            try {
                str2 = new String(bArr, this.b);
            } catch (UnsupportedEncodingException e) {
                str2 = new String(bArr);
            }
        } else if (b != 7) {
            throw new j("type mismatch.");
        } else {
            int i2 = this.f23933a.getInt();
            if (i2 > 104857600 || i2 < 0 || i2 > this.f23933a.capacity()) {
                throw new j("String too long: " + i2);
            }
            byte[] bArr2 = new byte[i2];
            this.f23933a.get(bArr2);
            try {
                str2 = new String(bArr2, this.b);
            } catch (UnsupportedEncodingException e2) {
                str2 = new String(bArr2);
            }
        }
        return str2;
    }

    public ByteBuffer a() {
        return this.f23933a;
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    public List a(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 9) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < a2) {
                    a aVar2 = new a();
                    b(aVar2);
                    switch (aVar2.f23934a) {
                        case 0:
                            a(1);
                            break;
                        case 1:
                            a(2);
                            break;
                        case 2:
                            a(4);
                            break;
                        case 3:
                            a(8);
                            break;
                        case 4:
                            a(4);
                            break;
                        case 5:
                            a(8);
                            break;
                        case 6:
                            byte b = this.f23933a.get();
                            byte b2 = b;
                            if (b < 0) {
                                b2 = b + 256;
                            }
                            a(b2);
                            break;
                        case 7:
                            a(this.f23933a.getInt());
                            break;
                        case 8:
                        case 9:
                            break;
                        case 10:
                            try {
                                p pVar = (p) Class.forName(p.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                                pVar.readFrom(this);
                                c();
                                arrayList.add(pVar);
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                throw new j("type mismatch." + e);
                            }
                        case 11:
                        default:
                            throw new j("type mismatch.");
                        case 12:
                            arrayList.add(new Integer(0));
                            break;
                    }
                    i2 = i3 + 1;
                }
            }
        } else if (z) {
            throw new j("require field not exist.");
        }
        return arrayList;
    }

    public <T> List<T> a(List<T> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] b = b((m) list.get(0), i, z);
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
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b != 0) {
            if (b != 1) {
                if (b == 12) {
                    return (short) 0;
                }
                throw new j("type mismatch.");
            }
            return this.f23933a.getShort();
        }
        return this.f23933a.get();
    }

    public void a(byte[] bArr) {
        b(bArr);
    }

    public boolean a(boolean z, int i, boolean z2) {
        boolean z3 = false;
        if (a((byte) 0, i, z2) != 0) {
            z3 = true;
        }
        return z3;
    }

    public byte[] a(byte[] bArr, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b != 9) {
            if (b == 13) {
                a aVar2 = new a();
                b(aVar2);
                if (aVar2.f23934a != 0) {
                    throw new j("type mismatch, tag: " + i + ", type: " + ((int) aVar.f23934a) + ", " + ((int) aVar2.f23934a));
                }
                int a2 = a(0, 0, true);
                if (a2 >= 0 && a2 <= this.f23933a.capacity()) {
                    byte[] bArr2 = new byte[a2];
                    this.f23933a.get(bArr2);
                    return bArr2;
                }
                throw new j("invalid size, tag: " + i + ", type: " + ((int) aVar.f23934a) + ", " + ((int) aVar2.f23934a) + ", size: " + a2);
            }
            throw new j("type mismatch.");
        }
        int a3 = a(0, 0, true);
        if (a3 < 0 || a3 > this.f23933a.capacity()) {
            throw new j("size invalid: " + a3);
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
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 9) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
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
            throw new j("require field not exist.");
        } else {
            dArr2 = null;
        }
        return dArr2;
    }

    public float[] a(float[] fArr, int i, boolean z) {
        float[] fArr2;
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 9) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
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
            throw new j("require field not exist.");
        } else {
            fArr2 = null;
        }
        return fArr2;
    }

    public int[] a(int[] iArr, int i, boolean z) {
        int[] iArr2;
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 9) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
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
            throw new j("require field not exist.");
        } else {
            iArr2 = null;
        }
        return iArr2;
    }

    public long[] a(long[] jArr, int i, boolean z) {
        long[] jArr2;
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 9) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
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
            throw new j("require field not exist.");
        } else {
            jArr2 = null;
        }
        return jArr2;
    }

    public p[] a(p[] pVarArr, int i, boolean z) {
        return (p[]) a((Object[]) pVarArr, i, z);
    }

    public <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new j("unable to get type of key and value.");
        }
        return (T[]) b((m) tArr[0], i, z);
    }

    public String[] a(String[] strArr, int i, boolean z) {
        return (String[]) a((Object[]) strArr, i, z);
    }

    public short[] a(short[] sArr, int i, boolean z) {
        short[] sArr2;
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 9) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
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
            throw new j("require field not exist.");
        } else {
            sArr2 = null;
        }
        return sArr2;
    }

    public boolean[] a(boolean[] zArr, int i, boolean z) {
        boolean[] zArr2;
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 9) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
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
            throw new j("require field not exist.");
        } else {
            zArr2 = null;
        }
        return zArr2;
    }

    public p b(p pVar, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return null;
        }
        try {
            p pVar2 = (p) pVar.getClass().newInstance();
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a == 10) {
                pVar2.readFrom(this);
                c();
                return pVar2;
            }
            throw new j("type mismatch.");
        } catch (Exception e) {
            throw new j(e.getMessage());
        }
    }

    public String b(int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b == 6) {
            byte b2 = this.f23933a.get();
            byte b3 = b2;
            if (b2 < 0) {
                b3 = b2 + 256;
            }
            byte[] bArr = new byte[b3];
            this.f23933a.get(bArr);
            try {
                return new String(bArr, this.b);
            } catch (UnsupportedEncodingException e) {
                return new String(bArr);
            }
        } else if (b == 7) {
            int i2 = this.f23933a.getInt();
            if (i2 > 104857600 || i2 < 0 || i2 > this.f23933a.capacity()) {
                throw new j("String too long: " + i2);
            }
            byte[] bArr2 = new byte[i2];
            this.f23933a.get(bArr2);
            try {
                return new String(bArr2, this.b);
            } catch (UnsupportedEncodingException e2) {
                return new String(bArr2);
            }
        } else {
            throw new j("type mismatch.");
        }
    }

    public String b(String str, int i, boolean z) {
        if (!b(i)) {
            if (z) {
                throw new j("require field not exist.");
            }
            return str;
        }
        a aVar = new a();
        b(aVar);
        byte b = aVar.f23934a;
        if (b == 6) {
            byte b2 = this.f23933a.get();
            byte b3 = b2;
            if (b2 < 0) {
                b3 = b2 + 256;
            }
            byte[] bArr = new byte[b3];
            this.f23933a.get(bArr);
            return i.a(bArr);
        } else if (b == 7) {
            int i2 = this.f23933a.getInt();
            if (i2 <= 104857600 && i2 >= 0 && i2 <= this.f23933a.capacity()) {
                byte[] bArr2 = new byte[i2];
                this.f23933a.get(bArr2);
                return i.a(bArr2);
            }
            throw new j("String too long: " + i2);
        } else {
            throw new j("type mismatch.");
        }
    }

    public void b(a aVar) {
        a(aVar, this.f23933a);
    }

    public void b(byte[] bArr) {
        this.f23933a = ByteBuffer.wrap(bArr);
    }

    public boolean b(int i) {
        int i2;
        boolean z = false;
        try {
            a aVar = new a();
            while (true) {
                int a2 = a(aVar);
                i2 = aVar.b;
                if (i <= i2 || aVar.f23934a == 11) {
                    break;
                }
                a(a2);
                a(aVar.f23934a);
            }
            if (aVar.f23934a == 11) {
                return false;
            }
            if (i == i2) {
                z = true;
            }
            return z;
        } catch (j | BufferUnderflowException e) {
            return false;
        }
    }

    public Map<String, String> c(int i, boolean z) {
        HashMap hashMap = new HashMap();
        if (b(i)) {
            a aVar = new a();
            b(aVar);
            if (aVar.f23934a != 8) {
                throw new j("type mismatch.");
            }
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new j("size invalid: " + a2);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= a2) {
                    break;
                }
                hashMap.put(b(0, true), b(1, true));
                i2 = i3 + 1;
            }
        } else if (z) {
            throw new j("require field not exist.");
        }
        return hashMap;
    }

    public void c() {
        a aVar = new a();
        do {
            b(aVar);
            a(aVar.f23934a);
        } while (aVar.f23934a != 11);
    }
}
