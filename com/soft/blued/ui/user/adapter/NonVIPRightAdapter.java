package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.user.views.NonVIPRightView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/NonVIPRightAdapter.class */
public class NonVIPRightAdapter extends BaseQuickAdapter<VIPCenterForJsonParse.NonVIPPriviledge, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    Context f20052a;
    IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    int f20053c;
    FragmentManager d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VIPCenterForJsonParse.NonVIPPriviledge nonVIPPriviledge) {
        if (baseViewHolder == null || nonVIPPriviledge == null) {
            return;
        }
        View view = baseViewHolder.getView(R.id.ll_item);
        NonVIPRightView nonVIPRightView = (NonVIPRightView) baseViewHolder.getView(R.id.non_vip_right_view);
        int adapterPosition = baseViewHolder.getAdapterPosition();
        if (adapterPosition == 0) {
            nonVIPRightView.a();
        } else {
            nonVIPRightView.b();
        }
        if (adapterPosition == this.mData.size()) {
            view.setBackground(BluedSkinUtils.b(this.f20052a, (int) R.drawable.shape_round_white_vip_center_card_btmhalf));
        } else {
            view.setBackgroundColor(BluedSkinUtils.a(this.f20052a, 2131101780));
        }
        nonVIPRightView.a(this.b, nonVIPPriviledge, this.f20053c, this.d);
    }
}
