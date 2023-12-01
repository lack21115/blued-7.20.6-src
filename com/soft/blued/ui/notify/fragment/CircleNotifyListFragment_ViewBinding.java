package com.soft.blued.ui.notify.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/CircleNotifyListFragment_ViewBinding.class */
public class CircleNotifyListFragment_ViewBinding implements Unbinder {
    private CircleNotifyListFragment b;

    public CircleNotifyListFragment_ViewBinding(CircleNotifyListFragment circleNotifyListFragment, View view) {
        this.b = circleNotifyListFragment;
        circleNotifyListFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        circleNotifyListFragment.recyclerView = (RecyclerView) Utils.a(view, 2131369105, "field 'recyclerView'", RecyclerView.class);
        circleNotifyListFragment.refreshLayout = (SmartRefreshLayout) Utils.a(view, R.id.refresh_layout, "field 'refreshLayout'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CircleNotifyListFragment circleNotifyListFragment = this.b;
        if (circleNotifyListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        circleNotifyListFragment.title = null;
        circleNotifyListFragment.recyclerView = null;
        circleNotifyListFragment.refreshLayout = null;
    }
}
