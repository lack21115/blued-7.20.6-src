package com.soft.blued.ui.discover.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/fragment/DiscoveryPageFragment_ViewBinding.class */
public class DiscoveryPageFragment_ViewBinding implements Unbinder {
    private DiscoveryPageFragment b;

    public DiscoveryPageFragment_ViewBinding(DiscoveryPageFragment discoveryPageFragment, View view) {
        this.b = discoveryPageFragment;
        discoveryPageFragment.vpIndicator = (TabPageIndicatorWithDot) Utils.a(view, 2131373299, "field 'vpIndicator'", TabPageIndicatorWithDot.class);
        discoveryPageFragment.title = Utils.a(view, 2131370694, "field 'title'");
        discoveryPageFragment.cttLeft = (ImageView) Utils.a(view, 2131363120, "field 'cttLeft'", ImageView.class);
        discoveryPageFragment.cttRightText = (TextView) Utils.a(view, 2131363135, "field 'cttRightText'", TextView.class);
        discoveryPageFragment.imgNearbyAd = (ImageView) Utils.a(view, R.id.img_nearby_ad, "field 'imgNearbyAd'", ImageView.class);
        discoveryPageFragment.bluedAdLayout = (BluedADConstraintLayout) Utils.a(view, R.id.blued_ad_layout, "field 'bluedAdLayout'", BluedADConstraintLayout.class);
        discoveryPageFragment.cttRight = (ImageView) Utils.a(view, 2131363126, "field 'cttRight'", ImageView.class);
        discoveryPageFragment.imgRightNewDot = (ShapeTextView) Utils.a(view, R.id.img_right_new_dot, "field 'imgRightNewDot'", ShapeTextView.class);
        discoveryPageFragment.cttRightMenu = (FrameLayout) Utils.a(view, 2131363133, "field 'cttRightMenu'", FrameLayout.class);
        discoveryPageFragment.viewPager = (CustomViewPager) Utils.a(view, 2131373209, "field 'viewPager'", CustomViewPager.class);
        discoveryPageFragment.findBadgeContainer = (QBadgeContainer) Utils.a(view, R.id.find_badge_container, "field 'findBadgeContainer'", QBadgeContainer.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DiscoveryPageFragment discoveryPageFragment = this.b;
        if (discoveryPageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        discoveryPageFragment.vpIndicator = null;
        discoveryPageFragment.title = null;
        discoveryPageFragment.cttLeft = null;
        discoveryPageFragment.cttRightText = null;
        discoveryPageFragment.imgNearbyAd = null;
        discoveryPageFragment.bluedAdLayout = null;
        discoveryPageFragment.cttRight = null;
        discoveryPageFragment.imgRightNewDot = null;
        discoveryPageFragment.cttRightMenu = null;
        discoveryPageFragment.viewPager = null;
        discoveryPageFragment.findBadgeContainer = null;
    }
}
