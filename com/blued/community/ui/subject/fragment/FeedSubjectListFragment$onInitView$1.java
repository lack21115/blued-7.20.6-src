package com.blued.community.ui.subject.fragment;

import android.text.TextUtils;
import android.view.View;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.CommRouteUtil;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/FeedSubjectListFragment$onInitView$1.class */
public final class FeedSubjectListFragment$onInitView$1 extends CommonAdapter<BluedTopic> {
    final /* synthetic */ FeedSubjectListFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSubjectListFragment$onInitView$1(FeedSubjectListFragment feedSubjectListFragment, int i) {
        super(i);
        this.d = feedSubjectListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectListFragment$onInitView$1 this$0, BluedTopic item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        FeedConstants.b = FeedProtos.DetailFrom.FIND_TOPIC_MINE;
        CommRouteUtil.a(this$0.f10437a, item.super_did, item.name);
    }

    @Override // com.blued.android.module.common.adapter.CommonAdapter
    public void a(CommonAdapter.ViewHolder holder, final BluedTopic item, int i) {
        Intrinsics.e(holder, "holder");
        Intrinsics.e(item, "item");
        holder.a(R.id.item_feed_subject_my_grid_iv, item.avatar, 9).a(R.id.item_feed_subject_my_grid_name, item.name).a(R.id.item_feed_subject_my_grid_viewer, !TextUtils.isEmpty(item.last_contents) ? item.last_contents : Intrinsics.a(CommonStringUtils.b(item.visited_total), (Object) this.d.getString(R.string.subject_visit_count))).a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectListFragment$onInitView$1$XsvxDoFAQ5S1bMoWql9YJH011bI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedSubjectListFragment$onInitView$1.a(FeedSubjectListFragment$onInitView$1.this, item, view);
            }
        });
        if (item.isShowUrlVisited) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DRAW, FeedProtos.DetailFrom.FIND_TOPIC_MINE, item.super_did, item.is_anonym == 1, false, item.is_follow == 1);
        item.isShowUrlVisited = true;
    }
}
