package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.ui.find.view.FloatSpreadView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveFragment_ViewBinding.class */
public class LiveFragment_ViewBinding implements Unbinder {
    private LiveFragment b;

    public LiveFragment_ViewBinding(LiveFragment liveFragment, View view) {
        this.b = liveFragment;
        liveFragment.mTitle = Utils.a(view, 2131370694, "field 'mTitle'");
        liveFragment.mTitleLeft = (ImageView) Utils.a(view, 2131363120, "field 'mTitleLeft'", ImageView.class);
        liveFragment.layoutTitleRight = (FrameLayout) Utils.a(view, 2131363133, "field 'layoutTitleRight'", FrameLayout.class);
        liveFragment.mTitleRight = (ImageView) Utils.a(view, 2131363126, "field 'mTitleRight'", ImageView.class);
        liveFragment.layoutTitleRequestLive = Utils.a(view, R.id.live_request_live_title_id, "field 'layoutTitleRequestLive'");
        liveFragment.ivTitleRequestLive = (ImageView) Utils.a(view, R.id.live_request_live_title_hand_iv, "field 'ivTitleRequestLive'", ImageView.class);
        liveFragment.tvTitleRequestLive = (TextView) Utils.a(view, R.id.live_request_live_title_count_tv, "field 'tvTitleRequestLive'", TextView.class);
        liveFragment.tvTitleRequestLiveSecond = (TextView) Utils.a(view, R.id.live_request_live_title_count_second_tv, "field 'tvTitleRequestLiveSecond'", TextView.class);
        liveFragment.layoutTitleRequestLiveCount = Utils.a(view, R.id.live_request_live_title_count_layout, "field 'layoutTitleRequestLiveCount'");
        liveFragment.mRightNewDot = (ShapeTextView) Utils.a(view, R.id.img_right_new_dot, "field 'mRightNewDot'", ShapeTextView.class);
        liveFragment.mTitleBarRoot = (FrameLayout) Utils.a(view, R.id.fl_title_bar_root, "field 'mTitleBarRoot'", FrameLayout.class);
        liveFragment.mViewPager = (CustomViewPager) Utils.a(view, R.id.main_live_viewpager, "field 'mViewPager'", CustomViewPager.class);
        liveFragment.indicator = (TabPageIndicatorWithDot) Utils.a(view, 2131373299, "field 'indicator'", TabPageIndicatorWithDot.class);
        liveFragment.view_soft = Utils.a(view, R.id.soft, "field 'view_soft'");
        liveFragment.view_hard = Utils.a(view, R.id.hard, "field 'view_hard'");
        liveFragment.beauty_open = Utils.a(view, R.id.beauty_open, "field 'beauty_open'");
        liveFragment.beauty_close = Utils.a(view, R.id.beauty_close, "field 'beauty_close'");
        liveFragment.mFloatSpreadView = (FloatSpreadView) Utils.a(view, R.id.fsv_spread, "field 'mFloatSpreadView'", FloatSpreadView.class);
        liveFragment.fl_floor = Utils.a(view, R.id.fl_floor, "field 'fl_floor'");
        liveFragment.second_floor = (ImageView) Utils.a(view, R.id.second_floor, "field 'second_floor'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveFragment liveFragment = this.b;
        if (liveFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveFragment.mTitle = null;
        liveFragment.mTitleLeft = null;
        liveFragment.layoutTitleRight = null;
        liveFragment.mTitleRight = null;
        liveFragment.layoutTitleRequestLive = null;
        liveFragment.ivTitleRequestLive = null;
        liveFragment.tvTitleRequestLive = null;
        liveFragment.tvTitleRequestLiveSecond = null;
        liveFragment.layoutTitleRequestLiveCount = null;
        liveFragment.mRightNewDot = null;
        liveFragment.mTitleBarRoot = null;
        liveFragment.mViewPager = null;
        liveFragment.indicator = null;
        liveFragment.view_soft = null;
        liveFragment.view_hard = null;
        liveFragment.beauty_open = null;
        liveFragment.beauty_close = null;
        liveFragment.mFloatSpreadView = null;
        liveFragment.fl_floor = null;
        liveFragment.second_floor = null;
    }
}
