package com.blued.community.ui.subject.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.community.view.CommonViewHolder;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-6737240-dex2jar.jar:com/blued/community/ui/subject/adapter/FeedSubjectListAdapter.class */
public final class FeedSubjectListAdapter extends CommonMultiItemAdapter<BluedTopic> {
    private final int a;

    public FeedSubjectListAdapter(int i) {
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectListAdapter this$0, BluedTopic item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        int i = this$0.a;
        FeedConstants.b = i == 1 ? FeedProtos.DetailFrom.SUPER_TOPIC_JOIN : i == 4 ? FeedProtos.DetailFrom.SUPER_TOPIC_FOLLOW : FeedProtos.DetailFrom.FIND_SUPER_TOPIC_LIST;
        CommRouteUtil.a(this$0.mContext, item.super_did, item.name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void onConvert(CommonViewHolder holder, final BluedTopic item, int i) {
        Intrinsics.e(holder, "holder");
        Intrinsics.e(item, "item");
        int i2 = item.is_hot_topics == 1 ? R.drawable.feed_subject_hot_icon : 0;
        ImageView imageView = (ImageView) holder.getView(R.id.item_feed_subject_iv);
        int i3 = R.drawable.defaultpicture;
        if (item.is_anonym == 1) {
            i3 = R.drawable.topic_anonymous_default_header_list;
        }
        ImageLoader.a((IRequestHost) null, AvatarUtils.a(0, item.avatar)).b(i3).d(i3).a(6.0f).a(imageView);
        CommonViewHolder visibility = holder.setText(R.id.item_feed_subject_name, item.name).setText(R.id.item_feed_subject_feed_count, Intrinsics.a(CommonStringUtils.b(item.ticktocks_total), (Object) this.mContext.getString(R.string.subject_feed_count))).setText(R.id.item_feed_subject_viewer_count, Intrinsics.a(CommonStringUtils.b(item.visited_total), (Object) this.mContext.getString(R.string.subject_visit_count))).setVisibility(R.id.item_feed_subject_flag, i2 != 0 ? 0 : 8);
        int i4 = R.id.item_feed_subject_ann_cv;
        int i5 = 8;
        if (item.is_anonym == 1) {
            i5 = 0;
        }
        visibility.setVisibility(i4, i5).setCardBackgroundColor(R.id.item_feed_subject_ann_cv, Color.parseColor(CommunityManager.a.a().s() ? "#388C8C8C" : "#17252630")).setConvertViewOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.adapter.-$$Lambda$FeedSubjectListAdapter$I9lmOY3bEt1QwOceZRCGmydK5AI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedSubjectListAdapter.a(FeedSubjectListAdapter.this, item, view);
            }
        });
        if (i2 != 0) {
            holder.setImageResource(R.id.item_feed_subject_flag, i2);
        }
        if (item.isShowUrlVisited) {
            return;
        }
        FeedProtos.Event event = FeedProtos.Event.SUPER_TOPIC_DRAW;
        int i6 = this.a;
        EventTrackFeed.a(event, i6 == 1 ? FeedProtos.DetailFrom.SUPER_TOPIC_JOIN : i6 == 4 ? FeedProtos.DetailFrom.SUPER_TOPIC_FOLLOW : FeedProtos.DetailFrom.FIND_SUPER_TOPIC_LIST, item.super_did, item.is_anonym == 1, false, item.is_follow == 1);
        item.isShowUrlVisited = true;
    }

    public void onAddItemType() {
        addItemType(0, R.layout.item_feed_subject_list);
    }
}
