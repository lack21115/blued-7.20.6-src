package com.blued.community.ui.feed.fragment;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.blued.community.ui.feed.vm.CommentedFeedViewModel;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/CommentedFeedFragment.class */
public final class CommentedFeedFragment extends BaseListFragment<CommentedFeedViewModel, BluedIngSelfFeed> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CommentedFeedFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CommunityServiceManager.b().a(this$0.getContext(), 1);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public FeedListAdapterForRecyclerView i() {
        return new FeedListAdapterForRecyclerView(getContext(), this, null, 24);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().e(true).a(20).a(ListConfig.LoadMoreModel.PULL_UP).b(false).c(true).d(false).a(true).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        NoDataAndLoadFailView c = c();
        if (c != null) {
            c.setNoDataStr(R.string.feed_interacted_nodata_tip);
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setBtnStr(R.string.feed_interacted_nodata_btn);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 != null) {
            c3.setNoDataBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$CommentedFeedFragment$mZ2AEHhughYIXErZxsgTPd4UBow
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentedFeedFragment.a(CommentedFeedFragment.this, view);
                }
            });
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        RecyclerView a = a();
        RecyclerView.Adapter adapter = a == null ? null : a.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView");
        }
        FeedMethods.a(lifecycleOwner, (IFeedDataObserver) adapter);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        EventTrackFeed.a(FeedProtos.Event.MINE_COMMENT_TAB_SHOW);
    }
}
