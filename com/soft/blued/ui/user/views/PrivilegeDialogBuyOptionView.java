package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PrivilegeDialogBuyOptionView.class */
public class PrivilegeDialogBuyOptionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f34385a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeConstraintLayout f34386c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;

    public PrivilegeDialogBuyOptionView(Context context) {
        super(context);
        this.f34385a = context;
        a();
    }

    public PrivilegeDialogBuyOptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34385a = context;
        a();
    }

    public PrivilegeDialogBuyOptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34385a = context;
        a();
    }

    public void a() {
        View inflate = LayoutInflater.from(this.f34385a).inflate(R.layout.item_privilege_pay_option_dialog, this);
        this.b = inflate;
        this.f34386c = (ShapeConstraintLayout) inflate.findViewById(R.id.ll_item);
        this.d = (TextView) this.b.findViewById(R.id.tv_month_count);
        this.e = (TextView) this.b.findViewById(R.id.tv_month_desc);
        this.f = (TextView) this.b.findViewById(R.id.tv_per_amount);
        this.g = (TextView) this.b.findViewById(R.id.tv_favourate);
        this.h = (TextView) this.b.findViewById(R.id.tv_discount_desc);
    }

    public void setOptionView(PrivilegeBuyOptionForJsonParse.ProductBean productBean) {
        ShapeHelper.b(this.f34386c, 2131101780);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34386c.getLayoutParams();
        if (productBean.choosen) {
            layoutParams.width = DensityUtils.a(this.f34385a, 100.0f);
            layoutParams.height = DensityUtils.a(this.f34385a, 133.0f);
            ShapeHelper.b(this.f34386c, 2131099653);
            ShapeHelper.d(this.f34386c, 2131102251);
            if (StringUtils.d(productBean.discount)) {
                this.g.setVisibility(4);
            } else {
                this.g.setVisibility(0);
                this.g.setText(productBean.discount);
            }
            this.d.setTextSize(26.0f);
            this.d.setPadding(0, DensityUtils.a(this.f34385a, 10.0f), 0, 0);
            this.e.setTextSize(14.0f);
            this.f.setTextSize(14.0f);
            this.h.setTextSize(14.0f);
        } else {
            layoutParams.width = DensityUtils.a(this.f34385a, 100.0f);
            layoutParams.height = DensityUtils.a(this.f34385a, 109.0f);
            ShapeHelper.d(this.f34386c, 2131101266);
            ShapeHelper.b(this.f34386c, 2131101266);
            this.g.setVisibility(8);
            this.d.setPadding(0, DensityUtils.a(this.f34385a, 31.0f), 0, 0);
            this.d.setTextSize(22.0f);
            this.e.setTextSize(12.0f);
            this.f.setTextSize(12.0f);
            this.h.setTextSize(12.0f);
        }
        this.f34386c.setLayoutParams(layoutParams);
        if (productBean.showBeans) {
            if (productBean.discount_beans > 0) {
                TextView textView = this.f;
                textView.setText(productBean.discount_beans + this.f34385a.getResources().getString(2131886105) + BridgeUtil.SPLIT_MARK + productBean.unit);
            } else {
                TextView textView2 = this.f;
                textView2.setText(productBean.average_beans + this.f34385a.getResources().getString(2131886105) + BridgeUtil.SPLIT_MARK + productBean.unit);
            }
        } else if (productBean.discount_price > 0.0f) {
            TextView textView3 = this.f;
            StringBuilder sb = new StringBuilder();
            sb.append("￥");
            sb.append(StringUtils.a(productBean.discount_price + ""));
            sb.append(BridgeUtil.SPLIT_MARK);
            sb.append(productBean.unit);
            textView3.setText(sb.toString());
        } else {
            TextView textView4 = this.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("￥");
            sb2.append(StringUtils.a(productBean.average_price + ""));
            sb2.append(BridgeUtil.SPLIT_MARK);
            sb2.append(productBean.unit);
            textView4.setText(sb2.toString());
        }
        this.d.setText(String.valueOf(productBean.buy_num));
        this.e.setText(productBean.unit);
        this.h.setText(productBean.discount_per);
    }
}
