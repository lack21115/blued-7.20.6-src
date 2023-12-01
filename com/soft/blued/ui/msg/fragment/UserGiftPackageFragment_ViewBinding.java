package com.soft.blued.ui.msg.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.R;
import com.soft.blued.customview.CirclePageIndicator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/UserGiftPackageFragment_ViewBinding.class */
public class UserGiftPackageFragment_ViewBinding implements Unbinder {
    private UserGiftPackageFragment b;

    public UserGiftPackageFragment_ViewBinding(UserGiftPackageFragment userGiftPackageFragment, View view) {
        this.b = userGiftPackageFragment;
        userGiftPackageFragment.circlePageIndicator = (CirclePageIndicator) Utils.a(view, 2131364744, "field 'circlePageIndicator'", CirclePageIndicator.class);
        userGiftPackageFragment.gift_pager = (ViewPager) Utils.a(view, R.id.gift_pager, "field 'gift_pager'", ViewPager.class);
        userGiftPackageFragment.stv_buy = (TextView) Utils.a(view, R.id.stv_buy, "field 'stv_buy'", TextView.class);
        userGiftPackageFragment.tv_empty = (TextView) Utils.a(view, 2131371322, "field 'tv_empty'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        UserGiftPackageFragment userGiftPackageFragment = this.b;
        if (userGiftPackageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        userGiftPackageFragment.circlePageIndicator = null;
        userGiftPackageFragment.gift_pager = null;
        userGiftPackageFragment.stv_buy = null;
        userGiftPackageFragment.tv_empty = null;
    }
}
