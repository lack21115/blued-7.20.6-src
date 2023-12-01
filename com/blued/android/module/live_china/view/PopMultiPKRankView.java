package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LiveRankingListExtra;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMultiPKRankView.class */
public class PopMultiPKRankView {

    /* renamed from: a  reason: collision with root package name */
    private View f15093a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f15094c;
    private MyPopupWindow d;
    private View e;
    private View f;
    private RankingAdapter g;
    private int h;
    private int i;
    private String j;
    private String k;
    private boolean l;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMultiPKRankView$MyPopupWindow.class */
    class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopMultiPKRankView.this.a();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMultiPKRankView$RankingAdapter.class */
    public class RankingAdapter extends BaseQuickAdapter<LiveRankingListExtra, BaseViewHolder> {
        public RankingAdapter() {
            super(R.layout.pop_window_ranking_list_item, null);
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
                if (PopMultiPKRankView.this.i == 1) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(PopMultiPKRankView.this.l ? R.drawable.live_rank_up_one : R.drawable.live_rank_pk_mvp);
                    textView.setVisibility(8);
                } else if (PopMultiPKRankView.this.i == 0) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.drawable.live_rank_up_one);
                    textView.setVisibility(8);
                } else if (PopMultiPKRankView.this.i == 2) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.drawable.live_rank_up_one);
                    textView.setVisibility(8);
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
            textView3.setText(PopMultiPKRankView.this.a(liveRankingListExtra.score) + this.mContext.getString(R.string.live_pk_consumes));
            textView4.setVisibility(8);
            if (LiveCloakingUtil.b(liveRankingListExtra.privilege)) {
                baseViewHolder.itemView.setClickable(false);
            } else {
                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopMultiPKRankView.RankingAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        PopMultiPKRankView.this.a();
                        LiveSetDataObserver.a().e(liveRankingListExtra.uid);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_window_multi_pk, (ViewGroup) null);
        this.f15093a = inflate;
        View findViewById = inflate.findViewById(R.id.bg_view);
        this.b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopMultiPKRankView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopMultiPKRankView.this.a();
            }
        });
        View findViewById2 = this.f15093a.findViewById(R.id.ll_content);
        this.f15094c = findViewById2;
        findViewById2.setVisibility(8);
        this.f15094c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopMultiPKRankView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        ((TextView) this.f15093a.findViewById(R.id.tv_title)).setText(this.k);
        View findViewById3 = this.f15093a.findViewById(R.id.iv_help);
        this.e = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopMultiPKRankView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (PopMultiPKRankView.this.l) {
                    EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_RULE_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                } else {
                    EventTrackLive.a(LiveProtos.Event.LIVE_PK_CONTRIBUTION_PAGE_RULE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
                }
                LiveSetDataObserver.a().b(LiveRoomInfo.a().A(), 25);
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.f15093a.findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(AppInfo.d(), 1, false));
        RankingAdapter rankingAdapter = new RankingAdapter();
        this.g = rankingAdapter;
        recyclerView.setAdapter(rankingAdapter);
        this.f = this.f15093a.findViewById(R.id.ll_loading);
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.f15093a, -1, -1, true);
        this.d = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(AppInfo.d().getResources().getDrawable(17170445));
        this.d.setTouchable(true);
        this.d.setOutsideTouchable(true);
        this.d.setFocusable(true);
        this.d.update();
    }

    private void a(IRequestHost iRequestHost) {
        LiveRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntity<LiveRankingListExtra, LiveRankingListExtra>>(iRequestHost) { // from class: com.blued.android.module.live_china.view.PopMultiPKRankView.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                PopMultiPKRankView.this.b();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopMultiPKRankView.this.f.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopMultiPKRankView.this.f.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRankingListExtra, LiveRankingListExtra> bluedEntity) {
                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) PopMultiPKRankView.this.f15093a.findViewById(R.id.ll_anchor_rank_layout);
                TextView textView = (TextView) PopMultiPKRankView.this.f15093a.findViewById(R.id.tv_rank_index);
                ImageView imageView = (ImageView) PopMultiPKRankView.this.f15093a.findViewById(R.id.iv_rank_index);
                ImageView imageView2 = (ImageView) PopMultiPKRankView.this.f15093a.findViewById(R.id.avatar);
                TextView textView2 = (TextView) PopMultiPKRankView.this.f15093a.findViewById(R.id.tv_name);
                TextView textView3 = (TextView) PopMultiPKRankView.this.f15093a.findViewById(R.id.tv_rank);
                RecyclerView recyclerView = (RecyclerView) PopMultiPKRankView.this.f15093a.findViewById(R.id.recycler_list);
                View findViewById = PopMultiPKRankView.this.f15093a.findViewById(R.id.fl_pk_list_empty);
                PopMultiPKRankView.this.f15093a.findViewById(R.id.live_pay).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopMultiPKRankView.4.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        PopMultiPKRankView.this.a();
                        LiveRefreshUIObserver.a().j();
                    }
                });
                if (!bluedEntity.hasData()) {
                    shapeLinearLayout.setVisibility(8);
                    findViewById.setVisibility(0);
                    recyclerView.setVisibility(8);
                    PopMultiPKRankView.this.b();
                    return;
                }
                shapeLinearLayout.setVisibility(0);
                findViewById.setVisibility(8);
                recyclerView.setVisibility(0);
                textView.setText(bluedEntity.extra.index > 10 ? "10+" : String.valueOf(bluedEntity.extra.index));
                if (bluedEntity.extra.index == 1) {
                    if (PopMultiPKRankView.this.i == 1) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(PopMultiPKRankView.this.l ? R.drawable.live_rank_up_one : R.drawable.live_rank_pk_mvp);
                        textView.setVisibility(8);
                    } else if (PopMultiPKRankView.this.i == 0) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_one);
                        textView.setVisibility(8);
                    } else if (PopMultiPKRankView.this.i == 2) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.live_rank_up_one);
                        textView.setVisibility(8);
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
                textView3.setText(PopMultiPKRankView.this.a(bluedEntity.extra.score) + AppInfo.d().getString(R.string.live_pk_consumes));
                if (PopMultiPKRankView.this.h == 0) {
                    shapeLinearLayout.setVisibility(0);
                } else {
                    shapeLinearLayout.setVisibility(8);
                }
                PopMultiPKRankView.this.g.setNewData(bluedEntity.data);
                recyclerView.setAdapter(PopMultiPKRankView.this.g);
            }
        }, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        View view = this.f15093a;
        if (view != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_anchor_rank_layout);
            RecyclerView recyclerView = (RecyclerView) this.f15093a.findViewById(R.id.recycler_list);
            View findViewById = this.f15093a.findViewById(R.id.fl_pk_list_empty);
            View findViewById2 = this.f15093a.findViewById(R.id.live_pay);
            if (this.h == 0) {
                findViewById2.setVisibility(0);
            } else {
                findViewById2.setVisibility(8);
            }
            if (this.g.getData() == null || this.g.getData().size() <= 0) {
                shapeLinearLayout.setVisibility(8);
                findViewById.setVisibility(0);
                recyclerView.setVisibility(8);
            }
        }
    }

    public void a() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_SHOW_DIALOG).post(false);
        this.f15094c.setVisibility(8);
        this.f15094c.startAnimation(AnimationUtils.loadAnimation(AppInfo.d(), R.anim.push_bottom_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopMultiPKRankView.5
            @Override // java.lang.Runnable
            public void run() {
                PopMultiPKRankView.this.d.a();
            }
        }, 300L);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(Context context, LivePkBannerModel livePkBannerModel, IRequestHost iRequestHost) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
