package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LuckyBagRewardModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemLuckyBagTable.class */
public final class FitemLuckyBagTable extends FreedomItem {
    private final LuckyBagRewardModel b;
    private boolean c;

    public FitemLuckyBagTable(LuckyBagRewardModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_lucky_bag_table;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        BaseViewHolder a = vh.a(R.id.iv_gift, this.b.getGoods_image()).a(R.id.tv_name, (CharSequence) this.b.getGoods_name());
        int i2 = R.id.tv_price;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Long.valueOf(this.b.getGoods_beans())}, 1));
        Intrinsics.c(format, "format(this, *args)");
        a.a(i2, (CharSequence) format).a(R.id.tv_probability, (CharSequence) this.b.getRate());
        View a2 = vh.a(R.id.ll_bg);
        Intrinsics.c(a2, "vh.getView(R.id.ll_bg)");
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) a2;
        shapeLinearLayout.getShapeModel().k = BluedSkinUtils.a(context, R.color.white);
        if (this.c) {
            float a3 = DensityUtils.a(context, 12.0f);
            shapeLinearLayout.getShapeModel().K = a3;
            shapeLinearLayout.getShapeModel().L = a3;
        } else {
            shapeLinearLayout.getShapeModel().K = 0.0f;
            shapeLinearLayout.getShapeModel().L = 0.0f;
        }
        shapeLinearLayout.setShapeModel(shapeLinearLayout.getShapeModel());
    }

    public final void a(boolean z) {
        this.c = z;
    }
}
