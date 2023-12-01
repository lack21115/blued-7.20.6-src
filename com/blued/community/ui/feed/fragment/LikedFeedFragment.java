package com.blued.community.ui.feed.fragment;

import android.view.View;
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
import com.blued.community.ui.feed.vm.LikedFeedViewModel;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/LikedFeedFragment.class */
public final class LikedFeedFragment extends BaseListFragment<LikedFeedViewModel, BluedIngSelfFeed> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LikedFeedFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CommunityServiceManager.b().a(this$0.getContext(), 1);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public FeedListAdapterForRecyclerView i() {
        return new FeedListAdapterForRecyclerView(getContext(), this, null, 23);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().a(20).e(true).a(ListConfig.LoadMoreModel.PULL_UP).b(false).c(true).d(false).a(true).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        super.m();
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataStr(R.string.feed_interacted_nodata_tip);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 != null) {
            c3.setBtnStr(R.string.feed_interacted_nodata_btn);
        }
        NoDataAndLoadFailView c4 = c();
        if (c4 != null) {
            c4.setNoDataBtnListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$LikedFeedFragment$SR6hmVUBGhnYU8rDH1detAg4jiM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LikedFeedFragment.a(LikedFeedFragment.this, view);
                }
            });
        }
        LikedFeedFragment likedFeedFragment = this;
        RecyclerView a2 = a();
        RecyclerView.Adapter adapter = a2 == null ? null : a2.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView");
        }
        FeedMethods.a(likedFeedFragment, (FeedListAdapterForRecyclerView) adapter);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        EventTrackFeed.a(FeedProtos.Event.MINE_LIKE_TAB_SHOW);
    }
}
