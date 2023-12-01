package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveJoinFansFragment_ViewBinding.class */
public class LiveJoinFansFragment_ViewBinding implements Unbinder {
    private LiveJoinFansFragment b;

    public LiveJoinFansFragment_ViewBinding(LiveJoinFansFragment liveJoinFansFragment, View view) {
        this.b = liveJoinFansFragment;
        liveJoinFansFragment.fl_main = Utils.a(view, 2131363859, "field 'fl_main'");
        liveJoinFansFragment.top_title = (CommonTopTitleNoTrans) Utils.a(view, 2131370749, "field 'top_title'", CommonTopTitleNoTrans.class);
        liveJoinFansFragment.refresh_view = (SmartRefreshLayout) Utils.a(view, 2131369121, "field 'refresh_view'", SmartRefreshLayout.class);
        liveJoinFansFragment.recycle_view = (RecyclerView) Utils.a(view, 2131369093, "field 'recycle_view'", RecyclerView.class);
        liveJoinFansFragment.ll_no_fans = Utils.a(view, R.id.ll_no_fans, "field 'll_no_fans'");
        liveJoinFansFragment.tv_no_data = (TextView) Utils.a(view, 2131372092, "field 'tv_no_data'", TextView.class);
        liveJoinFansFragment.tv_re_title = Utils.a(view, R.id.tv_re_title, "field 'tv_re_title'");
        liveJoinFansFragment.recycle_recommend = (RecyclerView) Utils.a(view, R.id.recycle_recommend, "field 'recycle_recommend'", RecyclerView.class);
        liveJoinFansFragment.tv_fans_qa = (TextView) Utils.a(view, R.id.tv_fans_qa, "field 'tv_fans_qa'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveJoinFansFragment liveJoinFansFragment = this.b;
        if (liveJoinFansFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveJoinFansFragment.fl_main = null;
        liveJoinFansFragment.top_title = null;
        liveJoinFansFragment.refresh_view = null;
        liveJoinFansFragment.recycle_view = null;
        liveJoinFansFragment.ll_no_fans = null;
        liveJoinFansFragment.tv_no_data = null;
        liveJoinFansFragment.tv_re_title = null;
        liveJoinFansFragment.recycle_recommend = null;
        liveJoinFansFragment.tv_fans_qa = null;
    }
}
