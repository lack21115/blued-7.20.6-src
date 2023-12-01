package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.adapter.MyGroupAdapter;
import com.soft.blued.ui.msg_group.constant.GroupConstant;
import com.soft.blued.ui.msg_group.viewmodel.MyGroupAllVM;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/MyGroupAllFragment.class */
public final class MyGroupAllFragment extends BaseListFragment<MyGroupAllVM, GroupInfoModel> {
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/MyGroupAllFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, MyGroupAllFragment.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupAllFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupAllFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = (GroupInfoModel) obj;
        if (groupInfoModel.itemType != 0 && groupInfoModel.itemType != 5) {
            if (groupInfoModel.itemType == 4) {
                WebViewShowInfoFragment.show(this$0.getContext(), Intrinsics.a(GroupConstant.f32663a, (Object) "group_list"));
                return;
            }
            return;
        }
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_CLICK, groupInfoModel.label, groupInfoModel.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN, String.valueOf(groupInfoModel.group_id));
        Context context = this$0.getContext();
        GroupInfoFragment.a(context, groupInfoModel.group_id + "", groupInfoModel, SocialNetWorkProtos.SourceType.MYGROUP);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public MyGroupAdapter i() {
        return new MyGroupAdapter(getFragmentActive());
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        ListConfig h = super.h();
        h.c(false);
        return h;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        CommonTopTitleNoTrans b2 = b();
        if (b2 != null) {
            b2.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupAllFragment$dYnwC6J_PPtrtU3eyVOpivCsKcQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGroupAllFragment.a(MyGroupAllFragment.this, view);
                }
            });
        }
        CommonTopTitleNoTrans b3 = b();
        TextView centerTextView = b3 == null ? null : b3.getCenterTextView();
        if (centerTextView != null) {
            centerTextView.setText(getString(R.string.group_my_groups));
        }
        f().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupAllFragment$qCr1IsC2l7q6un3jK4xfxzr96ww
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyGroupAllFragment.a(MyGroupAllFragment.this, baseQuickAdapter, view, i);
            }
        });
    }
}
