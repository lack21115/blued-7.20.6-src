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

    /* renamed from: c  reason: collision with root package name */
    private boolean f12540c;

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
        BaseViewHolder a2 = vh.a(R.id.iv_gift, this.b.getGoods_image()).a(R.id.tv_name, (CharSequence) this.b.getGoods_name());
        int i2 = R.id.tv_price;
        String format = String.format("%,d", Arrays.copyOf(new Object[]{Long.valueOf(this.b.getGoods_beans())}, 1));
        Intrinsics.c(format, "format(this, *args)");
        a2.a(i2, (CharSequence) format).a(R.id.tv_probability, (CharSequence) this.b.getRate());
        View a3 = vh.a(R.id.ll_bg);
        Intrinsics.c(a3, "vh.getView(R.id.ll_bg)");
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) a3;
        shapeLinearLayout.getShapeModel().k = BluedSkinUtils.a(context, R.color.white);
        if (this.f12540c) {
            float a4 = DensityUtils.a(context, 12.0f);
            shapeLinearLayout.getShapeModel().K = a4;
            shapeLinearLayout.getShapeModel().L = a4;
        } else {
            shapeLinearLayout.getShapeModel().K = 0.0f;
            shapeLinearLayout.getShapeModel().L = 0.0f;
        }
        shapeLinearLayout.setShapeModel(shapeLinearLayout.getShapeModel());
    }

    public final void a(boolean z) {
        this.f12540c = z;
    }
}
