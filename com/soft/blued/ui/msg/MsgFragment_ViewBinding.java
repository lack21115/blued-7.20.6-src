package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.TranslationAnimHintView;
import com.soft.blued.R;
import com.soft.blued.customview.TouchEnableKeyboardLinearLayout;
import com.soft.blued.ui.msg.customview.MsgFilterView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment_ViewBinding.class */
public class MsgFragment_ViewBinding implements Unbinder {
    private MsgFragment b;

    public MsgFragment_ViewBinding(MsgFragment msgFragment, View view) {
        this.b = msgFragment;
        msgFragment.keyboardLayout = (TouchEnableKeyboardLinearLayout) Utils.a(view, R.id.keyboardRelativeLayout, "field 'keyboardLayout'", TouchEnableKeyboardLinearLayout.class);
        msgFragment.cover_view = Utils.a(view, 2131363095, "field 'cover_view'");
        msgFragment.msg_filter_guide_iv = Utils.a(view, R.id.msg_filter_guide_iv, "field 'msg_filter_guide_iv'");
        msgFragment.msgFilterView = (MsgFilterView) Utils.a(view, R.id.msg_filter_view, "field 'msgFilterView'", MsgFilterView.class);
        msgFragment.pullRefresh = (RenrenPullToRefreshListView) Utils.a(view, R.id.msg_frient_pullrefresh, "field 'pullRefresh'", RenrenPullToRefreshListView.class);
        msgFragment.rLayout = (RelativeLayout) Utils.a(view, R.id.r_layout, "field 'rLayout'", RelativeLayout.class);
        msgFragment.bottom_hint_view = (TranslationAnimHintView) Utils.a(view, R.id.bottom_hint_view, "field 'bottom_hint_view'", TranslationAnimHintView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MsgFragment msgFragment = this.b;
        if (msgFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        msgFragment.keyboardLayout = null;
        msgFragment.cover_view = null;
        msgFragment.msg_filter_guide_iv = null;
        msgFragment.msgFilterView = null;
        msgFragment.pullRefresh = null;
        msgFragment.rLayout = null;
        msgFragment.bottom_hint_view = null;
    }
}
