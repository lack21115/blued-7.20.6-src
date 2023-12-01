package com.soft.blued.ui.user.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/VIPDiaglogBuyOptionView.class */
public class VIPDiaglogBuyOptionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f20709a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private ConstraintLayout f20710c;
    private TextView d;
    private TextView e;
    private ShapeTextView f;
    private ShapeTextView g;
    private TextView h;
    private int i;

    public VIPDiaglogBuyOptionView(Context context) {
        super(context);
        this.i = 1;
        this.f20709a = context;
        a();
    }

    public VIPDiaglogBuyOptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 1;
        this.f20709a = context;
        a();
    }

    public VIPDiaglogBuyOptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 1;
        this.f20709a = context;
        a();
    }

    public void a() {
        View inflate = LayoutInflater.from(this.f20709a).inflate(R.layout.item_vip_pay_option_new, this);
        this.b = inflate;
        this.f20710c = (ConstraintLayout) inflate.findViewById(R.id.ll_item);
        this.d = (TextView) this.b.findViewById(2131372046);
        this.e = (TextView) this.b.findViewById(R.id.tv_amount);
        this.f = this.b.findViewById(R.id.tv_favourate);
        this.g = this.b.findViewById(R.id.tv_tag);
        this.h = (TextView) this.b.findViewById(R.id.tv_yuan);
    }

    public void setOptionView(VIPBuyOption vIPBuyOption) {
        if (vIPBuyOption != null) {
            boolean z = false;
            if (StringUtils.d(vIPBuyOption.item.tag)) {
                this.f.setVisibility(4);
            } else {
                this.f.setText(vIPBuyOption.item.tag);
                this.f.setVisibility(0);
            }
            if (this.f.getVisibility() == 0) {
                z = true;
            }
            if (vIPBuyOption.choosen) {
                if (z) {
                    if (this.i == 2) {
                        this.f20710c.setBackground(this.f20709a.getResources().getDrawable(R.drawable.shape_buy_svip_item_choosed_3_corner_radius));
                    } else {
                        this.f20710c.setBackground(this.f20709a.getResources().getDrawable(R.drawable.shape_buy_vip_item_choosed_3_corner_radius));
                    }
                } else if (this.i == 2) {
                    this.f20710c.setBackground(this.f20709a.getResources().getDrawable(R.drawable.shape_buy_svip_item_choosed));
                } else {
                    this.f20710c.setBackground(this.f20709a.getResources().getDrawable(R.drawable.shape_buy_vip_item_choosed));
                }
            } else if (z) {
                this.f20710c.setBackground(this.f20709a.getResources().getDrawable(R.drawable.shape_buy_unchoosed_3_cornor_radius));
            } else {
                this.f20710c.setBackground(this.f20709a.getResources().getDrawable(R.drawable.shape_buy_unchoosed));
            }
            if (this.i == 2) {
                this.h.setTextColor(this.f20709a.getResources().getColor(2131099658));
                this.e.setTextColor(this.f20709a.getResources().getColor(2131099658));
                this.g.setTextColor(this.f20709a.getResources().getColor(2131099658));
                ShapeHelper.b(this.g, 2131099659);
                return;
            }
            this.h.setTextColor(this.f20709a.getResources().getColor(2131099663));
            this.e.setTextColor(this.f20709a.getResources().getColor(2131099663));
            this.g.setTextColor(this.f20709a.getResources().getColor(2131099663));
            ShapeHelper.b(this.g, 2131099661);
        }
    }
}
