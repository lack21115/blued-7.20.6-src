package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveDesireSelectGiftModel;
import java.text.DecimalFormat;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemDesireSelectGift.class */
public class FitemDesireSelectGift extends FreedomItem {
    public LiveDesireSelectGiftModel b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12531c = false;
    public View d;

    public FitemDesireSelectGift(LiveDesireSelectGiftModel liveDesireSelectGiftModel) {
        this.b = liveDesireSelectGiftModel;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.item_live_desire_select_gift;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        baseViewHolder.a(R.id.live_gift, this.b.images_static).a(R.id.tv_gift_name, (CharSequence) this.b.name).a(R.id.tv_price, (CharSequence) new DecimalFormat("#,###").format(Float.parseFloat(String.valueOf(this.b.beans))));
        View a2 = baseViewHolder.a(R.id.view_border);
        if (a2.animate() != null) {
            a2.animate().cancel();
        }
        if (this.f12531c) {
            a2.setScaleX(1.0f);
            a2.setScaleY(1.0f);
            a2.setAlpha(1.0f);
        } else {
            a2.setScaleX(0.8f);
            a2.setScaleY(0.8f);
            a2.setAlpha(0.0f);
        }
        this.d = a2;
    }

    public void a(boolean z) {
        this.f12531c = z;
        View view = this.d;
        if (view == null) {
            return;
        }
        if (z && view.getAlpha() != 1.0f) {
            this.d.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(70L);
        } else if (z || this.d.getAlpha() == 0.0f) {
        } else {
            this.d.animate().alpha(0.0f).scaleX(0.9f).scaleY(0.9f).setDuration(70L);
        }
    }
}
