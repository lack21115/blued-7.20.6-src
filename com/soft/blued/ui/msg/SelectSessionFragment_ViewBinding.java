package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/SelectSessionFragment_ViewBinding.class */
public class SelectSessionFragment_ViewBinding implements Unbinder {
    private SelectSessionFragment b;

    public SelectSessionFragment_ViewBinding(SelectSessionFragment selectSessionFragment, View view) {
        this.b = selectSessionFragment;
        selectSessionFragment.top_title = (CommonTopTitleNoTrans) Utils.a(view, 2131370749, "field 'top_title'", CommonTopTitleNoTrans.class);
        selectSessionFragment.recyclerView = (RecyclerView) Utils.a(view, 2131369096, "field 'recyclerView'", RecyclerView.class);
        selectSessionFragment.tv_all = (TextView) Utils.a(view, R.id.tv_all, "field 'tv_all'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SelectSessionFragment selectSessionFragment = this.b;
        if (selectSessionFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        selectSessionFragment.top_title = null;
        selectSessionFragment.recyclerView = null;
        selectSessionFragment.tv_all = null;
    }
}
