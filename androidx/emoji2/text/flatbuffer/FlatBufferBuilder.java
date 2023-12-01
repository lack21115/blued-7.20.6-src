package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlatBufferBuilder.class */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean o = !FlatBufferBuilder.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    ByteBuffer f2804a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f2805c;
    int[] d;
    int e;
    boolean f;
    boolean g;
    int h;
    int[] i;
    int j;
    int k;
    boolean l;
    ByteBufferFactory m;
    final Utf8 n;

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlatBufferBuilder$ByteBufferBackedInputStream.class */
    static class ByteBufferBackedInputStream extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        ByteBuffer f2806a;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.f2806a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.f2806a.get() & 255;
            } catch (BufferUnderflowException e) {
                return -1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlatBufferBuilder$ByteBufferFactory.class */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FlatBufferBuilder$HeapByteBufferFactory.class */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i) {
            return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(int i) {
        this(i, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory) {
        this(i, byteBufferFactory, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.f2805c = 1;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.i = new int[16];
        this.j = 0;
        this.k = 0;
        this.l = false;
        int i2 = i <= 0 ? 1 : i;
        this.m = byteBufferFactory;
        if (byteBuffer != null) {
            this.f2804a = byteBuffer;
            byteBuffer.clear();
            this.f2804a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f2804a = byteBufferFactory.newByteBuffer(i2);
        }
        this.n = utf8;
        this.b = this.f2804a.capacity();
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    static ByteBuffer a(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            int i = capacity == 0 ? 1 : capacity << 1;
            byteBuffer.position(0);
            ByteBuffer newByteBuffer = byteBufferFactory.newByteBuffer(i);
            newByteBuffer.position(newByteBuffer.clear().capacity() - capacity);
            newByteBuffer.put(byteBuffer);
            return newByteBuffer;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table table, int i) {
        return table.a(i) != 0;
    }

    public void Nested(int i) {
        if (i != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    protected void a(int i, String str, boolean z) {
        prep(this.f2805c, (z ? 4 : 0) + 8);
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        int i2 = 3;
        while (true) {
            int i3 = i2;
            if (i3 < 0) {
                a(i, z);
                return;
            } else {
                addByte((byte) str.charAt(i3));
                i2 = i3 - 1;
            }
        }
    }

    protected void a(int i, boolean z) {
        prep(this.f2805c, (z ? 4 : 0) + 4);
        addOffset(i);
        if (z) {
            addInt(this.f2804a.capacity() - this.b);
        }
        this.f2804a.position(this.b);
        this.g = true;
    }

    public void addBoolean(int i, boolean z, boolean z2) {
        if (this.l || z != z2) {
            addBoolean(z);
            slot(i);
        }
    }

    public void addBoolean(boolean z) {
        prep(1, 0);
        putBoolean(z);
    }

    public void addByte(byte b) {
        prep(1, 0);
        putByte(b);
    }

    public void addByte(int i, byte b, int i2) {
        if (this.l || b != i2) {
            addByte(b);
            slot(i);
        }
    }

    public void addDouble(double d) {
        prep(8, 0);
        putDouble(d);
    }

    public void addDouble(int i, double d, double d2) {
        if (this.l || d != d2) {
            addDouble(d);
            slot(i);
        }
    }

    public void addFloat(float f) {
        prep(4, 0);
        putFloat(f);
    }

    public void addFloat(int i, float f, double d) {
        if (this.l || f != d) {
            addFloat(f);
            slot(i);
        }
    }

    public void addInt(int i) {
        prep(4, 0);
        putInt(i);
    }

    public void addInt(int i, int i2, int i3) {
        if (this.l || i2 != i3) {
            addInt(i2);
            slot(i);
        }
    }

    public void addLong(int i, long j, long j2) {
        if (this.l || j != j2) {
            addLong(j);
            slot(i);
        }
    }

    public void addLong(long j) {
        prep(8, 0);
        putLong(j);
    }

    public void addOffset(int i) {
        prep(4, 0);
        if (!o && i > offset()) {
            throw new AssertionError();
        }
        putInt((offset() - i) + 4);
    }

    public void addOffset(int i, int i2, int i3) {
        if (this.l || i2 != i3) {
            addOffset(i2);
            slot(i);
        }
    }

    public void addShort(int i, short s, int i2) {
        if (this.l || s != i2) {
            addShort(s);
            slot(i);
        }
    }

    public void addShort(short s) {
        prep(2, 0);
        putShort(s);
    }

    public void addStruct(int i, int i2, int i3) {
        if (i2 != i3) {
            Nested(i2);
            slot(i);
        }
    }

    public void clear() {
        this.b = this.f2804a.capacity();
        this.f2804a.clear();
        this.f2805c = 1;
        while (true) {
            int i = this.e;
            if (i <= 0) {
                this.e = 0;
                this.f = false;
                this.g = false;
                this.h = 0;
                this.j = 0;
                this.k = 0;
                return;
            }
            int[] iArr = this.d;
            int i2 = i - 1;
            this.e = i2;
            iArr[i2] = 0;
        }
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f2804a;
        int i = this.b - remaining;
        this.b = i;
        byteBuffer2.position(i);
        this.f2804a.put(byteBuffer);
        return endVector();
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - length;
        this.b = i;
        byteBuffer.position(i);
        this.f2804a.put(bArr);
        return endVector();
    }

    public int createByteVector(byte[] bArr, int i, int i2) {
        startVector(1, i2, 1);
        ByteBuffer byteBuffer = this.f2804a;
        int i3 = this.b - i2;
        this.b = i3;
        byteBuffer.position(i3);
        this.f2804a.put(bArr, i, i2);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t, int[] iArr) {
        t.a(iArr, this.f2804a);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int encodedLength = this.n.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, encodedLength, 1);
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - encodedLength;
        this.b = i;
        byteBuffer.position(i);
        this.n.encodeUtf8(charSequence, this.f2804a);
        return endVector();
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.f2804a;
        int i = this.b - remaining;
        this.b = i;
        byteBuffer2.position(i);
        this.f2804a.put(byteBuffer);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i, int i2, int i3) {
        int i4 = i * i2;
        startVector(i, i2, i3);
        ByteBuffer byteBuffer = this.f2804a;
        int i5 = this.b - i4;
        this.b = i5;
        byteBuffer.position(i5);
        ByteBuffer order = this.f2804a.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i4);
        return order;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return endVector();
            }
            addOffset(iArr[i]);
            length = i;
        }
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f2804a;
    }

    public int endTable() {
        int i;
        int i2;
        if (this.d == null || !this.f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int offset = offset();
        int i3 = this.e;
        while (true) {
            i = i3 - 1;
            if (i < 0 || this.d[i] != 0) {
                break;
            }
            i3 = i;
        }
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 < 0) {
                break;
            }
            int[] iArr = this.d;
            addShort((short) (iArr[i5] != 0 ? offset - iArr[i5] : 0));
            i4 = i5 - 1;
        }
        addShort((short) (offset - this.h));
        addShort((short) ((i + 1 + 2) * 2));
        int i6 = 0;
        loop2: while (true) {
            int i7 = i6;
            if (i7 >= this.j) {
                i2 = 0;
                break;
            }
            int capacity = this.f2804a.capacity() - this.i[i7];
            int i8 = this.b;
            short s = this.f2804a.getShort(capacity);
            if (s == this.f2804a.getShort(i8)) {
                int i9 = 2;
                while (true) {
                    int i10 = i9;
                    if (i10 >= s) {
                        i2 = this.i[i7];
                        break loop2;
                    } else if (this.f2804a.getShort(capacity + i10) != this.f2804a.getShort(i8 + i10)) {
                        break;
                    } else {
                        i9 = i10 + 2;
                    }
                }
            }
            i6 = i7 + 1;
        }
        if (i2 != 0) {
            int capacity2 = this.f2804a.capacity() - offset;
            this.b = capacity2;
            this.f2804a.putInt(capacity2, i2 - offset);
        } else {
            int i11 = this.j;
            int[] iArr2 = this.i;
            if (i11 == iArr2.length) {
                this.i = Arrays.copyOf(iArr2, i11 * 2);
            }
            int[] iArr3 = this.i;
            int i12 = this.j;
            this.j = i12 + 1;
            iArr3[i12] = offset();
            ByteBuffer byteBuffer = this.f2804a;
            byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
        }
        this.f = false;
        return offset;
    }

    public int endVector() {
        if (this.f) {
            this.f = false;
            putInt(this.k);
            return offset();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finish(int i) {
        a(i, false);
    }

    public void finish(int i, String str) {
        a(i, str, false);
    }

    public void finishSizePrefixed(int i) {
        a(i, true);
    }

    public void finishSizePrefixed(int i, String str) {
        a(i, str, true);
    }

    public void finished() {
        if (!this.g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z) {
        this.l = z;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.m = byteBufferFactory;
        this.f2804a = byteBuffer;
        byteBuffer.clear();
        this.f2804a.order(ByteOrder.LITTLE_ENDIAN);
        this.f2805c = 1;
        this.b = this.f2804a.capacity();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = 0;
        this.j = 0;
        this.k = 0;
        return this;
    }

    public void notNested() {
        if (this.f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.f2804a.capacity() - this.b;
    }

    public void pad(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            ByteBuffer byteBuffer = this.f2804a;
            int i4 = this.b - 1;
            this.b = i4;
            byteBuffer.put(i4, (byte) 0);
            i2 = i3 + 1;
        }
    }

    public void prep(int i, int i2) {
        if (i > this.f2805c) {
            this.f2805c = i;
        }
        int capacity = ((this.f2804a.capacity() - this.b) + i2 + 1) & (i - 1);
        while (this.b < capacity + i + i2) {
            int capacity2 = this.f2804a.capacity();
            ByteBuffer byteBuffer = this.f2804a;
            ByteBuffer a2 = a(byteBuffer, this.m);
            this.f2804a = a2;
            if (byteBuffer != a2) {
                this.m.releaseByteBuffer(byteBuffer);
            }
            this.b += this.f2804a.capacity() - capacity2;
        }
        pad(capacity);
    }

    public void putBoolean(boolean z) {
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b) {
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, b);
    }

    public void putDouble(double d) {
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putDouble(i, d);
    }

    public void putFloat(float f) {
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - 4;
        this.b = i;
        byteBuffer.putFloat(i, f);
    }

    public void putInt(int i) {
        ByteBuffer byteBuffer = this.f2804a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, i);
    }

    public void putLong(long j) {
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putLong(i, j);
    }

    public void putShort(short s) {
        ByteBuffer byteBuffer = this.f2804a;
        int i = this.b - 2;
        this.b = i;
        byteBuffer.putShort(i, s);
    }

    public void required(int i, int i2) {
        int capacity = this.f2804a.capacity() - i;
        if (this.f2804a.getShort((capacity - this.f2804a.getInt(capacity)) + i2) != 0) {
            return;
        }
        throw new AssertionError("FlatBuffers: field " + i2 + " must be set");
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.b, this.f2804a.capacity() - this.b);
    }

    public byte[] sizedByteArray(int i, int i2) {
        finished();
        byte[] bArr = new byte[i2];
        this.f2804a.position(i);
        this.f2804a.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.f2804a.duplicate();
        duplicate.position(this.b);
        duplicate.limit(this.f2804a.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    public void slot(int i) {
        this.d[i] = offset();
    }

    public void startTable(int i) {
        notNested();
        int[] iArr = this.d;
        if (iArr == null || iArr.length < i) {
            this.d = new int[i];
        }
        this.e = i;
        Arrays.fill(this.d, 0, i, 0);
        this.f = true;
        this.h = offset();
    }

    public void startVector(int i, int i2, int i3) {
        notNested();
        this.k = i2;
        int i4 = i * i2;
        prep(4, i4);
        prep(i3, i4);
        this.f = true;
    }
}
