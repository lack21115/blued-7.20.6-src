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
    private StickyHeaderPositioner f20640a;
    private StickyHeaderHandler b;

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f20641c;
    private ViewRetriever.RecyclerViewRetriever d;
    private int e;
    private StickyHeaderListener f;

    public StickyLayoutManager(Context context, int i, boolean z, StickyHeaderHandler stickyHeaderHandler) {
        super(context, i, z);
        this.f20641c = new ArrayList();
        this.e = -1;
        a(stickyHeaderHandler);
    }

    public StickyLayoutManager(Context context, StickyHeaderHandler stickyHeaderHandler) {
        this(context, 1, false, stickyHeaderHandler);
        a(stickyHeaderHandler);
    }

    private void a() {
        this.f20640a.b(getOrientation());
        this.f20640a.a(findFirstVisibleItemPosition(), b(), this.d, findFirstCompletelyVisibleItemPosition() == 0);
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
            if (this.f20641c.contains(Integer.valueOf(position))) {
                linkedHashMap.put(Integer.valueOf(position), childAt);
            }
            i = i2 + 1;
        }
    }

    private void c() {
        this.f20641c.clear();
        List<?> a2 = this.b.a();
        if (a2 == null) {
            StickyHeaderPositioner stickyHeaderPositioner = this.f20640a;
            if (stickyHeaderPositioner != null) {
                stickyHeaderPositioner.a(this.f20641c);
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
                this.f20641c.add(Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
        StickyHeaderPositioner stickyHeaderPositioner2 = this.f20640a;
        if (stickyHeaderPositioner2 != null) {
            stickyHeaderPositioner2.a(this.f20641c);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        Preconditions.a(recyclerView);
        this.d = new ViewRetriever.RecyclerViewRetriever(recyclerView);
        StickyHeaderPositioner stickyHeaderPositioner = new StickyHeaderPositioner(recyclerView);
        this.f20640a = stickyHeaderPositioner;
        stickyHeaderPositioner.a(this.e);
        this.f20640a.a(this.f);
        if (this.f20641c.size() > 0) {
            this.f20640a.a(this.f20641c);
            a();
        }
        super.onAttachedToWindow(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        c();
        if (this.f20640a != null) {
            a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        super.removeAndRecycleAllViews(recycler);
        StickyHeaderPositioner stickyHeaderPositioner = this.f20640a;
        if (stickyHeaderPositioner != null) {
            stickyHeaderPositioner.a();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        StickyHeaderPositioner stickyHeaderPositioner;
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        if (Math.abs(scrollHorizontallyBy) > 0 && (stickyHeaderPositioner = this.f20640a) != null) {
            stickyHeaderPositioner.a(findFirstVisibleItemPosition(), b(), this.d, findFirstCompletelyVisibleItemPosition() == 0);
        }
        return scrollHorizontallyBy;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        StickyHeaderPositioner stickyHeaderPositioner;
        int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        if (Math.abs(scrollVerticallyBy) > 0 && (stickyHeaderPositioner = this.f20640a) != null) {
            stickyHeaderPositioner.a(findFirstVisibleItemPosition(), b(), this.d, findFirstCompletelyVisibleItemPosition() == 0);
        }
        return scrollVerticallyBy;
    }
}
