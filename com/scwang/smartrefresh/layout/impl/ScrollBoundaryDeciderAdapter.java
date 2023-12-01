package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/impl/ScrollBoundaryDeciderAdapter.class */
public class ScrollBoundaryDeciderAdapter implements ScrollBoundaryDecider {

    /* renamed from: a  reason: collision with root package name */
    public PointF f14304a;
    public ScrollBoundaryDecider b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14305c = true;

    @Override // com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
    public boolean a(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.b;
        return scrollBoundaryDecider != null ? scrollBoundaryDecider.a(view) : ScrollBoundaryUtil.a(view, this.f14304a);
    }

    @Override // com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
    public boolean b(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.b;
        return scrollBoundaryDecider != null ? scrollBoundaryDecider.b(view) : ScrollBoundaryUtil.a(view, this.f14304a, this.f14305c);
    }
}
