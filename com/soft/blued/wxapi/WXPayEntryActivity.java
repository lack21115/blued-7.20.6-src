package com.soft.blued.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.mobevent.MobEventUtils;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.pay.model.VIPPayResult;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.wxapi.WXPayEntryActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/wxapi/WXPayEntryActivity.class */
public class WXPayEntryActivity extends BaseFragmentActivity implements IWXAPIEventHandler {

    /* renamed from: c  reason: collision with root package name */
    private String f34878c = "";
    private String d = "";
    private IWXAPI e;
    private ProgressBar f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.wxapi.WXPayEntryActivity$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/wxapi/WXPayEntryActivity$1.class */
    public class AnonymousClass1 extends BluedUIHttpResponse<BluedEntityA<VIPPayResult>> {
        AnonymousClass1(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(VIPPayResult vIPPayResult) {
            if (vIPPayResult.lucky_list == null || vIPPayResult.lucky_list.size() <= 0) {
                return;
            }
            FuGiftListEvent fuGiftListEvent = new FuGiftListEvent();
            fuGiftListEvent.f32324a = vIPPayResult.lucky_list;
            LiveEventBus.get(EventBusConstant.KEY_EVENT_BUY_FU, FuGiftListEvent.class).post(fuGiftListEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(VIPPayResult vIPPayResult, boolean z) {
            WXPayEntryActivity.this.finish();
            VIPBuyResultObserver.a().a(vIPPayResult.ops, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<VIPPayResult> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                        final VIPPayResult vIPPayResult = (VIPPayResult) AppInfo.f().fromJson(AesCrypto.c(bluedEntityA.data.get(0).encrypted), (Class<Object>) VIPPayResult.class);
                        boolean z = true;
                        if (vIPPayResult.status != 1) {
                            WXPayEntryActivity.this.finish();
                            VIPBuyResultObserver.a().a(0, false);
                            AppMethods.a((CharSequence) WXPayEntryActivity.this.getResources().getString(2131886224));
                            return;
                        }
                        MobEventUtils.a();
                        if ((vIPPayResult.activity_id == 3 || vIPPayResult.activity_id == 4) && vIPPayResult.user_info != null && vIPPayResult.extra != null) {
                            AppMethods.a((CharSequence) WXPayEntryActivity.this.getResources().getString(R.string.pay_gift_success_hint));
                            ChatHelperV4.a().a(WXPayEntryActivity.this, vIPPayResult.user_info, 1, vIPPayResult.extra.info_1, vIPPayResult.extra.info_2, vIPPayResult.extra.product_vip_grade, 0, "");
                        }
                        BluedConfig.a().c();
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.wxapi.-$$Lambda$WXPayEntryActivity$1$RUgmAAl9TVjEU2F13fOHyx-O00Q
                            @Override // java.lang.Runnable
                            public final void run() {
                                WXPayEntryActivity.AnonymousClass1.a(VIPPayResult.this);
                            }
                        }, 1000L);
                        if (vIPPayResult.is_dialog != 1) {
                            VIPBuyResultObserver.a().a(vIPPayResult.ops, true);
                            WXPayEntryActivity.this.finish();
                            AppMethods.a((CharSequence) WXPayEntryActivity.this.getResources().getString(2131886226));
                            return;
                        }
                        int i = vIPPayResult.ops;
                        if (i == 2 || i == 3) {
                            PopMenuUtils.a(WXPayEntryActivity.this, new PopMenuFromCenter.DismissListner() { // from class: com.soft.blued.wxapi.-$$Lambda$WXPayEntryActivity$1$aHoKi3Y1kRJA_ysv8Cyb-U5OaVQ
                                @Override // com.soft.blued.customview.PopMenuFromCenter.DismissListner
                                public final void dissmiss(boolean z2) {
                                    WXPayEntryActivity.AnonymousClass1.this.a(vIPPayResult, z2);
                                }
                            });
                            return;
                        } else if (i != 4) {
                            VIPBuyResultObserver.a().a(vIPPayResult.ops, true);
                            WXPayEntryActivity.this.finish();
                            AppMethods.a((CharSequence) WXPayEntryActivity.this.getResources().getString(2131886226));
                            return;
                        } else {
                            VIPBuyResultObserver.a().a(vIPPayResult.ops, true);
                            WXPayEntryActivity.this.finish();
                            Observable<Object> observable = LiveEventBus.get(EventBusConstant.KEY_EVENT_CALL_BUY_OPEN);
                            if (vIPPayResult.is_secret_dialog != 1) {
                                z = false;
                            }
                            observable.post(Boolean.valueOf(z));
                            return;
                        }
                    }
                } catch (Exception e) {
                    WXPayEntryActivity.this.finish();
                    VIPBuyResultObserver.a().a(0, false);
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                    return;
                }
            }
            WXPayEntryActivity.this.finish();
            VIPBuyResultObserver.a().a(0, false);
            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            Logger.e("WXPay", "onUIFailure====" + str);
            VIPBuyResultObserver.a().a(0, false);
            WXPayEntryActivity.this.finish();
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            if (CommonTools.a((Activity) WXPayEntryActivity.this)) {
                WXPayEntryActivity.this.f.setVisibility(8);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            WXPayEntryActivity.this.f.setVisibility(0);
            super.onUIStart();
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, WXPayEntryActivity.class);
        intent.putExtra("RESULT", str);
        intent.putExtra("from", "alipay");
        context.startActivity(intent);
    }

    public void a(String str, String str2) {
        PayHttpUtils.b(new AnonymousClass1(new ActivityFragmentActive(getLifecycle())), new ActivityFragmentActive(getLifecycle()), str, str2);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.fragment_pay_result);
        this.f = (ProgressBar) findViewById(R.id.pb_progress);
        Intent intent = getIntent();
        if (intent != null) {
            this.f34878c = intent.getStringExtra("RESULT");
            this.d = intent.getStringExtra("from");
        }
        if (!"alipay".equals(this.d)) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, ShareCoreConstants.a());
            this.e = createWXAPI;
            createWXAPI.handleIntent(getIntent(), this);
        } else if (!TextUtils.isEmpty(this.f34878c)) {
            a(this.d, this.f34878c);
        } else {
            VIPBuyResultObserver.a().a(0, false);
            AppMethods.a((CharSequence) getResources().getString(2131886213));
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        getWindow().setFlags(2048, 2048);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.e.handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == 5) {
            PayResp payResp = (PayResp) baseResp;
            int i = baseResp.errCode;
            if (i == -2) {
                VIPBuyResultObserver.a().a(0, false);
                AppMethods.a((CharSequence) getResources().getString(2131886212));
                finish();
            } else if (i != 0) {
                VIPBuyResultObserver.a().a(0, false);
                AppMethods.a((CharSequence) getResources().getString(2131886213));
                finish();
            } else {
                a(UserAccountsModel.ACCOUNT_THREE_WEIXIN, payResp.prepayId);
                if (TextUtils.isEmpty(payResp.extData)) {
                    return;
                }
                LiveChargeCouponModel liveChargeCouponModel = null;
                try {
                    liveChargeCouponModel = (LiveChargeCouponModel) AppInfo.f().fromJson(payResp.extData, (Class<Object>) LiveChargeCouponModel.class);
                } catch (Exception e) {
                }
                if (liveChargeCouponModel == null || payResp.prepayId == null || !payResp.prepayId.equalsIgnoreCase(liveChargeCouponModel.prepayId)) {
                    return;
                }
                PayHttpUtils.a(liveChargeCouponModel.tradeNo, liveChargeCouponModel.id, liveChargeCouponModel.realPayMoney);
            }
        }
    }
}
