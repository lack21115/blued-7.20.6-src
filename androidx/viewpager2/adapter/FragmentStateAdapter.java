package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/adapter/FragmentStateAdapter.class */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {

    /* renamed from: a  reason: collision with root package name */
    final Lifecycle f3566a;
    final FragmentManager b;

    /* renamed from: c  reason: collision with root package name */
    final LongSparseArray<Fragment> f3567c;
    boolean d;
    private final LongSparseArray<Fragment.SavedState> e;
    private final LongSparseArray<Integer> f;
    private FragmentMaxLifecycleEnforcer g;
    private boolean h;

    /* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/adapter/FragmentStateAdapter$DataSetChangeObserver.class */
    static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/adapter/FragmentStateAdapter$FragmentMaxLifecycleEnforcer.class */
    public class FragmentMaxLifecycleEnforcer {
        private ViewPager2.OnPageChangeCallback b;

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f3577c;
        private LifecycleEventObserver d;
        private ViewPager2 e;
        private long f = -1;

        FragmentMaxLifecycleEnforcer() {
        }

        private ViewPager2 c(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void a(RecyclerView recyclerView) {
            this.e = c(recyclerView);
            ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    FragmentMaxLifecycleEnforcer.this.a(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i) {
                    FragmentMaxLifecycleEnforcer.this.a(false);
                }
            };
            this.b = onPageChangeCallback;
            this.e.registerOnPageChangeCallback(onPageChangeCallback);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.a(true);
                }
            };
            this.f3577c = dataSetChangeObserver;
            FragmentStateAdapter.this.registerAdapterDataObserver(dataSetChangeObserver);
            this.d = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.a(false);
                }
            };
            FragmentStateAdapter.this.f3566a.addObserver(this.d);
        }

        void a(boolean z) {
            int currentItem;
            Fragment fragment;
            if (FragmentStateAdapter.this.b() || this.e.getScrollState() != 0 || FragmentStateAdapter.this.f3567c.isEmpty() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.e.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.f || z) && (fragment = FragmentStateAdapter.this.f3567c.get(itemId)) != null && fragment.isAdded()) {
                this.f = itemId;
                FragmentTransaction beginTransaction = FragmentStateAdapter.this.b.beginTransaction();
                Fragment fragment2 = null;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= FragmentStateAdapter.this.f3567c.size()) {
                        break;
                    }
                    long keyAt = FragmentStateAdapter.this.f3567c.keyAt(i2);
                    Fragment valueAt = FragmentStateAdapter.this.f3567c.valueAt(i2);
                    if (valueAt.isAdded()) {
                        if (keyAt != this.f) {
                            beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                        } else {
                            fragment2 = valueAt;
                        }
                        valueAt.setMenuVisibility(keyAt == this.f);
                    }
                    i = i2 + 1;
                }
                if (fragment2 != null) {
                    beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                }
                if (beginTransaction.isEmpty()) {
                    return;
                }
                beginTransaction.commitNow();
            }
        }

        void b(RecyclerView recyclerView) {
            c(recyclerView).unregisterOnPageChangeCallback(this.b);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f3577c);
            FragmentStateAdapter.this.f3566a.removeObserver(this.d);
            this.e = null;
        }
    }

    public FragmentStateAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public FragmentStateAdapter(FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.f3567c = new LongSparseArray<>();
        this.e = new LongSparseArray<>();
        this.f = new LongSparseArray<>();
        this.d = false;
        this.h = false;
        this.b = fragmentManager;
        this.f3566a = lifecycle;
        super.setHasStableIds(true);
    }

    private Long a(int i) {
        Long l = null;
        int i2 = 0;
        while (i2 < this.f.size()) {
            Long l2 = l;
            if (this.f.valueAt(i2).intValue() == i) {
                if (l != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                l2 = Long.valueOf(this.f.keyAt(i2));
            }
            i2++;
            l = l2;
        }
        return l;
    }

    private static String a(String str, long j) {
        return str + j;
    }

    private void a(final Fragment fragment, final FrameLayout frameLayout) {
        this.b.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment2, View view, Bundle bundle) {
                if (fragment2 == fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.this.a(view, frameLayout);
                }
            }
        }, false);
    }

    private boolean a(long j) {
        View view;
        if (this.f.containsKey(j)) {
            return true;
        }
        Fragment fragment = this.f3567c.get(j);
        return (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) ? false : true;
    }

    private static boolean a(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private static long b(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void b(int i) {
        long itemId = getItemId(i);
        if (this.f3567c.containsKey(itemId)) {
            return;
        }
        Fragment createFragment = createFragment(i);
        createFragment.setInitialSavedState(this.e.get(itemId));
        this.f3567c.put(itemId, createFragment);
    }

    private void b(long j) {
        ViewParent parent;
        Fragment fragment = this.f3567c.get(j);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j)) {
            this.e.remove(j);
        }
        if (!fragment.isAdded()) {
            this.f3567c.remove(j);
        } else if (b()) {
            this.h = true;
        } else {
            if (fragment.isAdded() && containsItem(j)) {
                this.e.put(j, this.b.saveFragmentInstanceState(fragment));
            }
            this.b.beginTransaction().remove(fragment).commitNow();
            this.f3567c.remove(j);
        }
    }

    private void c() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter.this.d = false;
                FragmentStateAdapter.this.a();
            }
        };
        this.f3566a.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(runnable, 10000L);
    }

    void a() {
        if (!this.h || b()) {
            return;
        }
        ArraySet<Long> arraySet = new ArraySet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3567c.size()) {
                break;
            }
            long keyAt = this.f3567c.keyAt(i2);
            if (!containsItem(keyAt)) {
                arraySet.add(Long.valueOf(keyAt));
                this.f.remove(keyAt);
            }
            i = i2 + 1;
        }
        if (!this.d) {
            this.h = false;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.f3567c.size()) {
                    break;
                }
                long keyAt2 = this.f3567c.keyAt(i4);
                if (!a(keyAt2)) {
                    arraySet.add(Long.valueOf(keyAt2));
                }
                i3 = i4 + 1;
            }
        }
        for (Long l : arraySet) {
            b(l.longValue());
        }
    }

    void a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    void a(final FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.f3567c.get(fragmentViewHolder.getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout a2 = fragmentViewHolder.a();
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            a(fragment, a2);
        } else if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != a2) {
                a(view, a2);
            }
        } else if (fragment.isAdded()) {
            a(view, a2);
        } else if (b()) {
            if (this.b.isDestroyed()) {
                return;
            }
            this.f3566a.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.b()) {
                        return;
                    }
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    if (ViewCompat.isAttachedToWindow(fragmentViewHolder.a())) {
                        FragmentStateAdapter.this.a(fragmentViewHolder);
                    }
                }
            });
        } else {
            a(fragment, a2);
            FragmentTransaction beginTransaction = this.b.beginTransaction();
            beginTransaction.add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
            this.g.a(false);
        }
    }

    boolean b() {
        return this.b.isStateSaved();
    }

    public boolean containsItem(long j) {
        return j >= 0 && j < ((long) getItemCount());
    }

    public abstract Fragment createFragment(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Preconditions.checkArgument(this.g == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.g = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.a(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final FragmentViewHolder fragmentViewHolder, int i) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.a().getId();
        Long a2 = a(id);
        if (a2 != null && a2.longValue() != itemId) {
            b(a2.longValue());
            this.f.remove(a2.longValue());
        }
        this.f.put(itemId, Integer.valueOf(id));
        b(i);
        final FrameLayout a3 = fragmentViewHolder.a();
        if (ViewCompat.isAttachedToWindow(a3)) {
            if (a3.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            a3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (a3.getParent() != null) {
                        a3.removeOnLayoutChangeListener(this);
                        FragmentStateAdapter.this.a(fragmentViewHolder);
                    }
                }
            });
        }
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return FragmentViewHolder.a(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.g.b(recyclerView);
        this.g = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        a(fragmentViewHolder);
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long a2 = a(fragmentViewHolder.a().getId());
        if (a2 != null) {
            b(a2.longValue());
            this.f.remove(a2.longValue());
        }
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(Parcelable parcelable) {
        if (!this.e.isEmpty() || !this.f3567c.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (a(str, "f#")) {
                this.f3567c.put(b(str, "f#"), this.b.getFragment(bundle, str));
            } else if (!a(str, "s#")) {
                throw new IllegalArgumentException("Unexpected key in savedState: " + str);
            } else {
                long b = b(str, "s#");
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(b)) {
                    this.e.put(b, savedState);
                }
            }
        }
        if (this.f3567c.isEmpty()) {
            return;
        }
        this.h = true;
        this.d = true;
        a();
        c();
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable saveState() {
        int i;
        Bundle bundle = new Bundle(this.f3567c.size() + this.e.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f3567c.size()) {
                break;
            }
            long keyAt = this.f3567c.keyAt(i3);
            Fragment fragment = this.f3567c.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.b.putFragment(bundle, a("f#", keyAt), fragment);
            }
            i2 = i3 + 1;
        }
        for (i = 0; i < this.e.size(); i++) {
            long keyAt2 = this.e.keyAt(i);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(a("s#", keyAt2), this.e.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }
}
