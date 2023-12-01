package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CustomTwoLevelHeader;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;
import com.soft.blued.customview.smartrefresh.TwoLevelNearbyRefreshView;
import com.soft.blued.ui.find.view.NearbyChatHostRoomView;
import com.soft.blued.ui.find.view.NearbyChatRoomView;
import com.soft.blued.ui.find.view.RecommendViewMixedInNearby;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyPeopleFragment_ViewBinding.class */
public class NearbyPeopleFragment_ViewBinding implements Unbinder {
    private NearbyPeopleFragment b;

    public NearbyPeopleFragment_ViewBinding(NearbyPeopleFragment nearbyPeopleFragment, View view) {
        this.b = nearbyPeopleFragment;
        nearbyPeopleFragment.mRefreshLayout = (SmartRefreshLayout) Utils.a(view, 2131369119, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        nearbyPeopleFragment.mRecyclerView = (RecyclerView) Utils.a(view, 2131369105, "field 'mRecyclerView'", RecyclerView.class);
        nearbyPeopleFragment.tabBar = (LinearLayout) Utils.a(view, R.id.tab_bar, "field 'tabBar'", LinearLayout.class);
        nearbyPeopleFragment.sortTabBar = (LinearLayout) Utils.a(view, R.id.sort_tab_bar, "field 'sortTabBar'", LinearLayout.class);
        nearbyPeopleFragment.layoutFilterReset = (LinearLayout) Utils.a(view, R.id.layout_filter_reset, "field 'layoutFilterReset'", LinearLayout.class);
        nearbyPeopleFragment.stvFilterReset = (ShapeTextView) Utils.a(view, R.id.stv_filter_reset, "field 'stvFilterReset'", ShapeTextView.class);
        nearbyPeopleFragment.mRecommendViewMixedInNearby = (RecommendViewMixedInNearby) Utils.a(view, R.id.recommend_view, "field 'mRecommendViewMixedInNearby'", RecommendViewMixedInNearby.class);
        nearbyPeopleFragment.mCallBtn = (RelativeLayout) Utils.a(view, R.id.rl_call_btn, "field 'mCallBtn'", RelativeLayout.class);
        nearbyPeopleFragment.mCallBtnState = (RelativeLayout) Utils.a(view, R.id.rl_call_btn_state, "field 'mCallBtnState'", RelativeLayout.class);
        nearbyPeopleFragment.rl_location_root = (RelativeLayout) Utils.a(view, R.id.rl_location_root, "field 'rl_location_root'", RelativeLayout.class);
        nearbyPeopleFragment.iv_icon = (ImageView) Utils.a(view, 2131365504, "field 'iv_icon'", ImageView.class);
        nearbyPeopleFragment.iv_close = (ImageView) Utils.a(view, 2131365207, "field 'iv_close'", ImageView.class);
        nearbyPeopleFragment.tv_distance = (TextView) Utils.a(view, 2131371285, "field 'tv_distance'", TextView.class);
        nearbyPeopleFragment.tv_location = (TextView) Utils.a(view, 2131371868, "field 'tv_location'", TextView.class);
        nearbyPeopleFragment.coordinator = (CoordinatorLayout) Utils.a(view, 2131363084, "field 'coordinator'", CoordinatorLayout.class);
        nearbyPeopleFragment.appbar = (AppBarLayout) Utils.a(view, 2131362292, "field 'appbar'", AppBarLayout.class);
        nearbyPeopleFragment.header = (CustomTwoLevelHeader) Utils.a(view, 2131364224, "field 'header'", CustomTwoLevelHeader.class);
        nearbyPeopleFragment.refresh_view = (TwoLevelNearbyRefreshView) Utils.a(view, 2131369121, "field 'refresh_view'", TwoLevelNearbyRefreshView.class);
        nearbyPeopleFragment.llRefresh = (LinearLayout) Utils.a(view, 2131368176, "field 'llRefresh'", LinearLayout.class);
        nearbyPeopleFragment.flBanner = (FrameLayout) Utils.a(view, 2131363756, "field 'flBanner'", FrameLayout.class);
        nearbyPeopleFragment.nearbyChatRoomView = (NearbyChatRoomView) Utils.a(view, R.id.nearby_chat_room, "field 'nearbyChatRoomView'", NearbyChatRoomView.class);
        nearbyPeopleFragment.nearbyChatRoomHostView = (NearbyChatHostRoomView) Utils.a(view, R.id.nearby_chat_room_host, "field 'nearbyChatRoomHostView'", NearbyChatHostRoomView.class);
        nearbyPeopleFragment.noDataAndLoadFailView = (NoDataAndLoadFailView) Utils.a(view, R.id.nodataview, "field 'noDataAndLoadFailView'", NoDataAndLoadFailView.class);
        nearbyPeopleFragment.locationNoDataView = (NoDataAndLoadFailView) Utils.a(view, R.id.request_location_nodata_view, "field 'locationNoDataView'", NoDataAndLoadFailView.class);
        nearbyPeopleFragment.clRedPackGuide = (ConstraintLayout) Utils.a(view, R.id.cl_red_pack_guide, "field 'clRedPackGuide'", ConstraintLayout.class);
        nearbyPeopleFragment.tvCardGuide = (TextView) Utils.a(view, R.id.tv_card_guide, "field 'tvCardGuide'", TextView.class);
        nearbyPeopleFragment.clCashOutGuide = (ConstraintLayout) Utils.a(view, R.id.cl_cash_out_guide, "field 'clCashOutGuide'", ConstraintLayout.class);
        nearbyPeopleFragment.tvRedPackGuideTitle = (TextView) Utils.a(view, R.id.tv_red_pack_guide_title, "field 'tvRedPackGuideTitle'", TextView.class);
        nearbyPeopleFragment.tvRedPackGuideSubtitle = (TextView) Utils.a(view, R.id.tv_red_pack_guide_subtitle, "field 'tvRedPackGuideSubtitle'", TextView.class);
        nearbyPeopleFragment.tvCashOutBtn = (ShapeTextView) Utils.a(view, R.id.tv_cash_out_btn, "field 'tvCashOutBtn'", ShapeTextView.class);
        nearbyPeopleFragment.redPackRecyclerView = (RecyclerView) Utils.a(view, R.id.red_pack_recycler_view, "field 'redPackRecyclerView'", RecyclerView.class);
        nearbyPeopleFragment.ivRedPackGuideClose = (ImageView) Utils.a(view, R.id.iv_red_pack_guide_close, "field 'ivRedPackGuideClose'", ImageView.class);
        nearbyPeopleFragment.ivRedPackGuideAnimation = (ImageView) Utils.a(view, R.id.iv_red_pack_guide_animation, "field 'ivRedPackGuideAnimation'", ImageView.class);
        nearbyPeopleFragment.llGuideAnimation = (LinearLayout) Utils.a(view, R.id.ll_guide_animation, "field 'llGuideAnimation'", LinearLayout.class);
        nearbyPeopleFragment.search_layout = (ShapeLinearLayout) Utils.a(view, R.id.search_layout, "field 'search_layout'", ShapeLinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NearbyPeopleFragment nearbyPeopleFragment = this.b;
        if (nearbyPeopleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        nearbyPeopleFragment.mRefreshLayout = null;
        nearbyPeopleFragment.mRecyclerView = null;
        nearbyPeopleFragment.tabBar = null;
        nearbyPeopleFragment.sortTabBar = null;
        nearbyPeopleFragment.layoutFilterReset = null;
        nearbyPeopleFragment.stvFilterReset = null;
        nearbyPeopleFragment.mRecommendViewMixedInNearby = null;
        nearbyPeopleFragment.mCallBtn = null;
        nearbyPeopleFragment.mCallBtnState = null;
        nearbyPeopleFragment.rl_location_root = null;
        nearbyPeopleFragment.iv_icon = null;
        nearbyPeopleFragment.iv_close = null;
        nearbyPeopleFragment.tv_distance = null;
        nearbyPeopleFragment.tv_location = null;
        nearbyPeopleFragment.coordinator = null;
        nearbyPeopleFragment.appbar = null;
        nearbyPeopleFragment.header = null;
        nearbyPeopleFragment.refresh_view = null;
        nearbyPeopleFragment.llRefresh = null;
        nearbyPeopleFragment.flBanner = null;
        nearbyPeopleFragment.nearbyChatRoomView = null;
        nearbyPeopleFragment.nearbyChatRoomHostView = null;
        nearbyPeopleFragment.noDataAndLoadFailView = null;
        nearbyPeopleFragment.locationNoDataView = null;
        nearbyPeopleFragment.clRedPackGuide = null;
        nearbyPeopleFragment.tvCardGuide = null;
        nearbyPeopleFragment.clCashOutGuide = null;
        nearbyPeopleFragment.tvRedPackGuideTitle = null;
        nearbyPeopleFragment.tvRedPackGuideSubtitle = null;
        nearbyPeopleFragment.tvCashOutBtn = null;
        nearbyPeopleFragment.redPackRecyclerView = null;
        nearbyPeopleFragment.ivRedPackGuideClose = null;
        nearbyPeopleFragment.ivRedPackGuideAnimation = null;
        nearbyPeopleFragment.llGuideAnimation = null;
        nearbyPeopleFragment.search_layout = null;
    }
}
