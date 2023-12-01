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
    private String f33159a = "";
    private int b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchSubjectAdapter this$0, BluedTopic item, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        SuperTopicDetailFragment.a(this$0.mContext, item.super_did);
        EventTrackGuy.b(this$0.b == 1 ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_TOPIC_CLICK : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_CLICK, this$0.f33159a, item.super_did);
    }

    public final void a(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.view.CommonMultiItemAdapter
    /* renamed from: a */
    public void onConvert(CommonViewHolder viewHolder, final BluedTopic item, int i) {
        Intrinsics.e(viewHolder, "viewHolder");
        Intrinsics.e(item, "item");
        viewHolder.setImageUrl(2131365082, AvatarUtils.a(0, item.avatar), 12.0f, 2131102177);
        UserRelationshipUtils.a(this.mContext, item.name, this.f33159a, (TextView) viewHolder.getView(2131372046));
        UserRelationshipUtils.a(this.mContext, item.description, this.f33159a, (TextView) viewHolder.getView(2131371259));
        viewHolder.setText(2131372144, CommonStringUtils.b(item.ticktocks_total) + this.mContext.getString(2131892148) + ' ' + ((Object) CommonStringUtils.b(item.visited_total)) + this.mContext.getString(2131892155)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchSubjectAdapter$21wzzzuq9BsL1Y8hPQVJLn40uCs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchSubjectAdapter.a(SearchSubjectAdapter.this, item, view);
            }
        });
        if (item.isShowUrlVisited) {
            return;
        }
        EventTrackGuy.b(this.b == 1 ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_TOPIC_SHOW : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_TOPIC_SHOW, this.f33159a, item.super_did);
        item.isShowUrlVisited = true;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f33159a = str;
    }

    @Override // com.blued.community.view.CommonMultiItemAdapter
    public void onAddItemType() {
        addItemType(0, R.layout.item_search_all_circle);
    }
}
