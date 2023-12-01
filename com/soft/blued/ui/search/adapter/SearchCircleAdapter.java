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
    private String f19464a = "";
    private CircleConstants.CIRCLE_FROM_PAGE b = CircleConstants.CIRCLE_FROM_PAGE.z;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchCircleAdapter searchCircleAdapter, MyCircleModel myCircleModel, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchCircleAdapter, "this$0");
        Intrinsics.e(myCircleModel, "$item");
        CircleDetailsFragment.a(searchCircleAdapter.mContext, myCircleModel, CircleConstants.CIRCLE_FROM_PAGE.z);
        EventTrackGuy.b(searchCircleAdapter.b == CircleConstants.CIRCLE_FROM_PAGE.A ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_CIRCLE_CLICK : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_CLICK, searchCircleAdapter.f19464a, myCircleModel.circle_id);
    }

    public final void a(CircleConstants.CIRCLE_FROM_PAGE circle_from_page) {
        Intrinsics.e(circle_from_page, "<set-?>");
        this.b = circle_from_page;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.view.CommonMultiItemAdapter
    /* renamed from: a */
    public void onConvert(CommonViewHolder commonViewHolder, final MyCircleModel myCircleModel, int i) {
        Intrinsics.e(commonViewHolder, "viewHolder");
        Intrinsics.e(myCircleModel, "item");
        commonViewHolder.setImageUrl(R.id.iv_avatar, AvatarUtils.a(0, myCircleModel.cover), 12.0f, 2131102177);
        View view = commonViewHolder.getView(2131372046);
        Intrinsics.c(view, "viewHolder.getView(R.id.tv_name)");
        UserRelationshipUtils.a(this.mContext, myCircleModel.title, this.f19464a, (TextView) view);
        View view2 = commonViewHolder.getView(2131371259);
        Intrinsics.c(view2, "viewHolder.getView(R.id.tv_des)");
        UserRelationshipUtils.a(this.mContext, myCircleModel.description, this.f19464a, (TextView) view2);
        commonViewHolder.setText(R.id.tv_num, Intrinsics.a(CommonStringUtils.b(myCircleModel.members_num), this.mContext.getString(R.string.members_count_part))).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.adapter.-$$Lambda$SearchCircleAdapter$l4nLTkI5EC2Tgx2gitan3TNOFyI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SearchCircleAdapter.a(SearchCircleAdapter.this, myCircleModel, view3);
            }
        });
        if (myCircleModel.isShowUrlVisited) {
            return;
        }
        EventTrackGuy.b(this.b == CircleConstants.CIRCLE_FROM_PAGE.A ? GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_CIRCLE_SHOW : GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_CIRCLE_SHOW, this.f19464a, myCircleModel.circle_id);
        myCircleModel.isShowUrlVisited = true;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f19464a = str;
    }

    @Override // com.blued.community.view.CommonMultiItemAdapter
    public void onAddItemType() {
        addItemType(0, R.layout.item_search_all_circle);
    }
}
