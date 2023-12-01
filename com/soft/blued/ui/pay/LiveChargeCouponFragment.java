package com.soft.blued.ui.pay;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.CountModel;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.pay.LiveChargeCouponFragment;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/LiveChargeCouponFragment.class */
public class LiveChargeCouponFragment extends SimpleFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {
    private static final List<PayOption._pay_list> i = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private CommonTopTitleNoTrans f32978a;
    private RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayoutManager f32979c;
    private CommonRecycleAdapter<LiveChargeCouponModel> d;
    private NoDataAndLoadFailView e;
    private Dialog f;
    private String g = "";
    private String h = "";
    private List<String> j = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.pay.LiveChargeCouponFragment$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/LiveChargeCouponFragment$1.class */
    public class AnonymousClass1 extends CommonRecycleAdapter<LiveChargeCouponModel> {
        AnonymousClass1(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveChargeCouponModel liveChargeCouponModel, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, View view) {
            Tracker.onClick(view);
            LiveChargeCouponFragment.this.a(liveChargeCouponModel, commonAdapterHolder.getLayoutPosition());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveChargeCouponModel liveChargeCouponModel, int i, final CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (getItemViewType(i) == 1) {
                return;
            }
            ImageLoader.a(LiveChargeCouponFragment.this.getFragmentActive(), liveChargeCouponModel.image).b(2131231620).a(6.0f).a((ImageView) commonAdapterHolder.a(R.id.item_live_coupon_iv));
            commonAdapterHolder.a(R.id.item_live_coupon_money_tips_tv, "单笔充值" + liveChargeCouponModel.threshold + "元即可获得").a(R.id.item_live_coupon_bean_tips_tv, liveChargeCouponModel.name).a(R.id.item_live_coupon_use_btn, liveChargeCouponModel.status == 3 ? "已使用" : liveChargeCouponModel.status == 2 ? "支付中" : "去使用").a(R.id.item_live_coupon_use_btn, new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$LiveChargeCouponFragment$1$xMAkDl-AhVWaoxLDJgv97244AQo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveChargeCouponFragment.AnonymousClass1.this.a(liveChargeCouponModel, commonAdapterHolder, view);
                }
            });
            TextView textView = (TextView) commonAdapterHolder.a(R.id.item_live_coupon_time);
            if (liveChargeCouponModel.expire_time == -1) {
                textView.setText("有效期至：永久");
                textView.setTextColor(BluedSkinUtils.a(this.mContext, 2131102264));
            } else {
                long currentTimeMillis = (liveChargeCouponModel.expire_time * 1000) - System.currentTimeMillis();
                if (currentTimeMillis <= 0) {
                    textView.setText("有效期至：已过期");
                    textView.setTextColor(BluedSkinUtils.a(this.mContext, 2131102264));
                } else {
                    textView.setText("有效期至：" + TimeAndDateUtils.i.get().format(new Date(liveChargeCouponModel.expire_time * 1000)));
                    if (currentTimeMillis < 86400000) {
                        textView.setTextColor(Color.parseColor("#FF6533"));
                    } else {
                        textView.setTextColor(BluedSkinUtils.a(this.mContext, 2131102264));
                    }
                }
            }
            if (LiveChargeCouponFragment.this.j.contains(String.valueOf(liveChargeCouponModel.id))) {
                return;
            }
            LiveChargeCouponFragment.this.j.add(String.valueOf(liveChargeCouponModel.id));
            EventTrackLive.c(LiveProtos.Event.WANDOU_RECHARGE_COUPON_PAGE_ONE_SHOW, liveChargeCouponModel.id);
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return ((LiveChargeCouponModel) this.dataList.get(i)).itemType;
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return i == 1 ? R.layout.item_live_coupon_header : R.layout.item_live_coupon;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final LiveChargeCouponModel liveChargeCouponModel, int i2) {
        int i3;
        if (liveChargeCouponModel.status == 3 || liveChargeCouponModel.status == 2) {
            return;
        }
        EventTrackLive.c(LiveProtos.Event.WANDOU_RECHARGE_COUPON_PAGE_ONE_USE_CLICK, liveChargeCouponModel.id);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            i3 = -1;
            if (i5 >= i.size()) {
                break;
            } else if (i.get(i5).money >= liveChargeCouponModel.threshold) {
                i3 = i5;
                break;
            } else {
                i4 = i5 + 1;
            }
        }
        if (i3 < 0 || !a()) {
            return;
        }
        liveChargeCouponModel.status = 2;
        this.d.updateItemAndNotify(i2, liveChargeCouponModel);
        final String str = i.get(i3).id + "";
        final int i6 = (int) i.get(i3).money;
        liveChargeCouponModel.realPayMoney = i6;
        PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CountModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.pay.LiveChargeCouponFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CountModel> bluedEntityA) {
                BluedURIRouterAdapter.startVIPPay(AppInfo.d(), str, "", "", "", LiveChargeCouponFragment.this.g, LiveChargeCouponFragment.this.h, i6, liveChargeCouponModel);
            }
        }, liveChargeCouponModel.id, i6, getFragmentActive());
    }

    public static void a(List<PayOption._pay_list> list) {
        i.clear();
        if (list != null) {
            i.addAll(list);
        }
    }

    private void c() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(2131370694);
        this.f32978a = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setVisibility(0);
        this.f32978a.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.-$$Lambda$LiveChargeCouponFragment$Y2PN2Nf7e1THR20TaZ2x5OCqGko
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveChargeCouponFragment.this.a(view);
            }
        });
        this.f32978a.setCenterText("直播充值满赠券");
    }

    private void d() {
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(2131369096);
        this.b = recyclerView;
        recyclerView.setOverScrollMode(2);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(AppInfo.d());
        this.d = anonymousClass1;
        this.b.setAdapter(anonymousClass1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AppInfo.d());
        this.f32979c = linearLayoutManager;
        this.b.setLayoutManager(linearLayoutManager);
    }

    private void e() {
        PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveChargeCouponModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.pay.LiveChargeCouponFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveChargeCouponModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                LiveChargeCouponModel liveChargeCouponModel = new LiveChargeCouponModel();
                liveChargeCouponModel.itemType = 1;
                arrayList.add(0, liveChargeCouponModel);
                long currentTimeMillis = System.currentTimeMillis();
                for (LiveChargeCouponModel liveChargeCouponModel2 : bluedEntityA.data) {
                    if (liveChargeCouponModel2.expire_time == -1 || currentTimeMillis < liveChargeCouponModel2.expire_time * 1000) {
                        arrayList.add(liveChargeCouponModel2);
                    }
                }
                LiveChargeCouponFragment.this.d.setDataAndNotify(arrayList);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (LiveChargeCouponFragment.this.d.getDataList().size() == 0) {
                    LiveChargeCouponFragment.this.e.setVisibility(0);
                } else {
                    LiveChargeCouponFragment.this.e.setVisibility(8);
                }
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        CommonAlertDialog.a(getActivity(), "充值满赠券使用成功！", "恭喜获得神秘礼包！奖励已发到您的账户中，具体内容请到站内信中查看哦！", "知道了", (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i2, boolean z) {
        if (z) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.pay.-$$Lambda$LiveChargeCouponFragment$FM2hZoEkn2zMUjYi73jQIek_txg
                @Override // java.lang.Runnable
                public final void run() {
                    LiveChargeCouponFragment.this.f();
                }
            }, 500L);
        }
    }

    public boolean a() {
        return true;
    }

    @Override // com.blued.android.framework.ui.SimpleFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        i.clear();
        VIPBuyResultObserver.a().b(this);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        c();
        d();
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) this.rootView.findViewById(2131368721);
        this.e = noDataAndLoadFailView;
        noDataAndLoadFailView.setVisibility(8);
        this.e.setNoDataStr(R.string.no_live_charge_coupon);
        this.f = DialogUtils.a(getActivity());
        VIPBuyResultObserver.a().a(this);
        EventTrackLive.b(LiveProtos.Event.WANDOU_RECHARGE_COUPON_PAGE_SHOW);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        if (TypeUtils.a((List<?>) i)) {
            PayHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<PayOption>>(getFragmentActive()) { // from class: com.soft.blued.ui.pay.LiveChargeCouponFragment.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<PayOption> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null || bluedEntityA.getSingleData().pay_list == null) {
                        return;
                    }
                    LiveChargeCouponFragment.i.clear();
                    LiveChargeCouponFragment.i.addAll(bluedEntityA.getSingleData().pay_list);
                }
            }, (IRequestHost) getFragmentActive(), ReqAckPackage.REQ_RESPONSE_KEY.BEANS);
        }
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        this.g = this.args.getString("fromStr");
        this.h = this.args.getString("detail");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_live_charge_coupon;
    }
}
