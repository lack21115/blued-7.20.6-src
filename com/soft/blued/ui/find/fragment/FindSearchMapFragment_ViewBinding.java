package com.soft.blued.ui.find.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.ui.find.view.CustomCircleView;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapFragment_ViewBinding.class */
public class FindSearchMapFragment_ViewBinding implements Unbinder {
    private FindSearchMapFragment b;

    public FindSearchMapFragment_ViewBinding(FindSearchMapFragment findSearchMapFragment, View view) {
        this.b = findSearchMapFragment;
        findSearchMapFragment.mapView = (TextureMapView) Utils.a(view, R.id.map_view, "field 'mapView'", TextureMapView.class);
        findSearchMapFragment.tvHeaderOption = (ShapeTextView) Utils.a(view, R.id.tv_header_option, "field 'tvHeaderOption'", ShapeTextView.class);
        findSearchMapFragment.circleGuideView = (CustomCircleView) Utils.a(view, R.id.circle_view_guide, "field 'circleGuideView'", CustomCircleView.class);
        findSearchMapFragment.clGuide1 = (ConstraintLayout) Utils.a(view, R.id.cl_guide_1, "field 'clGuide1'", ConstraintLayout.class);
        findSearchMapFragment.ivStartHeaderLocation = (ImageView) Utils.a(view, R.id.iv_start_header_location, "field 'ivStartHeaderLocation'", ImageView.class);
        findSearchMapFragment.clGuide2 = (ConstraintLayout) Utils.a(view, R.id.cl_guide_2, "field 'clGuide2'", ConstraintLayout.class);
        findSearchMapFragment.ivSearchShadowGuide = (ImageView) Utils.a(view, R.id.iv_search_shadow_guide, "field 'ivSearchShadowGuide'", ImageView.class);
        findSearchMapFragment.clGuide3 = (ConstraintLayout) Utils.a(view, R.id.cl_guide_3, "field 'clGuide3'", ConstraintLayout.class);
        findSearchMapFragment.ivSetShadowGuide = (ImageView) Utils.a(view, R.id.iv_set_shadow_guide, "field 'ivSetShadowGuide'", ImageView.class);
        findSearchMapFragment.searchView = (ShapeTextView) Utils.a(view, R.id.tv_search_view, "field 'searchView'", ShapeTextView.class);
        findSearchMapFragment.ivReturnMyPosition = (ImageView) Utils.a(view, R.id.iv_return_my_position, "field 'ivReturnMyPosition'", ImageView.class);
        findSearchMapFragment.ivLeftClose = (ImageView) Utils.a(view, R.id.iv_left_close, "field 'ivLeftClose'", ImageView.class);
        findSearchMapFragment.clMapSearch = (ConstraintLayout) Utils.a(view, R.id.cl_map_search, "field 'clMapSearch'", ConstraintLayout.class);
        findSearchMapFragment.clShadowSetting = (ConstraintLayout) Utils.a(view, R.id.cl_shadow_setting, "field 'clShadowSetting'", ConstraintLayout.class);
        findSearchMapFragment.llMapAnimator = (LinearLayout) Utils.a(view, R.id.ll_map_animator, "field 'llMapAnimator'", LinearLayout.class);
        findSearchMapFragment.ivRefreshPosition = (ImageView) Utils.a(view, R.id.iv_refresh_position, "field 'ivRefreshPosition'", ImageView.class);
        findSearchMapFragment.llSearchShadow = (LinearLayout) Utils.a(view, R.id.ll_search_shadow, "field 'llSearchShadow'", LinearLayout.class);
        findSearchMapFragment.tvCurrentLocation = (ShapeTextView) Utils.a(view, R.id.tv_current_location, "field 'tvCurrentLocation'", ShapeTextView.class);
        findSearchMapFragment.llRefreshReturn = (LinearLayout) Utils.a(view, R.id.ll_refresh_return, "field 'llRefreshReturn'", LinearLayout.class);
        findSearchMapFragment.searchContent = (FrameLayout) Utils.a(view, R.id.search_content, "field 'searchContent'", FrameLayout.class);
        findSearchMapFragment.ivLocation = (ImageView) Utils.a(view, R.id.iv_location, "field 'ivLocation'", ImageView.class);
        findSearchMapFragment.tvTryMoveMap = (ShapeTextView) Utils.a(view, R.id.tv_try_move_map, "field 'tvTryMoveMap'", ShapeTextView.class);
        findSearchMapFragment.tvCancel = (TextView) Utils.a(view, 2131371051, "field 'tvCancel'", TextView.class);
        findSearchMapFragment.ivShadowPosition = (ImageView) Utils.a(view, R.id.iv_shadow_position, "field 'ivShadowPosition'", ImageView.class);
        findSearchMapFragment.tvShadowContent = (TextView) Utils.a(view, R.id.tv_shadow_content, "field 'tvShadowContent'", TextView.class);
        findSearchMapFragment.ivMapSearch = (ImageView) Utils.a(view, R.id.iv_map_search, "field 'ivMapSearch'", ImageView.class);
        findSearchMapFragment.tvSearchMapSubtitle = (TextView) Utils.a(view, R.id.tv_search_map_subtitle, "field 'tvSearchMapSubtitle'", TextView.class);
        findSearchMapFragment.btnChanceEncounter = (ShapeConstraintLayout) Utils.a(view, R.id.btn_chance_encounter, "field 'btnChanceEncounter'", ShapeConstraintLayout.class);
        findSearchMapFragment.ivChanceEncounter = (ImageView) Utils.a(view, R.id.iv_map_chance_encounter, "field 'ivChanceEncounter'", ImageView.class);
        findSearchMapFragment.tvChanceEncounterRemind = (ShapeTextView) Utils.a(view, R.id.tv_map_chance_encounter_remind, "field 'tvChanceEncounterRemind'", ShapeTextView.class);
        findSearchMapFragment.tvChanceEncounter = (TextView) Utils.a(view, R.id.tv_chance_encounter, "field 'tvChanceEncounter'", TextView.class);
        findSearchMapFragment.flChanceEncounterBg = (FrameLayout) Utils.a(view, R.id.fl_chance_encounter_bg, "field 'flChanceEncounterBg'", FrameLayout.class);
        findSearchMapFragment.chanceEncounterView = (ShapeLinearLayout) Utils.a(view, R.id.chance_encounter_view, "field 'chanceEncounterView'", ShapeLinearLayout.class);
        findSearchMapFragment.ivChanceEncounterViewClose = (ImageView) Utils.a(view, R.id.iv_chance_encounter_view_close, "field 'ivChanceEncounterViewClose'", ImageView.class);
        findSearchMapFragment.tvChanceEncounterStatus = (TextView) Utils.a(view, R.id.tv_chance_encounter_status, "field 'tvChanceEncounterStatus'", TextView.class);
        findSearchMapFragment.toggleButtonChanceEncounter = (ToggleButton) Utils.a(view, R.id.tglbtn_chance_encounter, "field 'toggleButtonChanceEncounter'", ToggleButton.class);
        findSearchMapFragment.chanceEncounterRecyclerView = (RecyclerView) Utils.a(view, R.id.chance_encounter_recycler_view, "field 'chanceEncounterRecyclerView'", RecyclerView.class);
        findSearchMapFragment.tvNoData = (TextView) Utils.a(view, R.id.tv_no_data, "field 'tvNoData'", TextView.class);
        findSearchMapFragment.tvFirstFree = (TextView) Utils.a(view, R.id.tv_first_free, "field 'tvFirstFree'", TextView.class);
        findSearchMapFragment.chanceEncounterGuide = (FrameLayout) Utils.a(view, R.id.chance_encounter_guide, "field 'chanceEncounterGuide'", FrameLayout.class);
        findSearchMapFragment.llGuide4 = (LinearLayout) Utils.a(view, R.id.ll_guide_4, "field 'llGuide4'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FindSearchMapFragment findSearchMapFragment = this.b;
        if (findSearchMapFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        findSearchMapFragment.mapView = null;
        findSearchMapFragment.tvHeaderOption = null;
        findSearchMapFragment.circleGuideView = null;
        findSearchMapFragment.clGuide1 = null;
        findSearchMapFragment.ivStartHeaderLocation = null;
        findSearchMapFragment.clGuide2 = null;
        findSearchMapFragment.ivSearchShadowGuide = null;
        findSearchMapFragment.clGuide3 = null;
        findSearchMapFragment.ivSetShadowGuide = null;
        findSearchMapFragment.searchView = null;
        findSearchMapFragment.ivReturnMyPosition = null;
        findSearchMapFragment.ivLeftClose = null;
        findSearchMapFragment.clMapSearch = null;
        findSearchMapFragment.clShadowSetting = null;
        findSearchMapFragment.llMapAnimator = null;
        findSearchMapFragment.ivRefreshPosition = null;
        findSearchMapFragment.llSearchShadow = null;
        findSearchMapFragment.tvCurrentLocation = null;
        findSearchMapFragment.llRefreshReturn = null;
        findSearchMapFragment.searchContent = null;
        findSearchMapFragment.ivLocation = null;
        findSearchMapFragment.tvTryMoveMap = null;
        findSearchMapFragment.tvCancel = null;
        findSearchMapFragment.ivShadowPosition = null;
        findSearchMapFragment.tvShadowContent = null;
        findSearchMapFragment.ivMapSearch = null;
        findSearchMapFragment.tvSearchMapSubtitle = null;
        findSearchMapFragment.btnChanceEncounter = null;
        findSearchMapFragment.ivChanceEncounter = null;
        findSearchMapFragment.tvChanceEncounterRemind = null;
        findSearchMapFragment.tvChanceEncounter = null;
        findSearchMapFragment.flChanceEncounterBg = null;
        findSearchMapFragment.chanceEncounterView = null;
        findSearchMapFragment.ivChanceEncounterViewClose = null;
        findSearchMapFragment.tvChanceEncounterStatus = null;
        findSearchMapFragment.toggleButtonChanceEncounter = null;
        findSearchMapFragment.chanceEncounterRecyclerView = null;
        findSearchMapFragment.tvNoData = null;
        findSearchMapFragment.tvFirstFree = null;
        findSearchMapFragment.chanceEncounterGuide = null;
        findSearchMapFragment.llGuide4 = null;
    }
}
