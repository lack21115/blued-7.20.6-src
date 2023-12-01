package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LiveRankingListExtra;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.pop.LivePKConsumePop;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPKListView.class */
public class PopPKListView {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f15104a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f15105c;
    private View d;
    private MyPopupWindow e;
    private View f;
    private ShapeFrameLayout g;
    private ShapeFrameLayout h;
    private TextView i;
    private TextView j;
    private CustomViewPager k;
    private PkPagerAdapter l;
    private BaseFragment m;
    private View n;
    private String p;
    private RankingAdapter q;
    private RankingAdapter r;
    private int t;
    private String u;
    private int v;
    private String w;
    private String x;
    private final int o = 2;
    private Map<String, View> s = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPKListView$MyPopupWindow.class */
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
                PopPKListView.this.b();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPKListView$PK_TYPE.class */
    public interface PK_TYPE {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPKListView$PkPagerAdapter.class */
    public class PkPagerAdapter extends PagerAdapter {
        PkPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = (View) PopPKListView.this.s.get(String.valueOf(i));
            while (view == null) {
                view = LayoutInflater.from(PopPKListView.this.b).inflate(R.layout.pop_window_pk_list, viewGroup, false);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_list);
                recyclerView.setLayoutManager(new LinearLayoutManager(PopPKListView.this.b, 1, false));
                if (i == 0) {
                    PopPKListView popPKListView = PopPKListView.this;
                    popPKListView.q = new RankingAdapter(0);
                    recyclerView.setAdapter(PopPKListView.this.q);
                } else if (i == 1) {
                    PopPKListView popPKListView2 = PopPKListView.this;
                    popPKListView2.r = new RankingAdapter(1);
                    recyclerView.setAdapter(PopPKListView.this.r);
                }
                PopPKListView.this.s.put(String.valueOf(i), view);
            }
            View view2 = (View) PopPKListView.this.s.get(String.valueOf(i));
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            viewGroup.addView(view2);
            return view2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopPKListView$RankingAdapter.class */
    public class RankingAdapter extends BaseQuickAdapter<LiveRankingListExtra, BaseViewHolder> {
        private int b;

        public RankingAdapter(int i) {
            super(R.layout.pop_window_ranking_list_item, null);
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final LiveRankingListExtra liveRankingListExtra) {
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_rank_index);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_rank_index);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.avatar);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_name);
            TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_rank);
            TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_pk);
            textView.setText(liveRankingListExtra.index + "");
            if (liveRankingListExtra.index == 1) {
                int i = this.b;
                if (i == 0) {
                    if (PopPKListView.this.v == 1) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_pk_mvp);
                        textView.setVisibility(8);
                    } else if (PopPKListView.this.v == 0) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_one);
                        textView.setVisibility(8);
                    } else if (PopPKListView.this.v == 2) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_one);
                        textView.setVisibility(8);
                    }
                } else if (i == 1) {
                    if (PopPKListView.this.v == 1) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_one);
                        textView.setVisibility(8);
                    } else if (PopPKListView.this.v == 0) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_one);
                        textView.setVisibility(8);
                    } else if (PopPKListView.this.v == 2) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_pk_mvp);
                        textView.setVisibility(8);
                    }
                }
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
            ImageLoader.a((IRequestHost) null, liveRankingListExtra.avatar).b(R.drawable.channel_default_head).c().a(imageView2);
            textView2.setText(LiveCloakingUtil.a(liveRankingListExtra.nickname, liveRankingListExtra.privilege));
            textView3.setText(PopPKListView.this.a(liveRankingListExtra.score) + this.mContext.getString(R.string.live_pk_consumes));
            textView4.setVisibility(8);
            if (LiveCloakingUtil.b(liveRankingListExtra.privilege)) {
                baseViewHolder.itemView.setClickable(false);
            } else {
                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.RankingAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (RankingAdapter.this.b == 0) {
                            PopPKListView.this.b();
                            LiveSetDataObserver.a().e(liveRankingListExtra.uid);
                        }
                    }
                });
            }
        }
    }

    public PopPKListView(BaseFragment baseFragment) {
        this.m = baseFragment;
        this.b = baseFragment.getContext();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        String str;
        if (i == 0) {
            if (LiveRoomManager.a().p() != null) {
                str = String.valueOf(LiveRoomManager.a().p().lid);
            }
            str = "";
        } else {
            if (i == 1) {
                str = this.u;
            }
            str = "";
        }
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntity<LiveRankingListExtra, LiveRankingListExtra>>(this.m.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopPKListView.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2) {
                PopPKListView.this.b(i);
                return super.onUIFailure(i2, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopPKListView.this.n.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopPKListView.this.n.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRankingListExtra, LiveRankingListExtra> bluedEntity) {
                if (bluedEntity.extra != null) {
                    PopPKListView.this.w = bluedEntity.extra.notice_text;
                    PopPKListView.this.x = bluedEntity.extra.notice_title;
                }
                View view = (View) PopPKListView.this.s.get(String.valueOf(i));
                if (view == null) {
                    return;
                }
                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_anchor_rank_layout);
                TextView textView = (TextView) view.findViewById(R.id.tv_rank_index);
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_rank_index);
                ImageView imageView2 = (ImageView) view.findViewById(R.id.avatar);
                TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                TextView textView3 = (TextView) view.findViewById(R.id.tv_rank);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_list);
                View findViewById = view.findViewById(R.id.fl_pk_list_empty);
                view.findViewById(R.id.live_pay).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        PopPKListView.this.b();
                        LiveRefreshUIObserver.a().j();
                    }
                });
                if (!bluedEntity.hasData()) {
                    shapeLinearLayout.setVisibility(8);
                    findViewById.setVisibility(0);
                    recyclerView.setVisibility(8);
                    PopPKListView.this.b(i);
                    return;
                }
                shapeLinearLayout.setVisibility(0);
                findViewById.setVisibility(8);
                recyclerView.setVisibility(0);
                textView.setText(bluedEntity.extra.index > 10 ? "10+" : String.valueOf(bluedEntity.extra.index));
                if (bluedEntity.extra.index == 1) {
                    int i2 = i;
                    if (i2 == 0) {
                        if (PopPKListView.this.v == 1) {
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.drawable.live_rank_pk_mvp);
                            textView.setVisibility(8);
                        } else if (PopPKListView.this.v == 0) {
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.drawable.live_rank_up_one);
                            textView.setVisibility(8);
                        } else if (PopPKListView.this.v == 2) {
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.drawable.live_rank_up_one);
                            textView.setVisibility(8);
                        }
                    } else if (i2 == 1) {
                        if (PopPKListView.this.v == 1) {
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.drawable.live_rank_up_one);
                            textView.setVisibility(8);
                        } else if (PopPKListView.this.v == 0) {
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.drawable.live_rank_up_one);
                            textView.setVisibility(8);
                        } else if (PopPKListView.this.v == 2) {
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.drawable.live_rank_pk_mvp);
                            textView.setVisibility(8);
                        }
                    }
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
                    textView.setVisibility(bluedEntity.extra.index <= 0 ? 8 : 0);
                }
                textView2.setText(LiveCloakingUtil.a(bluedEntity.extra.nickname, bluedEntity.extra.privilege));
                ImageLoader.a((IRequestHost) null, bluedEntity.extra.avatar).b(R.drawable.channel_default_head).c().a(imageView2);
                textView3.setText(PopPKListView.this.a(bluedEntity.extra.score) + PopPKListView.this.b.getString(R.string.live_pk_consumes));
                if (PopPKListView.this.m instanceof PlayingOnliveFragment) {
                    shapeLinearLayout.setVisibility(0);
                } else if (PopPKListView.this.m instanceof RecordingOnliveFragment) {
                    shapeLinearLayout.setVisibility(8);
                }
                int i3 = i;
                if (i3 == 0) {
                    PopPKListView.this.q.setNewData(bluedEntity.data);
                    recyclerView.setAdapter(PopPKListView.this.q);
                } else if (i3 == 1) {
                    PopPKListView.this.r.setNewData(bluedEntity.data);
                    recyclerView.setAdapter(PopPKListView.this.r);
                }
            }
        }, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        View view = this.s.get(String.valueOf(i));
        if (view != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_anchor_rank_layout);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_list);
            View findViewById = view.findViewById(R.id.fl_pk_list_empty);
            View findViewById2 = view.findViewById(R.id.live_pay);
            if (this.t == 0) {
                findViewById2.setVisibility(0);
            } else {
                findViewById2.setVisibility(8);
            }
            if (i == 0) {
                if (this.q.getData() == null || this.q.getData().size() <= 0) {
                    shapeLinearLayout.setVisibility(8);
                    findViewById.setVisibility(0);
                    recyclerView.setVisibility(8);
                }
            } else if (i == 1) {
                if (this.r.getData() == null || this.r.getData().size() <= 0) {
                    shapeLinearLayout.setVisibility(8);
                    findViewById.setVisibility(0);
                    recyclerView.setVisibility(8);
                }
            }
        }
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f15104a = from;
        View inflate = from.inflate(R.layout.pop_window_pk, (ViewGroup) null);
        this.f15105c = inflate.findViewById(R.id.bg_view);
        this.s.clear();
        this.f15105c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopPKListView.this.b();
            }
        });
        View findViewById = inflate.findViewById(R.id.ll_content);
        this.d = findViewById;
        findViewById.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.iv_help);
        this.f = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TextUtils.isEmpty(PopPKListView.this.w)) {
                    return;
                }
                LivePKConsumePop.a(PopPKListView.this.m, PopPKListView.this.w, PopPKListView.this.x);
            }
        });
        this.g = (ShapeFrameLayout) inflate.findViewById(R.id.fl_owner);
        this.h = (ShapeFrameLayout) inflate.findViewById(R.id.fl_other);
        this.i = (TextView) inflate.findViewById(R.id.tv_owner);
        this.j = (TextView) inflate.findViewById(R.id.tv_other);
        this.n = inflate.findViewById(R.id.ll_loading);
        this.k = (CustomViewPager) inflate.findViewById(R.id.live_pk_viewpager);
        PkPagerAdapter pkPagerAdapter = new PkPagerAdapter();
        this.l = pkPagerAdapter;
        this.k.setAdapter(pkPagerAdapter);
        this.k.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.4
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 0) {
                    ShapeModel shapeModel = new ShapeModel();
                    shapeModel.H = DensityUtils.a(PopPKListView.this.b, 30.0f);
                    shapeModel.k = ContextCompat.getColor(PopPKListView.this.b, R.color.syc_dark_b);
                    PopPKListView.this.i.setTextColor(ContextCompat.getColor(PopPKListView.this.b, R.color.syc_dark_0a0a0a));
                    PopPKListView.this.g.setShapeModel(shapeModel);
                    PopPKListView.this.h.setShapeModel(new ShapeModel());
                    PopPKListView.this.j.setTextColor(ContextCompat.getColor(PopPKListView.this.b, R.color.syc_dark_767676));
                    PopPKListView.this.a(0);
                } else if (i == 1) {
                    ShapeModel shapeModel2 = new ShapeModel();
                    PopPKListView.this.i.setTextColor(ContextCompat.getColor(PopPKListView.this.b, R.color.syc_dark_767676));
                    PopPKListView.this.g.setShapeModel(shapeModel2);
                    ShapeModel shapeModel3 = new ShapeModel();
                    shapeModel3.H = DensityUtils.a(PopPKListView.this.b, 30.0f);
                    shapeModel3.k = ContextCompat.getColor(PopPKListView.this.b, R.color.syc_dark_b);
                    PopPKListView.this.j.setTextColor(ContextCompat.getColor(PopPKListView.this.b, R.color.syc_dark_0a0a0a));
                    PopPKListView.this.h.setShapeModel(shapeModel3);
                    PopPKListView.this.a(1);
                }
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_RANK_CLICK, LiveProtos.Status.DAILY);
                PopPKListView.this.k.setCurrentItem(0);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopPKListView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_RANK_CLICK, LiveProtos.Status.WEEKLY);
                PopPKListView.this.k.setCurrentItem(1);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
        this.e.setTouchable(true);
        this.e.setOutsideTouchable(true);
        this.e.setFocusable(true);
        this.e.update();
    }

    public void a(LivePkBannerModel livePkBannerModel) {
        if (LiveRoomManager.a().t() || livePkBannerModel == null) {
            return;
        }
        this.t = livePkBannerModel.from;
        this.u = livePkBannerModel.lid;
        this.v = livePkBannerModel.pk_state;
        this.p = LiveRoomManager.a().g();
        MyPopupWindow myPopupWindow = this.e;
        if (myPopupWindow != null && myPopupWindow.isShowing()) {
            this.e.a();
        }
        c();
        this.f15105c.clearAnimation();
        this.d.clearAnimation();
        this.e.showAtLocation(this.d, 81, 0, 0);
        this.d.setVisibility(0);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in));
        if (livePkBannerModel.type == 0) {
            this.k.setCurrentItem(0);
            a(0);
        } else if (livePkBannerModel.type == 1) {
            this.k.setCurrentItem(1);
            a(1);
        }
    }

    public boolean a() {
        return this.d.getVisibility() == 0;
    }

    public void b() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_SHOW_DIALOG).post(false);
        this.d.setVisibility(8);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopPKListView.8
            @Override // java.lang.Runnable
            public void run() {
                PopPKListView.this.e.a();
            }
        }, 300L);
    }
}
