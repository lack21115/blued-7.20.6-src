package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveListHotFragment_ViewBinding.class */
public class LiveListHotFragment_ViewBinding implements Unbinder {
    private LiveListHotFragment b;

    public LiveListHotFragment_ViewBinding(LiveListHotFragment liveListHotFragment, View view) {
        this.b = liveListHotFragment;
        liveListHotFragment.grid_view = (RecyclerView) Utils.a(view, R.id.grid_view, "field 'grid_view'", RecyclerView.class);
        liveListHotFragment.refresh_view = (SmartRefreshLayout) Utils.a(view, R.id.refresh_view, "field 'refresh_view'", SmartRefreshLayout.class);
        liveListHotFragment.ll_default_empty = (LinearLayout) Utils.a(view, R.id.ll_default_empty, "field 'll_default_empty'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveListHotFragment liveListHotFragment = this.b;
        if (liveListHotFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveListHotFragment.grid_view = null;
        liveListHotFragment.refresh_view = null;
        liveListHotFragment.ll_default_empty = null;
    }
}
