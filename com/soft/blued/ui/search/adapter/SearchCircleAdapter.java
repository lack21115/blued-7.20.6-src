package com.soft.blued.ui.search.adapter;

import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.model.MyCircleModel;
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
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/adapter/SearchCircleAdapter.class */
public final class SearchCircleAdapter extends CommonMultiItemAdapter<MyCircleModel> {

    /* renamed from: a  reason: collision with root package name */
    private String f33155a = "";
    private CircleConstants.CIRCLE_FROM_PAGE b = CircleConstants.CIRCLE_FROM_PAGE.SEARCH_ALL_CIRCLE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchCircleAdapter this$0, MyCircleModel item, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        CircleDetailsFragment.a(this$0.mContext, item, CircleConstants.CIRCLE_FROM_PAGE.SEARCH_ALL_CIRCLE);
        EventTrackGuy.b(this$0.b == CircleConstants.CIRCLE_FROM_PAGE.SEARCH_MORE_CIRCLE ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_CIRCLE_CLICK : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_CLICK, this$0.f33155a, item.circle_id);
    }

    public final void a(CircleConstants.CIRCLE_FROM_PAGE circle_from_page) {
        Intrinsics.e(circle_from_page, "<set-?>");
        this.b = circle_from_page;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.view.CommonMultiItemAdapter
    /* renamed from: a */
    public void onConvert(CommonViewHolder viewHolder, final MyCircleModel item, int i) {
        Intrinsics.e(viewHolder, "viewHolder");
        Intrinsics.e(item, "item");
        viewHolder.setImageUrl(2131365082, AvatarUtils.a(0, item.cover), 12.0f, 2131102177);
        View view = viewHolder.getView(2131372046);
        Intrinsics.c(view, "viewHolder.getView(R.id.tv_name)");
        UserRelationshipUtils.a(this.mContext, item.title, this.f33155a, (TextView) view);
        View view2 = viewHolder.getView(2131371259);
        Intrinsics.c(view2, "viewHolder.getView(R.id.tv_des)");
        UserRelationshipUtils.a(this.mContext, item.description, this.f33155a, (TextView) view2);
        viewHolder.setText(2131372144, Intrinsics.a(CommonStringUtils.b(item.members_num), (Object) this.mContext.getString(2131890596))).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchCircleAdapter$l4nLTkI5EC2Tgx2gitan3TNOFyI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SearchCircleAdapter.a(SearchCircleAdapter.this, item, view3);
            }
        });
        if (item.isShowUrlVisited) {
            return;
        }
        EventTrackGuy.b(this.b == CircleConstants.CIRCLE_FROM_PAGE.SEARCH_MORE_CIRCLE ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_CIRCLE_SHOW : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_SHOW, this.f33155a, item.circle_id);
        item.isShowUrlVisited = true;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f33155a = str;
    }

    @Override // com.blued.community.view.CommonMultiItemAdapter
    public void onAddItemType() {
        addItemType(0, R.layout.item_search_all_circle);
    }
}
