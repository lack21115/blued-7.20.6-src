package com.blued.android.module.live_china.fitem;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.PlanetGiveNumModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemPlanetGiftNum.class */
public final class FitemPlanetGiftNum extends FreedomItem {
    private final Fragment b;

    /* renamed from: c  reason: collision with root package name */
    private final PlanetGiveNumModel f12541c;

    public FitemPlanetGiftNum(Fragment fragment, PlanetGiveNumModel model) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(model, "model");
        this.b = fragment;
        this.f12541c = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_planet_gift_num;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        boolean z = true;
        BaseViewHolder a2 = vh.a(R.id.tv_num, (CharSequence) String.valueOf(this.f12541c.getCount())).a(R.id.tv_num, true).a(R.id.tv_desc, (CharSequence) this.f12541c.getText()).a(R.id.tv_desc, true);
        int i2 = R.id.tv_num;
        if (this.f12541c.getCount() <= 0) {
            z = false;
        }
        a2.b(i2, z).a(vh.itemView, this.f12541c.getCount() > 0 ? R.color.transparent : R.color.trans_black_nine);
    }
}
