package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.common.l;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.LiveGiftIndicatorView;
import com.blued.android.module.live.base.event.LiveBeansChangeEvent;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveGiftScrawlPaintView;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.blued.android.module.live_china.model.LiveScrawlBuyResult;
import com.blued.android.module.live_china.model.PayResultEvent;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftScrawlFragment.class */
public class LiveGiftScrawlFragment extends LiveBaseDialogFragment {
    private int C;
    private SpannableStringBuilder D;
    private LiveGiftScrawlTransModel G;
    protected LiveGiftIndicatorView j;
    private LiveGiftScrawlPaintView k;
    private RecyclerView l;
    private ScrawlGiftAdapter m;
    private PagerGridLayoutManager n;
    private TextView o;
    private TextView p;
    private TextView q;
    private View r;
    private View s;
    private View t;
    private TextView u;
    private View v;
    private View w;
    private TextView x;
    private ImageView y;
    private View z;
    private int A = 0;
    private int B = 0;
    private final int E = 10;
    private final int F = 4;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftScrawlFragment$ScrawlGiftAdapter.class */
    public class ScrawlGiftAdapter extends LiveGiftBaseAdapter {
        private int c;

        public ScrawlGiftAdapter(Context context, Fragment fragment, int i) {
            super(context, fragment, i);
            this.c = 327;
            this.c = DisplayUtil.a(context, 109.0f);
        }

        @Override // com.blued.android.module.common.adapter.BaseGiftAdapter
        public boolean a(View view, BaseGiftModel baseGiftModel, int i) {
            int i2;
            LiveGiftModel liveGiftModel = (LiveGiftModel) baseGiftModel;
            if (liveGiftModel == null) {
                return false;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i2 = -1;
                if (i4 >= this.dataList.size()) {
                    break;
                } else if (((LiveGiftModel) this.dataList.get(i4)).isSelected) {
                    ((LiveGiftModel) this.dataList.get(i4)).isSelected = false;
                    i2 = i4;
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            liveGiftModel.isSelected = true;
            if (i != i2) {
                LiveGiftScrawlFragment.this.m.notifyDataSetChanged();
                LiveGiftScrawlFragment.this.k.a(liveGiftModel);
                return false;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.live_china.mine.LiveGiftBaseAdapter
        public void b(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
            super.b(commonAdapterHolder, liveGiftModel);
            View a = commonAdapterHolder.a(R.id.item_live_gift_content_layout);
            if (a != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.getLayoutParams();
                layoutParams.height = this.c;
                layoutParams.topMargin = 0;
                a.setLayoutParams(layoutParams);
            }
        }
    }

    private void A() {
        this.n = new PagerGridLayoutManager(1, 4, 1);
        this.A = DensityUtils.a(getContext(), 2.0f);
        this.l.setLayoutManager(this.n);
        new PagerGridSnapHelper().attachToRecyclerView(this.l);
        this.l.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.live_china.mine.LiveGiftScrawlFragment.4
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = LiveGiftScrawlFragment.this.A;
                rect.right = LiveGiftScrawlFragment.this.A;
            }
        });
        this.l.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftScrawlFragment.5
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    LiveGiftScrawlFragment.this.j.b(LiveGiftScrawlFragment.this.n.d());
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        ScrawlGiftAdapter scrawlGiftAdapter = new ScrawlGiftAdapter(getActivity(), this, 0);
        this.m = scrawlGiftAdapter;
        this.l.setAdapter(scrawlGiftAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        ImageLoader.c(a(), "live_gift_scrawl_paint_guide_icon.png").e((int) SystemClock.elapsedRealtime()).g(-1).a(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        LogUtils.c("buyGiftFail: " + i + ", msg: " + str);
        switch (i) {
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.Live_SendPresent_resetPayPassword));
                bundle.putString(l.y, getString(R.string.live_set_6_num));
                bundle.putString("http_host", LiveRoomInfo.a().m());
                LiveRouteUtil.a((Fragment) this, bundle, i);
                return;
            case 4221003:
            case 4221006:
            case 4221007:
            default:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                AppMethods.a((CharSequence) str);
                return;
            case 4221004:
            case 4221005:
                Bundle bundle2 = new Bundle();
                if (i == 4221005) {
                    bundle2.putString("title", getString(R.string.Live_SendPresent_verifyPassword));
                } else {
                    bundle2.putString("title", str);
                }
                bundle2.putString(l.y, getString(R.string.Live_SendPresent_verifyPasswordText));
                LiveRouteUtil.a((Fragment) this, bundle2, i);
                return;
            case 4221008:
                o();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        v();
    }

    private void a(BasePayRemaining basePayRemaining) {
        this.o.setText(CommonStringUtils.d(String.valueOf(n())));
        if (basePayRemaining == null || basePayRemaining.bonus <= 0) {
            this.p.setVisibility(8);
            return;
        }
        this.p.setVisibility(0);
        TextView textView = this.p;
        textView.setText("(" + String.format(getResources().getString(R.string.live_contain), CommonStringUtils.d(String.valueOf(basePayRemaining.bonus))) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveScrawlBuyResult liveScrawlBuyResult) {
        if (liveScrawlBuyResult == null) {
            return;
        }
        LogUtils.c("buyGiftSuccess: " + liveScrawlBuyResult.toString());
        if (!TextUtils.isEmpty(liveScrawlBuyResult.token)) {
            LiveRoomPreferences.c(liveScrawlBuyResult.token);
        }
        LiveDataManager.a().a(liveScrawlBuyResult);
        LiveEventBus.get("live_beans_change").post(new LiveBeansChangeEvent(LiveRoomManager.a().e(), liveScrawlBuyResult.beans_current, liveScrawlBuyResult.beans_count));
        if (liveScrawlBuyResult.join_club == 1) {
            AppMethods.d(R.string.live_fans_add_success);
            if (LiveRoomManager.a().q() != null) {
                LiveRoomManager.a().q().fans_status = 1;
            }
            LiveEventBus.get("live_refresh_gift_list").post(true);
        }
        if (LiveRoomManager.a().q() != null && LiveRoomManager.a().q().fans_status == 2) {
            LiveFansObserver.a().d();
        }
        LiveMsgSendManager.a().a(q());
        LiveRoomHttpUtils.d();
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void b(PayResultEvent payResultEvent) {
        if (payResultEvent == null) {
            return;
        }
        m();
        if (this.w.getVisibility() == 0) {
            long n = n();
            int i = this.C;
            if (n >= i) {
                this.w.setVisibility(8);
                a("", false);
                return;
            }
            String valueOf = String.valueOf(i - n());
            String str = "弯豆余额不足，还需" + valueOf + "弯豆即可赠送";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5A300")), str.indexOf(valueOf), str.indexOf(valueOf) + valueOf.length(), 33);
            this.x.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(String str, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.z.setVisibility(8);
            this.k.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }

    private void b(int i) {
        LiveRoomInfo.a().a(getContext(), getFragmentManager(), 3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(BasePayRemaining basePayRemaining) {
        a(basePayRemaining);
        if (basePayRemaining != null) {
            LiveEventBus.get("live_beans_change").post(new LiveBeansChangeEvent(LiveRoomManager.a().e(), basePayRemaining.beans_current, basePayRemaining.beans_current));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i) {
        this.n.scrollToPosition(i);
        this.j.b(i / 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        this.v.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        w();
    }

    private void k() {
        LiveEventBus.get("gold_remain_result", BasePayRemaining.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$OzbkW-GQ65UiPSYe53zbdh82Hrs
            public final void onChanged(Object obj) {
                LiveGiftScrawlFragment.this.b((BasePayRemaining) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.d, PayResultEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$cCgkEavFEIoEvcCIE911K09G1rQ
            public final void onChanged(Object obj) {
                LiveGiftScrawlFragment.this.b((PayResultEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.B == 0) {
            this.r.setAlpha(0.6f);
            this.s.setAlpha(0.6f);
        } else {
            this.z.setVisibility(8);
            this.r.setAlpha(1.0f);
            this.s.setAlpha(1.0f);
        }
        this.q.setText(String.valueOf(this.B));
        SpannableStringBuilder spannableStringBuilder = this.D;
        if (spannableStringBuilder != null) {
            this.u.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            this.u.setText("礼物数量不少于10个");
        }
        p();
    }

    private void m() {
        a(LiveDataManager.a().e());
    }

    private long n() {
        return LiveDataManager.a().d() + (LiveDataManager.a().e() != null ? LiveDataManager.a().e().bonus : 0L);
    }

    private void o() {
        b(0);
    }

    private void p() {
        if (this.B < 10) {
            this.t.setAlpha(0.6f);
            this.t.setEnabled(false);
            return;
        }
        this.t.setAlpha(1.0f);
        this.t.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LiveGiftScrawlTransModel q() {
        if (this.G == null) {
            this.G = new LiveGiftScrawlTransModel();
        }
        if (this.G.goods == null) {
            this.G.goods = new ArrayList();
        }
        return this.G;
    }

    private void r() {
        if (this.B < 10) {
            ToastUtils.b("礼物数量不少于10个");
            return;
        }
        this.v.setVisibility(0);
        this.w.setVisibility(8);
    }

    private void s() {
        this.v.setVisibility(8);
    }

    private void t() {
        this.v.setVisibility(8);
        if (n() >= this.C) {
            this.w.setVisibility(8);
            a("", false);
            return;
        }
        this.w.setVisibility(0);
        String valueOf = String.valueOf(this.C - n());
        String str = "弯豆余额不足，还需" + valueOf + "弯豆即可赠送";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F5A300")), str.indexOf(valueOf), str.indexOf(valueOf) + valueOf.length(), 33);
        this.x.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    private void u() {
        this.w.setVisibility(8);
    }

    private void v() {
        int n = this.C - ((int) n());
        int i = n;
        if (n <= 0) {
            i = 0;
        }
        b(i);
    }

    private void w() {
        this.k.a();
    }

    private void x() {
        this.k.b();
        this.z.setVisibility(0);
    }

    private void y() {
        if (TypeUtils.a((List<?>) q().goods)) {
            return;
        }
        for (LiveGiftScrawlModel liveGiftScrawlModel : q().goods) {
            EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_SEND_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), LiveRoomManager.a().p().liveFrom, LiveRoomManager.a().p().recommendType, LiveRoomManager.a().p().livePosition, liveGiftScrawlModel.goods_id, liveGiftScrawlModel.getPath().size(), (int) (liveGiftScrawlModel.beans * liveGiftScrawlModel.getPath().size()), liveGiftScrawlModel.packageTypeName, liveGiftScrawlModel.pageIndex + 1, liveGiftScrawlModel.positionInPage + 1, this.c.getBoolean("isHit"), this.c.getBoolean("isPking"), this.c.getBoolean("isMakeLover") ? LiveProtos.LiveType.BLIND_DATING_LIVE : LiveProtos.LiveType.SHOW_LIVE, "gift_bar", true, liveGiftScrawlModel.isMp4, false, 0L, this.c.getString("defined_rank_name", ""), "", false);
        }
        if (this.e != null && !this.e.isShowing()) {
            this.e.show();
        }
        LiveRoomHttpUtils.a(q(), new BluedUIHttpResponse<BluedEntityA<LiveScrawlBuyResult>>(a()) { // from class: com.blued.android.module.live_china.mine.LiveGiftScrawlFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveScrawlBuyResult> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    LiveGiftScrawlFragment.this.a(0, (String) null);
                    return;
                }
                LiveGiftScrawlFragment.this.a(bluedEntityA.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveGiftScrawlFragment.this.a(i, str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                if (LiveGiftScrawlFragment.this.e != null && LiveGiftScrawlFragment.this.e.isShowing()) {
                    LiveGiftScrawlFragment.this.e.dismiss();
                }
                return super.onUIFailure(i, str, str2);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        final ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= LiveRoomManager.a().L().size()) {
                a(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$9cBeRnoevP_OE0utKlX7dz7ueUs
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveGiftScrawlFragment.this.b(arrayList);
                    }
                });
                return;
            }
            LiveGiftModel liveGiftModel = LiveRoomManager.a().L().get(i2);
            if (liveGiftModel.isScrawlGift()) {
                LiveGiftModel liveGiftModel2 = new LiveGiftModel();
                ReflectionUtils.a(liveGiftModel, liveGiftModel2);
                arrayList.add(liveGiftModel2);
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public void b(List<LiveGiftModel> list) {
        String string = this.c.getString("selected_index");
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (StringUtils.a(list.get(i2).index, string)) {
                list.get(i2).isSelected = true;
                this.k.a(list.get(i2));
                i = i2;
                z = true;
            } else {
                list.get(i2).isSelected = false;
            }
        }
        int i3 = i;
        if (!z) {
            i3 = i;
            if (list.size() > 0) {
                list.get(0).isSelected = true;
                this.k.a(list.get(0));
                i3 = 0;
            }
        }
        this.m.setDataAndNotify(list);
        int size = list.size() / 4;
        int i4 = size;
        if (list.size() % 4 > 0) {
            i4 = size + 1;
        }
        this.j.a(i4);
        this.j.setIndicatorCount(i4);
        if (i4 < 1) {
            this.j.setVisibility(4);
        } else {
            this.j.setVisibility(0);
        }
        final int i5 = i3;
        a(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$igwWgfYuDUQ-YQcoejkvHRfoxio
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftScrawlFragment.this.c(i5);
            }
        }, 50L);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_gift_scrawl;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.k = (LiveGiftScrawlPaintView) this.b.findViewById(R.id.live_gift_scrawl_paint_view);
        this.l = this.b.findViewById(R.id.live_gift_scrawl_rv);
        A();
        this.j = (LiveGiftIndicatorView) this.b.findViewById(R.id.live_gift_scrawl_indicator_view);
        this.o = (TextView) this.b.findViewById(R.id.live_gift_scrawl_price_view);
        this.p = (TextView) this.b.findViewById(R.id.live_gift_scrawl_give_bean_tv);
        this.b.findViewById(R.id.live_gift_scrawl_charge).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$v48LPCGr1YtlalE1Mewjm4rWko0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.k(view);
            }
        });
        View findViewById = this.b.findViewById(R.id.live_gift_scrawl_undo);
        this.r = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$Ky31J9czVCs7se-OcfDHW9Q4KH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.j(view);
            }
        });
        View findViewById2 = this.b.findViewById(R.id.live_gift_scrawl_clear);
        this.s = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$syiWgbNe_e9GUBUXq22wFXs7Mds
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.i(view);
            }
        });
        this.b.findViewById(R.id.live_gift_scrawl_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$W6m0Fx-c8A9zrxFYAcHQOQS4nC8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.h(view);
            }
        });
        View findViewById3 = this.b.findViewById(R.id.live_gift_scrawl_confirm);
        this.t = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$C9YN5xxmTn3l6o84PKuJb0Qkv30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.g(view);
            }
        });
        this.u = (TextView) this.b.findViewById(R.id.live_gift_scrawl_tips_tv);
        this.q = (TextView) this.b.findViewById(R.id.live_gift_scrawl_num);
        View findViewById4 = this.b.findViewById(R.id.live_gift_scrawl_notice_parent_layout);
        this.v = findViewById4;
        findViewById4.setVisibility(8);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$u94uB8uC15RBfmBJEznYUC2oa-w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.f(view);
            }
        });
        this.b.findViewById(R.id.live_gift_scrawl_notice_layout).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$NZxr22m4W2XcOkfnfNYdbGRywvs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.e(view);
            }
        });
        this.b.findViewById(R.id.live_gift_scrawl_notice_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$8ODeL7jo78qhWArvW0o7B9lHdn4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.d(view);
            }
        });
        this.b.findViewById(R.id.live_gift_scrawl_notice_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$LNF0kL4zhI2I-ossEDbUx4N4x9w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.c(view);
            }
        });
        this.w = this.b.findViewById(R.id.live_gift_scrawl_need_charge_layout);
        this.x = (TextView) this.b.findViewById(R.id.live_gift_scrawl_need_charge_tv);
        this.w.setVisibility(8);
        this.b.findViewById(R.id.live_gift_scrawl_need_charge_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$p7hQD6vGunlQgu57sVVbwygsrMc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.b(view);
            }
        });
        this.b.findViewById(R.id.live_gift_scrawl_need_charge_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$Z7-l_Q2qfKOwGyT2UQJlO1EjbeQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftScrawlFragment.this.a(view);
            }
        });
        this.k.setScrawlPaintListener(new LiveGiftScrawlPaintView.ScrawlPaintListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftScrawlFragment.1
            @Override // com.blued.android.module.live_china.mine.LiveGiftScrawlPaintView.ScrawlPaintListener
            public void a(int i, SpannableStringBuilder spannableStringBuilder, int i2) {
                LiveGiftScrawlFragment.this.B = i;
                LiveGiftScrawlFragment.this.D = spannableStringBuilder;
                LiveGiftScrawlFragment.this.C = i2;
                LiveGiftScrawlFragment.this.l();
            }

            @Override // com.blued.android.module.live_china.mine.LiveGiftScrawlPaintView.ScrawlPaintListener
            public void a(List<LiveGiftScrawlModel> list) {
                LiveGiftScrawlFragment.this.q().goods.clear();
                if (list != null) {
                    LiveGiftScrawlFragment.this.q().goods.addAll(list);
                }
            }
        });
        this.y = (ImageView) this.b.findViewById(R.id.live_gift_scrawl_guide_iv);
        View findViewById5 = this.b.findViewById(R.id.live_gift_scrawl_guide_layout);
        this.z = findViewById5;
        findViewById5.setVisibility(0);
        this.z.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$NmhKkAlSIgW_iuJ4EwsEJ-vyBAQ
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a;
                a = LiveGiftScrawlFragment.this.a(view, motionEvent);
                return a;
            }
        });
        k();
        m();
        l();
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004 || i == 4221002) && intent != null) {
                String stringExtra = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                a(stringExtra, booleanExtra);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        dismissAllowingStateLoss();
        return true;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(new Runnable() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlFragment$CVS8tFVVT59z8v35wkYxyb6iYTg
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftScrawlFragment.this.B();
            }
        }, 100L);
        ThreadManager.a().a(new ThreadExecutor("GiftScrawlData") { // from class: com.blued.android.module.live_china.mine.LiveGiftScrawlFragment.2
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                LiveGiftScrawlFragment.this.z();
            }
        });
    }
}
