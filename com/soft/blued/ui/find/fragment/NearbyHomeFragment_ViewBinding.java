package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.NearbyHomeTabIndicator;
import com.soft.blued.customview.NearbyHomeViewPager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyHomeFragment_ViewBinding.class */
public class NearbyHomeFragment_ViewBinding implements Unbinder {
    private NearbyHomeFragment b;

    public NearbyHomeFragment_ViewBinding(NearbyHomeFragment nearbyHomeFragment, View view) {
        this.b = nearbyHomeFragment;
        nearbyHomeFragment.second_floor = (ImageView) Utils.a(view, R.id.second_floor, "field 'second_floor'", ImageView.class);
        nearbyHomeFragment.fl_floor = (FrameLayout) Utils.a(view, R.id.fl_floor, "field 'fl_floor'", FrameLayout.class);
        nearbyHomeFragment.second_floor_ad_icon = (ShapeTextView) Utils.a(view, R.id.second_floor_ad_icon, "field 'second_floor_ad_icon'", ShapeTextView.class);
        nearbyHomeFragment.indicatorTitle = (NearbyHomeTabIndicator) Utils.a(view, R.id.vp_indicator, "field 'indicatorTitle'", NearbyHomeTabIndicator.class);
        nearbyHomeFragment.mTitleLeft = (ImageView) Utils.a(view, 2131363120, "field 'mTitleLeft'", ImageView.class);
        nearbyHomeFragment.imgNewLeftRemind = (ShapeTextView) Utils.a(view, R.id.img_new_remind_visitor, "field 'imgNewLeftRemind'", ShapeTextView.class);
        nearbyHomeFragment.mTitleRightText = (TextView) Utils.a(view, R.id.ctt_right_text, "field 'mTitleRightText'", TextView.class);
        nearbyHomeFragment.mTitleRight = (ImageView) Utils.a(view, 2131363126, "field 'mTitleRight'", ImageView.class);
        nearbyHomeFragment.mTitleRightDot = (ShapeTextView) Utils.a(view, R.id.img_right_new_dot, "field 'mTitleRightDot'", ShapeTextView.class);
        nearbyHomeFragment.mTitleRightMenu = (FrameLayout) Utils.a(view, R.id.ctt_right_menu, "field 'mTitleRightMenu'", FrameLayout.class);
        nearbyHomeFragment.mViewPager = (NearbyHomeViewPager) Utils.a(view, R.id.main_find_viewpager, "field 'mViewPager'", NearbyHomeViewPager.class);
        nearbyHomeFragment.mTitle = Utils.a(view, 2131370694, "field 'mTitle'");
        nearbyHomeFragment.adConstraintLayout = (BluedADConstraintLayout) Utils.a(view, R.id.blued_ad_layout, "field 'adConstraintLayout'", BluedADConstraintLayout.class);
        nearbyHomeFragment.adNearbyImg = (ImageView) Utils.a(view, R.id.img_nearby_ad, "field 'adNearbyImg'", ImageView.class);
        nearbyHomeFragment.tvTip = (TextView) Utils.a(view, R.id.tv_tip, "field 'tvTip'", TextView.class);
        nearbyHomeFragment.nearbyActivityTip = (TextView) Utils.a(view, R.id.nearby_activity_tip, "field 'nearbyActivityTip'", TextView.class);
        nearbyHomeFragment.ivGoldGuide1 = (ImageView) Utils.a(view, R.id.iv_gold_guide_1, "field 'ivGoldGuide1'", ImageView.class);
        nearbyHomeFragment.ivGoldGuide2 = (ImageView) Utils.a(view, R.id.iv_gold_guide_2, "field 'ivGoldGuide2'", ImageView.class);
        nearbyHomeFragment.ivGoldGuide3 = (ImageView) Utils.a(view, R.id.iv_gold_guide_3, "field 'ivGoldGuide3'", ImageView.class);
        nearbyHomeFragment.ivGoldGuide4 = (ImageView) Utils.a(view, R.id.iv_gold_guide_4, "field 'ivGoldGuide4'", ImageView.class);
        nearbyHomeFragment.ivGoldGuide5 = (ImageView) Utils.a(view, R.id.iv_gold_guide_5, "field 'ivGoldGuide5'", ImageView.class);
        nearbyHomeFragment.tvSignDaysTip = (TextView) Utils.a(view, R.id.tv_sign_days_tip, "field 'tvSignDaysTip'", TextView.class);
        nearbyHomeFragment.viewCityNew = (TextView) Utils.a(view, R.id.view_city_new_tv, "field 'viewCityNew'", TextView.class);
        nearbyHomeFragment.tvMapTip = (TextView) Utils.a(view, R.id.tv_map_tip, "field 'tvMapTip'", TextView.class);
        nearbyHomeFragment.layoutGoldGuide = Utils.a(view, R.id.layout_gold_guide, "field 'layoutGoldGuide'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NearbyHomeFragment nearbyHomeFragment = this.b;
        if (nearbyHomeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        nearbyHomeFragment.second_floor = null;
        nearbyHomeFragment.fl_floor = null;
        nearbyHomeFragment.second_floor_ad_icon = null;
        nearbyHomeFragment.indicatorTitle = null;
        nearbyHomeFragment.mTitleLeft = null;
        nearbyHomeFragment.imgNewLeftRemind = null;
        nearbyHomeFragment.mTitleRightText = null;
        nearbyHomeFragment.mTitleRight = null;
        nearbyHomeFragment.mTitleRightDot = null;
        nearbyHomeFragment.mTitleRightMenu = null;
        nearbyHomeFragment.mViewPager = null;
        nearbyHomeFragment.mTitle = null;
        nearbyHomeFragment.adConstraintLayout = null;
        nearbyHomeFragment.adNearbyImg = null;
        nearbyHomeFragment.tvTip = null;
        nearbyHomeFragment.nearbyActivityTip = null;
        nearbyHomeFragment.ivGoldGuide1 = null;
        nearbyHomeFragment.ivGoldGuide2 = null;
        nearbyHomeFragment.ivGoldGuide3 = null;
        nearbyHomeFragment.ivGoldGuide4 = null;
        nearbyHomeFragment.ivGoldGuide5 = null;
        nearbyHomeFragment.tvSignDaysTip = null;
        nearbyHomeFragment.viewCityNew = null;
        nearbyHomeFragment.tvMapTip = null;
        nearbyHomeFragment.layoutGoldGuide = null;
    }
}
