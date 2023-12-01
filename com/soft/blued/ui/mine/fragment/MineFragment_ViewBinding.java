package com.soft.blued.ui.mine.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;
import com.soft.blued.customview.BluedADConstraintLayout;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment_ViewBinding.class */
public class MineFragment_ViewBinding implements Unbinder {
    private MineFragment b;

    /* renamed from: c  reason: collision with root package name */
    private View f31608c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;

    public MineFragment_ViewBinding(final MineFragment mineFragment, View view) {
        this.b = mineFragment;
        mineFragment.top = (FrameLayout) Utils.a(view, 2131370727, "field 'top'", FrameLayout.class);
        mineFragment.scrollPage = (ScrollView) Utils.a(view, R.id.scroll_page, "field 'scrollPage'", ScrollView.class);
        View a2 = Utils.a(view, R.id.iv_edit, "field 'ivEdit' and method 'onViewClicked'");
        mineFragment.ivEdit = (ImageView) Utils.b(a2, R.id.iv_edit, "field 'ivEdit'", ImageView.class);
        this.f31608c = a2;
        a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        View a3 = Utils.a(view, R.id.layout_header_name, "field 'layoutHeaderName' and method 'onViewClicked'");
        mineFragment.layoutHeaderName = (LinearLayout) Utils.b(a3, R.id.layout_header_name, "field 'layoutHeaderName'", LinearLayout.class);
        this.d = a3;
        a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        View a4 = Utils.a(view, 2131364232, "field 'headerView' and method 'onViewClicked'");
        mineFragment.headerView = (ImageView) Utils.b(a4, 2131364232, "field 'headerView'", ImageView.class);
        this.e = a4;
        a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.ivVerify = (ImageView) Utils.a(view, 2131366029, "field 'ivVerify'", ImageView.class);
        View a5 = Utils.a(view, R.id.tv_my_name, "field 'tvMyName' and method 'onViewClicked'");
        mineFragment.tvMyName = (TextView) Utils.b(a5, R.id.tv_my_name, "field 'tvMyName'", TextView.class);
        this.f = a5;
        a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.layoutName = (LinearLayout) Utils.a(view, R.id.layout_name, "field 'layoutName'", LinearLayout.class);
        View a6 = Utils.a(view, 2131365652, "field 'ivMore' and method 'onViewClicked'");
        mineFragment.ivMore = (ImageView) Utils.b(a6, 2131365652, "field 'ivMore'", ImageView.class);
        this.g = a6;
        a6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.tvAttentionsCount = (TextView) Utils.a(view, R.id.tv_attentions_count, "field 'tvAttentionsCount'", TextView.class);
        View a7 = Utils.a(view, R.id.ll_my_attentions, "field 'llMyAttentions' and method 'onViewClicked'");
        mineFragment.llMyAttentions = (LinearLayout) Utils.b(a7, R.id.ll_my_attentions, "field 'llMyAttentions'", LinearLayout.class);
        this.h = a7;
        a7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.tvFansCount = (TextView) Utils.a(view, R.id.tv_fans_count, "field 'tvFansCount'", TextView.class);
        View a8 = Utils.a(view, R.id.ll_my_fans, "field 'llMyFans' and method 'onViewClicked'");
        mineFragment.llMyFans = (LinearLayout) Utils.b(a8, R.id.ll_my_fans, "field 'llMyFans'", LinearLayout.class);
        this.i = a8;
        a8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.tvFeedCount = (TextView) Utils.a(view, R.id.tv_feed_count, "field 'tvFeedCount'", TextView.class);
        mineFragment.tvFeedName = (TextView) Utils.a(view, R.id.tv_feed_name, "field 'tvFeedName'", TextView.class);
        View a9 = Utils.a(view, R.id.ll_my_feed, "field 'llMyFeed' and method 'onViewClicked'");
        mineFragment.llMyFeed = (LinearLayout) Utils.b(a9, R.id.ll_my_feed, "field 'llMyFeed'", LinearLayout.class);
        this.j = a9;
        a9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.linearLayout = (LinearLayout) Utils.a(view, 2131366879, "field 'linearLayout'", LinearLayout.class);
        mineFragment.tvVipTitle = (TextView) Utils.a(view, R.id.tv_vip_title, "field 'tvVipTitle'", TextView.class);
        mineFragment.ivVipIcon = (ImageView) Utils.a(view, R.id.iv_vip_icon, "field 'ivVipIcon'", ImageView.class);
        mineFragment.vfVipAd = (ViewFlipper) Utils.a(view, R.id.vf_vip_ad, "field 'vfVipAd'", ViewFlipper.class);
        mineFragment.tvVipBtn = (TextView) Utils.a(view, R.id.tv_vip_btn, "field 'tvVipBtn'", TextView.class);
        mineFragment.ivVipBtn = (ImageView) Utils.a(view, R.id.iv_vip_btn, "field 'ivVipBtn'", ImageView.class);
        View a10 = Utils.a(view, R.id.layout_vip_btn, "field 'layoutVipBtn' and method 'onViewClicked'");
        mineFragment.layoutVipBtn = (ShapeLinearLayout) Utils.b(a10, R.id.layout_vip_btn, "field 'layoutVipBtn'", ShapeLinearLayout.class);
        this.k = a10;
        a10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        View a11 = Utils.a(view, R.id.layout_vip, "field 'layoutVip' and method 'onViewClicked'");
        mineFragment.layoutVip = (LinearLayout) Utils.b(a11, R.id.layout_vip, "field 'layoutVip'", LinearLayout.class);
        this.l = a11;
        a11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.ivVipBg = (ImageView) Utils.a(view, 2131366044, "field 'ivVipBg'", ImageView.class);
        mineFragment.ivBgIcon = (ImageView) Utils.a(view, R.id.iv_bg_icon, "field 'ivBgIcon'", ImageView.class);
        mineFragment.llHealthFlipper = (LinearLayout) Utils.a(view, R.id.ll_health_flipper, "field 'llHealthFlipper'", LinearLayout.class);
        mineFragment.tvAvatarAuditing = (TextView) Utils.a(view, R.id.tv_avatar_auditing, "field 'tvAvatarAuditing'", TextView.class);
        mineFragment.avatarWidget = (ImageView) Utils.a(view, 2131365108, "field 'avatarWidget'", ImageView.class);
        mineFragment.rvAnchorsEntry = (RecyclerView) Utils.a(view, R.id.rv_anchors_entry, "field 'rvAnchorsEntry'", RecyclerView.class);
        mineFragment.cvAnchors = (CardView) Utils.a(view, R.id.cv_anchors, "field 'cvAnchors'", CardView.class);
        mineFragment.rvServiceEntry = (RecyclerView) Utils.a(view, R.id.rv_service_entry, "field 'rvServiceEntry'", RecyclerView.class);
        mineFragment.cvService = (CardView) Utils.a(view, R.id.cv_service, "field 'cvService'", CardView.class);
        mineFragment.imgAd = (ImageView) Utils.a(view, 2131364414, "field 'imgAd'", ImageView.class);
        mineFragment.cvAd = (CardView) Utils.a(view, R.id.cv_ad, "field 'cvAd'", CardView.class);
        mineFragment.adViewLayout = (BluedADConstraintLayout) Utils.a(view, R.id.ad_view_layout, "field 'adViewLayout'", BluedADConstraintLayout.class);
        mineFragment.rvHealthEntry = (RecyclerView) Utils.a(view, R.id.rv_health_entry, "field 'rvHealthEntry'", RecyclerView.class);
        mineFragment.vfHealth = (ViewFlipper) Utils.a(view, R.id.vf_health, "field 'vfHealth'", ViewFlipper.class);
        mineFragment.cvHealth = (CardView) Utils.a(view, R.id.cv_health, "field 'cvHealth'", CardView.class);
        mineFragment.rvOthersEntry = (RecyclerView) Utils.a(view, R.id.rv_others_entry, "field 'rvOthersEntry'", RecyclerView.class);
        mineFragment.cvOther = (CardView) Utils.a(view, R.id.cv_other, "field 'cvOther'", CardView.class);
        View a12 = Utils.a(view, R.id.ll_my_group, "field 'll_my_group' and method 'onViewClicked'");
        mineFragment.ll_my_group = (LinearLayout) Utils.b(a12, R.id.ll_my_group, "field 'll_my_group'", LinearLayout.class);
        this.m = a12;
        a12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.mine.fragment.MineFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                mineFragment.onViewClicked(view2);
            }
        });
        mineFragment.tv_my_group_cnt = (TextView) Utils.a(view, R.id.tv_my_group_cnt, "field 'tv_my_group_cnt'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MineFragment mineFragment = this.b;
        if (mineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        mineFragment.top = null;
        mineFragment.scrollPage = null;
        mineFragment.ivEdit = null;
        mineFragment.layoutHeaderName = null;
        mineFragment.headerView = null;
        mineFragment.ivVerify = null;
        mineFragment.tvMyName = null;
        mineFragment.layoutName = null;
        mineFragment.ivMore = null;
        mineFragment.tvAttentionsCount = null;
        mineFragment.llMyAttentions = null;
        mineFragment.tvFansCount = null;
        mineFragment.llMyFans = null;
        mineFragment.tvFeedCount = null;
        mineFragment.tvFeedName = null;
        mineFragment.llMyFeed = null;
        mineFragment.linearLayout = null;
        mineFragment.tvVipTitle = null;
        mineFragment.ivVipIcon = null;
        mineFragment.vfVipAd = null;
        mineFragment.tvVipBtn = null;
        mineFragment.ivVipBtn = null;
        mineFragment.layoutVipBtn = null;
        mineFragment.layoutVip = null;
        mineFragment.ivVipBg = null;
        mineFragment.ivBgIcon = null;
        mineFragment.llHealthFlipper = null;
        mineFragment.tvAvatarAuditing = null;
        mineFragment.avatarWidget = null;
        mineFragment.rvAnchorsEntry = null;
        mineFragment.cvAnchors = null;
        mineFragment.rvServiceEntry = null;
        mineFragment.cvService = null;
        mineFragment.imgAd = null;
        mineFragment.cvAd = null;
        mineFragment.adViewLayout = null;
        mineFragment.rvHealthEntry = null;
        mineFragment.vfHealth = null;
        mineFragment.cvHealth = null;
        mineFragment.rvOthersEntry = null;
        mineFragment.cvOther = null;
        mineFragment.ll_my_group = null;
        mineFragment.tv_my_group_cnt = null;
        this.f31608c.setOnClickListener(null);
        this.f31608c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
        this.l.setOnClickListener(null);
        this.l = null;
        this.m.setOnClickListener(null);
        this.m = null;
    }
}
