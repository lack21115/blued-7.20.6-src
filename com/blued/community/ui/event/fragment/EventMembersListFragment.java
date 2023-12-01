package com.blued.community.ui.event.fragment;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.event.adapter.EventMemberListAdapter;
import com.blued.community.ui.event.model.EventMemberModel;
import com.blued.community.ui.event.vm.EventMembersListViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventMembersListFragment.class */
public final class EventMembersListFragment extends BaseListFragment<EventMembersListViewModel, EventMemberModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMembersListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ((EventMembersListViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.f10668a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMembersListFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        ((EventMembersListViewModel) this$0.y()).requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventMembersListFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        ((EventMembersListViewModel) this$0.y()).requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventMembersListFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        int size = this$0.f().getData().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (str.equals(this$0.f().getData().get(i2).activity_id)) {
                this$0.f().getData().get(i2).is_sign = 1;
                this$0.f().notifyItemChanged(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public BaseQuickAdapter<EventMemberModel, BaseViewHolder> i() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new EventMemberListAdapter(parentFragmentManager, fragmentActive, ((EventMembersListViewModel) y()).a(), ((EventMembersListViewModel) y()).c(), ((EventMembersListViewModel) y()).b());
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        if (CommunityManager.f19086a.a().s()) {
            RecyclerView a2 = a();
            if (a2 != null) {
                a2.setBackgroundResource(R.color.syc_151515);
            }
        } else {
            RecyclerView a3 = a();
            if (a3 != null) {
                a3.setBackgroundResource(R.color.white);
            }
        }
        CommonTopTitleNoTrans b = b();
        if (b != null) {
            b.setVisibility(8);
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataStr(R.string.event_member_no_data);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 != null) {
            c3.setFailBtnVisibility(0);
        }
        NoDataAndLoadFailView c4 = c();
        if (c4 != null) {
            c4.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventMembersListFragment$gEuRbBCUiUWAf7glqgxg0DAJkwI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventMembersListFragment.a(EventMembersListFragment.this, view);
                }
            });
        }
        EventMembersListFragment eventMembersListFragment = this;
        LiveEventBus.get("follow_success", String.class).observe(eventMembersListFragment, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventMembersListFragment$mgBUeZa-g3XP0eGLMxSoXJG1mIM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventMembersListFragment.a(EventMembersListFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("cancel_follow", String.class).observe(eventMembersListFragment, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventMembersListFragment$DIUgcuU2MZvWzHp8sr2G9MtfXqo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventMembersListFragment.b(EventMembersListFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SIGN_IN_SUCCESS", String.class).observe(eventMembersListFragment, new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventMembersListFragment$3i7EuJAsLlDoADsRBDs1ClhLjXk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EventMembersListFragment.c(EventMembersListFragment.this, (String) obj);
            }
        });
    }
}
