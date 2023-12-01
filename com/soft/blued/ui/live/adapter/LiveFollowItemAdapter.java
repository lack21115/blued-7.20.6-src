package com.soft.blued.ui.live.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.common.widget.refresh.RecommendLoadMoreView;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRecommendModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.view.LiveAutoPlayView;
import com.blued.android.module.live_china.view.LiveListAutoPlay;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.fragment.LiveJoinFansFragment;
import com.soft.blued.ui.live.fragment.RequestAnchorLiveRewardFragment;
import com.soft.blued.ui.live.model.RequestLiveExtra;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveFollowItemAdapter.class */
public class LiveFollowItemAdapter extends BaseMultiItemQuickAdapter<BluedLiveListData, BaseViewHolder> implements LiveListAutoPlay {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f17377a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private HashSet<String> f17378c;
    private List<LiveRecommendModel> d;
    private LiveHorizontalRecommendAdapter e;
    private int f;
    private BaseQuickAdapter.RequestLoadMoreListener g;
    private int h;
    private LiveAutoPlayView i;
    private List<String> j;
    private boolean k;

    public LiveFollowItemAdapter(BaseFragment baseFragment) {
        super(new ArrayList());
        this.f17378c = new HashSet<>();
        this.f = 0;
        this.h = 500;
        this.j = new ArrayList();
        this.k = true;
        this.f17377a = baseFragment;
        this.b = baseFragment.getFragmentActive();
        this.mContext = baseFragment.getContext();
        addItemType(0, R.layout.item_live_follow_list_show);
        addItemType(1, R.layout.recommend_linear_layout);
        addItemType(2, R.layout.item_live_follow_online_layout);
        this.h = (AppInfo.l - DisplayUtil.a(this.mContext, 25.0f)) / 2;
    }

    private String a(int i) {
        return this.mContext.getResources().getString(i);
    }

    private void a(final BluedLiveListData bluedLiveListData) {
        if (bluedLiveListData == null || bluedLiveListData.anchor == null) {
            return;
        }
        LiveHttpUtils.c(new BluedUIHttpResponse<BluedEntity<BluedEntityBaseExtra, RequestLiveExtra>>(this.b) { // from class: com.soft.blued.ui.live.adapter.LiveFollowItemAdapter.2
            public boolean onUIFailure(int i, String str) {
                if (i == 50002) {
                    ToastUtils.b("请打开通知权限，以免错过主播开播通知");
                    bluedLiveListData.notify = 1;
                    LiveFollowItemAdapter.this.notifyDataSetChanged();
                    return true;
                }
                return super.onUIFailure(i, str);
            }

            public void onUIUpdate(BluedEntity<BluedEntityBaseExtra, RequestLiveExtra> bluedEntity) {
                if (bluedEntity.extra != null && !TextUtils.isEmpty(((RequestLiveExtra) bluedEntity.extra).lid)) {
                    bluedLiveListData.lid = ((RequestLiveExtra) bluedEntity.extra).lid;
                    bluedLiveListData.live_play = null;
                    LiveFollowItemAdapter.this.a(bluedLiveListData, false);
                    LiveFollowItemAdapter.this.mData.remove(bluedLiveListData);
                    LiveFollowItemAdapter.this.mData.add(0, bluedLiveListData);
                    LiveFollowItemAdapter.this.notifyDataSetChanged();
                } else if (bluedLiveListData.notify == 0) {
                    ToastUtils.b("主播已收到你的提醒，开播会通知你");
                    bluedLiveListData.notify = 1;
                    LiveEventBusUtil.b();
                    LiveFollowItemAdapter.this.notifyDataSetChanged();
                } else if (bluedLiveListData.notify == 1 && bluedLiveListData.anchor != null && LiveDataManager.a().h()) {
                    RequestAnchorLiveRewardFragment.a(LiveFollowItemAdapter.this.f17377a, bluedLiveListData.anchor.uid);
                } else {
                    ToastUtils.b("已经催过主播啦，请耐心等待开播");
                }
            }
        }, bluedLiveListData.anchor.uid, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluedLiveListData bluedLiveListData, View view) {
        Tracker.onClick(view);
        if (a(bluedLiveListData, false)) {
            return;
        }
        a(bluedLiveListData);
        if (bluedLiveListData.anchor != null) {
            if (bluedLiveListData.notify != 1) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PLEASE_BTN_CLICK, bluedLiveListData.anchor.uid);
            } else if (LiveDataManager.a().h()) {
                EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_REWARD_CLICK, bluedLiveListData.anchor.uid, UserInfo.getInstance().getLoginUserInfo().getRich_level());
            } else {
                EventTrackLive.a(LiveProtos.Event.LIVE_URGE_BTN_CLICK, bluedLiveListData.anchor.uid);
            }
        }
    }

    private void a(BaseViewHolder baseViewHolder) {
        PullToRefreshRecyclerView view = baseViewHolder.getView(R.id.live_recommend_hListView);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.recommend_linear_root);
        View view2 = baseViewHolder.getView(R.id.view_top_line);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_recommend_tip);
        RecyclerView recyclerView = (RecyclerView) view.getRefreshableView();
        this.e = new LiveHorizontalRecommendAdapter(this.b, this.mContext, 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.e);
        this.e.setLoadMoreView(new RecommendLoadMoreView());
        BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener = this.g;
        if (requestLoadMoreListener != null) {
            this.e.setOnLoadMoreListener(requestLoadMoreListener, recyclerView);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                break;
            }
            LiveRecommendModel liveRecommendModel = this.d.get(i2);
            if (!this.f17378c.contains(liveRecommendModel.uid)) {
                this.e.addData((LiveHorizontalRecommendAdapter) liveRecommendModel);
                this.f17378c.add(liveRecommendModel.uid);
            }
            i = i2 + 1;
        }
        this.e.notifyDataSetChanged();
        List<LiveRecommendModel> list = this.d;
        if (list == null || !list.isEmpty()) {
            view2.setVisibility(0);
            textView.setVisibility(0);
            view.setVisibility(0);
            return;
        }
        view2.setVisibility(8);
        textView.setVisibility(8);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(BluedLiveListData bluedLiveListData, boolean z) {
        String str;
        String str2;
        String str3;
        if (bluedLiveListData == null) {
            return false;
        }
        if (bluedLiveListData.anchor != null) {
            String str4 = bluedLiveListData.anchor.name;
            String str5 = bluedLiveListData.anchor.avatar;
            str3 = bluedLiveListData.anchor.uid;
            str2 = str4;
            str = str5;
        } else {
            str = "";
            str2 = "";
            str3 = "";
        }
        if (bluedLiveListData.isLivingForFollow()) {
            LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(bluedLiveListData.lid, 0L), bluedLiveListData.screen_pattern, "followed", str3, str2, str, 0);
            liveRoomData.live_url = bluedLiveListData.live_play;
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_open_fans", z);
            LiveRoomInfoChannel.a(this.mContext, liveRoomData, -1, LiveRoomInfoChannel.a(a(), "followed"), bundle);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BluedLiveListData bluedLiveListData, View view) {
        Tracker.onClick(view);
        Bundle bundle = new Bundle();
        if (bluedLiveListData.anchor != null) {
            bundle.putString("anchor_id", bluedLiveListData.anchor.uid);
        }
        LiveJoinFansFragment.a(this.mContext, bundle);
        if (bluedLiveListData.anchor != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOW_END_NAMEPLATE_CLICK, bluedLiveListData.anchor.uid);
        }
    }

    private void b(BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.tv_live_follow_head);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_cover_box);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView2.getLayoutParams();
        int i = layoutParams.height;
        int i2 = this.h;
        if (i != i2) {
            layoutParams.height = i2;
            imageView.setLayoutParams(layoutParams);
        }
        int i3 = layoutParams2.height;
        int i4 = this.h;
        if (i3 != i4) {
            layoutParams2.height = i4;
            imageView2.setLayoutParams(layoutParams2);
        }
        if (TextUtils.isEmpty(bluedLiveListData.cover_box_url)) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            ImageLoader.a(this.b, bluedLiveListData.cover_box_url).e(imageView2.hashCode()).g(-1).a(imageView2);
        }
        ImageLoader.a(this.b, bluedLiveListData.anchor.avatar).b(2131234804).a(6.0f).a(imageView);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.live_type_icon);
        if (bluedLiveListData.link_type == 1) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235124);
        } else if (bluedLiveListData.link_type == 2) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235118);
        } else if (bluedLiveListData.link_type == 4) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235119);
        } else if (bluedLiveListData.link_type == 6) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131235120);
        } else {
            imageView3.setVisibility(8);
        }
        ((TextView) baseViewHolder.getView(R.id.tv_live_follow_name)).setText(TextUtils.isEmpty(bluedLiveListData.anchor.name) ? "" : bluedLiveListData.anchor.name);
        LiveFansLevelView view = baseViewHolder.getView(R.id.live_fans_level);
        view.a(bluedLiveListData.in_fan_club, bluedLiveListData.fan_club_level, bluedLiveListData.fan_club_name, bluedLiveListData.fans_status);
        if (!this.j.contains(bluedLiveListData.lid)) {
            this.j.add(bluedLiveListData.lid);
            if (bluedLiveListData.anchor != null) {
                com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_SHOW, "follow_list", bluedLiveListData.lid, bluedLiveListData.anchor.uid, bluedLiveListData.isPKStreamShow(), bluedLiveListData.weight, bluedLiveListData.cover_box_id);
            }
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LiveFollowItemAdapter$scnrA6aNulZHul7vs6mu1J4tD1I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveFollowItemAdapter.this.c(bluedLiveListData, view2);
            }
        });
        if (bluedLiveListData.isPKStreamShow()) {
            baseViewHolder.setGone(R.id.live_type_right_icon, true);
            if (bluedLiveListData.win_streak == 10) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235385);
            } else if (bluedLiveListData.win_streak == 20) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235386);
            } else if (bluedLiveListData.win_streak == 30) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235387);
            } else if (bluedLiveListData.win_streak == 40) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235388);
            } else if (bluedLiveListData.win_streak == 50) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235389);
            } else if (bluedLiveListData.win_streak == 60) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235390);
            } else if (bluedLiveListData.win_streak == 70) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235391);
            } else if (bluedLiveListData.win_streak == 80) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235392);
            } else if (bluedLiveListData.win_streak == 90) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235393);
            } else if (bluedLiveListData.win_streak == 99) {
                baseViewHolder.setImageResource(R.id.live_type_right_icon, 2131235394);
            }
        } else {
            baseViewHolder.setGone(R.id.live_type_right_icon, false);
        }
        int i5 = layoutParams.height;
        int i6 = layoutParams.width == i5 ? layoutParams.width : i5;
        LiveAutoPlayView view2 = baseViewHolder.getView(R.id.fl_video_view);
        view2.setLayoutParams(new FrameLayout.LayoutParams(i6, i5));
        RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) baseViewHolder.itemView.getLayoutParams();
        layoutParams3.height = i5;
        layoutParams3.width = i6;
        baseViewHolder.itemView.setLayoutParams(layoutParams3);
        view2.a(this, bluedLiveListData, "followed", i6, i5);
        if (bluedLiveListData.positionReal == 0) {
            if (bluedLiveListData.link_type == 1 || bluedLiveListData.link_type == 2 || bluedLiveListData.link_type == 4 || bluedLiveListData.live_type != 0) {
                this.i = null;
            } else {
                this.i = view2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(BluedLiveListData bluedLiveListData, View view) {
        Tracker.onClick(view);
        boolean z = true;
        if (bluedLiveListData.in_fan_club == 1) {
            z = false;
        }
        a(bluedLiveListData, z);
        if (bluedLiveListData.anchor != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOW_LIVING_JOIN_FANS_CLICK, bluedLiveListData.anchor.uid);
        }
    }

    private void c(BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData) {
        if (!this.j.contains(bluedLiveListData.lid)) {
            this.j.add(bluedLiveListData.lid);
            if (bluedLiveListData.anchor != null) {
                EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, "follow_list", bluedLiveListData.lid, bluedLiveListData.anchor.uid);
            }
        }
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.tv_live_follow_head);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_live_follow_name);
        LiveFansLevelView view = baseViewHolder.getView(R.id.live_record_level);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_live_follow_content);
        View view2 = baseViewHolder.getView(R.id.live_follow_apply_for_live_layout);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.live_follow_apply_for_live_iv);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.live_follow_apply_for_live_tv);
        ImageLoader.a(this.b, !TextUtils.isEmpty(bluedLiveListData.pic_url) ? bluedLiveListData.pic_url : bluedLiveListData.anchor.avatar).b(2131234804).a(imageView);
        if (TextUtils.isEmpty(bluedLiveListData.anchor.name)) {
            textView.setText("");
        } else {
            textView.setText(bluedLiveListData.anchor.name);
        }
        if (bluedLiveListData.in_fan_club == 1) {
            view.a(bluedLiveListData.in_fan_club, bluedLiveListData.fan_club_level, bluedLiveListData.fan_club_name, bluedLiveListData.fans_status);
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        String a2 = TimeAndDateUtils.a(this.mContext, bluedLiveListData.last_start_time * 1000);
        if (TextUtils.isEmpty(a2)) {
            textView2.setText("");
        } else {
            textView2.setText(String.format(a(R.string.live_last_living), a2));
        }
        view2.setVisibility(0);
        if (bluedLiveListData.notify != 1) {
            imageView2.setImageResource(2131234675);
            textView3.setText("求开播");
        } else if (LiveDataManager.a().h()) {
            imageView2.setImageResource(2131235622);
            textView3.setText("打赏");
        } else {
            imageView2.setImageResource(2131234677);
            textView3.setText("已催过");
            textView3.setTextColor(BluedSkinUtils.a(this.mContext, 2131102264));
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LiveFollowItemAdapter$mHoG9G1kTyZVSVgOgjwf7GNlyTI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LiveFollowItemAdapter.this.b(bluedLiveListData, view3);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LiveFollowItemAdapter$EG_jxJMfqYH89tT46JV-_xwvZC4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LiveFollowItemAdapter.this.a(bluedLiveListData, view3);
            }
        });
    }

    public List<BluedLiveListData> a() {
        ArrayList arrayList = new ArrayList();
        for (T t : getData()) {
            if (t.isLivingForFollow() && t.liveType == 0) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public void a(BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener) {
        this.g = requestLoadMoreListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == 0) {
            c(baseViewHolder, bluedLiveListData);
        } else if (itemViewType != 1) {
            if (itemViewType != 2) {
                return;
            }
            b(baseViewHolder, bluedLiveListData);
        } else {
            this.f = getData().indexOf(bluedLiveListData);
            this.f17378c.clear();
            this.d = bluedLiveListData.liveRecommendModelList;
            LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.e;
            if (liveHorizontalRecommendAdapter != null) {
                liveHorizontalRecommendAdapter.a();
            }
            a(baseViewHolder);
        }
    }

    public void a(List<BluedLiveListData> list) {
        this.j.clear();
        setNewData(list);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.live.adapter.LiveFollowItemAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                LiveFollowItemAdapter.this.e();
            }
        }, 500L);
    }

    public void a(boolean z) {
        LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.e;
        if (liveHorizontalRecommendAdapter == null) {
            return;
        }
        liveHorizontalRecommendAdapter.setEnableLoadMore(z);
    }

    public List<BluedLiveListData> b() {
        ArrayList arrayList = new ArrayList();
        for (T t : getData()) {
            if (t.liveType == 0) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public void b(List<LiveRecommendModel> list) {
        LiveHorizontalRecommendAdapter liveHorizontalRecommendAdapter = this.e;
        if (liveHorizontalRecommendAdapter == null) {
            return;
        }
        int size = liveHorizontalRecommendAdapter.getData().size();
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                LiveRecommendModel liveRecommendModel = list.get(i2);
                if (!this.f17378c.contains(liveRecommendModel.uid)) {
                    this.e.getData().add(liveRecommendModel);
                    this.f17378c.add(liveRecommendModel.uid);
                }
                i = i2 + 1;
            }
            this.e.notifyDataSetChanged();
        }
        if (size == this.e.getData().size()) {
            this.e.loadMoreComplete();
            this.e.loadMoreEnd();
        }
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void c(boolean z) {
        LiveAutoPlayView liveAutoPlayView = this.i;
        if (liveAutoPlayView != null) {
            liveAutoPlayView.a(z);
        }
    }

    public boolean c() {
        LiveAutoPlayView liveAutoPlayView = this.i;
        if (liveAutoPlayView == null || !liveAutoPlayView.e()) {
            return false;
        }
        LiveAutoPlayView liveAutoPlayView2 = this.i;
        if (liveAutoPlayView2 == null || !this.k) {
            return true;
        }
        liveAutoPlayView2.b();
        return true;
    }

    public void d() {
        LiveAutoPlayView liveAutoPlayView = this.i;
        if (liveAutoPlayView != null) {
            liveAutoPlayView.c();
        }
    }

    public void e() {
        if (c()) {
            return;
        }
        d();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i >= this.mData.size() || !((BluedLiveListData) this.mData.get(i)).isLivingForFollow()) {
            return super.getItemViewType(i);
        }
        return 2;
    }
}
