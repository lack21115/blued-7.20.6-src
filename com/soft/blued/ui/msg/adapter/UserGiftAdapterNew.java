package com.soft.blued.ui.msg.adapter;

import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg.customview.GiftGivingOptionViewNew;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/UserGiftAdapterNew.class */
public class UserGiftAdapterNew extends BaseQuickAdapter<GiftGivingOptionForJsonParse, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public int f32196a;
    private IRequestHost b;

    public UserGiftAdapterNew(IRequestHost iRequestHost, List<GiftGivingOptionForJsonParse> list) {
        super(R.layout.item_pop_user_gift_new, list);
        this.f32196a = 2;
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
        GiftGivingOptionViewNew giftGivingOptionViewNew = (GiftGivingOptionViewNew) baseViewHolder.getView(R.id.gif_view);
        giftGivingOptionViewNew.f32274a = this.f32196a;
        giftGivingOptionViewNew.a(this.b, giftGivingOptionForJsonParse, giftGivingOptionForJsonParse.chosen);
    }
}
