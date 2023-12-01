package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/SwitchAccountFragment_ViewBinding.class */
public class SwitchAccountFragment_ViewBinding implements Unbinder {
    private SwitchAccountFragment b;

    public SwitchAccountFragment_ViewBinding(SwitchAccountFragment switchAccountFragment, View view) {
        this.b = switchAccountFragment;
        switchAccountFragment.top_title = (CommonTopTitleNoTrans) Utils.a(view, R.id.top_title, "field 'top_title'", CommonTopTitleNoTrans.class);
        switchAccountFragment.iv_account_icon_one = (ImageView) Utils.a(view, R.id.iv_account_icon_one, "field 'iv_account_icon_one'", ImageView.class);
        switchAccountFragment.iv_account_icon_two = (ImageView) Utils.a(view, R.id.iv_account_icon_two, "field 'iv_account_icon_two'", ImageView.class);
        switchAccountFragment.iv_online_state_one = (ImageView) Utils.a(view, R.id.iv_online_state_one, "field 'iv_online_state_one'", ImageView.class);
        switchAccountFragment.iv_online_state_two = (ImageView) Utils.a(view, R.id.iv_online_state_two, "field 'iv_online_state_two'", ImageView.class);
        switchAccountFragment.tv_account_nick_one = (TextView) Utils.a(view, R.id.tv_account_nick_one, "field 'tv_account_nick_one'", TextView.class);
        switchAccountFragment.tv_account_nick_two = (TextView) Utils.a(view, R.id.tv_account_nick_two, "field 'tv_account_nick_two'", TextView.class);
        switchAccountFragment.tv_online_hint_one = (TextView) Utils.a(view, R.id.tv_online_hint_one, "field 'tv_online_hint_one'", TextView.class);
        switchAccountFragment.iv_delete_one = (ImageView) Utils.a(view, R.id.iv_delete_one, "field 'iv_delete_one'", ImageView.class);
        switchAccountFragment.iv_delete_two = (ImageView) Utils.a(view, R.id.iv_delete_two, "field 'iv_delete_two'", ImageView.class);
        switchAccountFragment.tv_add_account = (TextView) Utils.a(view, R.id.tv_add_account, "field 'tv_add_account'", TextView.class);
        switchAccountFragment.tv_management = (TextView) Utils.a(view, R.id.tv_management, "field 'tv_management'", TextView.class);
        switchAccountFragment.tv_management_hint = (TextView) Utils.a(view, R.id.tv_management_hint, "field 'tv_management_hint'", TextView.class);
        switchAccountFragment.tv_has_unread = (ShapeTextView) Utils.a(view, R.id.tv_has_unread, "field 'tv_has_unread'", ShapeTextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SwitchAccountFragment switchAccountFragment = this.b;
        if (switchAccountFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        switchAccountFragment.top_title = null;
        switchAccountFragment.iv_account_icon_one = null;
        switchAccountFragment.iv_account_icon_two = null;
        switchAccountFragment.iv_online_state_one = null;
        switchAccountFragment.iv_online_state_two = null;
        switchAccountFragment.tv_account_nick_one = null;
        switchAccountFragment.tv_account_nick_two = null;
        switchAccountFragment.tv_online_hint_one = null;
        switchAccountFragment.iv_delete_one = null;
        switchAccountFragment.iv_delete_two = null;
        switchAccountFragment.tv_add_account = null;
        switchAccountFragment.tv_management = null;
        switchAccountFragment.tv_management_hint = null;
        switchAccountFragment.tv_has_unread = null;
    }
}
