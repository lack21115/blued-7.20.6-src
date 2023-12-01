package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveRankWebDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.LiveRankingListExtra;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.RankHourDataModel;
import com.blued.android.module.live_china.model.RankHourExtraModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveRankListToolBarView;
import com.blued.android.module.live_china.view.PopRankingListView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingListView.class */
public class PopRankingListView {
    private LayoutInflater a;
    private Context b;
    private View c;
    private View d;
    private MyPopupWindow e;
    private View f;
    private CustomViewPager g;
    private LiveRankListToolBarView h;
    private MyPagerAdapter i;
    private BaseFragment j;
    private IRequestHost k;
    private View l;
    private int m;
    private String o;
    private RankingAdapter p;
    private LiveRankWebDialogFragment s;
    private int t;
    private int u;
    private final int n = 3;
    private Map<String, View> q = new HashMap();
    private Map<String, View> r = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingListView$BannerPagerAdapter.class */
    public class BannerPagerAdapter extends PagerAdapter {
        List<RankHourDataModel> a;
        Map<String, View> b = new HashMap();

        public BannerPagerAdapter(List<RankHourDataModel> list) {
            this.a = new ArrayList();
            this.a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(RankHourDataModel rankHourDataModel, View view) {
            PopRankingListView.this.a(rankHourDataModel.getUid(), rankHourDataModel.getType());
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.a.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.b.get(String.valueOf(i));
            while (view == null) {
                view = LayoutInflater.from(PopRankingListView.this.b).inflate(R.layout.item_live_banner_rank_hour, viewGroup, false);
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_avatar);
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_avatar_frame);
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_bounce);
                TextView textView2 = (TextView) view.findViewById(R.id.tv_desc);
                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_time_hour);
                ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_time_minute);
                View findViewById = view.findViewById(R.id.rl_time_root);
                ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_tag);
                final RankHourDataModel rankHourDataModel = this.a.get(this.b.size());
                imageView.setImageResource("top".equals(rankHourDataModel.getType()) ? R.drawable.live_rank_hour_banner_top : R.drawable.live_rank_hour_banner_potential);
                ImageLoader.a(PopRankingListView.this.k, AvatarUtils.a(1, rankHourDataModel.getAvatar())).c().b(R.drawable.live_rank_hour_default_avatar).a(imageView2);
                if (TextUtils.isEmpty(rankHourDataModel.getAvatar_frame())) {
                    imageView3.setVisibility(8);
                } else {
                    imageView3.setVisibility(0);
                    if (rankHourDataModel.getAvatar_frame_type() != 0) {
                        ImageLoader.a(PopRankingListView.this.k, rankHourDataModel.getAvatar_frame()).g().g(-1).a(imageView3);
                    } else {
                        ImageLoader.a(PopRankingListView.this.k, rankHourDataModel.getAvatar_frame()).a(imageView3);
                    }
                }
                textView2.setText(rankHourDataModel.getText());
                if (rankHourDataModel.getUid() <= 0) {
                    textView.setText(R.string.live_rank_vacancy);
                    textView.getPaint().setFakeBoldText(true);
                    imageView4.setVisibility(8);
                    findViewById.setVisibility(8);
                    imageView7.setVisibility(8);
                    imageView.setClickable(false);
                } else {
                    textView.setText(rankHourDataModel.getName());
                    textView.getPaint().setFakeBoldText(true);
                    if (rankHourDataModel.getLive() <= 0) {
                        imageView4.setVisibility(8);
                    } else {
                        imageView4.setVisibility(0);
                        ImageLoader.c(PopRankingListView.this.k, "live_rank_hour_bounce_white.png").g().g(-1).a(imageView4);
                    }
                    PopRankingListView.this.a(imageView5, imageView6, rankHourDataModel.getHour());
                    imageView7.setImageResource("top".equals(rankHourDataModel.getType()) ? R.drawable.live_rank_hour_star_top : R.drawable.live_rank_hour_star_potential);
                    findViewById.setVisibility(0);
                    imageView7.setVisibility(0);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopRankingListView$BannerPagerAdapter$Qtbnk6kOUikblClpl66vFIo0Vhg
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            PopRankingListView.BannerPagerAdapter.this.a(rankHourDataModel, view2);
                        }
                    });
                }
                this.b.put(String.valueOf(i), view);
            }
            View view2 = this.b.get(String.valueOf(i));
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            viewGroup.addView(view2);
            return view2;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingListView$HOUR_TYPE.class */
    public interface HOUR_TYPE {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingListView$MyPagerAdapter.class */
    public class MyPagerAdapter extends PagerAdapter {
        MyPagerAdapter() {
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return PopRankingListView.this.m;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (((View) PopRankingListView.this.q.get(String.valueOf(i))) == null) {
                if (i == PopRankingListView.this.t) {
                    PopRankingListView.this.q.put(String.valueOf(i), PopRankingListView.this.a(viewGroup));
                } else {
                    View inflate = LayoutInflater.from(PopRankingListView.this.b).inflate(R.layout.pop_window_ranking_list, viewGroup, false);
                    RecyclerView findViewById = inflate.findViewById(R.id.recycler_list);
                    findViewById.setLayoutManager(new LinearLayoutManager(PopRankingListView.this.b, 1, false));
                    View findViewById2 = inflate.findViewById(R.id.tv_hot_tips);
                    View findViewById3 = inflate.findViewById(R.id.tv_send_gift);
                    if (PopRankingListView.this.j instanceof PlayingOnliveFragment) {
                        findViewById3.setVisibility(0);
                        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.MyPagerAdapter.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Tracker.onClick(view);
                                if (PopRankingListView.this.g.getCurrentItem() == 1) {
                                    EventTrackLive.c(LiveProtos.Event.LIVE_HOT_LIST_GO_GOODS_CLICK, PopRankingListView.this.o);
                                } else if (PopRankingListView.this.g.getCurrentItem() == 2) {
                                    EventTrackLive.c(LiveProtos.Event.LIVE_SOAR_LIST_GO_GOODS_CLICK, PopRankingListView.this.o);
                                }
                                PopRankingListView.this.c();
                                LiveRefreshUIObserver.a().j();
                            }
                        });
                    } else {
                        findViewById3.setVisibility(8);
                    }
                    if (i == PopRankingListView.this.u) {
                        findViewById2.setVisibility(0);
                        PopRankingListView.this.p = new RankingAdapter(1, 0);
                        findViewById.setAdapter(PopRankingListView.this.p);
                    }
                    PopRankingListView.this.q.put(String.valueOf(i), inflate);
                }
            }
            View view = (View) PopRankingListView.this.q.get(String.valueOf(i));
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingListView$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopRankingListView.this.c();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingListView$RANKING_TYPE.class */
    public interface RANKING_TYPE {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRankingListView$RankingAdapter.class */
    class RankingAdapter extends BaseQuickAdapter<LiveRankingListExtra, BaseViewHolder> {
        private int b;
        private int c;

        public RankingAdapter(int i, int i2) {
            super(R.layout.pop_window_ranking_list_item, (List) null);
            this.b = i;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final LiveRankingListExtra liveRankingListExtra) {
            if (this.b == 1) {
                EventTrackLive.c(LiveProtos.Event.LIVE_HOT_LIST_SHOW, String.valueOf(liveRankingListExtra.uid));
            }
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_rank_index);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_rank_index);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.live_user_avatar_decorate);
            ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.avatar);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_name);
            TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_rank);
            TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_pk);
            textView.setText(liveRankingListExtra.index + "");
            if (liveRankingListExtra.index == 1) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.live_rank_up_one);
                textView.setVisibility(8);
            } else if (liveRankingListExtra.index == 2) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.live_rank_up_two);
                textView.setVisibility(8);
            } else if (liveRankingListExtra.index == 3) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.live_rank_up_three);
                textView.setVisibility(8);
            } else {
                imageView.setVisibility(8);
                textView.setVisibility(0);
            }
            ImageLoader.a((IRequestHost) null, liveRankingListExtra.avatar).b(R.drawable.channel_default_head).c().a(imageView3);
            if (TextUtils.isEmpty(liveRankingListExtra.avatar_frame)) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setVisibility(0);
                if (liveRankingListExtra.avatar_frame_type == 1) {
                    ImageLoader.a(PopRankingListView.this.k, liveRankingListExtra.avatar_frame).f(imageView2.hashCode()).g(-1).a(imageView2);
                } else if (liveRankingListExtra.avatar_frame_type == 2) {
                    ImageLoader.a(PopRankingListView.this.k, liveRankingListExtra.avatar_frame).e(imageView2.hashCode()).g(-1).a(imageView2);
                } else {
                    ImageLoader.a(PopRankingListView.this.k, liveRankingListExtra.avatar_frame).a(imageView2);
                }
            }
            textView2.setText(liveRankingListExtra.nickname);
            if (this.b == 1) {
                if (liveRankingListExtra.compareHot < 0.0d) {
                    textView3.setText(String.format(this.mContext.getResources().getString(R.string.live_ranking_backward_x_hit), PopRankingListView.this.a(liveRankingListExtra.compareHot * (-1.0d))));
                } else {
                    textView3.setText(String.format(this.mContext.getResources().getString(R.string.live_ranking_leading_x_hit), PopRankingListView.this.a(liveRankingListExtra.compareHot)));
                }
                textView4.setVisibility(8);
            }
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.RankingAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (RankingAdapter.this.b == 1) {
                        EventTrackLive.c(LiveProtos.Event.LIVE_HOT_LIST_CLICK, String.valueOf(liveRankingListExtra.uid));
                    }
                    if (!(PopRankingListView.this.j instanceof PlayingOnliveFragment)) {
                        if (PopRankingListView.this.j instanceof RecordingOnliveFragment) {
                            AppMethods.a((CharSequence) "当前正在开播无法切换直播间");
                        }
                    } else if (LiveRoomManager.a().p() != null && liveRankingListExtra.lid > 0) {
                        LiveDataListManager.a().b(new LiveRoomData(liveRankingListExtra.lid, 0, "live_room_ranking", liveRankingListExtra.uid, liveRankingListExtra.nickname, liveRankingListExtra.avatar, 0));
                    }
                }
            });
        }
    }

    public PopRankingListView(BaseFragment baseFragment) {
        this.m = 2;
        this.t = 0;
        this.u = 1;
        this.j = baseFragment;
        this.b = baseFragment.getContext();
        this.k = baseFragment.getFragmentActive();
        if (!LiveRoomManager.a().p().isShowHourRank) {
            this.t = -1;
            this.u = 0;
            this.m = 1;
        } else if (!LiveRoomManager.a().Q()) {
            this.u = -1;
            this.t = 0;
            this.m = 1;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.pop_window_ranking_hour, viewGroup, false);
        ((PopRankingHourCardView) inflate.findViewById(R.id.hour_card_current)).a(this.j, this.k, true, 0);
        a((AutoScrollViewPager) inflate.findViewById(R.id.asvp_star_banner), inflate.findViewById(R.id.ll_cursor_root));
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str) {
        if (LiveRoomManager.a().g() == null || !LiveRoomManager.a().g().equals(String.valueOf(j))) {
            EventTrackLive.o(LiveProtos.Event.LIVE_HOUR_LIST_BANNER_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str);
            LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>() { // from class: com.blued.android.module.live_china.view.PopRankingListView.10
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                        return;
                    }
                    AnchorLiveStateModel singleData = bluedEntityA.getSingleData();
                    if (singleData.is_live == 1) {
                        try {
                            PopRankingListView.this.a(singleData);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, String.valueOf(j), this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, ImageView imageView2, int i) {
        int i2;
        int i3 = i / 10;
        imageView.setImageResource(i3 != 1 ? i3 != 2 ? R.drawable.live_rank_hour_number_white_0 : R.drawable.live_rank_hour_number_white_2 : R.drawable.live_rank_hour_number_white_1);
        switch (i % 10) {
            case 1:
                i2 = R.drawable.live_rank_hour_number_white_1;
                break;
            case 2:
                i2 = R.drawable.live_rank_hour_number_white_2;
                break;
            case 3:
                i2 = R.drawable.live_rank_hour_number_white_3;
                break;
            case 4:
                i2 = R.drawable.live_rank_hour_number_white_4;
                break;
            case 5:
                i2 = R.drawable.live_rank_hour_number_white_5;
                break;
            case 6:
                i2 = R.drawable.live_rank_hour_number_white_6;
                break;
            case 7:
                i2 = R.drawable.live_rank_hour_number_white_7;
                break;
            case 8:
                i2 = R.drawable.live_rank_hour_number_white_8;
                break;
            case 9:
                i2 = R.drawable.live_rank_hour_number_white_9;
                break;
            default:
                i2 = R.drawable.live_rank_hour_number_white_0;
                break;
        }
        imageView2.setImageResource(i2);
    }

    private void a(final AutoScrollViewPager autoScrollViewPager, final View view) {
        LiveRoomHttpUtils.a(1, 1, LiveRoomManager.a().g(), new BluedUIHttpResponse<BluedEntity<Object, RankHourExtraModel>>(this.k) { // from class: com.blued.android.module.live_china.view.PopRankingListView.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, RankHourExtraModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null || bluedEntity.extra.getBanner() == null || bluedEntity.extra.getBanner().isEmpty()) {
                    return;
                }
                PopRankingListView.this.a(autoScrollViewPager, view, bluedEntity.extra.getBanner());
            }
        }, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AutoScrollViewPager autoScrollViewPager, View view, final List<RankHourDataModel> list) {
        autoScrollViewPager.setAdapter(new BannerPagerAdapter(list));
        autoScrollViewPager.setInterval(5000L);
        autoScrollViewPager.a();
        if (list.size() > 1) {
            final View findViewById = view.findViewById(R.id.view_cursor_top);
            final View findViewById2 = view.findViewById(R.id.view_cursor_potential);
            view.setVisibility(0);
            autoScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.9
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    if (i == 0) {
                        findViewById.animate().translationX(0.0f).setDuration(200L);
                        findViewById2.animate().translationX(-findViewById2.getWidth()).setDuration(200L);
                    } else {
                        findViewById.animate().translationX(findViewById.getWidth()).setDuration(200L);
                        findViewById2.animate().translationX(0.0f).setDuration(200L);
                    }
                    EventTrackLive.o(LiveProtos.Event.LIVE_HOUR_LIST_BANNER_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), ((RankHourDataModel) list.get(i)).getType());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AnchorLiveStateModel anchorLiveStateModel) {
        LiveRoomData liveRoomData = new LiveRoomData();
        liveRoomData.lid = anchorLiveStateModel.lid;
        LiveRoomAnchorModel liveRoomAnchorModel = new LiveRoomAnchorModel();
        liveRoomAnchorModel.name = anchorLiveStateModel.name;
        liveRoomAnchorModel.avatar = anchorLiveStateModel.avatar;
        liveRoomAnchorModel.uid = anchorLiveStateModel.uid;
        liveRoomData.profile = liveRoomAnchorModel;
        LiveDataListManager.a().b(liveRoomData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        if (i == 1) {
            EventTrackLive.c(LiveProtos.Event.LIVE_HOT_PAGE_SHOW, this.o);
            LiveRoomHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<LiveRankingListExtra, LiveRankingListExtra>>(this.k) { // from class: com.blued.android.module.live_china.view.PopRankingListView.6
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str) {
                    View view = (View) PopRankingListView.this.q.get(String.valueOf(i));
                    if (view != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_empty_view);
                        textView.setVisibility(0);
                        textView.setText(R.string.live_network_error);
                    }
                    return super.onUIFailure(i2, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    PopRankingListView.this.l.setVisibility(8);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                    PopRankingListView.this.l.setVisibility(0);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<LiveRankingListExtra, LiveRankingListExtra> bluedEntity) {
                    View view = (View) PopRankingListView.this.q.get(String.valueOf(i));
                    if (view == null) {
                        return;
                    }
                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_anchor_rank_layout);
                    TextView textView = (TextView) view.findViewById(R.id.tv_rank_index);
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_rank_index);
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.live_user_avatar_decorate);
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.avatar);
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_rank);
                    RecyclerView findViewById = view.findViewById(R.id.recycler_list);
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_empty_view);
                    if (!bluedEntity.hasData()) {
                        shapeLinearLayout.setVisibility(8);
                        textView4.setVisibility(0);
                        textView4.setText(R.string.live_ranking_no_data);
                        findViewById.setVisibility(8);
                        return;
                    }
                    shapeLinearLayout.setVisibility(0);
                    textView4.setVisibility(8);
                    findViewById.setVisibility(0);
                    if (TextUtils.isEmpty(bluedEntity.extra.avatar_frame)) {
                        imageView2.setVisibility(8);
                    } else {
                        imageView2.setVisibility(0);
                        if (bluedEntity.extra.avatar_frame_type == 1) {
                            ImageLoader.a(PopRankingListView.this.k, bluedEntity.extra.avatar_frame).f(imageView2.hashCode()).g(-1).a(imageView2);
                        } else if (bluedEntity.extra.avatar_frame_type == 2) {
                            ImageLoader.a(PopRankingListView.this.k, bluedEntity.extra.avatar_frame).e(imageView2.hashCode()).g(-1).a(imageView2);
                        } else {
                            ImageLoader.a(PopRankingListView.this.k, bluedEntity.extra.avatar_frame).a(imageView2);
                        }
                    }
                    textView.setText(String.valueOf(bluedEntity.extra.index));
                    if (bluedEntity.extra.index == 1) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_one);
                        textView.setVisibility(8);
                    } else if (bluedEntity.extra.index == 2) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_two);
                        textView.setVisibility(8);
                    } else if (bluedEntity.extra.index == 3) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_three);
                        textView.setVisibility(8);
                    } else {
                        imageView.setVisibility(8);
                        if (i == 1) {
                            if (bluedEntity.extra.index <= 0) {
                                textView.setVisibility(8);
                            } else {
                                textView.setVisibility(0);
                            }
                        }
                    }
                    textView2.setText(bluedEntity.extra.nickname);
                    ImageLoader.a((IRequestHost) null, bluedEntity.extra.avatar).b(R.drawable.channel_default_head).c().a(imageView3);
                    if (i == 1) {
                        textView3.setText(PopRankingListView.this.a(bluedEntity.extra.hot) + "热度值");
                        for (int i2 = 0; i2 < bluedEntity.data.size(); i2++) {
                            bluedEntity.data.get(i2).compareHot = bluedEntity.extra.hot - bluedEntity.data.get(i2).hot;
                        }
                        PopRankingListView.this.p.setNewData(bluedEntity.data);
                    }
                }
            }, i == 1 ? 1 : 2);
        }
    }

    private void d() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.a = from;
        View inflate = from.inflate(R.layout.pop_window_ranking, (ViewGroup) null);
        this.c = inflate.findViewById(R.id.tv_bg);
        this.q.clear();
        this.r.clear();
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopRankingListView.this.c();
            }
        });
        View findViewById = inflate.findViewById(R.id.ll_content);
        this.d = findViewById;
        findViewById.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.iv_help);
        this.f = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.LIVE_HOT_SOAR_LIST_QA_CLICK);
                if (PopRankingListView.this.s == null || !PopRankingListView.this.s.isVisible()) {
                    PopRankingListView.this.s = new LiveRankWebDialogFragment();
                    if (PopRankingListView.this.j != null) {
                        PopRankingListView.this.s.show(PopRankingListView.this.j.getFragmentManager(), "rankWebDialog");
                    }
                }
            }
        });
        this.l = inflate.findViewById(R.id.ll_loading);
        this.g = (CustomViewPager) inflate.findViewById(R.id.live_record_level_viewpager);
        LiveRankListToolBarView liveRankListToolBarView = (LiveRankListToolBarView) inflate.findViewById(R.id.live_record_level_tool_bar);
        this.h = liveRankListToolBarView;
        liveRankListToolBarView.a();
        this.h.setOnToolBarItemClickListener(new LiveRankListToolBarView.OnToolBarItemClickListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.4
            @Override // com.blued.android.module.live_china.view.LiveRankListToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                if (LiveRoomManager.a().p().isShowHourRank && LiveRoomManager.a().Q()) {
                    PopRankingListView.this.g.setCurrentItem(i);
                } else {
                    PopRankingListView.this.g.setCurrentItem(0);
                }
            }
        });
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter();
        this.i = myPagerAdapter;
        this.g.setAdapter(myPagerAdapter);
        this.g.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.view.PopRankingListView.5
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (LiveRoomManager.a().p().isShowHourRank && LiveRoomManager.a().Q()) {
                    PopRankingListView.this.g.setCurrentItem(i);
                } else {
                    PopRankingListView.this.g.setCurrentItem(0);
                }
                PopRankingListView.this.h.setToolBtnSelect(i);
                if (i == PopRankingListView.this.u) {
                    PopRankingListView.this.b(1);
                }
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.b.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.e.setTouchable(true);
        this.e.setOutsideTouchable(true);
        this.e.setFocusable(true);
        this.e.update();
    }

    public void a(int i) {
        int i2;
        if (LiveRoomManager.a().t()) {
            return;
        }
        LiveEventBus.get("live_show_dialog").post(true);
        this.o = LiveRoomManager.a().g();
        MyPopupWindow myPopupWindow = this.e;
        if (myPopupWindow != null && myPopupWindow.isShowing()) {
            this.e.a();
        }
        if (LiveRoomManager.a().p().isShowHourRank || i != 0) {
            i2 = i;
            if (!LiveRoomManager.a().Q()) {
                i2 = i;
                if (i == 1) {
                    i2 = 0;
                }
            }
        } else {
            i2 = 1;
        }
        d();
        this.c.clearAnimation();
        this.d.clearAnimation();
        this.e.showAtLocation(this.d, 81, 0, 0);
        this.d.setVisibility(0);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in));
        if (i2 == 0) {
            this.g.setCurrentItem(0);
        } else if (i2 == 1) {
            this.g.setCurrentItem(this.u);
            b(i2);
        }
    }

    public boolean a() {
        return this.d.getVisibility() == 0;
    }

    public void b() {
        this.j = null;
    }

    public void c() {
        Dialog dialog;
        LiveEventBus.get("live_show_dialog").post(false);
        LiveRankWebDialogFragment liveRankWebDialogFragment = this.s;
        if (liveRankWebDialogFragment != null && (dialog = liveRankWebDialogFragment.getDialog()) != null && dialog.isShowing()) {
            this.s.dismiss();
        }
        this.d.setVisibility(8);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRankingListView.7
            @Override // java.lang.Runnable
            public void run() {
                PopRankingListView.this.e.a();
            }
        }, 300L);
    }
}
