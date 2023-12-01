package com.soft.blued.ui.user.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;
import com.soft.blued.customview.LabeledTextView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPCustomizedFragment_ViewBinding.class */
public class VIPCustomizedFragment_ViewBinding implements Unbinder {
    private VIPCustomizedFragment b;

    public VIPCustomizedFragment_ViewBinding(VIPCustomizedFragment vIPCustomizedFragment, View view) {
        this.b = vIPCustomizedFragment;
        vIPCustomizedFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        vIPCustomizedFragment.viewBubble = (LabeledTextView) Utils.a(view, R.id.view_bubble, "field 'viewBubble'", LabeledTextView.class);
        vIPCustomizedFragment.viewChatBg = (LabeledTextView) Utils.a(view, R.id.view_chat_bg, "field 'viewChatBg'", LabeledTextView.class);
        vIPCustomizedFragment.viewFeedBg = (LabeledTextView) Utils.a(view, R.id.view_feed_bg, "field 'viewFeedBg'", LabeledTextView.class);
        vIPCustomizedFragment.viewAppIcon = (LabeledTextView) Utils.a(view, R.id.view_app_icon, "field 'viewAppIcon'", LabeledTextView.class);
        vIPCustomizedFragment.viewWidget = (LabeledTextView) Utils.a(view, R.id.view_widget, "field 'viewWidget'", LabeledTextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VIPCustomizedFragment vIPCustomizedFragment = this.b;
        if (vIPCustomizedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        vIPCustomizedFragment.title = null;
        vIPCustomizedFragment.viewBubble = null;
        vIPCustomizedFragment.viewChatBg = null;
        vIPCustomizedFragment.viewFeedBg = null;
        vIPCustomizedFragment.viewAppIcon = null;
        vIPCustomizedFragment.viewWidget = null;
    }
}
