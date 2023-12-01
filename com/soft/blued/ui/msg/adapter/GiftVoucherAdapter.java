package com.soft.blued.ui.msg.adapter;

import androidx.core.content.ContextCompat;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.GiftVoucherModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/GiftVoucherAdapter.class */
public class GiftVoucherAdapter extends BaseQuickAdapter<GiftVoucherModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public double f31977a;

    public GiftVoucherAdapter() {
        super((int) R.layout.item_gift_voucher);
    }

    private boolean a(double d, GiftVoucherModel giftVoucherModel) {
        return giftVoucherModel.isExpire || giftVoucherModel.money < d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GiftVoucherModel giftVoucherModel) {
        int color = ContextCompat.getColor(this.mContext, 2131102260);
        int color2 = ContextCompat.getColor(this.mContext, 2131102254);
        int color3 = ContextCompat.getColor(this.mContext, 2131101766);
        BaseViewHolder text = baseViewHolder.setText(2131372754, giftVoucherModel.title);
        text.setText(R.id.tv_money, ((int) giftVoucherModel.money) + "");
        if (giftVoucherModel.isExpire) {
            baseViewHolder.setText(2131372638, this.mContext.getString(R.string.gift_expired));
        } else {
            baseViewHolder.setText(2131372638, this.mContext.getString(R.string.for_social_gifts));
        }
        String a2 = TimeAndDateUtils.a(giftVoucherModel.start_timestamp + "", "yyyy.MM.dd");
        String a3 = TimeAndDateUtils.a(giftVoucherModel.end_timestamp + "", "yyyy.MM.dd");
        baseViewHolder.setText(2131371242, this.mContext.getString(R.string.redeem_between) + ":" + a2 + "-" + a3);
        if (a(this.f31977a, giftVoucherModel)) {
            baseViewHolder.setTextColor(2131372754, color).setTextColor(2131371242, color).setTextColor(2131372638, color).setTextColor(R.id.tv_money, color).setTextColor(R.id.rmb, color);
        } else {
            baseViewHolder.setTextColor(2131372754, color2).setTextColor(2131371242, color2).setTextColor(2131372638, color2).setTextColor(R.id.tv_money, color2).setTextColor(R.id.rmb, color2);
        }
        if (giftVoucherModel.isChecked) {
            baseViewHolder.setTextColor(R.id.tv_money, color3).setTextColor(R.id.rmb, color3);
            baseViewHolder.setBackgroundRes(2131362934, R.drawable.gift_voucher_selected_bg);
            baseViewHolder.setImageResource(2131365189, R.drawable.gift_voucher_on);
        } else {
            baseViewHolder.setBackgroundRes(2131362934, a(this.f31977a, giftVoucherModel) ? 2131232855 : 2131232856);
            baseViewHolder.setImageResource(2131365189, R.drawable.gift_voucher_off);
        }
        baseViewHolder.setVisible(2131365189, !a(this.f31977a, giftVoucherModel));
    }
}
