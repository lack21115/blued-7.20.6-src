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
    public void convert(BaseViewHolder helper, VipUpgradeModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ConstraintLayout constraintLayout = (ConstraintLayout) helper.getView(2131364999);
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        layoutParams.width = (AppInfo.l - DensityUtil.a(28.0f)) / 3;
        constraintLayout.setLayoutParams(layoutParams);
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) helper.getView(R.id.ll_item);
        ShapeModel shapeModel = shapeLinearLayout.getShapeModel();
        if (item.choose) {
            shapeModel.n = BluedSkinUtils.a(this.mContext, 2131101766);
        } else {
            shapeModel.n = BluedSkinUtils.a(this.mContext, (int) R.color.syc_D1E1FF);
        }
        shapeLinearLayout.setShapeModel(shapeModel);
        helper.setText(2131372678, item.market);
        helper.setText(2131372754, item.product_name);
        helper.setText(2131372285, String.valueOf(item.money));
        TextView textView = (TextView) helper.getView(R.id.tv_original_price);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = this.mContext.getString(R.string.vip_upgrade_rmb);
        Intrinsics.c(string, "mContext.getString(R.string.vip_upgrade_rmb)");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(item.original_money)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        textView.setPaintFlags(textView.getPaintFlags() | 16);
    }
}
