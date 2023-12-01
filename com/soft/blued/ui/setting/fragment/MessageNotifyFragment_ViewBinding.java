package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/MessageNotifyFragment_ViewBinding.class */
public class MessageNotifyFragment_ViewBinding implements Unbinder {
    private MessageNotifyFragment b;

    public MessageNotifyFragment_ViewBinding(MessageNotifyFragment messageNotifyFragment, View view) {
        this.b = messageNotifyFragment;
        messageNotifyFragment.topTitle = (CommonTopTitleNoTrans) Utils.a(view, R.id.top_title, "field 'topTitle'", CommonTopTitleNoTrans.class);
        messageNotifyFragment.llMessageMobileLogin = (LinearLayout) Utils.a(view, R.id.ll_message_mobile_login, "field 'llMessageMobileLogin'", LinearLayout.class);
        messageNotifyFragment.llMessageCommonLogin = (LinearLayout) Utils.a(view, R.id.ll_message_common_login, "field 'llMessageCommonLogin'", LinearLayout.class);
        messageNotifyFragment.tbMessageMobileLogin = (ToggleButton) Utils.a(view, R.id.tb_message_mobile_login, "field 'tbMessageMobileLogin'", ToggleButton.class);
        messageNotifyFragment.tbMessageCommonLogin = (ToggleButton) Utils.a(view, R.id.tb_message_common_login, "field 'tbMessageCommonLogin'", ToggleButton.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MessageNotifyFragment messageNotifyFragment = this.b;
        if (messageNotifyFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        messageNotifyFragment.topTitle = null;
        messageNotifyFragment.llMessageMobileLogin = null;
        messageNotifyFragment.llMessageCommonLogin = null;
        messageNotifyFragment.tbMessageMobileLogin = null;
        messageNotifyFragment.tbMessageCommonLogin = null;
    }
}
