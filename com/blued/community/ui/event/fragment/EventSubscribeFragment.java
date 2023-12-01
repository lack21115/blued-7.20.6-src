package com.blued.community.ui.event.fragment;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.ui.event.adapter.EventSubscribeAdapter;
import com.blued.community.ui.event.fragment.EventListFragment;
import com.blued.community.ui.event.model.PersonalEventModel;
import com.blued.community.ui.event.vm.EventSubscribeViewModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventSubscribeFragment.class */
public final class EventSubscribeFragment extends BaseListFragment<EventSubscribeViewModel, PersonalEventModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NoDataAndLoadFailView this_apply, View view) {
        Intrinsics.e(this_apply, "$this_apply");
        EventListFragment.Companion companion = EventListFragment.a;
        Context context = this_apply.getContext();
        Intrinsics.c(context, "context");
        companion.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSubscribeFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        if (str != null) {
            List<PersonalEventModel> data = this$0.f().getData();
            Intrinsics.c(data, "mAdapter.data");
            for (PersonalEventModel personalEventModel : data) {
                if (personalEventModel.uid.equals(str)) {
                    this$0.f().getData().remove(personalEventModel);
                }
            }
            this$0.f().notifyDataSetChanged();
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public EventSubscribeAdapter i() {
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new EventSubscribeAdapter(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().b(true).d(false).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        final NoDataAndLoadFailView c = c();
        if (c != null) {
            c.setNoDataImg(R.drawable.icon_no_data_common);
            c.setNoDataStr(R.string.event_sub_list_no_data_tips);
            c.setNoDataBtnStr(R.string.event_sub_list_no_data_btn);
            c.setNoDataBtnVisibility(0);
            c.setNoDataBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventSubscribeFragment$IoE1gGuoaFyoegsrK2daYj2NMFo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventSubscribeFragment.a(NoDataAndLoadFailView.this, view);
                }
            });
        }
        LiveEventBus.get("EVENT_BUS_ACTIVITY_CANCEL_SUBSCRIBE", String.class).observeForever(new Observer() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventSubscribeFragment$BANn9RObhRsPyMFJok0pWlpr3Gc
            public final void onChanged(Object obj) {
                EventSubscribeFragment.a(EventSubscribeFragment.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        if (f().getData().size() == 0) {
            ((EventSubscribeViewModel) y()).dispatchAction(BaseListAction.RefreshData.a);
        }
    }
}
