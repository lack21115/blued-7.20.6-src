package com.soft.blued.ui.user.adapter;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPBuyTipsAdapter.class */
public class VIPBuyTipsAdapter extends BaseQuickAdapter<VIPPrivilegeModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f20097a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VIPPrivilegeModel vIPPrivilegeModel) {
        baseViewHolder.setText(R.id.vip_buy_tip_name, vIPPrivilegeModel.name);
        ImageLoader.a(this.f20097a, vIPPrivilegeModel.icon).b(2131237310).c().a((ImageView) baseViewHolder.getView(R.id.vip_buy_tip_view));
    }
}
