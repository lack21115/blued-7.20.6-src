package androidx.collection;

/* loaded from: source-8756600-dex2jar.jar:androidx/collection/CircularArray.class */
public final class CircularArray<E> {

    /* renamed from: a  reason: collision with root package name */
    private E[] f1943a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f1944c;
    private int d;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        int highestOneBit = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.d = highestOneBit - 1;
        this.f1943a = (E[]) new Object[highestOneBit];
    }

    private void a() {
        E[] eArr = this.f1943a;
        int length = eArr.length;
        int i = this.b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr = new Object[i3];
        System.arraycopy(eArr, i, objArr, 0, i2);
        System.arraycopy(this.f1943a, 0, objArr, i2, this.b);
        this.f1943a = (E[]) objArr;
        this.b = 0;
        this.f1944c = length;
        this.d = i3 - 1;
    }

    public void addFirst(E e) {
        int i = (this.b - 1) & this.d;
        this.b = i;
        this.f1943a[i] = e;
        if (i == this.f1944c) {
            a();
        }
    }

    public void addLast(E e) {
        E[] eArr = this.f1943a;
        int i = this.f1944c;
        eArr[i] = e;
        int i2 = this.d & (i + 1);
        this.f1944c = i2;
        if (i2 == this.b) {
            a();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f1943a[this.d & (this.b + i)];
    }

    public E getFirst() {
        int i = this.b;
        if (i != this.f1944c) {
            return this.f1943a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i = this.b;
        int i2 = this.f1944c;
        if (i != i2) {
            return this.f1943a[(i2 - 1) & this.d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.b == this.f1944c;
    }

    public E popFirst() {
        int i = this.b;
        if (i != this.f1944c) {
            E[] eArr = this.f1943a;
            E e = eArr[i];
            eArr[i] = null;
            this.b = (i + 1) & this.d;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i = this.b;
        int i2 = this.f1944c;
        if (i != i2) {
            int i3 = this.d & (i2 - 1);
            E[] eArr = this.f1943a;
            E e = eArr[i3];
            eArr[i3] = null;
            this.f1944c = i3;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i) {
        int i2;
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = 0;
        int i4 = this.f1944c;
        if (i < i4) {
            i3 = i4 - i;
        }
        int i5 = i3;
        while (true) {
            int i6 = i5;
            i2 = this.f1944c;
            if (i6 >= i2) {
                break;
            }
            this.f1943a[i6] = null;
            i5 = i6 + 1;
        }
        int i7 = i2 - i3;
        int i8 = i - i7;
        this.f1944c = i2 - i7;
        if (i8 <= 0) {
            return;
        }
        int length = this.f1943a.length;
        this.f1944c = length;
        int i9 = length - i8;
        int i10 = i9;
        while (true) {
            int i11 = i10;
            if (i11 >= this.f1944c) {
                this.f1944c = i9;
                return;
            } else {
                this.f1943a[i11] = null;
                i10 = i11 + 1;
            }
        }
    }

    public void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.f1943a.length;
        int i2 = this.b;
        int i3 = length;
        if (i < length - i2) {
            i3 = i2 + i;
        }
        int i4 = this.b;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                break;
            }
            this.f1943a[i5] = null;
            i4 = i5 + 1;
        }
        int i6 = this.b;
        int i7 = i3 - i6;
        int i8 = i - i7;
        this.b = this.d & (i6 + i7);
        if (i8 <= 0) {
            return;
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= i8) {
                this.b = i8;
                return;
            } else {
                this.f1943a[i10] = null;
                i9 = i10 + 1;
            }
        }
    }

    public int size() {
        return (this.f1944c - this.b) & this.d;
    }
}
