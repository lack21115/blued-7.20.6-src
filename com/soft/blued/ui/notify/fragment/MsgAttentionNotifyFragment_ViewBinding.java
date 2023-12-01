package com.soft.blued.ui.notify.fragment;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/MsgAttentionNotifyFragment_ViewBinding.class */
public class MsgAttentionNotifyFragment_ViewBinding implements Unbinder {
    private MsgAttentionNotifyFragment b;

    public MsgAttentionNotifyFragment_ViewBinding(MsgAttentionNotifyFragment msgAttentionNotifyFragment, View view) {
        this.b = msgAttentionNotifyFragment;
        msgAttentionNotifyFragment.lv_friend = (ListView) Utils.a(view, R.id.notice_list, "field 'lv_friend'", ListView.class);
        msgAttentionNotifyFragment.topTitle = (CommonTopTitleNoTrans) Utils.a(view, 2131370749, "field 'topTitle'", CommonTopTitleNoTrans.class);
        msgAttentionNotifyFragment.llNodataChats = (NoDataAndLoadFailView) Utils.a(view, R.id.ll_nodata_chats, "field 'llNodataChats'", NoDataAndLoadFailView.class);
        msgAttentionNotifyFragment.msgFrientPullrefresh = (SmartRefreshLayout) Utils.a(view, R.id.msg_frient_pullrefresh, "field 'msgFrientPullrefresh'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MsgAttentionNotifyFragment msgAttentionNotifyFragment = this.b;
        if (msgAttentionNotifyFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        msgAttentionNotifyFragment.lv_friend = null;
        msgAttentionNotifyFragment.topTitle = null;
        msgAttentionNotifyFragment.llNodataChats = null;
        msgAttentionNotifyFragment.msgFrientPullrefresh = null;
    }
}
