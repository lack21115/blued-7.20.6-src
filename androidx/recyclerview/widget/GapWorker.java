package androidx.recyclerview.widget;

import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/GapWorker.class */
public final class GapWorker implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<GapWorker> f3267a = new ThreadLocal<>();
    static Comparator<Task> e = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            if ((task.view == null) != (task2.view == null)) {
                return task.view == null ? 1 : -1;
            } else if (task.immediate != task2.immediate) {
                int i = 1;
                if (task.immediate) {
                    i = -1;
                }
                return i;
            } else {
                int i2 = task2.viewVelocity - task.viewVelocity;
                if (i2 != 0) {
                    return i2;
                }
                int i3 = task.distanceToItem - task2.distanceToItem;
                if (i3 != 0) {
                    return i3;
                }
                return 0;
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    long f3268c;
    long d;
    ArrayList<RecyclerView> b = new ArrayList<>();
    private ArrayList<Task> f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/GapWorker$LayoutPrefetchRegistryImpl.class */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a  reason: collision with root package name */
        int f3269a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int[] f3270c;
        int d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f3270c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }

        void a(int i, int i2) {
            this.f3269a = i;
            this.b = i2;
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.f3270c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.d()) {
                    layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.f3269a, this.b, recyclerView.mState, this);
            }
            if (this.d > layoutManager.mPrefetchMaxCountObserved) {
                layoutManager.mPrefetchMaxCountObserved = this.d;
                layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.f3270c == null) {
                return false;
            }
            int i2 = this.d;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2 * 2) {
                    return false;
                }
                if (this.f3270c[i4] == i) {
                    return true;
                }
                i3 = i4 + 2;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d * 2;
            int[] iArr = this.f3270c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f3270c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.f3270c = iArr3;
                System.arraycopy((Object) iArr, 0, (Object) iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f3270c;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.d++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/GapWorker$Task.class */
    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    private RecyclerView.ViewHolder a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder a2 = recycler.a(i, false, j);
            if (a2 != null) {
                if (!a2.isBound() || a2.isInvalid()) {
                    recycler.a(a2, false);
                } else {
                    recycler.recycleView(a2.itemView);
                }
            }
            return a2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void a() {
        int i;
        int i2;
        Task task;
        int size = this.b.size();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= size) {
                break;
            }
            RecyclerView recyclerView = this.b.get(i3);
            int i5 = i;
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a(recyclerView, false);
                i5 = i + recyclerView.mPrefetchRegistry.d;
            }
            i3++;
            i4 = i5;
        }
        this.f.ensureCapacity(i);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i6 >= size) {
                Collections.sort(this.f, e);
                return;
            }
            RecyclerView recyclerView2 = this.b.get(i6);
            if (recyclerView2.getWindowVisibility() != 0) {
                i2 = i8;
            } else {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.f3269a) + Math.abs(layoutPrefetchRegistryImpl.b);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    i2 = i8;
                    if (i10 < layoutPrefetchRegistryImpl.d * 2) {
                        if (i8 >= this.f.size()) {
                            task = new Task();
                            this.f.add(task);
                        } else {
                            task = this.f.get(i8);
                        }
                        int i11 = layoutPrefetchRegistryImpl.f3270c[i10 + 1];
                        task.immediate = i11 <= abs;
                        task.viewVelocity = abs;
                        task.distanceToItem = i11;
                        task.view = recyclerView2;
                        task.position = layoutPrefetchRegistryImpl.f3270c[i10];
                        i8++;
                        i9 = i10 + 2;
                    }
                }
            }
            i6++;
            i7 = i2;
        }
    }

    private void a(Task task, long j) {
        RecyclerView.ViewHolder a2 = a(task.view, task.position, task.immediate ? Long.MAX_VALUE : j);
        if (a2 == null || a2.mNestedRecyclerView == null || !a2.isBound() || a2.isInvalid()) {
            return;
        }
        a(a2.mNestedRecyclerView.get(), j);
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.c() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.a(recyclerView, true);
        if (layoutPrefetchRegistryImpl.d == 0) {
            return;
        }
        try {
            TraceCompat.beginSection("RV Nested Prefetch");
            recyclerView.mState.a(recyclerView.mAdapter);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= layoutPrefetchRegistryImpl.d * 2) {
                    return;
                }
                a(recyclerView, layoutPrefetchRegistryImpl.f3270c[i2], j);
                i = i2 + 2;
            }
        } finally {
            TraceCompat.endSection();
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int c2 = recyclerView.mChildHelper.c();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= c2) {
                return false;
            }
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.d(i3));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private void b(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.size()) {
                return;
            }
            Task task = this.f.get(i2);
            if (task.view == null) {
                return;
            }
            a(task, j);
            task.clear();
            i = i2 + 1;
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f3268c == 0) {
            this.f3268c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.a(i, i2);
    }

    public void add(RecyclerView recyclerView) {
        this.b.add(recyclerView);
    }

    public void remove(RecyclerView recyclerView) {
        this.b.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.b.isEmpty()) {
                int size = this.b.size();
                int i = 0;
                long j2 = 0;
                while (true) {
                    j = j2;
                    if (i >= size) {
                        break;
                    }
                    RecyclerView recyclerView = this.b.get(i);
                    long j3 = j;
                    if (recyclerView.getWindowVisibility() == 0) {
                        j3 = Math.max(recyclerView.getDrawingTime(), j);
                    }
                    i++;
                    j2 = j3;
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                }
            }
        } finally {
            this.f3268c = 0L;
            TraceCompat.endSection();
        }
    }
}
