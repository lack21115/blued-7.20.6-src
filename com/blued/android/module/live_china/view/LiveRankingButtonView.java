package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RankingExtra;
import com.blued.android.module.live_china.model.RankingHourExtra;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveRankingButtonView;
import com.blued.android.module.live_china.view.MarqueeTextView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRankingButtonView.class */
public class LiveRankingButtonView extends LinearLayout implements View.OnClickListener {
    int a;
    boolean b;
    int c;
    private Context d;
    private LayoutInflater e;
    private View f;
    private ShapeFrameLayout g;
    private View h;
    private TextView i;
    private ImageView j;
    private View k;
    private TextView l;
    private MarqueeTextView m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private RankingHourExtra r;
    private ImageView s;
    private LiveHourExpanView t;
    private Runnable u;
    private Runnable v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LiveRankingButtonView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRankingButtonView$1.class */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (LiveRankingButtonView.this.o || LiveRankingButtonView.this.p <= 1 || LiveRankingButtonView.this.q < 0) {
                return;
            }
            LiveRankingButtonView.this.l.setVisibility(0);
            LiveRankingButtonView.this.m.setVisibility(8);
            LiveRankingButtonView.this.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i) {
            if (i < 1 || LiveRankingButtonView.this.o) {
                return;
            }
            LiveRankingButtonView.this.m.b();
            if (LiveRankingButtonView.this.p <= 1 || LiveRankingButtonView.this.q < 0) {
                return;
            }
            LiveRankingButtonView.this.l.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveRankingButtonView$1$lNS_smb5ZUBI-Gf7KU4Yqhkt3G8
                @Override // java.lang.Runnable
                public final void run() {
                    LiveRankingButtonView.AnonymousClass1.this.a();
                }
            }, 1000L);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveRankingButtonView.this.o || LiveRankingButtonView.this.p <= 1 || LiveRankingButtonView.this.q < 0) {
                return;
            }
            try {
                LiveRankingButtonView.this.l.setVisibility(8);
                LiveRankingButtonView.this.m.setVisibility(0);
                LiveRankingButtonView.this.m.setListener(new MarqueeTextView.callbackListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveRankingButtonView$1$1z7DhbbpGUr51ZA-IraR5zhPXiU
                    @Override // com.blued.android.module.live_china.view.MarqueeTextView.callbackListener
                    public final void onFinish(int i) {
                        LiveRankingButtonView.AnonymousClass1.this.a(i);
                    }
                });
                MarqueeTextView marqueeTextView = LiveRankingButtonView.this.m;
                marqueeTextView.setText("距上一名还差" + LiveRankingButtonView.this.q + "闪耀值");
                LiveRankingButtonView.this.m.a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public LiveRankingButtonView(Context context) {
        super(context);
        this.o = false;
        this.p = -1;
        this.u = new AnonymousClass1();
        this.a = 0;
        this.b = false;
        this.c = 0;
        this.v = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveRankingButtonView.2
            @Override // java.lang.Runnable
            public void run() {
                LiveRankingButtonView.this.i.setText(LiveTimeAndDateUtils.a(LiveRankingButtonView.this.c, false));
                LiveRankingButtonView.this.c--;
                if (LiveRankingButtonView.this.c > 0) {
                    AppInfo.n().postDelayed(LiveRankingButtonView.this.v, 1000L);
                    return;
                }
                if (LiveRankingButtonView.this.t.getVisibility() == 0) {
                    LiveRankingButtonView.this.t.a(LiveRankingButtonView.this.g, false, true);
                }
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveRankingButtonView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveRankingButtonView.this.t.setVisibility(8);
                        LiveRankingButtonView.this.k.setVisibility(0);
                        LiveRankingButtonView.this.g.setVisibility(8);
                    }
                }, 500L);
            }
        };
        this.d = context;
        b();
    }

    public LiveRankingButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = false;
        this.p = -1;
        this.u = new AnonymousClass1();
        this.a = 0;
        this.b = false;
        this.c = 0;
        this.v = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveRankingButtonView.2
            @Override // java.lang.Runnable
            public void run() {
                LiveRankingButtonView.this.i.setText(LiveTimeAndDateUtils.a(LiveRankingButtonView.this.c, false));
                LiveRankingButtonView.this.c--;
                if (LiveRankingButtonView.this.c > 0) {
                    AppInfo.n().postDelayed(LiveRankingButtonView.this.v, 1000L);
                    return;
                }
                if (LiveRankingButtonView.this.t.getVisibility() == 0) {
                    LiveRankingButtonView.this.t.a(LiveRankingButtonView.this.g, false, true);
                }
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LiveRankingButtonView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveRankingButtonView.this.t.setVisibility(8);
                        LiveRankingButtonView.this.k.setVisibility(0);
                        LiveRankingButtonView.this.g.setVisibility(8);
                    }
                }, 500L);
            }
        };
        this.d = context;
        b();
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.d);
        this.e = from;
        View inflate = from.inflate(R.layout.layout_live_ranking_button, (ViewGroup) this, true);
        this.k = inflate.findViewById(R.id.ll_hour);
        this.l = (TextView) inflate.findViewById(R.id.tv_hour);
        this.m = (MarqueeTextView) inflate.findViewById(R.id.tv_hour_tips);
        this.f = inflate.findViewById(R.id.root_hour);
        this.g = (ShapeFrameLayout) inflate.findViewById(R.id.fl_hour);
        this.h = inflate.findViewById(R.id.iv_hour_bg_top);
        this.i = (TextView) inflate.findViewById(R.id.tv_hour_time);
        this.j = (ImageView) inflate.findViewById(R.id.iv_hour_down);
        this.s = (ImageView) inflate.findViewById(R.id.iv_hour_anim);
        this.t = (LiveHourExpanView) inflate.findViewById(R.id.hour_expan_view);
        this.k.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.f.setVisibility(LiveRoomManager.a().p().isShowHourRank ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.o) {
            return;
        }
        this.k.removeCallbacks(this.u);
        this.k.postDelayed(this.u, 2000L);
    }

    public void a() {
    }

    public void a(int i, int i2) {
        if (i == -1) {
            this.l.setText("小时榜");
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.m.setText("");
            this.m.b();
            this.p = -1;
            this.q = 0;
            return;
        }
        this.p = i;
        this.q = i2;
        this.l.setText(i > 0 ? String.format(getContext().getString(R.string.live_pk_rank_num), Integer.valueOf(this.p)) : "未上榜");
        if (this.p <= 1 || this.q < 0) {
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.m.setText("");
            this.m.b();
        } else if (TextUtils.isEmpty(this.m.getText().toString())) {
            this.m.setScrollSpeed(1.0f);
            this.m.setWaitTime(200L);
            MarqueeTextView marqueeTextView = this.m;
            marqueeTextView.setText("距上一名还差" + this.q + "闪耀值");
            this.m.b();
            c();
        }
    }

    public void a(boolean z) {
        int i = 8;
        if (!z) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        if (this.g.getVisibility() == 0) {
            this.k.setVisibility(8);
            return;
        }
        View view = this.k;
        if (z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        boolean z = false;
        if (view.getId() == R.id.ll_hour || view.getId() == R.id.fl_hour) {
            EventTrackLive.a(LiveProtos.Event.LIVE_HOUR_LIST_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            LiveEventBus.get("live_ranking_dialog").post(0);
        } else if (view.getId() == R.id.iv_hour_down) {
            LiveHourExpanView liveHourExpanView = this.t;
            ShapeFrameLayout shapeFrameLayout = this.g;
            if (liveHourExpanView.getVisibility() == 8) {
                z = true;
            }
            liveHourExpanView.a(shapeFrameLayout, z, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.removeCallbacks(this.u);
    }

    public void setHourCountView(RankingHourExtra rankingHourExtra) {
        if (rankingHourExtra == null) {
            return;
        }
        this.r = rankingHourExtra;
        this.t.a(rankingHourExtra);
        if (rankingHourExtra.type != 1 || this.r.second <= 0) {
            return;
        }
        this.g.setVisibility(0);
        this.k.setVisibility(8);
        this.h.setVisibility(rankingHourExtra.rank_type == 1 ? 0 : 8);
        AppInfo.n().removeCallbacks(this.v);
        this.c = this.r.second;
        AppInfo.n().post(this.v);
        if (rankingHourExtra.rank < 20) {
            this.t.a(this.g, true, false);
        }
        if (rankingHourExtra.rank_type == 1) {
            this.s.setVisibility(0);
            ImageLoader.c(null, "live_hour_anim.png").g().g(-1).a(this.s);
        } else {
            this.s.setVisibility(8);
        }
        ShapeModel shapeModel = this.g.getShapeModel();
        shapeModel.k = ContextCompat.getColor(this.d, rankingHourExtra.rank_type == 1 ? R.color.syc_dark_afb218ff : R.color.syc_dark_B39F77FF);
        this.g.setShapeModel(shapeModel);
    }

    public void setIsSimpleModel(boolean z) {
        this.n = z;
    }

    public void setValue(RankingExtra rankingExtra) {
    }
}
