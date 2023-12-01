package com.blued.community.ui.circle.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.fragment.CircleTypeListFragment;
import com.blued.community.ui.circle.manager.CircleConstants;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.view.CircleJoinView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleListAdapter.class */
public class CircleListAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private LoadOptions f19113a;
    private CircleConstants.CIRCLE_FROM_PAGE b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f19114c;
    private View.OnClickListener d;
    private View e;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleListAdapter$MyCircleViewHolder.class */
    public static class MyCircleViewHolder {

        /* renamed from: a  reason: collision with root package name */
        ImageView f19117a;
        TextView b;

        /* renamed from: c  reason: collision with root package name */
        TextView f19118c;
        TextView d;
        CircleJoinView e;
        ImageView f;
        View g;

        public MyCircleViewHolder(BaseViewHolder baseViewHolder) {
            this.f19117a = (ImageView) baseViewHolder.getView(R.id.img_cover);
            this.b = (TextView) baseViewHolder.getView(R.id.tv_circle_desc);
            this.f19118c = (TextView) baseViewHolder.getView(R.id.tv_circle_name);
            this.d = (TextView) baseViewHolder.getView(R.id.tv_circle_member);
            this.f = (ImageView) baseViewHolder.getView(R.id.iv_level);
            CircleJoinView circleJoinView = (CircleJoinView) baseViewHolder.getView(R.id.cjv_join);
            this.e = circleJoinView;
            circleJoinView.setStyle(0);
            this.g = baseViewHolder.getView(R.id.view_content);
        }
    }

    public CircleListAdapter(Context context, CircleConstants.CIRCLE_FROM_PAGE circle_from_page, IRequestHost iRequestHost, View.OnClickListener onClickListener) {
        super(R.layout.item_circle_list, new ArrayList());
        this.mContext = context;
        this.d = onClickListener;
        this.f19114c = iRequestHost;
        LoadOptions loadOptions = new LoadOptions();
        this.f19113a = loadOptions;
        loadOptions.j = true;
        this.f19113a.l = false;
        this.f19113a.d = R.drawable.defaultpicture;
        this.f19113a.b = R.drawable.defaultpicture;
        this.b = circle_from_page;
        if (circle_from_page == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE) {
            View inflate = View.inflate(this.mContext, R.layout.item_joined_circle_list_footer, null);
            this.e = inflate;
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.-$$Lambda$CircleListAdapter$PjVkkVeuHKzsYmWdYA4pNLgQz3k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleListAdapter.this.a(view);
                }
            });
            setFooterView(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.MY_CIRCLE_MORE);
        CircleTypeListFragment.f19307a.a(this.mContext, FeedProtos.SourcePage.MINE_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MyCircleViewHolder myCircleViewHolder, MyCircleModel myCircleModel, View view) {
        a(myCircleViewHolder.e, myCircleModel);
        if (this.b == CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE) {
            EventTrackFeed.b(FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK, FeedProtos.CircleSource.FIND_CIRCLE_LIST, myCircleModel);
        } else if (this.b == CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE) {
            EventTrackFeed.b(FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK, FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE, myCircleModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MyCircleModel myCircleModel, MyCircleViewHolder myCircleViewHolder, View view) {
        CircleDetailsFragment.a(this.mContext, myCircleModel, this.b);
        View.OnClickListener onClickListener = this.d;
        if (onClickListener != null) {
            onClickListener.onClick(myCircleViewHolder.g);
        }
    }

    private void a(final CircleJoinView circleJoinView, final MyCircleModel myCircleModel) {
        CircleMethods.a(this.mContext, new CircleMethods.JoinViewChangeListener() { // from class: com.blued.community.ui.circle.adapter.CircleListAdapter.1
            @Override // com.blued.community.ui.circle.manager.CircleMethods.JoinViewChangeListener
            public void joinViewChange(CircleJoinState circleJoinState) {
                if (circleJoinState.isJoin()) {
                    myCircleModel.is_member = 1;
                } else {
                    myCircleModel.is_member = 0;
                }
                myCircleModel.setJoinState(circleJoinState);
                circleJoinView.setJoinStatusWithMember(myCircleModel);
                CircleListAdapter.this.notifyDataSetChanged();
            }
        }, myCircleModel.getJoinState(), this.f19114c, this.mContext instanceof AppCompatActivity ? ((AppCompatActivity) this.mContext).getSupportFragmentManager() : null, false, true);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final MyCircleModel myCircleModel) {
        if (baseViewHolder == null || myCircleModel == null) {
            return;
        }
        final MyCircleViewHolder myCircleViewHolder = new MyCircleViewHolder(baseViewHolder);
        ImageLoader.a(this.f19114c, myCircleModel.cover).b(R.drawable.circle_header_default).a(8.0f).a(myCircleViewHolder.f19117a);
        myCircleViewHolder.f19118c.setText(myCircleModel.title);
        myCircleViewHolder.b.setText(myCircleModel.description);
        TextView textView = myCircleViewHolder.d;
        textView.setText(myCircleModel.members_num + this.mContext.getResources().getString(R.string.members_count_part));
        if (this.b == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE || this.b == CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE) {
            myCircleViewHolder.g.setVisibility(0);
            myCircleViewHolder.e.setVisibility(8);
            if (this.b == CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE) {
                myCircleViewHolder.f.setVisibility(0);
                CircleMethods.a(myCircleViewHolder.f, myCircleModel.admin_level);
            }
        } else {
            myCircleViewHolder.e.setVisibility(0);
            myCircleViewHolder.e.setJoinStatusWithMember(myCircleModel);
            if (myCircleModel.is_member == 1 || myCircleModel.is_applied == 1) {
                myCircleViewHolder.e.setOnClickListener(null);
            } else {
                myCircleViewHolder.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.-$$Lambda$CircleListAdapter$zoEcJHOQlD2QxdTG0cbc9yH6pao
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CircleListAdapter.this.a(myCircleViewHolder, myCircleModel, view);
                    }
                });
            }
        }
        if (this.b == CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE) {
            if (!myCircleModel.isDraw) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel.circle_id, FeedProtos.CircleSource.FIND_CIRCLE_LIST, myCircleModel.is_member == 1, myCircleModel.allow_join == 0, myCircleModel.classify_id);
                myCircleModel.isDraw = true;
            }
        } else if (this.b == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE) {
            if (!myCircleModel.isDraw) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel.circle_id, FeedProtos.CircleSource.FIND_CIRCLE_MINE_ALL, myCircleModel.is_member == 1, myCircleModel.allow_join == 0, myCircleModel.classify_id);
                myCircleModel.isDraw = true;
            }
        } else if (this.b == CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE && !myCircleModel.isDraw) {
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel.circle_id, FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE, myCircleModel.is_member == 1, myCircleModel.allow_join == 0, myCircleModel.classify_id);
            myCircleModel.isDraw = true;
        }
        myCircleViewHolder.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.adapter.-$$Lambda$CircleListAdapter$gcvwP2EH1I4r7j5VQvM_cAVcGL4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleListAdapter.this.a(myCircleModel, myCircleViewHolder, view);
            }
        });
    }
}
