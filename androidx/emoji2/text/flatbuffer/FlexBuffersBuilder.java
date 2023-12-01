package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffersBuilder.class */
public class FlexBuffersBuilder {
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2865a = !FlexBuffersBuilder.class.desiredAssertionStatus();
    private final ReadWriteBuf b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Value> f2866c;
    private final HashMap<String, Integer> d;
    private final HashMap<String, Integer> e;
    private final int f;
    private boolean g;
    private Comparator<Value> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlexBuffersBuilder$Value.class */
    public static class Value {
        static final /* synthetic */ boolean f = !FlexBuffersBuilder.class.desiredAssertionStatus();

        /* renamed from: a  reason: collision with root package name */
        final int f2868a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final double f2869c;
        long d;
        int e;

        Value(int i, int i2, int i3, double d) {
            this.e = i;
            this.f2868a = i2;
            this.b = i3;
            this.f2869c = d;
            this.d = Long.MIN_VALUE;
        }

        Value(int i, int i2, int i3, long j) {
            this.e = i;
            this.f2868a = i2;
            this.b = i3;
            this.d = j;
            this.f2869c = Double.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte a() {
            return a(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte a(int i) {
            return h(b(i), this.f2868a);
        }

        static Value a(int i, double d) {
            return new Value(i, 3, 3, d);
        }

        static Value a(int i, float f2) {
            return new Value(i, 3, 2, f2);
        }

        static Value a(int i, int i2) {
            return new Value(i, 1, 0, i2);
        }

        static Value a(int i, int i2, int i3, int i4) {
            return new Value(i, i3, i4, i2);
        }

        static Value a(int i, long j) {
            return new Value(i, 1, 3, j);
        }

        static Value a(int i, boolean z) {
            return new Value(i, 26, 0, z ? 1L : 0L);
        }

        private int b(int i) {
            return FlexBuffers.b(this.f2868a) ? Math.max(this.b, i) : this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int b(int i, int i2, long j, int i3, int i4) {
            if (FlexBuffers.b(i)) {
                return i2;
            }
            int i5 = 1;
            while (true) {
                int i6 = i5;
                if (i6 > 32) {
                    if (f) {
                        return 3;
                    }
                    throw new AssertionError();
                }
                int a2 = FlexBuffersBuilder.a((int) (((j(i3, i6) + i3) + (i4 * i6)) - j));
                if ((1 << a2) == i6) {
                    return a2;
                }
                i5 = i6 * 2;
            }
        }

        static Value b(int i, int i2) {
            return new Value(i, 1, 1, i2);
        }

        static Value b(int i, long j) {
            return new Value(i, 2, 3, j);
        }

        static Value c(int i, int i2) {
            return new Value(i, 1, 2, i2);
        }

        static Value d(int i, int i2) {
            return new Value(i, 2, 0, i2);
        }

        static Value e(int i, int i2) {
            return new Value(i, 2, 1, i2);
        }

        static Value f(int i, int i2) {
            return new Value(i, 2, 2, i2);
        }

        private static byte h(int i, int i2) {
            return (byte) (i | (i2 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int i(int i, int i2) {
            return b(this.f2868a, this.b, this.d, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int j(int i, int i2) {
            return (i + 1) & (i2 - 1);
        }
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public FlexBuffersBuilder(int i) {
        this(new ArrayReadWriteBuf(i), 1);
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i) {
        this.f2866c = new ArrayList<>();
        this.d = new HashMap<>();
        this.e = new HashMap<>();
        this.g = false;
        this.h = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public int compare(Value value, Value value2) {
                byte b;
                byte b2;
                int i2 = value.e;
                int i3 = value2.e;
                do {
                    b = FlexBuffersBuilder.this.b.get(i2);
                    b2 = FlexBuffersBuilder.this.b.get(i3);
                    if (b == 0) {
                        return b - b2;
                    }
                    i2++;
                    i3++;
                } while (b == b2);
                return b - b2;
            }
        };
        this.b = readWriteBuf;
        this.f = i;
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i);
    }

    private int a(int i) {
        int i2 = 1 << i;
        int j = Value.j(this.b.writePosition(), i2);
        while (true) {
            int i3 = j;
            if (i3 == 0) {
                return i2;
            }
            this.b.put((byte) 0);
            j = i3 - 1;
        }
    }

    static int a(long j) {
        if (j <= FlexBuffers.Unsigned.a((byte) -1)) {
            return 0;
        }
        if (j <= FlexBuffers.Unsigned.a((short) -1)) {
            return 1;
        }
        return j <= FlexBuffers.Unsigned.a(-1) ? 2 : 3;
    }

    private int a(String str) {
        if (str == null) {
            return -1;
        }
        int writePosition = this.b.writePosition();
        if ((this.f & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.b.put(bytes, 0, bytes.length);
            this.b.put((byte) 0);
            this.d.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        Integer num = this.d.get(str);
        if (num == null) {
            byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
            this.b.put(bytes2, 0, bytes2.length);
            this.b.put((byte) 0);
            this.d.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        return num.intValue();
    }

    private Value a(int i, int i2) {
        long j = i2;
        int max = Math.max(0, a(j));
        int i3 = i;
        while (i3 < this.f2866c.size()) {
            i3++;
            max = Math.max(max, Value.b(4, 0, this.f2866c.get(i3).e, this.b.writePosition(), i3));
        }
        int a2 = a(max);
        a(j, a2);
        int writePosition = this.b.writePosition();
        while (i < this.f2866c.size()) {
            int i4 = this.f2866c.get(i).e;
            if (!f2865a && i4 == -1) {
                throw new AssertionError();
            }
            b(this.f2866c.get(i).e, a2);
            i++;
        }
        return new Value(-1, FlexBuffers.a(4, 0), max, writePosition);
    }

    private Value a(int i, int i2, int i3, boolean z, boolean z2, Value value) {
        int i4;
        int i5;
        if (f2865a || !z2 || z) {
            int i6 = i3;
            long j = i6;
            int max = Math.max(0, a(j));
            if (value != null) {
                max = Math.max(max, value.i(this.b.writePosition(), 0));
                i4 = 3;
            } else {
                i4 = 1;
            }
            int i7 = 4;
            int i8 = i2;
            while (i8 < this.f2866c.size()) {
                int max2 = Math.max(max, this.f2866c.get(i8).i(this.b.writePosition(), i8 + i4));
                int i9 = i7;
                if (z) {
                    if (i8 == i2) {
                        i9 = this.f2866c.get(i8).f2868a;
                        if (!FlexBuffers.d(i9)) {
                            throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                        }
                    } else {
                        i9 = i7;
                        if (f2865a) {
                            continue;
                        } else if (i7 != this.f2866c.get(i8).f2868a) {
                            throw new AssertionError();
                        } else {
                            i9 = i7;
                        }
                    }
                }
                i8++;
                i7 = i9;
                max = max2;
            }
            if (f2865a || !z2 || FlexBuffers.d(i7)) {
                int a2 = a(max);
                if (value != null) {
                    b(value.d, a2);
                    a(1 << value.b, a2);
                }
                if (!z2) {
                    a(j, a2);
                }
                int writePosition = this.b.writePosition();
                int i10 = i2;
                while (true) {
                    int i11 = i10;
                    if (i11 >= this.f2866c.size()) {
                        break;
                    }
                    a(this.f2866c.get(i11), a2);
                    i10 = i11 + 1;
                }
                if (!z) {
                    while (i2 < this.f2866c.size()) {
                        this.b.put(this.f2866c.get(i2).a(max));
                        i2++;
                    }
                }
                if (value != null) {
                    i5 = 9;
                } else if (z) {
                    if (!z2) {
                        i6 = 0;
                    }
                    i5 = FlexBuffers.a(i7, i6);
                } else {
                    i5 = 10;
                }
                return new Value(i, i5, max, writePosition);
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private Value a(int i, String str) {
        return a(i, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    private Value a(int i, byte[] bArr, int i2, boolean z) {
        int a2 = a(bArr.length);
        a(bArr.length, a(a2));
        int writePosition = this.b.writePosition();
        this.b.put(bArr, 0, bArr.length);
        if (z) {
            this.b.put((byte) 0);
        }
        return Value.a(i, writePosition, i2, a2);
    }

    private void a(double d, int i) {
        if (i == 4) {
            this.b.putFloat((float) d);
        } else if (i == 8) {
            this.b.putDouble(d);
        }
    }

    private void a(long j, int i) {
        if (i == 1) {
            this.b.put((byte) j);
        } else if (i == 2) {
            this.b.putShort((short) j);
        } else if (i == 4) {
            this.b.putInt((int) j);
        } else if (i != 8) {
        } else {
            this.b.putLong(j);
        }
    }

    private void a(Value value, int i) {
        int i2 = value.f2868a;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                a(value.f2869c, i);
                return;
            } else if (i2 != 26) {
                b(value.d, i);
                return;
            }
        }
        a(value.d, i);
    }

    private void a(String str, long j) {
        this.f2866c.add(Value.b(a(str), j));
    }

    private void b(long j, int i) {
        int writePosition = (int) (this.b.writePosition() - j);
        if (!f2865a && i != 8 && writePosition >= (1 << (i * 8))) {
            throw new AssertionError();
        }
        a(writePosition, i);
    }

    private void b(String str, long j) {
        int a2 = a(str);
        int a3 = a(j);
        this.f2866c.add(a3 == 0 ? Value.d(a2, (int) j) : a3 == 1 ? Value.e(a2, (int) j) : a3 == 2 ? Value.f(a2, (int) j) : Value.b(a2, j));
    }

    public int endMap(String str, int i) {
        int a2 = a(str);
        ArrayList<Value> arrayList = this.f2866c;
        Collections.sort(arrayList.subList(i, arrayList.size()), this.h);
        Value a3 = a(a2, i, this.f2866c.size() - i, false, false, a(i, this.f2866c.size() - i));
        while (this.f2866c.size() > i) {
            ArrayList<Value> arrayList2 = this.f2866c;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.f2866c.add(a3);
        return (int) a3.d;
    }

    public int endVector(String str, int i, boolean z, boolean z2) {
        Value a2 = a(a(str), i, this.f2866c.size() - i, z, z2, null);
        while (this.f2866c.size() > i) {
            ArrayList<Value> arrayList = this.f2866c;
            arrayList.remove(arrayList.size() - 1);
        }
        this.f2866c.add(a2);
        return (int) a2.d;
    }

    public ByteBuffer finish() {
        if (f2865a || this.f2866c.size() == 1) {
            int a2 = a(this.f2866c.get(0).i(this.b.writePosition(), 0));
            a(this.f2866c.get(0), a2);
            this.b.put(this.f2866c.get(0).a());
            this.b.put((byte) a2);
            this.g = true;
            return ByteBuffer.wrap(this.b.data(), 0, this.b.writePosition());
        }
        throw new AssertionError();
    }

    public ReadWriteBuf getBuffer() {
        if (f2865a || this.g) {
            return this.b;
        }
        throw new AssertionError();
    }

    public int putBlob(String str, byte[] bArr) {
        Value a2 = a(a(str), bArr, 25, false);
        this.f2866c.add(a2);
        return (int) a2.d;
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public void putBoolean(String str, boolean z) {
        this.f2866c.add(Value.a(a(str), z));
    }

    public void putBoolean(boolean z) {
        putBoolean(null, z);
    }

    public void putFloat(double d) {
        putFloat((String) null, d);
    }

    public void putFloat(float f) {
        putFloat((String) null, f);
    }

    public void putFloat(String str, double d) {
        this.f2866c.add(Value.a(a(str), d));
    }

    public void putFloat(String str, float f) {
        this.f2866c.add(Value.a(a(str), f));
    }

    public void putInt(int i) {
        putInt((String) null, i);
    }

    public void putInt(long j) {
        putInt((String) null, j);
    }

    public void putInt(String str, int i) {
        putInt(str, i);
    }

    public void putInt(String str, long j) {
        int a2 = a(str);
        if (-128 <= j && j <= 127) {
            this.f2866c.add(Value.a(a2, (int) j));
        } else if (-32768 <= j && j <= 32767) {
            this.f2866c.add(Value.b(a2, (int) j));
        } else if (-2147483648L > j || j > 2147483647L) {
            this.f2866c.add(Value.a(a2, j));
        } else {
            this.f2866c.add(Value.c(a2, (int) j));
        }
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public int putString(String str, String str2) {
        long j;
        int a2 = a(str);
        if ((this.f & 2) != 0) {
            Integer num = this.e.get(str2);
            if (num != null) {
                this.f2866c.add(Value.a(a2, num.intValue(), 5, a(str2.length())));
                return num.intValue();
            }
            Value a3 = a(a2, str2);
            this.e.put(str2, Integer.valueOf((int) a3.d));
            this.f2866c.add(a3);
            j = a3.d;
        } else {
            Value a4 = a(a2, str2);
            this.f2866c.add(a4);
            j = a4.d;
        }
        return (int) j;
    }

    public void putUInt(int i) {
        b((String) null, i);
    }

    public void putUInt(long j) {
        b((String) null, j);
    }

    public void putUInt64(BigInteger bigInteger) {
        a((String) null, bigInteger.longValue());
    }

    public int startMap() {
        return this.f2866c.size();
    }

    public int startVector() {
        return this.f2866c.size();
    }
}
