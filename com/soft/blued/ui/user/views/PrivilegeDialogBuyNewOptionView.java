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
import com.soft.blued.R;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PrivilegeDialogBuyNewOptionView.class */
public class PrivilegeDialogBuyNewOptionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f20692a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeConstraintLayout f20693c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;

    public PrivilegeDialogBuyNewOptionView(Context context) {
        super(context);
        this.f20692a = context;
        a();
    }

    public PrivilegeDialogBuyNewOptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20692a = context;
        a();
    }

    public PrivilegeDialogBuyNewOptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20692a = context;
        a();
    }

    public void a() {
        View inflate = LayoutInflater.from(this.f20692a).inflate(R.layout.item_privilege_pay_option_dialog_new, this);
        this.b = inflate;
        this.f20693c = inflate.findViewById(R.id.ll_item);
        this.d = (TextView) this.b.findViewById(R.id.tv_month_count);
        this.e = (TextView) this.b.findViewById(R.id.tv_month_desc);
        this.f = (TextView) this.b.findViewById(R.id.tv_per_amount);
        this.g = (TextView) this.b.findViewById(R.id.tv_favourate);
    }

    public void setOptionView(PrivilegeBuyOptionForJsonParse.ProductBean productBean) {
        ShapeHelper.b(this.f20693c, 2131102170);
        if (productBean.choosen) {
            ShapeHelper.b(this.f20693c, 2131102212);
            ShapeHelper.d(this.f20693c, 2131102222);
            this.d.setPadding(0, DensityUtils.a(this.f20692a, 10.0f), 0, 0);
            this.d.setTextColor(this.f20692a.getResources().getColor(2131102222));
            this.e.setTextColor(this.f20692a.getResources().getColor(2131102222));
            this.f.setTextColor(this.f20692a.getResources().getColor(2131102222));
            if (StringUtils.d(productBean.discount)) {
                this.g.setVisibility(4);
            } else {
                this.g.setVisibility(0);
                this.g.setText(productBean.discount);
            }
        } else {
            ShapeHelper.d(this.f20693c, 2131102212);
            ShapeHelper.b(this.f20693c, 2131102212);
            this.d.setPadding(0, DensityUtils.a(this.f20692a, 20.0f), 0, 0);
            this.d.setTextColor(this.f20692a.getResources().getColor(2131102203));
            this.e.setTextColor(this.f20692a.getResources().getColor(2131102203));
            this.f.setTextColor(this.f20692a.getResources().getColor(2131102205));
            this.g.setVisibility(8);
        }
        if (productBean.showBeans) {
            if (productBean.discount_beans > 0) {
                TextView textView = this.f;
                textView.setText(productBean.discount_beans + this.f20692a.getResources().getString(R.string.Live_SendPresent_wandou) + "/" + productBean.unit);
            } else {
                TextView textView2 = this.f;
                textView2.setText(productBean.average_beans + this.f20692a.getResources().getString(R.string.Live_SendPresent_wandou) + "/" + productBean.unit);
            }
        } else if (productBean.discount_price > 0.0f) {
            TextView textView3 = this.f;
            StringBuilder sb = new StringBuilder();
            sb.append("￥");
            sb.append(StringUtils.a(productBean.discount_price + ""));
            sb.append("/");
            sb.append(productBean.unit);
            textView3.setText(sb.toString());
        } else {
            TextView textView4 = this.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("￥");
            sb2.append(StringUtils.a(productBean.average_price + ""));
            sb2.append("/");
            sb2.append(productBean.unit);
            textView4.setText(sb2.toString());
        }
        this.d.setText(String.valueOf(productBean.buy_num));
        this.e.setText(productBean.unit);
    }
}
