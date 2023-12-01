package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.BluedPreferences;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PayPreOrderFragment.class */
public class PayPreOrderFragment extends BaseFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33885c = PayPreOrderFragment.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public Context f33886a;
    public View b;
    private PayUtils d;
    private ProgressBar e;
    private GoodsOptionBasic f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private LiveChargeCouponModel m;
    private int n = 1;
    private int o = 0;

    public static void a(Context context, GoodsOptionBasic goodsOptionBasic, String str, String str2, int i) {
        a(context, goodsOptionBasic, str, "", "", "", str2, i, 0, null);
    }

    public static void a(Context context, GoodsOptionBasic goodsOptionBasic, String str, String str2, String str3, String str4, String str5) {
        a(context, goodsOptionBasic, str, str2, str3, str4, str5, 0, 0, null);
    }

    public static void a(Context context, GoodsOptionBasic goodsOptionBasic, String str, String str2, String str3, String str4, String str5, int i, int i2, IRequestHost iRequestHost) {
        a(context, goodsOptionBasic, str, str2, str3, str4, str5, i, i2, null, 0, iRequestHost);
    }

    public static void a(Context context, GoodsOptionBasic goodsOptionBasic, String str, String str2, String str3, String str4, String str5, int i, int i2, LiveChargeCouponModel liveChargeCouponModel, int i3, IRequestHost iRequestHost) {
        if (i == 0) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("KEY_ITEM_BUY_OPTION", goodsOptionBasic);
            String str6 = str;
            if (str == null) {
                str6 = "my";
            }
            bundle.putString("KEY_PAY_FROM", str6);
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString("KEY_TARGET_UID", str2);
            if (str3 == null) {
                str3 = "";
            }
            bundle.putString("KEY_ACTIVITY_ID", str3);
            if (str4 == null) {
                str4 = "";
            }
            bundle.putString("KEY_EXCHANGE_ID", str4);
            bundle.putInt("KEY_COUPON_ID", i2);
            bundle.putInt("KEY_PAY_ENTRUST", i3);
            if (str5 == null) {
                str5 = "";
            }
            bundle.putString("KEY_DETAIL", str5);
            bundle.putSerializable("coupon_model", liveChargeCouponModel);
            TransparentActivity.a(bundle);
            TransparentActivity.b(context, PayPreOrderFragment.class, bundle);
        } else if (goodsOptionBasic != null) {
            PayUtils payUtils = new PayUtils(context, str, iRequestHost);
            payUtils.a(str2, str3, str4, str5, i2, liveChargeCouponModel);
            Log.v("drb", "directToPlatform:" + i);
            if (i != 1) {
                if (i == 2) {
                    if (goodsOptionBasic.wx_contract != 1 || i2 != 0) {
                        payUtils.a(2, goodsOptionBasic, goodsOptionBasic.vip_grade);
                        return;
                    }
                    PayAutoChargeActivity.a(context, goodsOptionBasic, str2, str3, str5, i, i3, goodsOptionBasic.id + "");
                    return;
                } else if (i == 3) {
                    payUtils.a(context, goodsOptionBasic, "", false, BluedPreferences.G(""), str5);
                    return;
                } else if (i != 4) {
                    return;
                }
            }
            if (goodsOptionBasic.alipay_contract != 1) {
                payUtils.a(i, goodsOptionBasic, goodsOptionBasic.vip_grade);
                return;
            }
            PayAutoChargeActivity.a(context, goodsOptionBasic, str2, str3, str5, i, i3, goodsOptionBasic.id + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    public void a() {
        ProgressBar progressBar = (ProgressBar) this.b.findViewById(R.id.pb_progress);
        this.e = progressBar;
        progressBar.setVisibility(4);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PayPreOrderFragment$6HspfWKG67nvX6WG38XMgQVsjrE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayPreOrderFragment.this.a(view);
            }
        });
        NormalPayTypeChoosePop.a(this.f33886a, new NormalPayTypeChoosePop.iChoosePayResultListener() { // from class: com.soft.blued.ui.user.fragment.PayPreOrderFragment.1
            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a() {
            }

            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a(int i, boolean z) {
                PayPreOrderFragment.this.n = i;
                PayPreOrderFragment.this.a(true);
            }
        }, this.n, this.f.id, getFragmentActive());
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, final boolean z) {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.PayPreOrderFragment.2
            @Override // java.lang.Runnable
            public void run() {
                LiveEventBusUtil.a(z, PayPreOrderFragment.this.f.trackMoney, PayPreOrderFragment.this.g);
                if (PayPreOrderFragment.this.getActivity() != null) {
                    PayPreOrderFragment.this.getActivity().finish();
                }
            }
        }, 500L);
    }

    public void a(boolean z) {
        int i = this.n;
        if (i != 1) {
            if (i == 2) {
                if (this.f.wx_contract == 1 && this.l == 0 && z) {
                    PayAutoChargeActivity.a(this.f33886a, this.f, this.h, this.i, this.k, this.n, this.o, "");
                    return;
                }
                PayUtils payUtils = this.d;
                GoodsOptionBasic goodsOptionBasic = this.f;
                payUtils.a(2, goodsOptionBasic, goodsOptionBasic.vip_grade);
                return;
            } else if (i != 4) {
                return;
            }
        }
        if (this.f.alipay_contract == 1 && this.l == 0 && z) {
            PayAutoChargeActivity.a(this.f33886a, this.f, this.h, this.i, this.k, this.n, this.o, "");
            return;
        }
        PayUtils payUtils2 = this.d;
        int i2 = this.n;
        GoodsOptionBasic goodsOptionBasic2 = this.f;
        payUtils2.a(i2, goodsOptionBasic2, goodsOptionBasic2.vip_grade);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        getActivity().finish();
        return super.onBackPressed();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33886a = getActivity();
        getActivity().overridePendingTransition(R.anim.no_anim, R.anim.no_anim);
        if (this.b == null) {
            this.b = layoutInflater.inflate(R.layout.dialog_vip_pay_pre_order, viewGroup, false);
            if (getArguments() != null) {
                this.f = (GoodsOptionBasic) getArguments().getSerializable("KEY_ITEM_BUY_OPTION");
                this.g = getArguments().getString("KEY_PAY_FROM");
                this.h = getArguments().getString("KEY_TARGET_UID");
                this.i = getArguments().getString("KEY_ACTIVITY_ID");
                this.j = getArguments().getString("KEY_EXCHANGE_ID");
                this.k = getArguments().getString("KEY_DETAIL");
                this.l = getArguments().getInt("KEY_COUPON_ID");
                this.n = getArguments().getInt("KEY_PAY_PLAT_FORM");
                this.m = (LiveChargeCouponModel) getArguments().getSerializable("coupon_model");
                this.o = getArguments().getInt("KEY_PAY_ENTRUST", 0);
            }
            PayUtils payUtils = new PayUtils(getActivity(), this.g, getFragmentActive());
            this.d = payUtils;
            payUtils.a(this.h, this.i, this.j, this.k, this.l, this.m);
            a();
            StatusBarHelper.a((Activity) getActivity(), false);
            VIPBuyResultObserver.a().a(this, getLifecycle());
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
