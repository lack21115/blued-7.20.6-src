package androidx.recyclerview.widget;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/SortedList.class */
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;

    /* renamed from: a  reason: collision with root package name */
    T[] f3341a;
    private T[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f3342c;
    private int d;
    private int e;
    private Callback f;
    private BatchedCallback g;
    private int h;
    private final Class<T> i;

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/SortedList$BatchedCallback.class */
    public static class BatchedCallback<T2> extends Callback<T2> {

        /* renamed from: a  reason: collision with root package name */
        final Callback<T2> f3343a;
        private final BatchingListUpdateCallback b;

        public BatchedCallback(Callback<T2> callback) {
            this.f3343a = callback;
            this.b = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.f3343a.areContentsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.f3343a.areItemsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.f3343a.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.b.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.f3343a.getChangePayload(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i2) {
            this.b.onChanged(i, i2, null);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            this.b.onChanged(i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.b.onInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.b.onMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.b.onRemoved(i, i2);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/SortedList$Callback.class */
    public static abstract class Callback<T2> implements ListUpdateCallback, Comparator<T2> {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        public abstract int compare(T2 t2, T2 t22);

        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i, int i2);

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback) {
        this(cls, callback, 10);
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i) {
        this.i = cls;
        this.f3341a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.f = callback;
        this.h = 0;
    }

    private int a(T t, int i, int i2, int i3) {
        int i4;
        int i5;
        T t2;
        int i6 = i;
        while (true) {
            int i7 = i6 - 1;
            i4 = i;
            if (i7 < i2) {
                break;
            }
            T t3 = this.f3341a[i7];
            if (this.f.compare(t3, t) != 0) {
                i4 = i;
                break;
            } else if (this.f.areItemsTheSame(t3, t)) {
                return i7;
            } else {
                i6 = i7;
            }
        }
        do {
            i5 = i4 + 1;
            if (i5 >= i3) {
                return -1;
            }
            t2 = this.f3341a[i5];
            if (this.f.compare(t2, t) != 0) {
                return -1;
            }
            i4 = i5;
        } while (!this.f.areItemsTheSame(t2, t));
        return i5;
    }

    private int a(T t, boolean z) {
        int i;
        int a2 = a(t, this.f3341a, 0, this.h, 1);
        if (a2 == -1) {
            i = 0;
        } else {
            i = a2;
            if (a2 < this.h) {
                T t2 = this.f3341a[a2];
                i = a2;
                if (this.f.areItemsTheSame(t2, t)) {
                    if (this.f.areContentsTheSame(t2, t)) {
                        this.f3341a[a2] = t;
                        return a2;
                    }
                    this.f3341a[a2] = t;
                    Callback callback = this.f;
                    callback.onChanged(a2, 1, callback.getChangePayload(t2, t));
                    return a2;
                }
            }
        }
        a(i, (int) t);
        if (z) {
            this.f.onInserted(i, 1);
        }
        return i;
    }

    private int a(T t, T[] tArr, int i, int i2) {
        while (i < i2) {
            if (this.f.areItemsTheSame(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int a(T t, T[] tArr, int i, int i2, int i3) {
        while (i < i2) {
            int i4 = (i + i2) / 2;
            T t2 = tArr[i4];
            int compare = this.f.compare(t2, t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare == 0) {
                if (this.f.areItemsTheSame(t2, t)) {
                    return i4;
                }
                int a2 = a((SortedList<T>) t, i4, i, i2);
                if (i3 == 1 && a2 == -1) {
                    return i4;
                }
                return a2;
            } else {
                i2 = i4;
            }
        }
        if (i3 == 1) {
            return i;
        }
        return -1;
    }

    private void a() {
        this.h--;
        this.f3342c++;
        this.f.onRemoved(this.e, 1);
    }

    private void a(int i, T t) {
        int i2 = this.h;
        if (i > i2) {
            throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.h);
        }
        T[] tArr = this.f3341a;
        if (i2 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, tArr.length + 10));
            System.arraycopy(this.f3341a, 0, tArr2, 0, i);
            tArr2[i] = t;
            System.arraycopy(this.f3341a, i, tArr2, i + 1, this.h - i);
            this.f3341a = tArr2;
        } else {
            System.arraycopy(tArr, i, tArr, i + 1, i2 - i);
            this.f3341a[i] = t;
        }
        this.h++;
    }

    private void a(int i, boolean z) {
        T[] tArr = this.f3341a;
        System.arraycopy(tArr, i + 1, tArr, i, (this.h - i) - 1);
        int i2 = this.h - 1;
        this.h = i2;
        this.f3341a[i2] = null;
        if (z) {
            this.f.onRemoved(i, 1);
        }
    }

    private void a(T t) {
        T[] tArr = this.f3341a;
        int i = this.e;
        tArr[i] = t;
        int i2 = i + 1;
        this.e = i2;
        this.h++;
        this.f.onInserted(i2 - 1, 1);
    }

    private void a(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int c2 = c(tArr);
        if (this.h != 0) {
            a(tArr, c2);
            return;
        }
        this.f3341a = tArr;
        this.h = c2;
        this.f.onInserted(0, c2);
    }

    private void a(T[] tArr, int i) {
        boolean z = !(this.f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.b = this.f3341a;
        int i2 = 0;
        this.f3342c = 0;
        int i3 = this.h;
        this.d = i3;
        this.f3341a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, i3 + i + 10));
        this.e = 0;
        while (true) {
            if (this.f3342c >= this.d && i2 >= i) {
                break;
            }
            int i4 = this.f3342c;
            int i5 = this.d;
            if (i4 == i5) {
                int i6 = i - i2;
                System.arraycopy(tArr, i2, this.f3341a, this.e, i6);
                int i7 = this.e + i6;
                this.e = i7;
                this.h += i6;
                this.f.onInserted(i7 - i6, i6);
                break;
            } else if (i2 == i) {
                int i8 = i5 - i4;
                System.arraycopy(this.b, i4, this.f3341a, this.e, i8);
                this.e += i8;
                break;
            } else {
                T t = this.b[i4];
                T t2 = tArr[i2];
                int compare = this.f.compare(t, t2);
                if (compare > 0) {
                    T[] tArr2 = this.f3341a;
                    int i9 = this.e;
                    int i10 = i9 + 1;
                    this.e = i10;
                    tArr2[i9] = t2;
                    this.h++;
                    i2++;
                    this.f.onInserted(i10 - 1, 1);
                } else if (compare == 0 && this.f.areItemsTheSame(t, t2)) {
                    T[] tArr3 = this.f3341a;
                    int i11 = this.e;
                    this.e = i11 + 1;
                    tArr3[i11] = t2;
                    int i12 = i2 + 1;
                    this.f3342c++;
                    i2 = i12;
                    if (!this.f.areContentsTheSame(t, t2)) {
                        Callback callback = this.f;
                        callback.onChanged(this.e - 1, 1, callback.getChangePayload(t, t2));
                        i2 = i12;
                    }
                } else {
                    T[] tArr4 = this.f3341a;
                    int i13 = this.e;
                    this.e = i13 + 1;
                    tArr4[i13] = t;
                    this.f3342c++;
                }
            }
        }
        this.b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private void b() {
        if (this.b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    private void b(T[] tArr) {
        boolean z = !(this.f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f3342c = 0;
        this.d = this.h;
        this.b = this.f3341a;
        this.e = 0;
        int c2 = c(tArr);
        this.f3341a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, c2));
        while (true) {
            if (this.e >= c2 && this.f3342c >= this.d) {
                break;
            }
            int i = this.f3342c;
            int i2 = this.d;
            if (i >= i2) {
                int i3 = this.e;
                int i4 = c2 - i3;
                System.arraycopy(tArr, i3, this.f3341a, i3, i4);
                this.e += i4;
                this.h += i4;
                this.f.onInserted(i3, i4);
                break;
            }
            int i5 = this.e;
            if (i5 >= c2) {
                int i6 = i2 - i;
                this.h -= i6;
                this.f.onRemoved(i5, i6);
                break;
            }
            T t = this.b[i];
            T t2 = tArr[i5];
            int compare = this.f.compare(t, t2);
            if (compare < 0) {
                a();
            } else if (compare > 0) {
                a((SortedList<T>) t2);
            } else if (this.f.areItemsTheSame(t, t2)) {
                T[] tArr2 = this.f3341a;
                int i7 = this.e;
                tArr2[i7] = t2;
                this.f3342c++;
                this.e = i7 + 1;
                if (!this.f.areContentsTheSame(t, t2)) {
                    Callback callback = this.f;
                    callback.onChanged(this.e - 1, 1, callback.getChangePayload(t, t2));
                }
            } else {
                a();
                a((SortedList<T>) t2);
            }
        }
        this.b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private boolean b(T t, boolean z) {
        int a2 = a(t, this.f3341a, 0, this.h, 2);
        if (a2 == -1) {
            return false;
        }
        a(a2, z);
        return true;
    }

    private int c(T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.f);
        int i = 1;
        int i2 = 0;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T t = tArr[i3];
            if (this.f.compare(tArr[i2], t) == 0) {
                int a2 = a((SortedList<T>) t, (SortedList<T>[]) tArr, i2, i);
                if (a2 != -1) {
                    tArr[a2] = t;
                } else {
                    if (i != i3) {
                        tArr[i] = t;
                    }
                    i++;
                }
            } else {
                if (i != i3) {
                    tArr[i] = t;
                }
                i2 = i;
                i++;
            }
        }
        return i;
    }

    private T[] d(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    public int add(T t) {
        b();
        return a((SortedList<T>) t, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.i, collection.size())), true);
    }

    public void addAll(T... tArr) {
        addAll(tArr, false);
    }

    public void addAll(T[] tArr, boolean z) {
        b();
        if (tArr.length == 0) {
            return;
        }
        if (z) {
            a((Object[]) tArr);
        } else {
            a((Object[]) d(tArr));
        }
    }

    public void beginBatchedUpdates() {
        b();
        Callback callback = this.f;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.g == null) {
            this.g = new BatchedCallback(callback);
        }
        this.f = this.g;
    }

    public void clear() {
        b();
        int i = this.h;
        if (i == 0) {
            return;
        }
        Arrays.fill(this.f3341a, 0, i, (Object) null);
        this.h = 0;
        this.f.onRemoved(0, i);
    }

    public void endBatchedUpdates() {
        b();
        Callback callback = this.f;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.f;
        BatchedCallback batchedCallback = this.g;
        if (callback2 == batchedCallback) {
            this.f = batchedCallback.f3343a;
        }
    }

    public T get(int i) throws IndexOutOfBoundsException {
        int i2;
        if (i < this.h && i >= 0) {
            T[] tArr = this.b;
            return (tArr == null || i < (i2 = this.e)) ? this.f3341a[i] : tArr[(i - i2) + this.f3342c];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.h);
    }

    public int indexOf(T t) {
        if (this.b != null) {
            int a2 = a(t, this.f3341a, 0, this.e, 4);
            if (a2 != -1) {
                return a2;
            }
            int a3 = a(t, this.b, this.f3342c, this.d, 4);
            if (a3 != -1) {
                return (a3 - this.f3342c) + this.e;
            }
            return -1;
        }
        return a(t, this.f3341a, 0, this.h, 4);
    }

    public void recalculatePositionOfItemAt(int i) {
        b();
        T t = get(i);
        a(i, false);
        int a2 = a((SortedList<T>) t, false);
        if (i != a2) {
            this.f.onMoved(i, a2);
        }
    }

    public boolean remove(T t) {
        b();
        return b(t, true);
    }

    public T removeItemAt(int i) {
        b();
        T t = get(i);
        a(i, true);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.i, collection.size())), true);
    }

    public void replaceAll(T... tArr) {
        replaceAll(tArr, false);
    }

    public void replaceAll(T[] tArr, boolean z) {
        b();
        if (z) {
            b(tArr);
        } else {
            b(d(tArr));
        }
    }

    public int size() {
        return this.h;
    }

    public void updateItemAt(int i, T t) {
        b();
        T t2 = get(i);
        boolean z = t2 == t || !this.f.areContentsTheSame(t2, t);
        if (t2 != t && this.f.compare(t2, t) == 0) {
            this.f3341a[i] = t;
            if (z) {
                Callback callback = this.f;
                callback.onChanged(i, 1, callback.getChangePayload(t2, t));
                return;
            }
            return;
        }
        if (z) {
            Callback callback2 = this.f;
            callback2.onChanged(i, 1, callback2.getChangePayload(t2, t));
        }
        a(i, false);
        int a2 = a((SortedList<T>) t, false);
        if (i != a2) {
            this.f.onMoved(i, a2);
        }
    }
}
