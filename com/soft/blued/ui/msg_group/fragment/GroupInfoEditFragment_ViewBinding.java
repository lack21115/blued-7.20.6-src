package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupInfoEditFragment_ViewBinding.class */
public class GroupInfoEditFragment_ViewBinding implements Unbinder {
    private GroupInfoEditFragment b;

    /* renamed from: c  reason: collision with root package name */
    private View f32691c;
    private View d;
    private View e;
    private View f;

    public GroupInfoEditFragment_ViewBinding(final GroupInfoEditFragment groupInfoEditFragment, View view) {
        this.b = groupInfoEditFragment;
        groupInfoEditFragment.tv_description = (TextView) Utils.a(view, 2131371264, "field 'tv_description'", TextView.class);
        groupInfoEditFragment.tv_group_name = (TextView) Utils.a(view, R.id.tv_group_name, "field 'tv_group_name'", TextView.class);
        groupInfoEditFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        groupInfoEditFragment.iv_icon = (ImageView) Utils.a(view, 2131365504, "field 'iv_icon'", ImageView.class);
        groupInfoEditFragment.fm_auditing = (FrameLayout) Utils.a(view, R.id.fm_auditing, "field 'fm_auditing'", FrameLayout.class);
        groupInfoEditFragment.tv_group_location = (TextView) Utils.a(view, R.id.tv_group_location, "field 'tv_group_location'", TextView.class);
        groupInfoEditFragment.iv_attention = (ImageView) Utils.a(view, 2131365076, "field 'iv_attention'", ImageView.class);
        groupInfoEditFragment.tv_classify = (TextView) Utils.a(view, R.id.tv_classify, "field 'tv_classify'", TextView.class);
        groupInfoEditFragment.category_dot = Utils.a(view, R.id.category_dot, "field 'category_dot'");
        View a2 = Utils.a(view, R.id.cl_describe, "method 'onClick'");
        this.f32691c = a2;
        a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoEditFragment.onClick(view2);
            }
        });
        View a3 = Utils.a(view, R.id.cl_group_name, "method 'onClick'");
        this.d = a3;
        a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoEditFragment.onClick(view2);
            }
        });
        View a4 = Utils.a(view, R.id.cl_icon, "method 'onClick'");
        this.e = a4;
        a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoEditFragment.onClick(view2);
            }
        });
        View a5 = Utils.a(view, R.id.cl_classify, "method 'onClick'");
        this.f = a5;
        a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void a(View view2) {
                groupInfoEditFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        GroupInfoEditFragment groupInfoEditFragment = this.b;
        if (groupInfoEditFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        groupInfoEditFragment.tv_description = null;
        groupInfoEditFragment.tv_group_name = null;
        groupInfoEditFragment.title = null;
        groupInfoEditFragment.iv_icon = null;
        groupInfoEditFragment.fm_auditing = null;
        groupInfoEditFragment.tv_group_location = null;
        groupInfoEditFragment.iv_attention = null;
        groupInfoEditFragment.tv_classify = null;
        groupInfoEditFragment.category_dot = null;
        this.f32691c.setOnClickListener(null);
        this.f32691c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
    }
}
