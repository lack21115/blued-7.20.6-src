package com.blued.community.ui.event.fragment;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.ui.event.adapter.EventListAdapter;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.vm.EventJoinedListViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventJoinedListFragment.class */
public final class EventJoinedListFragment extends BaseListFragment<EventJoinedListViewModel, EventDetailsModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventJoinedListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventJoinedListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ((EventJoinedListViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.a);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void a(boolean z, boolean z2) {
        NoDataAndLoadFailView c;
        super.a(z, z2);
        if (z || (c = c()) == null) {
            return;
        }
        c.setBtnStr(R.string.reload);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public BaseQuickAdapter<EventDetailsModel, BaseViewHolder> i() {
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        ActivityFragmentActive activityFragmentActive = fragmentActive;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        return new EventListAdapter(activityFragmentActive, parentFragmentManager, this, 1);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        ShapeTextView btn;
        super.m();
        CommonTopTitleNoTrans b = b();
        if (b != null) {
            b.setVisibility(8);
        }
        NoDataAndLoadFailView c = c();
        if (c != null) {
            c.setNoDataStr(R.string.event_my_join_no_data_content);
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setFailBtnVisibility(8);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 != null) {
            c3.setBtnStr(R.string.event_join_btn_content);
        }
        NoDataAndLoadFailView c4 = c();
        if (c4 != null) {
            c4.setNoDataBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventJoinedListFragment$sr6HHgmlkw_6GTZ0IxbpWpYy9fc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventJoinedListFragment.a(EventJoinedListFragment.this, view);
                }
            });
        }
        Context context = getContext();
        if (context != null) {
            NoDataAndLoadFailView c5 = c();
            ShapeTextView shapeTextView = null;
            ShapeModel shapeModel = (c5 == null || (btn = c5.getBtn()) == null) ? null : btn.getShapeModel();
            if (shapeModel != null) {
                shapeModel.b = ContextCompat.getColor(context, R.color.syc_dark_b);
            }
            NoDataAndLoadFailView c6 = c();
            if (c6 != null) {
                shapeTextView = c6.getBtn();
            }
            if (shapeTextView != null) {
                shapeTextView.setShapeModel(shapeModel);
            }
        }
        NoDataAndLoadFailView c7 = c();
        if (c7 == null) {
            return;
        }
        c7.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventJoinedListFragment$STZLETxUs3bXZl4xoK-ObwZQYfw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventJoinedListFragment.b(EventJoinedListFragment.this, view);
            }
        });
    }
}
