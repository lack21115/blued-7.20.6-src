package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncListDiffer.class */
public class AsyncListDiffer<T> {
    private static final Executor e = new MainThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    final AsyncDifferConfig<T> f3218a;
    Executor b;

    /* renamed from: c  reason: collision with root package name */
    int f3219c;
    private final ListUpdateCallback d;
    private final List<ListListener<T>> f;
    private List<T> g;
    private List<T> h;

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncListDiffer$ListListener.class */
    public interface ListListener<T> {
        void onCurrentListChanged(List<T> list, List<T> list2);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AsyncListDiffer$MainThreadExecutor.class */
    static class MainThreadExecutor implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Handler f3224a = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f3224a.post(runnable);
        }
    }

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.f = new CopyOnWriteArrayList();
        this.h = Collections.emptyList();
        this.d = listUpdateCallback;
        this.f3218a = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.b = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.b = e;
        }
    }

    public AsyncListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    private void a(List<T> list, Runnable runnable) {
        for (ListListener<T> listListener : this.f) {
            listListener.onCurrentListChanged(list, this.h);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    void a(List<T> list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        List<T> list2 = this.h;
        this.g = list;
        this.h = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.d);
        a(list2, runnable);
    }

    public void addListListener(ListListener<T> listListener) {
        this.f.add(listListener);
    }

    public List<T> getCurrentList() {
        return this.h;
    }

    public void removeListListener(ListListener<T> listListener) {
        this.f.remove(listListener);
    }

    public void submitList(List<T> list) {
        submitList(list, null);
    }

    public void submitList(final List<T> list, final Runnable runnable) {
        final int i = this.f3219c + 1;
        this.f3219c = i;
        final List<T> list2 = this.g;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.h;
        if (list == null) {
            int size = list2.size();
            this.g = null;
            this.h = Collections.emptyList();
            this.d.onRemoved(0, size);
            a(list3, runnable);
        } else if (list2 != null) {
            this.f3218a.getBackgroundThreadExecutor().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areContentsTheSame(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj == null || obj2 == null) {
                                if (obj == null && obj2 == null) {
                                    return true;
                                }
                                throw new AssertionError();
                            }
                            return AsyncListDiffer.this.f3218a.getDiffCallback().areContentsTheSame(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areItemsTheSame(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.f3218a.getDiffCallback().areItemsTheSame(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public Object getChangePayload(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj == null || obj2 == null) {
                                throw new AssertionError();
                            }
                            return AsyncListDiffer.this.f3218a.getDiffCallback().getChangePayload(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getNewListSize() {
                            return list.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getOldListSize() {
                            return list2.size();
                        }
                    });
                    AsyncListDiffer.this.b.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AsyncListDiffer.this.f3219c == i) {
                                AsyncListDiffer.this.a(list, calculateDiff, runnable);
                            }
                        }
                    });
                }
            });
        } else {
            this.g = list;
            this.h = Collections.unmodifiableList(list);
            this.d.onInserted(0, list.size());
            a(list3, runnable);
        }
    }
}
