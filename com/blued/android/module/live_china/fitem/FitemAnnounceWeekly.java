package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemAnnounceWeekly.class */
public class FitemAnnounceWeekly extends FreedomItem {
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12522c;
    public View d;

    public FitemAnnounceWeekly(String str, boolean z) {
        this.f12522c = false;
        this.b = str;
        this.f12522c = z;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_announce_weekly;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        baseViewHolder.a(R.id.tv_text, (CharSequence) this.b).a(R.id.tv_text_select, (CharSequence) this.b);
        View a2 = baseViewHolder.a(R.id.tv_text_select);
        if (a2.animate() != null) {
            a2.animate().cancel();
        }
        if (this.f12522c) {
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
        this.f12522c = z;
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

    public boolean e() {
        return this.f12522c;
    }
}
