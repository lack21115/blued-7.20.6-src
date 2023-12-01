package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ChildHelper.class */
public class ChildHelper {

    /* renamed from: a  reason: collision with root package name */
    final Callback f3184a;
    final Bucket b = new Bucket();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f3185c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ChildHelper$Bucket.class */
    public static class Bucket {

        /* renamed from: a  reason: collision with root package name */
        long f3186a = 0;
        Bucket b;

        Bucket() {
        }

        private void b() {
            if (this.b == null) {
                this.b = new Bucket();
            }
        }

        void a() {
            this.f3186a = 0L;
            Bucket bucket = this.b;
            if (bucket != null) {
                bucket.a();
            }
        }

        void a(int i) {
            if (i < 64) {
                this.f3186a |= 1 << i;
                return;
            }
            b();
            this.b.a(i - 64);
        }

        void b(int i) {
            if (i < 64) {
                this.f3186a &= 1 << i;
                return;
            }
            Bucket bucket = this.b;
            if (bucket != null) {
                bucket.b(i - 64);
            }
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f3186a & (1 << i)) != 0;
            }
            b();
            return this.b.c(i - 64);
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f3186a & j) != 0;
            long j2 = this.f3186a & j;
            this.f3186a = j2;
            long j3 = j - 1;
            this.f3186a = (j2 & j3) | Long.rotateRight(j3 & j2, 1);
            Bucket bucket = this.b;
            if (bucket != null) {
                if (bucket.c(0)) {
                    a(63);
                }
                this.b.d(0);
            }
            return z;
        }

        int e(int i) {
            Bucket bucket = this.b;
            return bucket == null ? i >= 64 ? Long.bitCount(this.f3186a) : Long.bitCount(this.f3186a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f3186a & ((1 << i) - 1)) : bucket.e(i - 64) + Long.bitCount(this.f3186a);
        }

        void insert(int i, boolean z) {
            if (i >= 64) {
                b();
                this.b.insert(i - 64, z);
                return;
            }
            boolean z2 = (this.f3186a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f3186a;
            this.f3186a = ((j2 & j) << 1) | (j2 & j);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.b != null) {
                b();
                this.b.insert(0, z2);
            }
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.f3186a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.f3186a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ChildHelper$Callback.class */
    public interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildHelper(Callback callback) {
        this.f3184a = callback;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.f3184a.getChildCount();
        int i2 = i;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return -1;
            }
            int e = i - (i3 - this.b.e(i3));
            if (e == 0) {
                while (this.b.c(i3)) {
                    i3++;
                }
                return i3;
            }
            i2 = i3 + e;
        }
    }

    private void g(View view) {
        this.f3185c.add(view);
        this.f3184a.onEnteredHiddenState(view);
    }

    private boolean h(View view) {
        if (this.f3185c.remove(view)) {
            this.f3184a.onLeftHiddenState(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b.a();
        int size = this.f3185c.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                this.f3184a.removeAllViews();
                return;
            }
            this.f3184a.onLeftHiddenState(this.f3185c.get(i));
            this.f3185c.remove(i);
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        View childAt = this.f3184a.getChildAt(f);
        if (childAt == null) {
            return;
        }
        if (this.b.d(f)) {
            h(childAt);
        }
        this.f3184a.removeViewAt(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        int indexOfChild = this.f3184a.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.b.d(indexOfChild)) {
            h(view);
        }
        this.f3184a.removeViewAt(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int childCount = i < 0 ? this.f3184a.getChildCount() : f(i);
        this.b.insert(childCount, z);
        if (z) {
            g(view);
        }
        this.f3184a.attachViewToParent(view, childCount, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int childCount = i < 0 ? this.f3184a.getChildCount() : f(i);
        this.b.insert(childCount, z);
        if (z) {
            g(view);
        }
        this.f3184a.addView(view, childCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f3184a.getChildCount() - this.f3185c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        int indexOfChild = this.f3184a.indexOfChild(view);
        if (indexOfChild == -1 || this.b.c(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.b.e(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i) {
        return this.f3184a.getChildAt(f(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f3184a.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i) {
        int size = this.f3185c.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return null;
            }
            View view = this.f3185c.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.f3184a.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.f3185c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d(int i) {
        return this.f3184a.getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        int indexOfChild = this.f3184a.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.b.a(indexOfChild);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        this.b.d(f);
        this.f3184a.detachViewFromParent(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view) {
        int indexOfChild = this.f3184a.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.b.c(indexOfChild)) {
            this.b.b(indexOfChild);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(View view) {
        int indexOfChild = this.f3184a.indexOfChild(view);
        if (indexOfChild == -1) {
            h(view);
            return true;
        } else if (this.b.c(indexOfChild)) {
            this.b.d(indexOfChild);
            h(view);
            this.f3184a.removeViewAt(indexOfChild);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.f3185c.size();
    }
}
