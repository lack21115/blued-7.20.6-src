package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYPrePayPriceAdapter.class */
public class YYPrePayPriceAdapter extends CommonRecycleAdapter<PayOption._pay_list> {

    /* renamed from: a  reason: collision with root package name */
    public int f16208a;
    public ArrayList<Long> b;

    /* renamed from: c  reason: collision with root package name */
    private int f16209c;
    private int d;
    private SelectItemCallBack e;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYPrePayPriceAdapter$SelectItemCallBack.class */
    public interface SelectItemCallBack {
        void selectItem(int i, View view, PayOption._pay_list _pay_listVar);
    }

    public YYPrePayPriceAdapter(Context context, int i, int i2, int i3, SelectItemCallBack selectItemCallBack) {
        super(context);
        this.b = new ArrayList<>();
        this.f16208a = i;
        this.f16209c = i2;
        this.d = i3;
        this.e = selectItemCallBack;
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
        this.f16208a = i;
        SelectItemCallBack selectItemCallBack = this.e;
        if (selectItemCallBack != null) {
            selectItemCallBack.selectItem(i, view, _pay_listVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    /* renamed from: a */
    public void onBindViewHolderData(final PayOption._pay_list _pay_listVar, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
        commonAdapterHolder.a(R.id.tv_beans, a(_pay_listVar.money * _pay_listVar.ratio));
        if (YYRoomInfoManager.e().c().k()) {
            int i2 = R.id.tv_price;
            commonAdapterHolder.a(i2, a(_pay_listVar.pretax) + "元");
        } else {
            int i3 = R.id.tv_price;
            commonAdapterHolder.a(i3, a(_pay_listVar.money) + "元");
        }
        final View a2 = commonAdapterHolder.a(R.id.view_border);
        final int i4 = (this.f16209c * this.d) + i;
        if (this.f16208a != i4) {
            a2.setAlpha(0.0f);
        } else if (this.e != null) {
            a2.setAlpha(1.0f);
            this.e.selectItem(this.f16208a, a2, _pay_listVar);
        }
        commonAdapterHolder.a(R.id.iv_icon_first_gift).setVisibility(4);
        Iterator<Long> it = this.b.iterator();
        while (it.hasNext()) {
            if (_pay_listVar.id == it.next().longValue()) {
                commonAdapterHolder.a(R.id.iv_icon_first_gift).setVisibility(0);
            } else {
                commonAdapterHolder.a(R.id.iv_icon_first_gift).setVisibility(4);
            }
        }
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYPrePayPriceAdapter$s_dKAOIQcxRQWjx4muT4d50rP3A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPrePayPriceAdapter.this.a(i4, a2, _pay_listVar, view);
            }
        });
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return R.layout.item_pre_pay_price_yy;
    }
}
