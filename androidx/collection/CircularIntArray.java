package androidx.collection;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/CircularIntArray.class */
public final class CircularIntArray {

    /* renamed from: a  reason: collision with root package name */
    private int[] f1897a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f1898c;
    private int d;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        int highestOneBit = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.d = highestOneBit - 1;
        this.f1897a = new int[highestOneBit];
    }

    private void a() {
        int[] iArr = this.f1897a;
        int length = iArr.length;
        int i = this.b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, i, iArr2, 0, i2);
        System.arraycopy(this.f1897a, 0, iArr2, i2, this.b);
        this.f1897a = iArr2;
        this.b = 0;
        this.f1898c = length;
        this.d = i3 - 1;
    }

    public void addFirst(int i) {
        int i2 = (this.b - 1) & this.d;
        this.b = i2;
        this.f1897a[i2] = i;
        if (i2 == this.f1898c) {
            a();
        }
    }

    public void addLast(int i) {
        int[] iArr = this.f1897a;
        int i2 = this.f1898c;
        iArr[i2] = i;
        int i3 = this.d & (i2 + 1);
        this.f1898c = i3;
        if (i3 == this.b) {
            a();
        }
    }

    public void clear() {
        this.f1898c = this.b;
    }

    public int get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f1897a[this.d & (this.b + i)];
    }

    public int getFirst() {
        int i = this.b;
        if (i != this.f1898c) {
            return this.f1897a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i = this.b;
        int i2 = this.f1898c;
        if (i != i2) {
            return this.f1897a[(i2 - 1) & this.d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.b == this.f1898c;
    }

    public int popFirst() {
        int i = this.b;
        if (i != this.f1898c) {
            int i2 = this.f1897a[i];
            this.b = (i + 1) & this.d;
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i = this.b;
        int i2 = this.f1898c;
        if (i != i2) {
            int i3 = this.d & (i2 - 1);
            int i4 = this.f1897a[i3];
            this.f1898c = i3;
            return i4;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f1898c = this.d & (this.f1898c - i);
    }

    public void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.b = this.d & (this.b + i);
    }

    public int size() {
        return (this.f1898c - this.b) & this.d;
    }
}
