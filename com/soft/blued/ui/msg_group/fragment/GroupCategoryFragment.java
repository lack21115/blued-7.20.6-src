package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.group.GroupCategoryModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.adapter.GroupCategoryAdapter;
import com.soft.blued.ui.msg_group.viewmodel.GroupCategoryVM;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupCategoryFragment.class */
public final class GroupCategoryFragment extends BaseListFragment<GroupCategoryVM, GroupCategoryModel> {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private GroupCategoryModel f18980c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupCategoryFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a(Companion companion, Fragment fragment, int i, GroupCategoryModel groupCategoryModel, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                groupCategoryModel = null;
            }
            companion.a(fragment, i, groupCategoryModel);
        }

        public final void a(Fragment fragment, int i, GroupCategoryModel groupCategoryModel) {
            Bundle bundle = new Bundle();
            bundle.putInt(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY, i);
            bundle.putSerializable("key_data", (Serializable) groupCategoryModel);
            Unit unit = Unit.a;
            TerminalActivity.a(fragment, GroupCategoryFragment.class, bundle);
        }
    }

    private final void D() {
        if (this.f18980c == null) {
            return;
        }
        Context context = getContext();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_data", (Serializable) this.f18980c);
        Unit unit = Unit.a;
        TerminalActivity.d(context, GroupInfoEditFragment.class, bundle);
    }

    private final void E() {
        if (this.f18980c == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, new Intent().putExtra("key_data", (Serializable) this.f18980c));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            return;
        }
        activity2.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, GroupCategoryFragment groupCategoryFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(groupCategoryFragment, "this$0");
        if (i == 0) {
            groupCategoryFragment.D();
        } else {
            groupCategoryFragment.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupCategoryFragment groupCategoryFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(groupCategoryFragment, "this$0");
        FragmentActivity activity = groupCategoryFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupCategoryFragment groupCategoryFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Context context;
        CommonTopTitleNoTrans b2;
        ShapeTextView rightTextView;
        Intrinsics.e(groupCategoryFragment, "this$0");
        if (groupCategoryFragment.f18980c == null && (context = groupCategoryFragment.getContext()) != null && (b2 = groupCategoryFragment.b()) != null && (rightTextView = b2.getRightTextView()) != null) {
            rightTextView.setTextColor(ContextCompat.getColor(context, 2131102254));
        }
        List data = baseQuickAdapter.getData();
        Intrinsics.c(data, "adapter.data");
        for (Object obj : data) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupCategoryModel");
            }
            ((GroupCategoryModel) obj).setSelected(false);
        }
        Object obj2 = baseQuickAdapter.getData().get(i);
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupCategoryModel");
        }
        GroupCategoryModel groupCategoryModel = (GroupCategoryModel) obj2;
        groupCategoryFragment.f18980c = groupCategoryModel;
        if (groupCategoryModel != null) {
            groupCategoryModel.setSelected(true);
        }
        baseQuickAdapter.notifyDataSetChanged();
    }

    /* renamed from: C */
    public GroupCategoryAdapter i() {
        return new GroupCategoryAdapter();
    }

    public ListConfig h() {
        ListConfig h = super.h();
        h.c(false);
        h.b(false);
        return h;
    }

    public void m() {
        Context context;
        CommonTopTitleNoTrans b2;
        ShapeTextView rightTextView;
        super.m();
        final int A = A();
        this.f18980c = (GroupCategoryModel) B();
        y().a(this.f18980c);
        if (this.f18980c == null && (context = getContext()) != null && (b2 = b()) != null && (rightTextView = b2.getRightTextView()) != null) {
            rightTextView.setTextColor(ContextCompat.getColor(context, 2131102264));
        }
        CommonTopTitleNoTrans b3 = b();
        if (b3 != null) {
            b3.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupCategoryFragment$Y5BmYFwOwJYm5P-QTahzjv0eqRw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupCategoryFragment.a(GroupCategoryFragment.this, view);
                }
            });
        }
        CommonTopTitleNoTrans b4 = b();
        TextView centerTextView = b4 == null ? null : b4.getCenterTextView();
        if (centerTextView != null) {
            centerTextView.setText(getString(R.string.group_select_category));
        }
        CommonTopTitleNoTrans b5 = b();
        ShapeTextView rightTextView2 = b5 == null ? null : b5.getRightTextView();
        if (rightTextView2 != null) {
            rightTextView2.setVisibility(0);
        }
        CommonTopTitleNoTrans b6 = b();
        ShapeTextView rightTextView3 = b6 == null ? null : b6.getRightTextView();
        if (rightTextView3 != null) {
            rightTextView3.setText(getString(A == 0 ? 2131891050 : 2131886693));
        }
        CommonTopTitleNoTrans b7 = b();
        if (b7 != null) {
            b7.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupCategoryFragment$XWlm86zwA4g4chKMB6gveLpRiiI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupCategoryFragment.a(A, this, view);
                }
            });
        }
        TextView textView = new TextView(getContext());
        textView.setText(getString(R.string.group_category_hint));
        textView.setTextSize(14.0f);
        Context context2 = getContext();
        if (context2 != null) {
            textView.setTextColor(ContextCompat.getColor(context2, 2131102254));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = BluedViewExtKt.a(15);
        layoutParams.leftMargin = BluedViewExtKt.a(30);
        layoutParams.rightMargin = BluedViewExtKt.a(30);
        layoutParams.bottomMargin = BluedViewExtKt.a(30);
        textView.setLayoutParams(layoutParams);
        f().addHeaderView(textView);
        f().setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupCategoryFragment$WJwYUJfaV6ulRsWQUhoRQZrm_yY
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GroupCategoryFragment.a(GroupCategoryFragment.this, baseQuickAdapter, view, i);
            }
        });
    }
}
