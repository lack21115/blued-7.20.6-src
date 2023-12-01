package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.CustomTwoLevelHeader;
import com.blued.android.module.common.view.LinePageIndicator;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.soft.blued.R;
import com.soft.blued.customview.LiveHotPullToRefreshLayout;
import com.soft.blued.customview.smartrefresh.TwoLevelRefreshView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveHomeFragment_ViewBinding.class */
public class LiveHomeFragment_ViewBinding implements Unbinder {
    private LiveHomeFragment b;

    public LiveHomeFragment_ViewBinding(LiveHomeFragment liveHomeFragment, View view) {
        this.b = liveHomeFragment;
        liveHomeFragment.swipe_view = (LiveHotPullToRefreshLayout) Utils.a(view, R.id.swipe_view, "field 'swipe_view'", LiveHotPullToRefreshLayout.class);
        liveHomeFragment.ll_tab = Utils.a(view, R.id.ll_tab, "field 'll_tab'");
        liveHomeFragment.refreshLayout = (RefreshLayout) Utils.a(view, 2131369116, "field 'refreshLayout'", RefreshLayout.class);
        liveHomeFragment.header = (CustomTwoLevelHeader) Utils.a(view, R.id.header, "field 'header'", CustomTwoLevelHeader.class);
        liveHomeFragment.refresh_view = (TwoLevelRefreshView) Utils.a(view, R.id.refresh_view, "field 'refresh_view'", TwoLevelRefreshView.class);
        liveHomeFragment.asvp_banner_hot_parent = (FrameLayout) Utils.a(view, R.id.asvp_banner_hot_parent, "field 'asvp_banner_hot_parent'", FrameLayout.class);
        liveHomeFragment.asvp_banner_hot_new = (AutoScrollViewPager) Utils.a(view, R.id.asvp_banner_hot_new, "field 'asvp_banner_hot_new'", AutoScrollViewPager.class);
        liveHomeFragment.lpi_line = (LinePageIndicator) Utils.a(view, 2131368404, "field 'lpi_line'", LinePageIndicator.class);
        liveHomeFragment.live_banner = (FrameLayout) Utils.a(view, R.id.live_banner, "field 'live_banner'", FrameLayout.class);
        liveHomeFragment.tv_living_count = (TextView) Utils.a(view, R.id.tv_living_count, "field 'tv_living_count'", TextView.class);
        liveHomeFragment.living_count = (ShapeLinearLayout) Utils.a(view, R.id.living_count, "field 'living_count'", ShapeLinearLayout.class);
        liveHomeFragment.main_live_new_viewpager = (ViewPager) Utils.a(view, R.id.main_live_new_viewpager, "field 'main_live_new_viewpager'", ViewPager.class);
        liveHomeFragment.recycle_view_cateroty = (RecyclerView) Utils.a(view, R.id.recycle_view_cateroty, "field 'recycle_view_cateroty'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveHomeFragment liveHomeFragment = this.b;
        if (liveHomeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveHomeFragment.swipe_view = null;
        liveHomeFragment.ll_tab = null;
        liveHomeFragment.refreshLayout = null;
        liveHomeFragment.header = null;
        liveHomeFragment.refresh_view = null;
        liveHomeFragment.asvp_banner_hot_parent = null;
        liveHomeFragment.asvp_banner_hot_new = null;
        liveHomeFragment.lpi_line = null;
        liveHomeFragment.live_banner = null;
        liveHomeFragment.tv_living_count = null;
        liveHomeFragment.living_count = null;
        liveHomeFragment.main_live_new_viewpager = null;
        liveHomeFragment.recycle_view_cateroty = null;
    }
}
