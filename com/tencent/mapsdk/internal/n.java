package com.tencent.mapsdk.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f23961a;
    private r b;

    /* renamed from: c  reason: collision with root package name */
    public String f23962c;

    public n() {
        this(128);
    }

    public n(int i) {
        this.f23962c = "GBK";
        this.f23961a = ByteBuffer.allocate(i);
    }

    public n(ByteBuffer byteBuffer) {
        this.f23962c = "GBK";
        this.f23961a = byteBuffer;
    }

    private void b(Object[] objArr, int i) {
        a(8);
        b((byte) 9, i);
        a(objArr.length, 0);
        int length = objArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(objArr[i3], 0);
            i2 = i3 + 1;
        }
    }

    public int a(String str) {
        this.f23962c = str;
        return 0;
    }

    public ByteBuffer a() {
        return this.f23961a;
    }

    public void a(byte b, int i) {
        a(3);
        if (b == 0) {
            b((byte) 12, i);
            return;
        }
        b((byte) 0, i);
        this.f23961a.put(b);
    }

    public void a(double d, int i) {
        a(10);
        b((byte) 5, i);
        this.f23961a.putDouble(d);
    }

    public void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.f23961a.putFloat(f);
    }

    public void a(int i) {
        if (this.f23961a.remaining() < i) {
            int capacity = (this.f23961a.capacity() + i) * 2;
            try {
                ByteBuffer allocate = ByteBuffer.allocate(capacity);
                allocate.put(this.f23961a.array(), 0, this.f23961a.position());
                this.f23961a = allocate;
            } catch (IllegalArgumentException e) {
                r rVar = this.b;
                if (rVar != null) {
                    rVar.a(e, this.f23961a, i, capacity);
                }
                throw e;
            }
        }
    }

    public void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
            return;
        }
        b((byte) 2, i2);
        this.f23961a.putInt(i);
    }

    public void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
            return;
        }
        b((byte) 3, i);
        this.f23961a.putLong(j);
    }

    public void a(p pVar, int i) {
        a(2);
        b((byte) 10, i);
        pVar.writeTo(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(r rVar) {
        this.b = rVar;
    }

    public void a(Boolean bool, int i) {
        a(bool.booleanValue(), i);
    }

    public void a(Byte b, int i) {
        a(b.byteValue(), i);
    }

    public void a(Double d, int i) {
        a(d.doubleValue(), i);
    }

    public void a(Float f, int i) {
        a(f.floatValue(), i);
    }

    public void a(Integer num, int i) {
        a(num.intValue(), i);
    }

    public void a(Long l, int i) {
        a(l.longValue(), i);
    }

    public void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i);
        } else if (obj instanceof p) {
            a((p) obj, i);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            a((short[]) obj, i);
        } else if (obj instanceof int[]) {
            a((int[]) obj, i);
        } else if (obj instanceof long[]) {
            a((long[]) obj, i);
        } else if (obj instanceof float[]) {
            a((float[]) obj, i);
        } else if (obj instanceof double[]) {
            a((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            b((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            throw new l("write object error: unsupport type. " + obj.getClass());
        }
    }

    public void a(Short sh, int i) {
        a(sh.shortValue(), i);
    }

    public void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f23962c);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.f23961a.putInt(bytes.length);
            this.f23961a.put(bytes);
            return;
        }
        b((byte) 6, i);
        this.f23961a.put((byte) bytes.length);
        this.f23961a.put(bytes);
    }

    public <T> void a(Collection<T> collection, int i) {
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                a(t, 0);
            }
        }
    }

    public <K, V> void a(Map<K, V> map, int i) {
        a(8);
        b((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i);
            return;
        }
        b((byte) 1, i);
        this.f23961a.putShort(s);
    }

    public void a(boolean z, int i) {
        a(z ? (byte) 1 : (byte) 0, i);
    }

    public void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f23961a.put(bArr);
    }

    public void a(double[] dArr, int i) {
        a(8);
        b((byte) 9, i);
        a(dArr.length, 0);
        int length = dArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(dArr[i3], 0);
            i2 = i3 + 1;
        }
    }

    public void a(float[] fArr, int i) {
        a(8);
        b((byte) 9, i);
        a(fArr.length, 0);
        int length = fArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(fArr[i3], 0);
            i2 = i3 + 1;
        }
    }

    public void a(int[] iArr, int i) {
        a(8);
        b((byte) 9, i);
        a(iArr.length, 0);
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(iArr[i3], 0);
            i2 = i3 + 1;
        }
    }

    public void a(long[] jArr, int i) {
        a(8);
        b((byte) 9, i);
        a(jArr.length, 0);
        int length = jArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(jArr[i3], 0);
            i2 = i3 + 1;
        }
    }

    public <T> void a(T[] tArr, int i) {
        b(tArr, i);
    }

    public void a(short[] sArr, int i) {
        a(8);
        b((byte) 9, i);
        a(sArr.length, 0);
        int length = sArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(sArr[i3], 0);
            i2 = i3 + 1;
        }
    }

    public void a(boolean[] zArr, int i) {
        a(8);
        b((byte) 9, i);
        a(zArr.length, 0);
        int length = zArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            a(zArr[i3], 0);
            i2 = i3 + 1;
        }
    }

    public r b() {
        return this.b;
    }

    public void b(byte b, int i) {
        if (i < 15) {
            this.f23961a.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.f23961a.put((byte) (b | 240));
            this.f23961a.put((byte) i);
        } else {
            throw new l("tag is too large: " + i);
        }
    }

    public void b(String str, int i) {
        a(str.length() + 10);
        byte[] b = i.b(str);
        if (b.length > 255) {
            b((byte) 7, i);
            this.f23961a.putInt(b.length);
            this.f23961a.put(b);
            return;
        }
        b((byte) 6, i);
        this.f23961a.put((byte) b.length);
        this.f23961a.put(b);
    }

    public void c(String str, int i) {
        byte[] b = i.b(str);
        a(b.length + 10);
        if (b.length > 255) {
            b((byte) 7, i);
            this.f23961a.putInt(b.length);
            this.f23961a.put(b);
            return;
        }
        b((byte) 6, i);
        this.f23961a.put((byte) b.length);
        this.f23961a.put(b);
    }

    public byte[] c() {
        byte[] bArr = new byte[this.f23961a.position()];
        System.arraycopy(this.f23961a.array(), 0, bArr, 0, this.f23961a.position());
        return bArr;
    }
}
