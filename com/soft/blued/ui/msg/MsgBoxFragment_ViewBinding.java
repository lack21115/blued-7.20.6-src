package com.soft.blued.ui.msg;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgBoxFragment_ViewBinding.class */
public class MsgBoxFragment_ViewBinding implements Unbinder {
    private MsgBoxFragment b;

    public MsgBoxFragment_ViewBinding(MsgBoxFragment msgBoxFragment, View view) {
        this.b = msgBoxFragment;
        msgBoxFragment.title = (CommonTopTitleNoTrans) Utils.a(view, R.id.top_title, "field 'title'", CommonTopTitleNoTrans.class);
        msgBoxFragment.pullRefresh = (RenrenPullToRefreshListView) Utils.a(view, R.id.friend_list, "field 'pullRefresh'", RenrenPullToRefreshListView.class);
        msgBoxFragment.nodataview = (NoDataAndLoadFailView) Utils.a(view, R.id.nodataview, "field 'nodataview'", NoDataAndLoadFailView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MsgBoxFragment msgBoxFragment = this.b;
        if (msgBoxFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        msgBoxFragment.title = null;
        msgBoxFragment.pullRefresh = null;
        msgBoxFragment.nodataview = null;
    }
}
