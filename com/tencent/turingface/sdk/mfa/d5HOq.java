package com.tencent.turingface.sdk.mfa;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/d5HOq.class */
public final class d5HOq {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f39942a;
    public String b = "GBK";

    public d5HOq(int i) {
        this.f39942a = ByteBuffer.allocate(i);
    }

    public final void a(byte b, int i) {
        a(3);
        if (b == 0) {
            b((byte) 12, i);
            return;
        }
        b((byte) 0, i);
        this.f39942a.put(b);
    }

    public final void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.f39942a.putFloat(f);
    }

    public final void a(int i) {
        if (this.f39942a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f39942a.capacity() + i) * 2);
            allocate.put(this.f39942a.array(), 0, this.f39942a.position());
            this.f39942a = allocate;
        }
    }

    public final void a(int i, int i2) {
        a(6);
        if (i >= -32768 && i <= 32767) {
            a((short) i, i2);
            return;
        }
        b((byte) 2, i2);
        this.f39942a.putInt(i);
    }

    public final void a(long j, int i) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i);
            return;
        }
        b((byte) 3, i);
        this.f39942a.putLong(j);
    }

    public final void a(ucT3w uct3w, int i) {
        a(2);
        b((byte) 10, i);
        uct3w.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i);
            this.f39942a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i);
        } else if (obj instanceof ucT3w) {
            a((ucT3w) obj, i);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
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
                a(zArr[i3] ? (byte) 1 : (byte) 0, 0);
                i2 = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i);
            a(sArr.length, 0);
            int length2 = sArr.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    return;
                }
                a(sArr[i5], 0);
                i4 = i5 + 1;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i);
            a(iArr.length, 0);
            int length3 = iArr.length;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= length3) {
                    return;
                }
                a(iArr[i7], 0);
                i6 = i7 + 1;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i);
            a(jArr.length, 0);
            int length4 = jArr.length;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= length4) {
                    return;
                }
                a(jArr[i9], 0);
                i8 = i9 + 1;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i);
            a(fArr.length, 0);
            int length5 = fArr.length;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= length5) {
                    return;
                }
                a(fArr[i11], 0);
                i10 = i11 + 1;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i);
            a(dArr.length, 0);
            int length6 = dArr.length;
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 >= length6) {
                    return;
                }
                double d = dArr[i13];
                a(10);
                b((byte) 5, 0);
                this.f39942a.putDouble(d);
                i12 = i13 + 1;
            }
        } else if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                a((Collection) obj, i);
                return;
            }
            StringBuilder b = com.tencent.turingcam.oqKCa.b("write object error: unsupport type. ");
            b.append(obj.getClass());
            throw new yiZAu(b.toString());
        } else {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i);
            a(objArr.length, 0);
            int length7 = objArr.length;
            int i14 = 0;
            while (true) {
                int i15 = i14;
                if (i15 >= length7) {
                    return;
                }
                a(objArr[i15], 0);
                i14 = i15 + 1;
            }
        }
    }

    public final void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.f39942a.putInt(bytes.length);
            this.f39942a.put(bytes);
            return;
        }
        b((byte) 6, i);
        this.f39942a.put((byte) bytes.length);
        this.f39942a.put(bytes);
    }

    public final <T> void a(Collection<T> collection, int i) {
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                a(t, 0);
            }
        }
    }

    public final <K, V> void a(Map<K, V> map, int i) {
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

    public final void a(short s, int i) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i);
            return;
        }
        b((byte) 1, i);
        this.f39942a.putShort(s);
    }

    public final void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f39942a.put(bArr);
    }

    public final void b(byte b, int i) {
        if (i < 15) {
            this.f39942a.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.f39942a.put((byte) (b | 240));
            this.f39942a.put((byte) i);
        } else {
            throw new yiZAu("tag is too large: " + i);
        }
    }
}
