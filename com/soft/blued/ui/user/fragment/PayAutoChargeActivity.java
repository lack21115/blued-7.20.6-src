package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.alipay.sdk.app.OpenAuthTask;
import com.alipay.sdk.app.PayTask;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.model.PayRemaining;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.config.c;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.mobevent.MobEventUtils;
import com.soft.blued.ui.pay.model.VIPPayResult;
import com.soft.blued.ui.user.fragment.PayAutoChargeActivity;
import com.soft.blued.ui.user.model.AliPayResult;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.model.VIPAutoChargeOrderForJsonParse;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PayAutoChargeActivity.class */
public class PayAutoChargeActivity extends BaseFragmentActivity {

    /* renamed from: c  reason: collision with root package name */
    public Context f20189c;
    private GoodsOptionBasic d;
    private ProgressBar e;
    private IWXAPI f;
    private String g;
    private String h;
    private String i;
    private String k;
    private Dialog l;
    private int o;
    private boolean j = false;
    private int m = -1;
    private int n = 0;
    private boolean p = false;
    private boolean q = false;
    private int r = 0;
    private boolean s = false;
    private String t = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.fragment.PayAutoChargeActivity$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PayAutoChargeActivity$2.class */
    public class AnonymousClass2 extends BluedUIHttpResponse<BluedEntityA<PayRemaining>> {

        /* renamed from: a  reason: collision with root package name */
        boolean f20192a;

        AnonymousClass2(IRequestHost iRequestHost) {
            super(iRequestHost);
            this.f20192a = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(DialogInterface dialogInterface) {
            PayAutoChargeActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            PayAutoChargeActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            PayAutoChargeActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            PayAutoChargeActivity.this.a(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<PayRemaining> bluedEntityA) {
            try {
                boolean z = false;
                VIPAutoChargeOrderForJsonParse vIPAutoChargeOrderForJsonParse = (VIPAutoChargeOrderForJsonParse) AppInfo.f().fromJson(AesCrypto.c(((PayRemaining) bluedEntityA.data.get(0)).encrypted), (Class<Object>) VIPAutoChargeOrderForJsonParse.class);
                PayAutoChargeActivity payAutoChargeActivity = PayAutoChargeActivity.this;
                if (vIPAutoChargeOrderForJsonParse.alipay_type == 1) {
                    z = true;
                }
                payAutoChargeActivity.s = z;
                int i = PayAutoChargeActivity.this.o;
                if (i != 1) {
                    if (i == 2) {
                        if (PayAutoChargeActivity.this.f()) {
                            PayAutoChargeActivity.this.a(vIPAutoChargeOrderForJsonParse);
                            return;
                        } else {
                            PayAutoChargeActivity.this.finish();
                            return;
                        }
                    } else if (i != 4) {
                        return;
                    }
                }
                if (vIPAutoChargeOrderForJsonParse.alipay_type == 1) {
                    PayAutoChargeActivity.this.b(vIPAutoChargeOrderForJsonParse);
                } else {
                    PayAutoChargeActivity.this.c(vIPAutoChargeOrderForJsonParse);
                }
            } catch (Exception e) {
                AppMethods.a(AppInfo.d().getResources().getString(2131887272));
                PayAutoChargeActivity.this.finish();
            }
        }

        public boolean onUIFailure(int i, String str) {
            if (i == 4032020) {
                this.f20192a = false;
                CommonAlertDialog.a(PayAutoChargeActivity.this.f20189c, "", str, PayAutoChargeActivity.this.f20189c.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PayAutoChargeActivity$2$GE_5M5TUOkh4WMIJqkdAq5nmdJI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        PayAutoChargeActivity.AnonymousClass2.this.c(dialogInterface, i2);
                    }
                }, PayAutoChargeActivity.this.f20189c.getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PayAutoChargeActivity$2$GptYYC7rMHNtAAz2Oq2NEYAT19E
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        PayAutoChargeActivity.AnonymousClass2.this.b(dialogInterface, i2);
                    }
                }, (DialogInterface.OnDismissListener) null).setCancelable(false);
                return true;
            } else if (i == 4032021) {
                CommonAlertDialog.a(PayAutoChargeActivity.this.f20189c, "", str, PayAutoChargeActivity.this.f20189c.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PayAutoChargeActivity$2$aFlqhQBFRnwqxe3e58lJw_Ql5-o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        PayAutoChargeActivity.AnonymousClass2.this.a(dialogInterface, i2);
                    }
                }, (DialogInterface.OnDismissListener) null, 0).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PayAutoChargeActivity$2$pG4y-EhFmSgwoOeEEJynDsktyqA
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        PayAutoChargeActivity.AnonymousClass2.this.a(dialogInterface);
                    }
                });
                this.f20192a = false;
                return true;
            } else {
                return super.onUIFailure(i, str);
            }
        }

        public void onUIFinish(boolean z) {
            super.onUIFinish();
            PayAutoChargeActivity.this.e.setVisibility(4);
            if (z || !this.f20192a) {
                return;
            }
            PayAutoChargeActivity.this.finish();
        }

        public void onUIStart() {
            super.onUIStart();
            PayAutoChargeActivity.this.e.setVisibility(0);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PayAutoChargeActivity$RESULTCODE.class */
    public interface RESULTCODE {
    }

    public static void a(Context context, GoodsOptionBasic goodsOptionBasic, String str, String str2, String str3, int i, int i2, String str4) {
        Intent intent = new Intent(context, PayAutoChargeActivity.class);
        intent.putExtra("KEY_ITEM_BUY_OPTION", goodsOptionBasic);
        intent.putExtra("KEY_TARGET_UID", str);
        intent.putExtra("KEY_ACTIVITY_ID", str2);
        intent.putExtra("KEY_VIP_DETAIL", str3);
        intent.putExtra("KEY_PAY_PLAT_FORM", i);
        intent.putExtra("KEY_PAY_ENTRUST", i2);
        intent.putExtra("KEY_PAY_PRODUCT_ID", str4);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VIPAutoChargeOrderForJsonParse vIPAutoChargeOrderForJsonParse) {
        OpenWebview.Req req = new OpenWebview.Req();
        req.url = vIPAutoChargeOrderForJsonParse.entrust_url;
        this.k = vIPAutoChargeOrderForJsonParse.contract_code;
        this.f.sendReq(req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final VIPAutoChargeOrderForJsonParse vIPAutoChargeOrderForJsonParse) {
        this.q = true;
        OpenAuthTask openAuthTask = new OpenAuthTask((Activity) this.f20189c);
        HashMap hashMap = new HashMap();
        hashMap.put("sign_params", vIPAutoChargeOrderForJsonParse.entrust_url);
        openAuthTask.execute("bluedalipay", OpenAuthTask.BizType.Deduct, hashMap, new OpenAuthTask.Callback() { // from class: com.soft.blued.ui.user.fragment.PayAutoChargeActivity.3
            public void onResult(int i, String str, Bundle bundle) {
                if (i != 9000) {
                    VIPBuyResultObserver.a().a(0, false);
                    AppMethods.a(PayAutoChargeActivity.this.f20189c.getResources().getString(R.string.Live_setting_rechargeFail));
                    PayAutoChargeActivity.this.finish();
                    return;
                }
                PayAutoChargeActivity.this.k = vIPAutoChargeOrderForJsonParse.contract_code;
                if (PayAutoChargeActivity.this.p) {
                    return;
                }
                PayAutoChargeActivity.this.g();
                PayAutoChargeActivity.this.p = true;
            }
        }, i());
        this.q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final VIPAutoChargeOrderForJsonParse vIPAutoChargeOrderForJsonParse) {
        this.q = true;
        try {
            new Thread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PayAutoChargeActivity$AzyQwGfrNU9vy7YPYy7AVQKIunU
                @Override // java.lang.Runnable
                public final void run() {
                    PayAutoChargeActivity.this.d(vIPAutoChargeOrderForJsonParse);
                }
            }).start();
        } catch (Exception e) {
            this.q = false;
            VIPBuyResultObserver.a().a(0, false);
            AppMethods.a(AppInfo.d().getResources().getString(2131887272));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(VIPAutoChargeOrderForJsonParse vIPAutoChargeOrderForJsonParse) {
        Map payV2 = new PayTask((Activity) this.f20189c).payV2(vIPAutoChargeOrderForJsonParse.entrust_url, true);
        Log.i("msp", payV2.toString());
        if (TextUtils.equals(new AliPayResult(payV2).getResultStatus(), "9000")) {
            this.k = vIPAutoChargeOrderForJsonParse.contract_code;
            if (!this.p) {
                g();
                this.p = true;
            }
        } else {
            VIPBuyResultObserver.a().a(0, false);
            AppMethods.a(this.f20189c.getResources().getString(R.string.Live_setting_rechargeFail));
            finish();
        }
        this.q = false;
    }

    private boolean i() {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(this.f20189c.getPackageManager()) != null;
    }

    public void a(int i, boolean z) {
        DialogUtils.b(this.l);
        Log.v("drb", "endQuery ops:" + i);
        VIPBuyResultObserver.a().a(i, z);
        finish();
    }

    public void a(boolean z) {
        if (this.d == null) {
            return;
        }
        UserHttpUtils.a(new AnonymousClass2(a()), TextUtils.isEmpty(this.t) ? this.d.c_id : Integer.parseInt(this.t), PayHttpUtils.a(this.o), 0.0d, this.d.vip_grade, 0, this.g, this.h, this.i, z, this.r, a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean f() {
        boolean z = this.f.getWXAppSupportAPI() >= 570425345;
        if (!z) {
            Toast.makeText((Context) this, (CharSequence) getResources().getString(R.string.Live_setting_noWechat), 0).show();
            Logger.e("PayAutoChargeActivity", "checkWXPayEnviroment=======");
        }
        return z;
    }

    public void g() {
        DialogUtils.a(this.l);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.PayAutoChargeActivity.1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.soft.blued.ui.user.fragment.PayAutoChargeActivity$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PayAutoChargeActivity$1$1.class */
            public class C06771 extends BluedUIHttpResponse<BluedEntityA<VIPPayResult>> {
                C06771(IRequestHost iRequestHost) {
                    super(iRequestHost);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void a(boolean z) {
                    PayAutoChargeActivity.this.a(2, true);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<VIPPayResult> bluedEntityA) {
                    try {
                        String c2 = AesCrypto.c(((VIPPayResult) bluedEntityA.data.get(0)).encrypted);
                        AppInfo.m();
                        VIPPayResult vIPPayResult = (VIPPayResult) AppInfo.f().fromJson(c2, (Class<Object>) VIPPayResult.class);
                        Log.v("drb", "result:" + vIPPayResult.toString());
                        PayAutoChargeActivity.this.m = vIPPayResult.status;
                        PayAutoChargeActivity.this.n = vIPPayResult.is_dialog;
                        if (vIPPayResult.status != 3) {
                            if (!PayAutoChargeActivity.this.s) {
                                AppMethods.d(2131887272);
                                PayAutoChargeActivity.this.a(2, false);
                                return;
                            }
                            VIPBuyResultObserver.a().a(0, false);
                            AppMethods.a(PayAutoChargeActivity.this.f20189c.getResources().getString(R.string.Live_setting_rechargeFail));
                            PayAutoChargeActivity.this.finish();
                            return;
                        }
                        MobEventUtils.a();
                        BluedConfig.a().d();
                        DialogUtils.b(PayAutoChargeActivity.this.l);
                        if (PayAutoChargeActivity.this.n == 1) {
                            PopMenuUtils.a(PayAutoChargeActivity.this.f20189c, new PopMenuFromCenter.DismissListner() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PayAutoChargeActivity$1$1$jqF5FP7JowNsGqpRXXzpufcpdWk
                                @Override // com.soft.blued.customview.PopMenuFromCenter.DismissListner
                                public final void dissmiss(boolean z) {
                                    PayAutoChargeActivity.AnonymousClass1.C06771.this.a(z);
                                }
                            });
                        } else {
                            AppMethods.d((int) R.string.done);
                            PayAutoChargeActivity.this.a(vIPPayResult.ops, true);
                        }
                        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_USER_VIP_INFO).post(true);
                    } catch (Exception e) {
                        AppMethods.d(2131887272);
                        PayAutoChargeActivity.this.a(2, false);
                    }
                }

                public boolean onUIFailure(int i, String str) {
                    PayAutoChargeActivity.this.a(2, false);
                    return super.onUIFailure(i, str);
                }

                public void onUIStart() {
                    super.onUIStart();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                UserHttpUtils.a((IRequestHost) PayAutoChargeActivity.this.a(), PayAutoChargeActivity.this.k, PayHttpUtils.a(PayAutoChargeActivity.this.o), (BluedUIHttpResponse) new C06771(PayAutoChargeActivity.this.a()));
            }
        }, c.j);
    }

    public void h() {
        Context context = this.f20189c;
        this.l = DialogUtils.a(context, context.getResources().getString(R.string.Live_SendPresent_isSearching), false);
        this.e = (ProgressBar) findViewById(R.id.pb_progress);
        a(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20189c = this;
        setContentView(R.layout.dialog_vip_pay_from_link);
        if (getIntent() != null) {
            this.d = (GoodsOptionBasic) getIntent().getSerializableExtra("KEY_ITEM_BUY_OPTION");
            this.g = getIntent().getStringExtra("KEY_TARGET_UID");
            this.h = getIntent().getStringExtra("KEY_ACTIVITY_ID");
            this.i = getIntent().getStringExtra("KEY_VIP_DETAIL");
            this.o = getIntent().getIntExtra("KEY_PAY_PLAT_FORM", 1);
            this.r = getIntent().getIntExtra("KEY_PAY_ENTRUST", 0);
            this.t = getIntent().getStringExtra("KEY_PAY_PRODUCT_ID");
        }
        h();
        StatusBarHelper.a(this, false);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.f20189c, ShareCoreConstants.a(), false);
        this.f = createWXAPI;
        createWXAPI.registerApp(ShareCoreConstants.a());
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (!this.j) {
            this.j = true;
        } else if (StringUtils.d(this.k)) {
            if (this.q) {
                return;
            }
            finish();
        } else if (this.p) {
        } else {
            g();
            this.p = true;
        }
    }
}
