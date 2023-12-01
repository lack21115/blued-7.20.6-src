package com.soft.blued.ui.msg.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.soft.blued.R;
import com.soft.blued.customview.CirclePageIndicator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/UserGiftFragment_ViewBinding.class */
public class UserGiftFragment_ViewBinding implements Unbinder {
    private UserGiftFragment b;

    public UserGiftFragment_ViewBinding(UserGiftFragment userGiftFragment, View view) {
        this.b = userGiftFragment;
        userGiftFragment.circlePageIndicator = (CirclePageIndicator) Utils.a(view, 2131364744, "field 'circlePageIndicator'", CirclePageIndicator.class);
        userGiftFragment.gift_pager = (ViewPager) Utils.a(view, R.id.gift_pager, "field 'gift_pager'", ViewPager.class);
        userGiftFragment.rl_pay_type = (ShapeRelativeLayout) Utils.a(view, R.id.rl_pay_type, "field 'rl_pay_type'", ShapeRelativeLayout.class);
        userGiftFragment.stv_buy = (TextView) Utils.a(view, R.id.stv_buy, "field 'stv_buy'", TextView.class);
        userGiftFragment.tv_pay_type = (TextView) Utils.a(view, R.id.tv_pay_type, "field 'tv_pay_type'", TextView.class);
        userGiftFragment.ll_stock_tip = (LinearLayout) Utils.a(view, R.id.ll_stock_tip, "field 'll_stock_tip'", LinearLayout.class);
        userGiftFragment.rl_voucher = (ShapeRelativeLayout) Utils.a(view, R.id.rl_voucher, "field 'rl_voucher'", ShapeRelativeLayout.class);
        userGiftFragment.tv_voucher = (TextView) Utils.a(view, R.id.tv_voucher, "field 'tv_voucher'", TextView.class);
        userGiftFragment.tv_voucher_title = (TextView) Utils.a(view, R.id.tv_voucher_title, "field 'tv_voucher_title'", TextView.class);
        userGiftFragment.tv_pay_title = (TextView) Utils.a(view, R.id.tv_pay_title, "field 'tv_pay_title'", TextView.class);
        userGiftFragment.voucher_line = Utils.a(view, R.id.voucher_line, "field 'voucher_line'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        UserGiftFragment userGiftFragment = this.b;
        if (userGiftFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        userGiftFragment.circlePageIndicator = null;
        userGiftFragment.gift_pager = null;
        userGiftFragment.rl_pay_type = null;
        userGiftFragment.stv_buy = null;
        userGiftFragment.tv_pay_type = null;
        userGiftFragment.ll_stock_tip = null;
        userGiftFragment.rl_voucher = null;
        userGiftFragment.tv_voucher = null;
        userGiftFragment.tv_voucher_title = null;
        userGiftFragment.tv_pay_title = null;
        userGiftFragment.voucher_line = null;
    }
}
