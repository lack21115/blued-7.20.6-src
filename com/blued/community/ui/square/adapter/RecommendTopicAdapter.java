package com.blued.community.ui.square.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/adapter/RecommendTopicAdapter.class */
public class RecommendTopicAdapter extends BaseQuickAdapter<BluedTopic, BaseViewHolder> {
    private Context a;
    private IRequestHost b;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/adapter/RecommendTopicAdapter$MyTopicViewHolder.class */
    public class MyTopicViewHolder {
        private View b;
        private ImageView c;
        private TextView d;
        private TextView e;
        private ShapeTextView f;

        public MyTopicViewHolder(BaseViewHolder baseViewHolder, int i) {
            if (i == 0) {
                this.b = baseViewHolder.getView(R.id.item_recommend1);
            } else if (i == 1) {
                this.b = baseViewHolder.getView(R.id.item_recommend2);
            } else if (i == 2) {
                this.b = baseViewHolder.getView(R.id.item_recommend3);
            }
            this.c = (ImageView) this.b.findViewById(R.id.img_cover);
            this.d = (TextView) this.b.findViewById(R.id.tv_topic_name);
            this.e = (TextView) this.b.findViewById(R.id.tv_topic_desc);
            this.f = (ShapeTextView) this.b.findViewById(R.id.stv_into);
        }
    }

    public RecommendTopicAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_recommend_topic_list, (List) null);
        this.a = context;
        this.b = iRequestHost;
    }

    private void a(final BluedTopic bluedTopic, MyTopicViewHolder myTopicViewHolder) {
        ImageLoader.a(this.b, bluedTopic.avatar).b(R.drawable.topic_default_header).a(6.0f).a(myTopicViewHolder.c);
        myTopicViewHolder.d.setText(bluedTopic.name);
        myTopicViewHolder.e.setText(DistanceUtils.a(this.a, bluedTopic.join_total) + this.a.getString(R.string.participate));
        myTopicViewHolder.f.getBackground().setAlpha(15);
        myTopicViewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.adapter.RecommendTopicAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.f(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_CLICK, bluedTopic.super_did);
                FeedConstants.b = FeedProtos.DetailFrom.FIND_PLAZA_RECOMMEND;
                SuperTopicDetailFragment.a(RecommendTopicAdapter.this.a, bluedTopic.super_did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedTopic bluedTopic) {
        if (baseViewHolder != null) {
            MyTopicViewHolder myTopicViewHolder = new MyTopicViewHolder(baseViewHolder, 0);
            MyTopicViewHolder myTopicViewHolder2 = new MyTopicViewHolder(baseViewHolder, 1);
            MyTopicViewHolder myTopicViewHolder3 = new MyTopicViewHolder(baseViewHolder, 2);
            myTopicViewHolder.b.setVisibility(8);
            myTopicViewHolder2.b.setVisibility(8);
            myTopicViewHolder3.b.setVisibility(8);
            if (bluedTopic.bluedTopicList.size() > 0) {
                myTopicViewHolder.b.setVisibility(0);
                BluedTopic bluedTopic2 = bluedTopic.bluedTopicList.get(0);
                a(bluedTopic2, myTopicViewHolder);
                if (!bluedTopic2.isShowUrlVisited) {
                    EventTrackFeed.f(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW, bluedTopic2.super_did);
                    bluedTopic2.isShowUrlVisited = true;
                }
            }
            if (bluedTopic.bluedTopicList.size() > 1) {
                myTopicViewHolder2.b.setVisibility(0);
                BluedTopic bluedTopic3 = bluedTopic.bluedTopicList.get(1);
                a(bluedTopic3, myTopicViewHolder2);
                if (!bluedTopic3.isShowUrlVisited) {
                    EventTrackFeed.f(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW, bluedTopic3.super_did);
                    bluedTopic3.isShowUrlVisited = true;
                }
            }
            if (bluedTopic.bluedTopicList.size() > 2) {
                myTopicViewHolder3.b.setVisibility(0);
                BluedTopic bluedTopic4 = bluedTopic.bluedTopicList.get(2);
                a(bluedTopic4, myTopicViewHolder3);
                if (bluedTopic4.isShowUrlVisited) {
                    return;
                }
                EventTrackFeed.f(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_DRAW, bluedTopic4.super_did);
                bluedTopic4.isShowUrlVisited = true;
            }
        }
    }
}
