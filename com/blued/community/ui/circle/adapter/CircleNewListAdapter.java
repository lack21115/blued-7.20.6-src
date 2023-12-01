package com.blued.community.ui.circle.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.view.CircleJoinView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleNewListAdapter.class */
public final class CircleNewListAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {
    private final Context a;
    private final IRequestHost b;
    private int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleNewListAdapter(Context context, IRequestHost fragmentActive) {
        super(R.layout.item_circle_new_list, (List) null);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = context;
        this.b = fragmentActive;
        this.c = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyCircleModel myCircleModel, CircleNewListAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        myCircleModel.classify_id = this$0.c;
        CircleDetailsFragment.a(this$0.mContext, myCircleModel, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_MORE_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyCircleModel myCircleModel, CircleNewListAdapter this$0, CircleJoinView cjvJoin, View view) {
        Intrinsics.e(this$0, "this$0");
        if (myCircleModel.isJoin()) {
            CircleDetailsFragment.a(this$0.mContext, myCircleModel, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_MORE_LIST);
        }
        if (!myCircleModel.isNotMember() || myCircleModel.is_applied == 1) {
            return;
        }
        Intrinsics.c(cjvJoin, "cjvJoin");
        this$0.a(cjvJoin, myCircleModel);
        myCircleModel.classify_id = this$0.c;
        EventTrackFeed.b(FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK, FeedProtos.CircleSource.CIRCLE_MORE_LIST, myCircleModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyCircleModel item, CircleJoinView cjv, CircleNewListAdapter this$0, CircleJoinState circleJoinState) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(cjv, "$cjv");
        Intrinsics.e(this$0, "this$0");
        if (circleJoinState.isJoin()) {
            item.setMember();
        } else {
            item.setExitJoin();
        }
        item.setJoinState(circleJoinState);
        cjv.setJoinStatusWithMember(item);
        this$0.notifyDataSetChanged();
    }

    private final void a(final CircleJoinView circleJoinView, final MyCircleModel myCircleModel) {
        FragmentManager fragmentManager;
        if (this.mContext instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = this.mContext;
            if (appCompatActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
            fragmentManager = appCompatActivity.getSupportFragmentManager();
        } else {
            fragmentManager = null;
        }
        CircleMethods.a(this.mContext, new CircleMethods.JoinViewChangeListener() { // from class: com.blued.community.ui.circle.adapter.-$$Lambda$CircleNewListAdapter$UoeoweOmafWjyU_1WxSodXcDt0E
            @Override // com.blued.community.ui.circle.manager.CircleMethods.JoinViewChangeListener
            public final void joinViewChange(CircleJoinState circleJoinState) {
                CircleNewListAdapter.a(MyCircleModel.this, circleJoinView, this, circleJoinState);
            }
        }, myCircleModel.getJoinState(), this.b, fragmentManager, false, true);
        notifyDataSetChanged();
    }

    public final void a(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final MyCircleModel myCircleModel) {
        if (baseViewHolder == null || myCircleModel == null) {
            return;
        }
        ImageLoader.a(this.b, myCircleModel.cover).b(R.drawable.circle_header_default).a(8.0f).a((ImageView) baseViewHolder.getView(R.id.iv_circle_cover));
        int i = myCircleModel.label;
        if (i == 0) {
            baseViewHolder.setGone(R.id.iv_circle_label, false);
        } else if (i == 1) {
            baseViewHolder.setGone(R.id.iv_circle_label, true);
            baseViewHolder.setImageResource(R.id.iv_circle_label, R.drawable.icon_circle_label_hot);
        } else if (i == 2) {
            baseViewHolder.setGone(R.id.iv_circle_label, true);
            baseViewHolder.setImageResource(R.id.iv_circle_label, R.drawable.icon_circle_label_top);
        } else if (i == 3) {
            baseViewHolder.setGone(R.id.iv_circle_label, true);
            baseViewHolder.setImageResource(R.id.iv_circle_label, R.drawable.icon_circle_label_new);
        }
        baseViewHolder.setText(R.id.tv_circle_name, myCircleModel.title);
        if (TextUtils.isEmpty(myCircleModel.description)) {
            baseViewHolder.setGone(R.id.tv_circle_desc, false);
        } else {
            baseViewHolder.setGone(R.id.tv_circle_desc, true);
            baseViewHolder.setText(R.id.tv_circle_desc, myCircleModel.description);
        }
        baseViewHolder.setText(R.id.tv_circle_member, Intrinsics.a(myCircleModel.members_big_num, (Object) this.mContext.getResources().getString(R.string.members_count_part)));
        baseViewHolder.setText(R.id.tv_circle_feeds, Intrinsics.a(myCircleModel.feed_big_num, (Object) this.mContext.getResources().getString(R.string.circle_feed_num)));
        baseViewHolder.setGone(R.id.cjv_join, true);
        final CircleJoinView circleJoinView = (CircleJoinView) baseViewHolder.getView(R.id.cjv_join);
        circleJoinView.setJoinStatus(myCircleModel.getJoinState());
        circleJoinView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.-$$Lambda$CircleNewListAdapter$iQl-hxPYQdO-SLy33Osx7-uw4Nw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleNewListAdapter.a(MyCircleModel.this, this, circleJoinView, view);
            }
        });
        if (!myCircleModel.isDraw) {
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel.circle_id, FeedProtos.CircleSource.CIRCLE_MORE_LIST, myCircleModel.isJoin(), myCircleModel.allow_join == 0, this.c);
            myCircleModel.isDraw = true;
        }
        baseViewHolder.getView(R.id.view_content).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.-$$Lambda$CircleNewListAdapter$IxWVQ-xU85t8UR0yKPyUBbz2W5Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleNewListAdapter.a(MyCircleModel.this, this, view);
            }
        });
    }

    public final Context getContext() {
        return this.a;
    }
}
