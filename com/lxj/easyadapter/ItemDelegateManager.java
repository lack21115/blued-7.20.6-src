package com.lxj.easyadapter;

import androidx.collection.SparseArrayCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7994992-dex2jar.jar:com/lxj/easyadapter/ItemDelegateManager.class */
public final class ItemDelegateManager<T> {

    /* renamed from: a  reason: collision with root package name */
    private SparseArrayCompat<ItemDelegate<T>> f10319a = new SparseArrayCompat<>();

    public final int a() {
        return this.f10319a.size();
    }

    public final int a(T t, int i) {
        int size = this.f10319a.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                throw new IllegalArgumentException("No ItemDelegate added that matches position=" + i + " in data source");
            } else if (this.f10319a.valueAt(i2).a(t, i)) {
                return this.f10319a.keyAt(i2);
            } else {
                size = i2;
            }
        }
    }

    public final ItemDelegate<T> a(int i) {
        ItemDelegate<T> itemDelegate = this.f10319a.get(i);
        if (itemDelegate == null) {
            Intrinsics.a();
        }
        return itemDelegate;
    }

    public final void a(ViewHolder viewHolder, T t, int i) {
        Intrinsics.d(viewHolder, "holder");
        int size = this.f10319a.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                throw new IllegalArgumentException("No ItemDelegateManager added that matches position=" + i + " in data source");
            }
            ItemDelegate<T> valueAt = this.f10319a.valueAt(i3);
            if (valueAt.a(t, i)) {
                valueAt.a(viewHolder, t, i);
                return;
            }
            i2 = i3 + 1;
        }
    }
}
