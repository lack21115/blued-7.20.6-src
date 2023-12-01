package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ao;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/recycle/f.class */
public final class f {
    final RecyclerView MS;
    final RecyclerView.LayoutManager MT;

    private f(RecyclerView recyclerView) {
        this.MS = recyclerView;
        this.MT = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper createVerticalHelper = this.MT.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.MT) : OrientationHelper.createHorizontalHelper(this.MT);
        int startAfterPadding = createVerticalHelper.getStartAfterPadding();
        int endAfterPadding = createVerticalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = this.MT.getChildAt(i);
            int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        ao.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View a2 = a(0, this.MT.getChildCount(), false, true);
        if (a2 == null) {
            return -1;
        }
        return this.MS.getChildAdapterPosition(a2);
    }

    public final int findLastVisibleItemPosition() {
        View a2 = a(this.MT.getChildCount() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return this.MS.getChildAdapterPosition(a2);
    }
}
