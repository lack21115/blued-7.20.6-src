package com.blued.community.ui.circle.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
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
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleRecommendListAdapter.class */
public class CircleRecommendListAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {
    private IRequestHost a;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleRecommendListAdapter$MyCircleViewHolder.class */
    public class MyCircleViewHolder {
        private View b;
        private ImageView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private CircleJoinView g;

        public MyCircleViewHolder(BaseViewHolder baseViewHolder, int i) {
            if (i == 0) {
                this.b = baseViewHolder.getView(R.id.item_recommend1);
            } else if (i == 1) {
                this.b = baseViewHolder.getView(R.id.item_recommend2);
            } else if (i == 2) {
                this.b = baseViewHolder.getView(R.id.item_recommend3);
            }
            this.c = (ImageView) this.b.findViewById(R.id.img_cover);
            this.d = (TextView) this.b.findViewById(R.id.tv_circle_desc);
            this.e = (TextView) this.b.findViewById(R.id.tv_circle_name);
            this.f = (TextView) this.b.findViewById(R.id.tv_circle_member);
            CircleJoinView circleJoinView = (CircleJoinView) this.b.findViewById(R.id.cjv_join);
            this.g = circleJoinView;
            circleJoinView.setStyle(0);
        }
    }

    public CircleRecommendListAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_recommend_circle_list, new ArrayList());
        this.mContext = context;
        this.a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MyCircleViewHolder myCircleViewHolder, MyCircleModel myCircleModel, View view) {
        a(myCircleViewHolder.g, myCircleModel);
    }

    private void a(final MyCircleModel myCircleModel, final MyCircleViewHolder myCircleViewHolder) {
        ImageLoader.a(this.a, myCircleModel.cover).b(R.drawable.circle_header_default).a(8.0f).a(myCircleViewHolder.c);
        myCircleViewHolder.e.setText(myCircleModel.title);
        myCircleViewHolder.d.setText(myCircleModel.description);
        TextView textView = myCircleViewHolder.f;
        textView.setText(myCircleModel.members_num + this.mContext.getResources().getString(R.string.members_count_part));
        myCircleViewHolder.g.setVisibility(0);
        myCircleViewHolder.g.setJoinStatusWithMember(myCircleModel);
        if (myCircleModel.is_member == 1 || myCircleModel.is_applied == 1) {
            myCircleViewHolder.g.setOnClickListener(null);
        } else {
            myCircleViewHolder.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.-$$Lambda$CircleRecommendListAdapter$tEBIoSiJV5Qq8FayZL69MFlKqs4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleRecommendListAdapter.this.a(myCircleViewHolder, myCircleModel, view);
                }
            });
        }
        myCircleViewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.CircleRecommendListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleDetailsFragment.a(CircleRecommendListAdapter.this.mContext, myCircleModel, CircleConstants.CIRCLE_FROM_PAGE.HOME_RECOMMEND_CIRCLE);
            }
        });
    }

    private void a(final CircleJoinView circleJoinView, final MyCircleModel myCircleModel) {
        EventTrackFeed.b(FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK, FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND, myCircleModel);
        CircleMethods.a(this.mContext, new CircleMethods.JoinViewChangeListener() { // from class: com.blued.community.ui.circle.adapter.CircleRecommendListAdapter.2
            @Override // com.blued.community.ui.circle.manager.CircleMethods.JoinViewChangeListener
            public void joinViewChange(CircleJoinState circleJoinState) {
                if (circleJoinState.isJoin()) {
                    myCircleModel.is_member = 1;
                } else {
                    myCircleModel.is_member = 0;
                }
                myCircleModel.setJoinState(circleJoinState);
                circleJoinView.setJoinStatusWithMember(myCircleModel);
                CircleRecommendListAdapter.this.notifyDataSetChanged();
            }
        }, myCircleModel.getJoinState(), this.a, this.mContext instanceof AppCompatActivity ? this.mContext.getSupportFragmentManager() : null, false, true);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, MyCircleModel myCircleModel) {
        if (baseViewHolder == null || myCircleModel == null) {
            return;
        }
        MyCircleViewHolder myCircleViewHolder = new MyCircleViewHolder(baseViewHolder, 0);
        MyCircleViewHolder myCircleViewHolder2 = new MyCircleViewHolder(baseViewHolder, 1);
        MyCircleViewHolder myCircleViewHolder3 = new MyCircleViewHolder(baseViewHolder, 2);
        myCircleViewHolder.b.setVisibility(8);
        myCircleViewHolder2.b.setVisibility(8);
        myCircleViewHolder3.b.setVisibility(8);
        if (myCircleModel.circleModelList.size() > 0) {
            myCircleViewHolder.b.setVisibility(0);
            MyCircleModel myCircleModel2 = myCircleModel.circleModelList.get(0);
            a(myCircleModel2, myCircleViewHolder);
            if (!myCircleModel2.isDraw) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel2.circle_id, FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND, myCircleModel.is_member == 1, myCircleModel.allow_join == 0, myCircleModel.classify_id);
                myCircleModel2.isDraw = true;
            }
        }
        if (myCircleModel.circleModelList.size() > 1) {
            myCircleViewHolder2.b.setVisibility(0);
            MyCircleModel myCircleModel3 = myCircleModel.circleModelList.get(1);
            a(myCircleModel3, myCircleViewHolder2);
            if (!myCircleModel3.isDraw) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel3.circle_id, FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND, myCircleModel.is_member == 1, myCircleModel.allow_join == 0, myCircleModel.classify_id);
                myCircleModel3.isDraw = true;
            }
        }
        if (myCircleModel.circleModelList.size() > 2) {
            myCircleViewHolder3.b.setVisibility(0);
            MyCircleModel myCircleModel4 = myCircleModel.circleModelList.get(2);
            a(myCircleModel4, myCircleViewHolder3);
            if (myCircleModel4.isDraw) {
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel4.circle_id, FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND, myCircleModel.is_member == 1, myCircleModel.allow_join == 0, myCircleModel.classify_id);
            myCircleModel4.isDraw = true;
        }
    }
}
