package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPBuyOption;
import com.soft.blued.utils.StringUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPItemRoundAdapter.class */
public class VIPItemRoundAdapter extends BaseQuickAdapter<VIPBuyOption, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f20107a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private onGoodClick f20108c;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPItemRoundAdapter$onGoodClick.class */
    public interface onGoodClick {
        void onclick(VIPBuyOption vIPBuyOption);
    }

    public VIPItemRoundAdapter(Context context, int i) {
        super(R.layout.item_vip_pay_option_new, new ArrayList());
        this.f20107a = context;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(VIPBuyOption vIPBuyOption, View view) {
        Tracker.onClick(view);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                break;
            }
            ((VIPBuyOption) this.mData.get(i2)).choosen = false;
            i = i2 + 1;
        }
        vIPBuyOption.choosen = true;
        notifyDataSetChanged();
        onGoodClick ongoodclick = this.f20108c;
        if (ongoodclick != null) {
            ongoodclick.onclick(vIPBuyOption);
        }
    }

    public VIPBuyOption a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                return null;
            }
            if (((VIPBuyOption) this.mData.get(i2)).choosen) {
                return (VIPBuyOption) this.mData.get(i2);
            }
            i = i2 + 1;
        }
    }

    public void a(int i) {
        if (i < this.mData.size()) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mData.size()) {
                    break;
                }
                ((VIPBuyOption) this.mData.get(i3)).choosen = false;
                i2 = i3 + 1;
            }
            ((VIPBuyOption) this.mData.get(i)).choosen = true;
            notifyDataSetChanged();
            onGoodClick ongoodclick = this.f20108c;
            if (ongoodclick != null) {
                ongoodclick.onclick((VIPBuyOption) this.mData.get(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final VIPBuyOption vIPBuyOption) {
        if (baseViewHolder != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.ll_item);
            TextView textView = (TextView) baseViewHolder.getView(2131372046);
            LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_amount);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_yuan);
            TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_amount);
            TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_org_amount);
            TextView textView5 = (TextView) baseViewHolder.getView(R.id.tv_amount_per_month);
            ShapeTextView view = baseViewHolder.getView(R.id.tv_tag);
            TextView textView6 = (TextView) baseViewHolder.getView(R.id.tv_favourate);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) constraintLayout.getLayoutParams();
            if (baseViewHolder.getAdapterPosition() == 0) {
                layoutParams.leftMargin = DensityUtils.a(this.mContext, 10.0f);
            } else {
                layoutParams.leftMargin = DensityUtils.a(this.mContext, 0.0f);
            }
            constraintLayout.setLayoutParams(layoutParams);
            if (vIPBuyOption != null) {
                if (StringUtils.d(vIPBuyOption.item.title)) {
                    textView6.setVisibility(4);
                } else {
                    textView6.setText(vIPBuyOption.item.title);
                    textView6.setVisibility(0);
                }
                textView.setText(vIPBuyOption.item.name);
                textView3.setText(String.valueOf(Math.round(vIPBuyOption.money)));
                textView4.setText("￥" + Math.round(vIPBuyOption.original_money));
                textView4.getPaint().setFlags(16);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                textView5.setText("￥" + decimalFormat.format(vIPBuyOption.money / vIPBuyOption.month) + this.mContext.getResources().getString(R.string.per_month));
                if (StringUtils.d(vIPBuyOption.item.tag)) {
                    view.setVisibility(4);
                } else {
                    view.setText(vIPBuyOption.item.tag);
                    view.setVisibility(0);
                }
                constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPItemRoundAdapter$sUKEEkegxGoPU0RRN-k9v95Ai9I
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        VIPItemRoundAdapter.this.a(vIPBuyOption, view2);
                    }
                });
                boolean z = textView6.getVisibility() == 0;
                if (vIPBuyOption.choosen) {
                    if (z) {
                        if (this.b == 2) {
                            constraintLayout.setBackground(BluedSkinUtils.b(this.mContext, (int) R.drawable.shape_buy_svip_item_choosed_3_corner_radius));
                        } else {
                            constraintLayout.setBackground(BluedSkinUtils.b(this.mContext, (int) R.drawable.shape_buy_vip_item_choosed_3_corner_radius));
                        }
                    } else if (this.b == 2) {
                        constraintLayout.setBackground(BluedSkinUtils.b(this.mContext, (int) R.drawable.shape_buy_svip_item_choosed));
                    } else {
                        constraintLayout.setBackground(BluedSkinUtils.b(this.mContext, (int) R.drawable.shape_buy_vip_item_choosed));
                    }
                } else if (z) {
                    constraintLayout.setBackground(BluedSkinUtils.b(this.mContext, (int) R.drawable.shape_buy_unchoosed_3_cornor_radius));
                } else {
                    constraintLayout.setBackground(BluedSkinUtils.b(this.mContext, (int) R.drawable.shape_buy_unchoosed));
                }
                if (this.b == 2) {
                    textView2.setTextColor(this.mContext.getResources().getColor(2131099658));
                    textView3.setTextColor(this.mContext.getResources().getColor(2131099658));
                    ShapeHelper.a(view, 2131099658);
                    ShapeHelper.b(view, 2131099659);
                    return;
                }
                textView2.setTextColor(this.mContext.getResources().getColor(2131099663));
                textView3.setTextColor(this.mContext.getResources().getColor(2131099663));
                ShapeHelper.a(view, 2131099663);
                ShapeHelper.b(view, 2131099661);
            }
        }
    }

    public void a(onGoodClick ongoodclick) {
        this.f20108c = ongoodclick;
    }

    public void a(List<VIPBuyOption> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.mData.clear();
                this.mData.addAll(list);
                notifyDataSetChanged();
                return;
            }
            list.get(i2).vip_grade = this.b;
            i = i2 + 1;
        }
    }
}
