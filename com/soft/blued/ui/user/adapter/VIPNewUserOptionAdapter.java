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
    private final int f33802a;

    public VIPNewUserOptionAdapter(int i) {
        super((int) R.layout.vip_center_new_user_option_item);
        this.f33802a = i;
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
    public void convert(BaseViewHolder helper, VIPCenterNewModel.OptionList data) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(data, "data");
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) helper.getView(2131364999);
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(R.id.tv_choosen_tag);
        if (helper.getAdapterPosition() == 0) {
            ViewGroup.LayoutParams layoutParams = shapeLinearLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            ((LinearLayout.LayoutParams) layoutParams).setMarginStart(DensityUtils.a(this.mContext, 10.0f));
        }
        if (helper.getPosition() == 0) {
            data.item.tag_up = "最优惠";
        }
        if (TextUtils.isEmpty(data.item.tag_up)) {
            shapeTextView.setVisibility(4);
        } else {
            shapeTextView.setText(data.item.tag_up);
            shapeTextView.setVisibility(0);
        }
        helper.setText(2131372046, data.item.name);
        ShapeLinearLayout shapeLinearLayout2 = shapeLinearLayout;
        ShapeHelper.a(shapeLinearLayout2, DensityUtils.a(this.mContext, 2.0f), 0.0f, 0.0f);
        if (data.choosen) {
            ShapeHelper.b(shapeLinearLayout2, 2131102170);
            ShapeHelper.d(shapeLinearLayout2, R.color.syc_FF3F4F);
        } else if (this.f33802a == 2) {
            ShapeHelper.b(shapeLinearLayout2, R.color.syc_B2D4FF);
            ShapeHelper.d(shapeLinearLayout2, R.color.syc_B2D4FF);
        } else {
            ShapeHelper.b(shapeLinearLayout2, R.color.syc_FFE9D3);
            ShapeHelper.d(shapeLinearLayout2, R.color.syc_FFE9D3);
        }
        helper.setText(R.id.tv_amount, Intrinsics.a("", (Object) Integer.valueOf((int) data.money)));
        TextView textView = (TextView) helper.getView(R.id.tv_amount_per_month);
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        String a2 = Intrinsics.a("", (Object) Integer.valueOf((int) data.original_money));
        helper.setText(R.id.tv_amount_per_month, BlueAppLocal.a().equals("en") ? Intrinsics.a("￥", (Object) a2) : Intrinsics.a(a2, (Object) "元"));
        ShapeTextView shapeTextView2 = (ShapeTextView) helper.getView(2131372678);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.K = DensityUtils.a(this.mContext, 12.0f);
        shapeModel.L = DensityUtils.a(this.mContext, 12.0f);
        shapeModel.b = BluedSkinUtils.a(this.mContext, 2131102170);
        if (this.f33802a == 2) {
            if (data.choosen) {
                shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_FF3F4F);
            } else {
                shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_8CB6EB);
            }
        } else if (data.choosen) {
            shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_FF3F4F);
        } else {
            shapeModel.k = BluedSkinUtils.a(this.mContext, (int) R.color.syc_F3C291);
        }
        shapeTextView2.setShapeModel(shapeModel);
        if (TextUtils.isEmpty(data.item.tag_bottom)) {
            shapeTextView2.setVisibility(4);
            return;
        }
        shapeTextView2.setVisibility(0);
        shapeTextView2.setText(data.item.tag_bottom);
    }
}
