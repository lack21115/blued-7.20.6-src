package com.soft.blued.ui.user.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VipUpgradeOptionAdapter.class */
public final class VipUpgradeOptionAdapter extends BaseQuickAdapter<VipUpgradeModel, BaseViewHolder> {
    public VipUpgradeOptionAdapter() {
        super((int) R.layout.vip_upgrade_option);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VipUpgradeModel vipUpgradeModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(vipUpgradeModel, "item");
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R.id.item_view);
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.width = (AppInfo.l - DensityUtil.a(28.0f)) / 3;
        constraintLayout.setLayoutParams(layoutParams);
        ShapeLinearLayout view = baseViewHolder.getView(R.id.ll_item);
        ShapeModel shapeModel = view.getShapeModel();
        if (vipUpgradeModel.choose) {
            shapeModel.n = BluedSkinUtils.a(this.mContext, 2131101766);
        } else {
            shapeModel.n = BluedSkinUtils.a(this.mContext, (int) R.color.syc_D1E1FF);
        }
        view.setShapeModel(shapeModel);
        baseViewHolder.setText(R.id.tv_tag, vipUpgradeModel.market);
        baseViewHolder.setText(2131372754, vipUpgradeModel.product_name);
        baseViewHolder.setText(R.id.tv_price, String.valueOf(vipUpgradeModel.money));
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_original_price);
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = this.mContext.getString(R.string.vip_upgrade_rmb);
        Intrinsics.c(string, "mContext.getString(R.string.vip_upgrade_rmb)");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(vipUpgradeModel.original_money)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        textView.setPaintFlags(textView.getPaintFlags() | 16);
    }
}
