package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Table.class */
public class Table {

    /* renamed from: a  reason: collision with root package name */
    protected int f2871a;
    protected ByteBuffer b;

    /* renamed from: c  reason: collision with root package name */
    Utf8 f2872c = Utf8.getDefault();
    private int d;
    private int e;

    /* JADX INFO: Access modifiers changed from: protected */
    public static Table a(Table table, int i, ByteBuffer byteBuffer) {
        table.c(b(i, byteBuffer), byteBuffer);
        return table;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(int i, ByteBuffer byteBuffer, Utf8 utf8) {
        int i2 = i + byteBuffer.getInt(i);
        return utf8.decodeUtf8(byteBuffer, i2 + 4, byteBuffer.getInt(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(int i, ByteBuffer byteBuffer) {
        return i + byteBuffer.getInt(i);
    }

    public void __reset() {
        c(0, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i) {
        if (i < this.e) {
            return this.b.getShort(this.d + i);
        }
        return 0;
    }

    protected int a(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuffer a(int i, int i2) {
        int a2 = a(i);
        if (a2 == 0) {
            return null;
        }
        ByteBuffer order = this.b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int e = e(a2);
        order.position(e);
        order.limit(e + (d(a2) * i2));
        return order;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        int a2 = a(i);
        if (a2 == 0) {
            return null;
        }
        int e = e(a2);
        byteBuffer.rewind();
        byteBuffer.limit((d(a2) * i2) + e);
        byteBuffer.position(e);
        return byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                break;
            }
            numArr[i2] = Integer.valueOf(iArr[i2]);
            i = i2 + 1;
        }
        Arrays.sort(numArr, new Comparator<Integer>() { // from class: androidx.emoji2.text.flatbuffer.Table.1
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return Table.this.a(num, num2, byteBuffer);
            }
        });
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = numArr[i4].intValue();
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i) {
        return i + this.b.getInt(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(int i) {
        return a(i, this.b, this.f2872c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i, ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        if (byteBuffer == null) {
            this.f2871a = 0;
            this.d = 0;
            this.e = 0;
            return;
        }
        this.f2871a = i;
        int i2 = i - byteBuffer.getInt(i);
        this.d = i2;
        this.e = this.b.getShort(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i) {
        int i2 = i + this.f2871a;
        return this.b.getInt(i2 + this.b.getInt(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(int i) {
        int i2 = i + this.f2871a;
        return i2 + this.b.getInt(i2) + 4;
    }

    public ByteBuffer getByteBuffer() {
        return this.b;
    }
}
