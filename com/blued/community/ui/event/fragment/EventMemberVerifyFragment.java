package com.blued.community.ui.event.fragment;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.event.adapter.EventMemberVerifyListAdapter;
import com.blued.community.ui.event.model.EventMemberModel;
import com.blued.community.ui.event.vm.EventMemberExamineViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventMemberVerifyFragment.class */
public final class EventMemberVerifyFragment extends BaseListFragment<EventMemberExamineViewModel, EventMemberModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMemberVerifyFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ((EventMemberExamineViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.a);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public BaseQuickAdapter<EventMemberModel, BaseViewHolder> i() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        ActivityFragmentActive activityFragmentActive = fragmentActive;
        boolean z = true;
        if (((EventMemberExamineViewModel) y()).c() != 1) {
            z = false;
        }
        return new EventMemberVerifyListAdapter(parentFragmentManager, activityFragmentActive, z, ((EventMemberExamineViewModel) y()).a(), ((EventMemberExamineViewModel) y()).b());
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        if (CommunityManager.a.a().s()) {
            RecyclerView a = a();
            if (a != null) {
                a.setBackgroundResource(R.color.syc_151515);
            }
        } else {
            RecyclerView a2 = a();
            if (a2 != null) {
                a2.setBackgroundResource(R.color.white);
            }
        }
        CommonTopTitleNoTrans b = b();
        if (b != null) {
            b.setVisibility(8);
        }
        NoDataAndLoadFailView c = c();
        if (c != null) {
            c.setNoDataStr(R.string.event_member_no_data);
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setFailBtnVisibility(0);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 == null) {
            return;
        }
        c3.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventMemberVerifyFragment$WY6GjtJGGX5BOZAZhBRcq5yBnxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberVerifyFragment.a(EventMemberVerifyFragment.this, view);
            }
        });
    }
}
