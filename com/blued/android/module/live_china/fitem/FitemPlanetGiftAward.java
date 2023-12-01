package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.PlanetGiftModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemPlanetGiftAward.class */
public final class FitemPlanetGiftAward extends FreedomItem {
    private final PlanetGiftModel b;

    public FitemPlanetGiftAward(PlanetGiftModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_planet_gift_award;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        vh.a(R.id.iv_gift, this.b.getImage()).a(R.id.tv_count, (CharSequence) Intrinsics.a("x", (Object) Integer.valueOf(this.b.getCount()))).a(R.id.tv_count, true).b(R.id.tv_count, this.b.getCount() > 1).a(R.id.tv_name, (CharSequence) this.b.getName()).a(R.id.tv_name, true);
        ImageLoader.c(vh.b, "live_planet_gift_backgroup.png").g().g(-1).a((ImageView) vh.a(R.id.iv_gift_border));
    }
}
