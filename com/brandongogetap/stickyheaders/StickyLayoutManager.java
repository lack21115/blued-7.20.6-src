package com.brandongogetap.stickyheaders;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.brandongogetap.stickyheaders.ViewRetriever;
import com.brandongogetap.stickyheaders.exposed.StickyHeader;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/brandongogetap/stickyheaders/StickyLayoutManager.class */
public class StickyLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private StickyHeaderPositioner f7034a;
    private StickyHeaderHandler b;

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f7035c;
    private ViewRetriever.RecyclerViewRetriever d;
    private int e;
    private StickyHeaderListener f;

    public StickyLayoutManager(Context context, int i, boolean z, StickyHeaderHandler stickyHeaderHandler) {
        super(context, i, z);
        this.f7035c = new ArrayList();
        this.e = -1;
        a(stickyHeaderHandler);
    }

    public StickyLayoutManager(Context context, StickyHeaderHandler stickyHeaderHandler) {
        this(context, 1, false, stickyHeaderHandler);
        a(stickyHeaderHandler);
    }

    private void a() {
        this.f7034a.b(getOrientation());
        this.f7034a.a(findFirstVisibleItemPosition(), b(), this.d, findFirstCompletelyVisibleItemPosition() == 0);
    }

    private void a(StickyHeaderHandler stickyHeaderHandler) {
        Preconditions.a(stickyHeaderHandler, "StickyHeaderHandler == null");
        this.b = stickyHeaderHandler;
    }

    private Map<Integer, View> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return linkedHashMap;
            }
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (this.f7035c.contains(Integer.valueOf(position))) {
                linkedHashMap.put(Integer.valueOf(position), childAt);
            }
            i = i2 + 1;
        }
    }

    private void c() {
        this.f7035c.clear();
        List<?> a2 = this.b.a();
        if (a2 == null) {
            StickyHeaderPositioner stickyHeaderPositioner = this.f7034a;
            if (stickyHeaderPositioner != null) {
                stickyHeaderPositioner.a(this.f7035c);
                return;
            }
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.size()) {
                break;
            }
            if (a2.get(i2) instanceof StickyHeader) {
                this.f7035c.add(Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
        StickyHeaderPositioner stickyHeaderPositioner2 = this.f7034a;
        if (stickyHeaderPositioner2 != null) {
            stickyHeaderPositioner2.a(this.f7035c);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        Preconditions.a(recyclerView);
        this.d = new ViewRetriever.RecyclerViewRetriever(recyclerView);
        StickyHeaderPositioner stickyHeaderPositioner = new StickyHeaderPositioner(recyclerView);
        this.f7034a = stickyHeaderPositioner;
        stickyHeaderPositioner.a(this.e);
        this.f7034a.a(this.f);
        if (this.f7035c.size() > 0) {
            this.f7034a.a(this.f7035c);
            a();
        }
        super.onAttachedToWindow(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        c();
        if (this.f7034a != null) {
            a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        super.removeAndRecycleAllViews(recycler);
        StickyHeaderPositioner stickyHeaderPositioner = this.f7034a;
        if (stickyHeaderPositioner != null) {
            stickyHeaderPositioner.a();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        StickyHeaderPositioner stickyHeaderPositioner;
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        if (Math.abs(scrollHorizontallyBy) > 0 && (stickyHeaderPositioner = this.f7034a) != null) {
            stickyHeaderPositioner.a(findFirstVisibleItemPosition(), b(), this.d, findFirstCompletelyVisibleItemPosition() == 0);
        }
        return scrollHorizontallyBy;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        StickyHeaderPositioner stickyHeaderPositioner;
        int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        if (Math.abs(scrollVerticallyBy) > 0 && (stickyHeaderPositioner = this.f7034a) != null) {
            stickyHeaderPositioner.a(findFirstVisibleItemPosition(), b(), this.d, findFirstCompletelyVisibleItemPosition() == 0);
        }
        return scrollVerticallyBy;
    }
}
