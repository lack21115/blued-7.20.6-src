package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ListAdapter.class */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    final AsyncListDiffer<T> f3299a;

    /* renamed from: androidx.recyclerview.widget.ListAdapter$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ListAdapter$1.class */
    class AnonymousClass1 implements AsyncListDiffer.ListListener<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ListAdapter f3300a;

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(List<T> list, List<T> list2) {
            this.f3300a.onCurrentListChanged(list, list2);
        }
    }

    public List<T> getCurrentList() {
        return this.f3299a.getCurrentList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f3299a.getCurrentList().size();
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    public void submitList(List<T> list) {
        this.f3299a.submitList(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.f3299a.submitList(list, runnable);
    }
}
