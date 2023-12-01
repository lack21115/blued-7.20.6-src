package com.blued.community.ui.send.adapter;

import android.widget.ImageView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/FeedPostTopicAdapter.class */
public class FeedPostTopicAdapter extends BaseQuickAdapter<BluedTopic, BaseViewHolder> {
    private int a;

    public FeedPostTopicAdapter(int i) {
        super(R.layout.item_feed_post_topic);
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedTopic bluedTopic) {
        baseViewHolder.setText(R.id.tv_topic, bluedTopic.name);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_pre_topic);
        if (bluedTopic.is_anonym == 1) {
            imageView.setImageResource(R.drawable.icon_anony_feed_post);
        } else if (bluedTopic.is_hot_topics == 1 || bluedTopic.is_hot == 1) {
            imageView.setImageResource(R.drawable.feed_subject_hot_icon);
        } else if (CommunityServiceManager.a().D() == 1) {
            imageView.setImageResource(R.drawable.feed_post_subject_icon_gray);
        } else {
            imageView.setImageResource(R.drawable.feed_post_super_topic);
        }
        baseViewHolder.addOnClickListener(R.id.root_layout);
        if (!bluedTopic.isShowUrlVisited) {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_TOPIC_SHOW, bluedTopic.super_did, this.a);
            bluedTopic.isShowUrlVisited = true;
        }
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) baseViewHolder.getView(R.id.layout_super_topic);
        if (bluedTopic.is_chosen) {
            ShapeHelper.b(shapeLinearLayout, R.color.syc_a_10);
            ShapeHelper.d(shapeLinearLayout, R.color.syc_a_10);
            return;
        }
        ShapeHelper.b(shapeLinearLayout, R.color.syc_b);
        ShapeHelper.d(shapeLinearLayout, R.color.syc_o);
    }
}
