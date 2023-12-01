package com.soft.blued.ui.user.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPCenterNewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPNewUserOptionAdapter.class */
public final class VIPNewUserOptionAdapter extends BaseQuickAdapter<VIPCenterNewModel.OptionList, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final int f20111a;

    public VIPNewUserOptionAdapter(int i) {
        super((int) R.layout.vip_center_new_user_option_item);
        this.f20111a = i;
    }

    public final VIPCenterNewModel.OptionList a() {
        List<VIPCenterNewModel.OptionList> data = getData();
        if (data == null || data.isEmpty()) {
            return null;
        }
        int size = getData().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            if (getData().get(i2).choosen) {
                return getData().get(i2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VIPCenterNewModel.OptionList optionList) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(optionList, "data");
        ShapeHelper.ShapeView shapeView = (ShapeLinearLayout) baseViewHolder.getView(R.id.item_view);
        ShapeTextView view = baseViewHolder.getView(R.id.tv_choosen_tag);
        if (baseViewHolder.getAdapterPosition() == 0) {
            ViewGroup.LayoutParams layoutParams = shapeView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            ((LinearLayout.LayoutParams) layoutParams).setMarginStart(DensityUtils.a(this.mContext, 10.0f));
        }
        if (baseViewHolder.getPosition() == 0) {
            optionList.item.tag_up = "最优惠";
        }
        if (TextUtils.isEmpty(optionList.item.tag_up)) {
            view.setVisibility(4);
        } else {
            view.setText(optionList.item.tag_up);
            view.setVisibility(0);
        }
        baseViewHolder.setText(2131372046, optionList.item.name);
        ShapeHelper.ShapeView shapeView2 = shapeView;
        ShapeHelper.a(shapeView2, DensityUtils.a(this.mContext, 2.0f), 0.0f, 0.0f);
        if (optionList.choosen) {
            ShapeHelper.b(shapeView2, 2131102170);
            ShapeHelper.d(shapeView2, (int) R.color.syc_FF3F4F);
        } else if (this.f20111a == 2) {
            ShapeHelper.b(shapeView2, (int) R.color.syc_B2D4FF);
            ShapeHelper.d(shapeView2, (int) R.color.syc_B2D4FF);
        } else {
            ShapeHelper.b(shapeView2, (int) R.color.syc_FFE9D3);
            ShapeHelper.d(shapeView2, (int) R.color.syc_FFE9D3);
        }
        baseViewHolder.setText(R.id.tv_amount, Intrinsics.a("", Integer.valueOf((int) optionList.money)));
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_amount_per_month);
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        String a2 = Intrinsics.a("", Integer.valueOf((int) optionList.original_money));
        baseViewHolder.setText(R.id.tv_amount_per_month, BlueAppLocal.a().equals("en") ? Intrinsics.a("￥", a2) : Intrinsics.a(a2, "元"));
        ShapeTextView view2 = baseViewHolder.getView(R.id.tv_tag);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.K = DensityUtils.a(this.mContext, 12.0f);
        shapeModel.L = DensityUtils.a(this.mContext, 12.0f);
        shapeModel.b = BluedSkinUtils.a(this.mContext, 2131102170);
        if (this.f20111a == 2) {
            if (optionList.choosen) {
                shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_FF3F4F);
            } else {
                shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_8CB6EB);
            }
        } else if (optionList.choosen) {
            shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_FF3F4F);
        } else {
            shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_F3C291);
        }
        view2.setShapeModel(shapeModel);
        if (TextUtils.isEmpty(optionList.item.tag_bottom)) {
            view2.setVisibility(4);
            return;
        }
        view2.setVisibility(0);
        view2.setText(optionList.item.tag_bottom);
    }
}
