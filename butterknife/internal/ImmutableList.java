package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

/* loaded from: source-8756600-dex2jar.jar:butterknife/internal/ImmutableList.class */
final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f3729a;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        T[] tArr = this.f3729a;
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (tArr[i2] == obj) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f3729a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3729a.length;
    }
}
