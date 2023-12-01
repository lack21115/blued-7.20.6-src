package com.tencent.beacon.pack;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/pack/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f21407a = new byte[0];
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: c  reason: collision with root package name */
    protected String f21408c;
    private ByteBuffer d;

    public b() {
        this(128);
    }

    public b(int i) {
        this.f21408c = "GBK";
        this.d = ByteBuffer.allocate(i);
    }

    private void a(Object[] objArr, int i) {
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
        this.f21408c = str;
        return 0;
    }

    public ByteBuffer a() {
        return this.d;
    }

    public void a(byte b2, int i) {
        a(3);
        if (b2 == 0) {
            b((byte) 12, i);
            return;
        }
        b((byte) 0, i);
        this.d.put(b2);
    }

    public void a(double d, int i) {
        a(10);
        b((byte) 5, i);
        this.d.putDouble(d);
    }

    public void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.d.putFloat(f);
    }

    public void a(int i) {
        if (this.d.remaining() < i) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate((this.d.capacity() + i) * 2);
                allocate.put(this.d.array(), 0, this.d.position());
                this.d = allocate;
            } catch (IllegalArgumentException e) {
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
        this.d.putInt(i);
    }

    public void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
            return;
        }
        b((byte) 3, i);
        this.d.putLong(j);
    }

    public void a(AbstractJceStruct abstractJceStruct, int i) {
        a(2);
        b((byte) 10, i);
        abstractJceStruct.writeTo(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(Object obj, int i) {
        Object obj2 = obj;
        if (obj == null) {
            obj2 = "";
        }
        if (obj2 instanceof Byte) {
            a(((Byte) obj2).byteValue(), i);
        } else if (obj2 instanceof Boolean) {
            a(((Boolean) obj2).booleanValue(), i);
        } else if (obj2 instanceof Short) {
            a(((Short) obj2).shortValue(), i);
        } else if (obj2 instanceof Integer) {
            a(((Integer) obj2).intValue(), i);
        } else if (obj2 instanceof Long) {
            a(((Long) obj2).longValue(), i);
        } else if (obj2 instanceof Float) {
            a(((Float) obj2).floatValue(), i);
        } else if (obj2 instanceof Double) {
            a(((Double) obj2).doubleValue(), i);
        } else if (obj2 instanceof String) {
            a((String) obj2, i);
        } else if (obj2 instanceof Map) {
            a((Map) obj2, i);
        } else if (obj2 instanceof List) {
            a((Collection) ((List) obj2), i);
        } else if (obj2 instanceof AbstractJceStruct) {
            a((AbstractJceStruct) obj2, i);
        } else if (obj2 instanceof byte[]) {
            a((byte[]) obj2, i);
        } else if (obj2 instanceof boolean[]) {
            a((boolean[]) obj2, i);
        } else if (obj2 instanceof short[]) {
            a((short[]) obj2, i);
        } else if (obj2 instanceof int[]) {
            a((int[]) obj2, i);
        } else if (obj2 instanceof long[]) {
            a((long[]) obj2, i);
        } else if (obj2 instanceof float[]) {
            a((float[]) obj2, i);
        } else if (obj2 instanceof double[]) {
            a((double[]) obj2, i);
        } else if (obj2.getClass().isArray()) {
            a((Object[]) obj2, i);
        } else if (obj2 instanceof Collection) {
            a((Collection) obj2, i);
        } else {
            throw new RuntimeException("write object error: unsupport type. " + obj2.getClass());
        }
    }

    public void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f21408c);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes(Charset.forName("UTF-8"));
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.d.putInt(bytes.length);
            this.d.put(bytes);
            return;
        }
        b((byte) 6, i);
        this.d.put((byte) bytes.length);
        this.d.put(bytes);
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
        this.d.putShort(s);
    }

    public void a(boolean z, int i) {
        a(z ? (byte) 1 : (byte) 0, i);
    }

    public void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.d.put(bArr);
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

    public void b(byte b2, int i) {
        if (i < 15) {
            this.d.put((byte) (b2 | (i << 4)));
        } else if (i < 256) {
            this.d.put((byte) (b2 | 240));
            this.d.put((byte) i);
        } else {
            throw new RuntimeException("tag is too large: " + i);
        }
    }

    public byte[] b() {
        byte[] bArr = new byte[this.d.position()];
        System.arraycopy(this.d.array(), 0, bArr, 0, this.d.position());
        return bArr;
    }
}
