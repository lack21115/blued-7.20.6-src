package com.soft.blued.ui.msg_group.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.TranslationAnimHintView;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupManagerFragment_ViewBinding.class */
public class GroupManagerFragment_ViewBinding implements Unbinder {
    private GroupManagerFragment b;

    public GroupManagerFragment_ViewBinding(GroupManagerFragment groupManagerFragment, View view) {
        this.b = groupManagerFragment;
        groupManagerFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        groupManagerFragment.hintView = (TranslationAnimHintView) Utils.a(view, R.id.hintView, "field 'hintView'", TranslationAnimHintView.class);
        groupManagerFragment.admin_list = (RecyclerView) Utils.a(view, R.id.admin_list, "field 'admin_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        GroupManagerFragment groupManagerFragment = this.b;
        if (groupManagerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        groupManagerFragment.title = null;
        groupManagerFragment.hintView = null;
        groupManagerFragment.admin_list = null;
    }
}
