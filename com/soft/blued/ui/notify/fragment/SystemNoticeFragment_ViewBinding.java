package com.soft.blued.ui.notify.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/SystemNoticeFragment_ViewBinding.class */
public class SystemNoticeFragment_ViewBinding implements Unbinder {
    private SystemNoticeFragment b;

    /* renamed from: c  reason: collision with root package name */
    private View f19240c;
    private View d;
    private View e;
    private View f;

    public SystemNoticeFragment_ViewBinding(final SystemNoticeFragment systemNoticeFragment, View view) {
        this.b = systemNoticeFragment;
        systemNoticeFragment.ivAttention = (ImageView) Utils.a(view, R.id.iv_attention, "field 'ivAttention'", ImageView.class);
        systemNoticeFragment.llAttention = (LinearLayout) Utils.a(view, R.id.ll_attention, "field 'llAttention'", LinearLayout.class);
        View a2 = Utils.a(view, R.id.tv_attention_count, "field 'tvAttentionCount' and method 'onViewClicked'");
        systemNoticeFragment.tvAttentionCount = (QBadgeContainer) Utils.b(a2, R.id.tv_attention_count, "field 'tvAttentionCount'", QBadgeContainer.class);
        this.f19240c = a2;
        a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                systemNoticeFragment.onViewClicked(view2);
            }
        });
        systemNoticeFragment.ivLike = (ImageView) Utils.a(view, R.id.iv_like, "field 'ivLike'", ImageView.class);
        systemNoticeFragment.llLike = (LinearLayout) Utils.a(view, R.id.ll_like, "field 'llLike'", LinearLayout.class);
        View a3 = Utils.a(view, R.id.tv_like_count, "field 'tvLikeCount' and method 'onViewClicked'");
        systemNoticeFragment.tvLikeCount = (QBadgeContainer) Utils.b(a3, R.id.tv_like_count, "field 'tvLikeCount'", QBadgeContainer.class);
        this.d = a3;
        a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                systemNoticeFragment.onViewClicked(view2);
            }
        });
        systemNoticeFragment.ivGroup = (ImageView) Utils.a(view, R.id.iv_group, "field 'ivGroup'", ImageView.class);
        systemNoticeFragment.llGroup = (LinearLayout) Utils.a(view, R.id.ll_group, "field 'llGroup'", LinearLayout.class);
        View a4 = Utils.a(view, R.id.tv_group_count, "field 'tvGroupCount' and method 'onViewClicked'");
        systemNoticeFragment.tvGroupCount = (QBadgeContainer) Utils.b(a4, R.id.tv_group_count, "field 'tvGroupCount'", QBadgeContainer.class);
        this.e = a4;
        a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                systemNoticeFragment.onViewClicked(view2);
            }
        });
        systemNoticeFragment.ivCircle = (ImageView) Utils.a(view, R.id.iv_circle, "field 'ivCircle'", ImageView.class);
        systemNoticeFragment.llCircle = (LinearLayout) Utils.a(view, R.id.ll_circle, "field 'llCircle'", LinearLayout.class);
        View a5 = Utils.a(view, R.id.tv_circle_count, "field 'tvCircleCount' and method 'onViewClicked'");
        systemNoticeFragment.tvCircleCount = (QBadgeContainer) Utils.b(a5, R.id.tv_circle_count, "field 'tvCircleCount'", QBadgeContainer.class);
        this.f = a5;
        a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                systemNoticeFragment.onViewClicked(view2);
            }
        });
        systemNoticeFragment.llMenu = (LinearLayout) Utils.a(view, R.id.ll_menu, "field 'llMenu'", LinearLayout.class);
        systemNoticeFragment.appbar = (AppBarLayout) Utils.a(view, R.id.appbar, "field 'appbar'", AppBarLayout.class);
        systemNoticeFragment.recycleView = (RecyclerView) Utils.a(view, R.id.recycle_view, "field 'recycleView'", RecyclerView.class);
        systemNoticeFragment.coordinator = (CoordinatorLayout) Utils.a(view, 2131363084, "field 'coordinator'", CoordinatorLayout.class);
        systemNoticeFragment.srlList = (SmartRefreshLayout) Utils.a(view, R.id.srl_list, "field 'srlList'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SystemNoticeFragment systemNoticeFragment = this.b;
        if (systemNoticeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        systemNoticeFragment.ivAttention = null;
        systemNoticeFragment.llAttention = null;
        systemNoticeFragment.tvAttentionCount = null;
        systemNoticeFragment.ivLike = null;
        systemNoticeFragment.llLike = null;
        systemNoticeFragment.tvLikeCount = null;
        systemNoticeFragment.ivGroup = null;
        systemNoticeFragment.llGroup = null;
        systemNoticeFragment.tvGroupCount = null;
        systemNoticeFragment.ivCircle = null;
        systemNoticeFragment.llCircle = null;
        systemNoticeFragment.tvCircleCount = null;
        systemNoticeFragment.llMenu = null;
        systemNoticeFragment.appbar = null;
        systemNoticeFragment.recycleView = null;
        systemNoticeFragment.coordinator = null;
        systemNoticeFragment.srlList = null;
        this.f19240c.setOnClickListener(null);
        this.f19240c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}
