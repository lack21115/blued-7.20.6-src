package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/TileList.class */
class TileList<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f3310a;
    Tile<T> b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Tile<T>> f3311c = new SparseArray<>(10);

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/TileList$Tile.class */
    public static class Tile<T> {

        /* renamed from: a  reason: collision with root package name */
        Tile<T> f3312a;
        public int mItemCount;
        public final T[] mItems;
        public int mStartPosition;

        public Tile(Class<T> cls, int i) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }

        boolean a(int i) {
            int i2 = this.mStartPosition;
            return i2 <= i && i < i2 + this.mItemCount;
        }

        T b(int i) {
            return this.mItems[i - this.mStartPosition];
        }
    }

    public TileList(int i) {
        this.f3310a = i;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.f3311c.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.f3311c.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.f3311c.valueAt(indexOfKey);
        this.f3311c.setValueAt(indexOfKey, tile);
        if (this.b == valueAt) {
            this.b = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.f3311c.clear();
    }

    public Tile<T> getAtIndex(int i) {
        return this.f3311c.valueAt(i);
    }

    public T getItemAt(int i) {
        Tile<T> tile = this.b;
        if (tile == null || !tile.a(i)) {
            int indexOfKey = this.f3311c.indexOfKey(i - (i % this.f3310a));
            if (indexOfKey < 0) {
                return null;
            }
            this.b = this.f3311c.valueAt(indexOfKey);
        }
        return this.b.b(i);
    }

    public Tile<T> removeAtPos(int i) {
        Tile<T> tile = this.f3311c.get(i);
        if (this.b == tile) {
            this.b = null;
        }
        this.f3311c.delete(i);
        return tile;
    }

    public int size() {
        return this.f3311c.size();
    }
}
