package com.soft.blued.ui.user.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.statistics.BluedStatistics;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.pay.alipay.AlipayUtils;
import com.soft.blued.ui.pay.alipay.Result;
import com.soft.blued.ui.pay.model.PayOrderInfo;
import com.soft.blued.ui.user.fragment.VIPBuyFragment;
import com.soft.blued.ui.user.model.GiftPayRemaining;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.ExperimentConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.activity.BDActivityManager;
import com.soft.blued.view.dialog.CommonAlertDialog2;
import com.soft.blued.view.dialog.DialogWith6PW;
import com.soft.blued.wxapi.WXPayEntryActivity;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/PayUtils.class */
public class PayUtils {

    /* renamed from: a  reason: collision with root package name */
    public Context f20568a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public IRequestHost f20569c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public LiveChargeCouponModel i;
    public DialogWith6PW j;
    GiftPayRemaining k;
    private IWXAPI l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.presenter.PayUtils$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/PayUtils$1.class */
    public class AnonymousClass1 extends BluedUIHttpResponse<BluedEntityA<PayRemaining>> {
        AnonymousClass1(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
            try {
                PayOrderInfo.AlipayOrder alipayOrder = (PayOrderInfo.AlipayOrder) AppInfo.f().fromJson(AesCrypto.c(((PayRemaining) bluedEntityA.data.get(0)).encrypted), (Class<Object>) PayOrderInfo.AlipayOrder.class);
                String str = null;
                if (!TextUtils.isEmpty(alipayOrder.info)) {
                    str = null;
                    if (alipayOrder.info.contains("out_trade_no=")) {
                        String substring = alipayOrder.info.substring(alipayOrder.info.indexOf("out_trade_no=") + 13 + 1);
                        str = substring.substring(0, substring.indexOf("\""));
                    }
                }
                final String str2 = str;
                AlipayUtils.a(PayUtils.this.f20568a, new Handler() { // from class: com.soft.blued.ui.user.presenter.PayUtils.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        try {
                            final Result result = new Result((String) message.obj);
                            if (message.what != 1) {
                                return;
                            }
                            String a2 = result.a();
                            if (a2.equals("9000")) {
                                new Timer().schedule(new TimerTask() { // from class: com.soft.blued.ui.user.presenter.PayUtils.1.1.1
                                    @Override // java.util.TimerTask, java.lang.Runnable
                                    public void run() {
                                        WXPayEntryActivity.a(PayUtils.this.f20568a, result.toString());
                                    }
                                }, 200L);
                                if (PayUtils.this.i != null) {
                                    PayHttpUtils.a(str2, PayUtils.this.i.id, PayUtils.this.i.realPayMoney);
                                }
                            } else if (a2.equals("6001")) {
                                BluedStatistics.c().a("ALI_PAY_CANCEL", 0L, 0, (String) message.obj);
                                VIPBuyResultObserver.a().a(0, false);
                                AppMethods.a("支付取消");
                            } else {
                                BluedStatistics.c().a("ALI_PAY_FAIL", 0L, 0, (String) message.obj);
                                VIPBuyResultObserver.a().a(0, false);
                                AppMethods.a(PayUtils.this.f20568a.getResources().getString(R.string.Live_setting_rechargeFail));
                            }
                        } catch (Exception e) {
                            VIPBuyResultObserver.a().a(0, false);
                            AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                        }
                    }
                }, alipayOrder.sign_type, alipayOrder.info, alipayOrder.sign);
                if (PayUtils.this.i != null) {
                    PayUtils.this.i.tradeNo = str;
                }
            } catch (Exception e) {
                VIPBuyResultObserver.a().a(0, false);
                AppMethods.a(AppInfo.d().getResources().getString(2131887272));
            }
        }

        public boolean onUIFailure(int i, String str) {
            VIPBuyResultObserver.a().a(0, false);
            switch (i) {
                case 4433003:
                    ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_today_buy_max_hint));
                    return true;
                case 4433004:
                    ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_buy_max_hint));
                    return true;
                case 4433005:
                    ToastUtils.a(AppInfo.d().getString(R.string.msg_stop_selling));
                    return true;
                default:
                    return super.onUIFailure(i, str);
            }
        }

        public void onUIFinish() {
            super.onUIFinish();
        }

        public void onUIStart() {
            super.onUIStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.presenter.PayUtils$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/PayUtils$3.class */
    public class AnonymousClass3 extends BluedUIHttpResponse<BluedEntityA<GiftPayRemaining>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GoodsOptionBasic f20574a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20575c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(IRequestHost iRequestHost, GoodsOptionBasic goodsOptionBasic, String str, Context context) {
            super(iRequestHost);
            this.f20574a = goodsOptionBasic;
            this.b = str;
            this.f20575c = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<GiftPayRemaining> bluedEntityA) {
            if (PayUtils.this.j != null) {
                PayUtils.this.j.f21177a.dismiss();
            }
            if (bluedEntityA.hasData()) {
                PayUtils.this.k = (GiftPayRemaining) bluedEntityA.data.get(0);
                if (!TextUtils.isEmpty(PayUtils.this.k.token)) {
                    BluedPreferences.H(PayUtils.this.k.token);
                }
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.presenter.PayUtils.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PayUtils.this.k.lucky_list == null || PayUtils.this.k.lucky_list.size() <= 0) {
                            return;
                        }
                        FuGiftListEvent fuGiftListEvent = new FuGiftListEvent();
                        fuGiftListEvent.f18634a = PayUtils.this.k.lucky_list;
                        LiveEventBus.get(EventBusConstant.KEY_EVENT_BUY_FU, FuGiftListEvent.class).post(fuGiftListEvent);
                    }
                }, 500L);
            }
        }

        public boolean onUIFailure(int i, String str, String str2) {
            LiveGiftPayTools.a(str2);
            final Pair a2 = BluedHttpUtils.a((Throwable) null, i, str2);
            if (((Integer) a2.first).intValue() == 0) {
                return super.onUIFailure(i, str, str2);
            }
            if (i == 4221002) {
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.user.presenter.PayUtils.3.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveGiftPayTools.a(PayUtils.this.f20568a, PayUtils.this.f20569c);
                    }
                });
                return true;
            } else if (i == 4221008) {
                if (PayUtils.this.j != null && PayUtils.this.j.f21177a != null && PayUtils.this.j.f21177a.isShowing()) {
                    PayUtils.this.j.f21177a.dismiss();
                }
                CommonAlertDialog.a(PayUtils.this.f20568a, "", PayUtils.this.f20568a.getResources().getString(R.string.Live_SendPresent_notEnoughWandou), PayUtils.this.f20568a.getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.presenter.PayUtils.3.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Tracker.onClick(dialogInterface, i2);
                        dialogInterface.dismiss();
                        BeansPrePayFragment.a(PayUtils.this.f20568a, 6);
                    }
                }, PayUtils.this.f20568a.getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return true;
            } else {
                switch (i) {
                    case 4221004:
                        if (TextUtils.isEmpty((CharSequence) a2.second)) {
                            return true;
                        }
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.user.presenter.PayUtils.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PayUtils.this.j == null || PayUtils.this.j.f21178c == null || PayUtils.this.j.b == null) {
                                    return;
                                }
                                PayUtils.this.j.f21178c.setTextColor(PayUtils.this.f20568a.getResources().getColor(2131099765));
                                PayUtils.this.j.f21178c.setText((CharSequence) a2.second);
                                PayUtils.this.j.b.a();
                            }
                        });
                        return true;
                    case 4221005:
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.user.presenter.PayUtils.3.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PayUtils.this.j == null || PayUtils.this.j.f21177a == null || !PayUtils.this.j.f21177a.isShowing()) {
                                    String string = PayUtils.this.f20568a.getResources().getString(R.string.Live_SendPresent_verifyPassword);
                                    String string2 = PayUtils.this.f20568a.getResources().getString(R.string.Live_SendPresent_verifyPasswordText);
                                    PayUtils.this.j = CommonAlertDialog2.a(PayUtils.this.f20568a, string, string2, true, false, true, true, new CommonAlertDialog2.PWDListener() { // from class: com.soft.blued.ui.user.presenter.PayUtils.3.5.1
                                        @Override // com.soft.blued.view.dialog.CommonAlertDialog2.PWDListener
                                        public void onClick(String str3, boolean z, DialogWith6PW dialogWith6PW) {
                                            String str4;
                                            if (TextUtils.isEmpty(str3)) {
                                                return;
                                            }
                                            try {
                                                str4 = BluedHttpTools.b(str3);
                                            } catch (NoSuchAlgorithmException e) {
                                                e.printStackTrace();
                                                str4 = "";
                                            }
                                            PayUtils.this.a(PayUtils.this.f20568a, AnonymousClass3.this.f20574a, str4, z, "", AnonymousClass3.this.b);
                                        }
                                    }, null);
                                }
                            }
                        });
                        return true;
                    default:
                        switch (i) {
                            case 4433003:
                                ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_today_buy_max_hint));
                                return true;
                            case 4433004:
                                ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_buy_max_hint));
                                return true;
                            case 4433005:
                                ToastUtils.a(AppInfo.d().getString(R.string.msg_stop_selling));
                                return true;
                            case 4433006:
                                ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_send_failed));
                                return true;
                            case 4433007:
                                ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_send_expired));
                                return true;
                            default:
                                return true;
                        }
                }
            }
        }

        public void onUIFinish(boolean z) {
            super.onUIFinish(z);
            VIPBuyResultObserver.a().a(3, z);
            if (z && TextUtils.equals(this.f20574a.trade_type, "beans")) {
                Context context = this.f20575c;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                    PayUtils.a(this.f20575c, this.b, PayUtils.this.k == null ? "" : PayUtils.this.k.order_id, this.f20574a.id);
                }
            }
        }
    }

    public PayUtils(Context context, String str, IRequestHost iRequestHost) {
        this.f20568a = context;
        this.b = str;
        this.f20569c = iRequestHost;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, ShareCoreConstants.a(), false);
        this.l = createWXAPI;
        createWXAPI.registerApp(ShareCoreConstants.a());
    }

    public static void a(Context context, int i, String str) {
        a(context, i, str, VipProtos.FromType.UNKNOWN_FROM);
    }

    public static void a(Context context, int i, String str, int i2, VipProtos.FromType fromType) {
        a(context, i, str, i2, fromType, true);
    }

    public static void a(Context context, int i, String str, int i2, VipProtos.FromType fromType, boolean z) {
        if (i <= 0) {
            i = 1;
            if (i2 >= 0) {
                int i3 = ExperimentConfig.a().b().switch_buy_vip_path;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            if (i2 != 4 && i2 != 6 && i2 != 11 && i2 != 13 && i2 != 22 && i2 != 36 && i2 != 26 && i2 != 27) {
                                i = 1;
                            }
                        } else if (i2 == 21) {
                            i = 1;
                        }
                    }
                    i = 2;
                } else {
                    if (i2 != 4 && i2 != 6 && i2 != 24 && i2 != 33 && i2 != 36 && i2 != 21 && i2 != 22 && i2 != 26 && i2 != 27 && i2 != 10001 && i2 != 10002) {
                        switch (i2) {
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                i = 1;
                                break;
                        }
                    }
                    i = 2;
                }
            }
        }
        VIPBuyFragment.a(context, i, str, i2, fromType, false, z, false, 0);
    }

    public static void a(Context context, int i, String str, VipProtos.FromType fromType) {
        a(context, 0, str, i, fromType);
    }

    public static void a(Context context, String str, int i, VipProtos.FromType fromType) {
        a(context, 0, str, i, fromType);
    }

    public static void a(Context context, final String str, final String str2) {
        if (BDActivityManager.f21128a.a() != null) {
            context = BDActivityManager.f21128a.a();
        }
        BluedAlertDialog a2 = CommonAlertDialog.a(context, context.getString(R.string.feed_super_bug_title), context.getString(R.string.feed_super_bug_msg), context.getString(R.string.feed_super_bug_sure), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.presenter.PayUtils.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                WebViewShowInfoFragment.show(BDActivityManager.f21128a.a(), H5Url.a(55, new Object[]{str, str2}), 0);
            }
        }, (DialogInterface.OnDismissListener) null, 1);
        a2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.user.presenter.PayUtils.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        a2.c().setGravity(1);
    }

    public static void a(final Context context, final String str, final String str2, final int i) {
        if (context instanceof FragmentActivity) {
            final Lifecycle lifecycle = ((FragmentActivity) context).getLifecycle();
            lifecycle.addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.user.presenter.PayUtils.4
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy() {
                    lifecycle.removeObserver(this);
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
                public void onStop() {
                    Log.v("drb", "onStop");
                    Activity activity = Context.this;
                    if (BDActivityManager.f21128a.a() != null) {
                        activity = BDActivityManager.f21128a.a();
                    }
                    String string = activity.getString(R.string.feed_super_bug_msg);
                    if (PayUtils.a(i)) {
                        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_SUPER_EXPOSURE).post(true);
                        string = activity.getString(R.string.super_exposure_fire_bag_buy_success_content);
                    }
                    BluedAlertDialog a2 = CommonAlertDialog.a(activity, activity.getString(R.string.feed_super_bug_title), string, activity.getString(R.string.feed_super_bug_sure), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.presenter.PayUtils.4.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            if (PayUtils.a(i)) {
                                return;
                            }
                            WebViewShowInfoFragment.show(BDActivityManager.f21128a.a(), H5Url.a(55, new Object[]{str, str2}), 0);
                        }
                    }, (DialogInterface.OnDismissListener) null, 1);
                    a2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.user.presenter.PayUtils.4.2
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    a2.c().setGravity(1);
                }
            });
        }
    }

    public static boolean a(int i) {
        return i == 400001 || i == 400002;
    }

    public BluedUIHttpResponse a() {
        return new AnonymousClass1(this.f20569c);
    }

    public void a(int i, GoodsOptionBasic goodsOptionBasic, int i2) {
        if (goodsOptionBasic != null) {
            if (i != 1) {
                if (i == 2) {
                    if (c()) {
                        PayHttpUtils.a(b(), this.f20569c, 2, goodsOptionBasic.id, this.b, this.e, this.d, this.f, this.g, this.h);
                        return;
                    }
                    return;
                } else if (i != 4) {
                    return;
                }
            }
            PayHttpUtils.a(a(), this.f20569c, i, goodsOptionBasic.id, this.b, this.e, this.d, this.f, this.g, this.h);
        }
    }

    public void a(Context context, GoodsOptionBasic goodsOptionBasic, String str, boolean z, String str2, String str3) {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.f20569c, goodsOptionBasic, str3, context);
        String str4 = this.d;
        UserHttpUtils.a(anonymousClass3, str4, goodsOptionBasic.id + "", goodsOptionBasic.feed_id, this.g, null, this.f20569c, str, str2, z, goodsOptionBasic.trade_type, goodsOptionBasic.beans, goodsOptionBasic.aim, goodsOptionBasic.promotion_type, goodsOptionBasic.role, goodsOptionBasic.age, goodsOptionBasic.area);
    }

    public void a(String str, String str2, String str3, String str4, int i, LiveChargeCouponModel liveChargeCouponModel) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = i;
        this.i = liveChargeCouponModel;
    }

    public BluedUIHttpResponse b() {
        return new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this.f20569c) { // from class: com.soft.blued.ui.user.presenter.PayUtils.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
                try {
                    String c2 = AesCrypto.c(((PayRemaining) bluedEntityA.data.get(0)).encrypted);
                    Gson f = AppInfo.f();
                    PayOrderInfo.WXpayOrder wXpayOrder = (PayOrderInfo.WXpayOrder) f.fromJson(c2, (Class<Object>) PayOrderInfo.WXpayOrder.class);
                    PayReq payReq = new PayReq();
                    payReq.appId = wXpayOrder.appid;
                    payReq.partnerId = wXpayOrder.partnerid;
                    payReq.prepayId = wXpayOrder.prepayid;
                    payReq.nonceStr = wXpayOrder.noncestr;
                    payReq.timeStamp = wXpayOrder.timestamp;
                    payReq.packageValue = wXpayOrder.packageValue;
                    payReq.sign = wXpayOrder.sign;
                    if (PayUtils.this.i != null) {
                        PayUtils.this.i.tradeNo = wXpayOrder.out_trade_no;
                        PayUtils.this.i.prepayId = wXpayOrder.prepayid;
                        try {
                            payReq.extData = f.toJson(PayUtils.this.i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    PayUtils.this.l.sendReq(payReq);
                } catch (Exception e2) {
                    VIPBuyResultObserver.a().a(0, false);
                    AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                }
            }

            public boolean onUIFailure(int i, String str) {
                VIPBuyResultObserver.a().a(0, false);
                switch (i) {
                    case 4433003:
                        ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_today_buy_max_hint));
                        return true;
                    case 4433004:
                        ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_buy_max_hint));
                        return true;
                    case 4433005:
                        ToastUtils.a(AppInfo.d().getString(R.string.msg_stop_selling));
                        return true;
                    default:
                        return super.onUIFailure(i, str);
                }
            }
        };
    }

    public boolean c() {
        boolean z = this.l.getWXAppSupportAPI() >= 570425345;
        if (!z) {
            AppMethods.a(this.f20568a.getResources().getString(R.string.Live_setting_noWechat));
        }
        return z;
    }
}
