package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveListFollowFragmentNew_ViewBinding.class */
public class LiveListFollowFragmentNew_ViewBinding implements Unbinder {
    private LiveListFollowFragmentNew b;

    public LiveListFollowFragmentNew_ViewBinding(LiveListFollowFragmentNew liveListFollowFragmentNew, View view) {
        this.b = liveListFollowFragmentNew;
        liveListFollowFragmentNew.ivIcon = (ImageView) Utils.a(view, 2131365504, "field 'ivIcon'", ImageView.class);
        liveListFollowFragmentNew.tvHint = (TextView) Utils.a(view, 2131371675, "field 'tvHint'", TextView.class);
        liveListFollowFragmentNew.ivClose = (ImageView) Utils.a(view, 2131365207, "field 'ivClose'", ImageView.class);
        liveListFollowFragmentNew.llNoInternet = (NoDataAndLoadFailView) Utils.a(view, R.id.ll_no_internet, "field 'llNoInternet'", NoDataAndLoadFailView.class);
        liveListFollowFragmentNew.mRecyclerView = (RecyclerView) Utils.a(view, 2131369105, "field 'mRecyclerView'", RecyclerView.class);
        liveListFollowFragmentNew.liveRecommendEmpty = Utils.a(view, R.id.live_default_empty, "field 'liveRecommendEmpty'");
        liveListFollowFragmentNew.tv_live_start_btn = Utils.a(view, R.id.tv_live_start_btn, "field 'tv_live_start_btn'");
        liveListFollowFragmentNew.msg_toast = Utils.a(view, R.id.msg_toast, "field 'msg_toast'");
        liveListFollowFragmentNew.refreshFollowList = (SmartRefreshLayout) Utils.a(view, R.id.refresh_follow_list, "field 'refreshFollowList'", SmartRefreshLayout.class);
        liveListFollowFragmentNew.refreshNewUserList = (SmartRefreshLayout) Utils.a(view, R.id.refresh_new_user_list, "field 'refreshNewUserList'", SmartRefreshLayout.class);
        liveListFollowFragmentNew.rvFollowList = (RecyclerView) Utils.a(view, R.id.rv_follow_list, "field 'rvFollowList'", RecyclerView.class);
        liveListFollowFragmentNew.live_no_follow_banner = Utils.a(view, R.id.live_no_follow_banner, "field 'live_no_follow_banner'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveListFollowFragmentNew liveListFollowFragmentNew = this.b;
        if (liveListFollowFragmentNew == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveListFollowFragmentNew.ivIcon = null;
        liveListFollowFragmentNew.tvHint = null;
        liveListFollowFragmentNew.ivClose = null;
        liveListFollowFragmentNew.llNoInternet = null;
        liveListFollowFragmentNew.mRecyclerView = null;
        liveListFollowFragmentNew.liveRecommendEmpty = null;
        liveListFollowFragmentNew.tv_live_start_btn = null;
        liveListFollowFragmentNew.msg_toast = null;
        liveListFollowFragmentNew.refreshFollowList = null;
        liveListFollowFragmentNew.refreshNewUserList = null;
        liveListFollowFragmentNew.rvFollowList = null;
        liveListFollowFragmentNew.live_no_follow_banner = null;
    }
}
