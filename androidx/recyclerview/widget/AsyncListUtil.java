package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncListUtil.class */
public class AsyncListUtil<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<T> f3225a;
    final int b;

    /* renamed from: c  reason: collision with root package name */
    final DataCallback<T> f3226c;
    final ViewCallback d;
    final TileList<T> e;
    final ThreadUtil.MainThreadCallback<T> f;
    final ThreadUtil.BackgroundCallback<T> g;
    boolean k;
    final int[] h = new int[2];
    final int[] i = new int[2];
    final int[] j = new int[2];
    private int p = 0;
    int l = 0;
    int m = 0;
    int n = 0;
    final SparseIntArray o = new SparseIntArray();
    private final ThreadUtil.MainThreadCallback<T> q = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
        private void a() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= AsyncListUtil.this.e.size()) {
                    AsyncListUtil.this.e.clear();
                    return;
                } else {
                    AsyncListUtil.this.g.recycleTile(AsyncListUtil.this.e.getAtIndex(i2));
                    i = i2 + 1;
                }
            }
        }

        private boolean a(int i) {
            return i == AsyncListUtil.this.n;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            if (!a(i)) {
                AsyncListUtil.this.g.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.e.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.g.recycleTile(addOrReplace);
            }
            int i2 = tile.mStartPosition;
            int i3 = tile.mItemCount;
            int i4 = 0;
            while (i4 < AsyncListUtil.this.o.size()) {
                int keyAt = AsyncListUtil.this.o.keyAt(i4);
                if (tile.mStartPosition > keyAt || keyAt >= i2 + i3) {
                    i4++;
                } else {
                    AsyncListUtil.this.o.removeAt(i4);
                    AsyncListUtil.this.d.onItemLoaded(keyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (a(i)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.e.removeAtPos(i2);
                if (removeAtPos != null) {
                    AsyncListUtil.this.g.recycleTile(removeAtPos);
                    return;
                }
                Log.e("AsyncListUtil", "tile not found @" + i2);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (a(i)) {
                AsyncListUtil.this.l = i2;
                AsyncListUtil.this.d.onDataRefresh();
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.m = asyncListUtil.n;
                a();
                AsyncListUtil.this.k = false;
                AsyncListUtil.this.a();
            }
        }
    };
    private final ThreadUtil.BackgroundCallback<T> r = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2

        /* renamed from: a  reason: collision with root package name */
        final SparseBooleanArray f3228a = new SparseBooleanArray();

        /* renamed from: c  reason: collision with root package name */
        private TileList.Tile<T> f3229c;
        private int d;
        private int e;
        private int f;
        private int g;

        private int a(int i) {
            return i - (i % AsyncListUtil.this.b);
        }

        private TileList.Tile<T> a() {
            TileList.Tile<T> tile = this.f3229c;
            if (tile != null) {
                this.f3229c = tile.f3360a;
                return tile;
            }
            return new TileList.Tile<>(AsyncListUtil.this.f3225a, AsyncListUtil.this.b);
        }

        private void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (true) {
                int i5 = i4;
                if (i5 > i2) {
                    return;
                }
                AsyncListUtil.this.g.loadTile(z ? (i2 + i) - i5 : i5, i3);
                i4 = i5 + AsyncListUtil.this.b;
            }
        }

        private void a(TileList.Tile<T> tile) {
            this.f3228a.put(tile.mStartPosition, true);
            AsyncListUtil.this.f.addTile(this.d, tile);
        }

        private boolean b(int i) {
            return this.f3228a.get(i);
        }

        private void c(int i) {
            this.f3228a.delete(i);
            AsyncListUtil.this.f.removeTile(this.d, i);
        }

        private void d(int i) {
            int maxCachedTiles = AsyncListUtil.this.f3226c.getMaxCachedTiles();
            while (this.f3228a.size() >= maxCachedTiles) {
                int keyAt = this.f3228a.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f3228a;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i2 = this.f - keyAt;
                int i3 = keyAt2 - this.g;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    c(keyAt);
                } else if (i3 <= 0) {
                    return;
                } else {
                    if (i2 >= i3 && i != 1) {
                        return;
                    }
                    c(keyAt2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (b(i)) {
                return;
            }
            TileList.Tile<T> a2 = a();
            a2.mStartPosition = i;
            a2.mItemCount = Math.min(AsyncListUtil.this.b, this.e - a2.mStartPosition);
            AsyncListUtil.this.f3226c.fillData(a2.mItems, a2.mStartPosition, a2.mItemCount);
            d(i2);
            a(a2);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.f3226c.recycleData(tile.mItems, tile.mItemCount);
            tile.f3360a = this.f3229c;
            this.f3229c = tile;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.d = i;
            this.f3228a.clear();
            this.e = AsyncListUtil.this.f3226c.refreshData();
            AsyncListUtil.this.f.updateItemCount(this.d, this.e);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i > i2) {
                return;
            }
            int a2 = a(i);
            int a3 = a(i2);
            this.f = a(i3);
            int a4 = a(i4);
            this.g = a4;
            if (i5 == 1) {
                a(this.f, a3, i5, true);
                a(a3 + AsyncListUtil.this.b, this.g, i5, false);
                return;
            }
            a(a2, a4, i5, false);
            a(this.f, a2 - AsyncListUtil.this.b, i5, true);
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncListUtil$DataCallback.class */
    public static abstract class DataCallback<T> {
        public abstract void fillData(T[] tArr, int i, int i2);

        public int getMaxCachedTiles() {
            return 10;
        }

        public void recycleData(T[] tArr, int i) {
        }

        public abstract int refreshData();
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncListUtil$ViewCallback.class */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public void extendRangeInto(int[] iArr, int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }

        public abstract void getItemRangeInto(int[] iArr);

        public abstract void onDataRefresh();

        public abstract void onItemLoaded(int i);
    }

    public AsyncListUtil(Class<T> cls, int i, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.f3225a = cls;
        this.b = i;
        this.f3226c = dataCallback;
        this.d = viewCallback;
        this.e = new TileList<>(i);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.f = messageThreadUtil.getMainThreadProxy(this.q);
        this.g = messageThreadUtil.getBackgroundProxy(this.r);
        refresh();
    }

    private boolean b() {
        return this.n != this.m;
    }

    void a() {
        this.d.getItemRangeInto(this.h);
        int[] iArr = this.h;
        if (iArr[0] > iArr[1] || iArr[0] < 0 || iArr[1] >= this.l) {
            return;
        }
        if (this.k) {
            int i = iArr[0];
            int[] iArr2 = this.i;
            if (i > iArr2[1] || iArr2[0] > iArr[1]) {
                this.p = 0;
            } else if (iArr[0] < iArr2[0]) {
                this.p = 1;
            } else if (iArr[0] > iArr2[0]) {
                this.p = 2;
            }
        } else {
            this.p = 0;
        }
        int[] iArr3 = this.i;
        int[] iArr4 = this.h;
        iArr3[0] = iArr4[0];
        iArr3[1] = iArr4[1];
        this.d.extendRangeInto(iArr4, this.j, this.p);
        int[] iArr5 = this.j;
        iArr5[0] = Math.min(this.h[0], Math.max(iArr5[0], 0));
        int[] iArr6 = this.j;
        iArr6[1] = Math.max(this.h[1], Math.min(iArr6[1], this.l - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.g;
        int[] iArr7 = this.h;
        int i2 = iArr7[0];
        int i3 = iArr7[1];
        int[] iArr8 = this.j;
        backgroundCallback.updateRange(i2, i3, iArr8[0], iArr8[1], this.p);
    }

    public T getItem(int i) {
        if (i < 0 || i >= this.l) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.l);
        }
        T itemAt = this.e.getItemAt(i);
        if (itemAt == null && !b()) {
            this.o.put(i, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.l;
    }

    public void onRangeChanged() {
        if (b()) {
            return;
        }
        a();
        this.k = true;
    }

    public void refresh() {
        this.o.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.g;
        int i = this.n + 1;
        this.n = i;
        backgroundCallback.refresh(i);
    }
}
