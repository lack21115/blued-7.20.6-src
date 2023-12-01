package com.blued.community.ui.event.fragment;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.ui.event.adapter.EventListAdapter;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.vm.EventPostedListViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventPostedListFragment.class */
public final class EventPostedListFragment extends BaseListFragment<EventPostedListViewModel, EventDetailsModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventPostedListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ((EventPostedListViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.f10668a);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public BaseQuickAdapter<EventDetailsModel, BaseViewHolder> i() {
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        ActivityFragmentActive activityFragmentActive = fragmentActive;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        return new EventListAdapter(activityFragmentActive, parentFragmentManager, this, 2);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        CommonTopTitleNoTrans b = b();
        if (b != null) {
            b.setVisibility(8);
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataStr(R.string.event_my_post_no_data_content);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 == null) {
            return;
        }
        c3.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventPostedListFragment$LykDKksFpwLjixV8rfXmrBFiBL4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventPostedListFragment.a(EventPostedListFragment.this, view);
            }
        });
    }
}
