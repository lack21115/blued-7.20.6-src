package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/AdapterListUpdateCallback.class */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.Adapter f3165a;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.f3165a = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.f3165a.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.f3165a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.f3165a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.f3165a.notifyItemRangeRemoved(i, i2);
    }
}
