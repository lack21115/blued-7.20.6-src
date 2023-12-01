package androidx.collection;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/CircularIntArray.class */
public final class CircularIntArray {

    /* renamed from: a  reason: collision with root package name */
    private int[] f1945a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f1946c;
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
        this.f1945a = new int[highestOneBit];
    }

    private void a() {
        int[] iArr = this.f1945a;
        int length = iArr.length;
        int i = this.b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i3];
        System.arraycopy((Object) iArr, i, (Object) iArr2, 0, i2);
        System.arraycopy((Object) this.f1945a, 0, (Object) iArr2, i2, this.b);
        this.f1945a = iArr2;
        this.b = 0;
        this.f1946c = length;
        this.d = i3 - 1;
    }

    public void addFirst(int i) {
        int i2 = (this.b - 1) & this.d;
        this.b = i2;
        this.f1945a[i2] = i;
        if (i2 == this.f1946c) {
            a();
        }
    }

    public void addLast(int i) {
        int[] iArr = this.f1945a;
        int i2 = this.f1946c;
        iArr[i2] = i;
        int i3 = this.d & (i2 + 1);
        this.f1946c = i3;
        if (i3 == this.b) {
            a();
        }
    }

    public void clear() {
        this.f1946c = this.b;
    }

    public int get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f1945a[this.d & (this.b + i)];
    }

    public int getFirst() {
        int i = this.b;
        if (i != this.f1946c) {
            return this.f1945a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i = this.b;
        int i2 = this.f1946c;
        if (i != i2) {
            return this.f1945a[(i2 - 1) & this.d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.b == this.f1946c;
    }

    public int popFirst() {
        int i = this.b;
        if (i != this.f1946c) {
            int i2 = this.f1945a[i];
            this.b = (i + 1) & this.d;
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i = this.b;
        int i2 = this.f1946c;
        if (i != i2) {
            int i3 = this.d & (i2 - 1);
            int i4 = this.f1945a[i3];
            this.f1946c = i3;
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
        this.f1946c = this.d & (this.f1946c - i);
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
        return (this.f1946c - this.b) & this.d;
    }
}
