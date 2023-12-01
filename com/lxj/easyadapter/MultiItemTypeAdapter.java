package com.lxj.easyadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.a;
import com.bytedance.applog.tracker.Tracker;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/MultiItemTypeAdapter.class */
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f10320a = new Companion(null);
    private final SparseArrayCompat<View> b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArrayCompat<View> f10321c;
    private ItemDelegateManager<T> d;
    private OnItemClickListener e;
    private List<? extends T> f;

    @Metadata
    /* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/MultiItemTypeAdapter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener.class */
    public interface OnItemClickListener {
        void a(View view, RecyclerView.ViewHolder viewHolder, int i);

        boolean b(View view, RecyclerView.ViewHolder viewHolder, int i);
    }

    @Metadata
    /* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/MultiItemTypeAdapter$SimpleOnItemClickListener.class */
    public static class SimpleOnItemClickListener implements OnItemClickListener {
        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.OnItemClickListener
        public void a(View view, RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.d(view, a.B);
            Intrinsics.d(viewHolder, "holder");
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.OnItemClickListener
        public boolean b(View view, RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.d(view, a.B);
            Intrinsics.d(viewHolder, "holder");
            return false;
        }
    }

    private final int a() {
        return (getItemCount() - c()) - d();
    }

    private final boolean b(int i) {
        return i < c();
    }

    private final boolean c(int i) {
        return i >= c() + a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.d(viewGroup, "parent");
        if (this.b.get(i) != null) {
            ViewHolder.Companion companion = ViewHolder.f10325a;
            View view = this.b.get(i);
            if (view == null) {
                Intrinsics.a();
            }
            return companion.a(view);
        } else if (this.f10321c.get(i) != null) {
            ViewHolder.Companion companion2 = ViewHolder.f10325a;
            View view2 = this.f10321c.get(i);
            if (view2 == null) {
                Intrinsics.a();
            }
            return companion2.a(view2);
        } else {
            int a2 = this.d.a(i).a();
            ViewHolder.Companion companion3 = ViewHolder.f10325a;
            Context context = viewGroup.getContext();
            Intrinsics.b(context, "parent.context");
            ViewHolder a3 = companion3.a(context, viewGroup, a2);
            a(a3, a3.a());
            a(viewGroup, a3, i);
            return a3;
        }
    }

    protected final void a(ViewGroup viewGroup, final ViewHolder viewHolder, int i) {
        Intrinsics.d(viewGroup, "parent");
        Intrinsics.d(viewHolder, "viewHolder");
        if (a(i)) {
            viewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.lxj.easyadapter.MultiItemTypeAdapter$setListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (MultiItemTypeAdapter.this.b() != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        int c2 = MultiItemTypeAdapter.this.c();
                        MultiItemTypeAdapter.OnItemClickListener b = MultiItemTypeAdapter.this.b();
                        if (b == null) {
                            Intrinsics.a();
                        }
                        Intrinsics.b(view, "v");
                        b.a(view, viewHolder, adapterPosition - c2);
                    }
                }
            });
            viewHolder.a().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lxj.easyadapter.MultiItemTypeAdapter$setListener$2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    if (MultiItemTypeAdapter.this.b() != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        int c2 = MultiItemTypeAdapter.this.c();
                        MultiItemTypeAdapter.OnItemClickListener b = MultiItemTypeAdapter.this.b();
                        if (b == null) {
                            Intrinsics.a();
                        }
                        Intrinsics.b(view, "v");
                        return b.b(view, viewHolder, adapterPosition - c2);
                    }
                    return false;
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewAttachedToWindow(ViewHolder viewHolder) {
        Intrinsics.d(viewHolder, "holder");
        ViewHolder viewHolder2 = viewHolder;
        super.onViewAttachedToWindow(viewHolder2);
        int layoutPosition = viewHolder.getLayoutPosition();
        if (b(layoutPosition) || c(layoutPosition)) {
            WrapperUtils.f10327a.a(viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.d(viewHolder, "holder");
        if (b(i) || c(i)) {
            return;
        }
        a(viewHolder, (ViewHolder) this.f.get(i - c()));
    }

    public final void a(ViewHolder viewHolder, View view) {
        Intrinsics.d(viewHolder, "holder");
        Intrinsics.d(view, "itemView");
    }

    public final void a(ViewHolder viewHolder, T t) {
        Intrinsics.d(viewHolder, "holder");
        this.d.a(viewHolder, t, viewHolder.getAdapterPosition() - c());
    }

    protected final boolean a(int i) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final OnItemClickListener b() {
        return this.e;
    }

    public final int c() {
        return this.b.size();
    }

    public final int d() {
        return this.f10321c.size();
    }

    protected final boolean e() {
        return this.d.a() > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return c() + d() + this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return b(i) ? this.b.keyAt(i) : c(i) ? this.f10321c.keyAt((i - c()) - a()) : !e() ? super.getItemViewType(i) : this.d.a(this.f.get(i - c()), i - c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.d(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        WrapperUtils.f10327a.a(recyclerView, new Function3<GridLayoutManager, GridLayoutManager.SpanSizeLookup, Integer, Integer>() { // from class: com.lxj.easyadapter.MultiItemTypeAdapter$onAttachedToRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final int a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i) {
                SparseArrayCompat sparseArrayCompat;
                SparseArrayCompat sparseArrayCompat2;
                Intrinsics.d(gridLayoutManager, "layoutManager");
                Intrinsics.d(spanSizeLookup, "oldLookup");
                int itemViewType = MultiItemTypeAdapter.this.getItemViewType(i);
                sparseArrayCompat = MultiItemTypeAdapter.this.b;
                if (sparseArrayCompat.get(itemViewType) != null) {
                    return gridLayoutManager.getSpanCount();
                }
                sparseArrayCompat2 = MultiItemTypeAdapter.this.f10321c;
                return sparseArrayCompat2.get(itemViewType) != null ? gridLayoutManager.getSpanCount() : spanSizeLookup.getSpanSize(i);
            }

            public /* synthetic */ Object a(Object obj, Object obj2, Object obj3) {
                return Integer.valueOf(a((GridLayoutManager) obj, (GridLayoutManager.SpanSizeLookup) obj2, ((Number) obj3).intValue()));
            }
        });
    }
}
