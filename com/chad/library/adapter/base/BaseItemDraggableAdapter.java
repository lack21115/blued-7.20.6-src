package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/BaseItemDraggableAdapter.class */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    /* renamed from: c  reason: collision with root package name */
    protected int f7947c;
    protected ItemTouchHelper d;
    protected boolean e;
    protected boolean f;
    protected OnItemDragListener g;
    protected OnItemSwipeListener h;
    protected boolean i;
    protected View.OnTouchListener j;
    protected View.OnLongClickListener k;

    public BaseItemDraggableAdapter(int i, List<T> list) {
        super(i, list);
        this.f7947c = 0;
        this.e = false;
        this.f = false;
        this.i = true;
    }

    private boolean b(int i) {
        return i >= 0 && i < this.mData.size();
    }

    public int a(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition() - getHeaderLayoutCount();
    }

    public void a(int i) {
        this.f7947c = i;
    }

    public void a(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z) {
        OnItemSwipeListener onItemSwipeListener = this.h;
        if (onItemSwipeListener == null || !this.f) {
            return;
        }
        onItemSwipeListener.a(canvas, viewHolder, f, f2, z);
    }

    public void a(ItemTouchHelper itemTouchHelper) {
        a(itemTouchHelper, 0, true);
    }

    public void a(ItemTouchHelper itemTouchHelper, int i, boolean z) {
        this.e = true;
        this.d = itemTouchHelper;
        a(i);
        b(z);
    }

    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        int a2 = a(viewHolder);
        int a3 = a(viewHolder2);
        if (b(a2) && b(a3)) {
            if (a2 >= a3) {
                int i = a2;
                while (true) {
                    int i2 = i;
                    if (i2 <= a3) {
                        break;
                    }
                    Collections.swap(this.mData, i2, i2 - 1);
                    i = i2 - 1;
                }
            } else {
                int i3 = a2;
                while (true) {
                    int i4 = i3;
                    if (i4 >= a3) {
                        break;
                    }
                    int i5 = i4 + 1;
                    Collections.swap(this.mData, i4, i5);
                    i3 = i5;
                }
            }
            notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.g;
        if (onItemDragListener == null || !this.e) {
            return;
        }
        onItemDragListener.a(viewHolder, a2, viewHolder2, a3);
    }

    public void a(OnItemDragListener onItemDragListener) {
        this.g = onItemDragListener;
    }

    public void b(RecyclerView.ViewHolder viewHolder) {
        OnItemDragListener onItemDragListener = this.g;
        if (onItemDragListener == null || !this.e) {
            return;
        }
        onItemDragListener.a(viewHolder, a(viewHolder));
    }

    public void b(boolean z) {
        this.i = z;
        if (z) {
            this.j = null;
            this.k = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (BaseItemDraggableAdapter.this.d == null || !BaseItemDraggableAdapter.this.e) {
                        return true;
                    }
                    BaseItemDraggableAdapter.this.d.startDrag((RecyclerView.ViewHolder) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
                    return true;
                }
            };
            return;
        }
        this.j = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEventCompat.getActionMasked(motionEvent) != 0 || BaseItemDraggableAdapter.this.i) {
                    return false;
                }
                if (BaseItemDraggableAdapter.this.d == null || !BaseItemDraggableAdapter.this.e) {
                    return true;
                }
                BaseItemDraggableAdapter.this.d.startDrag((RecyclerView.ViewHolder) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
                return true;
            }
        };
        this.k = null;
    }

    public void c(RecyclerView.ViewHolder viewHolder) {
        OnItemDragListener onItemDragListener = this.g;
        if (onItemDragListener == null || !this.e) {
            return;
        }
        onItemDragListener.b(viewHolder, a(viewHolder));
    }

    public void d(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener = this.h;
        if (onItemSwipeListener == null || !this.f) {
            return;
        }
        onItemSwipeListener.a(viewHolder, a(viewHolder));
    }

    public void e(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener = this.h;
        if (onItemSwipeListener == null || !this.f) {
            return;
        }
        onItemSwipeListener.b(viewHolder, a(viewHolder));
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener = this.h;
        if (onItemSwipeListener != null && this.f) {
            onItemSwipeListener.c(viewHolder, a(viewHolder));
        }
        int a2 = a(viewHolder);
        if (b(a2)) {
            this.mData.remove(a2);
            notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

    public void g() {
        this.f = true;
    }

    public void h() {
        this.f = false;
    }

    public boolean i() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BaseItemDraggableAdapter<T, K>) ((BaseViewHolder) viewHolder), i);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(K k, int i) {
        super.onBindViewHolder((BaseItemDraggableAdapter<T, K>) k, i);
        int itemViewType = k.getItemViewType();
        if (this.d == null || !this.e || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819) {
            return;
        }
        int i2 = this.f7947c;
        if (i2 == 0) {
            k.itemView.setTag(R.id.BaseQuickAdapter_viewholder_support, k);
            k.itemView.setOnLongClickListener(this.k);
            return;
        }
        View view = k.getView(i2);
        if (view != null) {
            view.setTag(R.id.BaseQuickAdapter_viewholder_support, k);
            if (this.i) {
                view.setOnLongClickListener(this.k);
            } else {
                view.setOnTouchListener(this.j);
            }
        }
    }
}
