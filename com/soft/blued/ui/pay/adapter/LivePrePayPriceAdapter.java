package com.soft.blued.ui.pay.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.LiveChargeCouponModel;
import com.blued.android.module.live.base.model.PayOption;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.DeviceUtils;
import java.text.DecimalFormat;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/adapter/LivePrePayPriceAdapter.class */
public class LivePrePayPriceAdapter extends CommonRecycleAdapter<PayOption._pay_list> {

    /* renamed from: a  reason: collision with root package name */
    public int f32990a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f32991c;
    private LiveChargeCouponModel d;
    private SelectItemCallBack e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/adapter/LivePrePayPriceAdapter$SelectItemCallBack.class */
    public interface SelectItemCallBack {
        void selectItem(int i, View view, PayOption._pay_list _pay_listVar);
    }

    public LivePrePayPriceAdapter(Context context, int i, int i2, int i3, LiveChargeCouponModel liveChargeCouponModel, SelectItemCallBack selectItemCallBack) {
        super(context);
        this.f32990a = i;
        this.b = i2;
        this.f32991c = i3;
        this.e = selectItemCallBack;
        this.d = liveChargeCouponModel;
    }

    private String a(double d) {
        int i;
        String format = new DecimalFormat("#0.00").format(d);
        int length = format.length();
        while (true) {
            int i2 = length - 1;
            i = i2;
            if (i2 < 0) {
                break;
            } else if (format.charAt(i2) == '.') {
                i = i2;
                break;
            } else if (format.charAt(i2) != '0') {
                i = i2 + 1;
                break;
            } else {
                length = i2;
            }
        }
        return format.substring(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, View view, PayOption._pay_list _pay_listVar, View view2) {
        Tracker.onClick(view2);
        this.f32990a = i;
        SelectItemCallBack selectItemCallBack = this.e;
        if (selectItemCallBack != null) {
            selectItemCallBack.selectItem(i, view, _pay_listVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    /* renamed from: a */
    public void onBindViewHolderData(final PayOption._pay_list _pay_listVar, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
        commonAdapterHolder.a(2131370967, a(_pay_listVar.money * _pay_listVar.ratio));
        if (DeviceUtils.f()) {
            commonAdapterHolder.a(2131372285, a(_pay_listVar.pretax) + "元");
        } else {
            commonAdapterHolder.a(2131372285, a(_pay_listVar.money) + "元");
        }
        if (this.d == null || _pay_listVar.money < this.d.threshold) {
            commonAdapterHolder.b(R.id.live_charge_coupon_gift_iv, 8);
        } else {
            commonAdapterHolder.b(R.id.live_charge_coupon_gift_iv, 0);
        }
        final View a2 = commonAdapterHolder.a(2131373114);
        final int i2 = (this.b * this.f32991c) + i;
        if (this.f32990a != i2) {
            a2.setAlpha(0.0f);
        } else if (this.e != null) {
            a2.setAlpha(1.0f);
            this.e.selectItem(this.f32990a, a2, _pay_listVar);
        }
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.pay.adapter.-$$Lambda$LivePrePayPriceAdapter$ambFIvde_GzbsiTcwHlqwE5wLNk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePrePayPriceAdapter.this.a(i2, a2, _pay_listVar, view);
            }
        });
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return R.layout.item_pre_pay_price;
    }
}
