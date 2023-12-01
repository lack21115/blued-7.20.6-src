package com.soft.blued.ui.msg.adapter;

import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg.customview.GiftGivingOptionViewNew;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/UserGiftPackageAdapter.class */
public class UserGiftPackageAdapter extends BaseQuickAdapter<UserGiftPackageModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public int f18507a;
    private IRequestHost b;

    public UserGiftPackageAdapter(IRequestHost iRequestHost, List<UserGiftPackageModel> list) {
        super(R.layout.item_pop_user_gift_new, list);
        this.f18507a = 2;
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, UserGiftPackageModel userGiftPackageModel) {
        GiftGivingOptionViewNew giftGivingOptionViewNew = (GiftGivingOptionViewNew) baseViewHolder.getView(R.id.gif_view);
        giftGivingOptionViewNew.f18584a = this.f18507a;
        giftGivingOptionViewNew.a(this.b, userGiftPackageModel);
    }
}
