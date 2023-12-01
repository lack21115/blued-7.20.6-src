package com.soft.blued.ui.search.adapter;

import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.ui.topic.fragment.SuperTopicDetailFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.community.view.CommonViewHolder;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.utils.UserRelationshipUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/adapter/SearchSubjectAdapter.class */
public final class SearchSubjectAdapter extends CommonMultiItemAdapter<BluedTopic> {

    /* renamed from: a  reason: collision with root package name */
    private String f19468a = "";
    private int b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchSubjectAdapter searchSubjectAdapter, BluedTopic bluedTopic, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchSubjectAdapter, "this$0");
        Intrinsics.e(bluedTopic, "$item");
        SuperTopicDetailFragment.a(searchSubjectAdapter.mContext, bluedTopic.super_did);
        EventTrackGuy.b(searchSubjectAdapter.b == 1 ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_TOPIC_CLICK : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_CLICK, searchSubjectAdapter.f19468a, bluedTopic.super_did);
    }

    public final void a(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.view.CommonMultiItemAdapter
    /* renamed from: a */
    public void onConvert(CommonViewHolder commonViewHolder, final BluedTopic bluedTopic, int i) {
        Intrinsics.e(commonViewHolder, "viewHolder");
        Intrinsics.e(bluedTopic, "item");
        commonViewHolder.setImageUrl(R.id.iv_avatar, AvatarUtils.a(0, bluedTopic.avatar), 12.0f, 2131102177);
        UserRelationshipUtils.a(this.mContext, bluedTopic.name, this.f19468a, (TextView) commonViewHolder.getView(2131372046));
        UserRelationshipUtils.a(this.mContext, bluedTopic.description, this.f19468a, (TextView) commonViewHolder.getView(2131371259));
        commonViewHolder.setText(R.id.tv_num, CommonStringUtils.b(bluedTopic.ticktocks_total) + this.mContext.getString(R.string.subject_feed_count) + ' ' + ((Object) CommonStringUtils.b(bluedTopic.visited_total)) + this.mContext.getString(R.string.subject_visit_count)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchSubjectAdapter$21wzzzuq9BsL1Y8hPQVJLn40uCs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchSubjectAdapter.a(SearchSubjectAdapter.this, bluedTopic, view);
            }
        });
        if (bluedTopic.isShowUrlVisited) {
            return;
        }
        EventTrackGuy.b(this.b == 1 ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_TOPIC_SHOW : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_SHOW, this.f19468a, bluedTopic.super_did);
        bluedTopic.isShowUrlVisited = true;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f19468a = str;
    }

    @Override // com.blued.community.view.CommonMultiItemAdapter
    public void onAddItemType() {
        addItemType(0, R.layout.item_search_all_circle);
    }
}
