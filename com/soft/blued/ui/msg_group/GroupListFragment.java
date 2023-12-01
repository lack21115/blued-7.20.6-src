package com.soft.blued.ui.msg_group;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.ui.msg_group.adapter.RecommendGroupAdapter;
import com.soft.blued.ui.msg_group.fragment.GroupInfoFragment;
import com.soft.blued.ui.msg_group.viewmodel.GroupRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/GroupListFragment.class */
public final class GroupListFragment extends BaseListFragment<GroupRecommendViewModel, GroupInfoModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = (GroupInfoModel) obj;
        Context context = this$0.getContext();
        GroupInfoFragment.a(context, groupInfoModel.group_id + "", groupInfoModel, SocialNetWorkProtos.SourceType.MYGROUP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public GridLayoutManager g() {
        return new GridLayoutManager(getContext(), 2);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: D */
    public RecommendGroupAdapter i() {
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new RecommendGroupAdapter(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().a(10).a(ListConfig.LoadMoreModel.PULL_UP).b(true).c(true).d(true).a(true).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void j() {
        super.j();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        CommonTopTitleNoTrans b = b();
        TextView centerTextView = b == null ? null : b.getCenterTextView();
        if (centerTextView != null) {
            centerTextView.setText("推荐群");
        }
        f().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.-$$Lambda$GroupListFragment$BtkTOdtCNDD1ZG43Sc31hg-9vI8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GroupListFragment.a(GroupListFragment.this, baseQuickAdapter, view, i);
            }
        });
    }
}
